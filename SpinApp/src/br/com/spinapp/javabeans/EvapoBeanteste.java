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

import br.com.spinapp.calculos.EvapotranspiracaoPenmanMonteith;
import br.com.spinapp.dao.CalculosDAO;
import br.com.spinapp.domain.Historico;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.domain.TipoSensor;

@ManagedBean(name="Evapotranspiracao")
public class EvapoBeanteste {
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
	lineModel.setTitle("Evapotranspiração");
	lineModel.setLegendPosition("e");
	lineModel.setShowPointLabels(true);
	lineModel.getAxes().put(AxisType.X, new CategoryAxis("Tempo h"));
	Axis yAxis = lineModel.getAxis(AxisType.Y);
	yAxis.setLabel("Km/h");
	yAxis.setMin(-50);
	yAxis.setMax(101);
    }

    private LineChartModel initCategoryModel() {
	LineChartModel model = new LineChartModel();

	ChartSeries leituras = new ChartSeries();

	CalculosDAO dao = new CalculosDAO();
	EvapotranspiracaoPenmanMonteith ev = new EvapotranspiracaoPenmanMonteith();
	List<Historico> itens = new ArrayList<Historico>();

	Historico hiTemp = new Historico();
	Sensor sTemp = new Sensor();
	TipoSensor tp = new TipoSensor();
	tp.setIdtipo(1L);
	sTemp.setTiposensor_idtipo(tp);
	hiTemp.setSensor_idsensor(sTemp);
	
	Historico hiUmi = new Historico();
	Sensor sUmi = new Sensor();
	tp.setIdtipo(1L);
	sUmi.setTiposensor_idtipo(tp);
	hiUmi.setSensor_idsensor(sUmi);
	
	Historico hiPres = new Historico();
	Sensor sPres = new Sensor();
	tp.setIdtipo(1L);
	sPres.setTiposensor_idtipo(tp);
	hiPres.setSensor_idsensor(sPres);
	
	Historico hiVent = new Historico();
	Sensor sVent = new Sensor();
	tp.setIdtipo(1L);
	sVent.setTiposensor_idtipo(tp);
	hiVent.setSensor_idsensor(sVent);
	
	
	
	
	try {
	    itens = dao.listarDatas(hiTemp);
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	leituras.setLabel("mm");
	for (Historico historico : itens) {
	    
	    hiTemp.setData(historico.getData());
	    hiUmi.setData(historico.getData());
	    hiPres.setData(historico.getData());
	    hiVent.setData(historico.getData());
	    SimpleDateFormat brasil = new SimpleDateFormat("HH:mm:ss");
	    String x = brasil.format(historico.getData());
	    float t=0;
	    try {
		t = dao.media(hiTemp);
	    } catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	    }
	    int dia= historico.getData().getDay();
	    int mes=historico.getData().getMonth();
	    int ano=historico.getData().getYear();
	    float krs=(float) 0.16;
	    float tmax=0;
	    try {
		tmax = dao.maxima(hiTemp);
	    } catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	    }
	    float tmin=0;
	    try {
		tmin = dao.minino(hiTemp);
	    } catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    float latitude=20;
	    float longitude=25;
	    int hemi=-1;
	    float z=335;
	    float ur=0;
	    try {
		ur = dao.media(hiUmi);
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    float g=0;
	    float patm=0;
	    try {
		patm = dao.media(hiPres)/1000;
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    float u2=0;
	    try {
		u2 = dao.media(hiVent);
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    
	    
	    Float y = ev.calcularEvapotranspiracao(t, dia, mes, ano, krs, tmax, tmin, latitude, longitude, hemi, z, ur, g, patm, u2);

	    leituras.set(x, y);
	}

	model.addSeries(leituras);

	return model;
    }
}
