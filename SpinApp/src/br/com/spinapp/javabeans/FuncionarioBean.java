package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.ClienteDAO;
import br.com.spinapp.dao.FuncionarioDAO;
import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Funcionario;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBFuncionario")
// nome do bean para a tela
@ViewScoped
public class FuncionarioBean {

	// Atributos
	private Funcionario funcionario;// variavel para CRUD dados na DAO
	private ArrayList<Cliente> comboCliente;
	private ArrayList<Funcionario> itens;
	private ArrayList<Funcionario> itensFiltrados;

	// metodos
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ArrayList<Cliente> getComboCliente() {
		return comboCliente;
	}

	public void setComboCliente(ArrayList<Cliente> comboCliente) {
		this.comboCliente = comboCliente;
	}

	public ArrayList<Funcionario> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Funcionario> itens) {
		this.itens = itens;
	}

	public ArrayList<Funcionario> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Funcionario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {
		
		try {
			funcionario = new Funcionario();// instanciar novo cliente para inserir
			
			ClienteDAO dao1 = new ClienteDAO();
			comboCliente = dao1.listar();
			
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
		
	}

	public void novo() {

		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.inserir(funcionario);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.excluir(funcionario);

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
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.atualizar(funcionario);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}