package datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2965387468888289999L;
	String nombre;
	String password;
	int puntuacion;
	 ArrayList<Usuario> listaAmigos;
	
	public Usuario(String nombre, String password, int puntuacion)  {
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
	public ArrayList<Usuario> getListaAmigos(){
		return listaAmigos;
	}
}
