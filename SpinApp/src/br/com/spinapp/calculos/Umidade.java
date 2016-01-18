package br.com.spinapp.calculos;

import java.util.ArrayList;

import br.com.spinapp.domain.Historico;

public class Umidade 
{
	/**
	 * 
	 * @param lista Lista contendo valores de Umidade
	 * @return Retorna o tempo que a umidade esta acima de 90%, que é propicio a fungos.
	 */
	public float dpm(ArrayList<Historico> lista)
	{
		int horas = 0;
		for (int i = 0; i < lista.size() - 1; i++) {
			if (lista.get(i + 1).getValor() > 90) {
				horas = horas
						+ (lista.get(i + 1).getHora().getHours() * 60 + lista
								.get(i + 1).getHora().getMinutes())
						- (lista.get(i).getHora().getHours() * 60 + lista
								.get(i).getHora().getMinutes());
			}
		}
		return (horas / 60);
	}
}
