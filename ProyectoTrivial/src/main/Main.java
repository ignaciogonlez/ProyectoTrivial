package main;

import Basededatos.conexionbasededatos;
import datos.Usuario;

public class Main {
	
	private static GestorVentanas gestorVentanas;
	private static Sistema sistema;
	
	
	public static void main(String[] args) {
		
		sistema = new Sistema();
		gestorVentanas = new GestorVentanas();
		gestorVentanas.getVentanaPrincipal().setVisible(true);
		sistema.bd.inicioBD("TrivialBD");
//		sistema.insertarPreguntas();
//		sistema.bd.verPreguntas();
//		sistema.bd.insertarPreguntas(sistema.listaPreguntas);
		//sistema.bd.insertarRespuestas();
		sistema.bd.verRespuestas();
	} 
	
	public static GestorVentanas getGestorVentanas() {
		return gestorVentanas;
	}
	
	public static Sistema getSistema(){
		return sistema;
	}
	
}