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
	}
	
		
	
}