package ventanas;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import datos.Jugador;
import main.Main;

/*
 * Ventana en la que se juega la partida y los jugadores avanzan
 */
public class VentanaTablero extends JFrame{
	
	Jugador j1;
	Jugador j2;
	Jugador j3;
	Jugador j4;
	FondoPanel fondo = new FondoPanel();
	
	public VentanaTablero() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Tablero" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		
		//Mapa
		fondo.setImagen("/foto_fondo.jpg");
		this.setContentPane(fondo);
		
		
	
	}
	
	public void moverJugador() {
		j1.setx(400);
		j1.sety(300);
	}
	
	public void paint(Graphics g) {
	     super.paint(g);
	     
	     j1.paint(g);
	     j2.paint(g);
	     j3.paint(g);
	     j4.paint(g);  
	     
	     g.dispose();
	}
	
	public Jugador getJ1(){
		return j1;
	}
	public Jugador getJ2(){
		return j2;
	}
	public Jugador getJ3(){
		return j3;
	}
	public Jugador getJ4(){
		return j4;
	}
	
	public void jugar(Thread t)  {
		
		String[] rc = {"Andres Iniesta", "Hepatitis", "Isaac Asimov", "Australia", "El día de la reina", 
				"Mad Men", "Sunismo", "Corinthians", "1935", "1941", "cuatro", "Adrián Escudero", "Ingerida", 
				"Hígado", "roja", "carbón", "Erótico", "Liechtenstein", "Bebés", "Colombia","Cero","Páncreas",
				"Lagomorfo","Una bacteria","Rodillas","Cuatro","Rugby","Argentina","Estados Unidos","15",
				"El conquistador","Isabel I y Fernando II","Romano","Alemania","1812","Impuesto","Sacramento",
				"Argel","Ghana","Chile"};
		
		ArrayList<String> respuestasCorrectas = new ArrayList<String>();
		
		for(String s : rc) respuestasCorrectas.add(s);
		
		
		j1 = new Jugador(700, 480, Color.RED, 1);
		j2 = new Jugador(700, 450, Color.DARK_GRAY, 2);
		j3 = new Jugador(700, 420, Color.BLUE, 3);
		j4 = new Jugador(700, 390, Color.YELLOW, 4);	
		
		while(!(j1.getN() > 9) && !(j2.getN() > 9) && !(j3.getN() > 9) && !(j4.getN() > 9)) {
			
			VentanaPregunta vp1 = new VentanaPregunta(this);
			VentanaPregunta vp2 = new VentanaPregunta(this);
			VentanaPregunta vp3 = new VentanaPregunta(this);
			VentanaPregunta vp4 = new VentanaPregunta(this);
			
			if(respuestasCorrectas.contains(vp1.getN())) j1.incrementarPosicion();
			if(respuestasCorrectas.contains(vp2.getN())) j2.incrementarPosicion();
			if(respuestasCorrectas.contains(vp3.getN())) j3.incrementarPosicion();
			if(respuestasCorrectas.contains(vp4.getN())) j4.incrementarPosicion();
			
			repaint();
			
			try {
				t.sleep(2500);
			} catch (InterruptedException e) {
				System.out.println("no funsionó");				
			}
		}
	}
	
}