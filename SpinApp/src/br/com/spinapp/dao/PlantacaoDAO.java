package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Planta;
import br.com.spinapp.domain.Plantacao;
import br.com.spinapp.factory.ConexaoFactory;

public class PlantacaoDAO {
    public void inserir(Plantacao p) throws SQLException {

	StringBuilder sql = new StringBuilder();// para concatenação
	sql.append(" INSERT INTO spin1.plantacao ");// append juntar
	sql.append(" (data_plantio, area, planta_idplanta, cliente_idcliente) ");
	sql.append(" VALUES (?, ?, ?, ?) ");

	// conexão com BD
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	Date sqlDate = new Date(p.getData_plantio().getTime());

	comando.setDate(1, sqlDate);
	comando.setFloat(2, p.getArea());
	comando.setLong(3, p.getPlanta_idplanta().getIdplanta());
	comando.setLong(4, p.getCliente_idcliente().getIdcliente());

	comando.executeUpdate();
    }

    public void excluir(Plantacao p) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" DELETE FROM spin1.plantacao ");
	sql.append(" WHERE idplantacao = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, p.getIdplantacao());

	comando.executeUpdate();

    }

    public void atualizar(Plantacao p) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" UPDATE spin1.plantacao ");
	sql.append(" SET data_plantio = ?, area = ?, planta_idplanta = ?, cliente_idcliente = ? ");
	sql.append(" WHERE idplantacao = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	Date sqlDate = new Date(p.getData_plantio().getTime());

	comando.setDate(1, sqlDate);
	comando.setFloat(2, p.getArea());
	comando.setLong(3, p.getPlanta_idplanta().getIdplanta());
	comando.setLong(4, p.getCliente_idcliente().getIdcliente());
	comando.setLong(5, p.getIdplantacao());

	comando.executeUpdate();
    }

    public ArrayList<Plantacao> listar() throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplantacao, p.data_plantio, p.area, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj, pa.idplanta, pa.nome, pa.tmin, pa.tmax, pa.tot, pa.ic, pa.uc ");
	sql.append(" FROM spin1.plantacao p ");
	sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = p.cliente_idcliente ");
	sql.append(" INNER JOIN spin1.planta pa ON pa.idplanta = p.planta_idplanta ");
	// sql.append("ORDER BY tipo ASC ");// Ordenação implementar na tela jsf

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	ResultSet resultado = comando.executeQuery();

	ArrayList<Plantacao> lista = new ArrayList<Plantacao>();

	while (resultado.next()) {

	    Plantacao p = new Plantacao();
	    Cliente c = new Cliente();
	    Planta pa = new Planta();

	    p.setIdplantacao(resultado.getLong("p.idplantacao"));
	    p.setData_plantio(resultado.getDate("p.data_plantio"));
	    p.setArea(resultado.getFloat("p.area"));

	    c.setIdcliente(resultado.getLong("c.idcliente"));
	    c.setNome(resultado.getString("c.nome"));
	    c.setCelular(resultado.getString("c.celular"));
	    c.setEndereco(resultado.getString("c.endereco"));
	    c.setCpf(resultado.getString("c.cpf"));
	    c.setRg(resultado.getString("c.rg"));
	    c.setEmail(resultado.getString("c.email"));
	    c.setSenha(resultado.getString("c.senha"));
	    c.setCnpj(resultado.getString("c.cnpj"));

	    pa.setIdplanta(resultado.getLong("pa.idplanta"));
	    pa.setNome(resultado.getString("pa.nome"));
	    pa.setTmin(resultado.getFloat("pa.tmin"));
	    pa.setTmax(resultado.getFloat("pa.tmax"));
	    pa.setTot(resultado.getFloat("pa.tot"));
	    pa.setIc(resultado.getFloat("pa.ic"));
	    pa.setUc(resultado.getFloat("pa.uc"));

	    p.setCliente_idcliente(c);
	    p.setPlanta_idplanta(pa);

	    lista.add(p);

	}
	return lista;
    }

    public ArrayList<Plantacao> listarPorId(Plantacao plan) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplantacao, p.data_plantio, p.area, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj, pa.idplanta, pa.nome, pa.tmin, pa.tmax, pa.tot, pa.ic, pa.uc ");
	sql.append(" FROM spin1.plantacao p ");
	sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = p.cliente_idcliente ");
	sql.append(" INNER JOIN spin1.planta pa ON pa.idplanta = p.planta_idplanta ");
	sql.append(" WHERE p.idplantacao = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, plan.getIdplantacao());

	ResultSet resultado = comando.executeQuery();

	ArrayList<Plantacao> lista = new ArrayList<Plantacao>();

	while (resultado.next()) {

	    Plantacao p = new Plantacao();
	    Cliente c = new Cliente();
	    Planta pa = new Planta();

	    p.setIdplantacao(resultado.getLong("p.idplantacao"));
	    p.setData_plantio(resultado.getDate("p.data_plantio"));
	    p.setArea(resultado.getFloat("p.area"));

	    c.setIdcliente(resultado.getLong("c.idcliente"));
	    c.setNome(resultado.getString("c.nome"));
	    c.setCelular(resultado.getString("c.celular"));
	    c.setEndereco(resultado.getString("c.endereco"));
	    c.setCpf(resultado.getString("c.cpf"));
	    c.setRg(resultado.getString("c.rg"));
	    c.setEmail(resultado.getString("c.email"));
	    c.setSenha(resultado.getString("c.senha"));
	    c.setCnpj(resultado.getString("c.cnpj"));

	    pa.setIdplanta(resultado.getLong("pa.idplanta"));
	    pa.setNome(resultado.getString("pa.nome"));
	    pa.setTmin(resultado.getFloat("pa.tmin"));
	    pa.setTmax(resultado.getFloat("pa.tmax"));
	    pa.setTot(resultado.getFloat("pa.tot"));
	    pa.setIc(resultado.getFloat("pa.ic"));
	    pa.setUc(resultado.getFloat("pa.uc"));

	    p.setCliente_idcliente(c);
	    p.setPlanta_idplanta(pa);

	    lista.add(p);

	}
	return lista;
    }

    public ArrayList<Plantacao> listarPorIdcliente(Plantacao plan) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplantacao, p.data_plantio, p.area, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj, pa.idplanta, pa.nome, pa.tmin, pa.tmax, pa.tot, pa.ic, pa.uc ");
	sql.append(" FROM spin1.plantacao p ");
	sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = p.cliente_idcliente ");
	sql.append(" INNER JOIN spin1.planta pa ON pa.idplanta = p.planta_idplanta ");
	sql.append(" WHERE c.idcliente = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, plan.getCliente_idcliente().getIdcliente());

	ResultSet resultado = comando.executeQuery();

	ArrayList<Plantacao> lista = new ArrayList<Plantacao>();

	while (resultado.next()) {

	    Plantacao p = new Plantacao();
	    Cliente c = new Cliente();
	    Planta pa = new Planta();

	    p.setIdplantacao(resultado.getLong("p.idplantacao"));
	    p.setData_plantio(resultado.getDate("p.data_plantio"));
	    p.setArea(resultado.getFloat("p.area"));

	    c.setIdcliente(resultado.getLong("c.idcliente"));
	    c.setNome(resultado.getString("c.nome"));
	    c.setCelular(resultado.getString("c.celular"));
	    c.setEndereco(resultado.getString("c.endereco"));
	    c.setCpf(resultado.getString("c.cpf"));
	    c.setRg(resultado.getString("c.rg"));
	    c.setEmail(resultado.getString("c.email"));
	    c.setSenha(resultado.getString("c.senha"));
	    c.setCnpj(resultado.getString("c.cnpj"));

	    pa.setIdplanta(resultado.getLong("pa.idplanta"));
	    pa.setNome(resultado.getString("pa.nome"));
	    pa.setTmin(resultado.getFloat("pa.tmin"));
	    pa.setTmax(resultado.getFloat("pa.tmax"));
	    pa.setTot(resultado.getFloat("pa.tot"));
	    pa.setIc(resultado.getFloat("pa.ic"));
	    pa.setUc(resultado.getFloat("pa.uc"));

	    p.setCliente_idcliente(c);
	    p.setPlanta_idplanta(pa);

	    lista.add(p);

	}
	return lista;
    }

    public Plantacao pesquisar(Plantacao plan) throws SQLException {
	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT p.idplantacao, p.data_plantio, p.area, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj, pa.idplanta, pa.nome, pa.tmin, pa.tmax, pa.tot, pa.ic, pa.uc ");
	sql.append(" FROM spin1.plantacao p ");
	sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = p.cliente_idcliente ");
	sql.append(" INNER JOIN spin1.planta pa ON pa.idplanta = p.planta_idplanta ");
	sql.append(" WHERE p.idplantacao = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, plan.getIdplantacao());

	ResultSet resultado = comando.executeQuery();

	Plantacao retorno = null;

	if (resultado.next()) {

	    retorno = new Plantacao();
	    Cliente c = new Cliente();
	    Planta pa = new Planta();

	    retorno.setIdplantacao(resultado.getLong("p.idplantacao"));
	    retorno.setData_plantio(resultado.getDate("p.data_plantio"));
	    retorno.setArea(resultado.getFloat("p.area"));

	    c.setIdcliente(resultado.getLong("c.idcliente"));
	    c.setNome(resultado.getString("c.nome"));
	    c.setCelular(resultado.getString("c.celular"));
	    c.setEndereco(resultado.getString("c.endereco"));
	    c.setCpf(resultado.getString("c.cpf"));
	    c.setRg(resultado.getString("c.rg"));
	    c.setEmail(resultado.getString("c.email"));
	    c.setSenha(resultado.getString("c.senha"));
	    c.setCnpj(resultado.getString("c.cnpj"));

	    pa.setIdplanta(resultado.getLong("pa.idplanta"));
	    pa.setNome(resultado.getString("pa.nome"));
	    pa.setTmin(resultado.getFloat("pa.tmin"));
	    pa.setTmax(resultado.getFloat("pa.tmax"));
	    pa.setTot(resultado.getFloat("pa.tot"));
	    pa.setIc(resultado.getFloat("pa.ic"));
	    pa.setUc(resultado.getFloat("pa.uc"));

	    retorno.setCliente_idcliente(c);
	    retorno.setPlanta_idplanta(pa);

	}

	return retorno;
    }
}