package Persistencia;

import java.sql.SQLException;



/** Clase fachada de conexion entre la capa de Persistencia y las clases de la capa logica.
 * @author 
 * @version 1.0
*/ 

public class FachadaBD {

	private static FachadaBD instancia;	
	private Usuario user = new Usuario();
	private Persona persona = new Persona();
	private Correo correo = new Correo();
	private Dominio dominio = new Dominio();
	private Cuenta cuenta = new Cuenta();
	private Telefono telefono = new Telefono();
	private Oficina oficina = new Oficina();	
	
	
	
	
	/** Método constructor de la clase FachadaBD - vacio.
	 *
	*/
	private FachadaBD(){}
	
		
	public static FachadaBD getInstancia(){
		if (instancia == null)
			instancia = new FachadaBD();
			
		return instancia;
	}
	
	
    /* METODOS PARA LA CLASE USUARIO */
	
	
	/** Metodo para ingresar un registro en la tabla Usuario
	 *@param pass passwd admin
	*/
	public void InserUS (String pass){
		this.user.InsertRow(pass);
	}
	
	
	
	/** Metodo para modificar el passwd de un Usuario Admin.
	 *@param pass passwd admin
	 *@param id id usuario
	*/
	public void ModificaPS (int id, String pass){
			this.user.cambiar_passwd(id, pass);
	}
	
	/** Método que devuelve todos los datos de la tabla usuarios
	 * @return Resulset con la tabla usuario
	 * @throws SQLException
	*/
	public java.sql.ResultSet ConTablaUS() throws SQLException{
		java.sql.ResultSet rs;
		rs = this.user.Select_tabla();
		return rs;
	}
	
	
	/** Método que devuelve todos los datos de un usuario seleccionado segun su id
	 * @return Resulset con la fila correspondiente al usuario seleccionado
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet ConFilaUS(int idUsu) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.user.Select_fila(idUsu);
		return rs;
	}
		
	
	/** Método que devuelve el ultimo id de usuario ingresado
	 * @return Resulset con el ultimo id de usuario
	 * @throws SQLException
	*/	
	public java.sql.ResultSet ConUltimoID() throws SQLException{
		java.sql.ResultSet rs;
	    rs = this.user.Select_ultimo_id();
		return rs;
	}
	
	
	/** Método que devuelve el passwd de usuario segun su id
	 * @param id id de usuario
	 * @return Resulset con el passwd de usuario
	 * @throws SQLException
	*/ 	
  	public String Devolver_pass(int id) throws SQLException{ 		
  		
  		String pass = " ";
  		java.sql.ResultSet rs;
  	    rs = this.user.Dev_pass(id);  	 
  	    rs.next();
  	  	pass = rs.getString(1);
		return pass;
  	}
  	
	/** Método que devuelve el passwd de usuario segun su id
	 * @param id id de usuario
	 * @return Resulset con el passwd de usuario
	 * @throws SQLException
	*/ 	
  	public String Devolver_passCon(int id) throws SQLException{ 		
  		
  		String pass = " ";
  		java.sql.ResultSet rs;
  	    rs = this.user.Dev_passCon(id);  	 
  	    rs.next();
  	  	pass = rs.getString(1);
		return pass;
  	}
  	
  	/**
     * Metodo que deshabilita el usuario y todas sus cuentas
     * 1 - Habilitada
     * 0 - Deshabilitada
     * @param id id usuario
     * @param habilita indica habilitado o no
    */
	public void habilitacion_usuario(int id, boolean habilita){
		user.habilitar_usuario(id, habilita);
		cuenta.habilitar_cuenta(id, habilita);
	}
  	
	
	/* METODOS PARA LA CLASE PERSONA */
	
	
	 /** Método que crea un objeto persona en la tabla Persona
	 *@param id es el id de usuario
	 *@param ced cedula de la persona
	 *@param nom nombre de la persona
	 *@param apellido apellido de la persona
	 *@param calle calle donde vive la persona
	 *@param nro numero de puerta
	 *@param apto numero de apartmento
     */	
	
