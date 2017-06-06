package Logica;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Perfil {
	
	private String nombre_perfil;
	
	/** Método constructor de la clase.
	 * @param nombre_perfil Nombre de perfil. */
	public Perfil(String nombre_perfil) {
		this.nombre_perfil = nombre_perfil;
	}
	
	/** Método que retorna el nombre de perfil del usuario.
	 * @return Nombre de perfil del usuario. */
	public String getNombre_perfil() {
		return nombre_perfil;
	}
	
	/** Método para modificar el nombre de perfil del usuario.
	 * @param nombre_perfil Nuevo nombre de perfil del usuario.
	 * @return No retorna nada. */
	public void setNombre_perfil(String nombre_perfil) {
		this.nombre_perfil = nombre_perfil;
	}
	
}
