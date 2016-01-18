package br.com.spinapp.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

//	private static final String USUARIO = "root";
//	private static final String SENHA = "1234";
//	private static final String URL = "jdbc:mysql://localhost:3306/spin";

	private static final String USUARIO = "spin1";
	private static final String SENHA = "spin14";
	private static final String URL = "jdbc:mysql://186.202.152.213:3306/spin1";
    
	public static Connection conectar()throws SQLException{
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());//problema de driver
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		
		return conexao;
	}
	
}
