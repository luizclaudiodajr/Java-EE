package br.com.spinapp.calculos;

import java.util.ArrayList;

import br.com.spinapp.domain.Historico;

public class Utilitario {
	
	/**
	 * Classe de Utial para Retonar o Valores Maximo, Minimos e Media de uma Lista de Historicos
	 * @author  Wellington Cássio Faria
	 * @
	 */
	
	
	/**
	 * Função Retorna o medido pelo senhor do historio definido 
	 * @param lista Lista de Historicos
	 * @return Valor máximo da Lista
	 */
	public float valorMaximo(ArrayList<Historico> lista)
	{
		
		float maximo;
		maximo=lista.get(0).getValor();
		for(int i = 0; i < lista.size(); i++)
        {
             if(lista.get(i).getValor()>maximo)
             {
            	 maximo= lista.get(i).getValor();
             }
        }	
		return maximo;
	}
	
	/**
	 * Calcula Valor Minimo dada uma Lista Recebi
	 * @param lista Lista de historioco
	 * @return
	 */
	public float valorMinino(ArrayList<Historico> lista)
	{
		float minino;
		minino=lista.get(0).getValor();
		for(int i = 0; i < lista.size(); i++)
        {
             if(lista.get(i).getValor()<minino)
             {
            	 minino= lista.get(i).getValor();
             }
        }	
		return minino;
	}
	
	/**
	 * Retorna a media dado uma lista de Historico
	 * @param lista Recebe uma Lista de Historico
	 * @return Media de uma Lista
	 */
	public float mediaValor(ArrayList<Historico> lista)
	{
		float media=0;
		for(int i = 0; i < lista.size(); i++)
        {
           media=media+lista.get(i).getValor();
        }	
		return media/lista.size();
	}
}
