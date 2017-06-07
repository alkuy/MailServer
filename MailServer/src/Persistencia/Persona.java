package Persistencia;


import java.sql.SQLException;


public class Persona {

	
	private int id_usuario;
	private int ci;
	private String nombre;
	private String apellido;
	private String calle;
	private String nro_puerta;
	private String apto;
	
	private Conexion pruebaConn = Conexion.getInstancia();
	
	public Persona(int id, int ced, String nom, String apellido, String calle, String nro, String apto){
		
		this.id_usuario = id;
		this.ci = ced;
		this.nombre = nom;
		this.apellido = apellido;
		this.calle = calle;
		this.nro_puerta = nro;
		this.apto = apto;
	}
	
	// contructor para consultas
	
    public Persona(int id){
		
		this.id_usuario = id;
		
	}
	
	
	/* Metodo de ingreso de datos a la base */
	
	public void InsertRow(){
		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				stm.execute("Insert into Persona values ('"+id_usuario+"','"+ci+"','"+nombre+"','"+apellido+"', '"+calle+"', '"+nro_puerta+"','"+apto+"')");
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
		
		String seleccion = "Select * from Persona";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		//pruebaConn.closeConextion();
		
		return rs;
		
	}
	
	
	/* metodo para cargar un resulset con lo datos de un registro seleccionado */
	
public java.sql.ResultSet Select_fila(int id) throws SQLException{
		
		String seleccion = "Select * from Persona where id_usuario ='"+id+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
	//	pruebaConn.closeConextion();
		
		return rs;
		
	}
	
	
}


