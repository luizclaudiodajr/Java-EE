package br.com.spinapp.domain;

public class Planta_has_doenca {
	
	// Atributos
	private Planta planta_idplanta;
	private Doenca doenca_iddoenca;
	
	// Getters e Setters
	public Planta getPlanta_idplanta() {
		return planta_idplanta;
	}
	public void setPlanta_idplanta(Planta planta_idplanta) {
		this.planta_idplanta = planta_idplanta;
	}
	public Doenca getDoenca_iddoenca() {
		return doenca_iddoenca;
	}
	public void setDoenca_iddoenca(Doenca doenca_iddoenca) {
		this.doenca_iddoenca = doenca_iddoenca;
	}
	
	
	// ToString
		@Override
		public String toString() {
			String saida = planta_idplanta+ ", " +doenca_iddoenca+ ".";
			return saida;
	
		}

}
