package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Equipamento;
import br.com.spinapp.domain.Modelo;
import br.com.spinapp.domain.Serverpin;
import br.com.spinapp.factory.ConexaoFactory;

public class EquipamentoDAO {
	
	public void inserir(Equipamento e) throws SQLException {

		StringBuilder sql = new StringBuilder();// para concatenação
		sql.append(" INSERT INTO spin1.equipamento ");// append juntar
		sql.append(" (mac, latitude, longitude, altitude, serverpin_idserver, modelo_idmodelo) ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?) ");

		// conexão com BD
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		comando.setString(1, e.getMac());
		comando.setFloat(2, e.getLatitude());
		comando.setFloat(3, e.getLongitude());
		comando.setFloat(4, e.getAltitude());
		comando.setLong(5, e.getServerpin_idserver().getIdserver());
		comando.setLong(6, e.getModelo_idmodelo().getIdmodelo());
		
		comando.executeUpdate();
	}

	public void excluir(Equipamento e) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM spin1.equipamento ");
		sql.append(" WHERE idequip = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, e.getIdequip());

		comando.executeUpdate();

	}

	public void atualizar(Equipamento e) throws SQLException {

		
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE spin1.equipamento ");
		sql.append(" SET mac = ?, latitude = ?, longitude = ?, altitude = ?, serverpin_idserver = ?, modelo_idmodelo = ? ");
		sql.append(" WHERE idequip = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setString(1, e.getMac());
		comando.setFloat(2, e.getLatitude());
		comando.setFloat(3, e.getLongitude());
		comando.setFloat(4, e.getAltitude());
		comando.setLong(5, e.getServerpin_idserver().getIdserver());
		comando.setLong(6, e.getModelo_idmodelo().getIdmodelo());
		comando.setLong(7, e.getIdequip());
		
		comando.executeUpdate();
	}

	public ArrayList<Equipamento> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT e.idequip, e.mac, e.latitude, e.longitude, e.altitude, s.idserver, s.ip, s.mac, s.porta, s.latitude, s.longitude, s.altitude, s.gsm, m.idmodelo, m.descricao ");
		sql.append(" FROM spin1.equipamento e ");
		sql.append(" INNER JOIN spin1.serverpin s ON s.idserver = e.serverpin_idserver ");
		sql.append(" INNER JOIN spin1.modelo m ON m.idmodelo = e.modelo_idmodelo ");
		//sql.append("ORDER BY tipo ASC ");// Ordenação implementar na tela jsf

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Equipamento> lista = new ArrayList<Equipamento>();

		while (resultado.next()) {

			Equipamento e = new Equipamento();
			Serverpin s = new Serverpin();
			Modelo m = new Modelo();
			
			
			e.setIdequip(resultado.getLong("e.idequip"));
			e.setMac(resultado.getString("e.mac"));
			e.setLatitude(resultado.getFloat("e.latitude"));
			e.setLongitude(resultado.getFloat("e.longitude"));
			e.setAltitude(resultado.getFloat("e.altitude"));
			
			s.setIdserver(resultado.getLong("s.idserver"));
			s.setIp(resultado.getString("s.ip"));
			s.setMac(resultado.getString("s.mac"));
			s.setPorta(resultado.getInt("s.porta"));
			s.setLatitude(resultado.getFloat("s.latitude"));
			s.setLongitude(resultado.getFloat("s.longitude"));
			s.setAltitude(resultado.getFloat("s.altitude"));
			s.setGsm(resultado.getString("s.gsm"));
			
			m.setIdmodelo(resultado.getLong("m.idmodelo"));
			m.setDescricao(resultado.getString("m.descricao"));

			e.setServerpin_idserver(s);
			e.setModelo_idmodelo(m);
	
			
			lista.add(e);

		}
		return lista;
	}

	public ArrayList<Equipamento> listarPorId(Equipamento eq) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT e.idequip, e.mac, e.latitude, e.longitude, e.altitude, s.idserver, s.ip, s.mac, s.porta, s.latitude, s.longitude, s.altitude, s.gsm, m.idmodelo, m.descricao ");
		sql.append(" FROM spin1.equipamento e ");
		sql.append(" INNER JOIN spin1.serverpin s ON s.idserver = e.serverpin_idserver ");
		sql.append(" INNER JOIN spin1.modelo m ON m.idmodelo = e.modelo_idmodelo ");
		sql.append(" WHERE e.idequip = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, eq.getIdequip());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Equipamento> lista = new ArrayList<Equipamento>();

		while (resultado.next()) {

			Equipamento e = new Equipamento();
			Serverpin s = new Serverpin();
			Modelo m = new Modelo();
			
			
			e.setIdequip(resultado.getLong("e.idequip"));
			e.setMac(resultado.getString("e.mac"));
			e.setLatitude(resultado.getFloat("e.latitude"));
			e.setLongitude(resultado.getFloat("e.longitude"));
			e.setAltitude(resultado.getFloat("e.altitude"));
			
			s.setIdserver(resultado.getLong("s.idserver"));
			s.setIp(resultado.getString("s.ip"));
			s.setMac(resultado.getString("s.mac"));
			s.setPorta(resultado.getInt("s.porta"));
			s.setLatitude(resultado.getFloat("s.latitude"));
			s.setLongitude(resultado.getFloat("s.longitude"));
			s.setAltitude(resultado.getFloat("s.altitude"));
			s.setGsm(resultado.getString("s.gsm"));
			
			m.setIdmodelo(resultado.getLong("m.idmodelo"));
			m.setDescricao(resultado.getString("m.descricao"));

			e.setServerpin_idserver(s);
			e.setModelo_idmodelo(m);	
			
			lista.add(e);

		}
		return lista;
	}

