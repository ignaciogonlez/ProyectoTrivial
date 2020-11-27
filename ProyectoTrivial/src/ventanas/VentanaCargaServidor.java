package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.Main;

public class VentanaCargaServidor extends JFrame {
	
	public VentanaCargaServidor() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Preparese" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
			
		JPanel panelCentral = new JPanel(new BorderLayout());
		panelCentral.setBackground(Color.pink);
			
			
			
		//PanelCentral
		JLabel lMensaje = new JLabel("            ESPERANDO A LOS DEMÁS JUGADORES");
		lMensaje.setForeground(Color.black);
		lMensaje.setFont(new Font("Serif", Font.PLAIN, 30));
		panelCentral.add(lMensaje);
		getContentPane().add(panelCentral,"Center");
	}

}
