package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Logica.Fachada;
import Persistencia.FachadaBD;

public class Ventanas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Presentacion present = new Presentacion();
		present.setLocationRelativeTo(null);  
		present.setVisible(true);
		principal pri = new principal();
		ActionListener realiza = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			present.dispose();
			pri.setLocationRelativeTo(null); 
			pri.setVisible(true);
			}
		};
			  
		Timer cierre = new Timer(3000, realiza);
		cierre.start();
		
		Fachada Logica = Fachada.getInstancia();
	}

}
