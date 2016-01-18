package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Planta;
import br.com.spinapp.domain.Planta_has_praga;
import br.com.spinapp.domain.Praga;
import br.com.spinapp.factory.ConexaoFactory;

public class Planta_has_pragaDAO {

    public void inserir(Planta_has_praga pp) throws SQLException {

	StringBuilder sql = new StringBuilder();// para concatenação
	sql.append(" INSERT INTO spin1.planta_has_praga ");// append juntar
	sql.append(" (planta_idplanta, praga_idpraga) ");
	sql.append(" VALUES (?, ?) ");

	// conexão com BD
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pp.getPlanta_idplanta().getIdplanta());
	comando.setLong(2, pp.getPraga_idpraga().getIdpraga());

	comando.executeUpdate();
    }

    public void excluir(Planta_has_praga pp) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" DELETE FROM spin1.planta_has_praga ");
	sql.append(" WHERE planta_idplanta = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pp.getPlanta_idplanta().getIdplanta());

	comando.executeUpdate();

    }

    public void atualizar(Planta_has_praga pp) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" UPDATE spin1.planta_has_praga ");
	sql.append(" SET planta_idplanta = ?, praga_idpraga = ? ");
	sql.append(" WHERE planta_idplanta = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pp.getPlanta_idplanta().getIdplanta());
	comando.setLong(2, pp.getPraga_idpraga().getIdpraga());
	comando.setLong(3, pp.getPlanta_idplanta().getIdplanta());

	comando.executeUpdate();
    }

    public ArrayList<Planta_has_praga> listar() throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplanta, p.nome, p.tmin, p.tmax, p.tot, p.ic, p.uc, pr.idpraga, pr.nome, pr.tb, pr.ct ");
	sql.append(" FROM spin1.planta_has_praga pp ");
	sql.append(" INNER JOIN spin1.planta p ON p.idplanta = pp.planta_idplanta ");
	sql.append(" INNER JOIN spin1.praga pr ON pr.idpraga = pp.praga_idpraga ");
	// sql.append("ORDER BY tipo ASC ");// Ordenação implementar na tela jsf

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	ResultSet resultado = comando.executeQuery();

	ArrayList<Planta_has_praga> lista = new ArrayList<Planta_has_praga>();

	while (resultado.next()) {

	    Planta_has_praga pp = new Planta_has_praga();
	    Planta p = new Planta();
	    Praga pr = new Praga();

	    p.setIdplanta(resultado.getLong("p.idplanta"));
	    p.setNome(resultado.getString("p.nome"));
	    p.setTmin(resultado.getFloat("p.tmin"));
	    p.setTmax(resultado.getFloat("p.tmax"));
	    p.setTot(resultado.getFloat("p.tot"));
	    p.setIc(resultado.getFloat("p.ic"));
	    p.setUc(resultado.getFloat("p.uc"));

	    pr.setIdpraga(resultado.getLong("pr.idpraga"));
	    pr.setNome(resultado.getString("pr.nome"));
	    pr.setTb(resultado.getFloat("pr.tb"));
	    pr.setCt(resultado.getFloat("pr.ct"));

	    pp.setPlanta_idplanta(p);
	    pp.setPraga_idpraga(pr);

	    lista.add(pp);

	}
	return lista;
    }

    public ArrayList<Planta_has_praga> listarPorIdplanta(Planta_has_praga pp) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplanta, p.nome, p.tmin, p.tmax, p.tot, p.ic, p.uc, pr.idpraga, pr.nome, pr.tb, pr.ct ");
	sql.append(" FROM spin1.planta_has_praga pp ");
	sql.append(" INNER JOIN spin1.planta p ON p.idplanta = pp.planta_idplanta ");
	sql.append(" INNER JOIN spin1.praga pr ON pr.idpraga = pp.praga_idpraga ");
	sql.append(" WHERE p.idplanta = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pp.getPlanta_idplanta().getIdplanta());

	ResultSet resultado = comando.executeQuery();

	ArrayList<Planta_has_praga> lista = new ArrayList<Planta_has_praga>();

	while (resultado.next()) {

	    Planta p = new Planta();
	    Praga pr = new Praga();

	    p.setIdplanta(resultado.getLong("p.idplanta"));
	    p.setNome(resultado.getString("p.nome"));
	    p.setTmin(resultado.getFloat("p.tmin"));
	    p.setTmax(resultado.getFloat("p.tmax"));
	    p.setTot(resultado.getFloat("p.tot"));
	    p.setIc(resultado.getFloat("p.ic"));
	    p.setUc(resultado.getFloat("p.uc"));

	    pr.setIdpraga(resultado.getLong("pr.idpraga"));
	    pr.setNome(resultado.getString("pr.nome"));
	    pr.setTb(resultado.getFloat("pr.tb"));
	    pr.setCt(resultado.getFloat("pr.ct"));

	    pp.setPlanta_idplanta(p);
	    pp.setPraga_idpraga(pr);

	    lista.add(pp);
	}
	return lista;
    }

    public ArrayList<Planta_has_praga> listarPorIdpraga(Planta_has_praga pp) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplanta, p.nome, p.tmin, p.tmax, p.tot, p.ic, p.uc, pr.idpraga, pr.nome, pr.tb, pr.ct ");
	sql.append(" FROM spin1.planta_has_praga pp ");
	sql.append(" INNER JOIN spin1.planta p ON p.idplanta = pp.planta_idplanta ");
	sql.append(" INNER JOIN spin1.praga pr ON pr.idpraga = pp.praga_idpraga ");
	sql.append(" WHERE pr.idpraga = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pp.getPraga_idpraga().getIdpraga());

	ResultSet resultado = comando.executeQuery();

	ArrayList<Planta_has_praga> lista = new ArrayList<Planta_has_praga>();

	while (resultado.next()) {

	    Planta p = new Planta();
	    Praga pr = new Praga();

	    p.setIdplanta(resultado.getLong("p.idplanta"));
	    p.setNome(resultado.getString("p.nome"));
	    p.setTmin(resultado.getFloat("p.tmin"));
	    p.setTmax(resultado.getFloat("p.tmax"));
	    p.setTot(resultado.getFloat("p.tot"));
	    p.setIc(resultado.getFloat("p.ic"));
	    p.setUc(resultado.getFloat("p.uc"));

	    pr.setIdpraga(resultado.getLong("pr.idpraga"));
	    pr.setNome(resultado.getString("pr.nome"));
	    pr.setTb(resultado.getFloat("pr.tb"));
	    pr.setCt(resultado.getFloat("pr.ct"));

	    pp.setPlanta_idplanta(p);
	    pp.setPraga_idpraga(pr);

	    lista.add(pp);
	}
	return lista;
    }

    public Planta_has_praga pesquisar(Planta_has_praga pp) throws SQLException {
	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplanta, p.nome, p.tmin, p.tmax, p.tot, p.ic, p.uc, pr.idpraga, pr.nome, pr.tb, pr.ct ");
	sql.append(" FROM spin1.planta_has_praga pp ");
	sql.append(" INNER JOIN spin1.planta p ON p.idplanta = pp.planta_idplanta ");
	sql.append(" INNER JOIN spin1.praga pr ON pr.idpraga = pp.praga_idpraga ");
	sql.append(" WHERE p.idplanta = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, pp.getPlanta_idplanta().getIdplanta());

	ResultSet resultado = comando.executeQuery();

	Planta_has_praga retorno = null;

	if (resultado.next()) {

	    retorno = new Planta_has_praga();
	    Planta p = new Planta();
	    Praga pr = new Praga();

	    p.setIdplanta(resultado.getLong("p.idplanta"));
	    p.setNome(resultado.getString("p.nome"));
	    p.setTmin(resultado.getFloat("p.tmin"));
	    p.setTmax(resultado.getFloat("p.tmax"));
	    p.setTot(resultado.getFloat("p.tot"));
	    p.setIc(resultado.getFloat("p.ic"));
	    p.setUc(resultado.getFloat("p.uc"));

	    pr.setIdpraga(resultado.getLong("pr.idpraga"));
	    pr.setNome(resultado.getString("pr.nome"));
	    pr.setTb(resultado.getFloat("pr.tb"));
	    pr.setCt(resultado.getFloat("pr.ct"));

	    retorno.setPlanta_idplanta(p);
	    retorno.setPraga_idpraga(pr);

	}

	return retorno;
    }
}