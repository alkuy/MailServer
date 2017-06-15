package Persistencia;


import java.sql.SQLException;
import java.util.Calendar;

public class Usuario {

	private int id_usuario;
	private String passAdmin;
	private String sqlFecha;
	private Conexion pruebaConn = Conexion.getInstancia();
	
	public Usuario(String pass){
		
		this.passAdmin = pass;	
	}
	
    public Usuario(int id){
		
		this.id_usuario = id;	
	}
	

	
	public void InsertRow(){
		
		
		Calendar fecha = Calendar.getInstance();
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH) + 1;
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		
		if (mes < 10){
			this.sqlFecha = (anio+"-0"+mes+"-"+dia);
			
		}
		else
			this.sqlFecha = (anio+"-"+mes+"-"+dia);
		
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Usuario (pass_admin, fecha_alta) values ('"+passAdmin+"','"+sqlFecha+"')");
			}
			catch (Exception e){
				
			}
		//	pruebaConn.closeConextion();
		}else{
			System.out.println("Desconectado");
		}
	}
	
	/* metodo para cargar un resulset con lo datos de la tabla */
	
	public java.sql.ResultSet Select_tabla() throws SQLException{
		
		String seleccion = "Select * from Usuario";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
	//	pruebaConn.closeConextion();
		
		return rs;
		
	}
	
	/* metodo para cargar un resulset con lo datos de un registro seleccionado */
	
public java.sql.ResultSet Select_fila(int id) throws SQLException{
		
		String seleccion = "Select * from Usuario where id_usuario ='"+id+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		
		//pruebaConn.closeConextion();
		
		return rs;
		
	}


   /* metodo para cargar un resulset con el ultimo id_usuario generado */

public java.sql.ResultSet Select_ultimo_id() throws SQLException{
	
	String seleccion = "SELECT MAX(id_usuario) FROM Usuario";
	
	java.sql.Statement ps = pruebaConn.getConexion().createStatement();
	java.sql.ResultSet rs = ps.executeQuery(seleccion);
	
	//pruebaConn.closeConextion();
	
	return rs;
	
}


/* metodo para devolver el pass de un usuario en base a su id */

public java.sql.ResultSet Dev_pass(int id) throws SQLException{
	
	String seleccion = "Select pass_admin from Usuario where id_usuario ='"+id+"'";		
	java.sql.Statement ps = pruebaConn.getConexion().createStatement();
	java.sql.ResultSet rs = ps.executeQuery(seleccion);		
	return rs;
	
}
	
	
}

