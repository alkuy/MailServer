package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import Persistencia.FachadaBD;

/** Clase para la colección de teléfonos del usuario.
 * @author 
 */
public class Telefonos {
	
	private ArrayList<Telefono> setTelefonos;
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	/** Método constructor de la clase.
	 */
	public Telefonos() {
		this.setTelefonos = new ArrayList<>();
	}
	
	/** Método que carga la colección de teléfonos del usuario con ID especificado en memoria.
	 * @param id
	 * @throws SQLException
	 */
	public Telefonos(int id) throws SQLException{
		this.setTelefonos = cargaDesdeBD(id);
	}
	
	/** Método que inserta el teléfono especificado en la colección de teléfonos.
	 * @param tel
	 */
	public void Insertar (Telefono tel){
		this.setTelefonos.add(tel);
	}
	
	/** Método que modifica los teléfonos del usuario.
	 * @param id_usuario
	 * @param oldTel teléfono anterior
	 * @param newTel teléfono nuevo
	 * @param tel1o2 primer o segundo teléfono.
	 */
	public void Modificar(int id_usuario, String oldTel, String newTel, int tel1o2){
		this.setTelefonos.get(tel1o2).setNumTel(newTel);
		BD.Modifica_tel(id_usuario, oldTel, newTel);
	}
	
	/** Método que carga la colección de teléfonos del usuario en memoria.
	 * @param idUsu
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Telefono> cargaDesdeBD(int idUsu) throws SQLException{
		ArrayList<Telefono> auxTels = new ArrayList<Telefono>();
		ResultSet rs = BD.ConFilaTel(idUsu);
		
		while(rs.next()){
			Telefono tel = new Telefono(idUsu, rs.getString("telefono"));
			auxTels.add(tel);
		}
		return auxTels;
	}
	
	/** Método que retorna la colección de teléfonos.
	 * @return ArrayList teléfonos
	 */
	public ArrayList<Telefono> getSetTelefonos() {
		return setTelefonos;
	}
	
	/** Método que retorna el número telefónico del teléfono especificado (primero o segundo)
	 * @param tels colección de teléfonos. 
	 * @param x 1 primero, 2 segundo.
	 * @return número telefónico (String)
	 */
	public String retornarTelx(ArrayList<Telefono> tels, int x){
		int cont=0;
		Iterator<Telefono> iteTels = tels.iterator();
		while(iteTels.hasNext()){
			Telefono auxTel = iteTels.next();
			if(cont==x)
				return auxTel.getNumTel();
			cont++;
		}
		return "";
	}
}
