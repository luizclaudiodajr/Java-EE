package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.spinapp.domain.Assinatura;
import br.com.spinapp.domain.Cliente;
import br.com.spinapp.domain.Plano;
import br.com.spinapp.factory.ConexaoFactory;

public class AssinaturaDAO {

	public void inserir(Assinatura a) throws SQLException {

		StringBuilder sql = new StringBuilder();// para concatenação
		sql.append(" INSERT INTO spin1.assinatura ");// append juntar
		sql.append(" (data_in, data_out, cliente_idcliente, plano_idplano) ");
		sql.append(" VALUES (?, ?, ?, ?) ");

		// conexão com BD
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		

		Date sqlDatein = new Date(a.getDatain().getTime());
		Date sqlDateout = new Date(a.getDataout().getTime());


		comando.setDate(1, sqlDatein);
		comando.setDate(2, sqlDateout);
		comando.setLong(3, a.getCliente_idcliente().getIdcliente());
		comando.setLong(4, a.getPlano_idplano().getIdplano());
		
		comando.executeUpdate();
	}

	public void excluir(Assinatura a) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM spin1.assinatura ");
		sql.append(" WHERE idassinatura = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, a.getIdassina());

		comando.executeUpdate();

	}

	public void atualizar(Assinatura a) throws SQLException {

		
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE spin1.assinatura ");
		sql.append(" SET data_in = ?, data_out = ?, cliente_idcliente = ?, plano_idplano = ? ");
		sql.append(" WHERE idassinatura = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		

		Date sqlDatein = new Date(a.getDatain().getTime());
		Date sqlDateout = new Date(a.getDataout().getTime());
		
		
		comando.setDate(1, sqlDatein);
		comando.setDate(2, sqlDateout);
		comando.setLong(3, a.getCliente_idcliente().getIdcliente());
		comando.setLong(4, a.getPlano_idplano().getIdplano());
		comando.setLong(5, a.getIdassina());

		comando.executeUpdate();
	}

	public ArrayList<Assinatura> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT a.idassinatura, a.data_in, a.data_out, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj, p.idplano, p.tipo, p.preco, p.duracao, p.descricao ");
		sql.append(" FROM spin1.assinatura a ");
		sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = a.cliente_idcliente ");
		sql.append(" INNER JOIN spin1.plano p ON p.idplano = a.plano_idplano ");
		//sql.append("ORDER BY tipo ASC ");// Ordenação implementar na tela jsf

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Assinatura> lista = new ArrayList<Assinatura>();

		while (resultado.next()) {

			Assinatura a = new Assinatura();
			Cliente c = new Cliente();
			Plano p = new Plano();
			
			
			a.setIdassina(resultado.getLong("a.idassinatura"));
			a.setDatain(resultado.getDate("a.data_in"));
			a.setDataout(resultado.getDate("a.data_out"));
			
			c.setIdcliente(resultado.getLong("c.idcliente"));
			c.setNome(resultado.getString("c.nome"));
			c.setCelular(resultado.getString("c.celular"));
			c.setEndereco(resultado.getString("c.endereco"));
			c.setCpf(resultado.getString("c.cpf"));
			c.setRg(resultado.getString("c.rg"));
			c.setEmail(resultado.getString("c.email"));
			c.setSenha(resultado.getString("c.senha"));
			c.setCnpj(resultado.getString("c.cnpj"));
			
			p.setIdplano(resultado.getLong("p.idplano"));
			p.setTipo(resultado.getString("p.tipo"));
			p.setPreco(resultado.getFloat("p.preco"));
			p.setDuracao(resultado.getString("p.duracao"));
			p.setDescricao(resultado.getString("p.descricao"));

			a.setCliente_idcliente(c);
			a.setPlano_idplano(p);
	
			
			lista.add(a);

		}
		return lista;
	}

	public ArrayList<Assinatura> listarPorId(Assinatura as) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT a.idassinatura, a.data_in, a.data_out, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj, p.idplano, p.tipo, p.preco, p.duracao, p.descricao ");
		sql.append(" FROM spin1.assinatura a ");
		sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = a.cliente_idcliente ");
		sql.append(" INNER JOIN spin1.plano p ON p.idplano = a.plano_idplano ");
		sql.append(" WHERE a.idassinatura = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, as.getIdassina());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Assinatura> lista = new ArrayList<Assinatura>();

		while (resultado.next()) {

			Assinatura a = new Assinatura();
			Cliente c = new Cliente();
			Plano p = new Plano();
			
			
			a.setIdassina(resultado.getLong("a.idassinatura"));
			a.setDatain(resultado.getDate("a.data_in"));
			a.setDataout(resultado.getDate("a.data_out"));
			
			c.setIdcliente(resultado.getLong("c.idcliente"));
			c.setNome(resultado.getString("c.nome"));
			c.setCelular(resultado.getString("c.celular"));
			c.setEndereco(resultado.getString("c.endereco"));
			c.setCpf(resultado.getString("c.cpf"));
			c.setRg(resultado.getString("c.rg"));
			c.setEmail(resultado.getString("c.email"));
			c.setSenha(resultado.getString("c.senha"));
			c.setCnpj(resultado.getString("c.cnpj"));
			
			p.setIdplano(resultado.getLong("p.idplano"));
			p.setTipo(resultado.getString("p.tipo"));
			p.setPreco(resultado.getFloat("p.preco"));
			p.setDuracao(resultado.getString("p.duracao"));
			p.setDescricao(resultado.getString("p.descricao"));

			a.setCliente_idcliente(c);
			a.setPlano_idplano(p);
	
			
			lista.add(a);

		}
		return lista;
	}

