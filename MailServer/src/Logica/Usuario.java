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
	
	/** M�todo constructor de la clase para usuario <u><b>com�n</b></u>.
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
		BD.InsertPer(id, ci, nombre, apellido, calle, nro_puerta, apto);
	}
	
	
	/** M�todo constructor de la clase para usuario <u><b>oficina</b></u>.
	 * @param id_usuario Identificador del usuario.
	 * @param nombre Nombre del usuario.  */
	public Usuario(int id_usuario, String nombre) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.cuentas = new Cuentas();
		this.prefiles = new Perfiles();
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
}
