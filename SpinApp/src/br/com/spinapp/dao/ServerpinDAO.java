package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Serverpin;
import br.com.spinapp.factory.ConexaoFactory;

public class ServerpinDAO {

    public void inserir(Serverpin s) throws SQLException {

	StringBuilder sql = new StringBuilder();// para concatenação
	sql.append(" INSERT INTO spin1.serverpin ");// append juntar
	sql.append(" (ip, mac, porta, latitude, longitude, altitude, gsm, cliente_idcliente) ");
	sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");

	// conexão com BD
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setString(1, s.getIp());
	comando.setString(2, s.getMac());
	comando.setInt(3, s.getPorta());
	comando.setFloat(4, s.getLatitude());
	comando.setFloat(5, s.getLongitude());
	comando.setFloat(6, s.getAltitude());
	comando.setString(7, s.getGsm());

	comando.setLong(8, s.getCliente_idcliente().getIdcliente());

	comando.executeUpdate();
    }

    public void excluir(Serverpin s) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" DELETE FROM spin1.serverpin ");
	sql.append(" WHERE idserver = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, s.getIdserver());

	comando.executeUpdate();

    }

    public void atualizar(Serverpin s) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" UPDATE spin1.serverpin ");
	sql.append(" SET ip = ?, mac = ?, porta = ?, latitude = ?, longitude = ?, altitude = ?, gsm = ?, cliente_idcliente = ? ");
	sql.append(" WHERE idserver = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setString(1, s.getIp());
	comando.setString(2, s.getMac());
	comando.setInt(3, s.getPorta());
	comando.setFloat(4, s.getLatitude());
	comando.setFloat(5, s.getLongitude());
	comando.setFloat(6, s.getAltitude());
	comando.setString(7, s.getGsm());
	comando.setLong(8, s.getCliente_idcliente().getIdcliente());
	comando.setLong(9, s.getIdserver());

	comando.executeUpdate();
    }

    public ArrayList<Serverpin> listar() throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT s.idserver, s.ip, s.mac, s.porta, s.latitude, s.longitude, s.altitude, s.gsm, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj ");
	sql.append(" FROM spin1.serverpin s ");
	sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = s.cliente_idcliente ");
	// sql.append("ORDER BY tipo ASC ");// Ordenação implementar na tela jsf

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	ResultSet resultado = comando.executeQuery();

	ArrayList<Serverpin> lista = new ArrayList<Serverpin>();

	while (resultado.next()) {

	    Serverpin s = new Serverpin();
	    Cliente c = new Cliente();

	    s.setIdserver(resultado.getLong("s.idserver"));
	    s.setIp(resultado.getString("s.ip"));
	    s.setMac(resultado.getString("s.mac"));
	    s.setPorta(resultado.getInt("s.porta"));
	    s.setLatitude(resultado.getFloat("s.latitude"));
	    s.setLongitude(resultado.getFloat("s.longitude"));
	    s.setAltitude(resultado.getFloat("s.altitude"));
	    s.setGsm(resultado.getString("s.gsm"));

	    c.setIdcliente(resultado.getLong("c.idcliente"));
	    c.setNome(resultado.getString("c.nome"));
	    c.setCelular(resultado.getString("c.celular"));
	    c.setEndereco(resultado.getString("c.endereco"));
	    c.setCpf(resultado.getString("c.cpf"));
	    c.setRg(resultado.getString("c.rg"));
	    c.setEmail(resultado.getString("c.email"));
	    c.setSenha(resultado.getString("c.senha"));
	    c.setCnpj(resultado.getString("c.cnpj"));

	    s.setCliente_idcliente(c);

	    lista.add(s);

	}
	return lista;
    }

    public ArrayList<Serverpin> listarPorId(Serverpin sp) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT s.idserver, s.ip, s.mac, s.porta, s.latitude, s.longitude, s.altitude, s.gsm, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj ");
	sql.append(" FROM spin1.serverpin s ");
	sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = s.cliente_idcliente ");
	sql.append(" WHERE s.idserver = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, sp.getIdserver());

	ResultSet resultado = comando.executeQuery();

	ArrayList<Serverpin> lista = new ArrayList<Serverpin>();

	while (resultado.next()) {

	    Serverpin s = new Serverpin();
	    Cliente c = new Cliente();

	    s.setIdserver(resultado.getLong("s.idserver"));
	    s.setIp(resultado.getString("s.ip"));
	    s.setMac(resultado.getString("s.mac"));
	    s.setPorta(resultado.getInt("s.porta"));
	    s.setLatitude(resultado.getFloat("s.latitude"));
	    s.setLongitude(resultado.getFloat("s.longitude"));
	    s.setAltitude(resultado.getFloat("s.altitude"));
	    s.setGsm(resultado.getString("s.gsm"));

	    c.setIdcliente(resultado.getLong("c.idcliente"));
	    c.setNome(resultado.getString("c.nome"));
	    c.setCelular(resultado.getString("c.celular"));
	    c.setEndereco(resultado.getString("c.endereco"));
	    c.setCpf(resultado.getString("c.cpf"));
	    c.setRg(resultado.getString("c.rg"));
	    c.setEmail(resultado.getString("c.email"));
	    c.setSenha(resultado.getString("c.senha"));
	    c.setCnpj(resultado.getString("c.cnpj"));

	    s.setCliente_idcliente(c);

	    lista.add(s);

	}
	return lista;
    }

    public ArrayList<Serverpin> listarPorIp(Serverpin sp) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT s.idserver, s.ip, s.mac, s.porta, s.latitude, s.longitude, s.altitude, s.gsm, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj ");
	sql.append(" FROM spin1.serverpin s ");
	sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = s.cliente_idcliente ");
	sql.append(" WHERE s.ip LIKE ? ");
	sql.append(" ORDER BY s.ip ASC ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setString(1, "%" + sp.getIp() + "%");

	ResultSet resultado = comando.executeQuery();

	ArrayList<Serverpin> lista = new ArrayList<Serverpin>();

	while (resultado.next()) {

	    Serverpin s = new Serverpin();
	    Cliente c = new Cliente();

	    s.setIdserver(resultado.getLong("s.idserver"));
	    s.setIp(resultado.getString("s.ip"));
	    s.setMac(resultado.getString("s.mac"));
	    s.setPorta(resultado.getInt("s.porta"));
	    s.setLatitude(resultado.getFloat("s.latitude"));
	    s.setLongitude(resultado.getFloat("s.longitude"));
	    s.setAltitude(resultado.getFloat("s.altitude"));
	    s.setGsm(resultado.getString("s.gsm"));

	    c.setIdcliente(resultado.getLong("c.idcliente"));
	    c.setNome(resultado.getString("c.nome"));
	    c.setCelular(resultado.getString("c.celular"));
	    c.setEndereco(resultado.getString("c.endereco"));
	    c.setCpf(resultado.getString("c.cpf"));
	    c.setRg(resultado.getString("c.rg"));
	    c.setEmail(resultado.getString("c.email"));
	    c.setSenha(resultado.getString("c.senha"));
	    c.setCnpj(resultado.getString("c.cnpj"));

	    s.setCliente_idcliente(c);

	    lista.add(s);
	}
	return lista;
    }

    public Serverpin pesquisar(Serverpin sp) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT s.idserver, s.ip, s.mac, s.porta, s.latitude, s.longitude, s.altitude, s.gsm, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj ");
	sql.append(" FROM spin1.serverpin s ");
	sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = s.cliente_idcliente ");
	sql.append(" WHERE s.idserver = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, sp.getIdserver());

	ResultSet resultado = comando.executeQuery();

	Serverpin retorno = null;

	if (resultado.next()) {

	    retorno = new Serverpin();
	    Cliente c = new Cliente();

	    retorno.setIdserver(resultado.getLong("s.idserver"));
	    retorno.setIp(resultado.getString("s.ip"));
	    retorno.setMac(resultado.getString("s.mac"));
	    retorno.setPorta(resultado.getInt("s.porta"));
	    retorno.setLatitude(resultado.getFloat("s.latitude"));
	    retorno.setLongitude(resultado.getFloat("s.longitude"));
	    retorno.setAltitude(resultado.getFloat("s.altitude"));
	    retorno.setGsm(resultado.getString("s.gsm"));

	    c.setIdcliente(resultado.getLong("c.idcliente"));
	    c.setNome(resultado.getString("c.nome"));
	    c.setCelular(resultado.getString("c.celular"));
	    c.setEndereco(resultado.getString("c.endereco"));
	    c.setCpf(resultado.getString("c.cpf"));
	    c.setRg(resultado.getString("c.rg"));
	    c.setEmail(resultado.getString("c.email"));
	    c.setSenha(resultado.getString("c.senha"));
	    c.setCnpj(resultado.getString("c.cnpj"));

	    retorno.setCliente_idcliente(c);

	}
	return retorno;
    }
}