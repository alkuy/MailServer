package Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

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
	
	public void altaUsu(String doc, String nom, String ape, String calle, String nro_puerta, String apto) throws SQLException{
		Usuario usu = new Usuario();
		int id= usu.InstertaUserDevuelveIdCargaPersona();
		Usuario NU = new Usuario(id, doc, nom, ape, calle,  nro_puerta, apto);
		hUsu.insert(NU);

	}
	
	public void bajaUsu(Usuario usuario){
///		hUsu.delete(usuario.getNom_usuario());
	}
	
	public void mofifUsu(Usuario usuario){
		
	}
	
	/**
	 * Metodo que carga ArrayList de dominios
	 * @return ArrayList con dominios y prioridades
	 */
	public ArrayList<Dominio> carga_dominios(){
		ArrayList<Dominio> dominios = new ArrayList<Dominio>();
		Dominio dom = new Dominio();
		dominios = dom.carga_dominios();
		return dominios;
		
	}
	
}
