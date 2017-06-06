package Logica;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Dominio {
	
	private String nombre_dominio;
	private int prioridad;
	
	/** M�todo constructor de la clase.
	 * @param nombre_dominio Nombre de dominio. 
	 * @param prioridad Prioridad del dominio */
	public Dominio(String nombre_dominio, int prioridad) {
		this.nombre_dominio = nombre_dominio;
		this.prioridad = prioridad;
	}
	
	/** M�todo que retorna el nombre de nombre de dominio.
	 * @return Nombre de dominio. */
	public String getNombre_dominio() {
		return nombre_dominio;
	}
	
	/** M�todo que retorna la prioridad del dominio.
	 * @return Prioridad del dominio. */
	public int getPrioridad() {
		return prioridad;
	}
	
//	Esto no se si va:
//	public void setNombre_dominio(String nombre_dominio) {
//		this.nombre_dominio = nombre_dominio;
//	}
//	
//	public void setPrioridad(int prioridad) {
//		this.prioridad = prioridad;
//	}

}
