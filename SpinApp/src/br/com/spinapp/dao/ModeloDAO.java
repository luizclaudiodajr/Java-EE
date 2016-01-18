package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Modelo;
import br.com.spinapp.factory.ConexaoFactory;

public class ModeloDAO {
	
	public void inserir(Modelo m) throws SQLException {

		StringBuilder sql = new StringBuilder();// para concatenação
		sql.append("INSERT INTO spin1.modelo ");// append juntar
		sql.append("(descricao) ");
		sql.append("VALUES (?) ");

		// conexão com BD
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
	
		comando.setString(1, m.getDescricao());

		comando.executeUpdate();
	}

	public void excluir(Modelo m) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM spin1.modelo ");
		sql.append("WHERE idmodelo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		

		comando.setLong(1, m.getIdmodelo());

		comando.executeUpdate();

	}

	public void atualizar(Modelo m) throws SQLException {

		
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE spin1.modelo ");
		sql.append(" SET descricao = ? ");
		sql.append(" WHERE idmodelo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setString(1, m.getDescricao());
		comando.setLong(2, m.getIdmodelo());

		comando.executeUpdate();
	}

	public ArrayList<Modelo> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idmodelo, descricao ");
		sql.append(" FROM spin1.modelo ");
		sql.append(" ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Modelo> lista = new ArrayList<Modelo>();

		while (resultado.next()) {

			Modelo item = new Modelo();

			item.setIdmodelo(resultado.getLong("idmodelo"));
			item.setDescricao(resultado.getString("descricao"));

			lista.add(item);

		}
		return lista;
	}

	public ArrayList<Modelo> listarPorId(Modelo m) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idmodelo, descricao ");
		sql.append(" FROM spin1.modelo ");
		sql.append(" WHERE idmodelo = ? ");
		sql.append(" ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, m.getIdmodelo());
		ResultSet resultado = comando.executeQuery();

		ArrayList<Modelo> lista = new ArrayList<Modelo>();

		while (resultado.next()) {

			Modelo item = new Modelo();

			item.setIdmodelo(resultado.getLong("idmodelo"));
			item.setDescricao(resultado.getString("descricao"));

			lista.add(item);

		}
		return lista;
	}

	public ArrayList<Modelo> listarPorDescricao(Modelo m) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idmodelo, descricao ");
		sql.append(" FROM spin1.modelo ");
		sql.append(" WHERE descricao LIKE ? ");
		sql.append(" ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				 
																				 
																				
		comando.setString(1, "%" + m.getDescricao() + "%");
		ResultSet resultado = comando.executeQuery();

		ArrayList<Modelo> lista = new ArrayList<Modelo>();

		while (resultado.next()) {

			Modelo item = new Modelo();

			item.setIdmodelo(resultado.getLong("idmodelo"));
			item.setDescricao(resultado.getString("descricao"));

			lista.add(item);

		}
		return lista;
	}

	public Modelo pesquisar(Modelo m) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idmodelo, descricao ");
		sql.append(" FROM spin1.modelo ");
		sql.append(" WHERE idmodelo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				 

		comando.setLong(1, m.getIdmodelo());

		ResultSet resultado = comando.executeQuery();

		Modelo retorno = null;

		if (resultado.next()) {

			retorno = new Modelo();

			retorno.setIdmodelo(resultado.getLong("idmodelo"));
			retorno.setDescricao(resultado.getString("descricao"));

		}

		return retorno;
	}
}