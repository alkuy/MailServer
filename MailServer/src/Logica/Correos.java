package Logica;

import java.util.ArrayList;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Correos {
	
	private ArrayList<Correo> setCorreos;
	
	/** Método constructor de la colección Correos. */
	public Correos() {
		this.setCorreos = new ArrayList<Correo>();
	}
	
	/** Método que da de alta un correo al Set.
	 * <BR><b>Precondición</b>: el correo a dar de alta no es miembro del set.</BR>
	 * @param correo Correo a dar de alta en la colección.
	 * @return No retorna nada. */
	public void Insertar(Correo correo){
		this.setCorreos.add(correo);
	}
	
	/** Determina sí el set está vacío o no.
	 * @param setCorreos Colección de correos a verificar.
	 * @return <u>True</u>: si la colección es vacía.
	 * <BR><u>False</u>: si la colección <b>NO</b> es vacía.</BR> */
	public boolean EsVacio(Correos setCorreos){
		return setCorreos == null;
	}
	
	/** Método que determina si el correo forma parte del Set o no.
	 * @param correo Correo a verificar su existencia en la colección.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.<BR> */
	public boolean Pertenece(Correo correo){
		for(int i=0; i < setCorreos.size(); i++)
			if(setCorreos.get(i).equals(correo))
				return true;
		return false;
	}
	
	/** Método que da de baja al correo del Set.
	 * <BR><b>Precondición</b>: el correo especificado pertenece al Set.</BR>
	 * @param correo Correo a verificar su existencia en la colección.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public void Borrar(Correo correo){
		this.setCorreos.remove(correo);
	}
	
	/** Método que retorna la coleccion Set de Correos.
	 * <BR><b>Precondición</b>: la colección no debe ser vacía.</BR>
	 * @return Retorna el set de Correos. */
	public ArrayList<Correo> getSetCorreos() {
		return setCorreos;
	}
	
}
