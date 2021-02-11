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


public class Jugador{
	
	private float x;
	private float y;
	private Rectangle rect;
	private Color c;
	private String[] posiciones;
	private int codigo, n = 0;
	private Properties properties1, properties2, properties3, properties4;
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
     
	public void paint(Graphics g) {
	     g.setColor(c);
	     g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
	
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
	
	public void incrementarPosicion() {
		n++;

		actualizarPosiciones();
		
	}
	
	public void actualizarPosiciones() {
		
		int c = 0;
		
		stk = new StringTokenizer(getPosicion(),";");
		
		System.out.println(getPosicion());
		
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
	       
}
