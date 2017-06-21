package Persistencia;

import java.sql.SQLException;

/* Fachada de conexión entre la capa de Persistencia y la capa Lógica */

public class FachadaBD {

	private static FachadaBD instancia;	
	private Usuario user = new Usuario();
	private Persona persona = new Persona();
	private Correo correo = new Correo();
	private Dominio dominio = new Dominio();
	private Cuenta cuenta = new Cuenta();
	private Telefono telefono = new Telefono();
	private Perfil perfil = new Perfil();
	private Oficina oficina = new Oficina();	
	private Tiene_perfil tiene_perfil = new Tiene_perfil();
	private Lista_distribucion lista_dist = new Lista_distribucion();
	
	private FachadaBD(){
	}
	
		
	public static FachadaBD getInstancia(){
		if (instancia == null)
			instancia = new FachadaBD();
			
		return instancia;
	}
	
	
/* METODOS PARA LA CLASE USUARIO */
	
	
	//Metodo para ingresar un registro en la tabla Usuario
	
	public void InserUS (String pass){
		this.user.InsertRow();
	}
	
	//Metodo que devuelve el Resulset con los datos de la tabla Usuarios cargados
	
	public java.sql.ResultSet ConTablaUS(int idUsu) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.user.Select_tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Usuarios que se elija segun id
	
