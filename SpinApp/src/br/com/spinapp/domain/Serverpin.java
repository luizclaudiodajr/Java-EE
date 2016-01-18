package br.com.spinapp.domain;

import java.util.List;

public class Serverpin {

	// Atributos
	private Long idserver;
	private String ip;
	private String mac;
	private int porta;
	private float latitude;
	private float longitude;
	private float altitude;
	private String gsm;
	private Cliente cliente_idcliente = new Cliente();
	
	private List<Equipamento> equipamentos;

	// Getters e Setters
	public Long getIdserver() {
		return idserver;
	}

	public void setIdserver(Long idserver) {
		this.idserver = idserver;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getAltitude() {
		return altitude;
	}

	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}

	public String getGsm() {
		return gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public Cliente getCliente_idcliente() {
		return cliente_idcliente;
	}

	public void setCliente_idcliente(Cliente cliente_idcliente) {
		this.cliente_idcliente = cliente_idcliente;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	// ToString
	@Override
	public String toString() {
		String saida = idserver+ ", " +ip+ ", " +mac+ ", " +porta+ ", "+latitude+ ", " +longitude+ ", " +altitude+ ", "+gsm+ ", " +cliente_idcliente+ ", " +equipamentos+ ".";
		return saida;
	}

}
