package Logica;

import Persistencia.FachadaBD;

public class Cuenta {
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	private String nom_u; // Solo agregue esto aca. No se por que no se pudo de entrada, por eso no lo puse en el contructor
	private String contraseña_cuenta;
	private Correos correos;
	private String dominio;
	//private Dominio dominio; // Por que es del tipo dominios ?????
	
	public Cuenta(){
		
	}

	
	/** Método constructor de la clase. */
	public Cuenta(String contraseña_cuenta, String dominio, Correos correos) {
		this.contraseña_cuenta = contraseña_cuenta;
		this.dominio = dominio;
		this.correos = new Correos();
	}
	
	/** Método que retorna la contraseña de la cuenta de usuario.
	 * @return Contraseña de la cuenta de usuario. */
	public String getContraseña_cuenta() {
		return contraseña_cuenta;
	}
	
	public String getDominio() {
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
