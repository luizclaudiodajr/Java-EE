package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.PragaDAO;
import br.com.spinapp.domain.Praga;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBPraga")
// nome do bean para a tela
@ViewScoped
public class PragaBean {

	// Atributos
	private Praga praga;// variavel para CRUD dados na DAO
	private ArrayList<Praga> itens;
	private ArrayList<Praga> itensFiltrados;

	// metodos
	public Praga getPraga() {
		return praga;
	}

	public void setPraga(Praga praga) {
		this.praga = praga;
	}

	public ArrayList<Praga> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Praga> itens) {
		this.itens = itens;
	}

	public ArrayList<Praga> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Praga> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	// FUNCAO
	@PostConstruct
	public void prepararPesquisa() {

		try {
			PragaDAO dao = new PragaDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {
		praga = new Praga();// instanciar novo cliente para inserir

	}

	public void novo() {

		try {
			PragaDAO dao = new PragaDAO();
			dao.inserir(praga);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			PragaDAO dao = new PragaDAO();
			dao.excluir(praga);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			PragaDAO dao = new PragaDAO();
			dao.atualizar(praga);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}