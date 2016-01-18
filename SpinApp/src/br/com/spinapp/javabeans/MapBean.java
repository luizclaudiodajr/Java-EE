package br.com.spinapp.javabeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
// nome do bean para a tela
@ViewScoped
public class MapBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MapModel simpleModel;

	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel();

		// Shared coordinates
		LatLng coord1 = new LatLng(-22.256622, -45.694294);

		// Basic marker
		simpleModel.addOverlay(new Marker(coord1, "Inatel"));
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}
}