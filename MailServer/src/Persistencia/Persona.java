package Persistencia;


import java.sql.SQLException;


public class Persona {

	
	private int id_usuario;
	private String ci;
	private String nombre;
	private String apellido;
	private String calle;
	private String nro_puerta;
	private String apto;
	
	private Conexion pruebaConn = Conexion.getInstancia();
	
	public Persona(int id, String ced, String nom, String apellido, String calle, String nro, String apto){
		
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
    
// contructor para consultas
	
    public Persona(){}
    
    	
	/* Metodo de ingreso de datos a la base */
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	

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
	
	
/* metodo para devolver el id de usuario en base a la cedula ingresada */
	
	public java.sql.ResultSet Dev_id(String ced) throws SQLException{
		
		String seleccion = "Select id_usuario from Persona where cedula ='"+ced+"'";
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);				
		return rs;
		
	}
	
	
/* metodo para devolver la c.i de usuario en base a su id */
	
	public java.sql.ResultSet Dev_ci(int id) throws SQLException{
		
		String seleccion = "Select cedula from Persona where id_usuario ='"+id+"'";		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);		
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


