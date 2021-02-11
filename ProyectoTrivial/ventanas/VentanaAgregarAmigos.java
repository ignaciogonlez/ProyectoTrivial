package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import main.Main;

public class VentanaAgregarAmigos extends JFrame{
	
	JTextField TfBuscar;
	JButton bAgregar;
	JLabel lMensaje;
	
	public VentanaAgregarAmigos(){
		
		setTitle( "Agregar" );
		setSize( 500, 300 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		JPanel panelCentral = new JPanel(new FlowLayout());
		bAgregar = new JButton("Agregar");
		panelCentral.add(bAgregar);
		getContentPane().add(panelCentral,"Center");
		
		JPanel panelSuperior = new JPanel(new FlowLayout());
		TfBuscar = new JTextField();
		TfBuscar.setBounds(270, 50, 100, 25);
		panelSuperior.add(TfBuscar);
		getContentPane().add(panelSuperior,"North");
		
		JPanel panelInferior = new JPanel(new FlowLayout());
		lMensaje = new JLabel("Introduce el nombre del usuario que quieras agregar");
		panelInferior.add(lMensaje);
		getContentPane().add(panelInferior,"South");
		
		
		bAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String amigo = TfBuscar.getText();
					if(Main.getSistema().getbd().verificarUsuario(amigo)){
						lMensaje = new JLabel("Se ha agregado nuevo amigo correctamente");
						lMensaje.setForeground(Color.GREEN);
						lMensaje.repaint();
					}else{
						lMensaje = new JLabel("No se ha encontrado el usuario o no se ha agregado correctamente");
						lMensaje.setForeground(Color.RED);
						lMensaje.repaint();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

}
