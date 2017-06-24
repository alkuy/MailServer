package Persistencia;

import java.sql.SQLException;


public class Perfil {

	
	private String tipo;
	private Conexion pruebaConn = Conexion.getInstancia();
	
	
	public Perfil(){}	
	
	public Perfil(String tipo){
				
		this.tipo = tipo;	
	}
	
   
	public void InsertRow(){
		
		
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Perfil values ('"+tipo+"')");
				
			}
			catch (Exception e){
				System.out.println("aca la cago");
			}
		//	pruebaConn.closeConextion();
		}else{
			System.out.println("Desconectado");
		}
	}
	
	/* metodo para cargar un resulset con lo datos de la tabla */
	
	public java.sql.ResultSet Select_tabla() throws SQLException{
		
		String seleccion = "Select * from Perfil";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
	//	pruebaConn.closeConextion();
		
		return rs;
		
	}
	
	/* metodo para cargar un resulset con lo datos de un registro seleccionado */
	
public java.sql.ResultSet Select_fila(String tipo) throws SQLException{
		
		String seleccion = "Select * from Perfil where tipo ='"+tipo+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		
		//pruebaConn.closeConextion();
		
		return rs;
		
	}


/* Metodo para eliminar un registro de la tabla Perfil */


	public void Eliminar_perfil(String tipo) {
		
		try{
			java.sql.Statement stm = pruebaConn.getConexion().createStatement();
			stm.execute("DELETE from Perfil where tipo = '"+tipo+"';");
	  }
		catch (Exception e){
			System.out.println("no se pudo eliminar el registro");
		}
		
		
	}
	
}


