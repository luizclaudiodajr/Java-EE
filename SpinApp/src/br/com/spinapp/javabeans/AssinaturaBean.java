package br.com.spinapp.javabeans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.spinapp.dao.AssinaturaDAO;
import br.com.spinapp.dao.ClienteDAO;
import br.com.spinapp.dao.PlanoDAO;
import br.com.spinapp.domain.Assinatura;
import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Plano;
import br.com.spinapp.util.JSFUtil;

@ManagedBean(name = "MBAssinatura")
// nome do bean para a tela
@ViewScoped
public class AssinaturaBean {

	// Atributos
	private Assinatura assinatura;// variavel para CRUD dados na DAO
	private ArrayList<Cliente> comboCliente;
	private ArrayList<Plano> comboPlano;
	private ArrayList<Assinatura> itens;
	private ArrayList<Assinatura> itensFiltrados;

	// metodos

	public Assinatura getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(Assinatura assinatura) {
		this.assinatura = assinatura;
	}

	public ArrayList<Cliente> getComboCliente() {
		return comboCliente;
	}

	public void setComboCliente(ArrayList<Cliente> comboCliente) {
		this.comboCliente = comboCliente;
	}

	public ArrayList<Plano> getComboPlano() {
		return comboPlano;
	}

	public void setComboPlano(ArrayList<Plano> comboPlano) {
		this.comboPlano = comboPlano;
	}

	public ArrayList<Assinatura> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Assinatura> itens) {
		this.itens = itens;
	}

	public ArrayList<Assinatura> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Assinatura> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			AssinaturaDAO dao = new AssinaturaDAO();
			itens = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	/* Prepara a instancia */
	public void prepararNovo() {

		try {
			assinatura = new Assinatura();// instanciar novo cliente para inserir

			ClienteDAO dao1 = new ClienteDAO();
			comboCliente = dao1.listar();

			PlanoDAO dao2 = new PlanoDAO();
			comboPlano = dao2.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void novo() {

		try {
			AssinaturaDAO dao = new AssinaturaDAO();
			dao.inserir(assinatura);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}

	}

	public void excluir() {

		try {
			AssinaturaDAO dao = new AssinaturaDAO();
			dao.excluir(assinatura);

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
			
			PlanoDAO dao2 = new PlanoDAO();
			comboPlano = dao2.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
	
	public void editar() {
		try {
			AssinaturaDAO dao = new AssinaturaDAO();
			dao.atualizar(assinatura);

			itens = dao.listar();

			JSFUtil.addMsgSucesso("Editado com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.addMsgErro(e.getMessage());
		}
	}
}