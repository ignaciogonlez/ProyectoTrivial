package datos;

import java.io.Serializable;

/** 
 *SOLO SI DA TIEMPO - Modo de juego en el que se disparan 5 preguntas a dos jugadores (el que mas acierte gana)
 */
public class Duelo extends Juego implements Serializable{
	
	private Pregunta[] listaPreguntas;
	private final int NUM_PREGUNTAS = 5;
	
	public Duelo(int tiempo) {
		super(tiempo);
		listaPreguntas = new Pregunta[NUM_PREGUNTAS];
	}
	
	public void setListaPreguntas(Pregunta[] listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}
	public Pregunta[] getListaPreguntas() {
		return listaPreguntas;
	}
}
