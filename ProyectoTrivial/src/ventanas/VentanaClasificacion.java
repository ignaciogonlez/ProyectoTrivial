package ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Main;

/** 
 * Ventana para poder ver tu localización en puntos respecto a tus amigos agregados (puntos por ganar una partida)
 */
public class VentanaClasificacion extends JFrame{
	
	JButton bAtras;
	
	public VentanaClasificacion() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Clasificacion" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		JPanel panelInferior = new JPanel(new FlowLayout());
		
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior,"South");
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
			}
		});
	}
}
