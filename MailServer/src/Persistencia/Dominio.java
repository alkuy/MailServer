package Persistencia;

import java.sql.SQLException;


public class Dominio {

	
	private String nom_dominio;
	private Conexion pruebaConn = Conexion.getInstancia();
	
	public Dominio(String nom_dominio){
				
		this.nom_dominio = nom_dominio;	
	}
	
	public Dominio(){
		
	}
   
	public void InsertRow(){
		
		
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Dominio values ('"+nom_dominio+"')");
				
			}
			catch (Exception e){
				//System.out.println("aca la cago");
			}
		}else{
			System.out.println("Desconectado");
		}
	}
	
	/* metodo para cargar un resulset con lo datos de la tabla */
	
	public java.sql.ResultSet Select_tabla() throws SQLException{
		
		String seleccion = "Select * from Dominio";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
	//	pruebaConn.closeConextion();
		
		return rs;
		
	}
	
	/* metodo para cargar un resulset con lo datos de un registro seleccionado */
	
public java.sql.ResultSet Select_fila(String nom_dominio) throws SQLException{
		
		String seleccion = "Select * from Dominio where nom_dominio ='"+nom_dominio+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		
		//pruebaConn.closeConextion();
		
		return rs;
		
	}

/*Metodo para modificar la prioridad de un dominio*/

public void cambiar_prioridad(String nom, int prioridad) {
	
	
	try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Dominio SET prioridad = '"+prioridad+"'" + "where nom_dominio = '"+nom+"';");
  }
	catch (Exception e){
		System.out.println("no se pudo modificar la prioridad del dominio");
	}
	
	
}
	
	
}

