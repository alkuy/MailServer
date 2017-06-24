package Persistencia;

import java.sql.SQLException;


public class Tiene_perfil {

	
	private int id_usuario;
	private String tipo;
	private Conexion pruebaConn = Conexion.getInstancia();
	
	
	public Tiene_perfil(){}	
	
	public Tiene_perfil(int id, String tipo){
		
		this.id_usuario = id;
		this.tipo = tipo;	
	}
	
	
public Tiene_perfil(int id){
		
		this.id_usuario = id;
		
	}
	
	/* Metodo de ingreso de datos a la base */
	
	public void InsertRow(){
		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Tiene_perfil values ('"+id_usuario+"','"+tipo+"')");
			}
			catch (Exception e){
				
			}
			//pruebaConn.closeConextion();
		}else{
			System.out.println("Desconectado");
		}
	}
	
	/* metodo para cargar un resulset con lo datos de la tabla */
	
	public java.sql.ResultSet Select_tabla() throws SQLException{
		
		String seleccion = "Select * from Tiene_perfil";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
	//	pruebaConn.closeConextion();
		
		return rs;
		
	}
	
	/* metodo para cargar un resulset con lo datos de un registro seleccionado */
	
public java.sql.ResultSet Select_fila(int id) throws SQLException{
		
		String seleccion = "Select * from Tiene_perfil where id_usuario ='"+id+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		
		//pruebaConn.closeConextion();
		
		return rs;
		
	}
	


/* Metodo para eliminar un registro de la tabla Tiene_Perfil*/


public void eliminar_tipo_perfil(int id) {
	
	
	try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("DELETE from Tiene_perfil where id_usuario = '"+id+"';");
  }
	catch (Exception e){
		System.out.println("no se pudo eliminar");
	}
	
	
}
	
}


