package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.dao.SensorDAO;
import br.com.spinapp.domain.Equipamento;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.domain.TipoSensor;


public class SensorDAOteste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {
		Sensor s = new Sensor();

		
		Equipamento e = new Equipamento();
		TipoSensor ts = new TipoSensor();
		
		e.setIdequip(3L);
		ts.setIdtipo(1L);
		
		s.setEquipamento_idequip(e);
		s.setTiposensor_idtipo(ts);


		SensorDAO dao = new SensorDAO();
		dao.inserir(s);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {

		Sensor s = new Sensor();
		s.setIdsensor(5l);

		SensorDAO dao = new SensorDAO();

		dao.excluir(s);
	}

	@Test
	@Ignore
	public void atualizar() throws SQLException, ParseException {

		Sensor s = new Sensor();


		s.setIdsensor(7L);

		Equipamento e = new Equipamento();
		TipoSensor ts = new TipoSensor();
		
		e.setIdequip(3L);
		ts.setIdtipo(3L);
		
		s.setEquipamento_idequip(e);
		s.setTiposensor_idtipo(ts);
				
		SensorDAO dao = new SensorDAO();
		dao.atualizar(s);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		SensorDAO dao = new SensorDAO();
		
		ArrayList<Sensor> lista = dao.listar();
		
		for(Sensor s : lista){
			
			
			System.out.println("\nID Sensor: "+s.getIdsensor());
			
			System.out.println("\nID Equipamento: "+s.getEquipamento_idequip().getIdequip());
		
			System.out.println("\nID Tipo do Sensor: "+s.getTiposensor_idtipo().getIdtipo());
			
			System.out.println("\n********** ********** **********");
		}
	}

	
	@Test
	@Ignore
	public void listarPorId() throws SQLException {

		Sensor se = new Sensor();

		se.setIdsensor(3L);

		SensorDAO dao = new SensorDAO();

		ArrayList<Sensor> lista = dao.listarPorId(se);

		for(Sensor s : lista){
			
			System.out.println("\nID Sensor: "+s.getIdsensor());
			
			System.out.println("\nID Equipamento: "+s.getEquipamento_idequip().getIdequip());
		
			System.out.println("\nID Tipo do Sensor: "+s.getTiposensor_idtipo().getIdtipo());
			
			System.out.println("\n********** ********** **********");	
		}
	}

	@Test
	@Ignore
	public void listarPorIDequipamento() throws SQLException {

		Sensor se = new Sensor();
		Equipamento e = new Equipamento();
		
		e.setIdequip(3L);
		se.setEquipamento_idequip(e);
		
		SensorDAO dao = new SensorDAO();

		ArrayList<Sensor> lista = dao.listarPorIdequipamento(se);

		for(Sensor s : lista){
			
			System.out.println("\nID Sensor: "+s.getIdsensor());
			
			System.out.println("\nID Equipamento: "+s.getEquipamento_idequip().getIdequip());
		
			System.out.println("\nID Tipo do Sensor: "+s.getTiposensor_idtipo().getIdtipo());
						
			System.out.println("\n********** ********** **********");	
			}
	}

	@Test
	@Ignore
	public void pesquisar() throws SQLException {
		
		Sensor se = new Sensor();

		se.setIdsensor(2L);

		SensorDAO dao = new SensorDAO();

		Sensor s = dao.pesquisar(se);

		System.out.println("\nID Sensor: "+s.getIdsensor());
		
		System.out.println("\nID Equipamento: "+s.getEquipamento_idequip().getIdequip());
	
		System.out.println("\nID Tipo do Sensor: "+s.getTiposensor_idtipo().getIdtipo());
							
		System.out.println("\n********** ********** **********");	
	}
}