package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;

import br.com.spinapp.dao.HistoricoDAO;
import br.com.spinapp.domain.Historico;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.domain.TipoSensor;

@ManagedBean(name = "MBUmidadeAr")
public class UmidadeArBean {

    private BarChartModel barModel;

    @PostConstruct
    public void init() {
	createBarModels();
    }

    public BarChartModel getBarModel() {
	return barModel;
    }

    private void createBarModels() {

	barModel = initCategoryModel();
	barModel.setTitle("Umidade do Ar");
	barModel.setLegendPosition("e");
	barModel.setShowPointLabels(true);
	barModel.getAxes().put(AxisType.X, new CategoryAxis("Tempo h"));
	Axis yAxis = barModel.getAxis(AxisType.Y);
	yAxis.setLabel("%");
	yAxis.setMin(0);
	yAxis.setMax(40);
    }

    private BarChartModel initCategoryModel() {
	BarChartModel model = new BarChartModel();

	ChartSeries leituras = new ChartSeries();

	HistoricoDAO dao = new HistoricoDAO();

	List<Historico> itens = new ArrayList<Historico>();

	Historico hi = new Historico();
	Sensor s = new Sensor();
	TipoSensor tp = new TipoSensor();

	tp.setIdtipo(8L);
	s.setTiposensor_idtipo(tp);
	hi.setSensor_idsensor(s);

	try {
	    itens = dao.listarTipoSensor(hi);
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	leituras.setLabel("Umidade Ar");
	for (Historico historico : itens) {

	    SimpleDateFormat brasil = new SimpleDateFormat("HH");

	    String x = brasil.format(historico.getHora());
	    Float y = historico.getValor();

	    leituras.set(x, y);
	}

	model.addSeries(leituras);

	return model;
    }

}
