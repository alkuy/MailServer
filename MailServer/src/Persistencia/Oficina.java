package Persistencia;


import java.sql.SQLException;


public class Oficina {

	
	private int id_usuario;
	private String nombre;
	private Conexion pruebaConn = Conexion.getInstancia();
	
	
	public Oficina(){}		
	
	public Oficina(int id, String nom){
	
	this.id_usuario = id;
	this.nombre = nom;	
    }
	
  	
	/* Metodo de ingreso de datos a la base */
	
	public void InsertRow(){
		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Oficina values ('"+id_usuario+"','"+nombre+"')");
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
		
		String seleccion = "Select * from Oficina";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
	//	pruebaConn.closeConextion();
		
		return rs;
		
	}
	
	/* metodo para cargar un resulset con lo datos de un registro seleccionado */
	
public java.sql.ResultSet Select_fila(int id) throws SQLException{
		
		String seleccion = "Select * from Oficina where id_usuario ='"+id+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		
		//pruebaConn.closeConextion();
		
		return rs;
		
	}
	
	
/* metodo para modificar el nombre del grupo (oficina) */

public void cambiar_nom_ofi(int id, String nombre) {
	
	
	try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Oficina SET nombre = '"+nombre+"'" + "where id_usuario = '"+id+"';");
  }
	catch (Exception e){
		System.out.println("no se pudo modificar el nombre");
	}
	
	
}

	
}

