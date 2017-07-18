package Persistencia;


import java.sql.SQLException;


/** Clase para ABM de los telefonos de una persona en la BD
 * @author 
 * @version 1.0
*/ 

public class Telefono {

	
	private int id_usuario;
	private String telefono;
	private Conexion pruebaConn = Conexion.getInstancia();
	
	public Telefono(int id, String tel){
		
		this.id_usuario = id;
		this.telefono = tel;	
	}
	

	
	/** Método constructor de la clase telefono - vacio.
	 *
	*/	
	public Telefono (){};
	
	
	 /** Método constructor de la clase telefono
	 *@param id id de usuario
	 */	
	
    public Telefono(int id){
		
		this.id_usuario = id;		
	}
    
    
    
	
    /** Método de ingreso de telefonos a la BD
	 * @exception Exception
    */	
	public void InsertRow(){
		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Telefono values ('"+id_usuario+"','"+telefono+"')");
			}
			catch (Exception e){
				
			}
		}else{}
	}
	
	
	/** Método que devuelve todos los datos de la tabla telefonos
	 * @return Resulset con la tabla telefono
	 * @throws SQLException
	*/
	public java.sql.ResultSet Select_tabla() throws SQLException{
		
		String seleccion = "Select * from Telefono";		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	
	
	
	/** Método que devuelve los telefonos de usuario segun el id de usuario seleccionado
	 * @return Resulset con los telefonos del usuario
	 * @throws SQLException
	*/		
    public java.sql.ResultSet Select_fila(int id) throws SQLException{
		
		String seleccion = "Select * from Telefono where id_usuario ='"+id+"'";		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;		
	  }


    /** Método que permite modificar los telefonos de una persona segun su id
     * @param id es el id de usuario
     * @param oldTel telefono anterior
     * @param newTel nuevo telefono
	 * @throws SQLException
	*/
    public void cambiar_telefonos(int id, String oldTel, String newTel) {
	
	
	   try{
		   java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		   stm.execute("UPDATE Telefono SET telefono = '"+newTel+"'" + "where id_usuario = '"+id+"'" + " and " + "telefono = "+oldTel);
       }catch (Exception e){}	
	
     }


    /** Método para eliminar el registro de un telefono segun el id de usuario seleccionado
    * @param id, id de usuario 
	* @throws SQLException
	*/
   public void eliminar_tels(int id) {
	
	 try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("DELETE from Telefono where id_usuario = '"+id+"';");
      }catch (Exception e){}
    }
	
	
	
	
}// fin clase Telefono

