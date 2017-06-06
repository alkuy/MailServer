package Logica;

import java.util.Date;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Auditoria {
	
	private String tipo;
	private Date fecha;
	
	/** Método constructor de la clase. */
	public Auditoria(String tipo, Date fecha) {
		this.tipo = tipo;
		this.fecha = fecha;
	}
	
	/** Método que retorna la fecha de cuando se realizo la auditoria.
	 * @return Fecha de auditoria. */
	public Date getFecha() {
		return fecha;
	}
	
	/** Método que retorna la fecha de cuando se realizo la auditoria.
	 * @return Fecha de auditoria. */
	public String getTipo() {
		return tipo;
	}
	
	/** Método para modificar la fecha de cuando se realizo la auditoria.
	 * @param fecha Nueva fecha de auditoria.
	 * @return No retorna nada. */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/** Método para modificar el tipo de auditoria.
	 * @param tipo Nuevo tipo de auditoria.
	 * @return No retorna nada. */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
