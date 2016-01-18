package br.com.spinapp.junit;

import java.text.ParseException;
import java.util.ArrayList;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.PlanoDAO;
import br.com.spinapp.domain.Plano;

public class PlanoDAOteste {

	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {
		Plano p = new Plano();

		p.setTipo("Basic");
		p.setPreco(400F);
		p.setDuracao("6 meses");
		p.setDescricao("plano basico");

		PlanoDAO dao = new PlanoDAO();
		
		dao.inserir(p);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Plano p = new Plano();
		p.setIdplano(5l);

		PlanoDAO dao = new PlanoDAO();

		dao.excluir(p);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Plano p = new Plano();

		p.setIdplano(7L);
		p.setTipo("Medium");
		p.setPreco(15000F);
		p.setDuracao("12 meses");
		p.setDescricao("teste descrição");

		PlanoDAO dao = new PlanoDAO();

		dao.atualizar(p);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		PlanoDAO dao = new PlanoDAO();

		ArrayList<Plano> lista = dao.listar();

		for (Plano p : lista) {
			System.out.println("ID: "+p.getIdplano());
			System.out.println("Tipo: "+p.getTipo());
			System.out.println("Preço: "+p.getPreco());
			System.out.println("Duração: "+p.getDuracao());
			System.out.println("Descrição: "+p.getDescricao());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Plano p = new Plano();
		p.setIdplano(1L);

		PlanoDAO dao = new PlanoDAO();

		ArrayList<Plano> lista = dao.listarPorId(p);

		for (Plano p1 : lista) {
			System.out.println("ID: "+p1.getIdplano());
			System.out.println("Tipo: "+p1.getTipo());
			System.out.println("Preço: "+p1.getPreco());
			System.out.println("Duração: "+p1.getDuracao());
			System.out.println("Descrição: "+p1.getDescricao());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorTipo() throws SQLException {

		Plano p = new Plano();
		p.setTipo("basic");

		PlanoDAO dao = new PlanoDAO();

		ArrayList<Plano> lista = dao.listarPorTipo(p);

		for (Plano p1 : lista) {
			System.out.println("ID: "+p1.getIdplano());
			System.out.println("Tipo: "+p1.getTipo());
			System.out.println("Preço: "+p1.getPreco());
			System.out.println("Duração: "+p1.getDuracao());
			System.out.println("Descrição: "+p1.getDescricao());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		Plano p = new Plano();

		p.setIdplano(1l);

		PlanoDAO dao = new PlanoDAO();

		Plano r = dao.pesquisar(p);

		System.out.println("ID: "+r.getIdplano());
		System.out.println("Tipo: "+r.getTipo());
		System.out.println("Preço: "+r.getPreco());
		System.out.println("Duração: "+r.getDuracao());
		System.out.println("Descrição: "+r.getDescricao());
		
		System.out.println("\n");
	}
}
