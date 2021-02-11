package ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.Usuario;
import main.Main;

/** 
 * Ventana para poder ver tu localización en puntos respecto a tus amigos agregados (puntos por ganar una partida)
 */
public class VentanaClasificacion extends JFrame{
	
	JButton bAtras;
	JTable tClasificacion;
	
	public VentanaClasificacion() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Clasificacion" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		JPanel panelInferior = new JPanel(new FlowLayout());
		
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior,"South");
		
		JPanel panelCentral = new JPanel(new FlowLayout());
		crearTabla();
		panelCentral.add(tClasificacion);
		getContentPane().add(panelCentral,"Center");
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
			}
		});
	}

	private void crearTabla(){
		tClasificacion = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new Object[]{"Usuario", "Puntuación"});
		try{
			ArrayList<Usuario> listaAmigos = Main.getSistema().getbd().listaUsuariosAmigos(Main.getUsuarioActual());
			for(Usuario u : listaAmigos){
				modelo.addRow(new Object[]{u.getNombre(), u.getPuntuacion()});
			}
			tClasificacion.setModel(modelo);
		}catch (Exception e){
			System.out.println(e);
		}
	}
}
