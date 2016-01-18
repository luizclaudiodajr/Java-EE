package br.com.spinapp.domain;

import java.util.List;

public class Planta {

	// Atributos
	private Long idplanta;
	private String nome;
	private float tmin;
	private float tmax;
	private float tot;
	private float ic;
	private float uc;
	
	private List<Doenca> doencas;
	private List<Praga> pragas;
	
	
	// Getters e Setters	
	public Long getIdplanta() {
		return idplanta;
	}

	public void setIdplanta(Long idplanta) {
		this.idplanta = idplanta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getTmin() {
		return tmin;
	}

	public void setTmin(float tmin) {
		this.tmin = tmin;
	}

	public float getTmax() {
		return tmax;
	}

	public void setTmax(float tmax) {
		this.tmax = tmax;
	}

	public float getTot() {
		return tot;
	}

	public void setTot(float tot) {
		this.tot = tot;
	}

	public float getIc() {
		return ic;
	}

	public void setIc(float ic) {
		this.ic = ic;
	}

	public float getUc() {
		return uc;
	}

	public void setUc(float uc) {
		this.uc = uc;
	}

	public List<Doenca> getDoencas() {
		return doencas;
	}

	public void setDoencas(List<Doenca> doencas) {
		this.doencas = doencas;
	}

	public List<Praga> getPragas() {
		return pragas;
	}

	public void setPragas(List<Praga> pragas) {
		this.pragas = pragas;
	}


	// ToString
	@Override
	public String toString() {
		String saida = idplanta+ ", " +nome+ ", " +tmin+ ", " +tmax+ ", " +tot +", " +ic+ ", " +uc+ ", " +doencas+ ", " +pragas+ ".";
		return saida;
	}
}
