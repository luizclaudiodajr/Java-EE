package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.PlantaDAO;
import br.com.spinapp.domain.Planta;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBPlanta")
// nome do bean para a tela
@ViewScoped
public class PlantaBean {

	// Atributos
	private Planta planta;// variavel para CRUD dados na DAO
	private ArrayList<Planta> itens;
	private ArrayList<Planta> itensFiltrados;

	// metodos
	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public ArrayList<Planta> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Planta> itens) {
		this.itens = itens;
	}

	public ArrayList<Planta> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Planta> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	// FUNCAO
	@PostConstruct
	public void prepararPesquisa() {

		try {
			PlantaDAO dao = new PlantaDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {
		planta = new Planta();// instanciar novo cliente para inserir

	}

	public void novo() {

		try {
			PlantaDAO dao = new PlantaDAO();
			dao.inserir(planta);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			PlantaDAO dao = new PlantaDAO();
			dao.excluir(planta);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			PlantaDAO dao = new PlantaDAO();
			dao.atualizar(planta);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}