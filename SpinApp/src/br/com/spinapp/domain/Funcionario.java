package br.com.spinapp.domain;

public class Funcionario {

	// Atributos
	private Long idfuncionario;
	private String nome;
	private String email;
	private String celular;
	private String senha;
	private Cliente cliente_idcliente = new Cliente();

	
	

	//Getters e Setters
	public Long getIdfuncionario() {
		return idfuncionario;
	}

	public void setIdfuncionario(Long idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cliente getCliente_idcliente() {
		return cliente_idcliente;
	}

	public void setCliente_idcliente(Cliente cliente_idcliente) {
		this.cliente_idcliente = cliente_idcliente;
	}

	// ToString
	@Override
	public String toString() {
		String saida = idfuncionario + ", " + nome + ", " + email + ", "+ celular + ", " + senha + ", " + cliente_idcliente + ".";
		return saida;
	}
}
