package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Logica.Fachada;
import Persistencia.FachadaBD;

public class Ventanas {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Presentacion present = new Presentacion();
		present.setLocationRelativeTo(null);  
		present.setVisible(true);
		
		Thread.sleep (5000);  // Excelente solución de Castelli
		principal pri = new principal();
		present.dispose();
			
		pri.setLocationRelativeTo(null); 
			
		pri.setVisible(true);
	
	}

}