	public java.sql.ResultSet ConFilaUS(int idUsu) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.user.Select_fila(idUsu);
		return rs;
	}
	
	// Metodo que devuelve un resulset con el ultimo id de usuario generado
	
	public java.sql.ResultSet ConUltimoID() throws SQLException{
		java.sql.ResultSet rs;
	    rs = this.user.Select_ultimo_id();
		return rs;
	}
	
	
  //Metodo que devuelve el pasword segun el id del usuario ingresado
 	
  	public java.sql.ResultSet Devolver_pass(int id) throws SQLException{
  		
  		java.sql.ResultSet rs;
  	    rs = this.user.Dev_pass(id);  		
  		return rs;
  	}
	
	
	
	/* METODOS PARA LA CLASE PERSONA */
	
	
	//Metodo que crea un objeto persona en la tabla Persona
	
	public void Nueva_Persona (int id, String ced, String nom, String ap, String calle, String nro, String apto){
		
		this.persona = new Persona(id,ced,nom,ap, calle, nro, apto);
	}
	
	
   	
     
     //Metodo que devuelve un entero con el id segun la cedula de usuario ingresada
 	
  	public int Devolver_id(String ci) throws SQLException{
 		int id=0;
 		java.sql.ResultSet rs;
 	    rs = this.persona.Dev_id(ci);
 		while (rs.next()){
 			id = rs.getInt(1);
 		}
 		return id;
 	}
     
 	
    //Metodo que devuelve la cedula segun el id del usuario ingresado
 	
  	public java.sql.ResultSet Devolver_ci(int id) throws SQLException{
  		
  		java.sql.ResultSet rs;
  	   	rs = this.persona.Dev_ci(id);  		
  		return rs;
  	}
     
	//Metodo para ingresar un registro en la tabla Persona
	
	public void InsertPer (int id, String ced, String nom, String ap, String calle, String nro, String apto){
		this.Nueva_Persona(id,ced,nom,ap, calle, nro, apto);
		this.persona.InsertRow();
	}
	
		
	//Metodo que devuelve el Resulset con los datos de la tabla Persona cargados
	
	public java.sql.ResultSet ConTablaPer(int idUsu) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.persona.Select_Tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Persona que se elija segun id
	
	public java.sql.ResultSet ConFilaPer(int idUsu) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.persona.Select_fila(idUsu);
		return rs;
	}
	
	
	
	/*METODOS PARA LA CLASE CORREO*/
	
	public void NuevoCorreo (String nom_us1, String nom_dom1, String nom_us2, String nom_dom2, String fecha, int id1, int id2, String asunto, String texto, int id){
		this.correo = new Correo(nom_us1,nom_dom1, nom_us2, nom_dom2,fecha, id1, id2, asunto,texto, id);
	}
	
		
	//Metodo para ingresar un registro en la tabla Correo
	
	public void InsertCorreo (String nom_us1, String nom_dom1, String nom_us2, String nom_dom2, String fecha, int id1, int id2, String asunto, String texto, int id){
		this.NuevoCorreo(nom_us1, nom_dom1, nom_us2, nom_dom2, fecha, id1, id2, asunto, texto, id);
		this.correo.InsertRow();
	}
	
	//Metodo que devuelve el Resulset con los datos de la tabla Correo cargados
	
	public java.sql.ResultSet ConTablaCorreo(String nom_us1,String nom_dom1, String nom_us2, String nom_dom2, String fecha) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.correo.Select_tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Correo que se elija segun las claves
	
	public java.sql.ResultSet ConFilaCorreo(String nom_us1,String nom_dom1, String nom_us2, String nom_dom2, String fecha) throws SQLException{
		java.sql.ResultSet rs;
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
	/*METE MANO ADRIAN*/
	public java.sql.ResultSet ConTablaDom() throws SQLException{
		java.sql.ResultSet rs;
		rs = dominio.Select_tabla();
		return rs;
	}
	/*----------------------------------------------------------------------*/
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Dominio que se elija
	
	public java.sql.ResultSet ConFilaDom(String dom) throws SQLException{
		java.sql.ResultSet rs;
		this.NuevoDom(dom);
		rs = this.dominio.Select_fila(dom);
		return rs;
	}
	
	
/* METODOS PARA LA CLASE CUENTA */
	
	
	//Metodo que crea un objeto persona en la tabla Cuenta
	
	public void Nueva_Cuenta (int id, String nom_us, String nom_dom, String pass, int es_lista){
		
		this.cuenta = new Cuenta(id,nom_us, nom_dom, pass, es_lista);
	}
	
	
     	
	//Metodo para ingresar un registro en la tabla Cuenta
	
	public void InsertCuenta (int id, String nom_us, String nom_dom, String pass, int es_lista){
		this.Nueva_Cuenta(id,nom_us, nom_dom, pass, es_lista);
		this.cuenta.InsertRow();
	}
	
	
	
	//Metodo que devuelve el Resulset con los datos de la tabla Cuenta cargados
	
	public java.sql.ResultSet ConTablaCuenta() throws SQLException{
		java.sql.ResultSet rs;
		rs = this.cuenta.Select_Tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Cuenta que se elija segun su clave
	
	public java.sql.ResultSet ConFilaCuenta(int id, String nom_us, String nom_dom) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.cuenta.Select_fila(id, nom_us, nom_dom);
		return rs;
	}
	
		
/* METODOS PARA LA CLASE TELEFONO*/
	
	public void NuevoTel (int id, String tel){
		this.telefono = new Telefono(id, tel);
		
	}
	
	
	//Metodo para ingresar un registro en la tabla Telefono
	
	public void InsertTel (int id, String tel){
		this.NuevoTel(id, tel);
		this.telefono.InsertRow();
	}
	
	//Metodo que devuelve el Resulset con todos los datos de la tabla Telefono cargados
	
	public java.sql.ResultSet ConTablaTel(int id) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.telefono.Select_tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Telefono que se elija
	
	public java.sql.ResultSet ConFilaTel(int id) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.telefono.Select_fila(id);
		return rs;
	}
	
	
