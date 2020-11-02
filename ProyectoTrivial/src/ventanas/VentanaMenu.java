package ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Main;
/** 
 * Ventana de menu tras hacer el login
 */
public class VentanaMenu extends JFrame{
	
	JButton bClasificacion;
	JButton bAmigos;
	JButton bSalir;
	
	JButton bJugar;  //boton para iniciar una partida
	
	public VentanaMenu() {
	
	setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
	setTitle( "MENU" );
	setSize( 800, 600 );
	setLocationRelativeTo( null );
	JPanel panelInferior = new JPanel(new FlowLayout());
	
	bClasificacion = new JButton("Clasificacion");
	panelInferior.add(bClasificacion);
	bAmigos = new JButton("Amigos");
	panelInferior.add(bAmigos);
	bSalir = new JButton("Salir"); 
	panelInferior.add(bSalir);
	getContentPane().add(panelInferior,"South");
	
	bJugar = new JButton("JUGAR");
	getContentPane().add(bJugar, "Center");
	
	bClasificacion.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Main.getGestorVentanas().getVentanaClasificacion().setVisible(true);
			dispose();
		}
	});
	bAmigos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Main.getGestorVentanas().getVentanaAmigos().setVisible(true);
			dispose();
		}
	});
	bSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
			dispose();
		}
	});
	}

}
