package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Persistencia.FachadaBD;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Dominio {
	
	private String nombre_dominio;
	private int prioridad;
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	public Dominio(){
		
	}
	/** Método constructor de la clase.
	 * @param nombre_dominio Nombre de dominio. 
	 * @param prioridad Prioridad del dominio */
	public Dominio(String nombre_dominio, int prioridad) {
		this.nombre_dominio = nombre_dominio;
		this.prioridad = prioridad;
	}
	
	/** Método que retorna el nombre de nombre de dominio.
	 * @return Nombre de dominio. */
	public String getNombre_dominio() {
		return nombre_dominio;
	}
	
	/** Método que retorna la prioridad del dominio.
	 * @return Prioridad del dominio. */
	public int getPrioridad() {
		return prioridad;
	}
	

	public void setNombre_dominio(String nombre_dominio) {
		this.nombre_dominio = nombre_dominio;
	}
	
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	/** Método que retoena un array con los dominios cargados en la base 
	 * @return ArrayList con dominios y prioridades 
	 */
	public ArrayList<Dominio> carga_dominios(){
		ArrayList<Dominio> dominios = new ArrayList<Dominio>();
		ResultSet rs = null;
		
		try {
			rs=BD.ConTablaDom();
			while(rs.next()){
				Dominio doms = new Dominio();
				doms.nombre_dominio = rs.getString("nom_dominio");
				doms.prioridad = rs.getInt("prioridad");
				dominios.add(doms);
			
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		return dominios;
		
	}
	
/*-----------------------------------------------------------------*/
}
