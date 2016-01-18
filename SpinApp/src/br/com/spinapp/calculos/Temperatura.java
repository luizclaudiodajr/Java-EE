package br.com.spinapp.calculos;

import java.util.ArrayList;
import java.util.Date;

import br.com.spinapp.domain.Historico;

public class Temperatura {

	/*
	 * Variaveis: T=Temperatura do Ar (ºC) UR= Umidade do Ar (%)
	 */

	/**
	 * Temperatura de Ponto de Orvalho (ºC)
	 * 
	 * @param t
	 *            Temperatura do Ar (ºC)
	 * @param ur
	 *            Umidade Relativa do Ar (%)
	 * @return Temperatura de Ponto de Orvalho (ºC)
	 */
	public float to(float t, float ur) {
		EvapotranspiracaoPenmanMonteith ep = new EvapotranspiracaoPenmanMonteith();
		return (float) ((237.3 * Math.log10(ep.ea(t, ur) / 0.611)) / (7.5 - Math
				.log10(ep.ea(t, ur) / 0.611)));
	}

	/**
	 * Calcula Quantidade de Frio Requerida para o termino do Repouso e início
	 * do densenvolvimento reprodutivo (NHF)
	 * 
	 * @param lista
	 *            Lita de Historio de Um dia.
	 * @return Retorna NHF em Horas.
	 */
	public float nhf(ArrayList<Historico> lista) {
		int horas = 0;
		for (int i = 0; i < lista.size() - 1; i++) {
			if (lista.get(i + 1).getValor() < 7) {
				horas = horas
						+ (lista.get(i + 1).getHora().getHours() * 60 + lista
								.get(i + 1).getHora().getMinutes())
						- (lista.get(i).getHora().getHours() * 60 + lista
								.get(i).getHora().getMinutes());
			}
		}
		return (horas / 60);
	}

	/**
	 * Indice Biometerológico de Conforto de Higro-Termico para Animais
	 * Homeotermos
	 * 
	 * @param t
	 *            Temperatura do Ar (ºC)
	 * @param ur
	 *            Umidade Relativa do Ar (%)
	 * @return Uma String informando a condição dos Animais Homeotermos
	 */
	public String thi(float t, float ur) {
		float calc = (float) (t + 0.36 * to(t, ur) + 41.2); // Calculo
		String resp; // Resposta
		if (calc <= 70) {
			resp = "Condição de Conforto.";
		} else if (calc < 72) {
			resp = "Início da Condição de Desconforto";
		} else {
			resp = "Condição de estresse Severo!";
		}
		return resp;
	}

	/**
	 * Soma Termica Dia-a-dia (Método 1)
	 * @param lista Recebe lista de temperatuda do sensor do dia.
	 * @param tb Temperartura base da Especie
	 * @return Soma Termica Dia-a-dia
	 */
	public float std(ArrayList<Historico> lista, float tb) {
		Utilitario u = new Utilitario();
		float tmax = u.valorMaximo(lista);
		float tmin = u.valorMinino(lista);
		if(tmin<tb)
		{
			tmin=tb;
		}
		return ((tmax+tmin)/2)-tb;		
	}
	
	public float stac(ArrayList<Historico> lista, float tb)
	{
		ArrayList<Historico> aux = new ArrayList<Historico>();
		int datainicio=lista.get(0).getData().getDate();
		float soma=0;
		for(int i = 0; i < lista.size(); i++)
		{
			if(lista.get(i).getData().getDate()==datainicio)
			{
				aux.add(lista.get(i));
			}else
			{
				soma=soma+std(aux, tb);
				aux.clear();
				datainicio=lista.get(i).getData().getDate();
				aux.add(lista.get(i));
			}
		}
		return soma;
	}
}