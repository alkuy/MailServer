package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.table.DefaultTableModel;

import Persistencia.FachadaBD;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 


public class Usuarios {
	
	private Hashtable<String, Usuario> hUsu;
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	/** M�todo constructor de la colecci�n Usuarios. */
	public Usuarios() {
		try {
			this.hUsu = cargaDesdeBD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.hUsu = new Hashtable<>();
	}
	
	/** M�todo que determina si en el diccionario de Usuarios existe un Usuario con la clave <b>id_usuario</b>.
	 * @param id_usuario Identificador del usuario a verificar su existencia en el diccionario.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public boolean member(int id_usuario) {
		return this.hUsu.containsKey(String.valueOf(id_usuario));
	}
	
	/** M�todo que da de alta un usuario en el diccionario.
	 * <BR><b>Precondici�n</b>: el usuario a dar de alta no es miembro del diccionario Usuarios.</BR>
	 * @param usu Usuario a dar de alta en la colecci�n.
	 * @return No retorna nada. */
	public void insert(Usuario usu){
		this.hUsu.put(String.valueOf(usu.getId_usuario()), usu);
	}
	
	/** M�todo que dado el nombre de usuario devuelve el usuario con dicho nombre.
	 * <BR><b>Precondici�n</b>: el usuario es miembro del diccionario.</BR>
	 * @param nom_usuario Nombre de usuario perteneciente al usuario a retornar.
	 * @return El usuario con dicho nombre de usuario. */
	public Usuario find(int id_usuario){
		return this.hUsu.get(String.valueOf(id_usuario));
	}
	
	public int getID(String ci){
		Enumeration<Usuario> eUsu = hUsu.elements();
		Usuario usu = new Usuario();
		while(eUsu.hasMoreElements()){
			usu = eUsu.nextElement();
//			System.out.println(usu.getId_usuario() + " " + usu.getCi() + " " + ci);
			if(usu.getCi() != null && usu.getCi().equals(ci)){
				return usu.getId_usuario();
			}
		}
		return 0;
	}
	
	/** M�todo que sustituye el viejo usuario en el diccionario por el nuevo usuario.
	 * <b>Precondici�n</b>: el usuario es miembro del diccionario.
	 * @param usu usuario a modificar en la colecci�n Usuarios.
	 * @return No retorna nada. */
	public void modify(int id_usuario, String ci, String nombre, String apellido, String calle, 
			String nro, String apto/*, String numTel1, String numTel2*/){
//		delete(usu.getNom_usuario());
//		this.hUsu.put(usu.getNom_usuario(), usu);
		this.find(id_usuario).setNombre(nombre);
		this.find(id_usuario).setApellido(apellido);
		this.find(id_usuario).setCalle(calle);
		this.find(id_usuario).setNro_puerta(nro);
		this.find(id_usuario).setApto(apto);
		BD.Modifica_datos_per(ci, nombre, apellido, calle, nro, apto);
	}
	
	/** M�todo que dado nombre de usuario de un usuario lo dada de baja del diccionario.
	 * <b>Precondici�n</b>: el usuario es miembro del diccionario.
	 * @param nom_usuario nombre de usuario perteneciente al usuario a dar de baja.
	 * @return No retorna nada. */
	public void delete(String nom_usuario){
		this.hUsu.remove(nom_usuario);
	}
	
	public Hashtable<String, Usuario> cargaDesdeBD() throws SQLException{
		Hashtable<String, Usuario> usuarios = new Hashtable<String, Usuario>();
		ResultSet rs = null;
		
		rs = BD.ConTablaUS();
		
		while(rs.next()){
			Usuario usu = new Usuario();
			
			usuarios.put(rs.getString("id_usuario"), usu.cargaDesdeBD(rs.getInt("id_usuario"), rs.getString("pass_admin")));
//			System.out.println(rs.getString("id_usuario"));
		}
		
		return usuarios;
	}

	
	public void imprimirConsola (Hashtable<String, Usuario> usus){
		Enumeration<String> e = usus.keys();
		
		System.out.println("IMPRIMIENDO");
		
		while(e.hasMoreElements()){
			String elem = e.nextElement();
			System.out.println(elem);
			
		}
	}
	
	public Hashtable<String, Usuario> getColection(){
		return hUsu;
	}
	
	public DefaultTableModel DevTablaUsuario(){
		String col[] = {"C�dula","Cuenta"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);
		
		Enumeration<Usuario> eUsu = hUsu.elements();
		Usuario usu;
		
		while(eUsu.hasMoreElements()){
			usu = eUsu.nextElement();
			
			//System.out.println("id " + usu.getId_usuario() + " CI " + usu.getCi() + " Nombre " + usu.getNombre());
			String carga [] = {usu.getCi(), usu.getNombre()};
			modelo.addRow(carga);
		}
		
		return modelo;
	}

}
