package datos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import main.Main;


public class Jugador{
	
	private float x;
	private float y;
	private Rectangle rect;
	private Color c;
	private String[] posiciones;
	
	public Jugador(int x, int y, Color c) {
		
		this.c = c;
		this.x = x;
		this.y = y;
		
        rect = new Rectangle(x, y, 30, 30);
        posiciones = new String[11];
        
        rellenarPosiciones();
    
    }
	
	public void rellenarPosiciones() {
		Main.getProperties();
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
     
	public void paint(Graphics g) {
	     g.setColor(c);
	     g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
	       
}
