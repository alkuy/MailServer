package Persistencia;


import java.sql.SQLException;
import java.util.Calendar;

public class Usuario {

	private int id_usuario;
	private String passAdmin;
	private String sqlFecha;
	private int habilitado = 1; // preestablecido como uno que es como se carga el usuario
	private Conexion pruebaConn = Conexion.getInstancia();
	
	
	/** Método constructor de la clase usuario - vacio.
	 *
	*/		
	public Usuario(){};
	
	
	/** Método de ingreso de datos del usuario a la BD
	 * @exception Exception
    */		
	public void InsertRow(String pass){		
		
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
				stm.execute("Insert into Usuario (pass_admin, fecha_alta, habilitado) values ('"+pass+"','"+sqlFecha+"', '"+habilitado+"')");
			}
			catch (Exception e){
				
			}
		}else{}
	 }
	
	
	
	
	/** Método que devuelve todos los datos de la tabla usuarios
	 * @return Resulset con la tabla usuario
	 * @throws SQLException
	*/
	
	public java.sql.ResultSet Select_tabla() throws SQLException{
		
		String seleccion = "Select * from Usuario";		
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;
	 }
	
	
	
	 
	/* metodo para cargar un resulset con lo datos de un registro seleccionado */
	
    public java.sql.ResultSet Select_fila(int id) throws SQLException{
		
		String seleccion = "Select * from Usuario where id_usuario ='"+id+"'";
		java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		java.sql.ResultSet rs = ps.executeQuery(seleccion);
		return rs;		
	 }


    /** Método que devuelve el ultimo id de usuario ingresado
	 * @return Resulset con el ultimo id de usuario
	 * @throws SQLException
	*/	

    public java.sql.ResultSet Select_ultimo_id() throws SQLException{
	
	  String seleccion = "SELECT MAX(id_usuario) FROM Usuario";	
	  java.sql.Statement ps = pruebaConn.getConexion().createStatement();
	  java.sql.ResultSet rs = ps.executeQuery(seleccion);	
	  return rs;
	
     }


    /** Método que devuelve el passwd de usuario segun su id
     * @param id id de usuario
	 * @return Resulset con el passwd de usuario
	 * @throws SQLException
	*/	

    public java.sql.ResultSet Dev_passCon(int id) throws SQLException{
	
	  String seleccion = "Select password from Cuenta where id_usuario ='"+id+"'";		
	  java.sql.Statement ps = pruebaConn.getConexion().createStatement();
	  java.sql.ResultSet rs = ps.executeQuery(seleccion);	
	  return rs;
	
     }
    
    /** Método que devuelve el passwd de usuario segun su id
     * @param id id de usuario
	 * @return Resulset con el passwd de usuario
	 * @throws SQLException
	*/	

    public java.sql.ResultSet Dev_pass(int id) throws SQLException{
	
	  String seleccion = "Select pass_admin from Usuario where id_usuario ='"+id+"'";		
	  java.sql.Statement ps = pruebaConn.getConexion().createStatement();
	  java.sql.ResultSet rs = ps.executeQuery(seleccion);	
	  return rs;
	
     }
    

    /** Método para modificar el passwd de un administrador en la BD
	 * @exception Exception
    */

    public void cambiar_passwd(int id, String passwd) {	
	
	  try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Usuario SET pass_admin = '"+passwd+"'" + "where id_usuario = '"+id+"';");
      }catch (Exception e){}
	
	
    }



   /**
    * Metodo que deshabilita el usuario y todas sus cuentas
    * 1 - Habilitada
    * 0 - Deshabilitada
    * @param id id usuario
    * @param habilita indica habilitado o no
   */
   public void habilitar_usuario(int id, boolean habilita){
	
	 try{
		java.sql.Statement stm = pruebaConn.getConexion().createStatement();
		stm.execute("UPDATE Usuario SET habilitado = '"+habilita+"'" + "where id_usuario = '"+id+"'");
      }catch (Exception e){}
	
    }
   
   /**
    * Trae el recordSet completo de usuario
    * @return
    * @throws SQLException
    */
   public java.sql.ResultSet TraeTodo() throws SQLException{
		
		  String seleccion = "Select * from Usuario";		
		  java.sql.Statement ps = pruebaConn.getConexion().createStatement();
		  java.sql.ResultSet rs = ps.executeQuery(seleccion);	
		  return rs;
		
	     }
   
  
	
	
}// fin clase Usuario

