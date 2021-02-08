package datos;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
	String nombre;
	String password;
	int puntuacion;
	 ArrayList<Usuario> listaAmigos;
	
	public Usuario(String nombre, String password, int puntuacion, ArrayList<Usuario> listaAmigos)  {
		this.nombre=nombre;
		this.password=password;
		this.puntuacion = puntuacion;
		this.listaAmigos= listaAmigos;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getPassword() {
		return this.password;
	}
	public String toString() {
		return nombre;
	}
	public int getPuntuacion() {
		return this.puntuacion;
	}
	public void setPuntuacion(int suma) {
		this.puntuacion = puntuacion+suma;
	}
}
