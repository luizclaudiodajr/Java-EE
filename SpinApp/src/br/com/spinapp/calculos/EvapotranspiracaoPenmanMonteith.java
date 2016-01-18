package br.com.spinapp.calculos;

/**Classe Estmativa de evapotranspiração, utilizando o Método de Penman-Monteith.

 * @author Wellington Cássio Faria

 * @version 1.0

 * @since SPIn

 */

/*
 *  Programação Baseada no Circular Técnica : "Roteiro de cálculo da evapotranspiração de referência pelo método de Penman-Monteith-FAO
 *  Bento Gonçalves, Rs, Dezembro, 2006.
 *  Autor: Marcos Antônio Fonseca Conceição, Embrapa Uva e Vinhos.
 */
public class EvapotranspiracaoPenmanMonteith {
	
	/*
	 * Variaveis:
	 * T= Temperatura média do ar (ºC);
	 * patm = Pressao atmosférica local (kPa);
	 * UR = Umidade relativa média do ar (%);
	 * Tmin e Tmax = Temperatura minima e maxima do dia (ºC)
	 * Dia, Mes, Ano = Dia, mês e ano;
	 * Hemi = Hemisterio Norte = 1 e Hemisterio Sul = -1 ;
	 * Latidude e Longitude = Latitude do local onde: Latidude º Longitude ' ;
	 * Z = Altitude do Local (m);
	 * Krs = Coeficiente empiríco igual a 0.16 para regiões continentais e 0.19 regiões costeiras;
	 * G= Fluxo total diario de calor de calor no solo (MJm^-2dia^-1) -> Os baixos valores de G normalmente registrados em escalas diarias, pode-se considera-lo sendo igual a ZERO, quanto não estão disponiveis(ALLLEN et al.,1998)
	 * U2 = Velocidade do Vento a 2m de altura (ms^-1);
	 */
	
	/** Calcula a declividade da curva de pressão de valor em relação à temperatura (kPaºC^⁻1)
	 * @param t Temperatura média do ar (ºC);
	 * @return Declividade da curva de pressão de valor em relação à temperatura (kPaºC^⁻1)
	 */
	public float delta (float t) 
	{
		return (float) ((4098*(0.6108*Math.exp((17.27*t)/(t+237.3))))/Math.pow(t+237.3,2.0));
	}
	
	/**
	 * Calculo do Coeficiente psicrométrico (kPaºC^-1);
	 * @param patm Pressao atmosférica local (kPa);
	 * @return Coeficiente psicrométrico (kPaºC^-1);
	 */
	public float y (float patm)
	{
		return (float) (0.665*Math.pow(10,-3)*patm);
	}
	
	/**
	 * Calcula a pressão de saturação de vapor(KPa);
	 * @param t Temperatura média do ar (ºC);
	 * @return Pressão de saturação de vapor(KPa);
	 */
	public float es (float t) 
	{
		return (float) (0.6108*Math.exp((17.27*t)/(t+237.3)));
	}
	
	/**
	 * Pressão atual de valor (KPa);
	 * @param t Temperatura média do ar (ºC);
	 * @param ur Umidade relativa média do ar (%);
	 * @return Pressão atual de valor (KPa);
	 */
	public float ea(float t, float ur) 
	{
		return (float)((es(t)*ur)/100);
	}
	
	/**
	 * Estima a Pressão atual de valor (KPa);
	 * @param tmin Temperatura minima(ºC)
	 * @return Estima a Pressão atual de valor (KPa);
	 */
	public float ea_estimativa1(float tmin) 
	{
		return (float)(0.61*Math.exp((17.27*tmin)/(tmin+237.3)));
	}
	
	/**
	 * Numero do dia do Ano.
	 * @param dia Dia
	 * @param mes Mês 
	 * @param ano Ano
	 * @return Numero do dia do Ano
	 */
	public int j (int dia, int mes, int ano) 
	{
		int dmes[]={31,28,31,30,31,30,31,31,30,31,30,31};
		
		if ( ( (!(ano % 4==0)) && (ano % 100==0) ) || (!(ano % 400==0)) )
	    {
	        dmes[1]=29;
	    }
	    int dias=0;
	    for (int i=0;i<mes-1;i++)
	    {
	        dias=dias+dmes[i];
	    }
	    return dias+dia;
	}
	
	/**
	 * Calcula a Distância inversa relativa entre a Terra e o Sol (rad);
	 * @param dia
	 * @param mes
	 * @param ano
	 * @return Distância inversa relativa entre a Terra e o Sol (rad);
	 */
	public float dr(int dia, int mes, int ano) 
	{
	    return (float) (1+0.033*Math.cos(((2*Math.PI)/(365))*j(dia,mes,ano)));
	}
	
