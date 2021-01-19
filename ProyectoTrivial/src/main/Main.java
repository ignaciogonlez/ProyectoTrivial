package main;

import datos.Usuario;

public class Main {
	
	private static GestorVentanas gestorVentanas;
	private static Sistema sistema;

	public static void main(String[] args) {
		
		sistema = new Sistema();
		gestorVentanas = new GestorVentanas();
		gestorVentanas.getVentanaPrincipal().setVisible(true);
		for (Usuario u : sistema.getListaUsuarios()) {
			System.out.println(u);
		} 

	}
	
	public static GestorVentanas getGestorVentanas() {
		return gestorVentanas;
	}
	
	public static Sistema getSistema(){
		return sistema;
	}
}
