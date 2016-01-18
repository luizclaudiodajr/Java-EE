package br.com.spinapp.junit;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import br.com.spinapp.factory.ConexaoFactory;

public class ConexaoFactoryTeste {
	
	@Test
	@Ignore
	public void conexao(){
		try{
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexão realizada com sucesso "+conexao);
		}catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Não foi possivel realizar a conexão");
		}
	}
}
