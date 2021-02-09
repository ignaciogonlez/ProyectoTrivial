package ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.Usuario;
import main.Main;

/** 
 * Ventana para ver los amigos que tienes agregados y agregar nuevos amigos.
 */
public class VentanaAmigos extends JFrame {
	
	JButton bAtras;
	JButton bAgregar;
	JTable tAmigos;
	
	public VentanaAmigos() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Amigos" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );

		JPanel panelSuperior = new JPanel(new FlowLayout());
		bAgregar = new JButton("+");
		panelSuperior.add(bAgregar);
		getContentPane().add(panelSuperior,"North");

		JPanel panelCentral = new JPanel(new FlowLayout());
		crearTabla();
		panelCentral.add(tAmigos);
		getContentPane().add(panelCentral,"Center");

		JPanel panelInferior = new JPanel(new FlowLayout());
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior,"South");


		bAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main.getGestorVentanas().getVentanaAgregarAmigos().setVisible(true);
				VentanaAgregarAmigos v = new VentanaAgregarAmigos();
				v.setVisible(true);
			}
		});

		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
			}
		});
	}

	private void crearTabla(){
		tAmigos = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new Object[]{"Usuario", "Puntuación"});
		try{
			ArrayList<Usuario> listaAmigos = Main.getSistema().getbd().sacarAmigos(Main.getUsuarioActual().getNombre());
			for(Usuario u : listaAmigos){
				modelo.addRow(new Object[]{u.getNombre(), u.getPuntuacion()});
			}
			tAmigos.setModel(modelo);
		}catch (Exception e){
			System.out.println(e);
		}
	}
}
