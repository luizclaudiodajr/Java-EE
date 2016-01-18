package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.ModeloDAO;
import br.com.spinapp.domain.Modelo;


public class ModeloDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {
		Modelo m = new Modelo();

		m.setDescricao("Serverpin");

		ModeloDAO dao = new ModeloDAO();
		
		dao.inserir(m);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Modelo m = new Modelo();
		m.setIdmodelo(4L);

		ModeloDAO dao = new ModeloDAO();

		dao.excluir(m);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Modelo m = new Modelo();

		m.setIdmodelo(2L);
		m.setDescricao("teste descrição");

		ModeloDAO dao = new ModeloDAO();

		dao.atualizar(m);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		ModeloDAO dao = new ModeloDAO();

		ArrayList<Modelo> lista = dao.listar();

		for (Modelo m : lista) {
			System.out.println("ID: "+m.getIdmodelo());
			System.out.println("Descrição: "+m.getDescricao());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Modelo mo = new Modelo();
		mo.setIdmodelo(1L);

		ModeloDAO dao = new ModeloDAO();

		ArrayList<Modelo> lista = dao.listarPorId(mo);

		for (Modelo m : lista) {
			System.out.println("ID: "+m.getIdmodelo());
			System.out.println("Descrição: "+m.getDescricao());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorDescricao() throws SQLException {

		Modelo mo = new Modelo();
		mo.setDescricao("minipin");

		ModeloDAO dao = new ModeloDAO();

		ArrayList<Modelo> lista = dao.listarPorDescricao(mo);

		for (Modelo m : lista) {
			System.out.println("ID: "+m.getIdmodelo());
			System.out.println("Descrição: "+m.getDescricao());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		Modelo m = new Modelo();

		m.setIdmodelo(1L);

		ModeloDAO dao = new ModeloDAO();

		Modelo r = dao.pesquisar(m);

		System.out.println("ID: "+r.getIdmodelo());
		System.out.println("Descrição: "+r.getDescricao());
		
		System.out.println("\n");
	}
}