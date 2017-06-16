package Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Fachada {
	
	private static Fachada instancia;
	private Usuarios hUsu;
	private Dominio hDom;
	
	private Fachada() {
		this.hUsu = new Usuarios();
		this.hDom = new Dominio();
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
	public Dominio getDom() {
		return hDom;
	}
	public void setDom() {
		this.hDom = new Dominio();
	}
	
	public ArrayList<Dominio> carga_dominios(){
		ArrayList<Dominio> dominios = new ArrayList<Dominio>();
		Dominio dom = new Dominio();
		dominios = dom.carga_dominios();
		return dominios;
		
	}
	
	public ArrayList<Cuenta> carga_cuentas(){
		ArrayList<Cuenta> cuenta = new ArrayList<Cuenta>();
		Cuentas cont = new Cuentas();
		cuenta = cont.cargaCuentasdesdeBD();
	
		return cuenta;
		
	}
	
	/**
	 * Carga en una tabla grafica los dominios con sus prioridades
	 * @return ModelTable
	 * @throws SQLException
	 */
	public DefaultTableModel DevDominioCompleto() throws SQLException{
		DefaultTableModel modelo;
		Dominio dom = new Dominio();
		modelo = dom.DevTablaDom();
		return modelo;
	}
	
}
