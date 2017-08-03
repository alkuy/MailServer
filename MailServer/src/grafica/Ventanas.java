package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

import Logica.Fachada;
import Persistencia.FachadaBD;


public class Ventanas {

	public static void main(String[] args) throws InterruptedException, SQLException {
		
		try{
			  
			  JFrame.setDefaultLookAndFeelDecorated(true);
			  JDialog.setDefaultLookAndFeelDecorated(true);
			  UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			 // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // el que mas me gusto
			 // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			 
			}
			catch (Exception e)
			 {
			  e.printStackTrace();
			 }
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
