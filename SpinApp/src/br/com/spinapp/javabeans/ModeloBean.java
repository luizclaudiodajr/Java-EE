package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.ModeloDAO;
import br.com.spinapp.domain.Modelo;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBModelo")//nome do bean para a tela
@ViewScoped
public class ModeloBean {
	
	//Atributos
	private Modelo modelo;//variavel para CRUD dados na DAO
	private ArrayList<Modelo> itens;
	private ArrayList<Modelo> itensFiltrados;

	
	//metodos	
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public ArrayList<Modelo> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Modelo> itens) {
		this.itens = itens;
	}
	public ArrayList<Modelo> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Modelo> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	//Função
	@PostConstruct
	public void prepararPesquisa(){

		try {
			ModeloDAO dao = new ModeloDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
		
	}
	/* Prepara a instancia */
	public void prepararNovo(){
		modelo = new Modelo();//instanciar novo cliente para inserir
		
	}
	
	public void novo(){
		
		try {
			ModeloDAO dao = new ModeloDAO();
			dao.inserir(modelo);
			
			itens = dao.listar();
		
			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
		
	}
	
	
	public void excluir(){
		
		try {
			ModeloDAO dao = new ModeloDAO();
			dao.excluir(modelo);
			
			itens = dao.listar();
			
			JSFUtil.addMsgSucesso("Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
	
	public void editar(){
		try {
			ModeloDAO dao = new ModeloDAO();
			dao.atualizar(modelo);
			
			itens = dao.listar();
			
			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}