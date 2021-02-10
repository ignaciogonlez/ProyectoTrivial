
package ventanas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Main;

/** 
 * Ventana para realizar el login
 */
public class VentanaInicioSesion extends JFrame{
	
	JButton bAtras;
	JButton bEntrar;
	JLabel lUsuario;
	JTextField TfUsuario;
	JLabel lPasword;
	JTextField TfPasword;
	
	public VentanaInicioSesion() {
		
		//FondoPanel fondo = new FondoPanel();
		//fondo.setImagen("/fotos/trivial2.jpg");
		//this.setContentPane(fondo);
		
		
		
		
		
		setTitle( "Inicio sesion" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.yellow);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.red);
		
		bEntrar = new JButton("Entrar");
		panelInferior.add(bEntrar);
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior,"South");
		
		lUsuario = new JLabel("Usuario");
		lUsuario.setBounds(270, 200, 80, 25);
		panel.add(lUsuario);
		
		TfUsuario = new JTextField();
		TfUsuario.setBounds(330, 200, 160, 25);
		panel.add(TfUsuario);
		
		lPasword = new JLabel("Password");
		lPasword.setBounds(270, 250, 80, 25);
		panel.add(lPasword);
		
		TfPasword = new JTextField();
		TfPasword.setBounds(330, 250, 190, 25);
		panel.add(TfPasword);
		
		getContentPane().add(panel);
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
				dispose();
			}
		});
		//Reviso si esta en la bd
		bEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = TfUsuario.getText();
				String password = TfPasword.getText();
				try {
					if(main.Main.getSistema().getbd().inicioCorrecto(nombre, password)) {
						Main.getGestorVentanas().getVentanaMenu().setVisible(true);
						//Main.setUsuarioActual(Main.getSistema().getbd().sacarUsuarioActual(nombre));
						dispose();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	
}
