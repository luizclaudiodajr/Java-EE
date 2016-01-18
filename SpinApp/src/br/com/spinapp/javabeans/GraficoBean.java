package br.com.spinapp.javabeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean(name = "MBGrafico")
// nome do bean para a tela
@ViewScoped
public class GraficoBean{

	private CartesianChartModel model;

	
	public GraficoBean() {
		ChartBean();
	}

	public void ChartBean() {

		model = new CartesianChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");

		boys.set("2004", 120);
		boys.set("2005", 100);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");

		girls.set("2004", 52);
		girls.set("2005", 60);

		model.addSeries(boys);
		model.addSeries(girls);
	}

	public CartesianChartModel getModel() {
		return model;
	}

}
