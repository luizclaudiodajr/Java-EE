package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.EquipamentoDAO;
import br.com.spinapp.dao.SensorDAO;
import br.com.spinapp.dao.TipoSensorDAO;
import br.com.spinapp.domain.Equipamento;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.domain.TipoSensor;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBSensor")
// nome do bean para a tela
@ViewScoped
public class SensorBean {

	// Atributos
	private Sensor sensor;// variavel para CRUD dados na DAO
	private ArrayList<Equipamento> comboEquipamento;
	private ArrayList<TipoSensor> comboTipoSensor;
	private ArrayList<Sensor> itens;
	private ArrayList<Sensor> itensFiltrados;

	// metodos
	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public ArrayList<Equipamento> getComboEquipamento() {
		return comboEquipamento;
	}

	public void setComboEquipamento(ArrayList<Equipamento> comboEquipamento) {
		this.comboEquipamento = comboEquipamento;
	}

	public ArrayList<TipoSensor> getComboTipoSensor() {
		return comboTipoSensor;
	}

	public void setComboTipoSensor(ArrayList<TipoSensor> comboTipoSensor) {
		this.comboTipoSensor = comboTipoSensor;
	}

	public ArrayList<Sensor> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Sensor> itens) {
		this.itens = itens;
	}

	public ArrayList<Sensor> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Sensor> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			SensorDAO dao = new SensorDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {

		try {
			sensor = new Sensor();// instanciar novo cliente para
									// inserir

			EquipamentoDAO dao1 = new EquipamentoDAO();
			comboEquipamento = dao1.listar();

			TipoSensorDAO dao2 = new TipoSensorDAO();
			comboTipoSensor = dao2.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void novo() {

		try {
			SensorDAO dao = new SensorDAO();
			dao.inserir(sensor);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			SensorDAO dao = new SensorDAO();
			dao.excluir(sensor);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void prepararEditar() {

		try {

			EquipamentoDAO dao1 = new EquipamentoDAO();
			comboEquipamento = dao1.listar();

			TipoSensorDAO dao2 = new TipoSensorDAO();
			comboTipoSensor = dao2.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			SensorDAO dao = new SensorDAO();
			dao.atualizar(sensor);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}