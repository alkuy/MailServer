package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import Persistencia.FachadaBD;

/** Clase para la colecci�n de tel�fonos del usuario.
 * @author 
 */
public class Telefonos {
	
	private ArrayList<Telefono> setTelefonos;
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	/** M�todo constructor de la clase.
	 */
	public Telefonos() {
		this.setTelefonos = new ArrayList<>();
	}
	
	/** M�todo que carga la colecci�n de tel�fonos del usuario con ID especificado en memoria.
	 * @param id
	 * @throws SQLException
	 */
	public Telefonos(int id) throws SQLException{
		this.setTelefonos = cargaDesdeBD(id);
	}
	
	/** M�todo que inserta el tel�fono especificado en la colecci�n de tel�fonos.
	 * @param tel
	 */
	public void Insertar (Telefono tel){
		this.setTelefonos.add(tel);
	}
	
	/** M�todo que modifica los tel�fonos del usuario.
	 * @param id_usuario
	 * @param oldTel tel�fono anterior
	 * @param newTel tel�fono nuevo
	 * @param tel1o2 primer o segundo tel�fono.
	 */
	public void Modificar(int id_usuario, String oldTel, String newTel, int tel1o2){
		this.setTelefonos.get(tel1o2).setNumTel(newTel);
		BD.Modifica_tel(id_usuario, oldTel, newTel);
	}
	
	/** M�todo que carga la colecci�n de tel�fonos del usuario en memoria.
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
	
	/** M�todo que retorna la colecci�n de tel�fonos.
	 * @return ArrayList tel�fonos
	 */
	public ArrayList<Telefono> getSetTelefonos() {
		return setTelefonos;
	}
	
	/** M�todo que retorna el n�mero telef�nico del tel�fono especificado (primero o segundo)
	 * @param tels colecci�n de tel�fonos. 
	 * @param x 1 primero, 2 segundo.
	 * @return n�mero telef�nico (String)
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
