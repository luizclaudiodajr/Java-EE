package br.com.spinapp.junit;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.FuncionarioDAO;
import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Funcionario;

public class FuncionarioDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException {
		Funcionario f = new Funcionario();
		Cliente c = new Cliente();
		
		
		f.setNome("Carlos");
		f.setEmail("aj.juna@hail.com");
		f.setCelular("035 8769-6543");
		f.setSenha("Rua das coves");
			
		c.setIdcliente(2L);
		
		f.setCliente_idcliente(c);


		FuncionarioDAO dao = new FuncionarioDAO();
		dao.inserir(f);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Funcionario f = new Funcionario();
		f.setIdfuncionario(5l);

		FuncionarioDAO dao = new FuncionarioDAO();

		dao.excluir(f);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException {

		Funcionario f = new Funcionario();
		Cliente c = new Cliente();
		
		f.setIdfuncionario(1L);
		f.setNome("Carlos");
		f.setEmail("aj.juna@hail.com");
		f.setCelular("035 8769-6543");
		f.setSenha("senha123");
			
		c.setIdcliente(1L);
		
		f.setCliente_idcliente(c);


		FuncionarioDAO dao = new FuncionarioDAO();
		dao.inserir(f);
	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		FuncionarioDAO dao = new FuncionarioDAO();
		
		ArrayList<Funcionario> lista = dao.listar();
		
		for(Funcionario f : lista){
			
			
			System.out.println("\nID funcionario: "+f.getIdfuncionario());
			System.out.println("Nome: "+f.getNome());
			System.out.println("Email: "+f.getEmail());
			System.out.println("Celular: "+f.getCelular());
			System.out.println("Senha: "+f.getSenha());
			
			System.out.println("\nID cliente: "+f.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+f.getCliente_idcliente().getNome());
			System.out.println("Celular: "+f.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+f.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+f.getCliente_idcliente().getCpf());
			System.out.println("RG: "+f.getCliente_idcliente().getRg());
			System.out.println("Email: "+f.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+f.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+f.getCliente_idcliente().getCnpj());
			
			System.out.println("\n********** ********** **********");
		}
	}

	
	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Funcionario fun = new Funcionario();

		fun.setIdfuncionario(3L);

		FuncionarioDAO dao = new FuncionarioDAO();

		ArrayList<Funcionario> lista = dao.listarPorId(fun);

		for(Funcionario f : lista){
			
			System.out.println("\nID funcionario: "+f.getIdfuncionario());
			System.out.println("Nome: "+f.getNome());
			System.out.println("Email: "+f.getEmail());
			System.out.println("Celular: "+f.getCelular());
			System.out.println("Senha: "+f.getSenha());
			
			System.out.println("\nID cliente: "+f.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+f.getCliente_idcliente().getNome());
			System.out.println("Celular: "+f.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+f.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+f.getCliente_idcliente().getCpf());
			System.out.println("RG: "+f.getCliente_idcliente().getRg());
			System.out.println("Email: "+f.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+f.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+f.getCliente_idcliente().getCnpj());
			
			System.out.println("\n********** ********** **********");
		}
	}

	@Test
	@Ignore
	public void listarPorNome() throws SQLException {

		Funcionario fun = new Funcionario();
		
		fun.setNome("Carlos");
		
		FuncionarioDAO dao = new FuncionarioDAO();

		ArrayList<Funcionario> lista = dao.listarPorNome(fun);

		for(Funcionario f : lista){

			System.out.println("\nID funcionario: "+f.getIdfuncionario());
			System.out.println("Nome: "+f.getNome());
			System.out.println("Email: "+f.getEmail());
			System.out.println("Celular: "+f.getCelular());
			System.out.println("Senha: "+f.getSenha());
			
			System.out.println("\nID cliente: "+f.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+f.getCliente_idcliente().getNome());
			System.out.println("Celular: "+f.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+f.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+f.getCliente_idcliente().getCpf());
			System.out.println("RG: "+f.getCliente_idcliente().getRg());
			System.out.println("Email: "+f.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+f.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+f.getCliente_idcliente().getCnpj());
			
			System.out.println("\n********** ********** **********");
		}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		Funcionario fun = new Funcionario();

		fun.setIdfuncionario(2L);

		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario f = dao.pesquisar(fun);


		System.out.println("\nID funcionario: "+f.getIdfuncionario());
		System.out.println("Nome: "+f.getNome());
		System.out.println("Email: "+f.getEmail());
		System.out.println("Celular: "+f.getCelular());
		System.out.println("Senha: "+f.getSenha());
		
		System.out.println("\nID cliente: "+f.getCliente_idcliente().getIdcliente());
		System.out.println("Nome: "+f.getCliente_idcliente().getNome());
		System.out.println("Celular: "+f.getCliente_idcliente().getCelular());
		System.out.println("Endereço: "+f.getCliente_idcliente().getEndereco());
		System.out.println("CPF: "+f.getCliente_idcliente().getCpf());
		System.out.println("RG: "+f.getCliente_idcliente().getRg());
		System.out.println("Email: "+f.getCliente_idcliente().getEmail());
		System.out.println("Senha: "+f.getCliente_idcliente().getSenha());
		System.out.println("CNPJ: "+f.getCliente_idcliente().getCnpj());
		
		System.out.println("\n********** ********** **********");
	}
}