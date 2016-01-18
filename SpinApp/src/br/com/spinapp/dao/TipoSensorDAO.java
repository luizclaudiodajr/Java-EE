package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.TipoSensor;
import br.com.spinapp.factory.ConexaoFactory;

public class TipoSensorDAO {
	
	public void inserir(TipoSensor t) throws SQLException {

		StringBuilder sql = new StringBuilder();// para concatenação
		sql.append("INSERT INTO spin1.tipo_sensor ");// append juntar
		sql.append("(descricao, unidade) ");
		sql.append("VALUES (?, ?) ");

		// conexão com BD
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
	
		comando.setString(1, t.getDescricao());
		comando.setString(2, t.getUnidade());

		comando.executeUpdate();
	}

	public void excluir(TipoSensor t) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM spin1.tipo_sensor ");
		sql.append("WHERE idtipo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		

		comando.setLong(1, t.getIdtipo());

		comando.executeUpdate();

	}

	public void atualizar(TipoSensor t) throws SQLException {

		
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE spin1.tipo_sensor ");
		sql.append(" SET descricao = ?, unidade = ? ");
		sql.append(" WHERE idtipo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setString(1, t.getDescricao());
		comando.setString(2, t.getUnidade());
		comando.setLong(3, t.getIdtipo());
		
		comando.executeUpdate();
	}

	public ArrayList<TipoSensor> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idtipo, descricao, unidade ");
		sql.append(" FROM spin1.tipo_sensor ");
		sql.append(" ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<TipoSensor> lista = new ArrayList<TipoSensor>();

		while (resultado.next()) {

			TipoSensor item = new TipoSensor();

			item.setIdtipo(resultado.getLong("idtipo"));
			item.setDescricao(resultado.getString("descricao"));
			item.setUnidade(resultado.getString("unidade"));
			
			lista.add(item);

		}
		return lista;
	}

	public ArrayList<TipoSensor> listarPorId(TipoSensor t) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idtipo, descricao, unidade ");
		sql.append(" FROM spin1.tipo_sensor ");
		sql.append(" WHERE idtipo = ? ");
		sql.append(" ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, t.getIdtipo());
		ResultSet resultado = comando.executeQuery();

		ArrayList<TipoSensor> lista = new ArrayList<TipoSensor>();

		while (resultado.next()) {

			TipoSensor item = new TipoSensor();

			item.setIdtipo(resultado.getLong("idtipo"));
			item.setDescricao(resultado.getString("descricao"));
			item.setUnidade(resultado.getString("unidade"));

			lista.add(item);

		}
		return lista;
	}

	public ArrayList<TipoSensor> listarPorDescricao(TipoSensor t) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idtipo, descricao, unidade ");
		sql.append(" FROM spin1.tipo_sensor ");
		sql.append(" WHERE descricao LIKE ? ");
		sql.append(" ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				 
																				 
																				
		comando.setString(1, "%" + t.getDescricao() + "%");
		ResultSet resultado = comando.executeQuery();

		ArrayList<TipoSensor> lista = new ArrayList<TipoSensor>();

		while (resultado.next()) {

			TipoSensor item = new TipoSensor();

			item.setIdtipo(resultado.getLong("idtipo"));
			item.setDescricao(resultado.getString("descricao"));
			item.setUnidade(resultado.getString("unidade"));

			lista.add(item);

		}
		return lista;
	}

	public TipoSensor pesquisar(TipoSensor t) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idtipo, descricao, unidade ");
		sql.append(" FROM spin1.tipo_sensor ");
		sql.append(" WHERE idtipo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				 

		comando.setLong(1, t.getIdtipo());

		ResultSet resultado = comando.executeQuery();

		TipoSensor retorno = null;

		if (resultado.next()) {

			retorno = new TipoSensor();

			retorno.setIdtipo(resultado.getLong("idtipo"));
			retorno.setDescricao(resultado.getString("descricao"));
			retorno.setUnidade(resultado.getString("unidade"));

		}

		return retorno;
	}
}