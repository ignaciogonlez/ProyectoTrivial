package datos;

import java.io.Serializable;

/** 
 * Clase padre de la jerarquia de juegos
 */
public class Juego implements Serializable{

	private int tiempo;
	
	public Juego(int tiempo) {
		this.tiempo = tiempo;
	}
}

