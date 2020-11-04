package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import main.Main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;
import main.GestorVentanas;

/** 
 * Ventana de espera del juego
 */

public class VentanaCarga extends JFrame {

	
	public VentanaCarga() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Preparese" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		
		JPanel panelCentral = new JPanel(new BorderLayout());
		panelCentral.setBackground(Color.pink);
		
		
		
		//PanelCentral
				JLabel lMensaje = new JLabel("            ESPERE A QUE DE COMIENZO LA PARTIDA");
				lMensaje.setForeground(Color.black);
				lMensaje.setFont(new Font("Serif", Font.PLAIN, 30));
				panelCentral.add(lMensaje);
				getContentPane().add(panelCentral,"Center");
	}
}