	public ArrayList<Assinatura> listarPorIdcliente(Assinatura as) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT a.idassinatura, a.data_in, a.data_out, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj, p.idplano, p.tipo, p.preco, p.duracao, p.descricao ");
		sql.append(" FROM spin1.assinatura a ");
		sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = a.cliente_idcliente ");
		sql.append(" INNER JOIN spin1.plano p ON p.idplano = a.plano_idplano ");
		sql.append(" WHERE c.idcliente = ? ");


		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
		
		
		comando.setLong(1, as.getCliente_idcliente().getIdcliente());
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Assinatura> lista = new ArrayList<Assinatura>();

		while (resultado.next()) {

			Assinatura a = new Assinatura();
			Cliente c = new Cliente();
			Plano p = new Plano();
			
			
			a.setIdassina(resultado.getLong("a.idassinatura"));
			a.setDatain(resultado.getDate("a.data_in"));
			a.setDataout(resultado.getDate("a.data_out"));
			
			c.setIdcliente(resultado.getLong("c.idcliente"));
			c.setNome(resultado.getString("c.nome"));
			c.setCelular(resultado.getString("c.celular"));
			c.setEndereco(resultado.getString("c.endereco"));
			c.setCpf(resultado.getString("c.cpf"));
			c.setRg(resultado.getString("c.rg"));
			c.setEmail(resultado.getString("c.email"));
			c.setSenha(resultado.getString("c.senha"));
			c.setCnpj(resultado.getString("c.cnpj"));
			
			p.setIdplano(resultado.getLong("p.idplano"));
			p.setTipo(resultado.getString("p.tipo"));
			p.setPreco(resultado.getFloat("p.preco"));
			p.setDuracao(resultado.getString("p.duracao"));
			p.setDescricao(resultado.getString("p.descricao"));

			a.setCliente_idcliente(c);
			a.setPlano_idplano(p);
	
			
			lista.add(a);

		}
		return lista;
	}

	public Assinatura pesquisar(Assinatura as) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT a.idassinatura, a.data_in, a.data_out, c.idcliente, c.nome, c.celular, c.endereco, c.cpf, c.rg, c.email, c.senha, c.cnpj, p.idplano, p.tipo, p.preco, p.duracao, p.descricao ");
		sql.append(" FROM spin1.assinatura a ");
		sql.append(" INNER JOIN spin1.cliente c ON c.idcliente = a.cliente_idcliente ");
		sql.append(" INNER JOIN spin1.plano p ON p.idplano = a.plano_idplano ");
		sql.append(" WHERE a.idassinatura = ? ");
		
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql
																				 
																				 
		comando.setLong(1, as.getIdassina());

		ResultSet resultado = comando.executeQuery();

		Assinatura retorno = null;

		if (resultado.next()) {

			retorno = new Assinatura();
			Cliente c = new Cliente();
			Plano p = new Plano();
			
			
			retorno.setIdassina(resultado.getLong("a.idassinatura"));
			retorno.setDatain(resultado.getDate("a.data_in"));
			retorno.setDataout(resultado.getDate("a.data_out"));
			
			c.setIdcliente(resultado.getLong("c.idcliente"));
			c.setNome(resultado.getString("c.nome"));
			c.setCelular(resultado.getString("c.celular"));
			c.setEndereco(resultado.getString("c.endereco"));
			c.setCpf(resultado.getString("c.cpf"));
			c.setRg(resultado.getString("c.rg"));
			c.setEmail(resultado.getString("c.email"));
			c.setSenha(resultado.getString("c.senha"));
			c.setCnpj(resultado.getString("c.cnpj"));
			
			p.setIdplano(resultado.getLong("p.idplano"));
			p.setTipo(resultado.getString("p.tipo"));
			p.setPreco(resultado.getFloat("p.preco"));
			p.setDuracao(resultado.getString("p.duracao"));
			p.setDescricao(resultado.getString("p.descricao"));

			retorno.setCliente_idcliente(c);
			retorno.setPlano_idplano(p);

		}

		return retorno;
	}
}
