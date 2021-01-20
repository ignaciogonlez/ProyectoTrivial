package ventanas;

import java.awt.*;
import javax.swing.*;

import datos.Jugador;

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
		
		j1 = new Jugador(200, 180, Color.RED);
		j2 = new Jugador(100, 130, Color.DARK_GRAY);
		j3 = new Jugador(100, 100, Color.BLUE);
		j4 = new Jugador(100, 80, Color.YELLOW);	
	
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
	
}
