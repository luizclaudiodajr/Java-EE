package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.ClienteDAO;
import br.com.spinapp.dao.PlantaDAO;
import br.com.spinapp.dao.PlantacaoDAO;
import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Planta;
import br.com.spinapp.domain.Plantacao;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBPlantacao")
// nome do bean para a tela
@ViewScoped
public class PlantacaoBean {

	// Atributos
	private Plantacao plantacao;// variavel para CRUD dados na DAO
	private ArrayList<Cliente> comboCliente;
	private ArrayList<Planta> comboPlanta;
	private ArrayList<Plantacao> itens;
	private ArrayList<Plantacao> itensFiltrados;

	// metodos
	public Plantacao getPlantacao() {
		return plantacao;
	}

	public void setPlantacao(Plantacao plantacao) {
		this.plantacao = plantacao;
	}

	public ArrayList<Cliente> getComboCliente() {
		return comboCliente;
	}

	public void setComboCliente(ArrayList<Cliente> comboCliente) {
		this.comboCliente = comboCliente;
	}

	public ArrayList<Planta> getComboPlanta() {
		return comboPlanta;
	}

	public void setComboPlanta(ArrayList<Planta> comboPlanta) {
		this.comboPlanta = comboPlanta;
	}

	public ArrayList<Plantacao> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Plantacao> itens) {
		this.itens = itens;
	}

	public ArrayList<Plantacao> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Plantacao> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			PlantacaoDAO dao = new PlantacaoDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {

		try {
			plantacao = new Plantacao();// instanciar novo cliente para inserir
			
			ClienteDAO dao1 = new ClienteDAO();
			comboCliente = dao1.listar();
			
			PlantaDAO dao2 = new PlantaDAO();
			comboPlanta = dao2.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void novo() {

		try {
			PlantacaoDAO dao = new PlantacaoDAO();
			dao.inserir(plantacao);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			PlantacaoDAO dao = new PlantacaoDAO();
			dao.excluir(plantacao);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void prepararEditar(){
		
		try {
			
			ClienteDAO dao1 = new ClienteDAO();
			comboCliente = dao1.listar();
			
			PlantaDAO dao2 = new PlantaDAO();
			comboPlanta = dao2.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
	
	public void editar() {
		try {
			PlantacaoDAO dao = new PlantacaoDAO();
			dao.atualizar(plantacao);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}