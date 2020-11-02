package datos;

import java.io.Serializable;

/** 
 * Juego "estandar", se realiza una pregunta y el usuario responde
 */
public class Estandar extends Juego implements Serializable{

	public Estandar(int tiempo, Pregunta pregunta) {
		super(tiempo);
		
	}

}
