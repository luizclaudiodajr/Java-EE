package br.com.spinapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.com.spinapp.domain.Historico;
import br.com.spinapp.domain.Sensor;
import br.com.spinapp.factory.ConexaoFactory;

public class CalculosDAO {

    

    public float media(Historico hi) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT AVG(valor) valor ");
	sql.append(" FROM spin1.historico ");
	sql.append(" WHERE sensor_idsensor = ? AND data = ? ");

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

//	Date sqlDate = new Date(hi.getData().getDate());

	String dataAgora = new SimpleDateFormat("yyyy-MM-dd").format(hi.getData());
	
	comando.setLong(1, hi.getSensor_idsensor().getIdsensor());
	comando.setString(2, dataAgora);

	ResultSet resultado = comando.executeQuery();

	double media = 0;
	
	if (resultado.next()) {

	    media = resultado.getDouble("valor");

	}

	return (float) media;
    }
    
    public float maxima(Historico hi) throws SQLException {

   	StringBuilder sql = new StringBuilder();
   	sql.append(" SELECT MAX(valor) valor ");
   	sql.append(" FROM spin1.historico ");
   	sql.append(" WHERE sensor_idsensor = ? AND data = ? ");

   	Connection conexao = ConexaoFactory.conectar();

   	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

//   	Date sqlDate = new Date(hi.getData().getDate());

   	String dataAgora = new SimpleDateFormat("yyyy-MM-dd").format(hi.getData());
   	
   	comando.setLong(1, hi.getSensor_idsensor().getIdsensor());
   	comando.setString(2, dataAgora);

   	ResultSet resultado = comando.executeQuery();

   	double media = 0;
   	
   	if (resultado.next()) {

   	    media = resultado.getDouble("valor");

   	}

   	return (float) media;
       }
    
    public float minino(Historico hi) throws SQLException {

   	StringBuilder sql = new StringBuilder();
   	sql.append(" SELECT MIN(valor) valor ");
   	sql.append(" FROM spin1.historico ");
   	sql.append(" WHERE sensor_idsensor = ? AND data = ? ");

   	Connection conexao = ConexaoFactory.conectar();

   	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

//   	Date sqlDate = new Date(hi.getData().getDate());

   	String dataAgora = new SimpleDateFormat("yyyy-MM-dd").format(hi.getData());
   	
   	comando.setLong(1, hi.getSensor_idsensor().getIdsensor());
   	comando.setString(2, dataAgora);

   	ResultSet resultado = comando.executeQuery();

   	double media = 0;
   	
   	if (resultado.next()) {

   	    media = resultado.getDouble("valor");

   	}

   	return (float) media;
       }
    
    public ArrayList<Historico> listarDatas(Historico hi) throws SQLException {

	StringBuilder sql = new StringBuilder();
	sql.append(" SELECT DISTINCT data");
	sql.append(" FROM spin1.historico");
	sql.append(" WHERE sensor_idsensor = ? ");
	sql.append("ORDER BY data ASC ");// Ordenação implementar na tela jsf

	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());// permite_executar_comando_sql

	comando.setLong(1, hi.getSensor_idsensor().getIdsensor());
	ResultSet resultado = comando.executeQuery();

	ArrayList<Historico> lista = new ArrayList<Historico>();

	while (resultado.next()) {

		Historico h = new Historico();
		Sensor s = new Sensor();
		
		
	
		h.setData(resultado.getDate("data"));

		h.setSensor_idsensor(s);
		
		lista.add(h);

	}
	return lista;
}

}
