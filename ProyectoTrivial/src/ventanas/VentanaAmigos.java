package ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Main;

/** 
 * Ventana para ver los amigos que tienes agregados y agregar nuevos amigos.
 */
public class VentanaAmigos extends JFrame {
	
	JButton bAtras;
	JButton bAgregar;
	
	public VentanaAmigos() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Amigos" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		JPanel panelInferior = new JPanel(new FlowLayout());
		
		bAgregar = new JButton ("Agregar amigo");
		panelInferior.add(bAgregar);
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
