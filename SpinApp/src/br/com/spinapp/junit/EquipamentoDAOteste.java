package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.EquipamentoDAO;
import br.com.spinapp.domain.Equipamento;
import br.com.spinapp.domain.Modelo;
import br.com.spinapp.domain.Serverpin;

public class EquipamentoDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {

		Equipamento e = new Equipamento();

		e.setMac("23f");
		e.setLatitude(40F);
		e.setLongitude(30F);
		e.setAltitude(30F);
		
		Serverpin s = new Serverpin();
		Modelo m = new Modelo();
		
		s.setIdserver(30L);
		m.setIdmodelo(1L);
		
		e.setServerpin_idserver(s);
		e.setModelo_idmodelo(m);


		EquipamentoDAO dao = new EquipamentoDAO();
		
		dao.inserir(e);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Equipamento e = new Equipamento();
		e.setIdequip(2L);

		EquipamentoDAO dao = new EquipamentoDAO();

		dao.excluir(e);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Equipamento e = new Equipamento();

		e.setIdequip(2L);
		e.setMac("23f");
		e.setLatitude(40F);
		e.setLongitude(30F);
		e.setAltitude(30F);
		
		Serverpin s = new Serverpin();
		Modelo m = new Modelo();
		
		s.setIdserver(23L);
		m.setIdmodelo(2L);
		
		e.setServerpin_idserver(s);
		e.setModelo_idmodelo(m);


		EquipamentoDAO dao = new EquipamentoDAO();
		dao.inserir(e);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		EquipamentoDAO dao = new EquipamentoDAO();
		
		ArrayList<Equipamento> lista = dao.listar();
		
		for(Equipamento e : lista){
			
			
			System.out.println("\nID equipamento: "+e.getIdequip());
			System.out.println("\nID Mac: "+e.getMac());
			System.out.println("Latitude: "+e.getLatitude());
			System.out.println("Longitude: "+e.getLongitude());
			System.out.println("Altitude: "+e.getAltitude());
			
			System.out.println("\nID cliente: "+e.getServerpin_idserver().getIdserver());
			System.out.println("IP: "+e.getServerpin_idserver().getIp());
			System.out.println("Mac: "+e.getServerpin_idserver().getMac());
			System.out.println("Porta: "+e.getServerpin_idserver().getPorta());
			System.out.println("Latitude: "+e.getServerpin_idserver().getLatitude());
			System.out.println("Longitude: "+e.getServerpin_idserver().getLongitude());
			System.out.println("Altitude: "+e.getServerpin_idserver().getAltitude());
			System.out.println("GSM: "+e.getServerpin_idserver().getGsm());
			
			System.out.println("\nID modelo: "+e.getModelo_idmodelo().getIdmodelo());
			System.out.println("Descrição: "+e.getModelo_idmodelo().getDescricao());
			
			System.out.println("\n********** ********** **********");
		}
	}

	
	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Equipamento eq = new Equipamento();

		eq.setIdequip(3L);

		EquipamentoDAO adao = new EquipamentoDAO();

		ArrayList<Equipamento> lista = adao.listarPorId(eq);

		for(Equipamento e : lista){
			
			
			System.out.println("\nID equipamento: "+e.getIdequip());
			System.out.println("\nID Mac: "+e.getMac());
			System.out.println("Latitude: "+e.getLatitude());
			System.out.println("Longitude: "+e.getLongitude());
			System.out.println("Altitude: "+e.getAltitude());
			
			System.out.println("\nID cliente: "+e.getServerpin_idserver().getIdserver());
			System.out.println("IP: "+e.getServerpin_idserver().getIp());
			System.out.println("Mac: "+e.getServerpin_idserver().getMac());
			System.out.println("Porta: "+e.getServerpin_idserver().getPorta());
			System.out.println("Latitude: "+e.getServerpin_idserver().getLatitude());
			System.out.println("Longitude: "+e.getServerpin_idserver().getLongitude());
			System.out.println("Altitude: "+e.getServerpin_idserver().getAltitude());
			System.out.println("GSM: "+e.getServerpin_idserver().getGsm());
			
			System.out.println("\nID modelo: "+e.getModelo_idmodelo().getIdmodelo());
			System.out.println("Descrição: "+e.getModelo_idmodelo().getDescricao());
			
			System.out.println("\n********** ********** **********");	
		}
	}

	@Test
	@Ignore
	public void listarPorIdserver() throws SQLException {

		Equipamento eq = new Equipamento();
		Serverpin s = new Serverpin();
		
		s.setIdserver(3L);
		eq.setServerpin_idserver(s);
		
		EquipamentoDAO dao = new EquipamentoDAO();

		ArrayList<Equipamento> lista = dao.listarPorIdserver(eq);

		for(Equipamento e : lista){
			
			
			System.out.println("\nID equipamento: "+e.getIdequip());
			System.out.println("\nID Mac: "+e.getMac());
			System.out.println("Latitude: "+e.getLatitude());
			System.out.println("Longitude: "+e.getLongitude());
			System.out.println("Altitude: "+e.getAltitude());
			
			System.out.println("\nID cliente: "+e.getServerpin_idserver().getIdserver());
			System.out.println("IP: "+e.getServerpin_idserver().getIp());
			System.out.println("Mac: "+e.getServerpin_idserver().getMac());
			System.out.println("Porta: "+e.getServerpin_idserver().getPorta());
			System.out.println("Latitude: "+e.getServerpin_idserver().getLatitude());
			System.out.println("Longitude: "+e.getServerpin_idserver().getLongitude());
			System.out.println("Altitude: "+e.getServerpin_idserver().getAltitude());
			System.out.println("GSM: "+e.getServerpin_idserver().getGsm());
			
			System.out.println("\nID modelo: "+e.getModelo_idmodelo().getIdmodelo());
			System.out.println("Descrição: "+e.getModelo_idmodelo().getDescricao());
						
			System.out.println("\n********** ********** **********");	
		}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		Equipamento eq = new Equipamento();

		eq.setIdequip(1l);

		EquipamentoDAO dao = new EquipamentoDAO();

		Equipamento e = dao.pesquisar(eq);

		
		System.out.println("\nID equipamento: "+e.getIdequip());
		System.out.println("\nID Mac: "+e.getMac());
		System.out.println("Latitude: "+e.getLatitude());
		System.out.println("Longitude: "+e.getLongitude());
		System.out.println("Altitude: "+e.getAltitude());
		
		System.out.println("\nID cliente: "+e.getServerpin_idserver().getIdserver());
		System.out.println("IP: "+e.getServerpin_idserver().getIp());
		System.out.println("Mac: "+e.getServerpin_idserver().getMac());
		System.out.println("Porta: "+e.getServerpin_idserver().getPorta());
		System.out.println("Latitude: "+e.getServerpin_idserver().getLatitude());
		System.out.println("Longitude: "+e.getServerpin_idserver().getLongitude());
		System.out.println("Altitude: "+e.getServerpin_idserver().getAltitude());
		System.out.println("GSM: "+e.getServerpin_idserver().getGsm());
		
		System.out.println("\nID modelo: "+e.getModelo_idmodelo().getIdmodelo());
		System.out.println("Descrição: "+e.getModelo_idmodelo().getDescricao());
							
		System.out.println("\n********** ********** **********");	
	}
}