package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import br.com.spinapp.domain.Leitura;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.domain.TipoSensor;
import br.com.spinapp.factory.ConexaoFactory;

public class LeituraDAO {
	
	public void inserir(Leitura l) throws SQLException {

		StringBuilder sql = new StringBuilder();// para concatenação
		sql.append(" INSERT INTO spin1.leitura ");// append juntar
		sql.append(" (data, hora, valor, sensor_idsensor) ");
		sql.append(" VALUES (?, ?, ?, ?) ");

		// conexão com BD
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		

		Date sqlDate = new Date(l.getData().getTime());
		Time sqlTime = new Time(l.getHora().getTime());


		comando.setDate(1, sqlDate);
		comando.setTime(2, sqlTime);
		comando.setFloat(3, l.getValor());
		comando.setLong(4, l.getSensor_idsensor().getIdsensor());
		
		comando.executeUpdate();
	}

	public void excluir(Leitura l) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM spin1.leitura ");
		sql.append(" WHERE idleitura = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, l.getIdleitura());

		comando.executeUpdate();

	}

	public void atualizar(Leitura l) throws SQLException {

		
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE spin1.leitura ");
		sql.append(" SET data = ?, hora = ?, valor = ?, sensor_idsensor = ? ");
		sql.append(" WHERE idleitura = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		

		Date sqlDate = new Date(l.getData().getTime());
		Time sqlTime = new Time(l.getHora().getTime());
		
		
		comando.setDate(1, sqlDate);
		comando.setTime(2, sqlTime);
		comando.setFloat(3, l.getValor());
		comando.setLong(4, l.getSensor_idsensor().getIdsensor());
		comando.setLong(5, l.getIdleitura());

		comando.executeUpdate();
	}

	public ArrayList<Leitura> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT l.idleitura, l.data, l.hora, l.valor, s.idsensor, s.equipamento_idequip, s.tipo_sensor_idtipo ");
		sql.append(" FROM spin1.leitura l ");
		sql.append(" INNER JOIN spin1.sensor s ON s.idsensor = l.sensor_idsensor ");
		//sql.append("ORDER BY tipo ASC ");// Ordenação implementar na tela jsf

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Leitura> lista = new ArrayList<Leitura>();

		while (resultado.next()) {

			Leitura l = new Leitura();
			Sensor s = new Sensor();
			
			
			l.setIdleitura(resultado.getLong("l.idleitura"));
			l.setData(resultado.getDate("l.data"));
			l.setHora(resultado.getTime("l.hora"));
			l.setValor(resultado.getFloat("l.valor"));
			
			s.setIdsensor(resultado.getLong("s.idsensor"));

			l.setSensor_idsensor(s);
			
			lista.add(l);

		}
		return lista;
	}

	
	public ArrayList<Leitura> listarVel(Leitura le) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT l.idleitura, l.data, l.hora, l.valor, s.idsensor, s.equipamento_idequip, s.tipo_sensor_idtipo, t.idtipo, t.descricao, t.unidade ");
		sql.append(" FROM spin1.leitura l ");
		sql.append(" INNER JOIN spin1.sensor s ON s.idsensor = l.sensor_idsensor ");
		sql.append(" INNER JOIN spin1.tipo_sensor t ON t.idtipo = s.tipo_sensor_idtipo ");
		sql.append(" WHERE l.idleitura = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, le.getSensor_idsensor().getTiposensor_idtipo().getIdtipo());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Leitura> lista = new ArrayList<Leitura>();

		while (resultado.next()) {

			Leitura l = new Leitura();
			Sensor s = new Sensor();
			TipoSensor t = new TipoSensor();
			
			l.setIdleitura(resultado.getLong("l.idleitura"));
			l.setData(resultado.getDate("l.data"));
			l.setHora(resultado.getTime("l.hora"));
			l.setValor(resultado.getFloat("l.valor"));
			
			s.setIdsensor(resultado.getLong("s.idsensor"));
			s.setIdsensor(resultado.getLong("s.equipamento_idequip"));
			s.setIdsensor(resultado.getLong("s.tipo_sensor_idtipo"));

			t.setIdtipo(resultado.getLong("t.idtipo"));
			t.setDescricao(resultado.getString("t.descricao"));
			t.setUnidade(resultado.getString("t.unidade"));

			
			s.setTiposensor_idtipo(t);
			l.setSensor_idsensor(s);
			
			lista.add(l);

		}
		return lista;
	}
	
	public ArrayList<Leitura> listarPorId(Leitura le) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT l.idleitura, l.data, l.hora, l.valor, s.idsensor, s.equipamento_idequip, s.tipo_sensor_idtipo ");
		sql.append(" FROM spin1.leitura l ");
		sql.append(" INNER JOIN spin1.sensor s ON s.idsensor = l.sensor_idsensor ");
		sql.append(" WHERE l.idleitura = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, le.getIdleitura());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Leitura> lista = new ArrayList<Leitura>();

		while (resultado.next()) {

			Leitura l = new Leitura();
			Sensor s = new Sensor();
			
			
			l.setIdleitura(resultado.getLong("l.idleitura"));
			l.setData(resultado.getDate("l.data"));
			l.setHora(resultado.getTime("l.hora"));
			l.setValor(resultado.getFloat("l.valor"));
			
			s.setIdsensor(resultado.getLong("s.idsensor"));

			l.setSensor_idsensor(s);
			
			lista.add(l);

		}
		return lista;
	}

	public ArrayList<Leitura> listarPorIdsensor(Leitura le) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT l.idleitura, l.data, l.hora, l.valor, s.idsensor, s.equipamento_idequip, s.tipo_sensor_idtipo ");
		sql.append(" FROM spin1.leitura l ");
		sql.append(" INNER JOIN spin1.sensor s ON s.idsensor = l.sensor_idsensor ");
		sql.append(" WHERE l.sensor_idsensor = ? ");


		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, le.getSensor_idsensor().getIdsensor());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Leitura> lista = new ArrayList<Leitura>();

		while (resultado.next()) {

			Leitura l = new Leitura();
			Sensor s = new Sensor();
			
			
			l.setIdleitura(resultado.getLong("l.idleitura"));
			l.setData(resultado.getDate("l.data"));
			l.setHora(resultado.getTime("l.hora"));
			l.setValor(resultado.getFloat("l.valor"));
			
			s.setIdsensor(resultado.getLong("s.idsensor"));

			l.setSensor_idsensor(s);
			
			lista.add(l);

		}
		return lista;
	}

	public Leitura pesquisar(Leitura le) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT l.idleitura, l.data, l.hora, l.valor, s.idsensor, s.equipamento_idequip, s.tipo_sensor_idtipo ");
		sql.append(" FROM spin1.leitura l ");
		sql.append(" INNER JOIN spin1.sensor s ON s.idsensor = l.sensor_idsensor ");
		sql.append(" WHERE l.idleitura = ? ");		
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				 
																				 
		comando.setLong(1, le.getIdleitura());

		ResultSet resultado = comando.executeQuery();

		Leitura retorno = null;

		if (resultado.next()) {

			retorno = new Leitura();
			Sensor s = new Sensor();
			
			retorno.setIdleitura(resultado.getLong("l.idleitura"));
			retorno.setData(resultado.getDate("l.data"));
			retorno.setHora(resultado.getTime("l.hora"));
			retorno.setValor(resultado.getFloat("l.valor"));
			
			s.setIdsensor(resultado.getLong("s.idsensor"));

			retorno.setSensor_idsensor(s);

		}

		return retorno;
	}
}