package Logica;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Cuenta {
	
	
	private String contraseña_cuenta;
	private Dominio dominio;
	private Correos correos;
	
	/** Método constructor de la clase. */
	public Cuenta(String contraseña_cuenta, Dominio dominio, Correos correos) {
		this.contraseña_cuenta = contraseña_cuenta;
		this.dominio = dominio;
		this.correos = correos;
	}
	
	/** Método que retorna la contraseña de la cuenta de usuario.
	 * @return Contraseña de la cuenta de usuario. */
	public String getContraseña_cuenta() {
		return contraseña_cuenta;
	}
	
	public Dominio getDominio() {
		return dominio;
	}
	
	public Correos getCorreos() {
		return correos;
	}
	
	/** Método para modificar la contraseña de la cuenta de usuario.
	 * @param contraseña_cuenta Nueva contraseña de la cuenta de usuario.
	 * @return No retorna nada. */
	public void setContraseña_cuenta(String contraseña_cuenta) {
		this.contraseña_cuenta = contraseña_cuenta;
	}
	
	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}
	
	public void setCorreos(Correos correos) {
		this.correos = correos;
	}

}
