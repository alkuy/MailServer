package Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
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
		
		/*System.out.println(NU.getHabilitado());
		System.out.println(NU.getApellido());*/
		
		NU.setTels(this.altaTel(NU.getTels(), id, numTel1));
		NU.setTels(this.altaTel(NU.getTels(), id, numTel2));
		
		hUsu.insert(NU);
	}
	
	public Telefonos altaTel(Telefonos auxTels, int idUsu, String numTel){
//		Telefonos auxTels = new Telefonos();
		Telefono auxTel = new Telefono(idUsu, numTel);
		auxTel.InsertTel(idUsu, numTel);
		auxTels.Insertar(auxTel);
		
		return auxTels;
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
	
	/*Para cuentas de un solo usuario*/
	public DefaultTableModel DevCuentasUsuario(int idUsuario) throws SQLException{
		DefaultTableModel modelo;
		Cuentas cuentas = new Cuentas();
		modelo = cuentas.DevTablaCuentasUsuario(idUsuario);
		return modelo;
	}
	
	
	public void altaUsuarioAdmin(String doc, String nom, String ape, String pass_admin, String calle, String nro_puerta, String apto, String numTel1, String numTel2) throws SQLException{
		Usuario usu = new Usuario();
		int id= usu.InstertaUserDevuelveId(pass_admin);
		Usuario NU = new Usuario(id, pass_admin, doc, nom, ape,calle, nro_puerta, apto, true); //Ingreso el usuario como habilitado
		
		NU.setTels(this.altaTel(NU.getTels(), id, numTel1));
		NU.setTels(this.altaTel(NU.getTels(), id, numTel2));
		
		hUsu.insert(NU);
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
 	
 	public void modifyTelUsu(int id_usuario, String oldTel, String newTel, int tel1o2){
		//Si el nuevo telefono es vacio entonces no se hace nada.
 		if(!newTel.isEmpty()){
	 		if(oldTel.isEmpty()){
				//El telefono anterior es vacio. Si el nuevo telefono NO es vacio se debe ingresar.
	 			hUsu.find(id_usuario).setTels(this.altaTel(hUsu.find(id_usuario).getTels(), id_usuario, newTel));
			}
			else{
				//Se pasa a modificar el telefono
				hUsu.find(id_usuario).getTels().Modificar(id_usuario, oldTel, newTel, tel1o2);
			}
		}
	}
 	
 	public String retornarTelx(int id_usuario, int x){
 		Telefonos tels = new Telefonos();
 		tels = hUsu.find(id_usuario).getTels();
 		return tels.retornarTelx(tels.getSetTelefonos(), x);
 	}
 	
 	public void resetPassCuenta(int id, String nom_us, String nom_dom, String pass){
 		//System.out.println(id);
 		hUsu.find(id).getCuentas().resetPass(id, nom_us, nom_dom, pass);
 	}
 	
 	
 	public int pri_Dom(String Dom){
 		Dominio domi = new Dominio();
 		int pri = domi.trae_prioridad(Dom);
 		return pri;
 	}
 	
 }
	 
 
