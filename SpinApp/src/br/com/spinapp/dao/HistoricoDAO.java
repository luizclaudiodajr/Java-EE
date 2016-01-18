package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import br.com.spinapp.domain.Historico;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.domain.TipoSensor;
import br.com.spinapp.factory.ConexaoFactory;

public class HistoricoDAO {
	
	public void inserir(Historico h) throws SQLException {

		StringBuilder sql = new StringBuilder();// para concatenação
		sql.append(" INSERT INTO spin1.historico ");// append juntar
		sql.append(" (data, hora, valor, sensor_idsensor) ");
		sql.append(" VALUES (?, ?, ?, ?) ");

		// conexão com BD
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		

		Date sqlDate = new Date(h.getData().getTime());
		Time sqlTime = new Time(h.getHora().getTime());


		comando.setDate(1, sqlDate);
		comando.setTime(2, sqlTime);
		comando.setFloat(3, h.getValor());
		comando.setLong(4, h.getSensor_idsensor().getIdsensor());
		
		comando.executeUpdate();
	}

	public void excluir(Historico h) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM spin1.historico ");
		sql.append(" WHERE idhistorico = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, h.getIdhistorico());

		comando.executeUpdate();

	}

	public void atualizar(Historico h) throws SQLException {

		
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE spin1.historico ");
		sql.append(" SET data = ?, hora = ?, valor = ?, sensor_idsensor = ? ");
		sql.append(" WHERE idhistorico = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		

		Date sqlDate = new Date(h.getData().getTime());
		Time sqlTime = new Time(h.getHora().getTime());
		
		
		comando.setDate(1, sqlDate);
		comando.setTime(2, sqlTime);
		comando.setFloat(3, h.getValor());
		comando.setLong(4, h.getSensor_idsensor().getIdsensor());
		comando.setLong(5, h.getIdhistorico());

		comando.executeUpdate();
	}

	public ArrayList<Historico> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT h.idhistorico, h.data, h.hora, h.valor, s.idsensor, s.equipamento_idequip, s.tipo_sensor_idtipo ");
		sql.append(" FROM spin1.historico h ");
		sql.append(" INNER JOIN spin1.sensor s ON s.idsensor = h.sensor_idsensor ");
		sql.append(" ORDER BY h.data ASC, h.hora ASC ");// Ordenação implementar na tela jsf

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Historico> lista = new ArrayList<Historico>();

		while (resultado.next()) {

			Historico h = new Historico();
			Sensor s = new Sensor();
			
			
			h.setIdhistorico(resultado.getLong("h.idhistorico"));
			h.setData(resultado.getDate("h.data"));
			h.setHora(resultado.getTime("h.hora"));
			h.setValor(resultado.getFloat("h.valor"));
			
			s.setIdsensor(resultado.getLong("s.idsensor"));

			h.setSensor_idsensor(s);
			
			lista.add(h);

		}
		return lista;
	}

