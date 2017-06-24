package Persistencia;

import java.sql.SQLException;

public class Correo{
	
	private String nom_usuario_emisor;
	private String nom_dominio_emisor;
	private String nom_usuario_receptor;
	private String nom_dominio_receptor;
	private String fecha;
	private int id_usuario_emisor;
	private int id_usuario_receptor;
	private String asunto;
	private String texto;
	private int id_conversacion;
	
	
	private Conexion pruebaConn = Conexion.getInstancia();
	
	// Contructor general para cargar todos los datos de un correo
	
	public Correo (){}
	
	public Correo(String nom_us1, String nom_dom1, String nom_us2, String nom_dom2, String fecha, int id1, int id2, String asunto, String texto, int id){
		
		this.id_usuario_emisor = id1;
		this.id_usuario_receptor = id2;
		this.nom_usuario_emisor = nom_us1;
		this.nom_usuario_receptor = nom_us2;
		this.nom_dominio_emisor = nom_dom1;
		this.nom_dominio_receptor = nom_dom2;
		this.fecha = fecha;
		this.asunto = asunto;
		this.texto = texto;
		this.id_conversacion = id;
	}
	
	
	/* Metodo de ingreso de datos a la base */
	
	public void InsertRow(){
		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Correo values ('"+nom_usuario_emisor+"','"+nom_dominio_emisor+"','"+nom_usuario_receptor+"','"+nom_dominio_receptor+"','"+fecha+"','"+id_usuario_emisor+"','"+id_usuario_receptor+"','"+asunto+"','"+texto+"','"+id_conversacion+"')");
			}
			catch (Exception e){
				System.out.println("aca la cago");
			}
		}else{
			System.out.println("Desconectado");
		}
	}
	
	/* metodo para cargar un resulset con lo datos de la tabla */
	
	public java.sql.ResultSet Select_tabla() throws SQLException{
		
		String seleccion = "Select * from Correo";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	
	
	/* metodo para cargar un resulset con lo datos de un registro seleccionado */
	
public java.sql.ResultSet Select_fila(String nom_us1,String nom_dom1, String nom_us2, String nom_dom2, String fecha) throws SQLException{
		
		String seleccion = "Select * from Correo where nom_usuario_emisor = '"+nom_us1+"' and nom_dominio_emisor = '"+nom_dom1+"' and nom_usuario_receptor = '"+nom_us2+"' and nom_dominio_receptor = '"+nom_dom2+"' and fecha ='"+fecha+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	

/* Metodo para eliminar un registro de la tabla Correo*/


public void eliminar_correo(String nom_us1,String nom_dom1, String nom_us2, String nom_dom2, String fecha) {
	
	
	try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("DELETE from Correo where nom_usuario_emisor = '"+nom_us1+"' and nom_dominio_emisor = '"+nom_dom1+"' and nom_usuario_receptor = '"+nom_us2+"' and nom_dominio_receptor = '"+nom_dom2+"' and fecha ='"+fecha+"'");
  }
	catch (Exception e){
		System.out.println("no se pudo eliminar el registro");
	}
	
	
}
	
}




