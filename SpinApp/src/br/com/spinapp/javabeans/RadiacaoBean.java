package br.com.spinapp.javabeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

@ManagedBean(name = "MBRadiacaoBean")
public class RadiacaoBean {

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
	lineModel.setTitle("Radiação");
	lineModel.setLegendPosition("e");
	lineModel.setShowPointLabels(true);
	lineModel.getAxes().put(AxisType.X, new CategoryAxis("Tempo h"));
	Axis yAxis = lineModel.getAxis(AxisType.Y);
	yAxis.setLabel("kWh/m²");
	yAxis.setMin(0);
	yAxis.setMax(7);
    }

    private LineChartModel initCategoryModel() {
	LineChartModel model = new LineChartModel();

	ChartSeries leituras = new ChartSeries();

	leituras.set("24/10/2014", 5.6);
	leituras.set("26/10/2014", 4.0);
	leituras.set("27/10/2014", 5.2);
	leituras.set("28/10/2014", 5.5);
	leituras.set("29/10/2014", 4.3);
	leituras.set("30/10/2014", 4.0);

	leituras.setLabel("Radiação");
	
	model.addSeries(leituras);

	return model;
    }
}
