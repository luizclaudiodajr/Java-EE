package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.TipoSensorDAO;
import br.com.spinapp.domain.TipoSensor;

public class TipoSensorDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {
		TipoSensor t = new TipoSensor();

		t.setDescricao("temperatura");
		t.setUnidade("c°");

		TipoSensorDAO dao = new TipoSensorDAO();
		
		dao.inserir(t);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		TipoSensor t = new TipoSensor();
		t.setIdtipo(4L);

		TipoSensorDAO dao = new TipoSensorDAO();

		dao.excluir(t);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		TipoSensor t = new TipoSensor();

		t.setIdtipo(2L);
		t.setDescricao("radiação");
		t.setUnidade("crip");

		TipoSensorDAO dao = new TipoSensorDAO();

		dao.atualizar(t);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		TipoSensorDAO dao = new TipoSensorDAO();

		ArrayList<TipoSensor> lista = dao.listar();

		for (TipoSensor t : lista) {
			System.out.println("ID: "+t.getIdtipo());
			System.out.println("Descrição: "+t.getDescricao());
			System.out.println("Unidade: "+t.getUnidade());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		TipoSensor ts = new TipoSensor();
		ts.setIdtipo(1L);

		TipoSensorDAO dao = new TipoSensorDAO();

		ArrayList<TipoSensor> lista = dao.listarPorId(ts);

		for (TipoSensor t : lista) {
			System.out.println("ID: "+t.getIdtipo());
			System.out.println("Descrição: "+t.getDescricao());
			System.out.println("Unidade: "+t.getUnidade());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorDescricao() throws SQLException {

		TipoSensor ts = new TipoSensor();
		ts.setDescricao("vento");

		TipoSensorDAO dao = new TipoSensorDAO();

		ArrayList<TipoSensor> lista = dao.listarPorDescricao(ts);

		for (TipoSensor t : lista) {
			System.out.println("ID: "+t.getIdtipo());
			System.out.println("Descrição: "+t.getDescricao());
			System.out.println("Unidade: "+t.getUnidade());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		TipoSensor t = new TipoSensor();

		t.setIdtipo(1L);

		TipoSensorDAO dao = new TipoSensorDAO();

		TipoSensor r = dao.pesquisar(t);

		System.out.println("ID: "+r.getIdtipo());
		System.out.println("Descrição: "+r.getDescricao());
		System.out.println("Unidade: "+r.getUnidade());
		
		System.out.println("\n");
	}
}