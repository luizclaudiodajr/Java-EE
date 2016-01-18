package br.com.spinapp.domain;

import java.util.List;

public class Equipamento {

	// Atributos
	private Long idequip;
	private String mac;
	private Float latitude;
	private Float longitude;
	private Float altitude;
	private Serverpin serverpin_idserver = new Serverpin();
	private Modelo modelo_idmodelo= new Modelo();
	
	private List<Sensor> sensores;

	// Getters e Setters
	public Long getIdequip() {
		return idequip;
	}

	public void setIdequip(Long idequip) {
		this.idequip = idequip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getAltitude() {
		return altitude;
	}

	public void setAltitude(Float altitude) {
		this.altitude = altitude;
	}

	public Serverpin getServerpin_idserver() {
		return serverpin_idserver;
	}

	public void setServerpin_idserver(Serverpin serverpin_idserver) {
		this.serverpin_idserver = serverpin_idserver;
	}

	public Modelo getModelo_idmodelo() {
		return modelo_idmodelo;
	}

	public void setModelo_idmodelo(Modelo modelo_idmodelo) {
		this.modelo_idmodelo = modelo_idmodelo;
	}

	public List<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(List<Sensor> sensores) {
		this.sensores = sensores;
	}

	// ToString
	@Override
	public String toString() {
		String saida = idequip + ", " + latitude + ", " + longitude + ", "+ altitude + ", "+serverpin_idserver + ", "+ modelo_idmodelo + ".";
		return saida;
	}

}
