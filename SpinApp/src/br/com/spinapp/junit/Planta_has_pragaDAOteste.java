package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.Planta_has_pragaDAO;
import br.com.spinapp.domain.Planta;
import br.com.spinapp.domain.Planta_has_praga;
import br.com.spinapp.domain.Praga;


public class Planta_has_pragaDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {
		
		Planta_has_praga php = new Planta_has_praga();

		
		Planta p = new Planta();
		Praga pr = new Praga();
		
		p.setIdplanta(3L);
		pr.setIdpraga(1L);
		
		php.setPlanta_idplanta(p);
		php.setPraga_idpraga(pr);

		Planta_has_pragaDAO dao = new Planta_has_pragaDAO();
		dao.inserir(php);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Planta_has_praga pp = new Planta_has_praga();
		Planta p = new Planta();
		
		p.setIdplanta(5L);
		
		pp.setPlanta_idplanta(p);

		Planta_has_pragaDAO dao = new Planta_has_pragaDAO();

		dao.excluir(pp);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Planta_has_praga php = new Planta_has_praga();
		Planta p = new Planta();
		Praga pr = new Praga();
				
		p.setIdplanta(2L);
		pr.setIdpraga(2L);
		
		php.setPlanta_idplanta(p);
		php.setPraga_idpraga(pr);

				
		Planta_has_pragaDAO dao = new Planta_has_pragaDAO();
		dao.atualizar(php);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		Planta_has_pragaDAO dao = new Planta_has_pragaDAO();
		
		ArrayList<Planta_has_praga> lista = dao.listar();
		
		for(Planta_has_praga pp : lista){
			
			System.out.println("\nID Planta: "+pp.getPlanta_idplanta().getIdplanta());
			System.out.println("Nome: "+pp.getPlanta_idplanta().getNome());
			System.out.println("Tmin: "+pp.getPlanta_idplanta().getTmin());
			System.out.println("Tmax: "+pp.getPlanta_idplanta().getTmax());
			System.out.println("Tot: "+pp.getPlanta_idplanta().getTot());
			System.out.println("Ic: "+pp.getPlanta_idplanta().getIc());
			System.out.println("Uc: "+pp.getPlanta_idplanta().getUc());
		
			System.out.println("\nID Tipo Praga: "+pp.getPraga_idpraga().getIdpraga());
			System.out.println("Nome: "+pp.getPraga_idpraga().getNome());
			System.out.println("TB: "+pp.getPraga_idpraga().getTb());
			System.out.println("TC: "+pp.getPraga_idpraga().getCt());
			
			System.out.println("\n********** ********** **********");
		}
	}

	
	@Test
	@Ignore
	public void listarPorIdplanta() throws SQLException {

		Planta_has_praga php = new Planta_has_praga();
		Planta p = new Planta();
		
		p.setIdplanta(3L);
		php.setPlanta_idplanta(p);
		
		Planta_has_pragaDAO dao = new Planta_has_pragaDAO();

		ArrayList<Planta_has_praga> lista = dao.listarPorIdplanta(php);

		for(Planta_has_praga pp : lista){
			
			System.out.println("\nID Planta: "+pp.getPlanta_idplanta().getIdplanta());
			System.out.println("Nome: "+pp.getPlanta_idplanta().getNome());
			System.out.println("Tmin: "+pp.getPlanta_idplanta().getTmin());
			System.out.println("Tmax: "+pp.getPlanta_idplanta().getTmax());
			System.out.println("Tot: "+pp.getPlanta_idplanta().getTot());
			System.out.println("Ic: "+pp.getPlanta_idplanta().getIc());
			System.out.println("Uc: "+pp.getPlanta_idplanta().getUc());
		
			System.out.println("\nID Tipo Praga: "+pp.getPraga_idpraga().getIdpraga());
			System.out.println("Nome: "+pp.getPraga_idpraga().getNome());
			System.out.println("TB: "+pp.getPraga_idpraga().getTb());
			System.out.println("TC: "+pp.getPraga_idpraga().getCt());
						
			System.out.println("\n********** ********** **********");	
		}
	}

	@Test
	@Ignore
	public void listarPorIdpraga() throws SQLException {

		Planta_has_praga php = new Planta_has_praga();
		Praga pr = new Praga();
		
		pr.setIdpraga(3L);
		php.setPraga_idpraga(pr);
		
		Planta_has_pragaDAO dao = new Planta_has_pragaDAO();

		ArrayList<Planta_has_praga> lista = dao.listarPorIdpraga(php);

		for(Planta_has_praga pp : lista){
			
			System.out.println("\nID Planta: "+pp.getPlanta_idplanta().getIdplanta());
			System.out.println("Nome: "+pp.getPlanta_idplanta().getNome());
			System.out.println("Tmin: "+pp.getPlanta_idplanta().getTmin());
			System.out.println("Tmax: "+pp.getPlanta_idplanta().getTmax());
			System.out.println("Tot: "+pp.getPlanta_idplanta().getTot());
			System.out.println("Ic: "+pp.getPlanta_idplanta().getIc());
			System.out.println("Uc: "+pp.getPlanta_idplanta().getUc());
		
			System.out.println("\nID Tipo Praga: "+pp.getPraga_idpraga().getIdpraga());
			System.out.println("Nome: "+pp.getPraga_idpraga().getNome());
			System.out.println("TB: "+pp.getPraga_idpraga().getTb());
			System.out.println("TC: "+pp.getPraga_idpraga().getCt());
			
			System.out.println("\n********** ********** **********");	
			}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		
		Planta_has_praga php = new Planta_has_praga();
		Planta p = new Planta();
		
		p.setIdplanta(3L);
		php.setPlanta_idplanta(p);
		
		Planta_has_pragaDAO dao = new Planta_has_pragaDAO();
		

		Planta_has_praga pp = dao.pesquisar(php);

		System.out.println("\nID Planta: "+pp.getPlanta_idplanta().getIdplanta());
		System.out.println("Nome: "+pp.getPlanta_idplanta().getNome());
		System.out.println("Tmin: "+pp.getPlanta_idplanta().getTmin());
		System.out.println("Tmax: "+pp.getPlanta_idplanta().getTmax());
		System.out.println("Tot: "+pp.getPlanta_idplanta().getTot());
		System.out.println("Ic: "+pp.getPlanta_idplanta().getIc());
		System.out.println("Uc: "+pp.getPlanta_idplanta().getUc());
	
		System.out.println("\nID Tipo Praga: "+pp.getPraga_idpraga().getIdpraga());
		System.out.println("Nome: "+pp.getPraga_idpraga().getNome());
		System.out.println("TB: "+pp.getPraga_idpraga().getTb());
		System.out.println("TC: "+pp.getPraga_idpraga().getCt());
											
		System.out.println("\n********** ********** **********");	
	}
}