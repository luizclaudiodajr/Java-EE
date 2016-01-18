package br.com.spinapp.domain;

import java.util.List;


public class Cliente {

	// Atributos
	private Long idcliente;
	private String nome;
	private String celular;
	private String endereco;
	private String cpf;
	private String rg;
	private String email;
	private String senha;
	private String cnpj;
	
	
	private List<Serverpin> serverpins;
	private List<Plantacao> platacoes;
	private List<Funcionario> funcionarios;
	
	
	
	// Getters e Setters
	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	

	public List<Serverpin> getServerpins() {
		return serverpins;
	}

	public void setServerpins(List<Serverpin> serverpins) {
		this.serverpins = serverpins;
	}

	public List<Plantacao> getPlatacoes() {
		return platacoes;
	}

	public void setPlatacoes(List<Plantacao> platacoes) {
		this.platacoes = platacoes;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	// ToString
	@Override
	public String toString() {
		String saida = idcliente + ", " + nome + ", " + celular + ", "+ endereco + ", " + cpf + ", " + rg + ", " + email + ", "+ senha + ", " + cnpj + ", " + serverpins + ", "+platacoes+ ", " + funcionarios + ".";
		return saida;
	}

	// operation

}
