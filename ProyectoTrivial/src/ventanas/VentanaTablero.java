package ventanas;

import java.awt.*;
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
		fondo.setImagen("/fotos/foto_fondo.jpg");
		this.setContentPane(fondo);
		
		j1 = new Jugador(700, 480, Color.RED);
		j2 = new Jugador(700, 450, Color.DARK_GRAY);
		j3 = new Jugador(700, 420, Color.BLUE);
		j4 = new Jugador(700, 390, Color.YELLOW);	
	
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
	
	public static void main(String[] args) {
		VentanaTablero vent = new VentanaTablero();
		vent.setVisible(true);
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
	
	public void setPlayerPosition(int x, int y, int j) {
		
		if(j == 1) {
			j1.setx(x);
			j1.sety(y);
		}else if(j == 2) {
			j2.setx(x);
			j2.sety(y);
		}else if(j == 3) {
			j3.setx(x);
			j3.sety(y);
		}else{
			j4.setx(x);
			j4.sety(y);
		}
		
		repaint();
		
	}
	
	public void jugar(){
		int numA1 = 0;
		int numA2 = 0;
		int numA3 = 0;
		int numA4 = 0;
		
	while(numA1!=10 || numA2!=10 || numA3!=10|| numA4!= 10) {
		try {Thread.sleep(5000); } catch (InterruptedException e) {}
		VentanaPregunta v1 = new VentanaPregunta(this);
		VentanaPregunta v2 = new VentanaPregunta(this);
		VentanaPregunta v3 = new VentanaPregunta(this);
		VentanaPregunta v4 = new VentanaPregunta(this);
		String[] respuestasCorrectas = {"Andres Iniesta", "Hepatitis", "Isaac Asimov", "Australia", "El día de la reina", "Mad Men", "Sunismo", "Corinthians", "1935", "1941", "cuatro", "Adrián Escudero", "Ingerida", "Hígado", "roja", "carbón", "Erótico", "Liechtenstein", "Bebés", "Colombia"};
		System.out.println(v1.getN());
		System.out.println(v2.getN());
		System.out.println(v3.getN());
		System.out.println(v4.getN());
		
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA1 == 1){
				numA1++;
				
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(400, 480, 1);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA1 == 2){
				numA1++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(100, 480, 1);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA1 == 3){
				numA1++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(150, 310, 1);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA1 == 4){
				numA1++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(280, 310, 1);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA1 == 5){
				numA1++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(480, 310, 1);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA1 == 6){
				numA1++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(680, 310, 1);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA1 == 7){
				numA1++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(680, 310, 1);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA1 == 8){
				numA1++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(480, 310, 1);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA1 == 9){
				numA1++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(280, 310, 1);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA1 == 10){
				numA1++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(150, 310, 1);
				break;
			}
		}
		
		
		
		
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA2 == 1){
				numA2++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(400, 450, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA2 == 2){
				numA2++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(100, 450, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA2 == 3){
				numA2++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(150, 280, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA2 == 4){
				numA2++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(280, 280, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA2 == 5){
				numA2++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(480, 280, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA2 == 6){
				numA2++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(680, 280, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA2 == 7){
				numA2++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(680, 130, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA2 == 8){
				numA2++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(480, 130, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA2 == 9){
				numA2++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(280, 130, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA2 == 10){
				numA2++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(150, 130, 2);
				break;
			}
		}
		
		
		
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA3 == 1){
				numA3++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(400, 420, 3);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA3 == 2){
				numA3++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(100, 420, 3);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA3 == 3){
				numA3++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(150, 250, 3);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA3 == 4){
				numA3++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(280, 250, 3);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA3 == 5){
				numA3++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(480, 250, 3);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA3 == 6){
				numA3++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(680, 250, 3);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA3 == 7){
				numA3++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(680, 100, 3);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA3 == 8){
				numA3++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(480, 100, 3);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA3 == 9){
				numA3++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(280, 100, 3);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA3 == 10){
				numA3++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(150, 100, 3);
				break;
			}
		}
		
		
		
		
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA4 == 1){
				numA4++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(400, 390, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA4 == 2){
				numA4++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(100, 390, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA4 == 3){
				numA4++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(150, 220, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA4 == 4){
				numA4++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(280, 220, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA4 == 5){
				numA4++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(480, 280, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA4 == 6){
				numA4++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(680, 220, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA4 == 7){
				numA4++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(680, 80, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA4 == 8){
				numA4++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(480, 80, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA4 == 9){
				numA4++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(280, 80, 2);
				break;
			}
		}
		for(String s : respuestasCorrectas){
			if(v2.getN().equals(s) && numA4 == 10){
				numA4++;
				Main.getGestorVentanas().getVentanaTablero().setPlayerPosition(150, 80, 2);
				break;
			}
		}
	}
		
		
		System.out.println(numA1);
		System.out.println(numA2);
		System.out.println(numA3);
		System.out.println(numA4);
		System.out.println(Main.getGestorVentanas().getVentanaTablero().getJ1().getx());
		System.out.println(Main.getGestorVentanas().getVentanaTablero().getJ2().getx());
		System.out.println(Main.getGestorVentanas().getVentanaTablero().getJ3().getx());
		System.out.println(Main.getGestorVentanas().getVentanaTablero().getJ4().getx());
	}
	
}