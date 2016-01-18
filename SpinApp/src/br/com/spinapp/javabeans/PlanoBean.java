package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.PlanoDAO;
import br.com.spinapp.domain.Plano;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBPlano")// nome do bean para a tela
@ViewScoped
public class PlanoBean {

	// Atributos
	private Plano plano;// variavel para CRUD dados na DAO
	private ArrayList<Plano> itens;
	private ArrayList<Plano> itensFiltrados;

	// metodos
	
	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public ArrayList<Plano> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Plano> itens) {
		this.itens = itens;
	}

	public ArrayList<Plano> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Plano> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	
	//FUNCAO
	@PostConstruct
	public void prepararPesquisa() {

		try {
			PlanoDAO dao = new PlanoDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	
	/* Prepara a instancia */
	public void prepararNovo() {
		plano = new Plano();// instanciar novo cliente para inserir

	}

	public void novo() {

		try {
			PlanoDAO dao = new PlanoDAO();
			dao.inserir(plano);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			PlanoDAO dao = new PlanoDAO();
			dao.excluir(plano);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			PlanoDAO dao = new PlanoDAO();
			dao.atualizar(plano);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}