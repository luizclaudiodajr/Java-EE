package br.com.spinapp.domain;

import java.util.Date;

public class Plantacao {
	
	//atributos
	private Long idplantacao;
	private Date data_plantio;
	private Float area;
	private Planta planta_idplanta = new Planta();
	private Cliente cliente_idcliente = new Cliente();
	
	// Getters e Setters
	public Long getIdplantacao() {
		return idplantacao;
	}
	public void setIdplantacao(Long idplantacao) {
		this.idplantacao = idplantacao;
	}
	public Date getData_plantio() {
		return data_plantio;
	}
	public void setData_plantio(Date data_plantio) {
		this.data_plantio = data_plantio;
	}
	public Float getArea() {
		return area;
	}
	public void setArea(Float area) {
		this.area = area;
	}
	public Planta getPlanta_idplanta() {
		return planta_idplanta;
	}
	public void setPlanta_idplanta(Planta planta_idplanta) {
		this.planta_idplanta = planta_idplanta;
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
		
		String saida = idplantacao+ ", " +data_plantio+ ", " +area+ ", " +planta_idplanta+ ", " +cliente_idcliente+ ".";
		return saida;
		
	}
	

}
