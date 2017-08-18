package Logica;

import java.util.Date;


public class Administracion {
	
	private Date fecha;
	
	/** 
	 * Método constructor de la clase. 
	 * */
	public Administracion(Date fecha) {
		this.fecha = fecha;
	}
	
	/** Método que retorna la fecha de ...
	 * @return Fecha de ... */
	public Date getFecha() {
		return fecha;
	}
	
	/** Método para modificar la fecha de ...
	 * @param fecha Nueva fecha ...
	 * @return No retorna nada. */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
