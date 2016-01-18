package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.LeituraDAO;
import br.com.spinapp.dao.SensorDAO;
import br.com.spinapp.domain.Leitura;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBLeitura")
// nome do bean para a tela
@ViewScoped
public class LeituraBean {

	// Atributos
	private Leitura leitura;// variavel para CRUD dados na DAO
	private ArrayList<Sensor> comboSensor;
	private ArrayList<Leitura> itens;
	private ArrayList<Leitura> itensFiltrados;

	// metodos
	public Leitura getLeitura() {
		return leitura;
	}

	public void setLeitura(Leitura leitura) {
		this.leitura = leitura;
	}

	public ArrayList<Sensor> getComboSensor() {
		return comboSensor;
	}

	public void setComboSensor(ArrayList<Sensor> comboSensor) {
		this.comboSensor = comboSensor;
	}

	public ArrayList<Leitura> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Leitura> itens) {
		this.itens = itens;
	}

	public ArrayList<Leitura> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Leitura> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			LeituraDAO dao = new LeituraDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {

		try {
			leitura = new Leitura();// instanciar novo cliente para
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
			LeituraDAO dao = new LeituraDAO();
			dao.inserir(leitura);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			LeituraDAO dao = new LeituraDAO();
			dao.excluir(leitura);

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
			LeituraDAO dao = new LeituraDAO();
			dao.atualizar(leitura);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}