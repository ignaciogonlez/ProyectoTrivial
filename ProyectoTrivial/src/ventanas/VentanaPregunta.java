package ventanas;

import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;

import datos.Jugador;

public class VentanaPregunta extends JFrame{
	
	  Integer[] options = {2, 3, 5, 7};
      int n = (Integer)JOptionPane.showInputDialog(null, "this is a number that is not prime:", 
              "Prime numbers", JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
      //System.out.println(n);
}
