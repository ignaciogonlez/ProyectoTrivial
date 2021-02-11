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
	
	JButton bJugar;  //boton para empezar la partida
	
	private Thread t;
	
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
	fondo.setImagen("/trivial2.jpg");
	getContentPane().add(fondo, "Center");
	
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
			//Main.getGestorVentanas().getVentanaAmigos().setVisible(true);
			VentanaAmigos v = new VentanaAmigos();
			v.setVisible(true);
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
			dispose();
			Main.getGestorVentanas().getVentanaInicioEnPartida4().setVisible(true);
			Main.getGestorVentanas().getVentanaInicioEnPartida3().setVisible(true);
			Main.getGestorVentanas().getVentanaInicioEnPartida2().setVisible(true);
			(t = new Thread() {
				@Override
				public void run() {
					boolean terminado = false;
					while(!terminado){
						System.out.println("Está en el bucle");
						if(!(Main.getGestorVentanas().getVentanaTablero().getU4().equals(""))){
							System.out.println("Ultima ventana cerrada");
							terminado = true;
							Main.getGestorVentanas().getVentanaTablero().setVisible(true);
							Main.getGestorVentanas().getVentanaTablero().setU1(Main.getUsuarioActual());
							Main.getGestorVentanas().getVentanaTablero().jugar(t);;
						}
					}
				}
			}).start();
		}
	});
	}
}
