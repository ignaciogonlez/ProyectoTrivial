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
	
	private static String HOST = "localhost";  //IP de conexi�n para la comunicaci�n
	private static int PUERTO = 3000; //Puerto de conexi�n
	private JTextArea taEstado = new JTextArea();
	private PrintWriter outputAServer;
    private boolean finComunicacion = false;
    private String nombre;
    String numeroC = "0"; //Numero de cliente que manda el servidor
    int numA = 0;

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
	        	System.out.println("cliente");
	            BufferedReader inputDesdeServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            outputAServer = new PrintWriter(socket.getOutputStream(), true);
	            do { // Ciclo de lectura desde el servidor hasta que acabe la comunicaci�n
	            	String feedback = inputDesdeServer.readLine();
	            	if(feedback.equals( "Pregunta" )){
	            		(new Thread() {
	        				@Override
	        				public void run() {
	        					System.out.println("saca");
	        					VentanaPregunta ventanaPregunta = new VentanaPregunta(new VentanaTablero());
	        					while(!ventanaPregunta.getCorrecta().equals("")){
	        						if(ventanaPregunta.getCorrecta().equals("true")){
	        							break;
	        						}
	        						if(ventanaPregunta.getCorrecta().equals("false")){
	        							try {Thread.sleep(5000); } catch (InterruptedException e) {}
	        							outputAServer.println("false");
	        							break;
	        						}
	        					}
	        				}
	        			}).start();
	            	}
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
