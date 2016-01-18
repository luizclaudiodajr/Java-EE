package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.EquipamentoDAO;
import br.com.spinapp.dao.ModeloDAO;
import br.com.spinapp.dao.ServerpinDAO;
import br.com.spinapp.domain.Equipamento;
import br.com.spinapp.domain.Modelo;
import br.com.spinapp.domain.Serverpin;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBEquipamento")
// nome do bean para a tela
@ViewScoped
public class EquipamentoBean {

	// Atributos
	private Equipamento equipamento;// variavel para CRUD dados na DAO
	private ArrayList<Serverpin> comboServerpin;
	private ArrayList<Modelo> comboModelo;
	private ArrayList<Equipamento> itens;
	private ArrayList<Equipamento> itensFiltrados;

	// metodos
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public ArrayList<Serverpin> getComboServerpin() {
		return comboServerpin;
	}

	public void setComboServerpin(ArrayList<Serverpin> comboServerpin) {
		this.comboServerpin = comboServerpin;
	}

	public ArrayList<Modelo> getComboModelo() {
		return comboModelo;
	}

	public void setComboModelo(ArrayList<Modelo> comboModelo) {
		this.comboModelo = comboModelo;
	}

	public ArrayList<Equipamento> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Equipamento> itens) {
		this.itens = itens;
	}

	public ArrayList<Equipamento> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Equipamento> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			EquipamentoDAO dao = new EquipamentoDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {

		try {
			equipamento = new Equipamento();// instanciar novo cliente para
											// inserir

			ServerpinDAO dao1 = new ServerpinDAO();
			comboServerpin = dao1.listar();

			ModeloDAO dao2 = new ModeloDAO();
			comboModelo = dao2.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void novo() {

		try {
			EquipamentoDAO dao = new EquipamentoDAO();
			dao.inserir(equipamento);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			EquipamentoDAO dao = new EquipamentoDAO();
			dao.excluir(equipamento);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void prepararEditar() {

		try {

			ServerpinDAO dao1 = new ServerpinDAO();
			comboServerpin = dao1.listar();

			ModeloDAO dao2 = new ModeloDAO();
			comboModelo = dao2.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			EquipamentoDAO dao = new EquipamentoDAO();
			dao.atualizar(equipamento);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}