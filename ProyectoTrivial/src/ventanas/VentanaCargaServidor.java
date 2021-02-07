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
    int numComienzo = 0; //Sirve para saber si es la primera pregunta
    int numAciertos = 0; //Aciertos que lleva cada cliente
	
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
			serverSocket.setSoTimeout( 50000 );  // Para que haya un timeout en el accept - por si cerramos la aplicación para que no se quede esperando de forma infinita
			while (!finComunicacion) {
				try {
					System.out.println("servidor");
					Socket socket = serverSocket.accept(); // Se queda esperando a una conexión con timeout
					// *VARIOS CLIENTES*
					// Cada vez que un cliente se conecta, se genera un HILO que hace la comunicación (la lectura) con ese cliente. Y el servidor sigue ejecutando para esperar a otro cliente
					lSockets.add( socket );
					numCliente++;
					Thread t = new Thread ( new Runnable() { @Override public void run() {
						int numC = numCliente;
						int numCom = numComienzo;
						int numA = numAciertos;
						System.out.println("hilo");
						try {
							BufferedReader inputDesdeCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));
							PrintWriter outputACliente = new PrintWriter(socket.getOutputStream(), true);
							lSalidas.add( outputACliente );  // Para mensajes de difusión
							System.out.println("c");
							while (!finComunicacion) {  // ciclo de lectura desde el cliente hasta que acabe la comunicación
								System.out.println("prop");
								if(numCom==0){
									System.out.println("h");
									numCom = 1;
									try {Thread.sleep(5000); } catch (InterruptedException e) {}
									for (PrintWriter outputCl : lSalidas) {
										System.out.println("pr");
										outputCl.println( "Pregunta" );
									}
								}
								String textoRecibido = inputDesdeCliente.readLine();
								if(textoRecibido.equals("true")){ //Actualiza las coordenadas
									numA++;
									if(numA==1 && numC==1){
										Main.getGestorVentanas().getVentanaTablero().getJ1().setx(400);
									}
									if(numA==1 && numC==2){
										Main.getGestorVentanas().getVentanaTablero().getJ2().setx(400);
									}
									if(numA==1 && numC==3){
										Main.getGestorVentanas().getVentanaTablero().getJ3().setx(400);
									}
									if(numA==1 && numC==4){
										Main.getGestorVentanas().getVentanaTablero().getJ4().setx(400);
									}
									if(numA==2 && numC==1){
										Main.getGestorVentanas().getVentanaTablero().getJ1().setx(100);
									}
									if(numA==2 && numC==2){
										Main.getGestorVentanas().getVentanaTablero().getJ2().setx(100);
									}
									if(numA==2 && numC==3){
										Main.getGestorVentanas().getVentanaTablero().getJ3().setx(100);
									}
									if(numA==2 && numC==4){
										Main.getGestorVentanas().getVentanaTablero().getJ4().setx(100);
									}
									if(numA==3 && numC==1){
										Main.getGestorVentanas().getVentanaTablero().getJ1().setx(150);
										Main.getGestorVentanas().getVentanaTablero().getJ1().sety(310);
									}
									if(numA==3 && numC==2){
										Main.getGestorVentanas().getVentanaTablero().getJ2().setx(150);
										Main.getGestorVentanas().getVentanaTablero().getJ2().sety(280);
									}
									if(numA==3 && numC==3){
										Main.getGestorVentanas().getVentanaTablero().getJ3().setx(150);
										Main.getGestorVentanas().getVentanaTablero().getJ3().sety(250);
									}
									if(numA==3 && numC==4){
										Main.getGestorVentanas().getVentanaTablero().getJ4().setx(150);
										Main.getGestorVentanas().getVentanaTablero().getJ4().setx(220);
									}
									if(numA==4 && numC==1){
										Main.getGestorVentanas().getVentanaTablero().getJ1().setx(280);
									}
									if(numA==4 && numC==2){
										Main.getGestorVentanas().getVentanaTablero().getJ2().setx(280);
									}
									if(numA==4 && numC==3){
										Main.getGestorVentanas().getVentanaTablero().getJ3().setx(280);
									}
									if(numA==4 && numC==4){
										Main.getGestorVentanas().getVentanaTablero().getJ4().setx(280);
									}
									if(numA==5 && numC==1){
										Main.getGestorVentanas().getVentanaTablero().getJ1().setx(480);
									}
									if(numA==5 && numC==2){
										Main.getGestorVentanas().getVentanaTablero().getJ2().setx(480);
									}
									if(numA==5 && numC==3){
										Main.getGestorVentanas().getVentanaTablero().getJ3().setx(480);
									}
									if(numA==5 && numC==4){
										Main.getGestorVentanas().getVentanaTablero().getJ4().setx(480);
									}
									if(numA==6 && numC==1){
										Main.getGestorVentanas().getVentanaTablero().getJ1().setx(680);
									}
									if(numA==6 && numC==2){
										Main.getGestorVentanas().getVentanaTablero().getJ2().setx(680);
									}
									if(numA==6 && numC==3){
										Main.getGestorVentanas().getVentanaTablero().getJ3().setx(680);
									}
									if(numA==6 && numC==4){
										Main.getGestorVentanas().getVentanaTablero().getJ4().setx(680);
									}
									if(numA==7 && numC==1){
										Main.getGestorVentanas().getVentanaTablero().getJ1().sety(160);
									}
									if(numA==7 && numC==2){
										Main.getGestorVentanas().getVentanaTablero().getJ2().sety(130);
									}
									if(numA==7 && numC==3){
										Main.getGestorVentanas().getVentanaTablero().getJ3().sety(100);
									}
									if(numA==7 && numC==4){
										Main.getGestorVentanas().getVentanaTablero().getJ4().sety(80);
									}
									if(numA==8 && numC==1){
										Main.getGestorVentanas().getVentanaTablero().getJ1().setx(480);
									}
									if(numA==8 && numC==2){
										Main.getGestorVentanas().getVentanaTablero().getJ2().setx(480);
									}
									if(numA==8 && numC==3){
										Main.getGestorVentanas().getVentanaTablero().getJ3().setx(480);
									}
									if(numA==8 && numC==4){
										Main.getGestorVentanas().getVentanaTablero().getJ4().setx(480);
									}
									if(numA==9 && numC==1){
										Main.getGestorVentanas().getVentanaTablero().getJ1().setx(280);
									}
									if(numA==9 && numC==2){
										Main.getGestorVentanas().getVentanaTablero().getJ2().setx(280);
									}
									if(numA==9 && numC==3){
										Main.getGestorVentanas().getVentanaTablero().getJ3().setx(280);
									}
									if(numA==9 && numC==4){
										Main.getGestorVentanas().getVentanaTablero().getJ4().setx(280);
									}
									if(numA==10 && numC==1){
										Main.getGestorVentanas().getVentanaTablero().getJ1().setx(150);
									}
									if(numA==10 && numC==2){
										Main.getGestorVentanas().getVentanaTablero().getJ2().setx(150);
									}
									if(numA==10 && numC==3){
										Main.getGestorVentanas().getVentanaTablero().getJ3().setx(150);
									}
									if(numA==10 && numC==4){
										Main.getGestorVentanas().getVentanaTablero().getJ4().setx(150);
									}
									//try {Thread.sleep(5000); } catch (InterruptedException e) {}
									//Main.getGestorVentanas().getVentanaTablero().getJ1();
									//Main.getGestorVentanas().getVentanaTablero().getJ2();
									//Main.getGestorVentanas().getVentanaTablero().getJ3();
									//Main.getGestorVentanas().getVentanaTablero().getJ4();
									
								}
								if(textoRecibido.equals("true") && numC==1){
									try {Thread.sleep(5000); } catch (InterruptedException e) {}
									for (PrintWriter outputCl : lSalidas) {
										outputCl.println( "Pregunta" );
									}
								}
								if(textoRecibido.equals("false") && numC==1){
									try {Thread.sleep(5000); } catch (InterruptedException e) {}
									for (PrintWriter outputCl : lSalidas) {
										outputCl.println( "Pregunta" );
									}
								}
							}
							System.out.println("d");
							lClientes.setText( "El cliente " + numC + " se ha desconectado." );
//							socket.close();
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
					System.out.println("lol");
					// Timeout en socket servidor - se reintenta (en el mismo while)
				}
			}
		} catch(IOException e) {
			lClientes.setText("Error en servidor: " + e.getMessage());
		}

	}

}
