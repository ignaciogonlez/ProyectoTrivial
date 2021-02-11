	
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
	private static Properties properties1, properties2, properties3, properties4;
	static Usuario usuarioActual;
	
	public static void main(String[] args) throws SQLException, IOException {
		
		sistema = new Sistema();
		gestorVentanas = new GestorVentanas();
		gestorVentanas.getVentanaPrincipal().setVisible(true);
		sistema.bd.inicioBD("TrivialBD");
		sistema.bd.verPreguntas();
		//sistema.bd.crearTablasBD();
		inicializarProperties();
	} 
	
	public static GestorVentanas getGestorVentanas() {
		return gestorVentanas;
	}
	
	public static Sistema getSistema(){
		return sistema;
	}
	
	public static void inicializarProperties() throws IOException {
		properties1 = new Properties();
		properties2 = new Properties();
		properties3 = new Properties();
		properties4 = new Properties();
		
		try {
			InputStream is1 = new FileInputStream("posiciones1.properties");
			properties1.load(is1);
			
			InputStream is2 = new FileInputStream("posiciones2.properties");
			properties2.load(is2);
			
			InputStream is3 = new FileInputStream("posiciones3.properties");
			properties3.load(is3);
			
			InputStream is4 = new FileInputStream("posiciones4.properties");
			properties4.load(is4);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getProperties1() {
		return properties1;
	}
	
	public static Properties getProperties2() {
		return properties2;
	}
	
	public static Properties getProperties3() {
		return properties3;
	}
	
	public static Properties getProperties4() {
		return properties4;
	}
	
	public static Usuario getUsuarioActual(){
		return usuarioActual;
	}
	
	public static void setUsuarioActual(Usuario usuario){
		usuarioActual = usuario;
	}
	
}