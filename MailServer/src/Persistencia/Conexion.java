package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;

public class Conexion { 

	private static Connection Conn = null;
	private static Conexion Instancia = null;
	
	
	private Conexion(){
		getConexion();
	}
	
	public static Conexion getInstancia(){
		if (Instancia == null){
			Instancia = new Conexion();
		}
		return Instancia;
	}
	
	public Connection getConexion() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Servidor_Mail", "AM", "adrian");
			//System.out.println("conexion exitosa");
		} catch (Exception e) {
			Conn=null;
			System.out.println("Error al conectar puta madre");
		}
		
		return Conn;
	}
	
	
	public void closeConextion() {
			try {
				Conn.close();
				System.out.println("Se deconecto la base");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("No se pudo cerrar la conexion");
			}
		}
	
}

