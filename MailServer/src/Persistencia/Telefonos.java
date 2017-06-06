package Persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

public class Telefonos {

	
	private int id_usuario;
	private String telefono;
	private Conexion pruebaConn = Conexion.getInstancia();
	
	public Telefonos(int id, String tel){
		
		this.id_usuario = id;
		this.telefono = tel;	
	}
	
	
	/* Metodo de ingreso de datos a la base */
	
	public void InsertRow(){
		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Telefono values ('"+id_usuario+"','"+telefono+"')");
			}
			catch (Exception e){
				
			}
			pruebaConn.closeConextion();
		}else{
			System.out.println("Desconectado");
		}
	}
	
	/* metodo para cargar un resulset con lo datos de la tabla */
	
	public java.sql.ResultSet SelectRow() throws SQLException{
		
		String seleccion = "Select * from Telefono";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		pruebaConn.closeConextion();
		
		return rs;
		
	}
	
	
}

