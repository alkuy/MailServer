package Persistencia;



	import java.sql.SQLException;

	public class Lista_distribucion {
		
		private String nom_usuario_lista;
		private String nom_dominio_lista;
		private String nom_usuario_receptor;
		private String nom_dominio_receptor;
		private int id_usuario_lista;
		private int id_usuario_receptor;
		
			
		private Conexion pruebaConn = Conexion.getInstancia();
		
		
		public Lista_distribucion(){}	
		
		// Contructor general para cargar todos los datos de una lista de distribucion
		
		public Lista_distribucion(String nom_lis, String nom_dom_lis, String nom_res, String nom_dom_res, int id_lis, int id_res){
			
			this.id_usuario_lista = id_lis;
			this.id_usuario_receptor = id_res;
			this.nom_usuario_lista = nom_lis;
			this.nom_usuario_receptor = nom_res;
			this.nom_dominio_lista = nom_dom_lis;
			this.nom_dominio_receptor = nom_dom_res;
			
		}
		
		// contructor para consultas por lo que solo le paso las claves
		
	    public Lista_distribucion(String nom_lis, String nom_dom_lis, String nom_res, String nom_dom_res){
			
	    	this.nom_usuario_lista = nom_lis;
			this.nom_usuario_receptor = nom_res;
			this.nom_dominio_lista = nom_dom_lis;
			this.nom_dominio_receptor = nom_dom_res;
			
			
		}
		
		
		/* Metodo de ingreso de datos a la base */
		
		public void InsertRow(){
			
				
			if (pruebaConn!=null){
				try{
					java.sql.Statement stm = pruebaConn.getConexion().createStatement();
					stm.execute("Insert into Lista_distribucion values ('"+nom_usuario_lista+"','"+nom_dominio_lista+"','"+nom_usuario_receptor+"','"+nom_dominio_receptor+"','"+id_usuario_lista+"','"+id_usuario_receptor+"')");
				}
				catch (Exception e){
					//System.out.println("aca la cago");
				}
				//pruebaConn.closeConextion();
			}else{
				System.out.println("Desconectado");
			}
		}
		
		/* metodo para cargar un resulset con lo datos de la tabla */
		
		public java.sql.ResultSet Select_tabla() throws SQLException{
			
			String seleccion = "Select * from Lista_distribucion";
			
			java.sql.Statement ps = pruebaConn.getConexion().createStatement();
			java.sql.ResultSet rs = ps.executeQuery(seleccion);
			//pruebaConn.closeConextion();
			
			return rs;
			
		}
		
		
		/* metodo para cargar un resulset con lo datos de un registro seleccionado */
		
	public java.sql.ResultSet Select_fila(String nom_lis, String nom_dom_lis, String nom_res, String nom_dom_res) throws SQLException{
			
			String seleccion = "Select * from Lista_distribucion where nom_usuario_lista = '"+nom_lis+"' and nom_dominio_lista = '"+nom_dom_lis+"' and nom_usuario_receptor = '"+nom_res+"' and nom_dominio_receptor = '"+nom_dom_res+"'";
			
			java.sql.Statement ps = pruebaConn.getConexion().createStatement();
			java.sql.ResultSet rs = ps.executeQuery(seleccion);
		//	pruebaConn.closeConextion();
			
			return rs;
			
		}
	
	
	/* Metodo para eliminar un registro de la tabla Lista Distribucion*/


	public void eliminar_lista(String nom_us_lis, String nom_dom_lis, String nom_us_res, String nom_dom_res) {
		
		
		try{
			java.sql.Statement stm = pruebaConn.getConexion().createStatement();
			stm.execute("DELETE from Lista_distribucion where nom_usuario_lista = '"+nom_us_lis+"' AND nom_dominio_lista = '"+nom_dom_lis+"' AND nom_usuario_receptor = '"+nom_us_res+"' AND nom_dominio_receptor = '"+nom_dom_res+"';");
	  }
		catch (Exception e){
			System.out.println("no se pudo eliminar el registro");
		}
		
		
	}
		
		
	}





