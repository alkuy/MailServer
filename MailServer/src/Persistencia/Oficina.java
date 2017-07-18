package Persistencia;


import java.sql.SQLException;


/** Clase para cargar los datos de un correo de oficina a la BD y devolverlo de ella.
 * @author 
 * @version 1.0
*/ 

public class Oficina {

	
	private int id_usuario;
	private String nombre;
	private Conexion pruebaConn = Conexion.getInstancia();
	
	
	/** Método constructor de la clase oficina - vacio.
	 *
	*/	
	public Oficina(){}	
	
	
	/** Método constructor de la clase oficina
	 *@param id id de usuario
	 *@param nom nombre de usuario de grupo u oficina
	*/		
	public Oficina(int id, String nom){
	
	this.id_usuario = id;
	this.nombre = nom;	
    }
	
	
	/** Método de ingreso de datos del grupo a la BD
	 * @exception Exception
    */	
  	
	public void InsertRow(){
		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Oficina values ('"+id_usuario+"','"+nombre+"')");
			}
			catch (Exception e){}
			
		}else{}
	}
	
	
	
	
	/** Método que devuelve todos los datos de la tabla oficina
	 * @return Resulset con la tabla oficina
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet Select_tabla() throws SQLException{
		
		String seleccion = "Select * from Oficina";		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	


	/** Método que devuelve todos los datos de un grupo seleccionado
	 * @param id, id de usuario
	 * @return Resulset con la fila correspondiente al grupo seleccionado
	 * @throws SQLException
	*/
	public java.sql.ResultSet Select_fila(int id) throws SQLException{
		
		String seleccion = "Select * from Oficina where id_usuario ='"+id+"'";		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	
	
	/** Método para modificar el nombre del grupo u oficina
	 * @param id, es id de usuario
	 * @param nombre nuevo nombre de oficina
	 * @exception Exception
    */

   public void cambiar_nom_ofi(int id, String nombre) {
	
	
	try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Oficina SET nombre = '"+nombre+"'" + "where id_usuario = '"+id+"';");
    }catch (Exception e){}
	
	
   }



}// fin Clase Oficina

