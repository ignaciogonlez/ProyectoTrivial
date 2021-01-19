package main;

import java.util.ArrayList;

import Basededatos.conexionbasededatos;
import datos.Pregunta;
import datos.Usuario;


/** 
 * Sistema para ir gestionando los datos del juego
 */
public class Sistema {
	ArrayList<Usuario> listaUsuarios;
	ArrayList<Pregunta> listaPreguntas;
	conexionbasededatos bd = new conexionbasededatos();
	
	public Sistema() {
		listaUsuarios = new ArrayList<Usuario>();
	}
	
	public ArrayList<Usuario> getListaUsuarios(){
		return listaUsuarios;
	}
	public ArrayList<Pregunta> getListaPreguntas(){
		return listaPreguntas;
	}
	public void addUsuario(Usuario u) {
		listaUsuarios.add(u);
	}
	public conexionbasededatos getbd() {
		return bd;
	}
}
