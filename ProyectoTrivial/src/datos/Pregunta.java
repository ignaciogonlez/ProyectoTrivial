package datos;

import java.awt.Font;
import java.io.Serializable;
import java.util.ArrayList;

/** 
 * Objeto "pregunta" que se iran realizando durante el juego
 */
public class Pregunta implements Serializable {
	
	private String pregunta;
	private int tiempo;
	ArrayList<String>  = new ArrayList<String>();
	public Pregunta(String pregunta) {
		this.pregunta = pregunta;
	}
}
