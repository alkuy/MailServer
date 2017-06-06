package Persistencia;

import java.sql.SQLException;

/* Fachada de conexión entre la capa de Persistencia y la capa Lógica */

public class FachadaBD {

	private static FachadaBD instancia;	
	private Usuario user;
	private Persona persona;
	private Telefonos tel;
	private Correo correo;
	private Dominio dominio;
		
	private FachadaBD(){
	}
	
		
	public static FachadaBD getInstancia(){
		if (instancia == null)
			instancia = new FachadaBD();
			
		return instancia;
	}
	
	
/* METODOS PARA LA CLASE USUARIO */
	
	public void NuevoUS (String pass){
		this.user = new Usuario(pass);
	}
	
	public void NuevoUS2 (int id){
		this.user = new Usuario(id);
	}
	
	//Metodo para ingresar un registro en la tabla Usuario
	
	public void InserUS (String pass){
		this.NuevoUS(pass);
		this.user.InsertRow();
	}
	
	//Metodo que devuelve el Resulset con los datos de la tabla Usuarios cargados
	
	public java.sql.ResultSet ConTablaUS(int idUsu) throws SQLException{
		java.sql.ResultSet rs;
		this.NuevoUS2(idUsu);
		rs = this.user.Select_tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Usuarios que se elija segun id
	
	public java.sql.ResultSet ConFilaUS(int idUsu) throws SQLException{
		java.sql.ResultSet rs;
		this.NuevoUS2(idUsu);
		rs = this.user.Select_fila(idUsu);
		return rs;
	}
	
	
	
	/* METODOS PARA LA CLASE PERSONA */
	
	
	//Metodo que crea un objeto persona en la tabla Persona
	
	public void Nueva_Persona (int id, int ced, String nom, String ap){
		
		this.persona = new Persona(id,ced,nom,ap);
	}
	
	
     public void Nueva_Persona2 (int id){
		
		this.persona = new Persona(id);
	}
		
	//Metodo para ingresar un registro en la tabla Persona
	
	public void InsertPer (int id, int ced, String nom, String ap){
		this.Nueva_Persona(id,ced,nom,ap);
		this.persona.InsertRow();
	}
	
	
	
	//Metodo que devuelve el Resulset con los datos de la tabla Persona cargados
	
	public java.sql.ResultSet ConTablaPer(int idUsu) throws SQLException{
		java.sql.ResultSet rs;
		this.Nueva_Persona2(idUsu);
		rs = this.persona.Select_Tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Persona que se elija segun id
	
	public java.sql.ResultSet ConFilaPer(int idUsu) throws SQLException{
		java.sql.ResultSet rs;
		this.Nueva_Persona2(idUsu);
		rs = this.persona.Select_fila(idUsu);
		return rs;
	}
	
	
	
	/*METODOS PARA LA CLASE CORREO*/
	
	public void NuevoCorreo (String nom_us1, String nom_dom1, String nom_us2, String nom_dom2, String fecha, int id1, int id2, String asunto, String texto){
		this.correo = new Correo(nom_us1,nom_dom1, nom_us2, nom_dom2,fecha, id1, id2, asunto, texto);
	}
	
	public void NuevoCorreo2 (String nom_us1,String nom_dom1, String nom_us2, String nom_dom2, String fecha){
		this.correo = new Correo(nom_us1,nom_dom1, nom_us2, nom_dom2, fecha);
	}
	
	//Metodo para ingresar un registro en la tabla Usuario
	
	public void InsertCorreo (String nom_us1, String nom_dom1, String nom_us2, String nom_dom2, String fecha, int id1, int id2, String asunto, String texto){
		this.NuevoCorreo(nom_us1, nom_dom1, nom_us2, nom_dom2, fecha, id1, id2, asunto, texto);
		this.correo.InsertRow();
	}
	
	//Metodo que devuelve el Resulset con los datos de la tabla Usuarios cargados
	
	public java.sql.ResultSet ConTablaCorreo(String nom_us1,String nom_dom1, String nom_us2, String nom_dom2, String fecha) throws SQLException{
		java.sql.ResultSet rs;
		this.NuevoCorreo2(nom_us1,nom_dom1, nom_us2, nom_dom2, fecha);
		rs = this.correo.Select_tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Usuarios que se elija segun id
	
	public java.sql.ResultSet ConFilaCorreo(String nom_us1,String nom_dom1, String nom_us2, String nom_dom2, String fecha) throws SQLException{
		java.sql.ResultSet rs;
		this.NuevoCorreo2(nom_us1,nom_dom1,nom_us2, nom_dom2,fecha);
		rs = this.correo.Select_fila(nom_us1,nom_dom1,nom_us2, nom_dom2,fecha);
		return rs;
	}
	
	
/* METODOS PARA LA CLASE DOMINIO*/
	
	public void NuevoDom (String dom){
		this.dominio = new Dominio(dom);
	}
	
	
	
	//Metodo para ingresar un registro en la tabla Dominio
	
	public void InsertDom (String dom){
		this.NuevoDom(dom);
		this.dominio.InsertRow();
	}
	
	//Metodo que devuelve el Resulset con todos los datos de la tabla Dominio cargados
	
	public java.sql.ResultSet ConTablaDom(String dom) throws SQLException{
		java.sql.ResultSet rs;
		this.NuevoDom(dom);
		rs = this.dominio.Select_tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Dominio que se elija
	
	public java.sql.ResultSet ConFilaDom(String dom) throws SQLException{
		java.sql.ResultSet rs;
		this.NuevoDom(dom);
		rs = this.dominio.Select_fila(dom);
		return rs;
	}
	
	
	
}
