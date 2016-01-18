package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.TipoSensorDAO;
import br.com.spinapp.domain.TipoSensor;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBTipoSensor")
// nome do bean para a tela
@ViewScoped
public class TipoSensorBean {

	// Atributos
	private TipoSensor tiposensor;// variavel para CRUD dados na DAO
	private ArrayList<TipoSensor> itens;
	private ArrayList<TipoSensor> itensFiltrados;

	// metodos
	public TipoSensor getTiposensor() {
		return tiposensor;
	}

	public void setTiposensor(TipoSensor tiposensor) {
		this.tiposensor = tiposensor;
	}

	public ArrayList<TipoSensor> getItens() {
		return itens;
	}

	public void setItens(ArrayList<TipoSensor> itens) {
		this.itens = itens;
	}

	public ArrayList<TipoSensor> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<TipoSensor> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	// FUNCAO
	@PostConstruct
	public void prepararPesquisa() {

		try {
			TipoSensorDAO dao = new TipoSensorDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {
		tiposensor = new TipoSensor();// instanciar novo cliente para
											// inserir

	}

	public void novo() {

		try {
			TipoSensorDAO dao = new TipoSensorDAO();
			dao.inserir(tiposensor);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			TipoSensorDAO dao = new TipoSensorDAO();
			dao.excluir(tiposensor);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			TipoSensorDAO dao = new TipoSensorDAO();
			dao.atualizar(tiposensor);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}