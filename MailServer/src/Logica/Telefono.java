package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;

import Persistencia.FachadaBD;

/** Clase para el tel�fono de un usuario.
 * @author 
 */
public class Telefono {
	
	private String numTel;
	private int id;

	FachadaBD BD = FachadaBD.getInstancia();
	
	/** M�todo constructor de la clase.
	 */
	public Telefono(){
	}
	
	/** M�todo constructor de la clase.
	 * @param idUsu ID de usuario.
	 * @param numTel n�mero telef�nico.
	 */
	public Telefono(int idUsu, String numTel) {
		this.numTel = numTel;
		this.id = idUsu;
		//BD.InsertTel(idUsu, numTel);
	}
		
	/** M�todo que retorna el ID de usuario asociado al n�mero telef�nico
	 * @return id ID de usuario.
	 */
	public int getId() {
		return id;
	}

	/** M�todo que modifica el ID de usuario asociado al n�mero telef�nico
	 * @param id ID de usuario.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/** M�todo que retorna el n�mero telef�nico de un usuario.
	 * @return id ID de usuario.
	 */
	public String getNumTel() {
		return numTel;
	}
	
	/** M�todo que modifica el n�mero telef�nico de un usuario.
	 * @param numTel n�mero telef�nico de usuario.
	 */
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	/** M�todo que da de alta el tel�fono de un usuario en la base de datos.
	 * @param idUsu
	 * @param numTel
	 */
	public void InsertTel(int idUsu, String numTel){
		if (!numTel.equals("")){
			BD.InsertTel(idUsu, numTel);
		}
	}
}
