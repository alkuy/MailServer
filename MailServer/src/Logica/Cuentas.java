package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Persistencia.FachadaBD;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Cuentas {
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	private ArrayList<Cuenta> setCuentas;
	
	/** M�todo constructor de la colecci�n Cuentas. */
	public Cuentas() {
		this.setCuentas = new ArrayList<Cuenta>();
	}
	
	/** M�todo que da de alta un cuenta al set.
	 * <BR><b>Precondici�n</b>: la cuenta a dar de alta no es miembro del set.</BR>
	 * @param cuenta Cuenta a dar de alta en la colecci�n.
	 * @return No retorna nada. */
	public void Insertar(Cuenta cuenta){
		this.setCuentas.add(cuenta);
	}
	
	/** Determina s� el set est� vac�o o no.
	 * @param setCuentas Colecci�n de cuentas a verificar.
	 * @return <u>True</u>: si la colecci�n es vac�a.
	 * <BR><u>False</u>: si la colecci�n <b>NO</b> es vac�a.</BR> */
	public boolean EsVacio(Cuentas setCuentas){
		return setCuentas == null;
	}
	
	/** M�todo que determina si la cuenta forma parte del set o no.
	 * @param cuenta Cuenta a verificar su existencia en la colecci�n.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public boolean Pertenece(Cuenta cuenta){
		for(int i=0; i < setCuentas.size(); i++)
			if(setCuentas.get(i).equals(cuenta))
				return true;
		return false;
	}
	
	/** M�todo que da de baja a la cuenta del Set.
	 * <BR><b>Precondici�n</b>: la cuenta especificada pertenece al Set.</BR>
	 * @param cuenta Cuenta a verificar su existencia en la colecci�n.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public void Borrar(Cuenta cuenta){
		this.setCuentas.remove(cuenta);
	}
	
	/** M�todo que retorna la coleccion Set de Cuentas.
	 * <BR><b>Precondici�n</b>: la colecci�n no debe ser vac�a.</BR>
	 * @return Retorna el set de Cuentas. */
	public ArrayList<Cuenta> getsetCuentas(){
		return setCuentas;
	}
	
	/**
	 * Metodo que carga cuentas desde la base en arrayList
	 * @return ArrayList con cuentas
	 */
	public ArrayList<Cuenta> cargaCuentasdesdeBD(){
		Cuenta c = new Cuenta();
		ResultSet rs = null;
		try {
			rs = BD.ConTablaCuenta();
			String nom_u = rs.getString("nom_usuario");
			String nom_d = rs.getString("nom_dominio");
			c.setNomU(nom_u);
			c.setDominio(nom_d);
			this.setCuentas.add(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return setCuentas;
		
	}

}
