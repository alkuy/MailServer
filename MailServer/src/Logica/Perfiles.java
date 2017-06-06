package Logica;

import java.util.ArrayList;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Perfiles {
	
	private ArrayList<Perfil> setPerfiles;
	
	/** Método constructor de la colección Perfiles. */
	public Perfiles() {
		this.setPerfiles = new ArrayList<Perfil>();
	}
	
	/** Método que da de alta un perfil al set.
	 * <BR><b>Precondición</b>: el perfil a dar de alta no es miembro del set.</BR>
	 * @param perfil Perfil a dar de alta en la colección.
	 * @return No retorna nada. */
	public void Insertar(Perfil perfil){
		this.setPerfiles.add(perfil);
	}
	
	/** Determina sí el set está vacío o no.
	 * @param setPerfiles Colección de perfiles a verificar.
	 * @return <u>True</u>: si la colección es vacía.
	 * <BR><u>False</u>: si la colección <b>NO</b> es vacía.</BR> */
	public boolean EsVacio(Perfiles setPerfiles){
		return setPerfiles == null;
	}
	
	/** Método que determina si el perfil forma parte del set o no.
	 * @param perfil Perfil a verificar su existencia en la colección.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public boolean Pertenece(Perfil perfil){
		for(int i=0; i < setPerfiles.size(); i++)
			if(setPerfiles.get(i).equals(perfil))
				return true;
		return false;
	}
	
	/** Método que da de baja al perfil del Set.
	 * <BR><b>Precondición</b>: el perfil especificado pertenece al Set.</BR>
	 * @param perfil Perfil a verificar su existencia en la colección.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public void Borrar(Perfil perfil){
		this.setPerfiles.remove(perfil);
	}
	
	/** Método que retorna la coleccion Set de Perfiles.
	 * <BR><b>Precondición</b>: la colección no debe ser vacía.</BR>
	 * @return Retorna el set de Perfiles. */
	public ArrayList<Perfil> getsetPerfiles() {
		return setPerfiles;
	}

}