/* METODOS PARA LA CLASE OFICINA*/
	
	public void NuevaOfi (int id, String nom){
		this.oficina = new Oficina(id, nom);
		
	}
	
	
	//Metodo para ingresar un registro en la tabla Telefono
	
	public void InsertOfi (int id, String nom){
		this.NuevaOfi(id, nom);
		this.oficina.InsertRow();
	}
	
	//Metodo que devuelve el Resulset con todos los datos de la tabla Telefono cargados
	
	public java.sql.ResultSet ConTablaOfi(int id) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.oficina.Select_tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Telefono que se elija
	
	public java.sql.ResultSet ConFilaOfi(int id) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.oficina.Select_fila(id);
		return rs;
	}
		
	
	
/* METODOS PARA LA CLASE PERFIL*/
	
	public void NuevoPerf(String tipo){
		this.perfil = new Perfil(tipo);
	}
		
	
	//Metodo para ingresar un registro en la tabla Perfil
	
	public void InsertPerf (String tipo){
		this.NuevoPerf(tipo);
		this.perfil.InsertRow();
	}
	
	//Metodo que devuelve el Resulset con todos los datos de la tabla Perfil cargados
	
	public java.sql.ResultSet ConTablaPerf(String tipo) throws SQLException{
		java.sql.ResultSet rs;
		this.NuevoPerf(tipo);
		rs = this.perfil.Select_tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Perfil que se elija
	
	public java.sql.ResultSet ConFilaPerf(String tipo) throws SQLException{
		java.sql.ResultSet rs;
		this.NuevoPerf(tipo);
		rs = this.perfil.Select_fila(tipo);
		return rs;
	}
	
/* METODOS PARA LA CLASE TIENE PERFIL*/
	
	public void Nuevo_TPerfil (int id, String tipo){
		this.tiene_perfil = new Tiene_perfil(id, tipo);
		
	}
	
	//Metodo para ingresar un registro en la tabla Tiene Perfil
	
	public void Insert_TPerfil (int id, String tipo){
		this.Nuevo_TPerfil(id, tipo);
		this.tiene_perfil.InsertRow();
	}
	
	//Metodo que devuelve el Resulset con todos los datos de la tabla Tiene Perfil cargados
	
	public java.sql.ResultSet ConTabla_TPerfil(int id) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.tiene_perfil.Select_tabla();
		return rs;
	}
	
	
	//Metodo que devuelve el Resulset con los datos de la fila de la tabla Telefono que se elija
	
	public java.sql.ResultSet ConFila_TPerfil(int id) throws SQLException{
		java.sql.ResultSet rs;
		rs = this.tiene_perfil.Select_fila(id);
		return rs;
	}
	
	



/*METODOS PARA LA CLASE LISTA DISTRIBUCION*/

public void NuevaLista (String nom_lis, String nom_dom_lis, String nom_res, String nom_dom_res, int id_lis, int id_res){
	this.lista_dist = new Lista_distribucion(nom_lis, nom_dom_lis, nom_res, nom_dom_res, id_lis, id_res);
}


//Metodo para ingresar un registro en la tabla Lista Distribucion

public void InsertLista (String nom_lis, String nom_dom_lis, String nom_res, String nom_dom_res, int id_lis, int id_res){
	this.NuevaLista(nom_lis, nom_dom_lis, nom_res, nom_dom_res, id_lis, id_res);
	this.lista_dist.InsertRow();
}

//Metodo que devuelve el Resulset con los datos de la tabla Lista Dristribucion cargados

public java.sql.ResultSet ConTablaLista(String nom_lis, String nom_dom_lis, String nom_res, String nom_dom_res) throws SQLException{
	java.sql.ResultSet rs;
	rs = this.lista_dist.Select_tabla();
	return rs;
}


//Metodo que devuelve el Resulset con los datos de la fila de la tabla Lista Distribucion que se elija segun las claves

public java.sql.ResultSet ConFilaLista(String nom_lis, String nom_dom_lis, String nom_res, String nom_dom_res) throws SQLException{
	java.sql.ResultSet rs;
	rs = this.lista_dist.Select_fila(nom_lis, nom_dom_lis, nom_res, nom_dom_res);
	return rs;
}

}


