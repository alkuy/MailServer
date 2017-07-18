package Persistencia;


import java.sql.SQLException;

/** Clase para ABM de los datos de una persona en la BD
 * @author 
 * @version 1.0
*/ 


public class Persona {

	
	private int id_usuario;
	private String ci;
	private String nombre;
	private String apellido;
	private String calle;
	private String nro_puerta;
	private String apto;
	
	private Conexion pruebaConn = Conexion.getInstancia();
	
	
	/** Método constructor de la clase persona - vacio.
	 *
	*/	
	 public Persona(){}
	 
	 
	 /** Método constructor de la clase dominio
		 *@param id id de usuario
		 *@param ced cedula de la persona
		 *@param nom nombre de la persona
		 *@param apellido apellido de la persona
		 *@param calle calle donde vive la persona
		 *@param nro numero de puerta
		 *@param apto numero de apartmento
	*/	
	 public Persona(int id, String ced, String nom, String apellido, String calle, String nro, String apto){
		
		this.id_usuario = id;
		this.ci = ced;
		this.nombre = nom;
		this.apellido = apellido;
		this.calle = calle;
		this.nro_puerta = nro;
		this.apto = apto;
	  }
	

	 /** Método de ingreso de datos de la persona a la BD
		 * @exception Exception
	 */	

	 public void InsertRow(){		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Persona values ('"+id_usuario+"','"+ci+"','"+nombre+"','"+apellido+"', '"+calle+"', '"+nro_puerta+"','"+apto+"')");
			}
			catch (Exception e){
				
			}
		
		}else{}
			
	  }
	
	
		
	/** Método que devuelve todos los datos de la tabla persona
	 * @return Resulset con la tabla persona
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet Select_Tabla() throws SQLException{
		
		String seleccion = "Select * from Persona";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	
	
	/** Método que devuelve el id de usuario segun la cedula ingresada
	 * @return Resulset con el id de usuario
	 * @throws SQLException
	*/	
	public java.sql.ResultSet Dev_id(String ced) throws SQLException{
		
		String seleccion = "Select id_usuario from Persona where cedula ='"+ced+"'";
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);				
		return rs;
		
	}
	
	
	/** Método que devuelve la c.i de usuario segun su id
	 * @return Resulset con la c.i de usuario
	 * @throws SQLException
	*/		
	public java.sql.ResultSet Dev_ci(int id) throws SQLException{
		
		String seleccion = "Select cedula from Persona where id_usuario ='"+id+"'";		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);		
		return rs;
		
	}
	
	
	
	/** Método que devuelve todos los datos de una Persona seleccionada
	 * @param id , id de usuario
	 * @return Resulset con la fila correspondiente a la persona seleccionada
	 * @throws SQLException
	*/	
    public java.sql.ResultSet Select_fila(int id) throws SQLException{
		
		String seleccion = "Select * from Persona where id_usuario ='"+id+"'";		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	  }

    
    
    /** Método para modificar los datos de una persona
	 * @exception Exception
    */
    public void cambiar_datos_personales(String ci, String nom, String ap, String calle, String nro, String apart) {
	
	 try{
		 java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		 stm.execute("UPDATE Persona SET nombre = '"+nom+"', apellido = '"+ap+"', calle = '"+calle+"', nro_puerta = '"+nro+"', apto = '"+apart+"'" + "where cedula = '"+ci+"';");
      }catch (Exception e){}	
	
    }
   
   
	
}// fin clase Persona


