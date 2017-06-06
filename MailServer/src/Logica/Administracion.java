package Logica;

import java.util.Date;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Administracion {
	
	private Date fecha;
	
	/** M�todo constructor de la clase. */
	public Administracion(Date fecha) {
		this.fecha = fecha;
	}
	
	/** M�todo que retorna la fecha de ...
	 * @return Fecha de ... */
	public Date getFecha() {
		return fecha;
	}
	
	/** M�todo para modificar la fecha de ...
	 * @param fecha Nueva fecha ...
	 * @return No retorna nada. */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
