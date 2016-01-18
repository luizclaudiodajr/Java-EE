package br.com.spinapp.calculos;

import java.util.ArrayList;

import br.com.spinapp.domain.Historico;

public class PlanejamentoDeColheita {
	
	public float Colheita(float tb, float ct, ArrayList<Historico> lista)
	{
		Temperatura t=new Temperatura();
		float gd=t.stac(lista, tb);
		Historico diaUltimaPosicao=lista.get(lista.size()-1);
		ArrayList<Historico> aux= new ArrayList<Historico>(0);
		
		for(int i = lista.size()-1; i > 0; i--)
		{
			if(lista.get(i).getData().getDay()==diaUltimaPosicao.getData().getDay())
			{
				aux.add(lista.get(i));
			}else
			{
				break;
			}
		}
		float stdUltimodia=t.std(aux, tb);
		return 	(ct-gd)/stdUltimodia;
		
	}
}
