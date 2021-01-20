package main;

import java.sql.SQLException;

import Basededatos.conexionbasededatos;
import datos.Usuario;

public class Main {
	
	private static GestorVentanas gestorVentanas;
	private static Sistema sistema;
	
	
	public static void main(String[] args) throws SQLException {
		
		sistema = new Sistema();
		gestorVentanas = new GestorVentanas();
		gestorVentanas.getVentanaPrincipal().setVisible(true);
		sistema.bd.inicioBD("TrivialBD");
	} 
	
	public static GestorVentanas getGestorVentanas() {
		return gestorVentanas;
	}
	
	public static Sistema getSistema(){
		return sistema;
	}
	
}