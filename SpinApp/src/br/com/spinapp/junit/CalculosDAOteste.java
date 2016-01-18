package br.com.spinapp.junit;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import br.com.spinapp.dao.CalculosDAO;
import br.com.spinapp.domain.Historico;
import br.com.spinapp.domain.Sensor;

public class CalculosDAOteste {

    @Test

    public void media() throws SQLException, ParseException {

	Historico hi = new Historico();
	Sensor se = new Sensor();
	
	
//	SimpleDateFormat databr = new SimpleDateFormat("yyyy-MM-dd");
//	
//	Date d1 = databr.parse("2014-10-10");
//	
	
	String oldstring = "2014-10-10 00:00:00.0";
	Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
	
	hi.setData(date);

	se.setIdsensor(3L);
	hi.setSensor_idsensor(se);

	
	CalculosDAO dao = new CalculosDAO();

	

	hi.setIdhistorico(3L);

	
	ArrayList<Historico> lista = dao.listarDatas(hi);

	for(Historico h : lista){
		
		System.out.println("\nID leitura: "+h.getIdhistorico());
		System.out.println("Data: "+h.getData());
		System.out.println("Hora: "+h.getHora());
		System.out.println("Valor: "+h.getValor());
		
		System.out.println("\nID Sensor: "+h.getSensor_idsensor().getIdsensor());
					
		System.out.println("\n********** ********** **********");	
	}
	
	
    }
    
    

}
