package Logica;

import Persistencia.FachadaBD;

public class Cuenta {
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	private String nom_u; // Solo agregue esto aca. No se por que no se pudo de entrada, por eso no lo puse en el contructor
	private String contrase�a_cuenta;
	private Correos correos;
	private String dominio;
	//private Dominio dominio; // Por que es del tipo dominios ?????
	
	public Cuenta(){
		
	}

	
	/** M�todo constructor de la clase. */
	public Cuenta(String contrase�a_cuenta, String dominio, Correos correos) {
		this.contrase�a_cuenta = contrase�a_cuenta;
		this.dominio = dominio;
		this.correos = new Correos();
	}
	
	/** M�todo que retorna la contrase�a de la cuenta de usuario.
	 * @return Contrase�a de la cuenta de usuario. */
	public String getContrase�a_cuenta() {
		return contrase�a_cuenta;
	}
	
	public String getDominio() {
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
	
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	
	public void setCorreos(Correos correos) {
		this.correos = correos;
	}
	
	/*Agregado por Adrian*/
	public void setNomU(String nombre){
		this.nom_u = nombre;
	}

}
