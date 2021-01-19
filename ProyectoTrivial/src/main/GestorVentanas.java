package main;

import ventanas.VentanaAmigos;
import ventanas.VentanaCarga;
import ventanas.VentanaClasificacion;
import ventanas.VentanaInicioSesion;
import ventanas.VentanaMenu;
import ventanas.VentanaPrincipal;
import ventanas.VentanaRegistrarse;
import ventanas.VentanaCargaServidor;

/** 
 * Clase para el control de flujo de ventanas
 */
public class GestorVentanas {
	
	VentanaPrincipal ventanaPrincipal;
	VentanaInicioSesion ventanaInicio;
	VentanaRegistrarse ventanaRegistro;
	VentanaMenu ventanaMenu;
	VentanaAmigos ventanaAmigos;
	VentanaClasificacion ventanaClasificacion;
	VentanaCarga ventanaCarga;
	VentanaCargaServidor ventanaCargaServidor;
	
	public GestorVentanas() {
		ventanaPrincipal = new VentanaPrincipal();
		ventanaInicio = new VentanaInicioSesion();
		ventanaRegistro = new VentanaRegistrarse();
		ventanaMenu = new VentanaMenu();
		ventanaAmigos = new VentanaAmigos();
		ventanaClasificacion = new VentanaClasificacion();
		ventanaCarga = new VentanaCarga();
		ventanaCargaServidor = new VentanaCargaServidor();
	}
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}
	public VentanaInicioSesion getVentanaInicio() {
		return ventanaInicio;
	}
	public VentanaRegistrarse getVentanaRegistro() {
		return ventanaRegistro;
	}
	public VentanaMenu getVentanaMenu() {
		return ventanaMenu;
	}
	public VentanaAmigos getVentanaAmigos(){
		return ventanaAmigos;
	}
	public VentanaClasificacion getVentanaClasificacion(){
		return ventanaClasificacion;
	}
	public VentanaCarga getVentanaCarga() {
		return ventanaCarga;
	}
	public VentanaCargaServidor getVentanaCargaServidor() {
		return ventanaCargaServidor;
	}
}
