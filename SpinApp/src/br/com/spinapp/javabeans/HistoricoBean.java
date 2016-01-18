package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.HistoricoDAO;
import br.com.spinapp.dao.SensorDAO;
import br.com.spinapp.domain.Historico;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBHistorico")
// nome do bean para a tela
@ViewScoped
public class HistoricoBean {

	// Atributos
	private Historico historico;// variavel para CRUD dados na DAO
	private ArrayList<Sensor> comboSensor;
	private ArrayList<Historico> itens;
	private ArrayList<Historico> itensFiltrados;

	// metodos
	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public ArrayList<Sensor> getComboSensor() {
		return comboSensor;
	}

	public void setComboSensor(ArrayList<Sensor> comboSensor) {
		this.comboSensor = comboSensor;
	}

	public ArrayList<Historico> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Historico> itens) {
		this.itens = itens;
	}

	public ArrayList<Historico> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Historico> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	
	@PostConstruct
	public void prepararPesquisa() {

		try {
			HistoricoDAO dao = new HistoricoDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {

		try {
			historico = new Historico();// instanciar novo cliente para
									// inserir

			SensorDAO dao1 = new SensorDAO();
			comboSensor = dao1.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void novo() {

		try {
			HistoricoDAO dao = new HistoricoDAO();
			dao.inserir(historico);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			HistoricoDAO dao = new HistoricoDAO();
			dao.excluir(historico);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void prepararEditar() {

		try {

			SensorDAO dao1 = new SensorDAO();
			comboSensor = dao1.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			HistoricoDAO dao = new HistoricoDAO();
			dao.atualizar(historico);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}