	public ArrayList<Equipamento> listarPorIdserver(Equipamento eq) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT e.idequip, e.mac, e.latitude, e.longitude, e.altitude, s.idserver, s.ip, s.mac, s.porta, s.latitude, s.longitude, s.altitude, s.gsm, m.idmodelo, m.descricao ");
		sql.append(" FROM spin1.equipamento e ");
		sql.append(" INNER JOIN spin1.serverpin s ON s.idserver = e.serverpin_idserver ");
		sql.append(" INNER JOIN spin1.modelo m ON m.idmodelo = e.modelo_idmodelo ");
		sql.append(" WHERE s.idserver = ? ");


		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, eq.getServerpin_idserver().getIdserver());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Equipamento> lista = new ArrayList<Equipamento>();

		while (resultado.next()) {

			Equipamento e = new Equipamento();
			Serverpin s = new Serverpin();
			Modelo m = new Modelo();
			
			
			e.setIdequip(resultado.getLong("e.idequip"));
			e.setMac(resultado.getString("e.mac"));
			e.setLatitude(resultado.getFloat("e.latitude"));
			e.setLongitude(resultado.getFloat("e.longitude"));
			e.setAltitude(resultado.getFloat("e.altitude"));
			
			s.setIdserver(resultado.getLong("s.idserver"));
			s.setIp(resultado.getString("s.ip"));
			s.setMac(resultado.getString("s.mac"));
			s.setPorta(resultado.getInt("s.porta"));
			s.setLatitude(resultado.getFloat("s.latitude"));
			s.setLongitude(resultado.getFloat("s.longitude"));
			s.setAltitude(resultado.getFloat("s.altitude"));
			s.setGsm(resultado.getString("s.gsm"));
			
			m.setIdmodelo(resultado.getLong("m.idmodelo"));
			m.setDescricao(resultado.getString("m.descricao"));

			e.setServerpin_idserver(s);
			e.setModelo_idmodelo(m);	
			
			lista.add(e);
		}
		return lista;
	}

	public Equipamento pesquisar(Equipamento eq) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT e.idequip, e.mac, e.latitude, e.longitude, e.altitude, s.idserver, s.ip, s.mac, s.porta, s.latitude, s.longitude, s.altitude, s.gsm, m.idmodelo, m.descricao ");
		sql.append(" FROM spin1.equipamento e ");
		sql.append(" INNER JOIN spin1.serverpin s ON s.idserver = e.serverpin_idserver ");
		sql.append(" INNER JOIN spin1.modelo m ON m.idmodelo = e.modelo_idmodelo ");
		sql.append(" WHERE e.idequip = ? ");
		
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				 
																				 
		comando.setLong(1, eq.getIdequip());

		ResultSet resultado = comando.executeQuery();

		Equipamento retorno = null;

		if (resultado.next()) {

			retorno = new Equipamento();
			Serverpin s = new Serverpin();
			Modelo m = new Modelo();
			
			
			retorno.setIdequip(resultado.getLong("e.idequip"));
			retorno.setMac(resultado.getString("e.mac"));
			retorno.setLatitude(resultado.getFloat("e.latitude"));
			retorno.setLongitude(resultado.getFloat("e.longitude"));
			retorno.setAltitude(resultado.getFloat("e.altitude"));
			
			s.setIdserver(resultado.getLong("s.idserver"));
			s.setIp(resultado.getString("s.ip"));
			s.setMac(resultado.getString("s.mac"));
			s.setPorta(resultado.getInt("s.porta"));
			s.setLatitude(resultado.getFloat("s.latitude"));
			s.setLongitude(resultado.getFloat("s.longitude"));
			s.setAltitude(resultado.getFloat("s.altitude"));
			s.setGsm(resultado.getString("s.gsm"));
			
			m.setIdmodelo(resultado.getLong("m.idmodelo"));
			m.setDescricao(resultado.getString("m.descricao"));

			retorno.setServerpin_idserver(s);
			retorno.setModelo_idmodelo(m);	
			
		}

		return retorno;
	}
}