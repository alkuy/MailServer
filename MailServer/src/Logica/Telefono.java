package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;

import Persistencia.FachadaBD;

/** Clase para el teléfono de un usuario.
 * @author 
 */
public class Telefono {
	
	private String numTel;
	private int id;

	FachadaBD BD = FachadaBD.getInstancia();
	
	/** Método constructor de la clase.
	 */
	public Telefono(){
	}
	
	/** Método constructor de la clase.
	 * @param idUsu ID de usuario.
	 * @param numTel número telefónico.
	 */
	public Telefono(int idUsu, String numTel) {
		this.numTel = numTel;
		this.id = idUsu;
		//BD.InsertTel(idUsu, numTel);
	}
		
	/** Método que retorna el ID de usuario asociado al número telefónico
	 * @return id ID de usuario.
	 */
	public int getId() {
		return id;
	}

	/** Método que modifica el ID de usuario asociado al número telefónico
	 * @param id ID de usuario.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/** Método que retorna el número telefónico de un usuario.
	 * @return id ID de usuario.
	 */
	public String getNumTel() {
		return numTel;
	}
	
	/** Método que modifica el número telefónico de un usuario.
	 * @param numTel número telefónico de usuario.
	 */
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	/** Método que da de alta el teléfono de un usuario en la base de datos.
	 * @param idUsu
	 * @param numTel
	 */
	public void InsertTel(int idUsu, String numTel){
		if (!numTel.equals("")){
			BD.InsertTel(idUsu, numTel);
		}
	}
}
