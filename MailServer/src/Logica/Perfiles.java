package Logica;

import java.util.ArrayList;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Perfiles {
	
	private ArrayList<Perfil> setPerfiles;
	
	/** M�todo constructor de la colecci�n Perfiles. */
	public Perfiles() {
		this.setPerfiles = new ArrayList<Perfil>();
	}
	
	/** M�todo que da de alta un perfil al set.
	 * <BR><b>Precondici�n</b>: el perfil a dar de alta no es miembro del set.</BR>
	 * @param perfil Perfil a dar de alta en la colecci�n.
	 * @return No retorna nada. */
	public void Insertar(Perfil perfil){
		this.setPerfiles.add(perfil);
	}
	
	/** Determina s� el set est� vac�o o no.
	 * @param setPerfiles Colecci�n de perfiles a verificar.
	 * @return <u>True</u>: si la colecci�n es vac�a.
	 * <BR><u>False</u>: si la colecci�n <b>NO</b> es vac�a.</BR> */
	public boolean EsVacio(Perfiles setPerfiles){
		return setPerfiles == null;
	}
	
	/** M�todo que determina si el perfil forma parte del set o no.
	 * @param perfil Perfil a verificar su existencia en la colecci�n.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public boolean Pertenece(Perfil perfil){
		for(int i=0; i < setPerfiles.size(); i++)
			if(setPerfiles.get(i).equals(perfil))
				return true;
		return false;
	}
	
	/** M�todo que da de baja al perfil del Set.
	 * <BR><b>Precondici�n</b>: el perfil especificado pertenece al Set.</BR>
	 * @param perfil Perfil a verificar su existencia en la colecci�n.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public void Borrar(Perfil perfil){
		this.setPerfiles.remove(perfil);
	}
	
	/** M�todo que retorna la coleccion Set de Perfiles.
	 * <BR><b>Precondici�n</b>: la colecci�n no debe ser vac�a.</BR>
	 * @return Retorna el set de Perfiles. */
	public ArrayList<Perfil> getsetPerfiles() {
		return setPerfiles;
	}

}
