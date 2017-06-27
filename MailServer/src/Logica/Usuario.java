package Logica;
import java.sql.ResultSet;
import java.sql.SQLException;

import Persistencia.FachadaBD;
/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Usuario {
	
//	private Date fecha_alta;
	private int id_usuario;
	private String pass_admin;
	private String ci;
	private String nombre;
	private String apellido;
	private String calle;
	private String nro_puerta;
	private String apto;
	
	private Cuentas cuentas;
	private Perfiles prefiles;
	
	private Telefonos tels;
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	public Usuario(){
		
	}
	
	/** M�todo constructor de la clase para usuario <u><b>com�n</b></u>.
	 * Carga el usuario persona en la Base de Datos
	 * @param id_usuario Identificador del usuario.
	 * @param ci Cedula del usuario.
	 * @param nombre Nombre del usuario.
	 * @param apellido Apellido del usuario.
	 * @param calle Nombre de calle de la direcci�n del usuario.
	 * @param nro_puerta N�mero de puerta de la direcci�n del usuario.
	 * @param apto N�mero de apartamento de la direcci�n del usuario.  */
	public Usuario(int id, String ci, String nombre, String apellido, 
			String calle, String nro_puerta, String apto) {
		this.id_usuario = id;
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
		this.calle = calle;
		this.nro_puerta = nro_puerta;
		this.apto = apto;
		this.cuentas = new Cuentas();
		this.prefiles = new Perfiles();
		this.tels = new Telefonos();
		String tipo = "usuario";
		BD.InsertPer(id, ci, nombre, apellido, calle, nro_puerta, apto);
		BD.Insert_TPerfil(id, tipo); // VER si lo hacemos asi
	}
	
	
	/** M�todo constructor de la clase para usuario <u><b>oficina</b></u>.
	 * Carga el usuario Grupo u Oficina en la Base de datos
	 * @param id_usuario Identificador del usuario.
	 * @param nombre Nombre del usuario.  */
	public Usuario(int id_usuario, String nombre) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		//this.cuentas = new Cuentas(); // No comprendo bien que hacemos aca
		//this.prefiles = new Perfiles(); // No entiendo para que una coleccion de perfiles dentro de usuario //ADRIAN
		BD.InsertOfi(id_usuario, nombre);
		BD.Insert_TPerfil(id_usuario, "usuario"); // VER si lo hacemos asi
	}
	
	/** M�todo constructor de la clase para usuario <u><b>administrador</b></u>.
	 * @param nom_usuario nombre de usuario administrador.
	 * @param contrase�a_admin contrase�a de usuario administrador.
	 * @param ci cedula del usuario. */
	public Usuario(int id_usuario, String pass_admin, String ci, String nombre, 
			String apellido, String calle, String nro_puerta, String apto) {
		this.id_usuario = id_usuario;
		this.pass_admin = pass_admin;
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
		this.calle = calle;
		this.nro_puerta = nro_puerta;
		this.apto = apto;
		//this.cuentas = new Cuentas(); //No comprendo de que nos sirve esto
		//this.prefiles = new Perfiles();  // No entiendo para que una coleccion de perfiles dentro de usuario //ADRIAN
		//BD.InserUS(pass_admin);
		BD.InsertPer(id_usuario, ci, nombre, apellido, calle, nro_puerta, apto);
		
	}
	
	/**
	 * Metodo que genera en la tabla usuario un registro vacio y devuelve el ID para poder ingresar 
	 * el usuario en la tabla correspondiente, ejempo persona, grupo o administrador
	 * @return id (int) Ultimo id cargado en tabla Usuario
	 * @throws SQLException
	 */
	public int InstertaUserDevuelveId(String pass) throws SQLException{
		BD.InserUS(pass);
		java.sql.ResultSet rs = BD.ConUltimoID();
		rs.next();
		int id = rs.getInt(1);
		return id;
		//return 7;
	}
	
	/** M�todo que retorna el identificador del usuario.
	 * @return Identificador del usuario. */
	public int getId_usuario() {
		return id_usuario;
	}
	
	/** M�todo que retorna la contrase�a de un usuario administrador.
	 * @return Contrase�a de un usuario administrador. */
	public String getPass_admin() {
		return pass_admin;
	}
	
	/** M�todo que retorna la c�dula del usuario.
	 * @return C�dula de un usuario. */
	public String getCi() {
		return ci;
	}
	
	/** M�todo que retorna el nombre del usuario.
	 * @return Nombre del usuario. */
	public String getNombre() {
		return nombre;
	}
	
	/** M�todo que retorna el apellido del usuario.
	 * @return Apellido del usuario. */
	public String getApellido() {
		return apellido;
	}
	
	/** M�todo que retorna el nombre de calle de la direcci�n del usuario.
	 * @return Nombre de calle de la direcci�n del usuario. */
	public String getCalle() {
		return calle;
	}
	
	/** M�todo que retorna el n�mero de puerta de la direcci�n del usuario.
	 * @return N�mero de puerta de la direcci�n del usuario. */
	public String getNro_puerta() {
		return nro_puerta;
	}
	
	/** M�todo que retorna el n�mero de apartamento de la direcci�n del usuario.
	 * @return N�mero de apartamento de la direcci�n del usuario. */
	public String getApto() {
		return apto;
	}

	/** M�todo que retorna las cuentas del usuario.
	 * @return Cuentas del usuario. */
	public Cuentas getCuentas() {
		return cuentas;
	}
	
	/** M�todo que retorna los perfiles del usuario.
	 * @return Perfiles del usuario. */
	public Perfiles getPrefiles() {
		return prefiles;
	}
	
	/** M�todo para modificar la constrase�a de un usuario administrador.
	 * @param pass_admin Nueva contrase�a.
	 * @return No retorna nada. */
	public void setPass_admin(String pass_admin) {
		this.pass_admin = pass_admin;
	}
	
	/** M�todo para modificar el nombre del usuario.
	 * @param nombre Nuevo nombre.
	 * @return No retorna nada. */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/** M�todo para modificar el apellido del usuario.
	 * @param apellido Nuevo apellido.
	 * @return No retorna nada. */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/** M�todo para modificar el nombre de calle de la direcci�n del usuario.
	 * @param calle Nuevo nombre de calle de la direcci�n del usuario.
	 * @return No retorna nada. */
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	/** M�todo para modificar el nombre de calle de la direcci�n del usuario.
	 * @param nro_puerta Nuevo n�mero de puerta de la direcci�n del usuario.
	 * @return No retorna nada. */
	public void setNro_puerta(String nro_puerta) {
		this.nro_puerta = nro_puerta;
	}
	
	/** M�todo para modificar el n�mero de apartamento de la direcci�n del usuario.
	 * @param apto Nuevo n�mero de apartamento de la direcci�n del usuario.
	 * @return No retorna nada. */
	public void setApto(String apto) {
		this.apto = apto;
	}
	
	/** M�todo que modifica las cuentas del usuario.
	 * @param cuentas Nueva colecci�n de cuentas.
	 * @return No retorna nada. */
	public void setCuentas(Cuentas cuentas) {
		this.cuentas = cuentas;
	}
	
	/** M�todo que modifica los perfiles del usuario.
	 * @param prefiles Nueva colecci�n de perfiles.
	 * @return No retorna nada. */
	public void setPrefiles(Perfiles prefiles) {
		this.prefiles = prefiles;
	}

	
	public void autentica(String usuario, String pass){
		
	}
	
	public Usuario cargaDesdeBD(int id_usuario, String pass_admin) throws SQLException{
		Usuario usu = new Usuario();
		//System.out.println("Persona " + id_usuario);
		//Se crea Resultset(rs) de la persona correspondiente a id_usuario
		ResultSet rs = BD.ConFilaPer(id_usuario);
		
		if(!pass_admin.equals(null)){
			//System.out.println("ES UN ADMIN " + pass_admin);
			usu.pass_admin = pass_admin;
		}
		
		while (rs.next()){
			if(!rs.wasNull()){
				//Si el rs no es null entonces es una persona y se cargan los datos de persona.
				usu.id_usuario = rs.getInt("id_usuario");
				//System.out.println("Persona\n " + rs.getInt("cedula"));
				usu.ci = String.valueOf(rs.getInt("cedula"));
				//System.out.println("Persona\n " + rs.getString("nombre"));
				usu.nombre = rs.getString("nombre");
				//System.out.println("Persona\n " + rs.getString("apellido"));
				usu.apellido = rs.getString("apellido");
				//System.out.println("Persona\n " + rs.getString("calle"));
				usu.calle = rs.getString("calle");
				//System.out.println("Persona\n " + rs.getString("nro_puerta"));
				usu.nro_puerta = rs.getString("nro_puerta");
				//System.out.println("Persona\n " + rs.getString("apto"));
				usu.apto = rs.getString("apto");
				
			}
			else{
				//El rs es null entonces es una oficina y se carga el nombre de la oficina.
				rs = BD.ConFilaOfi(usu.id_usuario);
				
				usu.id_usuario = rs.getInt("id_usuario");
				usu.nombre = rs.getString("nombre");
			}
		}
		
		return usu;
	}
}
