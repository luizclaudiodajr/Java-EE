package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.PlantaDAO;
import br.com.spinapp.domain.Planta;


public class PlantaDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {
		Planta p = new Planta();

		p.setNome("Rosa");
		p.setTmin(4F);
		p.setTmax(40F);
		p.setTot(4F);
		p.setIc(3F);
		p.setUc(7F);

		PlantaDAO dao = new PlantaDAO();
		
		dao.inserir(p);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Planta p = new Planta();
		p.setIdplanta(5l);

		PlantaDAO pdao = new PlantaDAO();

		pdao.excluir(p);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Planta p = new Planta();

		p.setIdplanta(3L);
		p.setNome("Girasol");
		p.setTmin(4F);
		p.setTmax(40F);
		p.setTot(4F);
		p.setIc(3F);
		p.setUc(7F);

		PlantaDAO pdao = new PlantaDAO();

		pdao.atualizar(p);

	}

	@Test
	public void listar() throws SQLException {

		PlantaDAO dao = new PlantaDAO();

		ArrayList<Planta> lista = dao.listar();

		for (Planta p : lista) {
			System.out.println("ID: "+p.getIdplanta());
			System.out.println("Nome: "+p.getNome());
			System.out.println("Tmin: "+p.getTmin());
			System.out.println("Tmax: "+p.getTmax());
			System.out.println("Tot: "+p.getTot());
			System.out.println("Ic: "+p.getIc());
			System.out.println("Uc: "+p.getUc());
			
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Planta pl = new Planta();
		pl.setIdplanta(2L);

		PlantaDAO dao = new PlantaDAO();

		ArrayList<Planta> lista = dao.listarPorId(pl);

		for (Planta p : lista) {
			System.out.println("ID: "+p.getIdplanta());
			System.out.println("Nome: "+p.getNome());
			System.out.println("Tmin: "+p.getTmin());
			System.out.println("Tmax: "+p.getTmax());
			System.out.println("Tot: "+p.getTot());
			System.out.println("Ic: "+p.getIc());
			System.out.println("Uc: "+p.getUc());
						
			System.out.println("\n");
		}
	}

	@Test
	public void listarPorNome() throws SQLException {

		Planta pl = new Planta();
		pl.setNome("rosa");

		PlantaDAO dao = new PlantaDAO();

		ArrayList<Planta> lista = dao.listarPorNome(pl);

		for (Planta p : lista) {
			System.out.println("ID: "+p.getIdplanta());
			System.out.println("Nome: "+p.getNome());
			System.out.println("Tmin: "+p.getTmin());
			System.out.println("Tmax: "+p.getTmax());
			System.out.println("Tot: "+p.getTot());
			System.out.println("Ic: "+p.getIc());
			System.out.println("Uc: "+p.getUc());
									
			System.out.println("\n");
		}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		Planta pl = new Planta();

		pl.setIdplanta(1l);

		PlantaDAO dao = new PlantaDAO();

		Planta p = dao.pesquisar(pl);
		
		System.out.println("ID: "+p.getIdplanta());
		System.out.println("Nome: "+p.getNome());
		System.out.println("Tmin: "+p.getTmin());
		System.out.println("Tmax: "+p.getTmax());
		System.out.println("Tot: "+p.getTot());
		System.out.println("Ic: "+p.getIc());
		System.out.println("Uc: "+p.getUc());
							
		System.out.println("\n");
	}
}