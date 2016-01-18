package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Planta;
import br.com.spinapp.factory.ConexaoFactory;

public class PlantaDAO {
	
	public void inserir(Planta p) throws SQLException {

		StringBuilder sql = new StringBuilder();// para concatenação
		sql.append("INSERT INTO spin1.planta ");// append juntar
		sql.append("(nome, tmin, tmax, tot, ic, uc) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?) ");

		// conexão com BD
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
	
		comando.setString(1, p.getNome());
		comando.setFloat(2, p.getTmin());
		comando.setFloat(3, p.getTmax());
		comando.setFloat(4, p.getTot());
		comando.setFloat(5, p.getIc());
		comando.setFloat(6, p.getUc());
		
		comando.executeUpdate();
	}

	public void excluir(Planta p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM spin1.planta ");
		sql.append("WHERE idplanta = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		

		comando.setLong(1, p.getIdplanta());

		comando.executeUpdate();

	}

	public void atualizar(Planta p) throws SQLException {

		
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE spin1.planta ");
		sql.append(" SET nome = ?, tmin = ?, tmax = ?, tot = ?, ic = ?, uc = ? ");
		sql.append(" WHERE idplanta = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setString(1, p.getNome());
		comando.setFloat(2, p.getTmin());
		comando.setFloat(3, p.getTmax());
		comando.setFloat(4, p.getTot());
		comando.setFloat(5, p.getIc());
		comando.setFloat(6, p.getUc());
		comando.setFloat(7, p.getIdplanta());
		
		comando.executeUpdate();
	}

	public ArrayList<Planta> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idplanta, nome, tmin, tmax, tot, ic, uc ");
		sql.append(" FROM spin1.planta ");
		sql.append(" ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

		
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Planta> lista = new ArrayList<Planta>();

		while (resultado.next()) {

			Planta item = new Planta();

			item.setIdplanta(resultado.getLong("idplanta"));
			item.setNome(resultado.getString("nome"));
			item.setTmin(resultado.getFloat("tmin"));
			item.setTmax(resultado.getFloat("tmax"));
			item.setTot(resultado.getFloat("tot"));
			item.setIc(resultado.getFloat("ic"));
			item.setUc(resultado.getFloat("uc"));
			
			
			lista.add(item);

		}
		return lista;
	}

	public ArrayList<Planta> listarPorId(Planta p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idplanta, nome, tmin, tmax, tot, ic, uc ");
		sql.append(" FROM spin1.planta ");
		sql.append(" WHERE idplanta = ? ");
		sql.append(" ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, p.getIdplanta());
		ResultSet resultado = comando.executeQuery();

		ArrayList<Planta> lista = new ArrayList<Planta>();

		while (resultado.next()) {

			Planta item = new Planta();

			item.setIdplanta(resultado.getLong("idplanta"));
			item.setNome(resultado.getString("nome"));
			item.setTmin(resultado.getFloat("tmin"));
			item.setTmax(resultado.getFloat("tmax"));
			item.setTot(resultado.getFloat("tot"));
			item.setIc(resultado.getFloat("ic"));
			item.setUc(resultado.getFloat("uc"));

			lista.add(item);

		}
		return lista;
	}

	public ArrayList<Planta> listarPorNome(Planta p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idplanta, nome, tmin, tmax, tot, ic, uc ");
		sql.append(" FROM spin1.planta ");
		sql.append(" WHERE nome LIKE ? ");
		sql.append(" ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				 
																				 
		comando.setString(1, "%" + p.getNome() + "%");
		ResultSet resultado = comando.executeQuery();

		ArrayList<Planta> lista = new ArrayList<Planta>();

		while (resultado.next()) {

			Planta item = new Planta();

			item.setIdplanta(resultado.getLong("idplanta"));
			item.setNome(resultado.getString("nome"));
			item.setTmin(resultado.getFloat("tmin"));
			item.setTmax(resultado.getFloat("tmax"));
			item.setTot(resultado.getFloat("tot"));
			item.setIc(resultado.getFloat("ic"));
			item.setUc(resultado.getFloat("uc"));

			lista.add(item);

		}
		return lista;
	}

	public Planta pesquisar(Planta p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idplanta, nome, tmin, tmax, tot, ic, uc ");
		sql.append(" FROM spin1.planta ");
		sql.append(" WHERE idplanta = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				

		comando.setLong(1, p.getIdplanta());

		ResultSet resultado = comando.executeQuery();

		Planta retorno = null;

		if (resultado.next()) {

			retorno = new Planta();

			retorno.setIdplanta(resultado.getLong("idplanta"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setTmin(resultado.getFloat("tmin"));
			retorno.setTmax(resultado.getFloat("tmax"));
			retorno.setTot(resultado.getFloat("tot"));
			retorno.setIc(resultado.getFloat("ic"));
			retorno.setUc(resultado.getFloat("uc"));

		}

		return retorno;
	}


}