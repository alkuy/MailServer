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
				JOptionPane.showMessageDialog(campo, "Caracteres máximos: "+max , null, JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if(texto.length() < min){
				campo.setBorder(bordeROJO);
				JOptionPane.showMessageDialog(campo, "El campo requiere al menos: "+min+" caracteres" , null, JOptionPane.ERROR_MESSAGE);
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
			  JOptionPane.showMessageDialog(campo, "Debe ingresar valores numericos", null, JOptionPane.ERROR_MESSAGE);
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
		  JOptionPane.showMessageDialog(campo, "Debe ingresar caracteres validos. Solo minusculas y números", null, JOptionPane.ERROR_MESSAGE);
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
			 JOptionPane.showMessageDialog(null, "El documento ingresado no existe en la base de Datos. Por favor ingreselo previamente", null, JOptionPane.INFORMATION_MESSAGE);
			 return false;
		 }else{
			 return true;
		 }
  }
  
  /**
   * Metodo que se fija si es correcto el digito verificador de la cedula ingresada
   * @param cedula
   * @return True si el digito es correcto
   */
  public boolean verificaCedula(JComponent campo){
	  String cedula = ((JTextField)campo).getText();
	  
		Border bordeROJO = BorderFactory.createLineBorder(Color.RED, 2);
		Border bordeCOMUN = BorderFactory.createLineBorder(Color.BLACK, 1);
	  
	  int tot=cedula.length()-1; // Cantidad de numeros de la cedula. Menos 1 porque el array comienza 
	  int [] documento = {0,0,0,0,0,0,0,0}; //Array para guardar los numeros por separado
	  int [] verificadores = {4,3,6,7,8,9,2}; // Array que va a contener los verificadores
	  int [] res = new int[tot]; // Para ir guardando resultados de la primera operacion
	  int resultadoTot = 0; // Guarda la suma de todos los primeros resultados
	  int DigitoVerificador = Character.getNumericValue(cedula.charAt(tot)); 
	  int resultadoFinal = 0; // El que deria ser el digito verificador
	  
	  /*Cargo la matriz al reves. Esto lo hago por que si es una cedula que no llega al millon
	   * tengo que hacer multiplicar un numero menos y un numero de la matriz no se utiliza*/
	  int j=0;
	  int i=tot-1;
	  while (i>=0){
		documento[i]=Character.getNumericValue(cedula.charAt(j));  /*Separlo los numeros para poder operar*/
		j++;
		i--;
	  }
	  
	  
	  i=0;
	  while (i<tot){ // Voy hasta el penultimo, ya que el ultimo deberia ser el verificador
		  int resultado = 0;
		  resultado = documento[i] * verificadores[i]; /*Opero con los numeros preestablecido*/
		  /*Me quedo con la unidad*/
		  if (resultado >= 10){res[i] = resultado%10;}
		  if (resultado < 10){res[i] = resultado;}
		  /*Sumo todas las unidades que me quedan*/
		  resultadoTot = resultadoTot + res[i];
		  
		  
		  i++;
	  }
	  
	  
	  resultadoFinal = 10 - resultadoTot%10;
	  if (resultadoFinal == 10){resultadoFinal = 0;} // Para las cedulas que tiene como digito verificador 0
	  if (resultadoFinal == DigitoVerificador){
		  campo.setBorder(bordeCOMUN);
		  return true;
	  }else{
		  JOptionPane.showMessageDialog(null, "El número de documento no es correcto", null, JOptionPane.ERROR_MESSAGE);
		  campo.setBorder(bordeROJO);
		  return false;
	  }
  }
  
  /**
   * Comprueba que el mismo dominio no exista ya
   * @param Dominio
   * @return
   */
  public boolean existe_dominio(String Dominio){
	  int pri=FCLogica.pri_Dom(Dominio);
	  if (pri == 0){
		  return false;//Si no tiene prioridad en la ase de datos no existe
	  }else{
		  JOptionPane.showMessageDialog(null, "El dominio ya existe", null, JOptionPane.ERROR_MESSAGE);
		  return true;
	  }
  }
  
}  
