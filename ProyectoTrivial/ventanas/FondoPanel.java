package ventanas;

import java.awt.*;
import javax.swing.*;

/*
 * Clase para poner imagenes de fondo en las ventanas
 */
public class FondoPanel extends JPanel{

	private Image imagen;
	
	@Override
	public void paint(Graphics g){
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
	public void setImagen(String i){
		imagen = new ImageIcon(getClass().getResource(i)).getImage();
	}
}
