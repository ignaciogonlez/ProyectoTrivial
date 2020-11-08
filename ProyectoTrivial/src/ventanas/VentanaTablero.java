package ventanas;

import java.awt.*;
import javax.swing.*;

/*
 * Ventana en la que se juega la partida y los jugadores avanzan
 */
public class VentanaTablero extends JFrame{

	FondoPanel fondo = new FondoPanel();
	
	public VentanaTablero() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Tablero" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		
		//Mapa
		fondo.setImagen("/fotos/foto_fondo.jpg");
		this.setContentPane(fondo);
	}
}
