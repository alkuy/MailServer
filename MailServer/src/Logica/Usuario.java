package Logica;
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
	//prueba commit2
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	public Usuario(){
		
	}
	
	/** Método constructor de la clase para usuario <u><b>común</b></u>.
	 * @param id_usuario Identificador del usuario.
	 * @param ci Cedula del usuario.
	 * @param nombre Nombre del usuario.
	 * @param apellido Apellido del usuario.
	 * @param calle Nombre de calle de la dirección del usuario.
	 * @param nro_puerta Número de puerta de la dirección del usuario.
	 * @param apto Número de apartamento de la dirección del usuario.  */
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
		BD.InsertPer(id, ci, nombre, apellido, calle, nro_puerta, apto);
	}
	
	
	/** Método constructor de la clase para usuario <u><b>oficina</b></u>.
	 * @param id_usuario Identificador del usuario.
	 * @param nombre Nombre del usuario.  */
	public Usuario(int id_usuario, String nombre) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.cuentas = new Cuentas();
		this.prefiles = new Perfiles();
	}
	
	/** Método constructor de la clase para usuario <u><b>administrador</b></u>.
	 * @param nom_usuario nombre de usuario administrador.
	 * @param contraseña_admin contraseña de usuario administrador.
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
		this.cuentas = new Cuentas();
		this.prefiles = new Perfiles();
	}
	
	public int InstertaUserDevuelveIdCargaPersona() throws SQLException{
		BD.InserUS(null);
		java.sql.ResultSet rs = BD.ConUltimoID();
		rs.next();
		int id = rs.getInt(1);
		return id;
		//return 7;
	}
	
	/** Método que retorna el identificador del usuario.
	 * @return Identificador del usuario. */
	public int getId_usuario() {
		return id_usuario;
	}
	
	/** Método que retorna la contraseña de un usuario administrador.
	 * @return Contraseña de un usuario administrador. */
	public String getPass_admin() {
		return pass_admin;
	}
	
	/** Método que retorna la cédula del usuario.
	 * @return Cédula de un usuario. */
	public String getCi() {
		return ci;
	}
	
	/** Método que retorna el nombre del usuario.
	 * @return Nombre del usuario. */
	public String getNombre() {
		return nombre;
	}
	
	/** Método que retorna el apellido del usuario.
	 * @return Apellido del usuario. */
	public String getApellido() {
		return apellido;
	}
	
	/** Método que retorna el nombre de calle de la dirección del usuario.
	 * @return Nombre de calle de la dirección del usuario. */
	public String getCalle() {
		return calle;
	}
	
	/** Método que retorna el número de puerta de la dirección del usuario.
	 * @return Número de puerta de la dirección del usuario. */
	public String getNro_puerta() {
		return nro_puerta;
	}
	
	/** Método que retorna el número de apartamento de la dirección del usuario.
	 * @return Número de apartamento de la dirección del usuario. */
	public String getApto() {
		return apto;
	}

	/** Método que retorna las cuentas del usuario.
	 * @return Cuentas del usuario. */
	public Cuentas getCuentas() {
		return cuentas;
	}
	
	/** Método que retorna los perfiles del usuario.
	 * @return Perfiles del usuario. */
	public Perfiles getPrefiles() {
		return prefiles;
	}
	
	/** Método para modificar la constraseña de un usuario administrador.
	 * @param pass_admin Nueva contraseña.
	 * @return No retorna nada. */
	public void setPass_admin(String pass_admin) {
		this.pass_admin = pass_admin;
	}
	
	/** Método para modificar el nombre del usuario.
	 * @param nombre Nuevo nombre.
	 * @return No retorna nada. */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/** Método para modificar el apellido del usuario.
	 * @param apellido Nuevo apellido.
	 * @return No retorna nada. */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/** Método para modificar el nombre de calle de la dirección del usuario.
	 * @param calle Nuevo nombre de calle de la dirección del usuario.
	 * @return No retorna nada. */
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	/** Método para modificar el nombre de calle de la dirección del usuario.
	 * @param nro_puerta Nuevo número de puerta de la dirección del usuario.
	 * @return No retorna nada. */
	public void setNro_puerta(String nro_puerta) {
		this.nro_puerta = nro_puerta;
	}
	
	/** Método para modificar el número de apartamento de la dirección del usuario.
	 * @param apto Nuevo número de apartamento de la dirección del usuario.
	 * @return No retorna nada. */
	public void setApto(String apto) {
		this.apto = apto;
	}
	
	/** Método que modifica las cuentas del usuario.
	 * @param cuentas Nueva colección de cuentas.
	 * @return No retorna nada. */
	public void setCuentas(Cuentas cuentas) {
		this.cuentas = cuentas;
	}
	
	/** Método que modifica los perfiles del usuario.
	 * @param prefiles Nueva colección de perfiles.
	 * @return No retorna nada. */
	public void setPrefiles(Perfiles prefiles) {
		this.prefiles = prefiles;
	}

	
	public void autentica(String usuario, String pass){
		
	}
}
