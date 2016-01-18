package br.com.spinapp.domain;


public class Plano {

	// Atributos
	private Long idplano;
	private String tipo;
	private float preco;
	private String duracao;
	private String descricao;


	// Getters e Setters
	public Long getIdplano() {
		return idplano;
	}

	public void setIdplano(Long idplano) {
		this.idplano = idplano;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	// ToString
	@Override
	public String toString() {
		String saida = idplano+", "+tipo+", "+preco+", "+duracao+", "+descricao+".";
		return saida;
	}

}
