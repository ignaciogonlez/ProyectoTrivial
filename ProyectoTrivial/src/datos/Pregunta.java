package datos;

import java.awt.Font;
import java.io.Serializable;
import java.util.ArrayList;

/** 
 * Objeto "pregunta" que se iran realizando durante el juego
 */
public class Pregunta implements Serializable {
	
	private String pregunta;

	
	public Pregunta(String pregunta, ArrayList<Respuesta> respuesta) {
		this.pregunta = pregunta ;
	}
	private int tiempo;

	public Pregunta(String pregunta) {
		this.pregunta = pregunta;

	}
	public String toString() {
		return pregunta;
	}
}
