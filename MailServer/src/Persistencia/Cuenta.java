package Persistencia;

import java.sql.SQLException;


public class Cuenta {

	
	private int id_usuario;
	private String nom_usuario;
	private String nom_dominio;
	private String password;
	private String fecha_creacion; 
	private int es_lista;
	
	
	private Conexion pruebaConn = Conexion.getInstancia();
	
	public Cuenta(){
		
	}
	
	public Cuenta(int id, String nom_us, String nom_dom, String pass, int es_lista){
		
		this.id_usuario = id;
		this.nom_usuario = nom_us;
		this.nom_dominio = nom_dom;
		this.password = pass;
		this.es_lista = es_lista;
	}
	
	
	
	/* Metodo de ingreso de datos a la base */
	
	public void InsertRow(){
		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Cuenta values ('"+id_usuario+"','"+nom_usuario+"','"+nom_dominio+"','"+password+"', '"+es_lista+"' ,CURRENT_TIMESTAMP )");
				
			}
			catch (Exception e){
				
			}
			//pruebaConn.closeConextion();
		}else{
			System.out.println("Desconectado");
		}
	}
	
	/* metodo para cargar un resulset con lo datos de la tabla */
	
	public java.sql.ResultSet Select_Tabla() throws SQLException{
		
		String seleccion = "Select * from Cuenta";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		//pruebaConn.closeConextion();
		
		return rs;
		
	}
	
	
	/* metodo para cargar un resulset con lo datos de un registro seleccionado */
	
public java.sql.ResultSet Select_fila(int id, String nom_us, String nom_dom ) throws SQLException{
		
		String seleccion = "Select * from Persona where id_usuario ='"+id+"'and nom_usuario = '"+nom_us+"'and nom_dominio = '"+nom_dom+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
	//	pruebaConn.closeConextion();
		
		return rs;
		
	}


/* metodo para modificar el passwor de ingreso a la base en la base */

public void cambiar_passwd(int id, String nom_us, String nom_dom, String passwd) {
	
	
	try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Cuenta SET password = '"+passwd+"'" + "where id_usuario = '"+id+"' AND nom_usuario = '"+nom_us+"' AND nom_dominio = '"+nom_dom+"'");
  }
	catch (Exception e){
		System.out.println("no se pudo modificar el passwd");
	}
	
}


/* Metodo para eliminar un registro de la tabla Usuarios*/


public void eliminar_cuenta(int id) {
	
	
	try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("DELETE from Cuenta where id_usuario = '"+id+"';");
  }
	catch (Exception e){
		System.out.println("no se pudo eliminar el registro");
	}
	
	
}
	
	
}


