package ventanas;

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

import main.GestorVentanas;
import main.Main;

/** 
 * Ventana de espera del juego
 */

public class VentanaCarga extends JFrame {
	
	private static String HOST = "localhost";  //IP de conexión para la comunicación
	private static int PUERTO = 3000; //Puerto de conexión
	private JTextArea taEstado = new JTextArea();
	private PrintWriter outputAServer;
    private boolean finComunicacion = false;
    private String nombre;

	public VentanaCarga() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Preparese" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		taEstado.setEditable( false );
		
		JPanel panelCentral = new JPanel(new BorderLayout());
		panelCentral.setBackground(Color.pink);
		JPanel panelInferior = new JPanel(new BorderLayout());
		panelInferior.setBackground(Color.pink);
		
		//PanelCentral
		JLabel lMensaje = new JLabel("            ESPERE A QUE DE COMIENZO LA PARTIDA");
		lMensaje.setForeground(Color.black);
		lMensaje.setFont(new Font("Serif", Font.PLAIN, 30));
		panelCentral.add(lMensaje);
		getContentPane().add(panelCentral,"Center");
		
		//PanelInferior
		panelInferior.add(taEstado);
		getContentPane().add(panelInferior,"South");

	}
	
	 public void lanzaCliente() {
	        try (Socket socket = new Socket( HOST, PUERTO )) {
	            BufferedReader inputDesdeServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            outputAServer = new PrintWriter(socket.getOutputStream(), true);
	            do { // Ciclo de lectura desde el servidor hasta que acabe la comunicación
	            	//TODO
	            } while (!finComunicacion);
	        } catch (IOException e) {
         	taEstado.append( "Error en cliente: " + e.getMessage() + "\n" );
	        }
	        taEstado.append( "Fin de proceso de cliente.\n" );
	        System.out.println( "Cerrando ventana cliente " + nombre + " en 2 segundos..." );
	        if (finComunicacion) {
	        	try { Thread.sleep( 2000 ); } catch (InterruptedException e) {}
	        	dispose();
	        }
	    }
}
