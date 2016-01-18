package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Plano;
import br.com.spinapp.factory.ConexaoFactory;

public class PlanoDAO {

    public void inserir(Plano p) throws SQLException {

	StringBuilder sql = new StringBuilder();// para concatenação
	sql.append("INSERT INTO spin1.plano ");// append juntar
	sql.append("(tipo, preco, duracao, descricao) ");
	sql.append("VALUES (?, ?, ?, ?) ");

	// conexão com BD
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setString(1, p.getTipo());
	comando.setFloat(2, p.getPreco());
	comando.setString(3, p.getDuracao());
	comando.setString(4, p.getDescricao());

	comando.executeUpdate();
    }

    public void excluir(Plano p) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append("DELETE FROM spin1.plano ");
	sql.append("WHERE idplano = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, p.getIdplano());

	comando.executeUpdate();

    }

    public void atualizar(Plano p) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" UPDATE spin1.plano ");
	sql.append(" SET tipo = ?, preco = ?, duracao = ?, descricao = ? ");
	sql.append(" WHERE idplano = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setString(1, p.getTipo());
	comando.setFloat(2, p.getPreco());
	comando.setString(3, p.getDuracao());
	comando.setString(4, p.getDescricao());
	comando.setLong(5, p.getIdplano());

	comando.executeUpdate();
    }

    public ArrayList<Plano> listar() throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT idplano, tipo, preco, duracao, descricao ");
	sql.append(" FROM spin1.plano ");
	sql.append(" ORDER BY tipo ASC ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	ResultSet resultado = comando.executeQuery();

	ArrayList<Plano> lista = new ArrayList<Plano>();

	while (resultado.next()) {

	    Plano item = new Plano();

	    item.setIdplano(resultado.getLong("idplano"));
	    item.setTipo(resultado.getString("tipo"));
	    item.setPreco(resultado.getFloat("preco"));
	    item.setDuracao(resultado.getString("duracao"));
	    item.setDescricao(resultado.getString("descricao"));

	    lista.add(item);

	}
	return lista;
    }

    public ArrayList<Plano> listarPorId(Plano p) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT idplano, tipo, preco, duracao, descricao ");
	sql.append(" FROM spin1.plano ");
	sql.append(" WHERE idplano = ? ");
	sql.append(" ORDER BY tipo ASC ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, p.getIdplano());
	ResultSet resultado = comando.executeQuery();

	ArrayList<Plano> lista = new ArrayList<Plano>();

	while (resultado.next()) {

	    Plano item = new Plano();

	    item.setIdplano(resultado.getLong("idplano"));
	    item.setTipo(resultado.getString("tipo"));
	    item.setPreco(resultado.getFloat("preco"));
	    item.setDuracao(resultado.getString("duracao"));
	    item.setDescricao(resultado.getString("descricao"));

	    lista.add(item);

	}
	return lista;
    }

    public ArrayList<Plano> listarPorTipo(Plano p) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT idplano, tipo, preco, duracao, descricao ");
	sql.append(" FROM spin1.plano ");
	sql.append(" WHERE tipo LIKE ? ");
	sql.append(" ORDER BY tipo ASC ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setString(1, "%" + p.getTipo() + "%");
	ResultSet resultado = comando.executeQuery();

	ArrayList<Plano> lista = new ArrayList<Plano>();

	while (resultado.next()) {

	    Plano item = new Plano();

	    item.setIdplano(resultado.getLong("idplano"));
	    item.setTipo(resultado.getString("tipo"));
	    item.setPreco(resultado.getFloat("preco"));
	    item.setDuracao(resultado.getString("duracao"));
	    item.setDescricao(resultado.getString("descricao"));

	    lista.add(item);

	}
	return lista;
    }

    public Plano pesquisar(Plano p) throws SQLException {
	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT idplano, tipo, preco, duracao, descricao ");
	sql.append(" FROM spin1.plano ");
	sql.append(" WHERE idplano = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, p.getIdplano());

	ResultSet resultado = comando.executeQuery();

	Plano retorno = null;

	if (resultado.next()) {

	    retorno = new Plano();

	    retorno.setIdplano(resultado.getLong("idplano"));
	    retorno.setTipo(resultado.getString("tipo"));
	    retorno.setPreco(resultado.getFloat("preco"));
	    retorno.setDuracao(resultado.getString("duracao"));
	    retorno.setDescricao(resultado.getString("descricao"));

	}

	return retorno;
    }
}