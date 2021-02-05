package ventanas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class VentanaPregunta {
	
	String correcta = "null";
	String n ;
	int c = 0;
	ArrayList<ArrayList<Integer>> preguntasJugadores = new ArrayList<ArrayList<Integer>>();
	
	ArrayList<Integer> preguntasJ1 = new ArrayList<Integer>(), 
					preguntasJ2 = new ArrayList<Integer>(),
					preguntasJ3 = new ArrayList<Integer>(),
					preguntasJ4 = new ArrayList<Integer>();
	
	public VentanaPregunta(VentanaTablero vt) {
		
		poblarPreguntasJugadores();
		
		Random r = new Random();
		int id = r.nextInt(20);
		String pregunta = "";
		try {
			pregunta = main.Main.getSistema().getbd().preguntaAleatoria(id);
			String[] listaRespuestas = main.Main.getSistema().getbd().respuestasPregunta(id);
			n = (String)JOptionPane.showInputDialog(null, pregunta, 
		              "Trivial", JOptionPane.QUESTION_MESSAGE, null, listaRespuestas,listaRespuestas);
//			String[] respuestasCorrectas = {"Andres Iniesta", "Hepatitis", "Isaac Asimov", "Australia", "El día de la reina", "Mad Men", "Sunismo", "Corinthians", "1935", "1941", "cuatro", "Adrián Escudero", "Ingerida", "Hígado", "roja", "carbón", "Erótico", "Liechtenstein", "Bebés", "Colombia"};
//			for(String s : respuestasCorrectas){
//				if(n.equals(s)){
//					correcta = "true";
//					
//					for(ArrayList<Integer> ar : preguntasJugadores) {
//						for(Integer i : ar) {
//							if(c == i) {
//								
//							}
//						}
//					}
//					
//			//	vt.setPlayerPosition(200, 200, 1);
//				}else{
//					correcta = "false";
//				}
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void poblarPreguntasJugadores() {
		preguntasJ1.add(1);
		preguntasJ1.add(5);
		preguntasJ1.add(9);
		preguntasJ1.add(13);
		preguntasJ1.add(17);
		preguntasJugadores.add(preguntasJ1);
		
		preguntasJ2.add(2);
		preguntasJ2.add(6);
		preguntasJ2.add(10);
		preguntasJ2.add(14);
		preguntasJ2.add(18);
		preguntasJugadores.add(preguntasJ2);
		
		preguntasJ3.add(3);
		preguntasJ3.add(7);
		preguntasJ3.add(11);
		preguntasJ3.add(15);
		preguntasJ3.add(19);
		preguntasJugadores.add(preguntasJ3);
		
		preguntasJ4.add(4);
		preguntasJ4.add(8);
		preguntasJ4.add(12);
		preguntasJ4.add(16);
		preguntasJ4.add(20);
		preguntasJugadores.add(preguntasJ4);
	}
	
	public String getCorrecta(){
		return correcta;
	}
	
	public String getN(){
		return n;
	}
}
