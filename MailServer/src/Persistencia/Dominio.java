package Persistencia;

import java.sql.SQLException;

/** Clase para cargar los datos de un dominio a la BD y devolverlo de ella.
 * @author 
 * @version 1.0
*/ 


public class Dominio {

	
	private String nom_dominio;
	private int prioridad;
	private Conexion pruebaConn = Conexion.getInstancia();
	
	
	/** Método constructor de la clase dominio - vacio.
	 *
	*/
	
	public Dominio(){}
	
	
	/** Método constructor de la clase dominio
	 *@param nom_dominio nombre del dominio
	 *@param prioridad del dominio
	*/
	
	public Dominio(String nom_dominio, int prioridad){
				
		this.nom_dominio = nom_dominio;	
		this.prioridad = prioridad;
	}
	
	
	
	/** Método de ingreso de datos del dominio a la BD
	 * @exception Exception
    */	
	
   	public void InsertRow(){
		
		
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Dominio (nom_dominio, prioridad) values ('"+nom_dominio+"', '"+prioridad+"')");
				
						
			}
			catch (Exception e){
				
			}
		}else{}
	}
	
   	
   	
   	/** Método que devuelve todos los datos de la tabla dominio
	 * @return Resulset con la tabla dominio
	 * @throws SQLException
	*/
   	
	public java.sql.ResultSet Select_tabla() throws SQLException{
		
		String seleccion = "Select * from Dominio";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	
	
	
	/** Método que devuelve todos los datos de un dominio seleccionado
	 * @param dom es nombre de dominio
	 * @return Resulset con la fila correspondiente al dominio seleccionado
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet Select_fila(String nom_dominio) throws SQLException{
		
		String seleccion = "Select * from Dominio where nom_dominio ='"+nom_dominio+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		
				
		return rs;
		
	}
    
    

	/** Método para modificar la prioridad de un dominio
	 * @param nom es nombre del dominio
	 * @param prioridad es la prioridad del dominio
	 * @exception Exception
    */

    public void cambiar_prioridad(String nom, int prioridad) {
	
	
	  try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Dominio SET prioridad = '"+prioridad+"'" + "where nom_dominio = '"+nom+"';");
      }catch (Exception e){}
	}


	
}// fin clase Dominio

