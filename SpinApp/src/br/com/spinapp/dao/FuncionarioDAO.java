package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Funcionario;
import br.com.spinapp.factory.ConexaoFactory;

public class FuncionarioDAO {
	
	public void inserir(Funcionario f) throws SQLException {

		StringBuilder sql = new StringBuilder();// para concatenação
		sql.append(" INSERT INTO spin1.funcionario ");// append juntar
		sql.append(" (nome, email, celular, senha, cliente_idcliente) ");
		sql.append(" VALUES (?, ?, ?, ?, ?) ");

		// conexão com BD
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		

		comando.setString(1, f.getNome());
		comando.setString(2, f.getEmail());
		comando.setString(3, f.getCelular());
		comando.setString(4, f.getSenha());
		comando.setLong(5, f.getCliente_idcliente().getIdcliente());
		
		comando.executeUpdate();
	}
	
	public void excluir(Funcionario f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM spin1.funcionario ");
		sql.append(" WHERE idfuncionario = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, f.getIdfuncionario());

		comando.executeUpdate();

	}
	
	public void atualizar(Funcionario f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE spin1.funcionario ");
		sql.append(" SET nome = ?, email = ?, celular = ?, senha = ?, cliente_idcliente = ? " );
		sql.append(" WHERE idfuncionario = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setString(1, f.getNome());
		comando.setString(2, f.getEmail());
		comando.setString(3, f.getCelular());
		comando.setString(4, f.getSenha());
		comando.setLong(5, f.getCliente_idcliente().getIdcliente());
		comando.setLong(6, f.getIdfuncionario());

		comando.executeUpdate();
	}
	
	public ArrayList<Funcionario> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT f.idfuncionario, f.nome, f.email, f.celular, f.senha, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj ");
		sql.append(" FROM spin1.funcionario f ");
		sql.append(" INNER JOIN cliente c ON c.idcliente = f.cliente_idcliente ");
		//sql.append("ORDER BY tipo ASC ");// Ordenação implementar na tela jsf

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

		while (resultado.next()) {

			Funcionario f = new Funcionario();
			Cliente c = new Cliente();

			
			f.setIdfuncionario(resultado.getLong("f.idfuncionario"));
			f.setNome(resultado.getString("f.nome"));
			f.setEmail(resultado.getString("f.email"));
			f.setCelular(resultado.getString("f.celular"));
			f.setSenha(resultado.getString("f.senha"));
			
			
			c.setIdcliente(resultado.getLong("c.idcliente"));
			c.setNome(resultado.getString("c.nome"));
			c.setCelular(resultado.getString("c.celular"));
			c.setEndereco(resultado.getString("c.endereco"));
			c.setCpf(resultado.getString("c.cpf"));
			c.setRg(resultado.getString("c.rg"));
			c.setEmail(resultado.getString("c.email"));
			c.setSenha(resultado.getString("c.senha"));
			c.setCnpj(resultado.getString("c.cnpj"));
			
			f.setCliente_idcliente(c);
	
			
			lista.add(f);

		}
		return lista;
	}
	
	public ArrayList<Funcionario> listarPorId(Funcionario fun) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT f.idfuncionario, f.nome, f.email, f.celular, f.senha, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj ");
		sql.append(" FROM spin1.funcionario f ");
		sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = f.cliente_idcliente ");
		sql.append(" WHERE f.idfuncionario = ? ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		comando.setLong(1, fun.getIdfuncionario());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

		while (resultado.next()) {

			Funcionario f = new Funcionario();
			Cliente c = new Cliente();

			
			f.setIdfuncionario(resultado.getLong("f.idfuncionario"));
			f.setNome(resultado.getString("f.nome"));
			f.setEmail(resultado.getString("f.email"));
			f.setCelular(resultado.getString("f.celular"));
			f.setSenha(resultado.getString("f.senha"));
			
			
			c.setIdcliente(resultado.getLong("c.idcliente"));
			c.setNome(resultado.getString("c.nome"));
			c.setCelular(resultado.getString("c.celular"));
			c.setEndereco(resultado.getString("c.endereco"));
			c.setCpf(resultado.getString("c.cpf"));
			c.setRg(resultado.getString("c.rg"));
			c.setEmail(resultado.getString("c.email"));
			c.setSenha(resultado.getString("c.senha"));
			c.setCnpj(resultado.getString("c.cnpj"));
			
			f.setCliente_idcliente(c);
	
			
			lista.add(f);

		}
		return lista;
	}
	
	public ArrayList<Funcionario> listarPorNome(Funcionario fun) throws SQLException {


		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT f.idfuncionario, f.nome, f.email, f.celular, f.senha, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj ");
		sql.append(" FROM spin1.funcionario f ");
		sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = f.cliente_idcliente ");
		sql.append(" WHERE f.nome LIKE ? ");
		sql.append(" ORDER BY f.nome ASC ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

		comando.setString(1, "%" + fun.getNome() + "%");
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

		while (resultado.next()) {

			Funcionario f = new Funcionario();
			Cliente c = new Cliente();
			
			f.setIdfuncionario(resultado.getLong("f.idfuncionario"));
			f.setNome(resultado.getString("f.nome"));
			f.setEmail(resultado.getString("f.email"));
			f.setCelular(resultado.getString("f.celular"));
			f.setSenha(resultado.getString("f.senha"));
			
			c.setIdcliente(resultado.getLong("c.idcliente"));
			c.setNome(resultado.getString("c.nome"));
			c.setCelular(resultado.getString("c.celular"));
			c.setEndereco(resultado.getString("c.endereco"));
			c.setCpf(resultado.getString("c.cpf"));
			c.setRg(resultado.getString("c.rg"));
			c.setEmail(resultado.getString("c.email"));
			c.setSenha(resultado.getString("c.senha"));
			c.setCnpj(resultado.getString("c.cnpj"));
			
			f.setCliente_idcliente(c);
	
			lista.add(f);

		}
		return lista;
	}
	
	public Funcionario pesquisar(Funcionario fun) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT f.idfuncionario, f.nome, f.email, f.celular, f.senha, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj ");
		sql.append(" FROM spin1.funcionario f ");
		sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = f.cliente_idcliente ");
		sql.append(" WHERE f.idfuncionario = ? ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				 
																				 
		comando.setLong(1, fun.getIdfuncionario());

		ResultSet resultado = comando.executeQuery();

		Funcionario retorno = null;

		if (resultado.next()) {

			retorno = new Funcionario();
			Cliente c = new Cliente();
			
			
			retorno.setIdfuncionario(resultado.getLong("f.idfuncionario"));
			retorno.setNome(resultado.getString("f.nome"));
			retorno.setEmail(resultado.getString("f.email"));
			retorno.setCelular(resultado.getString("f.celular"));
			retorno.setSenha(resultado.getString("f.senha"));
			
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