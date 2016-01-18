package br.com.spinapp.domain;

import java.util.List;

public class Praga {
	
	// Atributos
	private Long idpraga;
	private String nome;
	private float tb;
	private float ct;
	
	private List<Planta> plantas;
	
	// Getters e Setters
	public Long getIdpraga() {
		return idpraga;
	}
	public void setIdpraga(Long idpraga) {
		this.idpraga = idpraga;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getTb() {
		return tb;
	}
	public void setTb(float tb) {
		this.tb = tb;
	}
	
	public float getCt() {
		return ct;
	}
	public void setCt(float ct) {
		this.ct = ct;
	}
	public List<Planta> getPlantas() {
		return plantas;
	}
	public void setPlantas(List<Planta> plantas) {
		this.plantas = plantas;
	}
	
	
	// ToString
	@Override
	public String toString() {
		String saida = idpraga+ ", " +nome+ ", " +tb+ ", " +ct+ ", " +plantas+ ".";
		return saida;
	}

}
