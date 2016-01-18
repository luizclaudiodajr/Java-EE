package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.DoencaDAO;
import br.com.spinapp.domain.Doenca;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBDoenca")
// nome do bean para a tela
@ViewScoped
public class DoencaBean {

	// Atributos
	private Doenca doenca;// variavel para CRUD dados na DAO
	private ArrayList<Doenca> itens;
	private ArrayList<Doenca> itensFiltrados;

	// metodos
	public Doenca getDoenca() {
		return doenca;
	}

	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}

	public ArrayList<Doenca> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Doenca> itens) {
		this.itens = itens;
	}

	public ArrayList<Doenca> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Doenca> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	// FUNCAO
	@PostConstruct
	public void prepararPesquisa() {

		try {
			DoencaDAO dao = new DoencaDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {
		doenca = new Doenca();// instanciar novo cliente para inserir

	}

	public void novo() {

		try {
			DoencaDAO dao = new DoencaDAO();
			dao.inserir(doenca);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			DoencaDAO dao = new DoencaDAO();
			dao.excluir(doenca);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			DoencaDAO dao = new DoencaDAO();
			dao.atualizar(doenca);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}