package datos;

import java.awt.Font;
import java.io.Serializable;

/** 
 * Objeto "pregunta" que se iran realizando durante el juego
 */
public class Pregunta implements Serializable {
	
	private String pregunta;
	
	public Pregunta(String pregunta) {
		this.pregunta = pregunta ;
	}
}
