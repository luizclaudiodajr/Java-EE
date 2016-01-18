package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.ClienteDAO;
import br.com.spinapp.domain.Cliente;
import br.com.spinapp.util.JSFUtil;


@ManagedBean(name = "MBCliente")//nome do bean para a tela
@ViewScoped
public class ClienteBean {//faz o intermediario de telaXDAO do banco
	//Atributos
	private Cliente cliente;//variavel para CRUD dados na DAO
	private ArrayList<Cliente> itens;
	private ArrayList<Cliente> itensFiltrados;

	//metodos
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	public ArrayList<Cliente> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Cliente> itens) {
		this.itens = itens;
	}

	public ArrayList<Cliente> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Cliente> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa(){

		try {
			ClienteDAO dao = new ClienteDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
		
	}
	/* Prepara a instancia */
	public void prepararNovo(){
		cliente = new Cliente();//instanciar novo cliente para inserir
		
	}
	
	public void novo(){
		
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.inserir(cliente);
			
			itens = dao.listar();
		
			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
		
	}
	
	
	public void excluir(){
		
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.excluir(cliente);
			
			itens = dao.listar();
			
			JSFUtil.addMsgSucesso("Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
	
	public void editar(){
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.atualizar(cliente);
			
			itens = dao.listar();
			
			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}