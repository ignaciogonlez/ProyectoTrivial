package main;

import ventanas.*;

/** 
 * Clase para el control de flujo de ventanas
 */
public class GestorVentanas {
	
	VentanaPrincipal ventanaPrincipal;
	VentanaInicioSesion ventanaInicio;
	VentanaRegistrarse ventanaRegistro;
	VentanaMenu ventanaMenu;
	VentanaAmigos ventanaAmigos;
	VentanaAgregarAmigos ventanaAgregarAmigos;
	VentanaClasificacion ventanaClasificacion;
	VentanaCarga ventanaCarga1;
	VentanaCarga ventanaCarga2;
	VentanaCarga ventanaCarga3;
	VentanaCarga ventanaCarga4;
	VentanaCargaServidor ventanaCargaServidor;
	VentanaTablero ventanaTablero;
	
	
	public GestorVentanas() {
		ventanaPrincipal = new VentanaPrincipal();
		ventanaInicio = new VentanaInicioSesion();
		ventanaRegistro = new VentanaRegistrarse();
		ventanaMenu = new VentanaMenu();
		//ventanaAmigos = new VentanaAmigos();
		//ventanaAgregarAmigos = new VentanaAgregarAmigos();
		ventanaClasificacion = new VentanaClasificacion();
		ventanaCarga1 = new VentanaCarga();
		ventanaCarga2 = new VentanaCarga();
		ventanaCarga3 = new VentanaCarga();
		ventanaCarga4 = new VentanaCarga();
		ventanaCargaServidor = new VentanaCargaServidor();
		ventanaTablero = new VentanaTablero();
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
	public VentanaAgregarAmigos getVentanaAgregarAmigos(){
		return ventanaAgregarAmigos;
	}
	public VentanaClasificacion getVentanaClasificacion(){
		return ventanaClasificacion;
	}
	public VentanaCarga getVentanaCarga1() {
		return ventanaCarga1;
	}
	public VentanaCarga getVentanaCarga2() {
		return ventanaCarga2;
	}
	public VentanaCarga getVentanaCarga3() {
		return ventanaCarga3;
	}
	public VentanaCarga getVentanaCarga4() {
		return ventanaCarga4;
	}
	public VentanaCargaServidor getVentanaCargaServidor() {
		return ventanaCargaServidor;
	}
	public VentanaTablero getVentanaTablero(){
		return ventanaTablero;
	}
}
