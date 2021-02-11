package ventanas;

import java.awt.*;
import javax.swing.*;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.Main;

/** 
 * Ventana para realizar el login en partida
 */
public class VentanaInicioEnPartida extends JFrame{
	
	JButton bEntrar;
	JLabel lUsuario;
	JTextField TfUsuario;
	JLabel lPasword;
	JTextField TfPasword;
	boolean cerrada;
	
	public VentanaInicioEnPartida(int jugador) {

		setTitle( "Inicio de sesión del Jugador " + jugador );
		setSize( 400, 300 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		cerrada = false;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.yellow);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.red);
		
		bEntrar = new JButton("Entrar");
		panelInferior.add(bEntrar);
		getContentPane().add(panelInferior,"South");
		
		lUsuario = new JLabel("Usuario");
		lUsuario.setBounds(80, 60, 80, 25);
		panel.add(lUsuario);
		
		TfUsuario = new JTextField();
		TfUsuario.setBounds(140, 60, 160, 25);
		panel.add(TfUsuario);
		
		lPasword = new JLabel("Password");
		lPasword.setBounds(80, 110, 80, 25);
		panel.add(lPasword);
		
		TfPasword = new JTextField();
		TfPasword.setBounds(140, 110, 190, 25);
		panel.add(TfPasword);
		
		getContentPane().add(panel);
		
		//Reviso si esta en la bd
		bEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = TfUsuario.getText();

				String password = TfPasword.getText();

				try {

					if(main.Main.getSistema().getbd().inicioCorrecto(nombre, password)) {
						cerrada = true;
						dispose();
						if(jugador==2){
							Main.getGestorVentanas().getVentanaTablero().setU2(nombre);
						}
						if(jugador==3){
							Main.getGestorVentanas().getVentanaTablero().setU3(nombre);
						}
						if(jugador==4){
							Main.getGestorVentanas().getVentanaTablero().setU4(nombre);
						}


					}

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});

	}

	public void setTitulo(int jugador){
		setTitle("Inicio Sesion de Jugador " + jugador);	
	
}
}
