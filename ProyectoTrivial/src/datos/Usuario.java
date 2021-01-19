package datos;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
	String nombre;
	String password;
	public Usuario(String nombre, String password, ArrayList<Date> partidas) {
		this.nombre=nombre;
		this.password=password;
		
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getPassword() {
		return this.password;
	}
}
