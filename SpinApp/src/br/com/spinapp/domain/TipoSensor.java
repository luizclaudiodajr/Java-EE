package br.com.spinapp.domain;

public class TipoSensor {
	
	// Atributos
	private Long idtipo;
	private String descricao;
	private String unidade;
	
	// Getters e Setters
	public Long getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(Long idtipo) {
		this.idtipo = idtipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	
	// ToString
	@Override
	public String toString() {
		String saida = +idtipo+ ", " +descricao+ ", " +unidade+ "." ;
		return saida;
	}
	
}
