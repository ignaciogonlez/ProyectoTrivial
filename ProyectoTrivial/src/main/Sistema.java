package main;

import java.util.ArrayList;

import datos.Pregunta;


/** 
 * Sistema para ir gestionando los datos del juego
 */
public class Sistema {
	ArrayList<String> listaUsuarios;
	ArrayList<Pregunta> listaPreguntas;
	
	public Sistema() {
		listaUsuarios = new ArrayList<String>();
	}
	
	public ArrayList<String> getListaUsuarios(){
		return listaUsuarios;
	}
	public ArrayList<Pregunta> getListaPreguntas(){
		return listaPreguntas;
	}
	public void incluirUsuario(String usuario) {
		listaUsuarios.add(usuario);
	}
}
