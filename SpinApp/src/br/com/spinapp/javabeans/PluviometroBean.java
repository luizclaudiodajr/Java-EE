package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import br.com.spinapp.dao.HistoricoDAO;
import br.com.spinapp.domain.Historico;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.domain.TipoSensor;

@ManagedBean(name = "MBPluviometro")
public class PluviometroBean {

    private LineChartModel lineModel;

    @PostConstruct
    public void init() {
	createLineModels();
    }

    public LineChartModel getLineModel() {
	return lineModel;
    }

    private void createLineModels() {

	lineModel = initCategoryModel();
	lineModel.setTitle("Pluviometro");
	lineModel.setLegendPosition("e");
	lineModel.setShowPointLabels(true);
	lineModel.getAxes().put(AxisType.X, new CategoryAxis("Tempo h"));
	Axis yAxis = lineModel.getAxis(AxisType.Y);
	yAxis.setLabel("mm");
	yAxis.setMin(0);
	yAxis.setMax(0.1);
    }

    private LineChartModel initCategoryModel() {
	LineChartModel model = new LineChartModel();

	ChartSeries leituras = new ChartSeries();

	HistoricoDAO dao = new HistoricoDAO();

	List<Historico> itens = new ArrayList<Historico>();

	Historico hi = new Historico();
	Sensor s = new Sensor();
	TipoSensor tp = new TipoSensor();

	tp.setIdtipo(5L);
	s.setTiposensor_idtipo(tp);
	hi.setSensor_idsensor(s);

	try {
	    itens = dao.listarTipoSensor(hi);
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	leituras.setLabel("Pluviometro");
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
