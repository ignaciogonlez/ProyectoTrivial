package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

import main.Main;

public class VentanaCargaServidor extends JFrame {
	
	private static int PUERTO = 3000;	//Puerto de conexión
	JLabel lClientes = new JLabel( " " );
	boolean finComunicacion = false;
    ArrayList<Socket> lSockets = new ArrayList<>(); 
    ArrayList<PrintWriter> lSalidas = new ArrayList<>();
    int numCliente = 0;	//Añadimos un número de cliente para saber cuántos se conectan
	
	public VentanaCargaServidor() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Preparese" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
			
		JPanel panelCentral = new JPanel(new BorderLayout());
		panelCentral.setBackground(Color.pink);
		JPanel panelBajo = new JPanel(new BorderLayout());
		panelCentral.setBackground(Color.pink);
			
		//PanelCentral
		JLabel lMensaje = new JLabel("            ESPERANDO A LOS DEMÃ�S JUGADORES");
		lMensaje.setForeground(Color.black);
		lMensaje.setFont(new Font("Serif", Font.PLAIN, 30));
		panelCentral.add(lMensaje);
		getContentPane().add(panelCentral,"Center");
		
		//PanelBajo
		panelBajo.add(lClientes);
		getContentPane().add(panelBajo,"South" );
		
		//Para cerrar todos los sockets abiertos
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					// *VARIOS CLIENTES*
					// Se cierran todos los sockets abiertos 
					for (Socket socket : lSockets) socket.close();
				} catch (IOException e1) {
		    		lClientes.setText("Error en servidor: " + e1.getMessage());
				}
				finComunicacion = true;
			}
		});
	}
	
	public void lanzaServidor() {
		// *VARIOS CLIENTES*
		// Como el servidor va a gestionar varios clientes, en lugar de abrir solo una conexión, abre repetidamente conexiones hasta final
		try(ServerSocket serverSocket = new ServerSocket( PUERTO )) {
			serverSocket.setSoTimeout( 5000 );  // Para que haya un timeout en el accept - por si cerramos la aplicación para que no se quede esperando de forma infinita
			while (!finComunicacion) {
				try {
					Socket socket = serverSocket.accept(); // Se queda esperando a una conexión con timeout
					// *VARIOS CLIENTES*
					// Cada vez que un cliente se conecta, se genera un HILO que hace la comunicación (la lectura) con ese cliente. Y el servidor sigue ejecutando para esperar a otro cliente
					lSockets.add( socket );
					numCliente++;
					Thread t = new Thread ( new Runnable() { @Override public void run() {
						int numC = numCliente;
						try {
							lClientes.setText( "Cliente " + numC + " conectado" );
							BufferedReader inputDesdeCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));
							PrintWriter outputACliente = new PrintWriter(socket.getOutputStream(), true);
							lSalidas.add( outputACliente );  // Para mensajes de difusión
							while(!finComunicacion) {  // ciclo de lectura desde el cliente hasta que acabe la comunicación
								//TODO
							}
							lClientes.setText( "El cliente " + numC + " se ha desconectado." );
							socket.close();
							lSockets.remove( socket );
							lSalidas.remove( outputACliente );
						} catch(IOException e) {
							if (finComunicacion) {
								System.out.println( "Cerrada comunicación con cliente " + numC + " por cierre de servidor." );
							} else {
								e.printStackTrace();
							}
						}
					} } );
					t.start();
				} catch (SocketTimeoutException e) {
					// Timeout en socket servidor - se reintenta (en el mismo while)
				}
			}
		} catch(IOException e) {
			lClientes.setText("Error en servidor: " + e.getMessage());
		}

	}

}
