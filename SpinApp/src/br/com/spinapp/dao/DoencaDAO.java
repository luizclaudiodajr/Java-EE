package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Doenca;
import br.com.spinapp.factory.ConexaoFactory;

public class DoencaDAO {

    public void inserir(Doenca d) throws SQLException {

	StringBuilder sql = new StringBuilder();// para concatenação
	sql.append("INSERT INTO spin1.doenca ");// append juntar
	sql.append("(nome, reino, tb, tc) ");
	sql.append("VALUES (?, ?, ?, ?) ");

	// conexão com BD
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setString(1, d.getNome());
	comando.setString(2, d.getReino());
	comando.setFloat(3, d.getTb());
	comando.setFloat(4, d.getTc());

	comando.executeUpdate();
    }

    public void excluir(Doenca d) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append("DELETE FROM spin1.doenca ");
	sql.append("WHERE iddoenca = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, d.getIddoenca());

	comando.executeUpdate();

    }

    public void atualizar(Doenca d) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" UPDATE spin1.doenca ");
	sql.append(" SET nome = ?, reino = ?, tb = ?, tc = ? ");
	sql.append(" WHERE iddoenca = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setString(1, d.getNome());
	comando.setString(2, d.getReino());
	comando.setFloat(3, d.getTb());
	comando.setFloat(4, d.getTc());
	comando.setLong(5, d.getIddoenca());

	comando.executeUpdate();
    }

    public ArrayList<Doenca> listar() throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT iddoenca, nome, reino, tb, tc ");
	sql.append(" FROM spin1.doenca ");
	sql.append(" ORDER BY nome ASC ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	ResultSet resultado = comando.executeQuery();

	ArrayList<Doenca> lista = new ArrayList<Doenca>();

	while (resultado.next()) {

	    Doenca item = new Doenca();

	    item.setIddoenca(resultado.getLong("iddoenca"));
	    item.setNome(resultado.getString("nome"));
	    item.setReino(resultado.getString("reino"));
	    item.setTb(resultado.getFloat("tb"));
	    item.setTc(resultado.getFloat("tc"));

	    lista.add(item);

	}
	return lista;
    }

    public ArrayList<Doenca> listarPorId(Doenca d) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT iddoenca, nome, reino, tb, tc ");
	sql.append(" FROM spin1.doenca ");
	sql.append(" WHERE iddoenca = ? ");
	sql.append(" ORDER BY nome ASC ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, d.getIddoenca());
	ResultSet resultado = comando.executeQuery();

	ArrayList<Doenca> lista = new ArrayList<Doenca>();

	while (resultado.next()) {

	    Doenca item = new Doenca();

	    item.setIddoenca(resultado.getLong("iddoenca"));
	    item.setNome(resultado.getString("nome"));
	    item.setReino(resultado.getString("reino"));
	    item.setTb(resultado.getFloat("tb"));
	    item.setTc(resultado.getFloat("tc"));

	    lista.add(item);

	}
	return lista;
    }

    public ArrayList<Doenca> listarPorNome(Doenca d) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT iddoenca, nome, reino, tb, tc ");
	sql.append(" FROM spin1.doenca ");
	sql.append(" WHERE nome LIKE ? ");
	sql.append(" ORDER BY nome ASC ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setString(1, "%" + d.getNome() + "%");
	ResultSet resultado = comando.executeQuery();

	ArrayList<Doenca> lista = new ArrayList<Doenca>();

	while (resultado.next()) {

	    Doenca item = new Doenca();

	    item.setIddoenca(resultado.getLong("iddoenca"));
	    item.setNome(resultado.getString("nome"));
	    item.setReino(resultado.getString("reino"));
	    item.setTb(resultado.getFloat("tb"));
	    item.setTc(resultado.getFloat("tc"));

	    lista.add(item);

	}
	return lista;
    }

    public Doenca pesquisar(Doenca d) throws SQLException {
	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT iddoenca, nome, reino, tb, tc ");
	sql.append(" FROM spin1.doenca ");
	sql.append(" WHERE iddoenca = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, d.getIddoenca());

	ResultSet resultado = comando.executeQuery();

	Doenca retorno = null;

	if (resultado.next()) {

	    retorno = new Doenca();

	    retorno.setIddoenca(resultado.getLong("iddoenca"));
	    retorno.setNome(resultado.getString("nome"));
	    retorno.setReino(resultado.getString("reino"));
	    retorno.setTb(resultado.getFloat("tb"));
	    retorno.setTc(resultado.getFloat("tc"));

	}

	return retorno;
    }
}