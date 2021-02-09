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
		
		JPanel panelSuperior = new JPanel(new FlowLayout());
		panelSuperior.add(TfBuscar);
		bAgregar = new JButton("Agregar");
		panelSuperior.add(bAgregar);
		getContentPane().add(panelSuperior);
		
		JPanel panelCentral = new JPanel(new FlowLayout());
		panelCentral.add(lMensaje);
		getContentPane().add(panelCentral);
		
		bAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Main.getSistema().getbd().verificarYAgregarUsuario(TfBuscar.getText(), Main.getUsuarioActual().getListaAmigos())){
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
