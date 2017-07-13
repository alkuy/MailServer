package Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

import Persistencia.FachadaBD;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Fachada {
	
	private static Fachada instancia;
	private static Dominio dominio;
	private Usuarios hUsu;
	
	FachadaBD BD = FachadaBD.getInstancia(); //Provisorio

	
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
	
	public void altaUsu(String doc, String nom, String ape, String calle, String nro_puerta, String apto, String numTel1, String numTel2) throws SQLException{
		Usuario usu = new Usuario();
		int id= usu.InstertaUserDevuelveId(null);
		Usuario NU = new Usuario(id, doc, nom, ape, calle,  nro_puerta, apto, true);
		hUsu.insert(NU);
		
		/*System.out.println(NU.getHabilitado());
		System.out.println(NU.getApellido());*/
		
		this.altaTel(id, numTel1);
		this.altaTel(id, numTel2);
	}
	
	public void altaTel(int idUsu, String numTel){
		Telefonos auxTels = new Telefonos();
		Telefono auxTel = new Telefono(idUsu, numTel);
		auxTel.InsertTel(idUsu, numTel);
		auxTels.Insertar(auxTel);
	}
	
	public int altaUsuGrupo(String nom) throws SQLException{
		Usuario usu = new Usuario();
		int id= usu.InstertaUserDevuelveId(null);
		Usuario NU = new Usuario(id, nom);
		hUsu.insert(NU);
		return id;
	}
	
	public void bajaUsu(Usuario usuario){
///		hUsu.delete(usuario.getNom_usuario());
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
		for (int i = 0; i < cuentas.getsetCuentas().size()-1; i++){ // sigo sin resolver bien esto
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
	 * @param cedula
	 * @param nomU
	 * @param dominio
	 */
	public void altaCuentaPersonal(String cedula, String nomU, String dominio){
		nomU = nomU.toLowerCase();
		dominio = dominio.toLowerCase();
		
		cuenta.setIdUsuario(cedula);
		cuenta.setNomU(nomU);
		cuenta.setDominio(dominio);
		cuenta.setContraseña_cuenta(cedula);
		cuenta.setEs_lista(0);
		cuenta.setHabilitada(true);
		cuentas.Insertar(cuenta);
		cuenta.LimpiaCuenta();
		
	}
	/**
	 * Funcion que le da alta a una cuenta grupal o de oficina
	 * @param id
	 * @param nomU
	 * @param dominio
	 * Password dominio+año
	 */
	public void altaCuentaGrupo(int id, String nomU, String dominio){
		nomU = nomU.toLowerCase();
		dominio = dominio.toLowerCase();
		cuenta.setIdUsuario(id);
		cuenta.setNomU(nomU);
		cuenta.setDominio(dominio);
		Calendar fecha = Calendar.getInstance();
		int anio = fecha.get(Calendar.YEAR);
		cuenta.setContraseña_cuenta(dominio+anio);
		cuenta.setEs_lista(0);		
		cuentas.Insertar(cuenta);
		cuenta.LimpiaCuenta();
	}
	
	/**
	 * Trae la tabla de Cuentas
	 * @return TableModel
	 * @throws SQLException
	 */
	public DefaultTableModel DevCuentasCompleto() throws SQLException{
		DefaultTableModel modelo;
		Cuentas cuentas = new Cuentas();
		modelo = cuentas.DevTablaCuenta();
		return modelo;
	}
	
	
	public void altaUsuarioAdmin(String doc, String nom, String ape, String pass_admin, String calle, String nro_puerta, String apto, String numTel1, String numTel2) throws SQLException{
		Usuario usu = new Usuario();
		int id= usu.InstertaUserDevuelveId(pass_admin);
		Usuario NU = new Usuario(id, pass_admin, doc, nom, ape,calle, nro_puerta, apto, true); //Ingreso el usuario como habilitado
		hUsu.insert(NU);
		
		this.altaTel(id, numTel1);
		this.altaTel(id, numTel2);
	}
/*	public boolean ExisteUsuario(String cedula){
		Usuarios usuarios = new Usuarios();
		ArrayList<Usuario> users = usuarios. 
		return false;
	}*/
	
	public DefaultTableModel DevUsuariosCompleto() throws SQLException{
		DefaultTableModel modelo;
		Usuarios usuarios = new Usuarios();
		modelo = usuarios.DevTablaUsuario();
		return modelo;
		
		//Usuarios usuarios = new Usuarios();
		
		//usuarios.imprimirConsola(usuarios.getColection());
		
	}
	

public void altaDominio(String dominio, int prioridad){
		Dominio dom = new Dominio(dominio, prioridad);
	}
	



 public boolean verifica_ingreso(String cedula, String passwd) throws SQLException{
	 
		
		Usuario usuario = new Usuario();
		
			
	if (usuario.autentica(cedula, passwd)){
		
		return true;
		
	}else {
	
		return false;
		
	   }
		
	}
 
 public int trae_id(String cedula){
	 int id;
	 Usuario usuario = new Usuario();
	 id=usuario.trae_id(cedula);
	 return id;
	 }
 
 
 	public Usuario findUsu(int id_usuario){
 		return hUsu.find(id_usuario);
 	}
 	
 	public int getID(String ci){
 		return hUsu.getID(ci);
 	}
 	
 	public void modifyUsuario(int id_usuario, String ci, String nombre, String apellido, String calle, 
 			String nro, String apto, boolean habilitado){
 		hUsu.modify(id_usuario, ci, nombre, apellido, calle, nro, apto, habilitado);
 	}
 	
 	public String retornarTelx(int id_usuario, int x){
// 		System.out.println("EN FACHADA " + hUsu.find(id_usuario).getId_usuario());
// 		System.out.println("DONDE EXPLOTAS1");
 		Telefonos tels = new Telefonos();
 		tels = hUsu.find(id_usuario).getTels();
// 		System.out.println("DONDE EXPLOTAS2");
// 		if(tels==null)
// 			System.out.println("SOY UN PUTO NULL");
 		return tels.retornarTelx(tels.getSetTelefonos(), x);
 	}
 	
 	public void modifyCuenta(int id, String nom_us, String nom_dom, String pass){
 		Usuario usu = hUsu.find(id);
// 		System.out.println(id);
// 		//Imprimir pass para probar que se modifica
// 		ArrayList<Cuenta> cuentas = usu.getCuentas().getsetCuentas();
// 		Iterator<Cuenta> aux = cuentas.iterator();
// 		while(aux.hasNext()){
// 			System.out.println("pass " + aux.next().getContraseña_cuenta());
// 		}
// 		
// 		pass = usu.getCi();
 		
// 		usu.getCuentas().modify(id, nom_us, nom_dom, pass);
 		
// 		System.out.println("new pass " + pass);
 		
 		BD.Modifica_cuentaPS(id, nom_us, nom_dom, usu.getCi());
 	}
 	
 	
 	public int pri_Dom(String Dom){
 		Dominio domi = new Dominio();
 		int pri = domi.trae_prioridad(Dom);
 		return pri;
 	}
 }
	 
 
