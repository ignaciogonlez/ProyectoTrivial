	
package main ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import Basededatos.conexionbasededatos;
import datos.Usuario;
import ventanas.VentanaPregunta;

public class Main {
	
	private static GestorVentanas gestorVentanas;
	private static Sistema sistema;
	private static Properties properties;
	
	public static void main(String[] args) throws SQLException, IOException {
		
		sistema = new Sistema();
		gestorVentanas = new GestorVentanas();
		gestorVentanas.getVentanaPrincipal().setVisible(true);
		sistema.bd.inicioBD("TrivialBD");
		inicializarProperties();
	} 
	
	public static GestorVentanas getGestorVentanas() {
		return gestorVentanas;
	}
	
	public static Sistema getSistema(){
		return sistema;
	}
	
	public static void inicializarProperties() throws IOException {
		properties = new Properties();
		
		try {
			InputStream is = new FileInputStream("posiciones.properties");
			properties.load(is);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getProperties() {
		return properties;
	}
	
	
}