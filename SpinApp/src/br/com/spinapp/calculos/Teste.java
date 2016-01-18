package br.com.spinapp.calculos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.spinapp.domain.Historico;

public class Teste {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		EvapotranspiracaoPenmanMonteith p=new EvapotranspiracaoPenmanMonteith();
		Temperatura td = new Temperatura();
		Utilitario u = new Utilitario();
		ArrayList<Historico> lista= new ArrayList<Historico>();
		
		float t= (float)25.6;
		float patm= (float)97.402;
		float ur=(float)81.6;
		float latitude= 20;
		float longitude= 25;
		int dia=15;
		int mes=10;
		int ano= 2004;
		float z= 335;
		float hemi= -1;
		float krs=(float)0.16;
		float tmax=(float)32.3;
		float tmin=(float)22.3;
		float g=(float)0.6;
		float u2=(float)1.6;
		
		
		SimpleDateFormat databr = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timebr = new SimpleDateFormat("HH:mm:ss");
		
		
		
		Historico h1= new Historico();
		h1.setValor((float)2);
		Date d1 = databr.parse("2014-10-10");
		Date d2 = timebr.parse("20:10:02");
		h1.setData(d1);
		h1.setHora(d2);
		lista.add(h1);
		
		Historico h2= new Historico();
		h2.setValor((float)18);
		d1 = databr.parse("2014-10-11");
		d2 = timebr.parse("21:30:02");
		h2.setData(d1);
		h2.setHora(d2);
		lista.add(h2);
		/*
		Historico h3= new Historico();
		h3.setValor((float)19.7);
		d1 = databr.parse("2014-10-12");
		d2 = timebr.parse("20:40:02");
		h3.setData(d1);
		h3.setHora(d2);
		lista.add(h3);
		
		Historico h4= new Historico();
		h4.setValor((float)21.3);
		d1 = databr.parse("2014-10-13");
		d2 = timebr.parse("21:40:02");
		h4.setData(d1);
		h4.setHora(d2);
		lista.add(h4);
		
		Historico h5= new Historico();
		h5.setValor((float)22.4);
		d1 = databr.parse("2014-10-14");
		d2 = timebr.parse("21:10:02");
		h5.setData(d1);
		h5.setHora(d2);
		lista.add(h5);
		
		Historico h6= new Historico();
		h6.setValor((float)23.0);
		d1 = databr.parse("2014-10-15");
		d2 = timebr.parse("21:10:02");
		h6.setData(d1);
		h6.setHora(d2);
		lista.add(h6);
		*/
		for(int i = 0; i < lista.size(); i++)
        {
           
            	System.out.print(lista.get(i).toString()+"\n");

            	 
             
        }	
		
		//PlanejamentoDeColheita px = new PlanejamentoDeColheita(); 
		//System.out.print(px.Colheita(10, 1550, lista));
		
		//System.out.print(u.valorMaximo(lista)+" - "); OK
		//System.out.print(u.valorMinino(lista)+" - "); OK
		//System.out.print(u.mediaValor(lista)+" - "); OK
		
		//System.out.print(p.delta(t));
		//System.out.print(p.y(patm)); OK
		//System.out.print(p.es(t));// OK
		//System.out.print(p.ea((float)28,(float)27.8));
		//System.out.print(p.w(latitude, longitude, hemi)); OK
		//System.out.print(p.dr(dia, mes, ano)); OK
		//System.out.print(p.gs(dia, mes, ano)); OK
		//System.out.print(p.ws(latitude, longitude, hemi, dia, mes, ano)); OK
		//System.out.print(p.ra(latitude, longitude, hemi, dia, mes, ano)); OK
		//System.out.print(p.rso(latitude, longitude, hemi, dia, mes, ano, z)); OK
		//System.out.print(p.rn(dia, mes, ano, krs, tmax, tmin, latitude, longitude, hemi, z, tmin, ur));
		//System.out.print(p.rnl(latitude, longitude, hemi, dia, mes, ano, z, tmax, tmin, longitude, ur, krs));
		//System.out.print(p.calcularEvapotranspiracao(t, dia, mes, ano, krs, tmax, tmin, latitude, longitude, hemi, z, ur, g, patm, u2)); //OKKKKK!
		
		//System.out.print(td.to(28,(float)27.8)); OK
		
	}

}
