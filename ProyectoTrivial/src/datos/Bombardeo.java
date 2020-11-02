package datos;

import java.io.Serializable;
import java.util.ArrayList;
/** 
 * Durante 30 segundos se van enviando preguntas sin parar (Tendra que responder un minimo de 5 preguntas y acertar mas de un 75%)
 */
public class Bombardeo extends Juego implements Serializable{

	public Bombardeo(int tiempo, ArrayList<Pregunta> preguntas) {
		super(tiempo);
	}

}
