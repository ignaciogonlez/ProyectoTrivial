package main;

import java.util.ArrayList;

import Basededatos.conexionbasededatos;
import datos.Pregunta;
import datos.Respuesta;
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
		listaPreguntas = new ArrayList<Pregunta>();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Respuesta respuesta1a;
	Respuesta respuesta1b;
	Respuesta respuesta1c;
	Respuesta respuesta1d;
	ArrayList<Respuesta> respuestas1;
	Pregunta pregunta1;
	
	Respuesta respuesta2a;
	Respuesta respuesta2b;
	Respuesta respuesta2c;
	Respuesta respuesta2d;
	ArrayList<Respuesta> respuestas2;
	Pregunta pregunta2;
	
	Respuesta respuesta3a;
	Respuesta respuesta3b;
	Respuesta respuesta3c;
	Respuesta respuesta3d;
	ArrayList<Respuesta> respuestas3;
	Pregunta pregunta3;
	
	Respuesta respuesta4a;
	Respuesta respuesta4b;
	Respuesta respuesta4c;
	Respuesta respuesta4d;
	ArrayList<Respuesta> respuestas4;
	Pregunta pregunta4;
	
	Respuesta respuesta5a;
	Respuesta respuesta5b;
	Respuesta respuesta5c;
	Respuesta respuesta5d;
	ArrayList<Respuesta> respuestas5;
	Pregunta pregunta5;
	
	Respuesta respuesta6a;
	Respuesta respuesta6b;
	Respuesta respuesta6c;
	Respuesta respuesta6d;
	ArrayList<Respuesta> respuestas6;
	Pregunta pregunta6;
	
	Respuesta respuesta7a;
	Respuesta respuesta7b;
	Respuesta respuesta7c;
	Respuesta respuesta7d;
	ArrayList<Respuesta> respuestas7;
	Pregunta pregunta7;
	
	Respuesta respuesta8a;
	Respuesta respuesta8b;
	Respuesta respuesta8c;
	Respuesta respuesta8d;
	ArrayList<Respuesta> respuestas8;
	Pregunta pregunta8;
	
	Respuesta respuesta9a;
	Respuesta respuesta9b;
	Respuesta respuesta9c;
	Respuesta respuesta9d;
	ArrayList<Respuesta> respuestas9;
	Pregunta pregunta9;
	
	Respuesta respuesta10a;
	Respuesta respuesta10b;
	Respuesta respuesta10c;
	Respuesta respuesta10d;
	ArrayList<Respuesta> respuestas10;
	Pregunta pregunta10;
	
	Respuesta respuesta11a;
	Respuesta respuesta11b;
	Respuesta respuesta11c;
	Respuesta respuesta11d;
	ArrayList<Respuesta> respuestas11;
	Pregunta pregunta11;
	
	Respuesta respuesta12a;
	Respuesta respuesta12b;
	Respuesta respuesta12c;
	Respuesta respuesta12d;
	ArrayList<Respuesta> respuestas12;
	Pregunta pregunta12;
	
	Respuesta respuesta13a;
	Respuesta respuesta13b;
	Respuesta respuesta13c;
	Respuesta respuesta13d;
	ArrayList<Respuesta> respuestas13;
	Pregunta pregunta13;
	
	Respuesta respuesta14a;
	Respuesta respuesta14b;
	Respuesta respuesta14c;
	Respuesta respuesta14d;
	ArrayList<Respuesta> respuestas14;
	Pregunta pregunta14;
	
	Respuesta respuesta15a;
	Respuesta respuesta15b;
	Respuesta respuesta15c;
	Respuesta respuesta15d;
	ArrayList<Respuesta> respuestas15;
	Pregunta pregunta15;
	
	Respuesta respuesta16a;
	Respuesta respuesta16b;
	Respuesta respuesta16c;
	Respuesta respuesta16d;
	ArrayList<Respuesta> respuestas16;
	Pregunta pregunta16;
	
	Respuesta respuesta17a;
	Respuesta respuesta17b;
	Respuesta respuesta17c;
	Respuesta respuesta17d;
	ArrayList<Respuesta> respuestas17;
	Pregunta pregunta17;
	
	Respuesta respuesta18a;
	Respuesta respuesta18b;
	Respuesta respuesta18c;
	Respuesta respuesta18d;
	ArrayList<Respuesta> respuestas18;
	Pregunta pregunta18;
	
	Respuesta respuesta19a;
	Respuesta respuesta19b;
	Respuesta respuesta19c;
	Respuesta respuesta19d;
	ArrayList<Respuesta> respuestas19;
	Pregunta pregunta19;
	
	Respuesta respuesta20a;
	Respuesta respuesta20b;
	Respuesta respuesta20c;
	Respuesta respuesta20d;
	ArrayList<Respuesta> respuestas20;
	Pregunta pregunta20;
	
	
	
	public void insertarPreguntas() {
		respuesta1a = new Respuesta("Sergio Ramos",false);
		respuesta1b = new Respuesta("Sergio Busquets",false);
		respuesta1c = new Respuesta("Andres Iniesta",true);
		respuesta1d = new Respuesta("David Villa",false);
		respuestas1 = new ArrayList<Respuesta>();
		respuestas1.add(respuesta1a);
		respuestas1.add(respuesta1b);
		respuestas1.add(respuesta1c);
		respuestas1.add(respuesta1d);
		pregunta1 = new Pregunta("¿Que jugador de fútbol metió el gol en la final del Mundial del 2010?",respuestas1);
		listaPreguntas.add(pregunta1);
		
		respuesta2a = new Respuesta("Hepatitis",true);
		respuesta2b = new Respuesta("Artrisis",false);
		respuesta2c = new Respuesta("Diabetes",false);
		respuesta2d = new Respuesta("Cifoescoliosis",false);
		respuestas2 = new ArrayList<Respuesta>();
		respuestas2.add(respuesta2a);
		respuestas2.add(respuesta2b);
		respuestas2.add(respuesta2c);
		respuestas2.add(respuesta2d);
		pregunta2 = new Pregunta("¿Cuál de las sisguientes enfermedades ataca al higado? ",respuestas2);
		listaPreguntas.add(pregunta2);
		
		respuesta3a = new Respuesta("Isaac Asimov",true);
		respuesta3b = new Respuesta("William Shakespeare",false);
		respuesta3c = new Respuesta("William Faulkner",false);
		respuesta3d = new Respuesta("Oscar Wilde",false);
		respuestas3 = new ArrayList<Respuesta>();
		respuestas3.add(respuesta3a);
		respuestas3.add(respuesta3b);
		respuestas3.add(respuesta3c);
		respuestas3.add(respuesta3d);
		pregunta3 = new Pregunta("¿Quién escribió Azazel? ",respuestas3);
		listaPreguntas.add(pregunta3);
		
		respuesta4a = new Respuesta("Estados Unidos", false);
		respuesta4b = new Respuesta("Australia",true);
		respuesta4c = new Respuesta("Rumanía",false);
		respuesta4d = new Respuesta("Ninguna es correcta",false);
		respuestas4 = new ArrayList<Respuesta>();
		respuestas4.add(respuesta4a);
		respuestas4.add(respuesta4b);
		respuestas4.add(respuesta4c);
		respuestas4.add(respuesta4d);
		pregunta4 = new Pregunta("¿A qué país pertenece Tasmania? ",respuestas4);
		listaPreguntas.add(pregunta4);
		
		respuesta5a = new Respuesta("Hallowen", false);
		respuesta5b = new Respuesta("El día de la reina",true);
		respuesta5c = new Respuesta("Navidad",false);
		respuesta5d = new Respuesta("La llegada del verano",false);
		respuestas5 = new ArrayList<Respuesta>();
		respuestas5.add(respuesta5a);
		respuestas5.add(respuesta5b);
		respuestas5.add(respuesta5c);
		respuestas5.add(respuesta5d);
		pregunta5 = new Pregunta("¿Cuál es la principal celebración holandesa? ",respuestas5);
		listaPreguntas.add(pregunta5);
		
		respuesta6a = new Respuesta("Mad Men", true);
		respuesta6b = new Respuesta("Juego de Tronos",false);
		respuesta6c = new Respuesta("Shameless",false);
		respuesta6d = new Respuesta("Vikings",false);
		respuestas6 = new ArrayList<Respuesta>();
		respuestas6.add(respuesta6a);
		respuestas6.add(respuesta6b);
		respuestas6.add(respuesta6c);
		respuestas6.add(respuesta6d);
		pregunta6 = new Pregunta("¿Qué premiada serie de televisión tiene como protagonista un publicista?",respuestas6);
		listaPreguntas.add(pregunta6);
		
		respuesta7a = new Respuesta("Jariyismo", false);
		respuesta7b = new Respuesta("Sunismo",true);
		respuesta7c = new Respuesta("Sufismo",false);
		respuesta7d = new Respuesta("Corán",false);
		respuestas7 = new ArrayList<Respuesta>();
		respuestas7.add(respuesta7a);
		respuestas7.add(respuesta7b);
		respuestas7.add(respuesta7c);
		respuestas7.add(respuesta7d);
		pregunta7 = new Pregunta("¿Cuál es la rama mayoritaria del Islam? ",respuestas7);
		listaPreguntas.add(pregunta7);
		
		respuesta8a = new Respuesta("Corinthians", true);
		respuesta8b = new Respuesta("Palmeiras",false);
		respuesta8c = new Respuesta("Cruzeiro",false);
		respuesta8d = new Respuesta("São Paulo",false);
		respuestas8 = new ArrayList<Respuesta>();
		respuestas8.add(respuesta8a);
		respuestas8.add(respuesta8b);
		respuestas8.add(respuesta8c);
		respuestas8.add(respuesta8d);
		pregunta8 = new Pregunta(" ¿Cuál es el clásico rival del flamengo? ",respuestas8);
		listaPreguntas.add(pregunta8);
		
		respuesta9a = new Respuesta("1952", false);
		respuesta9b = new Respuesta("1935",true);
		respuesta9c = new Respuesta("1970",false);
		respuesta9d = new Respuesta("1940",false);
		respuestas9 = new ArrayList<Respuesta>();
		respuestas9.add(respuesta9a);
		respuestas9.add(respuesta9b);
		respuestas9.add(respuesta9c);
		respuestas9.add(respuesta9d);
		pregunta9 = new Pregunta("¿En que año se estreno Pinocho en Disney? ",respuestas9);
		listaPreguntas.add(pregunta9);
		
		respuesta10a = new Respuesta("1920", false);
		respuesta10b = new Respuesta("1937",false);
		respuesta10c = new Respuesta("1942",false);
		respuesta10d = new Respuesta("1941",true);
		respuestas10 = new ArrayList<Respuesta>();
		respuestas10.add(respuesta10a);
		respuestas10.add(respuesta10b);
		respuestas10.add(respuesta10c);
		respuestas10.add(respuesta10d);
		pregunta10 = new Pregunta("¿En que año tuvo lugar el ataque a PearlHarbour?",respuestas10);
		listaPreguntas.add(pregunta10);
		

		respuesta11a = new Respuesta("una", false);
		respuesta11b = new Respuesta("ninguna",false);
		respuesta11c = new Respuesta("cuatro",true);
		respuesta11d = new Respuesta("ocho",false);
		respuestas11 = new ArrayList<Respuesta>();
		respuestas11.add(respuesta11a);
		respuestas11.add(respuesta11b);
		respuestas11.add(respuesta11c);
		respuestas11.add(respuesta11d);
		pregunta11 = new Pregunta("¿Cuántas finales del mundo jugó la Selección Argentina de fútbol?",respuestas11);
		listaPreguntas.add(pregunta11);
		

		respuesta12a = new Respuesta("Christian Vieri" , false);
		respuesta12b = new Respuesta("Zinedine Zidan",false);
		respuesta12c = new Respuesta("Luka Modric",false);
		respuesta12d = new Respuesta("Adrián Escudero",true);
		respuestas12 = new ArrayList<Respuesta>();
		respuestas12.add(respuesta12a);
		respuestas12.add(respuesta12b);
		respuestas12.add(respuesta12c);
		respuestas12.add(respuesta12d);
		pregunta12 = new Pregunta("¿Quién marcó el gol 3.500 en Liga del Atlético de Madrid?",respuestas12);
		listaPreguntas.add(pregunta12);
		
		respuesta13a = new Respuesta("Inhalada", false);
		respuesta13b = new Respuesta("Esnifada",false);
		respuesta13c = new Respuesta("Inyectada",false);
		respuesta13d = new Respuesta("Ingerida",true);
		respuestas13 = new ArrayList<Respuesta>();
		respuestas13.add(respuesta13a);
		respuestas13.add(respuesta13b);
		respuestas13.add(respuesta13c);
		respuestas13.add(respuesta13d);
		pregunta13 = new Pregunta("¿Cómo tomarías la sustancia alucinógena natural llamada ayahuasca?",respuestas13);
		listaPreguntas.add(pregunta13);
		
		respuesta14a = new Respuesta("Hígado" , true);
		respuesta14b = new Respuesta("Páncreas",false);
		respuesta14c = new Respuesta("Intestino delgado",false);
		respuesta14d = new Respuesta("Riñon",false);
		respuestas14 = new ArrayList<Respuesta>();
		respuestas14.add(respuesta14a);
		respuestas14.add(respuesta14b);
		respuestas14.add(respuesta14c);
		respuestas14.add(respuesta14d);
		pregunta14 = new Pregunta("¿Qué órgano del cuerpo humano produce la bilis?",respuestas14);
		listaPreguntas.add(pregunta14);
		
		respuesta15a = new Respuesta("roja", true);
		respuesta15b = new Respuesta("verde",false);
		respuesta15c = new Respuesta("azul",false);
		respuesta15d = new Respuesta("amarilla",false);
		respuestas15 = new ArrayList<Respuesta>();
		respuestas15.add(respuesta15a);
		respuestas15.add(respuesta15b);
		respuestas15.add(respuesta15c);
		respuestas15.add(respuesta15d);
		pregunta15 = new Pregunta("¿De qué color es la sange de los peces?",respuestas15);
		listaPreguntas.add(pregunta15);
		

		respuesta16a = new Respuesta("carbón", true);
		respuesta16b = new Respuesta("azúcar",false);
		respuesta16c = new Respuesta("azufre",false);
		respuesta16d = new Respuesta("fósforo",true);
		respuestas16 = new ArrayList<Respuesta>();
		respuestas16.add(respuesta16a);
		respuestas16.add(respuesta16b);
		respuestas16.add(respuesta16c);
		respuestas16.add(respuesta16d);
		pregunta16 = new Pregunta("¿De donde de saca la sacarina?",respuestas16);
		listaPreguntas.add(pregunta16);
		
		respuesta17a = new Respuesta("Ciencia-ficción", false);
		respuesta17b = new Respuesta("Negro",false);
		respuesta17c = new Respuesta("Romántico",false);
		respuesta17d = new Respuesta("Erótico",true);
		respuestas17 = new ArrayList<Respuesta>();
		respuestas17.add(respuesta17a);
		respuestas17.add(respuesta17b);
		respuestas17.add(respuesta17c);
		respuestas17.add(respuesta17d);
		pregunta17 = new Pregunta("¿A qué género pertenece la novela \"La historia del ojo\" de George Bataille?",respuestas17);
		listaPreguntas.add(pregunta17);
		
		respuesta18a = new Respuesta("Armenia" , false);
		respuesta18b = new Respuesta("Moldavia",false);
		respuesta18c = new Respuesta("Liechtenstein",true);
		respuesta18d = new Respuesta("Hungría",false);
		respuestas18 = new ArrayList<Respuesta>();
		respuestas18.add(respuesta18a);
		respuestas18.add(respuesta18b);
		respuestas18.add(respuesta18c);
		respuestas18.add(respuesta18d);
		pregunta18 = new Pregunta("¿Cuál es el país menos turístico de Europa?",respuestas18);
		listaPreguntas.add(pregunta18);
		
		respuesta19a = new Respuesta("Famosos", false);
		respuesta19b = new Respuesta("Farolas",false);
		respuesta19c = new Respuesta("Bebés",true);
		respuesta19d = new Respuesta("Palomas",false);
		respuestas19 = new ArrayList<Respuesta>();
		respuestas19.add(respuesta19a);
		respuestas19.add(respuesta19b);
		respuestas19.add(respuesta19c);
		respuestas19.add(respuesta19d);
		pregunta19 = new Pregunta("¿Qué fotografía, sobre todo, Anne Gedde?",respuestas19);
		listaPreguntas.add(pregunta12);
		
		respuesta20a = new Respuesta("Colombia", true);
		respuesta20b = new Respuesta("Venezuela",false);
		respuesta20c = new Respuesta("Costa Rica",false);
		respuesta20d = new Respuesta("Chile",false);
		respuestas20 = new ArrayList<Respuesta>();
		respuestas20.add(respuesta20a);
		respuestas20.add(respuesta20b);
		respuestas20.add(respuesta20c);
		respuestas20.add(respuesta20d);
		pregunta20 = new Pregunta("¿En qué país situarías la ciudad de Cali?",respuestas20);
		listaPreguntas.add(pregunta20);
		
		
		
	}
	
}
