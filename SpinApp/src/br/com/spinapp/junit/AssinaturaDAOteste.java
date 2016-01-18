package br.com.spinapp.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.AssinaturaDAO;
import br.com.spinapp.domain.Assinatura;
import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Plano;

public class AssinaturaDAOteste {

	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {
		Assinatura a = new Assinatura();

		SimpleDateFormat brasil = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = brasil.parse("2014-10-10");
		Date d2 = brasil.parse("2015-06-09");

		brasil.format(d1);// converte date para String

		a.setDatain(d1);// para o banco tem que mandar Date
		a.setDataout(d2);
		
		
		Plano p = new Plano();
		Cliente c = new Cliente();
		
		p.setIdplano(3L);
		c.setIdcliente(2L);
		
		a.setCliente_idcliente(c);
		a.setPlano_idplano(p);


		AssinaturaDAO dao = new AssinaturaDAO();
		dao.inserir(a);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Assinatura a = new Assinatura();
		a.setIdassina(5l);

		AssinaturaDAO pdao = new AssinaturaDAO();

		pdao.excluir(a);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Assinatura a = new Assinatura();

		SimpleDateFormat brasil = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = brasil.parse("2014-10-10");
		Date d2 = brasil.parse("2015-06-09");

		a.setIdassina(7L);
		a.setDatain(d1);
		a.setDataout(d2);

		Plano p = new Plano();
		Cliente c = new Cliente();
		
		p.setIdplano(3L);
		c.setIdcliente(2L);
		
		a.setCliente_idcliente(c);
		a.setPlano_idplano(p);
				
		AssinaturaDAO pdao = new AssinaturaDAO();
		pdao.atualizar(a);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		AssinaturaDAO dao = new AssinaturaDAO();
		
		ArrayList<Assinatura> lista = dao.listar();
		
		for(Assinatura a : lista){
			
			
			System.out.println("\nID contrato: "+a.getIdassina());
			System.out.println("Data de entrada: "+a.getDatain());
			System.out.println("Data de saida: "+a.getDataout());
			
			System.out.println("\nID cliente: "+a.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+a.getCliente_idcliente().getNome());
			System.out.println("Celular: "+a.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+a.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+a.getCliente_idcliente().getCpf());
			System.out.println("RG: "+a.getCliente_idcliente().getRg());
			System.out.println("Email: "+a.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+a.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+a.getCliente_idcliente().getCnpj());
		
			System.out.println("\nID plano: "+a.getPlano_idplano().getIdplano());
			System.out.println("Tipo: "+a.getPlano_idplano().getTipo());
			System.out.println("Preço: "+a.getPlano_idplano().getPreco());
			System.out.println("Duraçao do plano: "+a.getPlano_idplano().getDuracao());
			System.out.println("Descrição do plano: "+a.getPlano_idplano().getDescricao());
			
			System.out.println("\n********** ********** **********");
		}
	}

	
	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Assinatura as = new Assinatura();

		as.setIdassina(3L);

		AssinaturaDAO adao = new AssinaturaDAO();

		ArrayList<Assinatura> lista = adao.listarPorId(as);

		for(Assinatura a : lista){
			
			
			System.out.println("\nID contrato: "+a.getIdassina());
			System.out.println("Data de entrada: "+a.getDatain());
			System.out.println("Data de saida: "+a.getDataout());
			
			System.out.println("\nID cliente: "+a.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+a.getCliente_idcliente().getNome());
			System.out.println("Celular: "+a.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+a.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+a.getCliente_idcliente().getCpf());
			System.out.println("RG: "+a.getCliente_idcliente().getRg());
			System.out.println("Email: "+a.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+a.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+a.getCliente_idcliente().getCnpj());
		
			System.out.println("\nID plano: "+a.getPlano_idplano().getIdplano());
			System.out.println("Tipo: "+a.getPlano_idplano().getTipo());
			System.out.println("Preço: "+a.getPlano_idplano().getPreco());
			System.out.println("Duraçao do plano: "+a.getPlano_idplano().getDuracao());
			System.out.println("Descrição do plano: "+a.getPlano_idplano().getDescricao());
			
			System.out.println("\n********** ********** **********");	
		}
	}

	@Test
	@Ignore
	public void listarPorIDcliente() throws SQLException {

		Assinatura as = new Assinatura();
		Cliente c = new Cliente();
		
		c.setIdcliente(3L);
		as.setCliente_idcliente(c);
		
		AssinaturaDAO adao = new AssinaturaDAO();

		ArrayList<Assinatura> lista = adao.listarPorIdcliente(as);

		for(Assinatura a : lista){
			
			
			System.out.println("\nID contrato: "+a.getIdassina());
			System.out.println("Data de entrada: "+a.getDatain());
			System.out.println("Data de saida: "+a.getDataout());
			
			System.out.println("\nID cliente: "+a.getCliente_idcliente().getIdcliente());
			System.out.println("Nome: "+a.getCliente_idcliente().getNome());
			System.out.println("Celular: "+a.getCliente_idcliente().getCelular());
			System.out.println("Endereço: "+a.getCliente_idcliente().getEndereco());
			System.out.println("CPF: "+a.getCliente_idcliente().getCpf());
			System.out.println("RG: "+a.getCliente_idcliente().getRg());
			System.out.println("Email: "+a.getCliente_idcliente().getEmail());
			System.out.println("Senha: "+a.getCliente_idcliente().getSenha());
			System.out.println("CNPJ: "+a.getCliente_idcliente().getCnpj());
		
			System.out.println("\nID plano: "+a.getPlano_idplano().getIdplano());
			System.out.println("Tipo: "+a.getPlano_idplano().getTipo());
			System.out.println("Preço: "+a.getPlano_idplano().getPreco());
			System.out.println("Duraçao do plano: "+a.getPlano_idplano().getDuracao());
			System.out.println("Descrição do plano: "+a.getPlano_idplano().getDescricao());
			
			System.out.println("\n********** ********** **********");	
			}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		Assinatura as = new Assinatura();

		as.setIdassina(1l);

		AssinaturaDAO asdao = new AssinaturaDAO();

		Assinatura a = asdao.pesquisar(as);

		System.out.println("\nID contrato: "+a.getIdassina());
		System.out.println("Data de entrada: "+a.getDatain());
		System.out.println("Data de saida: "+a.getDataout());
		
		System.out.println("\nID cliente: "+a.getCliente_idcliente().getIdcliente());
		System.out.println("Nome: "+a.getCliente_idcliente().getNome());
		System.out.println("Celular: "+a.getCliente_idcliente().getCelular());
		System.out.println("Endereço: "+a.getCliente_idcliente().getEndereco());
		System.out.println("CPF: "+a.getCliente_idcliente().getCpf());
		System.out.println("RG: "+a.getCliente_idcliente().getRg());
		System.out.println("Email: "+a.getCliente_idcliente().getEmail());
		System.out.println("Senha: "+a.getCliente_idcliente().getSenha());
		System.out.println("CNPJ: "+a.getCliente_idcliente().getCnpj());
	
		System.out.println("\nID plano: "+a.getPlano_idplano().getIdplano());
		System.out.println("Tipo: "+a.getPlano_idplano().getTipo());
		System.out.println("Preço: "+a.getPlano_idplano().getPreco());
		System.out.println("Duraçao do plano: "+a.getPlano_idplano().getDuracao());
		System.out.println("Descrição do plano: "+a.getPlano_idplano().getDescricao());
		
		System.out.println("\n********** ********** **********");	
	}
}
