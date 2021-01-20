package ventanas;

import java.awt.*;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.*;
import javax.swing.JOptionPane;

import datos.Jugador;

public class VentanaPregunta {
	
	
	public VentanaPregunta() {
		
		Random r = new Random();
		int id = r.nextInt(20);
		String pregunta = "";
		try {
			pregunta = main.Main.getSistema().getbd().preguntaAleatoria(id);
			String[] listaRespuestas = main.Main.getSistema().getbd().respuestasPregunta(id);
			String n = (String)JOptionPane.showInputDialog(null, pregunta, 
		              "Trivial", JOptionPane.QUESTION_MESSAGE, null, listaRespuestas,listaRespuestas);
			System.out.println(n);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