	public void Nueva_Persona (int id, String ced, String nom, String ap, String calle, String nro, String apto){
		
		this.persona = new Persona(id,ced,nom,ap, calle, nro, apto);
	}
	
	
	/** Método para modificar los datos peronales a partir de la ci
	*/	
	public void Modifica_datos_per (String ci, String nombre, String apellido,String calle, String nro, String apto){
		this.persona.cambiar_datos_personales(ci, nombre, apellido, calle, nro, apto);
	}

	
	
	/** Método que devuelve el id de usuario segun la cedula ingresada
	 * @return Resulset con el id de usuario
	 * @throws SQLException
	*/	
  	public int Devolver_id(String ci) throws SQLException{
 		int id=0;
 		java.sql.ResultSet rs;
 	    rs = this.persona.Dev_id(ci);
 		while (rs.next()){
 			id = rs.getInt(1);
 		}
 		return id;
 	}
     
 	
  	/** Método que devuelve la c.i de usuario segun su id
	 * @return Resulset con la c.i de usuario
	 * @throws SQLException
	*/	 	
  	public java.sql.ResultSet Devolver_ci(int id) throws SQLException{
  		
  		java.sql.ResultSet rs;
  	   	rs = this.persona.Dev_ci(id);  		
  		return rs;
  	}
  	
 	/** Método que devuelve la c.i de usuario segun su Nombre de Usuario
	 * @return Resulset con la c.i de usuario
	 * @throws SQLException
	*/	 	
  	public java.sql.ResultSet Devolver_ci2(String NomUsu) throws SQLException{
  		
  		java.sql.ResultSet rs;
  	   	rs = this.persona.Dev_ci_2(NomUsu);  		
  		return rs;
  	}
  	
  	
     
