package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.PragaDAO;
import br.com.spinapp.domain.Praga;


public class PragaDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {

		Praga p = new Praga();

		p.setNome("Nome1");
		p.setTb(12F);
		p.setCt(10F);

		PragaDAO dao = new PragaDAO();
		
		dao.inserir(p);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Praga p = new Praga();
		p.setIdpraga(5L);

		PragaDAO dao = new PragaDAO();

		dao.excluir(p);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Praga p = new Praga();

		p.setIdpraga(7L);
		p.setNome("Nome2");
		p.setTb(40F);
		p.setCt(33F);

		PragaDAO dao = new PragaDAO();

		dao.atualizar(p);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		PragaDAO dao = new PragaDAO();

		ArrayList<Praga> lista = dao.listar();

		for (Praga p : lista) {

			System.out.println("ID: "+p.getIdpraga());
			System.out.println("Nome: "+p.getNome());
			System.out.println("TB: "+p.getTb());
			System.out.println("TC: "+p.getCt());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Praga pg = new Praga();
		pg.setIdpraga(1L);

		PragaDAO dao = new PragaDAO();

		ArrayList<Praga> lista = dao.listarPorId(pg);

		for (Praga p : lista) {
			
			System.out.println("ID: "+p.getIdpraga());
			System.out.println("Nome: "+p.getNome());
			System.out.println("TB: "+p.getTb());
			System.out.println("TC: "+p.getCt());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorNome() throws SQLException {

		Praga pg = new Praga();
		pg.setNome("nome2");

		PragaDAO dao = new PragaDAO();

		ArrayList<Praga> lista = dao.listarPorNome(pg);

		for (Praga p : lista) {
			System.out.println("ID: "+p.getIdpraga());
			System.out.println("Nome: "+p.getNome());
			System.out.println("TB: "+p.getTb());
			System.out.println("TC: "+p.getCt());
						
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		Praga pg = new Praga();

		pg.setIdpraga(1l);

		PragaDAO dao = new PragaDAO();

		Praga r = dao.pesquisar(pg);

		System.out.println("ID: "+r.getIdpraga());
		System.out.println("Tipo: "+r.getNome());
		System.out.println("Duração: "+r.getTb());
		System.out.println("Descrição: "+r.getCt());
		
		System.out.println("\n");
	}
}