	public ArrayList<Historico> listarTipoSensor(Historico hi) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT h.idhistorico, h.data, h.hora, h.valor, h.sensor_idsensor, s.idsensor, s.equipamento_idequip, s.tipo_sensor_idtipo, t.idtipo, t.descricao, t.unidade ");
		sql.append(" FROM spin1.historico h ");
		sql.append(" INNER JOIN spin1.sensor s ON s.idsensor = h.sensor_idsensor ");
		sql.append(" INNER JOIN spin1.tipo_sensor t ON t.idtipo = s.tipo_sensor_idtipo ");
		sql.append(" WHERE t.idtipo = ? ");
		sql.append("ORDER BY h.data ASC, h.hora ASC ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, hi.getSensor_idsensor().getTiposensor_idtipo().getIdtipo());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Historico> lista = new ArrayList<Historico>();

		while (resultado.next()) {

			Historico h = new Historico();
			Sensor s = new Sensor();
			TipoSensor t = new TipoSensor();
			
			h.setIdhistorico(resultado.getLong("h.idhistorico"));
			h.setData(resultado.getDate("h.data"));
			h.setHora(resultado.getTime("h.hora"));
			h.setValor(resultado.getFloat("h.valor"));
			h.setIdhistorico(resultado.getLong("h.sensor_idsensor"));
			
			s.setIdsensor(resultado.getLong("s.idsensor"));
			s.setIdsensor(resultado.getLong("s.equipamento_idequip"));
			s.setIdsensor(resultado.getLong("s.tipo_sensor_idtipo"));

			t.setIdtipo(resultado.getLong("t.idtipo"));
			t.setDescricao(resultado.getString("t.descricao"));
			t.setUnidade(resultado.getString("t.unidade"));

			
			s.setTiposensor_idtipo(t);
			h.setSensor_idsensor(s);
			
			lista.add(h);

		}
		return lista;
	}
	
	
	public ArrayList<Historico> listarPorId(Historico hi) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT h.idhistorico, h.data, h.hora, h.valor, s.idsensor, s.equipamento_idequip, s.tipo_sensor_idtipo ");
		sql.append(" FROM spin1.historico h ");
		sql.append(" INNER JOIN spin1.sensor s ON s.idsensor = h.sensor_idsensor ");
		sql.append(" WHERE h.idhistorico = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, hi.getIdhistorico());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Historico> lista = new ArrayList<Historico>();

		while (resultado.next()) {

			Historico h = new Historico();
			Sensor s = new Sensor();
			
			
			h.setIdhistorico(resultado.getLong("h.idhistorico"));
			h.setData(resultado.getDate("h.data"));
			h.setHora(resultado.getTime("h.hora"));
			h.setValor(resultado.getFloat("h.valor"));
			
			s.setIdsensor(resultado.getLong("s.idsensor"));

			h.setSensor_idsensor(s);
			
			lista.add(h);

		}
		return lista;
	}

	public ArrayList<Historico> listarPorIdsensor(Historico hi) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT h.idhistorico, h.data, h.hora, h.valor, s.idsensor, s.equipamento_idequip, s.tipo_sensor_idtipo ");
		sql.append(" FROM spin1.historico h ");
		sql.append(" INNER JOIN spin1.sensor s ON s.idsensor = h.sensor_idsensor ");
		sql.append(" WHERE h.sensor_idsensor = ? ");


		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, hi.getSensor_idsensor().getIdsensor());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Historico> lista = new ArrayList<Historico>();

		while (resultado.next()) {

			Historico h = new Historico();
			Sensor s = new Sensor();
			
			
			h.setIdhistorico(resultado.getLong("h.idhistorico"));
			h.setData(resultado.getDate("h.data"));
			h.setHora(resultado.getTime("h.hora"));
			h.setValor(resultado.getFloat("h.valor"));
			
			s.setIdsensor(resultado.getLong("s.idsensor"));

			h.setSensor_idsensor(s);
			
			lista.add(h);

		}
		return lista;
	}

	public Historico pesquisar(Historico hi) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT h.idhistorico, h.data, h.hora, h.valor, s.idsensor, s.equipamento_idequip, s.tipo_sensor_idtipo ");
		sql.append(" FROM spin1.historico h ");
		sql.append(" INNER JOIN spin1.sensor s ON s.idsensor = h.sensor_idsensor ");
		sql.append(" WHERE h.idhistorico = ? ");		
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				 
																				 
		comando.setLong(1, hi.getIdhistorico());

		ResultSet resultado = comando.executeQuery();

		Historico retorno = null;

		if (resultado.next()) {

			retorno = new Historico();
			Sensor s = new Sensor();
			
			
			retorno.setIdhistorico(resultado.getLong("h.idhistorico"));
			retorno.setData(resultado.getDate("h.data"));
			retorno.setHora(resultado.getTime("h.hora"));
			retorno.setValor(resultado.getFloat("h.valor"));
			
			s.setIdsensor(resultado.getLong("s.idsensor"));

			retorno.setSensor_idsensor(s);

		}

		return retorno;
	}	
}