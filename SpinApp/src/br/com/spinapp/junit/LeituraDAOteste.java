package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.LeituraDAO;
import br.com.spinapp.domain.Leitura;
import br.com.spinapp.domain.Sensor;


public class LeituraDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {

		Leitura l = new Leitura();

		SimpleDateFormat databr = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timebr = new SimpleDateFormat("HH:mm:ss");
		
		Date d1 = databr.parse("2014-10-10");
		Date d2 = timebr.parse("20:10:02");

		l.setData(d1);// para o banco tem que mandar Date
		l.setHora(d2);
		l.setValor(20F);
		
		Sensor s = new Sensor();
		
		s.setIdsensor(3L);
		
		l.setSensor_idsensor(s);


		LeituraDAO dao = new LeituraDAO();
		dao.inserir(l);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Leitura l = new Leitura();
		l.setIdleitura(5l);

		LeituraDAO pdao = new LeituraDAO();

		pdao.excluir(l);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Leitura l = new Leitura();

		
		SimpleDateFormat databr = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timebr = new SimpleDateFormat("HH:mm:ss");
		
		Date d1 = databr.parse("2014-10-10");
		Date d2 = timebr.parse("12:15:02");


		l.setIdleitura(3L);
		l.setData(d1);// para o banco tem que mandar Date
		l.setHora(d2);
		l.setValor(15F);
		
		Sensor s = new Sensor();
		
		s.setIdsensor(3L);
		
		l.setSensor_idsensor(s);
				
		LeituraDAO pdao = new LeituraDAO();
		pdao.atualizar(l);

	}

	@Test
	
	public void listar() throws SQLException {

		LeituraDAO dao = new LeituraDAO();
		
		ArrayList<Leitura> lista = dao.listar();
		
		for(Leitura l : lista){
			
			
			System.out.println("\nID leitura: "+l.getIdleitura());
			System.out.println("Data: "+l.getData());
			System.out.println("Hora: "+l.getHora());
			System.out.println("Valor: "+l.getValor());
			
			System.out.println("\nID Sensor: "+l.getSensor_idsensor().getIdsensor());
			
			System.out.println("\n********** ********** **********");
		}
	}

	
	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Leitura le = new Leitura();

		le.setIdleitura(3L);

		LeituraDAO adao = new LeituraDAO();

		ArrayList<Leitura> lista = adao.listarPorId(le);

		for(Leitura l : lista){
			
			System.out.println("\nID leitura: "+l.getIdleitura());
			System.out.println("Data: "+l.getData());
			System.out.println("Hora: "+l.getHora());
			System.out.println("Valor: "+l.getValor());
			
			System.out.println("\nID Sensor: "+l.getSensor_idsensor().getIdsensor());
			
			System.out.println("\n********** ********** **********");	
		}
	}

	@Test
	@Ignore
	public void listarPorIDsensor() throws SQLException {

		Leitura le = new Leitura();
		Sensor s = new Sensor();
		
		s.setIdsensor(3L);
		le.setSensor_idsensor(s);
		
		LeituraDAO dao = new LeituraDAO();

		ArrayList<Leitura> lista = dao.listarPorIdsensor(le);

		for(Leitura l : lista){
			
			System.out.println("\nID leitura: "+l.getIdleitura());
			System.out.println("Data: "+l.getData());
			System.out.println("Hora: "+l.getHora());
			System.out.println("Valor: "+l.getValor());
			
			System.out.println("\nID Sensor: "+l.getSensor_idsensor().getIdsensor());
			
			System.out.println("\n********** ********** **********");	
			}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		Leitura le = new Leitura();

		le.setIdleitura(1l);

		LeituraDAO dao = new LeituraDAO();

		Leitura l = dao.pesquisar(le);

		System.out.println("\nID leitura: "+l.getIdleitura());
		System.out.println("Data: "+l.getData());
		System.out.println("Hora: "+l.getHora());
		System.out.println("Valor: "+l.getValor());
		
		System.out.println("\nID Sensor: "+l.getSensor_idsensor().getIdsensor());
		
		System.out.println("\n********** ********** **********");	
	}
}