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
import Logica.Usuario;

public class Verificaciones {
	public Verificaciones(){
		
	}
	
	private Fachada FCLogica = Fachada.getInstancia();
	
	/**
	 * Intercambia carcteres que pueden ocasionar problemas en base de datos
	 * @param cadena
	 * @return cadena 
	 */
	public String remplazoCaracteres(String cadena){
		cadena = cadena.replace("'", "''");
		return cadena;
	}

  // metodo que se llama desde principal para que desde aca se conecte con la fachada de la capa logica para hacr la verificacion de usuario y contraseña de administrador
  /**
   * Metodo verifica ingreso a programa
   * @param cedula
   * @param passwd
   * @return true si es correcto el user y admin
   */
	public boolean verifica_admin(String cedula, String passwd) {  
	 try { 		 
		
	 if (FCLogica.verifica_ingreso(cedula, passwd)){
		 
		  return true;
		  
	  } else {
		  	
		       return false; 	  
	         }
  } catch (Exception e){ return false;}
	 
  }
  
/*VERIFICADORES GENERALES NO APLICADOS AUN*/  

/**
 * Verificador de solo minusculas  
 * @param cadena
 * @return True si son solo minusculas
 */
  public boolean solo_minusculas(String cadena){
	  if (cadena.matches("[a-z]+")){
		  return true;
	  }
	  return false;
  }
  /**
   * Verificador de maximo de caracteres aceptado
   * @param campo
   * @param max
   * @return true si es menos campo es menor que la cantida de caracteres aceptado
   */
  
  public boolean cant_caracteres(JComponent campo, int max, int min){
	  	Border bordeROJO = BorderFactory.createLineBorder(Color.RED, 2);
		Border bordeCOMUN = BorderFactory.createLineBorder(Color.BLACK, 1);
		String texto = ((JTextField)campo).getText();
			if(texto.length() > max){
				campo.setBorder(bordeROJO);
				JOptionPane.showMessageDialog(campo, "Caracteres máximos: "+max);
				return false;
			}
			if(texto.length() < min){
				campo.setBorder(bordeROJO);
				JOptionPane.showMessageDialog(campo, "El campo requiere al menos: "+min+" caracteres");
				return false;	
			}
		campo.setBorder(bordeCOMUN);
		return true;
		}
  
  /**
   * Verifica si es numerico el valor ingresado	
   * @param campo
   * @return true si es numero
   */
  public boolean numerico(JComponent campo){
	  Border bordeROJO = BorderFactory.createLineBorder(Color.RED, 2);
		Border bordeCOMUN = BorderFactory.createLineBorder(Color.BLACK, 1);
	  String texto = ((JTextField)campo).getText();
	  if (texto.length() > 0){
		  try {
			  Long.parseLong(texto); //No funciona
			  campo.setBorder(bordeCOMUN);
			  return true;
		  }catch (NumberFormatException nfe){
			  campo.setBorder(bordeROJO);
			  JOptionPane.showMessageDialog(campo, "Debe ingresar valores numericos");
			  return false;
		  }
	  }
	  return true;
  }
  
  /**
   * Verifica que los caracteres ingresados sean letras minusculas o numeros
   * @param campo
   * @return True si son correctos los caracteres
   */
  public boolean caracteres_validos(JComponent campo){
	Border bordeROJO = BorderFactory.createLineBorder(Color.RED, 2);
	Border bordeCOMUN = BorderFactory.createLineBorder(Color.BLACK, 1);
	  String texto = ((JTextField)campo).getText();
	  if (texto.matches("[a-z0-9]+")){
		  campo.setBorder(bordeCOMUN);
		  return true;
	  }else{
		  JOptionPane.showMessageDialog(campo, "Debe ingresar caracteres validos. Solo minusculas y números");
		  campo.setBorder(bordeROJO);
		  return false;
	  }
  }
  /**
   * Verifica que exista un usuario con esa cedula en el sistema
   * @param cedula
   * @return boolean
   */
  public boolean existe_cedula(String cedula){
	  	int id;
	  	id = FCLogica.trae_id(cedula);
		 if (id==0){
			 JOptionPane.showMessageDialog(null, "El documento ingresado no existe en la base de Datos. Por favor ingreselo previamente");
			 return false;
		 }else{
			 return true;
		 }
  }
  
  
  
  
}  
