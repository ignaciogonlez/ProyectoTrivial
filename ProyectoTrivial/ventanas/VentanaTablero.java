package ventanas;

import java.awt.*;
import java.sql.SQLException;
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
	String u1;
	String u2;
	String u3;
	String u4;
	FondoPanel fondo = new FondoPanel();
	
	public VentanaTablero() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Tablero" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		u4="";
		
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
	public void setU1(String usuario){
		u1 = usuario;
	}
	public void setU2(String usuario){
		u2 = usuario;
	}
	public void setU3(String usuario){
		u3 = usuario;
	}
	public void setU4(String usuario){
		u4 = usuario;
	}
	public String getU4(){
		return u4;
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
				e.printStackTrace();
			}
		}
		
		if(j1.getN() > 9){
			VentanaGanador vg = new VentanaGanador(this, u1);
			try {
				Main.getSistema().getbd().updatePuntuacion(u1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			vg.setVisible(true);
		}
		if(j2.getN() > 9){
			VentanaGanador vg = new VentanaGanador(this, u2);
			try {
				Main.getSistema().getbd().updatePuntuacion(u2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			vg.setVisible(true);
		}
		if(j3.getN() > 9){
			VentanaGanador vg = new VentanaGanador(this, u3);
			try {
				Main.getSistema().getbd().updatePuntuacion(u3);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			vg.setVisible(true);
		}
		if(j4.getN() > 9){
			VentanaGanador vg = new VentanaGanador(this, u4);
			try {
				Main.getSistema().getbd().updatePuntuacion(u4);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			vg.setVisible(true);
		}
	}
	
}