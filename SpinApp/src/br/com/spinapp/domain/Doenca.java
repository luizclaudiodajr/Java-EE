package br.com.spinapp.domain;

import java.util.List;

public class Doenca {
	
	private Long iddoenca;
	private String nome;
	private String reino;
	private float tb;
	private float tc;
	private List<Planta> plantas;
	
	// Getters e Setters
	public Long getIddoenca() {
		return iddoenca;
	}
	public void setIddoenca(Long iddoenca) {
		this.iddoenca = iddoenca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getReino() {
		return reino;
	}
	public void setReino(String reino) {
		this.reino = reino;
	}
	public float getTb() {
		return tb;
	}
	public void setTb(float tb) {
		this.tb = tb;
	}
	public float getTc() {
		return tc;
	}
	public void setTc(float tc) {
		this.tc = tc;
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
		String saida = iddoenca+", "+nome+", "+reino+","+tb+", "+tc+ ", " +plantas+ ".";
		return saida;
	}
	
}
