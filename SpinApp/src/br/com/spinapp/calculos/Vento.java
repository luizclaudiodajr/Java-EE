/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spinapp.calculos;


public class Vento {
    

    public String categoriaDoVento(float u2)
    {
        String r="";
        if(u2<2)
        {
            r="Calmo";
        }else if(u2<5)
        {
            r="Quase Calmo";
        }else if(u2<10)
        {
            r="Brisa Amena";
        }else if(u2<20)
        {
            r="Vento Leve";
        }else if(u2<30)
        {
            r="Vento Moderado";
        }else if(u2<40)
        {
            r="Vento Forte";
        }else if(u2<50)
        {
            r="Vento Muito Forte";
        }else if(u2<60)
        {
            r="Vento Fortíssimo";
        }else if(u2<75)
        {
            r="Ventania";
        }else if(u2<100)
        {
            r="Vendaval";
        }else
        {
            r="Tornado";
        }
            
        
        return r;
        
    }
}