	/**
	 * Calcula a Declinação do Sol (rad);
	 * @param dia
	 * @param mes
	 * @param ano
	 * @return Declinação do Sol (rad);
	 */
	public float gs(int dia, int mes, int ano) 
	{
	    return (float) (0.409*Math.sin(((2*Math.PI)/(365))*j(dia,mes,ano)-1.39));
	}
	
	/**
	 * Representa a Latitude local em radianos
	 * @param latitude Latitude Local;
	 * @param longitude Longitude Local;
	 * @param hemi Hemisterio Norte = 1 e Hemisterio Sul = -1 ; 
	 * @return Latitude local em radianos (rad)
	 */
	public float w(float latitude,float longitude,float hemi)
	{
	    return (float) (hemi*(latitude+(longitude/60))*Math.PI/180);
	}
	
	/**
	 * Calcula Angulo horário ao nascer do sol (rad)
	 * @param latitude Latitude Local;
	 * @param longitude Longitude Local;
	 * @param hemi Hemisterio Norte = 1 e Hemisterio Sul = -1 ; 
	 * @param dia
	 * @param mes
	 * @param ano
	 * @return Angulo horário ao nascer do sol (rad)
	 */
	public float ws(float latitude,float longitude,float hemi,int dia, int mes, int ano)
	{
	    float x= (float) (1-Math.pow(Math.tan(w(latitude,longitude,hemi)),2)*Math.pow(Math.tan(gs(dia,mes,ano)),2));
	    if(x<=0)
	    {
	        x=(float) 0.00001;
	    }
	    return (float) ((Math.PI/2)-Math.atan( (-Math.tan(w(latitude,longitude,hemi))*Math.tan(gs(dia,mes,ano)))/Math.pow(x,0.5) ));
	}
	
	/**
	 * Calcula Radiação solar no topo da Atmosfera (MJm^-2dia^-1);
	 * @param latitude Latitude Local;
	 * @param longitude Longitude Local;
	 * @param hemi Hemisterio Norte = 1 e Hemisterio Sul = -1 ; 
	 * @param dia
	 * @param mes
	 * @param ano
	 * @return Radiação solar no topo da Atmosfera (MJm^-2dia^-1);
	 */
	public float ra(float latitude,float longitude,float hemi,int dia, int mes, int ano) //Radiação solar no topo da Atmosfera (MJm^-2dia^-1);
	{
	    return (float) ((118.08/Math.PI)*dr(dia,mes,ano)*( ws(latitude,longitude,hemi,dia,mes,ano) * Math.sin(w(latitude,longitude,hemi))*Math.sin(gs(dia,mes,ano)) + Math.cos(w(latitude,longitude,hemi))*Math.cos(gs(dia,mes,ano))*Math.sin(ws(latitude,longitude,hemi,dia,mes,ano)) ));
	}
	
	/**
	 * Calcula Radiação solar incidente na ausencia de nuvens (MJm^-2dia^-1);
	 * @param latitude Latitude Local;
	 * @param longitude Longitude Local;
	 * @param hemi Hemisterio Norte = 1 e Hemisterio Sul = -1 ; 
	 * @param dia
	 * @param mes
	 * @param ano
	 * @param z Altitude do Local (m);
	 * @return Radiação solar incidente na ausencia de nuvens (MJm^-2dia^-1);
	 */
	public float rso(float latitude,float longitude,float hemi,int dia, int mes, int ano, float z) 
	{
	    return (float) ((0.75+2*Math.pow(10,-5)*z)*ra(latitude,longitude,hemi,dia,mes,ano));
	}
	
	/**
	 * Calcula Saldo de radiação de ondas longas (MJm^-2dia^-1);
	 * @param latitude Latitude Local;
	 * @param longitude Longitude Local;
	 * @param hemi Hemisterio Norte = 1 e Hemisterio Sul = -1 ; 
	 * @param dia
	 * @param mes
	 * @param ano
	 * @param z Altitude do Local (m);
	 * @param tmax Temperatura maxima do dia (ºC);
	 * @param tmin Temperatura minima do dia (ºC);
	 * @param t Temperatura média do ar (ºC);
	 * @param ur Umidade relativa média do ar (%);
	 * @param krs Coeficiente empiríco igual a 0.16 para regiões continentais e 0.19 regiões costeiras;
	 * @return Saldo de radiação de ondas longas (MJm^-2dia^-1);
	 */
	public float rnl(float latitude,float longitude,float hemi,int dia, int mes, int ano, float z,float tmax, float tmin, float t, float ur,float krs)
	{
	    return (float) (4.903*Math.pow(10,-9)*((Math.pow(tmax+273.16,4)+Math.pow(tmin+273.16,4))/2)*(0.34-0.14*Math.sqrt(ea(t,ur)))*(1.35*(rs(dia,mes,ano,krs,tmax,tmin,latitude,longitude,hemi,z)/rso(latitude,longitude,hemi,dia,mes,ano,z))-0.35));
	}
	