  	/** Método de ingreso de datos de la persona a la BD
	 * @exception Exception
    */		
	public void InsertPer (int id, String ced, String nom, String ap, String calle, String nro, String apto){
		this.Nueva_Persona(id,ced,nom,ap, calle, nro, apto);
		this.persona.InsertRow();
	}
	
		
	/** Método que devuelve todos los datos de la tabla persona
	 * @return Resulset con la tabla persona
	 * @throws SQLException
	*/	
	public java.sql.ResultSet ConTablaPer(int idUsu) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.persona.Select_Tabla();
		return rs;
	}
	
	
	/** Método que devuelve todos los datos de una Persona seleccionada
	 * @param id , id de usuario
	 * @return Resulset con la fila correspondiente a la persona seleccionada
	 * @throws SQLException
	*/		
	public java.sql.ResultSet ConFilaPer(int idUsu) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.persona.Select_fila(idUsu);
		return rs;
	}
	
	
		
	/*METODOS PARA LA CLASE CORREO*/
	
	
	/** Método que crea un objeto correo en la clase Correo
	 *@param nom_us1 nombre del usuario emisor
	 *@param nom_dom1 nombre del dominio emisor
	 *@param nom_us2 nombre del usuario receptor
	 *@param nom_dom2 nombre del dominio receptor
	 *@param fecha es la fecha del correo
	 *@param id1 id del usuario emisor
	 *@param id2 id del usuario receptor
	 *@param asunto asunto del correo
	 *@param texto texto del correo
	 *@param id id de conversacion
	*/
	
	public void NuevoCorreo (String nom_us1, String nom_dom1, String nom_us2, String nom_dom2, String fecha, int id1, int id2, String asunto, String texto, int id){
		this.correo = new Correo(nom_us1,nom_dom1, nom_us2, nom_dom2,fecha, id1, id2, asunto,texto, id);
	}
	
		
	/** Método de ingreso de datos del correo a la BD
	 *@param nom_us1 nombre del usuario emisor
	 *@param nom_dom1 nombre del dominio emisor
	 *@param nom_us2 nombre del usuario receptor
	 *@param nom_dom2 nombre del dominio receptor
	 *@param fecha es la fecha del correo
	 *@param id1 id del usuario emisor
	 *@param id2 id del usuario receptor
	 *@param asunto asunto del correo
	 *@param texto texto del correo
	 *@param id id de conversacion
	    */
	
	public void InsertCorreo (String nom_us1, String nom_dom1, String nom_us2, String nom_dom2, String fecha, int id1, int id2, String asunto, String texto, int id){
		this.NuevoCorreo(nom_us1, nom_dom1, nom_us2, nom_dom2, fecha, id1, id2, asunto, texto, id);
		this.correo.InsertRow();
	}
	
	
	
	/** Método que devuelve todos los datos de la tabla correo
	 * @return Resulset con la tabla correo
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet ConTablaCorreo() throws SQLException{
		java.sql.ResultSet rs;
		rs = this.correo.Select_tabla();
		return rs;
	}
	
	/** Método que borra todos los correos
	 * 
	 * 
	*/
	
	public void BorrarTablaCorreos(){
		correo.DeleteCorreo();
	}
	
	/** Método que devuelve todos los datos de la tabla correo de un Usuario
	 * @param Usuario a consultar
	 * @return Resulset con la tabla correo del Usuario
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet ConTablaCorreoUsu(String Usu) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.correo.Select_tabla_Usuario(Usu);
		return rs;
	}
	
	
	/** Método que devuelve todos los datos de un correo seleccionado
	 *@param nom_us1 nombre del usuario emisor
	 *@param nom_dom1 nombre del dominio emisor
	 *@param nom_us2 nombre del usuario receptor
	 *@param nom_dom2 nombre del dominio receptor
	 *@param fecha es la fecha del correo
	 * @return Resulset con la fila correspondiente al correo seleccionado
	 * @throws SQLException
	*/	
	public java.sql.ResultSet ConFilaCorreo(String nom_us1,String nom_dom1, String nom_us2, String nom_dom2, String fecha) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.correo.Select_fila(nom_us1,nom_dom1,nom_us2, nom_dom2,fecha);
		return rs;
	}
	

	/** Método para eliminar un correo seleccionado
     *@param nom_us1 nombre del usuario emisor
	 *@param nom_dom1 nombre del dominio emisor
	 *@param nom_us2 nombre del usuario receptor
	 *@param nom_dom2 nombre del dominio receptor
	 *@param fecha es la fecha del correo
	*/
  	public void Eliminar_correo(String nom_us1,String nom_dom1, String nom_us2, String nom_dom2, String fecha) {
  		
  		
  		this.correo.eliminar_correo(nom_us1, nom_dom1, nom_us2, nom_dom2, fecha);
  	}
	
	
  	/**
     * Metodo que setea como Enviado un correo cuando se remite a su Destinatario
     * 1 - Enviado
     * 0 - No Enviado
     * @param fecha
     * @param Enviado
    */
	public void Set_Enviado(String fecha, boolean Enviado){
		this.correo.Set_Enviado(fecha, Enviado);
	}
	
	
   /* METODOS PARA LA CLASE DOMINIO*/
  	

	/** Método que cre un objeto dominio de la clase dominio
	 *@param dom es nombre del dominio
	 *@param priori es prioridad del dominio
	*/	
	public void NuevoDom (String dom, int priori){
		this.dominio = new Dominio(dom, priori);
	}
		
	
	/** Método de ingreso de datos del dominio a la BD
	 * @param nom es nombre del dominio
	 * @param prioridad es la prioridad del dominio
	 * @exception Exception
    */		
	public void InsertDom (String dom, int priori){
		this.NuevoDom(dom, priori);
		this.dominio.InsertRow();
	}
	
	
	/** Método para modificar la prioridad de un dominio
	 * @param nom es nombre del dominio
	 * @param prioridad es la prioridad del dominio
	 * @exception Exception
    */
	public void Modifica_prioridad (String nom, int prioridad){
			this.dominio.cambiar_prioridad(nom, prioridad);
		}

	
	/** Método que devuelve todos los datos de la tabla dominio
	 * @return Resulset con la tabla dominio
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet ConTablaDom() throws SQLException{
		java.sql.ResultSet rs;
		rs = dominio.Select_tabla();
		return rs;
	}
	
	
	/** Método que devuelve todos los datos de un dominio seleccionado
	 * @param dom es nombre de dominio
	 * @return Resulset con la fila correspondiente al dominio seleccionado
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet ConFilaDom(String dom) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.dominio.Select_fila(dom);
		return rs;
	}
	
	
	
/* METODOS PARA LA CLASE CUENTA */
	
	
	/** Método que crea un objeto cuenta
	 *@param id identificador del usuario propietario de la cuenta
	 *@param nom_us nombre de usuario
	 *@param nom_dom nombre de dominio
	 *@param pass clave de acceso
	 *@param es_lista indica si es lista de distribucion o no (si vale 0 no es lista, si vale 1 es lista).
	  
	*/
	
	public void Nueva_Cuenta (int id, String nom_us, String nom_dom, String pass, int es_lista){
		
		this.cuenta = new Cuenta(id,nom_us, nom_dom, pass, es_lista);
	}
	
	
     	
	/** Método de ingreso de datos de la cuenta a la BD
	*/
	
	public void InsertCuenta (int id, String nom_us, String nom_dom, String pass, int es_lista){
		this.Nueva_Cuenta(id,nom_us, nom_dom, pass, es_lista);
		this.cuenta.InsertRow();
	}
	
	
	/** Método para modificar el passwd de ingreso
	 *@param id identificador del usuario propietario de la cuenta
	 *@param nom_us nombre de usuario
	 *@param nom_dom nombre de dominio
	 *@param pass clave de acceso
	* @exception Exception
	*/
	public void Modifica_cuentaPS (int id, String nom_us, String nom_dom,String pass){
		this.cuenta.resetear_passwd(id,nom_us,nom_dom, pass);
	}
	
	
	
	
	public void Cambia_Psswd (String nom_us, String nom_dom,String pass){
		this.cuenta.cambiar_passwd(nom_us,nom_dom, pass);
	}
	
	
	/** Método que devuelve todos los datos de la tabla cuenta
	* @return Resulset con la tabla cuenta
	* @throws SQLException
	*/
	
	 public java.sql.ResultSet ConTablaCuenta() throws SQLException{
		java.sql.ResultSet rs;
		rs = this.cuenta.Select_Tabla();
		return rs;
	}
	
	
    /** Método que devuelve un Resulset con los registros de la cuenta de un usuario segun su id
	* @param id de usuario
	* @return Resulset con la tabla cuenta
	* @throws SQLException
	*/
	public java.sql.ResultSet ConTablaCuentaID(int id) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.cuenta.Select_Tabla_Id(id);
		return rs;
	} 
	
	
	/** Metodo que desabilita una cuenta de usuario
	 * 
	 * @param id
	 * @param nom_us
	 * @param nom_dom
	 * @param habilita
	 */
	
	public void deshabCuenta(int id, String nom_us, String nom_dom, boolean habilita){
		this.cuenta.habilitar_cuenta(id, nom_us, nom_dom, habilita);
   }

	
		
    /* METODOS PARA LA CLASE TELEFONO*/
	
	 /** Método que crea un objeto de la clase telfono
		 *@param id id de usuario
		 *@param tel telefono
	 */	
	public void NuevoTel (int id, String tel){
		this.telefono = new Telefono(id, tel);
		
	}
	
	
    /** Método de ingreso de telefonos a la BD
	 * @exception Exception
    */		
	public void InsertTel (int id, String tel){
		this.NuevoTel(id, tel);
		this.telefono.InsertRow();
	}
	
	
	/** Método que permite modificar los telefonos de una persona segun su id
     * @param id es el id de usuario
     * @param oldTel telefono anterior
     * @param newTel nuevo telefono
	 * @throws SQLException
	*/
	public void Modifica_tel (int id, String oldTel, String newTel){
		this.telefono.cambiar_telefonos(id,oldTel,newTel);
	}
	
	
	/** Método que devuelve todos los datos de la tabla telefonos
	 * @return Resulset con la tabla telefono
	 * @throws SQLException
	*/	
	public java.sql.ResultSet ConTablaTel() throws SQLException{ 
		java.sql.ResultSet rs;
		rs = this.telefono.Select_tabla();
		return rs;
	}
	
	
	/** Método que devuelve los telefonos de usuario segun el id de usuario seleccionado
	 * @return Resulset con los telefonos del usuario
	 * @throws SQLException
	*/	
	
	public java.sql.ResultSet ConFilaTel(int id) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.telefono.Select_fila(id);
		return rs;
	}
	
	
	/** Método para eliminar el registro de un telefono segun el id de usuario seleccionado
	    * @param id, id de usuario 
		* @throws SQLException
	*/
  	public void Eliminar_tels(int id) {  		
  		
  		this.telefono.eliminar_tels(id);
  	}
	
	
     /* METODOS PARA LA CLASE OFICINA*/
  	
  	
  	/** Método que crea un objeto de la clase telfono
	 *@param id id de usuario
	 *@param nom nombre de usuario
    */		
	public void NuevaOfi (int id, String nom){
		this.oficina = new Oficina(id, nom);
		
	}
	
	
	/** Método de ingreso de datos del grupo a la BD
	 *@param id id de usuario
	 *@param nom nombre de usuario
	 * @exception Exception
    */	
	
	public void InsertOfi (int id, String nom){
		this.NuevaOfi(id, nom);
		this.oficina.InsertRow();
	}
	
	
	/** Método para modificar el nombre del grupo u oficina
	 * @param id, es id de usuario
	 * @param nom nuevo nombre de oficina
	 * @exception Exception
    */
	
	public void Modifica_nom_ofi(int id, String nom){
		this.oficina.cambiar_nom_ofi(id,nom);
	}
	
	
	/** Método que devuelve todos los datos de la tabla oficina
	 * @return Resulset con la tabla oficina
	 * @throws SQLException
	*/	
	public java.sql.ResultSet ConTablaOfi() throws SQLException{
		java.sql.ResultSet rs;
		rs = this.oficina.Select_tabla();
		return rs;
	}
	
	
	/** Método que devuelve todos los datos de un grupo seleccionado
	 * @param id, id de usuario
	 * @return Resulset con la fila correspondiente al grupo seleccionado
	 * @throws SQLException
	*/	
	public java.sql.ResultSet ConFilaOfi(int id) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.oficina.Select_fila(id);
		return rs;
	}
	
	/**
	 * Trae todos los registros de la tabla Usuarios
	 * @return
	 * @throws SQLException
	 */
	public java.sql.ResultSet DevTodoUsuario() throws SQLException{
		Usuario user = new Usuario();
		java.sql.ResultSet rs;
		rs = user.TraeTodo(); 
		return rs;
	}
	
/**
 * Metodo para cambiar password admin
 * @param id
 * @param passwd
 */
	public void cambiaPassAdmin(int id, String passwd){
		Usuario user = new Usuario();
		user.cambiar_passwd(id, passwd);
	}
	
	/**
	 * Metodo para traer oficina
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public java.sql.ResultSet TraeOficina(int id) throws SQLException{
		Usuario user = new Usuario();
		java.sql.ResultSet rs;
		rs =user.TraeOficina(id);
		return rs;
	}
	
	/**
	 * Metodo para habilitar o deshabilitar Oficina o grupo
	 * @param id
	 * @param habilita
	 */
	public void habilitaOficina(int id, boolean habilita){
		Cuenta c = new Cuenta();
		c.habilitar_cuenta(id, habilita);
	}
	
	
	public void ResetPassOfi(int id){
		Cuenta c = new Cuenta();
		c.ResetearPassOficina(id);
	}

}// fin clase FachadaBD


