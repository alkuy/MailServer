package Logica;

import java.util.ArrayList;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Correos {
	
	private ArrayList<Correo> setCorreos;
	
	/** M�todo constructor de la colecci�n Correos. */
	public Correos() {
		this.setCorreos = new ArrayList<Correo>();
	}
	
	/** M�todo que da de alta un correo al Set.
	 * <BR><b>Precondici�n</b>: el correo a dar de alta no es miembro del set.</BR>
	 * @param correo Correo a dar de alta en la colecci�n.
	 * @return No retorna nada. */
	public void Insertar(Correo correo){
		this.setCorreos.add(correo);
	}
	
	/** Determina s� el set est� vac�o o no.
	 * @param setCorreos Colecci�n de correos a verificar.
	 * @return <u>True</u>: si la colecci�n es vac�a.
	 * <BR><u>False</u>: si la colecci�n <b>NO</b> es vac�a.</BR> */
	public boolean EsVacio(Correos setCorreos){
		return setCorreos == null;
	}
	
	/** M�todo que determina si el correo forma parte del Set o no.
	 * @param correo Correo a verificar su existencia en la colecci�n.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.<BR> */
	public boolean Pertenece(Correo correo){
		for(int i=0; i < setCorreos.size(); i++)
			if(setCorreos.get(i).equals(correo))
				return true;
		return false;
	}
	
	/** M�todo que da de baja al correo del Set.
	 * <BR><b>Precondici�n</b>: el correo especificado pertenece al Set.</BR>
	 * @param correo Correo a verificar su existencia en la colecci�n.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public void Borrar(Correo correo){
		this.setCorreos.remove(correo);
	}
	
	/** M�todo que retorna la coleccion Set de Correos.
	 * <BR><b>Precondici�n</b>: la colecci�n no debe ser vac�a.</BR>
	 * @return Retorna el set de Correos. */
	public ArrayList<Correo> getSetCorreos() {
		return setCorreos;
	}
	
}
