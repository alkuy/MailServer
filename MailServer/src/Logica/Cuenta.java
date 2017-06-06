package Logica;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Cuenta {
	
	
	private String contrase�a_cuenta;
	private Dominio dominio;
	private Correos correos;
	
	/** M�todo constructor de la clase. */
	public Cuenta(String contrase�a_cuenta, Dominio dominio, Correos correos) {
		this.contrase�a_cuenta = contrase�a_cuenta;
		this.dominio = dominio;
		this.correos = correos;
	}
	
	/** M�todo que retorna la contrase�a de la cuenta de usuario.
	 * @return Contrase�a de la cuenta de usuario. */
	public String getContrase�a_cuenta() {
		return contrase�a_cuenta;
	}
	
	public Dominio getDominio() {
		return dominio;
	}
	
	public Correos getCorreos() {
		return correos;
	}
	
	/** M�todo para modificar la contrase�a de la cuenta de usuario.
	 * @param contrase�a_cuenta Nueva contrase�a de la cuenta de usuario.
	 * @return No retorna nada. */
	public void setContrase�a_cuenta(String contrase�a_cuenta) {
		this.contrase�a_cuenta = contrase�a_cuenta;
	}
	
	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}
	
	public void setCorreos(Correos correos) {
		this.correos = correos;
	}

}
