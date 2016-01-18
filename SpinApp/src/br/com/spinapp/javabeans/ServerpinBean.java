package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.ClienteDAO;
import br.com.spinapp.dao.ServerpinDAO;
import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Serverpin;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBServerpin")
// nome do bean para a tela
@ViewScoped
public class ServerpinBean {

	// Atributos
	private Serverpin serverpin;// variavel para CRUD dados na DAO
	private ArrayList<Cliente> comboCliente;
	private ArrayList<Serverpin> itens;
	private ArrayList<Serverpin> itensFiltrados;

	// metodos
	public Serverpin getServerpin() {
		return serverpin;
	}

	public void setServerpin(Serverpin serverpin) {
		this.serverpin = serverpin;
	}

	public ArrayList<Cliente> getComboCliente() {
		return comboCliente;
	}

	public void setComboCliente(ArrayList<Cliente> comboCliente) {
		this.comboCliente = comboCliente;
	}

	public ArrayList<Serverpin> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Serverpin> itens) {
		this.itens = itens;
	}

	public ArrayList<Serverpin> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Serverpin> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			ServerpinDAO dao = new ServerpinDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {

		try {
			serverpin = new Serverpin();// instanciar novo cliente para
											// inserir

			ClienteDAO dao1 = new ClienteDAO();
			comboCliente = dao1.listar();
			
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void novo() {

		try {
			ServerpinDAO dao = new ServerpinDAO();
			dao.inserir(serverpin);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			ServerpinDAO dao = new ServerpinDAO();
			dao.excluir(serverpin);

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
			
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			ServerpinDAO dao = new ServerpinDAO();
			dao.atualizar(serverpin);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}