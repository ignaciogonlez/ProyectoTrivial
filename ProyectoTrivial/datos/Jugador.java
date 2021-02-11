package datos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import main.Main;

/**Clase jugador donde se construyen los jugadores y se les asigna una serie de posiciones 
 * que deben ir tomando según el fichero properties
 * @author luissuarezcuartas
 */

public class Jugador{
	
	private float x;
	private float y;
	private Rectangle rect;
	private Color c;
	private String[] posiciones;
	private int codigo, n = 0;	//codigo de jugador (1 2 3 o 4)
	private Properties properties1, properties2, properties3, properties4;   //ficheros donde se guardan las posiciones de cada jugador a lo largo del mapa
	private StringTokenizer stk;
	
	public Jugador(int x, int y, Color c, int codigo) {
		
		this.c = c;
		this.x = x;
		this.y = y;
		this.codigo = codigo;
		
        rect = new Rectangle(x, y, 30, 30);
        posiciones = new String[11];
        
        properties1 = Main.getProperties1();
        properties2 = Main.getProperties2();
        properties3 = Main.getProperties3();
        properties4 = Main.getProperties4();
        
        rellenarPosiciones(codigo, 0);
    }
	
	public float getx() {
    	return x;
    }
    
    public void setx(float x) {
    	this.x = x;
    }
    
    public float gety() {
    	return y;
    }
    
    public void sety(float y) {
    	this.y = y;
    }
     /**
      * Metodo para pintar los jugadores sobre el mapa
      * @param g (Clase Graphics)
      */
	public void paint(Graphics g) {
	     g.setColor(c);
	     g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	
	/**Metodo recursivo para ir rellenando las posiciones pasándolas del fichero properties
	 * @param codigo
	 * @param index
	 */
	public void rellenarPosiciones(int codigo, int index) {
		
		if(index < 11) {
			
			if(codigo == 1) {
				posiciones[index] = properties1.getProperty(Integer.toString(index+1));
				rellenarPosiciones(1, ++index);
						
			}else if(codigo == 2) {
				posiciones[index] = properties2.getProperty(Integer.toString(index+1));
				rellenarPosiciones(2, ++index);
				
			}else if(codigo == 3) {
				posiciones[index] = properties3.getProperty(Integer.toString(index+1));
				rellenarPosiciones(3, ++index);
				
			}else {
				posiciones[index] = properties4.getProperty(Integer.toString(index+1));
				rellenarPosiciones(4, ++index);
				
			}
		}
	}
	
	public String getPosicion(){
		return posiciones[n];
	}
	
	/**
	 * Metodo para ir incrementando la posición del jugador cada vez que avanza
	 */
	public void incrementarPosicion() {
		n++;

		actualizarPosiciones();
		
	}
	
	/**
	 * Actualiza la posición del jugador
	 */
	public void actualizarPosiciones() {
		
		int c = 0;
		
		stk = new StringTokenizer(getPosicion(),";");
		
		
		while(stk.hasMoreTokens()) {
		
			if(c == 0) {
				
				String token = stk.nextToken();

				x = Float.parseFloat(token);
				rect.x = Integer.parseInt(token);
				
				
			}else {
				
				String token = stk.nextToken();

				y = Float.parseFloat(token);
				rect.y = Integer.parseInt(token);
				
			}
			
			c++;
		}
	}
	
	public int getN() {
		return n;
	}
	
	public void setN(int newN){
		n = newN;
	}
	       
}
