package ventanas;

import java.awt.Color;
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
	
	JButton bJugar;  //boton para unirse a una partida
	JButton bcrearPartida;   //boton para crear partida
	
	public VentanaMenu() {
	
	setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
	setTitle( "MENU" );
	setSize( 800, 600 );
	setLocationRelativeTo( null );
	JPanel panelInferior = new JPanel(new FlowLayout());
	panelInferior.setBackground(Color.orange);
	
	bClasificacion = new JButton("Clasificacion");
	panelInferior.add(bClasificacion);
	bAmigos = new JButton("Amigos");
	panelInferior.add(bAmigos);
	bSalir = new JButton("Salir"); 
	panelInferior.add(bSalir);
	getContentPane().add(panelInferior,"South");
	
	FondoPanel fondo = new FondoPanel();
	JPanel panelCentral = new JPanel(new FlowLayout());
	fondo.setImagen("/fotos/trivial2.jpg");
	getContentPane().add(fondo, "Center");
	
	bcrearPartida = new JButton("Crear Partida");
	panelCentral.add(bcrearPartida);
	bcrearPartida.setBackground(Color.orange);
	
	bJugar = new JButton("Jugar");
	panelCentral.add(bJugar);
	bJugar.setBackground(Color.green);
	getContentPane().add(panelCentral,"North");

	
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
	bJugar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Main.getGestorVentanas().getVentanaCarga().setVisible(true);
			dispose();
		}
	});
	bcrearPartida.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Main.getGestorVentanas().getVentanaCargaServidor().setVisible(true);
			dispose();	
		}
	});
	}
}
