package Persistencia;


import java.sql.SQLException;


public class Telefono {

	
	private int id_usuario;
	private String telefono;
	private Conexion pruebaConn = Conexion.getInstancia();
	
	public Telefono(int id, String tel){
		
		this.id_usuario = id;
		this.telefono = tel;	
	}
	
/* Contructor vacio*/
	public Telefono (){};
	
	
public Telefono(int id){
		
		this.id_usuario = id;
		
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
			//pruebaConn.closeConextion();
		}else{
			System.out.println("Desconectado");
		}
	}
	
	/* metodo para cargar un resulset con lo datos de la tabla */
	
	public java.sql.ResultSet Select_tabla() throws SQLException{
		
		String seleccion = "Select * from Telefono";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
	//	pruebaConn.closeConextion();
		
		return rs;
		
	}
	
	/* metodo para cargar un resulset con lo datos de un registro seleccionado */
	
public java.sql.ResultSet Select_fila(int id) throws SQLException{
		
		String seleccion = "Select * from Telefono where id_usuario ='"+id+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		
		//pruebaConn.closeConextion();
		
		return rs;
		
	}


//Metodo que permite modificar los telefonos de una persona segun su id

public void cambiar_telefonos(int id, String tel) {
	
	
	try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Telefono SET telefono = '"+tel+"'" + "where id_usuario = '"+id+"'");
}
	catch (Exception e){
		System.out.println("no se pudo modificar el telefono");
	}	
	
}
	
	
	
}

