package ventanas;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import main.Main;

public class VentanaGanador extends JFrame{

	JButton bAceptar;
	FondoPanel fondo;
	JLabel lMensaje;
	
	public VentanaGanador(VentanaTablero vt, String jugador){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "GANADOR" );
		setSize( 200, 200 );
		setLocationRelativeTo( null );
		
		JPanel panelInferior = new JPanel(new FlowLayout());
		bAceptar = new JButton("Aceptar");
		panelInferior.add(bAceptar);
		getContentPane().add(panelInferior,"South");
		
		fondo = new FondoPanel();
		fondo.setImagen("/fotos/medalla.jpg");
		getContentPane().add(fondo, "Center");
		
		JPanel panelSuperior = new JPanel(new FlowLayout());
		lMensaje = new JLabel(jugador + " es el ganador");
		lMensaje.setFont(new Font("Serif", Font.PLAIN, 14));
		panelSuperior.add(lMensaje);
		getContentPane().add(panelSuperior,"North");
		

		bAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				vt.dispose();
			}	
		});
	}
}