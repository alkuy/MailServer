package grafica;
import java.awt.Color;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Logica.Fachada;

public class Verificaciones {
	public Verificaciones(){
		
	}
	
	
	private Fachada FCLogica = Fachada.getInstancia();
	/**
	 * Varifica documento ingresado
	 * @param campo
	 * @return
	 */
	public boolean documento(JComponent campo) {
        // suponemos que JComponent será un JTextField
			if (campo instanceof JTextField){
				String texto = ((JTextField)campo).getText();
				try
					{
                    // Si se puede convertir en entero, está bien
					Integer.parseInt(texto);
					if(texto.length() > 8 || texto.length() < 6){
						JOptionPane.showMessageDialog(campo, "Ingreso mal el documento");
						return false;
					}else{
						return true;
					}	
				}catch (Exception e)
					{
					JOptionPane.showMessageDialog(campo, "Ingreso mal el documento");
					return false;
					}
			}

			return true;

	}
	
	public boolean campo_vacio(JComponent campo){
		Border bordeROJO = BorderFactory.createLineBorder(Color.RED, 2);
		Border bordeCOMUN = BorderFactory.createLineBorder(Color.BLACK, 1);
		if (campo instanceof JTextField){
			String texto = ((JTextField)campo).getText();
			if(texto.isEmpty()){
				//JOptionPane.showMessageDialog(campo, "Debe ingresar datos");
				campo.setBorder(bordeROJO);
				return false;
			}else{
				campo.setBorder(bordeCOMUN);
				return true;
			}
		
		}
		return false;
	}
	
	/*public boolean telefonos(JComponent campo){
		if (campo instanceof JTextField){
				String texto = ((JTextField)campo).getText();
				try
					{
                    // Si se puede convertir en entero, está bien
					Integer.parseInt(texto);
					if(texto.length() > 10 || texto.length() < 8){
						JOptionPane.showMessageDialog(campo, "Ingreso mal el teléfono");
						return false;
					}else{
						return true;
					}	
				}catch (Exception e)
					{
					JOptionPane.showMessageDialog(campo, "Ingreso mal el teléfono");
					return false;
					}

}*/
	
	public String remplazoCaracteres(String cadena){
		cadena = cadena.replace("'", "''");
		return cadena;
	}



  // metodo que se llama desde principal para que desde aca se conecte con la fachada de la capa logica para hacr la verificacion de usuario y contraseña de administrador
  public boolean verifica_admin(String cedula, String passwd) {
	  
	  
	 try { 		 
		
	 if (FCLogica.verifica_ingreso(cedula, passwd)){
		 
		  return true;
		  
	  } else {
		  	
		       return false; 	  
	         }
  } catch (Exception e){ return false;}
	 
  }  	 
  
}
