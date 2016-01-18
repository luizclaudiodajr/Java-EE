package br.com.spinapp.domain;

import java.util.List;

public class Sensor {

	// Atributos
	private Long idsensor;
	private Equipamento equipamento_idequip = new Equipamento();
	private TipoSensor tiposensor_idtipo = new TipoSensor();
	
	
	private List<Leitura> leituras;
	private List<Historico> historicos;

	// Getters e Setters
	public Long getIdsensor() {
		return idsensor;
	}

	public void setIdsensor(Long idsensor) {
		this.idsensor = idsensor;
	}

	public Equipamento getEquipamento_idequip() {
		return equipamento_idequip;
	}

	public void setEquipamento_idequip(Equipamento equipamento_idequip) {
		this.equipamento_idequip = equipamento_idequip;
	}

	public TipoSensor getTiposensor_idtipo() {
		return tiposensor_idtipo;
	}

	public void setTiposensor_idtipo(TipoSensor tiposensor_idtipo) {
		this.tiposensor_idtipo = tiposensor_idtipo;
	}

	public List<Leitura> getLeituras() {
		return leituras;
	}

	public void setLeituras(List<Leitura> leituras) {
		this.leituras = leituras;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	// ToString
	@Override
	public String toString() {
		String saida = idsensor+ ", " +equipamento_idequip+ "." +tiposensor_idtipo+ ", " +leituras+ "," +historicos+ ".";
		return saida;
	}

}
