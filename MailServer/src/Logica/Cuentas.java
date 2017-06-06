package Logica;

import java.util.ArrayList;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Cuentas {
	
	private ArrayList<Cuenta> setCuentas;
	
	/** Método constructor de la colección Cuentas. */
	public Cuentas() {
		this.setCuentas = new ArrayList<Cuenta>();
	}
	
	/** Método que da de alta un cuenta al set.
	 * <BR><b>Precondición</b>: la cuenta a dar de alta no es miembro del set.</BR>
	 * @param cuenta Cuenta a dar de alta en la colección.
	 * @return No retorna nada. */
	public void Insertar(Cuenta cuenta){
		this.setCuentas.add(cuenta);
	}
	
	/** Determina sí el set está vacío o no.
	 * @param setCuentas Colección de cuentas a verificar.
	 * @return <u>True</u>: si la colección es vacía.
	 * <BR><u>False</u>: si la colección <b>NO</b> es vacía.</BR> */
	public boolean EsVacio(Cuentas setCuentas){
		return setCuentas == null;
	}
	
	/** Método que determina si la cuenta forma parte del set o no.
	 * @param cuenta Cuenta a verificar su existencia en la colección.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public boolean Pertenece(Cuenta cuenta){
		for(int i=0; i < setCuentas.size(); i++)
			if(setCuentas.get(i).equals(cuenta))
				return true;
		return false;
	}
	
	/** Método que da de baja a la cuenta del Set.
	 * <BR><b>Precondición</b>: la cuenta especificada pertenece al Set.</BR>
	 * @param cuenta Cuenta a verificar su existencia en la colección.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public void Borrar(Cuenta cuenta){
		this.setCuentas.remove(cuenta);
	}
	
	/** Método que retorna la coleccion Set de Cuentas.
	 * <BR><b>Precondición</b>: la colección no debe ser vacía.</BR>
	 * @return Retorna el set de Cuentas. */
	public ArrayList<Cuenta> getsetCuentas() {
		return setCuentas;
	}

}
