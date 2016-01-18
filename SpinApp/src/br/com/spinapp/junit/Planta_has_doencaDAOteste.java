package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.Planta_has_doencaDAO;
import br.com.spinapp.domain.Planta_has_doenca;
import br.com.spinapp.domain.Doenca;
import br.com.spinapp.domain.Planta;


public class Planta_has_doencaDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {
		
		Planta_has_doenca pd = new Planta_has_doenca();

		
		Planta p = new Planta();
		Doenca d = new Doenca();
		
		p.setIdplanta(3L);
		d.setIddoenca(1L);
		
		pd.setPlanta_idplanta(p);
		pd.setDoenca_iddoenca(d);

		Planta_has_doencaDAO dao = new Planta_has_doencaDAO();
		dao.inserir(pd);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Planta_has_doenca pd = new Planta_has_doenca();
		Planta p = new Planta();
		
		p.setIdplanta(5L);
		
		pd.setPlanta_idplanta(p);

		Planta_has_doencaDAO dao = new Planta_has_doencaDAO();

		dao.excluir(pd);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Planta_has_doenca pd = new Planta_has_doenca();
		Planta p = new Planta();
		Doenca d = new Doenca();
				
		p.setIdplanta(2L);
		d.setIddoenca(2L);
		
		pd.setPlanta_idplanta(p);
		pd.setDoenca_iddoenca(d);

				
		Planta_has_doencaDAO dao = new Planta_has_doencaDAO();
		dao.atualizar(pd);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		Planta_has_doencaDAO dao = new Planta_has_doencaDAO();
		
		ArrayList<Planta_has_doenca> lista = dao.listar();
		
		for(Planta_has_doenca pd : lista){
			
			System.out.println("\nID Planta: "+pd.getPlanta_idplanta().getIdplanta());
			System.out.println("Nome: "+pd.getPlanta_idplanta().getNome());
			System.out.println("Tmin: "+pd.getPlanta_idplanta().getTmin());
			System.out.println("Tmax: "+pd.getPlanta_idplanta().getTmax());
			System.out.println("Tot: "+pd.getPlanta_idplanta().getTot());
			System.out.println("Ic: "+pd.getPlanta_idplanta().getIc());
			System.out.println("Uc: "+pd.getPlanta_idplanta().getUc());
		
			System.out.println("\nID Tipo Doenca: "+pd.getDoenca_iddoenca().getIddoenca());
			System.out.println("Nome: "+pd.getDoenca_iddoenca().getNome());
			System.out.println("Reino: "+pd.getDoenca_iddoenca().getReino());
			System.out.println("TB: "+pd.getDoenca_iddoenca().getTb());
			System.out.println("TC: "+pd.getDoenca_iddoenca().getTc());
			
			System.out.println("\n********** ********** **********");
		}
	}

	
	@Test
	@Ignore
	public void listarPorIdplanta() throws SQLException {

		Planta_has_doenca phd = new Planta_has_doenca();
		Planta p = new Planta();
		
		p.setIdplanta(3L);
		phd.setPlanta_idplanta(p);
		
		Planta_has_doencaDAO dao = new Planta_has_doencaDAO();

		ArrayList<Planta_has_doenca> lista = dao.listarPorIdplanta(phd);

		for(Planta_has_doenca pd : lista){
			
			System.out.println("\nID Planta: "+pd.getPlanta_idplanta().getIdplanta());
			System.out.println("Nome: "+pd.getPlanta_idplanta().getNome());
			System.out.println("Tmin: "+pd.getPlanta_idplanta().getTmin());
			System.out.println("Tmax: "+pd.getPlanta_idplanta().getTmax());
			System.out.println("Tot: "+pd.getPlanta_idplanta().getTot());
			System.out.println("Ic: "+pd.getPlanta_idplanta().getIc());
			System.out.println("Uc: "+pd.getPlanta_idplanta().getUc());
		
			System.out.println("\nID Tipo Doenca: "+pd.getDoenca_iddoenca().getIddoenca());
			System.out.println("Nome: "+pd.getDoenca_iddoenca().getNome());
			System.out.println("Reino: "+pd.getDoenca_iddoenca().getReino());
			System.out.println("TB: "+pd.getDoenca_iddoenca().getTb());
			System.out.println("TC: "+pd.getDoenca_iddoenca().getTc());
						
			System.out.println("\n********** ********** **********");	
		}
	}

	@Test
	@Ignore
	public void listarPorIddoenca() throws SQLException {

		Planta_has_doenca phd = new Planta_has_doenca();
		Doenca d = new Doenca();
		
		d.setIddoenca(3L);
		phd.setDoenca_iddoenca(d);
		
		Planta_has_doencaDAO dao = new Planta_has_doencaDAO();

		ArrayList<Planta_has_doenca> lista = dao.listarPorIddoenca(phd);

		for(Planta_has_doenca pd : lista){
			
			System.out.println("\nID Planta: "+pd.getPlanta_idplanta().getIdplanta());
			System.out.println("Nome: "+pd.getPlanta_idplanta().getNome());
			System.out.println("Tmin: "+pd.getPlanta_idplanta().getTmin());
			System.out.println("Tmax: "+pd.getPlanta_idplanta().getTmax());
			System.out.println("Tot: "+pd.getPlanta_idplanta().getTot());
			System.out.println("Ic: "+pd.getPlanta_idplanta().getIc());
			System.out.println("Uc: "+pd.getPlanta_idplanta().getUc());
		
			System.out.println("\nID Tipo Doenca: "+pd.getDoenca_iddoenca().getIddoenca());
			System.out.println("Nome: "+pd.getDoenca_iddoenca().getNome());
			System.out.println("Reino: "+pd.getDoenca_iddoenca().getReino());
			System.out.println("TB: "+pd.getDoenca_iddoenca().getTb());
			System.out.println("TC: "+pd.getDoenca_iddoenca().getTc());
									
			System.out.println("\n********** ********** **********");	
			}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		
		Planta_has_doenca phd = new Planta_has_doenca();
		Planta p = new Planta();
		
		p.setIdplanta(3L);
		phd.setPlanta_idplanta(p);
		
		Planta_has_doencaDAO dao = new Planta_has_doencaDAO();
		

		Planta_has_doenca pd = dao.pesquisar(phd);

		System.out.println("\nID Planta: "+pd.getPlanta_idplanta().getIdplanta());
		System.out.println("Nome: "+pd.getPlanta_idplanta().getNome());
		System.out.println("Tmin: "+pd.getPlanta_idplanta().getTmin());
		System.out.println("Tmax: "+pd.getPlanta_idplanta().getTmax());
		System.out.println("Tot: "+pd.getPlanta_idplanta().getTot());
		System.out.println("Ic: "+pd.getPlanta_idplanta().getIc());
		System.out.println("Uc: "+pd.getPlanta_idplanta().getUc());
	
		System.out.println("\nID Tipo Doenca: "+pd.getDoenca_iddoenca().getIddoenca());
		System.out.println("Nome: "+pd.getDoenca_iddoenca().getNome());
		System.out.println("Reino: "+pd.getDoenca_iddoenca().getReino());
		System.out.println("TB: "+pd.getDoenca_iddoenca().getTb());
		System.out.println("TC: "+pd.getDoenca_iddoenca().getTc());
									
		System.out.println("\n********** ********** **********");	
	}
}