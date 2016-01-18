package br.com.spinapp.domain;

import java.util.Date;

public class Assinatura {

	// Atributos
	private Long idassina;
	private Date datain;
	private Date dataout;
	private Plano plano_idplano = new Plano();
	private Cliente cliente_idcliente = new Cliente();

	// Getters e Setters

	public Long getIdassina() {
		return idassina;
	}

	public void setIdassina(Long idassina) {
		this.idassina = idassina;
	}

	public Date getDatain() {
		return datain;
	}

	public void setDatain(Date datain) {
		this.datain = datain;
	}

	public Date getDataout() {
		return dataout;
	}

	public void setDataout(Date dataout) {
		this.dataout = dataout;
	}

	public Plano getPlano_idplano() {
		return plano_idplano;
	}

	public void setPlano_idplano(Plano plano_idplano) {
		this.plano_idplano = plano_idplano;
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
		String saida = idassina+", "+datain+", "+dataout+", "+plano_idplano+", "+cliente_idcliente+".";
		return saida;
	}
	
}
