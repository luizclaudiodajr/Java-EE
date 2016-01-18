package br.com.spinapp.domain;

import java.util.Date;


public class Historico {

	// Atributos
	private Long idhistorico;
	private Date data;
	private Date hora;
	private float valor;
	private Sensor sensor_idsensor = new Sensor();

	// Getters e Setters
	public Long getIdhistorico() {
		return idhistorico;
	}

	public void setIdhistorico(Long idhistorico) {
		this.idhistorico = idhistorico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Sensor getSensor_idsensor() {
		return sensor_idsensor;
	}

	public void setSensor_idsensor(Sensor sensor_idsensor) {
		this.sensor_idsensor = sensor_idsensor;
	}

	
	// ToString
	@Override
	public String toString() {
		String saida = idhistorico+ ", " +data+ ", " +hora+ ", " +valor+ ", " +sensor_idsensor+ ".";
		return saida;
	}
}
