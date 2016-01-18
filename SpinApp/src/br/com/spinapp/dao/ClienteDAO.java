package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Cliente;
import br.com.spinapp.factory.ConexaoFactory;

public class ClienteDAO {

    public void inserir(Cliente c) throws SQLException {

	StringBuilder sql = new StringBuilder();// para concatenação
	sql.append(" INSERT INTO spin1.cliente ");// append juntar
	sql.append(" (nome, celular, endereco, cpf, rg, email, senha, cnpj) ");
	sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");

	// conexão com BD
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite
									     // executar
									     // comando
									     // sql

	comando.setString(1, c.getNome());
	comando.setString(2, c.getCelular());
	comando.setString(3, c.getEndereco());
	comando.setString(4, c.getCpf());
	comando.setString(5, c.getRg());
	comando.setString(6, c.getEmail());
	comando.setString(7, c.getSenha());
	comando.setString(8, c.getCnpj());

	comando.executeUpdate();
    }

    public void excluir(Cliente c) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" DELETE FROM spin1.cliente ");
	sql.append(" WHERE idcliente = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite
									     // executar
									     // comando
									     // sql

	comando.setLong(1, c.getIdcliente());

	comando.executeUpdate();

    }

    public void atualizar(Cliente c) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" UPDATE spin1.cliente ");
	sql.append(" SET nome = ?, celular = ?, endereco = ?, cpf = ?, rg = ?, email = ?, senha = ?, cnpj = ? ");
	sql.append(" WHERE idcliente = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite
									     // executar
									     // comando
									     // sql

	comando.setString(1, c.getNome());
	comando.setString(2, c.getCelular());
	comando.setString(3, c.getEndereco());
	comando.setString(4, c.getCpf());
	comando.setString(5, c.getRg());
	comando.setString(6, c.getEmail());
	comando.setString(7, c.getSenha());
	comando.setString(8, c.getCnpj());
	comando.setLong(9, c.getIdcliente());

	comando.executeUpdate();
    }

    public ArrayList<Cliente> listar() throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT idcliente, nome, celular, endereco, cpf, rg, email, senha, cnpj ");
	sql.append(" FROM spin1.cliente ");
	// sql.append("ORDER BY nome ASC ");// Ordenação implementar na tela jsf

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite
									     // executar
									     // comando
									     // sql

	ResultSet resultado = comando.executeQuery();

	ArrayList<Cliente> lista = new ArrayList<Cliente>();

	while (resultado.next()) {

	    Cliente c = new Cliente();

	    c.setIdcliente(resultado.getLong("idcliente"));
	    c.setNome(resultado.getString("nome"));
	    c.setCelular(resultado.getString("celular"));
	    c.setEndereco(resultado.getString("endereco"));
	    c.setCpf(resultado.getString("cpf"));
	    c.setRg(resultado.getString("rg"));
	    c.setEmail(resultado.getString("email"));
	    c.setSenha(resultado.getString("senha"));
	    c.setCnpj(resultado.getString("cnpj"));

	    lista.add(c);

	}
	return lista;
    }

    public ArrayList<Cliente> listarPorId(Cliente c) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT idcliente, nome, celular, endereco, cpf, rg, email, senha, cnpj ");
	sql.append(" FROM spin1.cliente ");
	sql.append(" WHERE idcliente = ? ");
	sql.append(" ORDER BY nome ASC ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite
									     // executar
									     // comando
									     // sql

	comando.setLong(1, c.getIdcliente());

	ResultSet resultado = comando.executeQuery();

	ArrayList<Cliente> lista = new ArrayList<Cliente>();

	while (resultado.next()) {

	    Cliente item = new Cliente();

	    item.setIdcliente(resultado.getLong("idcliente"));
	    item.setNome(resultado.getString("nome"));
	    item.setCelular(resultado.getString("celular"));
	    item.setEndereco(resultado.getString("endereco"));
	    item.setCpf(resultado.getString("cpf"));
	    item.setRg(resultado.getString("rg"));
	    item.setEmail(resultado.getString("email"));
	    item.setSenha(resultado.getString("senha"));
	    item.setCnpj(resultado.getString("cnpj"));

	    lista.add(item);

	}
	return lista;
    }

    public ArrayList<Cliente> listarPorNome(Cliente c) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT idcliente, nome, celular, endereco, cpf, rg, email, senha, cnpj ");
	sql.append(" FROM spin1.cliente ");
	sql.append(" WHERE nome LIKE ? ");
	sql.append(" ORDER BY nome ASC ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite
									     // executar
									     // comando
									     // sql
	comando.setString(1, "%" + c.getNome() + "%");
	ResultSet resultado = comando.executeQuery();

	ArrayList<Cliente> lista = new ArrayList<Cliente>();

	while (resultado.next()) {

	    Cliente item = new Cliente();

	    item.setIdcliente(resultado.getLong("idcliente"));
	    item.setNome(resultado.getString("nome"));
	    item.setCelular(resultado.getString("celular"));
	    item.setEndereco(resultado.getString("endereco"));
	    item.setCpf(resultado.getString("cpf"));
	    item.setRg(resultado.getString("rg"));
	    item.setEmail(resultado.getString("email"));
	    item.setSenha(resultado.getString("senha"));
	    item.setCnpj(resultado.getString("cnpj"));

	    lista.add(item);

	}
	return lista;
    }

    public Cliente pesquisar(Cliente c) throws SQLException {
	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT idcliente, nome, celular, endereco, cpf, rg, email, senha, cnpj ");
	sql.append(" FROM spin1.cliente ");
	sql.append(" WHERE idcliente = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite
									     // executar
									     // comando
									     // sql

	comando.setLong(1, c.getIdcliente());

	ResultSet resultado = comando.executeQuery();

	Cliente retorno = null;

	if (resultado.next()) {
	    retorno = new Cliente();

	    retorno.setIdcliente(resultado.getLong("idcliente"));
	    retorno.setNome(resultado.getString("nome"));
	    retorno.setCelular(resultado.getString("celular"));
	    retorno.setEndereco(resultado.getString("endereco"));
	    retorno.setCpf(resultado.getString("cpf"));
	    retorno.setRg(resultado.getString("rg"));
	    retorno.setEmail(resultado.getString("email"));
	    retorno.setSenha(resultado.getString("senha"));
	    retorno.setCnpj(resultado.getString("cnpj"));
	}

	return retorno;
    }
}
