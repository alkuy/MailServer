package Logica;

import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.table.DefaultTableModel;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Fachada {
	
	private static Fachada instancia;
	private static Dominio dominio;
	private Usuarios hUsu;

	
	private Fachada() {
		this.hUsu = new Usuarios();
		//this.dominio = new Dominio();
	}
	public static Fachada getInstancia() {
		if(instancia == null)
			instancia = new Fachada();
		
		return instancia;
	}
	
	Cuenta cuenta = Cuenta.getInstancia();
	Cuentas cuentas = Cuentas.getInstancia();
	
	public Usuarios gethUsu() {
		return hUsu;
	}
	
	public void altaUsu(String doc, String nom, String ape, String calle, String nro_puerta, String apto, String numTel) throws SQLException{
		Usuario usu = new Usuario();
		int id= usu.InstertaUserDevuelveIdCargaPersona();
		Usuario NU = new Usuario(id, doc, nom, ape, calle,  nro_puerta, apto);
		hUsu.insert(NU);
		
		this.altaTel(id, numTel);
	}
	
	public void altaTel(int idUsu, String numTel){
		Telefonos auxTels = new Telefonos();
		Telefono auxTel = new Telefono(idUsu, numTel);
		auxTels.Insertar(auxTel);
	}
	
	public void bajaUsu(Usuario usuario){
///		hUsu.delete(usuario.getNom_usuario());
	}
	
	public void mofifUsu(Usuario usuario){
		
	}


	/**
	 * Metodo que carga ArrayList de dominios. Lo usoa para cargar combobox en Nueva Cuenta
	 * @return ArrayList<String> con dominios
	 */
	public ArrayList<String> carga_dominios(){
		ArrayList<String> dominios = new ArrayList<String>();
		Dominio dom = new Dominio();
		dominios = dom.carga_nom_dom();
		return dominios;
		
	}
	
	/**
	 * Metdo que trae Array con todos la cueta
	 * @return ArrayList<Cuenta>
	 */
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
	
	
	public boolean VerificaCuenta(String usuario, String dominio){
		boolean vale = false;
		
		String usu, dom, cadena1, cadena2;
		cadena2 = usuario+dominio;
		/*Paso a minuscula porque sino del commbobox lo trae en mayuscula*/
		cadena2 = cadena2.toLowerCase();
		for (int i = 0; i < cuentas.getsetCuentas().size(); i++){
			usu = cuentas.getsetCuentas().get(i).getNom_u().toString();
			dom = cuentas.getsetCuentas().get(i).getDominio().toString();
			cadena1 = usu+dom;
			/*comparo lo ingresado con lo existente en el arraylist*/
			
			if (cadena1.equals(cadena2)){
				vale = true;
			}
			
		}
		return vale;
	}
	
	/**
	 * Funcion que ingresa sobre la base todos los datos de la cuenta
	 * Los carga al array de cuentas y limpia los datos del objeto.
	 */
	public void altaCuentaPersonal(String cedula, String nomU, String dominio){
		nomU = nomU.toLowerCase();
		dominio = dominio.toLowerCase();
		
		cuenta.setIdUsuario(cedula);
		cuenta.setNomU(nomU);
		cuenta.setDominio(dominio);
		cuenta.setContraseña_cuenta(cedula);
		cuenta.setEs_lista(0);		
		cuentas.Insertar(cuenta);
		cuenta.LimpiaCuenta();
		
	}
	
	/**
	 * Trae la tabla de Cuentas
	 * @return
	 * @throws SQLException
	 */
	public DefaultTableModel DevCuentasCompleto() throws SQLException{
		DefaultTableModel modelo;
		Cuentas cuentas = new Cuentas();
		modelo = cuentas.DevTablaCuenta();
		return modelo;
	}
	
/*	public boolean ExisteUsuario(String cedula){
		Usuarios usuarios = new Usuarios();
		ArrayList<Usuario> users = usuarios. 
		return false;
	}*/
	
}
