package ventanas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datos.Usuario;
import main.Main;

/** 
 * Ventana para registrarse en la aplicacion 
 */
public class VentanaRegistrarse extends JFrame{
	
	JLabel lUsuario;
	JTextField tfUsuario;
	JLabel lPasword;
	JTextField tfPasword;
	JLabel lRPasword;
	JTextField tfRPasword;
	JLabel lMensaje;
	JButton bRegistrarse;
	JButton bAtras;
	
	
	public VentanaRegistrarse() {
		setTitle( "Registro" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		panel.setLayout(null);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.green);
		
		lUsuario = new JLabel("Usuario");
		lUsuario.setBounds(270, 200, 80, 25);
		panel.add(lUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(330, 200, 160, 25);
		panel.add(tfUsuario);
		
		lPasword = new JLabel("Password");
		lPasword.setBounds(270, 250, 80, 25);
		panel.add(lPasword);
		
		tfPasword = new JTextField();
		tfPasword.setBounds(330, 250, 190, 25);
		panel.add(tfPasword);
		
		lRPasword = new JLabel("Password");
		lRPasword.setBounds(270, 300, 80, 25);
		panel.add(lRPasword);
		
		tfRPasword = new JTextField();
		tfRPasword.setBounds(330, 300, 190, 25);
		panel.add(tfRPasword);
		
		lMensaje = new JLabel("(Repeat)");
		lMensaje.setForeground(Color.RED); 
		lMensaje.setBounds(550, 300, 80, 25);
		panel.add(lMensaje);
		
		getContentPane().add(panel);
		
		bRegistrarse = new JButton("Registrarse");
		panelInferior.add(bRegistrarse);
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior,"South");
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
				dispose();
			}
		});
		bRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (registroCorrecto()) {
					String usuario = tfUsuario.getText();
					String password = tfPasword.getText();
					ArrayList<Date> partidas = new ArrayList<Date>();
					Usuario usur = new Usuario(usuario, password,partidas);
					//Main.getSistema().getListaUsuarios().add(usur);
					//Main.getSistema().addUsuario(usur);
					dispose();
				}
			}
		});
	}
	/** 
	 * Metodo por programar para ver si las dos contrasenas son iguales, el nombre no este repetido...
	 */
	public boolean registroCorrecto() {
		boolean correcto = false;
		return correcto;
	}
}
