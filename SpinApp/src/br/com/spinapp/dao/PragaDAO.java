package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Praga;
import br.com.spinapp.factory.ConexaoFactory;

public class PragaDAO {
	
	public void inserir(Praga p) throws SQLException {

		StringBuilder sql = new StringBuilder();// para concatenação
		sql.append("INSERT INTO spin1.praga ");// append juntar
		sql.append("(nome, tb, ct) ");
		sql.append("VALUES (?, ?, ?) ");

		// conexão com BD
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
	
		comando.setString(1, p.getNome());
		comando.setFloat(2, p.getTb());
		comando.setFloat(3, p.getCt());

		comando.executeUpdate();
	}

	public void excluir(Praga p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM spin1.praga ");
		sql.append("WHERE idpraga = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		

		comando.setLong(1, p.getIdpraga());

		comando.executeUpdate();

	}

	public void atualizar(Praga p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE spin1.praga ");
		sql.append(" SET nome = ?, tb = ?, ct = ? ");
		sql.append(" WHERE idpraga = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setString(1, p.getNome());
		comando.setFloat(2, p.getTb());
		comando.setFloat(3, p.getCt());
		comando.setLong(4, p.getIdpraga());

		comando.executeUpdate();
	}

	public ArrayList<Praga> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idpraga, nome, tb, ct ");
		sql.append(" FROM spin1.praga ");
		sql.append(" ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Praga> lista = new ArrayList<Praga>();

		while (resultado.next()) {

			Praga item = new Praga();

			item.setIdpraga(resultado.getLong("idpraga"));
			item.setNome(resultado.getString("nome"));
			item.setTb(resultado.getFloat("tb"));
			item.setCt(resultado.getFloat("ct"));

			lista.add(item);

		}
		return lista;
	}

	public ArrayList<Praga> listarPorId(Praga p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idpraga, nome, tb, ct ");
		sql.append(" FROM spin1.praga ");
		sql.append(" WHERE idpraga = ? ");
		sql.append(" ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, p.getIdpraga());
		ResultSet resultado = comando.executeQuery();

		ArrayList<Praga> lista = new ArrayList<Praga>();

		while (resultado.next()) {

			Praga item = new Praga();

			item.setIdpraga(resultado.getLong("idpraga"));
			item.setNome(resultado.getString("nome"));
			item.setTb(resultado.getFloat("tb"));
			item.setCt(resultado.getFloat("ct"));

			lista.add(item);

		}
		return lista;
	}

	public ArrayList<Praga> listarPorNome(Praga p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idpraga, nome, tb, ct ");
		sql.append(" FROM spin1.praga ");
		sql.append(" WHERE nome LIKE ? ");
		sql.append(" ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				 
																				 
																				
		comando.setString(1, "%" + p.getNome() + "%");
		ResultSet resultado = comando.executeQuery();

		ArrayList<Praga> lista = new ArrayList<Praga>();

		while (resultado.next()) {

			Praga item = new Praga();

			item.setIdpraga(resultado.getLong("idpraga"));
			item.setNome(resultado.getString("nome"));
			item.setTb(resultado.getFloat("tb"));
			item.setCt(resultado.getFloat("ct"));

			lista.add(item);

		}
		return lista;
	}

	public Praga pesquisar(Praga p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idpraga, nome, tb, ct ");
		sql.append(" FROM spin1.praga ");
		sql.append(" WHERE idpraga = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				

		comando.setLong(1, p.getIdpraga());

		ResultSet resultado = comando.executeQuery();

		Praga retorno = null;

		if (resultado.next()) {

			retorno = new Praga();

			retorno.setIdpraga(resultado.getLong("idpraga"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setTb(resultado.getFloat("tb"));
			retorno.setCt(resultado.getFloat("ct"));

		}

		return retorno;
	}
}