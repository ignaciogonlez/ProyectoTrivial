package datos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ventanas.VentanaTablero;

/**public class Tablero extends JFrame{
	
	Jugador j1;
	Jugador j2;
	Jugador j3;
	Jugador j4;
	VentanaTablero ventana;
	Graphics g;
	
	public Tablero() {
		ventana= new VentanaTablero();
		setSize(626, 508);
		setTitle("Tablero de juego");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		j1 = new Jugador(500, 100, Color.RED);
		j2 = new Jugador(600, 100, Color.DARK_GRAY);
		j3 = new Jugador(400, 300, Color.BLUE);
		j4 = new Jugador(700, 400, Color.YELLOW);
		
	}
	
	public void paint(Graphics g) {
	     super.paint(g);
	     
	     this.g = g;
	     
	     j1.paint(g);
	     j2.paint(g);
	     j3.paint(g);
	     j4.paint(g);
	     
	     g.dispose();
	     
	}
	
}
**/