package br.com.spinapp.calculos;

import java.util.ArrayList;

import br.com.spinapp.domain.Historico;

public class EstimativadePragas {
	
	/**
	 * Calcula dias do ciclo de pragas. (Quantos dias levam para sair do ovo até estagio Adulto)
	 * @param ct Stac do Inseto
	 * @param tb Temperatura sabe do Inseto
	 * @param lista
	 * @return numero de dias para inseto sair do ovo e  se tormar adulto.
	 */
	public float cliclo (float ct, float tb, ArrayList<Historico> lista)
	{
		Utilitario u= new Utilitario();
		float tempmed=u.mediaValor(lista);
		return ct/(tempmed-tb);
	}
	
	/**
	 * Retorna uma lista do tipo historico com valor contendo a geração de pragas do dia.
	 * @param lista Lista de as temperatura de um sensor
	 * @param ct
	 * @param tb
	 * @return Lista do tipo historico com valor contendo a geração de pragas do dia.
	 */
	public ArrayList<Historico> geracao(ArrayList<Historico> lista, float ct, float tb)
	{
		ArrayList<Historico> aux = new ArrayList<Historico>();
		ArrayList<Historico> aux2=new ArrayList<Historico>();
		int datainicio=lista.get(0).getData().getDate();
		Historico dado= new Historico();
		
		for(int i = 0; i < lista.size(); i++)
		{
			if(lista.get(i).getData().getDate()==datainicio)
			{
				aux.add(lista.get(i));
				dado.setData(lista.get(i).getData());
			}else
			{
				datainicio=lista.get(i).getData().getDate();
				float geracao=1/cliclo(ct, tb, aux);
				dado.setValor(geracao);
				aux2.add(dado);
				aux.clear();
				aux.add(lista.get(i));
			}
		}	
		return aux2;
	}
	
}
