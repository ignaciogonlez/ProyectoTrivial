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
	VentanaInicioEnPartida ventanaInicioEnPartida2;
	VentanaInicioEnPartida ventanaInicioEnPartida3;
	VentanaInicioEnPartida ventanaInicioEnPartida4;
	VentanaTablero ventanaTablero;
	
	
	public GestorVentanas() {
		ventanaPrincipal = new VentanaPrincipal();
		ventanaInicio = new VentanaInicioSesion();
		ventanaRegistro = new VentanaRegistrarse();
		ventanaMenu = new VentanaMenu();
		ventanaClasificacion = new VentanaClasificacion();
		ventanaInicioEnPartida2 = new VentanaInicioEnPartida(2);
		ventanaInicioEnPartida3 = new VentanaInicioEnPartida(3);
		ventanaInicioEnPartida4 = new VentanaInicioEnPartida(4);
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
	public VentanaInicioEnPartida getVentanaInicioEnPartida2(){
		return ventanaInicioEnPartida2;
	}
	public VentanaInicioEnPartida getVentanaInicioEnPartida3(){
		return ventanaInicioEnPartida3;
	}
	public VentanaInicioEnPartida getVentanaInicioEnPartida4(){
		return ventanaInicioEnPartida4;
	}
	public VentanaTablero getVentanaTablero(){
		return ventanaTablero;
	}
}
