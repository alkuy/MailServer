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
		/*Calendar fecha = Calendar.getInstance();
		int anio = fecha.get(Calendar.YEAR);
		cuenta.setContraseña_cuenta(dominio+anio);*/
		cuenta.setContraseña_cuenta("1234");
		cuenta.setEs_lista(0);		
		cuentas.Insertar(cuenta);
		cuenta.LimpiaCuenta();
	}
	
	/**
	 * Trae la tabla de Cuentas
	 * @return TableModel
	 * @throws SQLException
	 */
	
	public java.sql.ResultSet CuentasDesdeBD() throws SQLException{
		java.sql.ResultSet rs = null;
		rs = BD.ConTablaCuenta();
		return rs;
	}
	
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
	


  /** Metodo de autenticacion de login
   * 
   * @param cedula
   * @param passwd
   * @return true or false
   * @throws SQLException
  */
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
 
 	public String ObtenPass(String Usu, String dom) throws SQLException{
 		Usuario usuario = new Usuario();
 		String pass = usuario.ObtenerPass(Usu, dom);
 		return pass;
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
 	
 	
 	
 	public void cambiaPassCuenta(String nom_us, String nom_dom,String passNuevo) throws SQLException{
 		
		
		int id = this.IdUsuario(nom_us, nom_dom);
 		hUsu.find(id).getCuentas().cambiaPass(nom_us, nom_dom, passNuevo);
 	}
 	
 	
 	
 	
 	
 	public void deshabCuenta(int id, String nom_us, String nom_dom, boolean habilitada){
 		hUsu.find(id).getCuentas().deshabCuenta(id, nom_us, nom_dom, habilitada);
 	}
 	
	public boolean desOhabCuenta(int id, String nom_us, String nom_dom) throws SQLException{
 		Usuarios u = new Usuarios();
			if(u.esOficina(id)){
				Cuentas c = new Cuentas();
				return c.estaHabilitadaOf(id);
			}else{
				return hUsu.find(id).getCuentas().desOhabCuenta(id, nom_us, nom_dom);
			}
	
 	}
 	
 	public int pri_Dom(String Dom){
 		Dominio domi = new Dominio();
 		int pri = domi.trae_prioridad(Dom);
 		return pri;
 	}
 	
 	public int IdUsuario(String NomUsu, String DomUsu) throws SQLException{
		Cuenta c = new Cuenta();
		return c.devuelveIdUsuarioCuenta(NomUsu, DomUsu);
	}
 	
 	/**
 	 * Verifica la existencia de una cuenta
 	 * @param usuario
 	 * @param dominio
 	 * @return true si la cuenta ya existe con ese nombre
 	 */
 	public boolean VerificaCuenta(String usuario, String dominio){
 		Cuentas cuenta = new Cuentas();
 		if(cuenta.comprueba_cuenta(usuario, dominio)){
 			return true;
 		}else{
 			return false;
 		}
 	}
 	
 	public void CargaCorreoBD(String emisor, int IdEmisor, String receptor, int IdReceptor, String asunto, int IdCorreo, String Texto){
 		Correo C = new Correo(emisor, IdEmisor, receptor, IdReceptor, asunto, IdCorreo, false, Texto);
 		C.CargarCorreoEnBase(C);
 	}
 	
 	public java.sql.ResultSet ObtieneCorreosBD() throws SQLException{
 		Correo C = new Correo("a", 1, "b", 2, "c", 4, false, "e");
 		java.sql.ResultSet rs = C.ObtenerCorreoDeBase();
 		return rs;
 	}
 	
 	public java.sql.ResultSet ObtieneCorreosBDUsu(String Usu, String Dom) throws SQLException{
 		Correo C = new Correo("a", 1, "b", 2, "c", 4, false, "e");
 		java.sql.ResultSet rs = C.ObtenerCorreoDeBaseUsu(Usu, Dom);
 		return rs;
 	}
 	
 	
 	public void Correo_Enviado(String fecha, boolean Enviado){
 		Correo C = new Correo("a", 1, "b", 2, "c", 4, false, "e");
 		C.Correo_Enviado(fecha, Enviado);
 	}
 	
 	/*public String getPassAdmin(String id){
 		String pass=null;
 		pass = 
 		return pass;
 	}*/
 	
 	/**
 	 * Trae tabla con Administrdores
 	 * @return
 	 * @throws SQLException
 	 */
 	public DefaultTableModel DevTablaAdmins() throws SQLException{
		DefaultTableModel modelo;
		Usuarios admin = new Usuarios();
		modelo = admin.DevTablaAdmins();
		return modelo;
	}
 	
 	/**
 	 * Se fija si no hay ningun registro en la base 
 	 * @return True si no hay registros
 	 */
 	public boolean BaseNueva(){
 		Usuarios user = new Usuarios();
 		boolean es = false;
		try {
			es = user.CompurebaVacio();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return es;
 	}
 	
 	/**
 	 * Cambia el password del asministrador
 	 * @param id
 	 * @param pass
 	 */
 	public void cambiaPassAdmin(int id, String pass){
 		Usuario user = new Usuario();
 		user.cambiaPassAdmin(id, pass);
 	}
 	
 	/**
 	 * Comprueba si el id dado pertenece a un grupo u oficina
 	 * @param id
 	 * @return true si es Oficina
 	 * @throws SQLException
 	 */
 	public boolean esOficina(int id) throws SQLException{
 		Usuarios user = new Usuarios();
 		boolean es = user.esOficina(id);
 		return es;
 	}
 	
 	/**
 	 * Traer el nombre de la oficina
 	 * @param id
 	 * @return
 	 * @throws SQLException
 	 */
 	public String nomOficina(int id)throws SQLException{
 		Usuarios user = new Usuarios();
 		String of = user.nombreOficina(id);
 		return of;
 	}
 	
 	/**
 	 * Habilitar o deshabilitar oficina
 	 * @param id
 	 * @param habilita
 	 * @throws SQLException
 	 */
 	public void habilitaOficina(int id, boolean habilita)throws SQLException{
 		Cuentas c = new Cuentas();
 		c.habilitaOficina(id, habilita);
 	}
 	
 	/**
 	 * Saber si una cuenta de grupo esta habilitada
 	 * @param id
 	 * @return
 	 * @throws SQLException
 	 */
 	public boolean OfEstaHabilitada(int id)throws SQLException{
 		Cuentas c = new Cuentas();
 		boolean esta = c.estaHabilitadaOf(id);
		return esta;
 		
 	}
 	
 	public void resetPassOfi(int id){
 		Cuenta c = new Cuenta();
 		c.ResetPassOfi(id);
 	}
 	
 }
	 
 
