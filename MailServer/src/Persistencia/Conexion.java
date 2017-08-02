package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Clase Singleton que realiza la conexion al sistema gestor de base de datos SQL Server.
 * @author 
 * @version 1.0
*/ 

public class Conexion { 

	private static Connection Conn = null;
	private static Conexion Instancia = null;
	
	
	/** Método constructor de la clase conexion.
	 *
	*/
	
	private Conexion(){
		getConexion();
	}
	
	/** Método para instanciar la clase conexion
	 @return instancia de conexion a la BD  */
	
	public static Conexion getInstancia(){
		if (Instancia == null){
			Instancia = new Conexion();
		}
		return Instancia;
	}
	
	/** Método que realiza la conexion a la BD
	 @return la conexion establecida o nula  */
	
	public Connection getConexion() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Servidor_Mail", "sa", "admin");
			} catch (Exception e) {
			Conn=null;
		   }
		
		return Conn;
	}
	
	
	/** Método para finalizar la conexion a la base de datos
    * @return conexion cerrada o excepcion si no se puede completar la accion
	* @exception SQLException  
	*/
	
	public void closeConextion() {
			try {
				Conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
	
}

