package Logica;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Fachada {
	
	private static Fachada instancia;
	private Usuarios hUsu;
	
	private Fachada() {
		this.hUsu = new Usuarios();
	}
	
	public static Fachada getInstancia() {
		if(instancia == null)
			instancia = new Fachada();
		
		return instancia;
	}
	
	public Usuarios gethUsu() {
		return hUsu;
	}
	
	public void altaUsu(Usuario usuario){
		hUsu.insert(usuario);
	}
	
	public void bajaUsu(Usuario usuario){
		hUsu.delete(usuario.getNom_usuario());
	}
	
	public void mofifUsu(Usuario usuario){
		
	}
	
}