	/**
	 * Estimativa de Radiação solar incidente (MJm^-2dia^-1) utilizando os valores de Tmax e Tmin.
	 * @param dia
	 * @param mes
	 * @param ano
	 * @param krs Coeficiente empiríco igual a 0.16 para regiões continentais e 0.19 regiões costeiras;
	 * @param tmax Temperatura maxima do dia (ºC);
	 * @param tmin Temperatura minima do dia (ºC);
	 * @param latitude Latitude Local;
	 * @param longitude Longitude Local;
	 * @param hemi Hemisterio Norte = 1 e Hemisterio Sul = -1 ; 
	 * @param z Altitude do Local (m);
	 * @return Radiação solar incidente (MJm^-2dia^-1);
	 */
	public float rs(int dia, int mes, int ano, float krs, float tmax, float tmin, float latitude, float longitude, float hemi, float z)//Estimativa de Rs utilizando os valores de Tmax e Tmin
	{
	    return (float) (krs*ra(latitude,longitude,hemi,dia,mes,ano)*Math.sqrt(tmax-tmin));
	}
	
	/**
	 * Estimativa do Saldo de radiação (MJm^-2dia^-1).
	 * @param dia
	 * @param mes
	 * @param ano
	 * @param krs Coeficiente empiríco igual a 0.16 para regiões continentais e 0.19 regiões costeiras;
	 * @param tmax Temperatura maxima do dia (ºC);
	 * @param tmin Temperatura minima do dia (ºC);
	 * @param latitude Latitude Local;
	 * @param longitude Longitude Local;
	 * @param hemi Hemisterio Norte = 1 e Hemisterio Sul = -1 ; 
	 * @param z Altitude do Local (m);
	 * @param t Temperatura média do ar (ºC)
	 * @param ur Umidade relativa média do ar (%);
	 * @return Saldo de radiação (MJm^-2dia^-1);
	 */
	public float rn(int dia, int mes, int ano,float krs, float tmax, float tmin, float latitude, float longitude, float hemi, float z, float t, float ur)//Estimativa RN (Saldo de radiação) (MJm^-2dia^-1);
	{
	    return (float) (0.77*rs(dia,mes,ano,krs,tmax,tmin,latitude,longitude,hemi,z)-rnl(latitude,longitude,hemi,dia,mes,ano,z,tmax,tmin,t,ur,krs));
	}
	
	/**
	 * Estmativa de evapotranspiração pelo metodo de Penman-Monteith (mm);
	 * @param t Temperatura média do ar (ºC)
	 * @param dia Temperatura maxima do dia (ºC);
	 * @param mes
	 * @param ano
	 * @param krs Coeficiente empiríco igual a 0.16 para regiões continentais e 0.19 regiões costeiras;
	 * @param tmax Temperatura maxima do dia (ºC);
	 * @param tmin Temperatura minima do dia (ºC);
	 * @param latitude Latitude Local;
	 * @param longitude Longitude Local;
	 * @param hemi Hemisterio Norte = 1 e Hemisterio Sul = -1 ; 
	 * @param z Altitude do Local (m);
	 * @param ur Umidade relativa média do ar (%);
	 * @param g Fluxo total diario de calor de calor no solo (MJm^-2dia^-1) -> Os baixos valores de G normalmente registrados em escalas diarias, pode-se considera-lo sendo igual a ZERO, quanto não estão disponiveis(ALLLEN et al.,1998)
	 * @param patm Pressao atmosférica local (kPa);
	 * @param u2 Média diaria da Velocidade do Vento a 2m de altura (ms^-1)
	 * @return Evapotranspiração pelo metodo de Penman-Monteith (mm);
	 */
	public float calcularEvapotranspiracao(float t, int dia, int mes, int ano,float krs, float tmax, float tmin, float latitude, float longitude, float hemi, float z, float ur, float g, float patm, float u2) //Estmativa de evapotranspiração pelo metodo de Penman-Monteith (mm);
	{

		return (float) ((0.408*delta(t)*(rn(dia,mes,ano,krs,tmax,tmin,latitude,longitude,hemi,z,t,ur)-g)+((y(patm)*900*u2*(es(t)-ea(t,ur)))/(t+273)))/(delta(t)+y(patm)*(1+0.34*u2)));
	}

}
