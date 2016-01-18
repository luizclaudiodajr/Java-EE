package br.com.spinapp.domain;

import java.util.List;

public class Modelo {
	
	// Atributos
	private Long idmodelo;
	private String descricao;
	
	private List<Equipamento> equipamentos;
	
	
	// Getters e Setters
	public Long getIdmodelo() {
		return idmodelo;
	}
	public void setIdmodelo(Long idmodelo) {
		this.idmodelo = idmodelo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		String saida = idmodelo+ ", " +descricao+ "," +equipamentos+ ".";
		return saida;
	}
	

}
