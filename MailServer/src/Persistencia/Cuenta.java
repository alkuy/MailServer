package Persistencia;

import java.sql.SQLException;

/** Clase para ABM de los datos de una cuenta en la BD.
 * @author 
 * @version 1.0
*/ 


public class Cuenta {

	
	private int id_usuario;
	private String nom_usuario;
	private String nom_dominio;
	private String password;
	private int es_lista;
	private int habilitado;
	
	
	private Conexion pruebaConn = Conexion.getInstancia();
	
	/** Método constructor de la clase cuenta - vacio.
	 *
	*/
	
	public Cuenta(){}
	
	
	
	/** Método constructor de la clase cuenta
	 *@param id identificador del usuario propietario de la cuenta
	 *@param nom_us nombre de usuario
	 *@param nom_dom nombre de dominio
	 *@param pass clave de acceso
	 *@param es_lista indica si es lista de distribucion o no (si vale 0 no es lista, si vale 1 es lista).
	  
	*/
	
	public Cuenta(int id, String nom_us, String nom_dom, String pass, int es_lista){
		
		this.id_usuario = id;
		this.nom_usuario = nom_us;
		this.nom_dominio = nom_dom;
		this.password = pass;
		this.es_lista = es_lista;
		this.habilitado = 1; // se pone en uno que es el predeterminado cuando se crea
	}
	
	
	
	/** Método de ingreso de datos de la cuenta a la BD
	*/
	
	public void InsertRow(){
		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Cuenta values ('"+id_usuario+"','"+nom_usuario+"','"+nom_dominio+"','"+password+"', '"+es_lista+"' ,CURRENT_TIMESTAMP, '"+habilitado+"')");
				
			}
			catch (Exception e){
				
			}
			
		}else{}
		
	} // fin InsertRow
	
	
	
	
	/** Método que devuelve todos los datos de la tabla cuenta
	 * @return Resulset con la tabla cuenta
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet Select_Tabla() throws SQLException{
		
		String seleccion = "Select * from Cuenta";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	
	
	
	
	/** Método que devuelve todos los datos de una cuenta seleccionada segun su id
	 * @return Resulset con la fila correspondiente a la cuenta seleccionada
	 * @throws SQLException
	    */
	
	public java.sql.ResultSet Select_Tabla_Id(int id) throws SQLException{
		
		String seleccion = "Select * from Cuenta where id_usuario ='"+id+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	

	
	/** Método para modificar el passwd de ingreso
	 *@param id identificador del usuario propietario de la cuenta
	 *@param nom_us nombre de usuario
	 *@param nom_dom nombre de dominio
	 *@param pass clave de acceso
	* @exception Exception
	*/

  public void cambiar_passwd(int id, String nom_us, String nom_dom, String passwd) {
	
	
	try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Cuenta SET password = '"+passwd+"'" + "where id_usuario = '"+id+"' AND nom_usuario = '"+nom_us+"' AND nom_dominio = '"+nom_dom+"'");
    }
	catch (Exception e){
		//System.out.println("no se pudo modificar el passwd");
	}
	
  }



  
    /**
    * Metodo para habilitar o deshabilitar una cuenta
    * 1 - Habilitada
    * 0 - Deshabilitada
    * @param id
    * @param nom_us
    * @param nom_dom
    * @param habilita
    */
    public void habilitar_cuenta(int id, String nom_us, String nom_dom, boolean habilita){
	
	  try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Cuenta SET habilitada = '"+habilita+"'" + "where id_usuario = '"+id+"' AND nom_usuario = '"+nom_us+"' AND nom_dominio = '"+nom_dom+"'");
      }catch (Exception e){}
	
    }
    
    
  
    /**
    * Metodo que habilita o deshabilita todas las cuentas de ese usuario
    * @param id
    * @param habilita
    */
    public void habilitar_cuenta(int id, boolean habilita){
	
	 try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Cuenta SET habilitada = '"+habilita+"'" + "where id_usuario = '"+id+"';");
     }catch (Exception e){}
	
    }
    
    
    public void ResetearPassOficina(int id){
    	 try{
    			java.sql.Statement stm = pruebaConn.getConexion().createStatement();
    			stm.execute("UPDATE Cuenta SET password = '1234' where id_usuario = '"+id+"';");
    	     }catch (Exception e){}
    		
    }
	

	
}// fin clase Cuenta


