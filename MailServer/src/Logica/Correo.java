package Logica;

import java.util.Date;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Correo {
	
	private Cuenta emisor;
	private String asunto;
	private Cuenta receptor;	
	private Date fecha;
	private Date hora;
	private boolean flag_respuesta;
	
	/** Método constructor de la clase.
	 * @param emisor Usuario emisor del correo.
	 * @param receptor Usuario receptor del correo.
	 * @param asunto Asunto del correo.
	 * @param fecha Fecha del correo.
	 * @param hora Hora del correo.
	 * @param flag_respuesta Indica si es respuesta 
	 * 			a un correo con el mismo asunto. */
	public Correo(Cuenta emisor, Cuenta receptor, String asunto,
			Date fecha, Date hora, boolean flag_respuesta) {
		this.emisor = emisor;
		this.receptor = receptor;
		this.asunto = asunto;
		this.fecha = fecha;
		this.hora = hora;
		this.flag_respuesta = flag_respuesta;
	}
	
	/** Método que retorna el asunto del correo.
	 * @return Asunto del correo. */
	public String getAsunto() {
		return asunto;
	}
	
	/** Método que retorna el emisor del correo.
	 * @return Emisor del correo. */
	public Cuenta getEmisor() {
		return emisor;
	}
	
	/** Método que retorna la fecha del correo.
	 * @return Fecha del correo. */
	public Date getFecha() {
		return fecha;
	}
	
	/** Método que retorna la hora del correo.
	 * @return Hora del correo. */
	public Date getHora() {
		return hora;
	}
	
	/** Método que retorna el receptor del correo.
	 * @return Receptor del correo. */
	public Cuenta getReceptor() {
		return receptor;
	}
	
	public boolean getFlag_respuesta(){
		return flag_respuesta;
	}
	
//	No va a contener los set porque en el srv no se van a cambiar los atributos,
//	que se guarde como borrador va a ser tema del cte.

}
