package br.com.spinapp.junit;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.ClienteDAO;
import br.com.spinapp.domain.Cliente;

public class ClienteDAOteste {

	@Test
	@Ignore
	public void inserir() throws SQLException {

		Cliente c = new Cliente();

		c.setNome("Carlos");
		c.setCelular("035 8769-6543");
		c.setEndereco("Rua das coves");
		c.setCpf("092134-mg");
		c.setRg("123456-6");
		c.setEmail("aj.juna@hail.com");
		c.setSenha("a12b3c");
		c.setCnpj("asd123ka");

		ClienteDAO dao = new ClienteDAO();

		dao.inserir(c);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {
		Cliente c = new Cliente();
		c.setIdcliente(5l);

		ClienteDAO pdao = new ClienteDAO();

		pdao.excluir(c);

	}

	@Test
	@Ignore
	public void atualizar() throws SQLException {
		Cliente c = new Cliente();

		c.setIdcliente(2L);
		c.setNome("Luiz");
		c.setCelular("035 9234-1234");
		c.setEndereco("Rua nova");
		c.setCpf("32.456.988-32");
		c.setRg("12.43-mg");
		c.setEmail("as.gt@gmail.com");
		c.setSenha("asd654");
		c.setCnpj("asd92i2.2");

		ClienteDAO pdao = new ClienteDAO();

		pdao.atualizar(c);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		ClienteDAO dao = new ClienteDAO();

		ArrayList<Cliente> lista = dao.listar();

		for (Cliente c : lista) {
			System.out.println("ID: " + c.getIdcliente());
			System.out.println("Nome: " + c.getNome());
			System.out.println("Celular: " + c.getCelular());
			System.out.println("Endereço: " + c.getEndereco());
			System.out.println("CPF: " + c.getCpf());
			System.out.println("RG: " + c.getRg());
			System.out.println("Email: " + c.getEmail());
			System.out.println("Senha: " + c.getSenha());
			System.out.println("CNPJ: " + c.getCnpj());

			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Cliente c = new Cliente();

		c.setIdcliente(1L);

		ClienteDAO pdao = new ClienteDAO();

		ArrayList<Cliente> lista = pdao.listarPorId(c);

		for (Cliente c1 : lista) {
			System.out.println("ID: " + c1.getIdcliente());
			System.out.println("Nome: " + c1.getNome());
			System.out.println("Celular: " + c1.getCelular());
			System.out.println("Endereço: " + c1.getEndereco());
			System.out.println("CPF: " + c1.getCpf());
			System.out.println("RG: " + c1.getRg());
			System.out.println("Email: " + c1.getEmail());
			System.out.println("Senha: " + c1.getSenha());
			System.out.println("CNPJ: " + c1.getCnpj());

			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorNome() throws SQLException {

		Cliente c = new Cliente();

		c.setNome("João");

		ClienteDAO pdao = new ClienteDAO();

		ArrayList<Cliente> lista = pdao.listarPorNome(c);

		for (Cliente c1 : lista) {
			System.out.println("ID: " + c1.getIdcliente());
			System.out.println("Nome: " + c1.getNome());
			System.out.println("Celular: " + c1.getCelular());
			System.out.println("Endereço: " + c1.getEndereco());
			System.out.println("CPF: " + c1.getCpf());
			System.out.println("RG: " + c1.getRg());
			System.out.println("Email: " + c1.getEmail());
			System.out.println("Senha: " + c1.getSenha());
			System.out.println("CNPJ: " + c1.getCnpj());

			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		Cliente c = new Cliente();

		c.setIdcliente(1l);

		ClienteDAO pdao = new ClienteDAO();

		Cliente r = pdao.pesquisar(c);

		System.out.println("ID: " + r.getIdcliente());
		System.out.println("Nome: " + r.getNome());
		System.out.println("Celular: " + r.getCelular());
		System.out.println("Endereço: " + r.getEndereco());
		System.out.println("CPF: " + r.getCpf());
		System.out.println("RG: " + r.getRg());
		System.out.println("Email: " + r.getEmail());
		System.out.println("Senha: " + r.getSenha());
		System.out.println("CNPJ: " + r.getCnpj());

		System.out.println("\n");
	}
}
