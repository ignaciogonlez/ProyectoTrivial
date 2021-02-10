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
 * Ventana principal del juego
 */
public class VentanaPrincipal extends JFrame {
	
	private JButton bCerrar;
	private JButton bInicio;
	private JButton bRegistrarse;

	
	
	public VentanaPrincipal(){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Menu" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		
		//Paneles principales
		JPanel panelCentral = new JPanel(new BorderLayout());
		panelCentral.setBackground(Color.yellow);
		JPanel panelInferior = new JPanel(new FlowLayout());
		JPanel panelSuperior = new JPanel(new BorderLayout());
		
		//PanelCentral
		JLabel lMensaje = new JLabel("                     PREGUNTADOS");
		lMensaje.setForeground(Color.RED);
		lMensaje.setFont(new Font("Serif", Font.PLAIN, 44));
		panelSuperior.add(lMensaje);
		getContentPane().add(panelSuperior,"North");
		
		//PanelInferior
		bInicio = new JButton("Iniciar Sesión");
		panelInferior.add(bInicio);
		bRegistrarse = new JButton("Registrase");
		panelInferior.add(bRegistrarse);
		bCerrar = new JButton("Cerrar");
		panelInferior.add(bCerrar);
		getContentPane().add(panelInferior,"South");
		
		
		bInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaInicio().setVisible(true);
				dispose();
			}	
		});
		bRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaRegistro().setVisible(true);
				dispose();
			}
		});
		bCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//ETIQUETA IMAGEN
		JLabel etiquetaImg = new JLabel(new ImageIcon("Trvial.jpg"));
		etiquetaImg.setBounds(10, 20, 512, 512);
		panelCentral.add(etiquetaImg);
		getContentPane().add(panelCentral,"Center");
		
	}

}


