package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.HistoricoDAO;
import br.com.spinapp.domain.Historico;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.domain.TipoSensor;

public class HistoricoDAOteste {
	
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {

		Historico h = new Historico();

		SimpleDateFormat databr = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timebr = new SimpleDateFormat("HH:mm:ss");
		
		Date d1 = databr.parse("2014-10-10");
		Date d2 = timebr.parse("20:10:02");

		h.setData(d1);// para o banco tem que mandar Date
		h.setHora(d2);
		h.setValor(20F);
		
		Sensor s = new Sensor();
		
		s.setIdsensor(3L);
		
		h.setSensor_idsensor(s);

		HistoricoDAO dao = new HistoricoDAO();
		dao.inserir(h);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Historico h = new Historico();
		h.setIdhistorico(5l);

		HistoricoDAO dao = new HistoricoDAO();

		dao.excluir(h);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Historico h = new Historico();

		
		SimpleDateFormat databr = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timebr = new SimpleDateFormat("HH:mm:ss");
		
		Date d1 = databr.parse("2014-10-10");
		Date d2 = timebr.parse("12:15:02");


		h.setIdhistorico(3L);
		h.setData(d1);// para o banco tem que mandar Date
		h.setHora(d2);
		h.setValor(15F);
		
		Sensor s = new Sensor();
		
		s.setIdsensor(3L);
		
		h.setSensor_idsensor(s);
				
		HistoricoDAO dao = new HistoricoDAO();
		dao.atualizar(h);
	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		HistoricoDAO dao = new HistoricoDAO();
		
		ArrayList<Historico> lista = dao.listar();
		
		for(Historico h : lista){
			
			
			System.out.println("\nID leitura: "+h.getIdhistorico());
			System.out.println("Data: "+h.getData());
			System.out.println("Hora: "+h.getHora());
			System.out.println("Valor: "+h.getValor());
			
			System.out.println("\nID Sensor: "+h.getSensor_idsensor().getIdsensor());
			
			System.out.println("\n********** ********** **********");
		}
	}

	
	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Historico hi = new Historico();

		hi.setIdhistorico(3L);

		HistoricoDAO adao = new HistoricoDAO();

		ArrayList<Historico> lista = adao.listarPorId(hi);

		for(Historico h : lista){
			
			System.out.println("\nID leitura: "+h.getIdhistorico());
			System.out.println("Data: "+h.getData());
			System.out.println("Hora: "+h.getHora());
			System.out.println("Valor: "+h.getValor());
			
			System.out.println("\nID Sensor: "+h.getSensor_idsensor().getIdsensor());
						
			System.out.println("\n********** ********** **********");	
		}
	}
	
	@Test
	
	public void listarTipoSensor() throws SQLException {

		Historico hi = new Historico();
		Sensor s = new Sensor();
		TipoSensor tp = new TipoSensor();
		
		tp.setIdtipo(3L);
		s.setTiposensor_idtipo(tp);
		hi.setSensor_idsensor(s);
		
		HistoricoDAO adao = new HistoricoDAO();
		
		ArrayList<Historico> lista = adao.listarTipoSensor(hi);

		for(Historico h : lista){
			
			System.out.println("\nID leitura: "+h.getIdhistorico());
			System.out.println("Data: "+h.getData());
			System.out.println("Hora: "+h.getHora());
			System.out.println("Valor: "+h.getValor());
			System.out.println("Valor: "+h.getSensor_idsensor());
			
			System.out.println("\nID Sensor: "+h.getSensor_idsensor().getIdsensor());
			System.out.println("ID Equipamento: "+h.getSensor_idsensor().getEquipamento_idequip());
			System.out.println("ID TipoSensor: "+h.getSensor_idsensor().getTiposensor_idtipo());
			
			System.out.println("\nID Tipo: "+h.getSensor_idsensor().getTiposensor_idtipo().getIdtipo());
			System.out.println("Descricao: "+h.getSensor_idsensor().getTiposensor_idtipo().getDescricao());
			System.out.println("Unidade: "+h.getSensor_idsensor().getTiposensor_idtipo().getUnidade());
			
			System.out.println("\n********** ********** **********");	
		}
	}

	@Test
	@Ignore
	public void listarPorIdsensor() throws SQLException {

		Historico hi = new Historico();
		Sensor s = new Sensor();
		
		s.setIdsensor(3L);
		hi.setSensor_idsensor(s);
		
		HistoricoDAO dao = new HistoricoDAO();

		ArrayList<Historico> lista = dao.listarPorIdsensor(hi);

		for(Historico h : lista){
			
			System.out.println("\nID leitura: "+h.getIdhistorico());
			System.out.println("Data: "+h.getData());
			System.out.println("Hora: "+h.getHora());
			System.out.println("Valor: "+h.getValor());
			
			System.out.println("\nID Sensor: "+h.getSensor_idsensor().getIdsensor());
			
			System.out.println("\n********** ********** **********");	
			}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		
		Historico hi = new Historico();

		hi.setIdhistorico(1l);

		HistoricoDAO dao = new HistoricoDAO();

		Historico h = dao.pesquisar(hi);

		System.out.println("\nID leitura: "+h.getIdhistorico());
		System.out.println("Data: "+h.getData());
		System.out.println("Hora: "+h.getHora());
		System.out.println("Valor: "+h.getValor());
		
		System.out.println("\nID Sensor: "+h.getSensor_idsensor().getIdsensor());
		
		System.out.println("\n********** ********** **********");	
	}
}