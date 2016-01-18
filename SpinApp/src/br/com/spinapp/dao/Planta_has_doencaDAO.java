package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Doenca;
import br.com.spinapp.domain.Planta;
import br.com.spinapp.domain.Planta_has_doenca;
import br.com.spinapp.factory.ConexaoFactory;

public class Planta_has_doencaDAO {

    public void inserir(Planta_has_doenca pd) throws SQLException {

	StringBuilder sql = new StringBuilder();// para concatenação
	sql.append(" INSERT INTO spin1.planta_has_doenca ");// append juntar
	sql.append(" (planta_idplanta, doenca_iddoenca) ");
	sql.append(" VALUES (?, ?) ");

	// conexão com BD
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pd.getPlanta_idplanta().getIdplanta());
	comando.setLong(2, pd.getDoenca_iddoenca().getIddoenca());

	comando.executeUpdate();
    }

    public void excluir(Planta_has_doenca pd) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" DELETE FROM spin1.planta_has_doenca ");
	sql.append(" WHERE planta_idplanta = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pd.getPlanta_idplanta().getIdplanta());

	comando.executeUpdate();

    }

    public void atualizar(Planta_has_doenca pd) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" UPDATE spin1.planta_has_doenca ");
	sql.append(" SET planta_idplanta = ?, doenca_iddoenca = ? ");
	sql.append(" WHERE planta_idplanta = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pd.getPlanta_idplanta().getIdplanta());
	comando.setLong(2, pd.getDoenca_iddoenca().getIddoenca());
	comando.setLong(3, pd.getPlanta_idplanta().getIdplanta());

	comando.executeUpdate();
    }

    public ArrayList<Planta_has_doenca> listar() throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplanta, p.nome, p.tmin, p.tmax, p.tot, p.ic, p.uc, d.iddoenca, d.nome, d.reino, d.tb, d.tc ");
	sql.append(" FROM spin1.planta_has_doenca pd ");
	sql.append(" INNER JOIN spin1.planta p ON p.idplanta = pd.planta_idplanta ");
	sql.append(" INNER JOIN spin1.doenca d ON d.iddoenca = pd.doenca_iddoenca ");
	// sql.append("ORDER BY tipo ASC ");// Ordenação implementar na tela jsf

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	ResultSet resultado = comando.executeQuery();

	ArrayList<Planta_has_doenca> lista = new ArrayList<Planta_has_doenca>();

	while (resultado.next()) {

	    Planta_has_doenca pd = new Planta_has_doenca();
	    Planta p = new Planta();
	    Doenca d = new Doenca();

	    p.setIdplanta(resultado.getLong("p.idplanta"));
	    p.setNome(resultado.getString("p.nome"));
	    p.setTmin(resultado.getFloat("p.tmin"));
	    p.setTmax(resultado.getFloat("p.tmax"));
	    p.setTot(resultado.getFloat("p.tot"));
	    p.setIc(resultado.getFloat("p.ic"));
	    p.setUc(resultado.getFloat("p.uc"));

	    d.setIddoenca(resultado.getLong("d.iddoenca"));
	    d.setNome(resultado.getString("d.nome"));
	    d.setReino(resultado.getString("d.reino"));
	    d.setTb(resultado.getFloat("d.tb"));
	    d.setTc(resultado.getFloat("d.tc"));

	    pd.setPlanta_idplanta(p);
	    pd.setDoenca_iddoenca(d);

	    lista.add(pd);

	}
	return lista;
    }

    public ArrayList<Planta_has_doenca> listarPorIdplanta(Planta_has_doenca pd) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplanta, p.nome, p.tmin, p.tmax, p.tot, p.ic, p.uc, d.iddoenca, d.nome, d.reino, d.tb, d.tc ");
	sql.append(" FROM spin1.planta_has_doenca pd ");
	sql.append(" INNER JOIN spin1.planta p ON p.idplanta = pd.planta_idplanta ");
	sql.append(" INNER JOIN spin1.doenca d ON d.iddoenca = pd.doenca_iddoenca ");
	sql.append(" WHERE p.idplanta = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pd.getPlanta_idplanta().getIdplanta());

	ResultSet resultado = comando.executeQuery();

	ArrayList<Planta_has_doenca> lista = new ArrayList<Planta_has_doenca>();

	while (resultado.next()) {

	    Planta p = new Planta();
	    Doenca d = new Doenca();

	    p.setIdplanta(resultado.getLong("p.idplanta"));
	    p.setNome(resultado.getString("p.nome"));
	    p.setTmin(resultado.getFloat("p.tmin"));
	    p.setTmax(resultado.getFloat("p.tmax"));
	    p.setTot(resultado.getFloat("p.tot"));
	    p.setIc(resultado.getFloat("p.ic"));
	    p.setUc(resultado.getFloat("p.uc"));

	    d.setIddoenca(resultado.getLong("d.iddoenca"));
	    d.setNome(resultado.getString("d.nome"));
	    d.setReino(resultado.getString("d.reino"));
	    d.setTb(resultado.getFloat("d.tb"));
	    d.setTc(resultado.getFloat("d.tc"));

	    pd.setPlanta_idplanta(p);
	    pd.setDoenca_iddoenca(d);

	    lista.add(pd);
	}
	return lista;
    }

    public ArrayList<Planta_has_doenca> listarPorIddoenca(Planta_has_doenca pd) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplanta, p.nome, p.tmin, p.tmax, p.tot, p.ic, p.uc, d.iddoenca, d.nome, d.reino, d.tb, d.tc ");
	sql.append(" FROM spin1.planta_has_doenca pd ");
	sql.append(" INNER JOIN spin1.planta p ON p.idplanta = pd.planta_idplanta ");
	sql.append(" INNER JOIN spin1.doenca d ON d.iddoenca = pd.doenca_iddoenca ");
	sql.append(" WHERE d.iddoenca = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pd.getDoenca_iddoenca().getIddoenca());

	ResultSet resultado = comando.executeQuery();

	ArrayList<Planta_has_doenca> lista = new ArrayList<Planta_has_doenca>();

	while (resultado.next()) {

	    Planta p = new Planta();
	    Doenca d = new Doenca();

	    p.setIdplanta(resultado.getLong("p.idplanta"));
	    p.setNome(resultado.getString("p.nome"));
	    p.setTmin(resultado.getFloat("p.tmin"));
	    p.setTmax(resultado.getFloat("p.tmax"));
	    p.setTot(resultado.getFloat("p.tot"));
	    p.setIc(resultado.getFloat("p.ic"));
	    p.setUc(resultado.getFloat("p.uc"));

	    d.setIddoenca(resultado.getLong("d.iddoenca"));
	    d.setNome(resultado.getString("d.nome"));
	    d.setReino(resultado.getString("d.reino"));
	    d.setTb(resultado.getFloat("d.tb"));
	    d.setTc(resultado.getFloat("d.tc"));

	    pd.setPlanta_idplanta(p);
	    pd.setDoenca_iddoenca(d);

	    lista.add(pd);
	}
	return lista;
    }

    public Planta_has_doenca pesquisar(Planta_has_doenca pd) throws SQLException {
	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplanta, p.nome, p.tmin, p.tmax, p.tot, p.ic, p.uc, d.iddoenca, d.nome, d.reino, d.tb, d.tc ");
	sql.append(" FROM spin1.planta_has_doenca pd ");
	sql.append(" INNER JOIN spin1.planta p ON p.idplanta = pd.planta_idplanta ");
	sql.append(" INNER JOIN spin1.doenca d ON d.iddoenca = pd.doenca_iddoenca ");
	sql.append(" WHERE p.idplanta = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pd.getPlanta_idplanta().getIdplanta());

	ResultSet resultado = comando.executeQuery();

	Planta_has_doenca retorno = null;

	if (resultado.next()) {

	    retorno = new Planta_has_doenca();
	    Planta p = new Planta();
	    Doenca d = new Doenca();

	    p.setIdplanta(resultado.getLong("p.idplanta"));
	    p.setNome(resultado.getString("p.nome"));
	    p.setTmin(resultado.getFloat("p.tmin"));
	    p.setTmax(resultado.getFloat("p.tmax"));
	    p.setTot(resultado.getFloat("p.tot"));
	    p.setIc(resultado.getFloat("p.ic"));
	    p.setUc(resultado.getFloat("p.uc"));

	    d.setIddoenca(resultado.getLong("d.iddoenca"));
	    d.setNome(resultado.getString("d.nome"));
	    d.setReino(resultado.getString("d.reino"));
	    d.setTb(resultado.getFloat("d.tb"));
	    d.setTc(resultado.getFloat("d.tc"));

	    retorno.setPlanta_idplanta(p);
	    retorno.setDoenca_iddoenca(d);

	}

	return retorno;
    }
}