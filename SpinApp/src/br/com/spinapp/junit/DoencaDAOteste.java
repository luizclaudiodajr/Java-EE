package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.DoencaDAO;
import br.com.spinapp.domain.Doenca;


public class DoencaDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {
		Doenca d = new Doenca();

		d.setNome("Nome1");
		d.setReino("Reino1");
		d.setTb(12F);
		d.setTc(10F);

		DoencaDAO dao = new DoencaDAO();
		
		dao.inserir(d);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Doenca d = new Doenca();
		d.setIddoenca(5L);

		DoencaDAO dao = new DoencaDAO();

		dao.excluir(d);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Doenca d = new Doenca();

		d.setIddoenca(7L);
		d.setNome("Nome2");
		d.setReino("Reino2");
		d.setTb(40F);
		d.setTc(33F);

		DoencaDAO dao = new DoencaDAO();

		dao.atualizar(d);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		DoencaDAO dao = new DoencaDAO();

		ArrayList<Doenca> lista = dao.listar();

		for (Doenca d : lista) {
			System.out.println("ID: "+d.getIddoenca());
			System.out.println("Nome: "+d.getNome());
			System.out.println("Reino: "+d.getReino());
			System.out.println("TB: "+d.getTb());
			System.out.println("TC: "+d.getTc());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Doenca dc = new Doenca();
		dc.setIddoenca(1L);

		DoencaDAO dao = new DoencaDAO();

		ArrayList<Doenca> lista = dao.listarPorId(dc);

		for (Doenca d : lista) {
			System.out.println("ID: "+d.getIddoenca());
			System.out.println("Nome: "+d.getNome());
			System.out.println("Reino: "+d.getReino());
			System.out.println("TB: "+d.getTb());
			System.out.println("TC: "+d.getTc());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorNome() throws SQLException {

		Doenca dc = new Doenca();
		dc.setNome("nome2");

		DoencaDAO dao = new DoencaDAO();

		ArrayList<Doenca> lista = dao.listarPorNome(dc);

		for (Doenca d : lista) {
			System.out.println("ID: "+d.getIddoenca());
			System.out.println("Nome: "+d.getNome());
			System.out.println("Reino: "+d.getReino());
			System.out.println("TB: "+d.getTb());
			System.out.println("TC: "+d.getTc());
						
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		Doenca dc = new Doenca();

		dc.setIddoenca(1l);

		DoencaDAO dao = new DoencaDAO();

		Doenca r = dao.pesquisar(dc);

		System.out.println("ID: "+r.getIddoenca());
		System.out.println("Tipo: "+r.getNome());
		System.out.println("Preço: "+r.getReino());
		System.out.println("Duração: "+r.getTb());
		System.out.println("Descrição: "+r.getTc());
		
		System.out.println("\n");
	}
}