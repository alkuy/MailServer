package Persistencia;

import java.sql.SQLException;


/** Clase para ABM de un correo en la BD.
 * @author 
 * @version 1.0
*/ 
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
	
	
	/** Método constructor de la clase correo - vacio
	 *
	*/
	
	public Correo (){}
	
	
	
	/** Método constructor de la clase correo.
	 *@param nom_us1 nombre del usuario emisor
	 *@param nom_dom1 nombre del dominio emisor
	 *@param nom_us2 nombre del usuario receptor
	 *@param nom_dom2 nombre del dominio receptor
	 *@param fecha es la fecha del correo
	 *@param id1 id del usuario emisor
	 *@param id2 id del usuario receptor
	 *@param asunto asunto del correo
	 *@param texto texto del correo
	 *@param id id de conversacion
	*/
	
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
	
	
	/** Método de ingreso de datos del correo a la BD
    */
	
	public void InsertRow(){
		
			
		if (pruebaConn!=null){
			try{
				java.sql.Statement stm = pruebaConn.getConexion().createStatement();
				if (id_usuario_receptor == 0)
					stm.execute("Insert into Correo values ('"+nom_usuario_emisor+"','"+nom_dominio_emisor+"','"+nom_usuario_receptor+"','"+nom_dominio_receptor+"','"+fecha+"','"+id_usuario_emisor+"','"+asunto+"','"+texto+"','"+id_conversacion+"')");
				else
					stm.execute("Insert into Correo values ('"+nom_usuario_emisor+"','"+nom_dominio_emisor+"','"+nom_usuario_receptor+"','"+nom_dominio_receptor+"','"+fecha+"','"+id_usuario_emisor+"','"+id_usuario_receptor+"','"+asunto+"','"+texto+"','"+id_conversacion+"')");
			}
			catch (Exception e){
				
			}
		}else{
			
		}
	}
	
	/** Método para borrar los correos de la tabala Correo
	 * 
	 * 
	*/
		
		public void DeleteCorreo(){
			if (pruebaConn!=null){
				try{
					java.sql.Statement stm = pruebaConn.getConexion().createStatement();
					stm.execute("delete from Correo");
				}
				catch (Exception e){	
				}
			}else{}
		}
	
	/** Método que devuelve todos los datos de la tabla correo
	 * @return Resulset con la tabla correo
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet Select_tabla() throws SQLException{
		
		String seleccion = "Select * from Correo";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	
	/** Método que devuelve todos los datos de la tabla correo de un Usuario
	 * @return Resulset con la tabla correo
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet Select_tabla_Usuario(String Usu) throws SQLException{
		
		String seleccion = "select * from Correo where nom_usuario_receptor = '"+Usu+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	
	
	/** Método que devuelve todos los datos de un correo seleccionado
	 *@param nom_us1 nombre del usuario emisor
	 *@param nom_dom1 nombre del dominio emisor
	 *@param nom_us2 nombre del usuario receptor
	 *@param nom_dom2 nombre del dominio receptor
	 *@param fecha es la fecha del correo
	 * @return Resulset con la fila correspondiente al correo seleccionado
	 * @throws SQLException
	*/
	
    public java.sql.ResultSet Select_fila(String nom_us1,String nom_dom1, String nom_us2, String nom_dom2, String fecha) throws SQLException{
 		
		String seleccion = "Select * from Correo where nom_usuario_emisor = '"+nom_us1+"' and nom_dominio_emisor = '"+nom_dom1+"' and nom_usuario_receptor = '"+nom_us2+"' and nom_dominio_receptor = '"+nom_dom2+"' and fecha ='"+fecha+"'";
		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
		
	}
	

        
    /** Método para eliminar un correo seleccionado
     *@param nom_us1 nombre del usuario emisor
	 *@param nom_dom1 nombre del dominio emisor
	 *@param nom_us2 nombre del usuario receptor
	 *@param nom_dom2 nombre del dominio receptor
	 *@param fecha es la fecha del correo
	*/

   public void eliminar_correo(String nom_us1,String nom_dom1, String nom_us2, String nom_dom2, String fecha) {
	
	
	try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("DELETE from Correo where nom_usuario_emisor = '"+nom_us1+"' and nom_dominio_emisor = '"+nom_dom1+"' and nom_usuario_receptor = '"+nom_us2+"' and nom_dominio_receptor = '"+nom_dom2+"' and fecha ='"+fecha+"'");
    }catch (Exception e){}
	
	
   }
	
} // fin clase correo




