package Persistencia;


import java.sql.SQLException;


public class Persona {

	
	private int id_usuario;
	private String ci;
	private String nombre;
	private String apellido;
	private String calle;
	private String nro_puerta;
	private String apto;
	
	private Conexion pruebaConn = Conexion.getInstancia();
	
	public Persona(int id, String ced, String nom, String apellido, String calle, String nro, String apto){
		
		this.id_usuario = id;
		this.ci = ced;
		this.nombre = nom;
		this.apellido = apellido;
		this.calle = calle;
		this.nro_puerta = nro;
		this.apto = apto;
	}
	
	
    public Persona(){}
    
    
    
    	
	/**
	 * @return the ci
	 */
	public String getCi() {
		return ci;
	}


	/**
	 * @param ci the ci to set
	 */
	public void setCi(String ci) {
		this.ci = ci;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}


	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}


	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}


	/**
	 * @return the nro_puerta
	 */
	public String getNro_puerta() {
		return nro_puerta;
	}


	/**
	 * @param nro_puerta the nro_puerta to set
	 */
	public void setNro_puerta(String nro_puerta) {
		this.nro_puerta = nro_puerta;
	}


	/**
	 * @return the apto
	 */
	public String getApto() {
		return apto;
	}


	/**
	 * @param apto the apto to set
	 */
	public void setApto(String apto) {
		this.apto = apto;
	}
	
	/**
	 * @return the id_usuario
	 */
	public int getId_usuario() {
		return id_usuario;
	}


	/**
	 * @param id_usuario the id_usuario to set
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}


	
	/* Metodo de ingreso de datos a la base */

	


	public void InsertRow(){
		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Persona values ('"+id_usuario+"','"+ci+"','"+nombre+"','"+apellido+"', '"+calle+"', '"+nro_puerta+"','"+apto+"')");
			}
			catch (Exception e){
				
			}
		
		}else{
			System.out.println("Desconectado");
		}
	}
	
	/* metodo para cargar un resulset con lo datos de la tabla */
	
	public java.sql.ResultSet Select_Tabla() throws SQLException{
		
		String seleccion = "Select * from Persona";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	
	
/* metodo para devolver el id de usuario en base a la cedula ingresada */
	
	public java.sql.ResultSet Dev_id(String ced) throws SQLException{
		
		String seleccion = "Select id_usuario from Persona where cedula ='"+ced+"'";
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);				
		return rs;
		
	}
	
	
/* metodo para devolver la c.i de usuario en base a su id */
	
	public java.sql.ResultSet Dev_ci(int id) throws SQLException{
		
		String seleccion = "Select cedula from Persona where id_usuario ='"+id+"'";		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);		
		return rs;
		
	}
	
	
	
	/* metodo para cargar un resulset con lo datos de un registro seleccionado */
	
public java.sql.ResultSet Select_fila(int id) throws SQLException{
		
		String seleccion = "Select * from Persona where id_usuario ='"+id+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}

// Metodo que permite modificar los datos personales de la persona en la base de datos.
   public void cambiar_datos_personales(String ci, String nom, String ap, String calle, String nro, String apart) {
	
	
	try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Persona SET nombre = '"+nom+"', apellido = '"+ap+"', calle = '"+calle+"', nro_puerta = '"+nro+"', apto = '"+apart+"'" + "where cedula = '"+ci+"';");
  }	
	catch (Exception e){
		System.out.println("no se pudo modificar el passwd");
	}	
	
  }
   
   
   /* Metodo para eliminar un registro de la tabla Persona*/


   public void eliminar_persona(int id) {
   	
   	
   	try{
   		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
   		stm.execute("DELETE from Persona where id_usuario = '"+id+"';");
     }
   	catch (Exception e){
   		System.out.println("no se pudo eliminar la persona");
   	}
   	
   	
   }
	
	
}


