package br.com.spinapp.domain;

public class Planta_has_praga {
	
		// Atributos
		private Planta planta_idplanta;
		private Praga praga_idpraga;
		
		// Getters e Setters
		public Planta getPlanta_idplanta() {
			return planta_idplanta;
		}
		public void setPlanta_idplanta(Planta planta_idplanta) {
			this.planta_idplanta = planta_idplanta;
		}
		
		public Praga getPraga_idpraga() {
			return praga_idpraga;
		}
		public void setPraga_idpraga(Praga praga_idpraga) {
			this.praga_idpraga = praga_idpraga;
		}
			// ToString
			@Override
			public String toString() {
				String saida = planta_idplanta+ ", " +praga_idpraga+ ".";
				return saida;
		
			}
}