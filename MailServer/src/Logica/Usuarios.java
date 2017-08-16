package Logica;

import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.table.*;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Persistencia.FachadaBD;

/** Clase para el diccionario de los usuarios
 * @author 
 * @version 1.0
*/ 


public class Usuarios {
	
	private Hashtable<String, Usuario> hUsu, admins;
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	/** Método constructor de la colección Usuarios. */
	public Usuarios() {
		try {
			this.hUsu = cargaDesdeBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Método que determina si en el diccionario de Usuarios existe un Usuario con la clave <b>id_usuario</b>.
	 * @param id_usuario Identificador del usuario a verificar su existencia en el diccionario.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public boolean member(int id_usuario) {
		return this.hUsu.containsKey(String.valueOf(id_usuario));
	}
	
	/** Método que da de alta un usuario en el diccionario.
	 * <BR><b>Precondición</b>: el usuario a dar de alta no es miembro del diccionario Usuarios.</BR>
	 * @param usu Usuario a dar de alta en la colección.
	 * @return No retorna nada. */
	public void insert(Usuario usu){
		this.hUsu.put(String.valueOf(usu.getId_usuario()), usu);
	}
	
	/** Método que dado el nombre de usuario devuelve el usuario con dicho nombre.
	 * <BR><b>Precondición</b>: el usuario es miembro del diccionario.</BR>
	 * @param nom_usuario Nombre de usuario perteneciente al usuario a retornar.
	 * @return El usuario con dicho nombre de usuario. */
	public Usuario find(int id_usuario){
		return this.hUsu.get(String.valueOf(id_usuario));
	}
	
	/** Método que retorna el ID del usuario con la CI especificada
	 * <BR><b>Precondición</b>: el usuario es miembro del diccionario.</BR>
	 * @param ci cédula del usuario
	 * @return id de usuario
	 */
	public int getID(String ci){
		Enumeration<Usuario> eUsu = hUsu.elements();
		Usuario usu = new Usuario();
		while(eUsu.hasMoreElements()){
			usu = eUsu.nextElement();
			if(usu.getCi() != null && usu.getCi().equals(ci)){
				return usu.getId_usuario();
			}
		}
		return 0;
	}
	
	/** Método que sustituye el viejo usuario en el diccionario por el nuevo usuario.
	 * <b>Precondición</b>: el usuario es miembro del diccionario.
	 * @param usu usuario a modificar en la colección Usuarios.
	 * @return No retorna nada. */
	public void modify(int id_usuario, String ci, String nombre, String apellido, String calle, 
			String nro, String apto, boolean habilitado){
		this.find(id_usuario).setNombre(nombre);
		this.find(id_usuario).setApellido(apellido);
		this.find(id_usuario).setCalle(calle);
		this.find(id_usuario).setNro_puerta(nro);
		this.find(id_usuario).setApto(apto);
		this.find(id_usuario).setHabilitado(habilitado);
		BD.Modifica_datos_per(ci, nombre, apellido, calle, nro, apto);
		BD.habilitacion_usuario(id_usuario, habilitado);
	}
	
	/** Método que dado nombre de usuario de un usuario lo dada de baja del diccionario.
	 * <b>Precondición</b>: el usuario es miembro del diccionario.
	 * @param nom_usuario nombre de usuario perteneciente al usuario a dar de baja.
	 * @return No retorna nada. */
	public void delete(String nom_usuario){
		this.hUsu.remove(nom_usuario);
	}
	
	/** Método que carga la colección de usuarios desde la base de datos.
	 * 
	 * @return Diccionario de usuarios.
	 * @throws SQLException
	 */
	public Hashtable<String, Usuario> cargaDesdeBD() throws SQLException{
		Hashtable<String, Usuario> usuarios = new Hashtable<String, Usuario>();
		ResultSet rs = null;
		
		rs = BD.ConTablaUS();
		
		while(rs.next()){
			Usuario usu = new Usuario();
			usuarios.put(rs.getString("id_usuario"), usu.cargaDesdeBD(rs.getInt("id_usuario"), rs.getString("pass_admin"), rs.getBoolean("habilitado")));
	
		}
		
		return usuarios;
	}
	
	/** Método que retorna la colección de usuarios
	 * @return Hashtable
	 */
	public Hashtable<String, Usuario> getColection(){
		return hUsu;
	}
	
	/** Carga la tabla con la cédula y el nombre del usuario 
	 * @return TableModel
	 * @throws SQLException 
	 */
	public DefaultTableModel DevTablaUsuario() throws SQLException{
		String col[] = {"Cédula","Nombre", "Habilitado"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);
		
		Enumeration<Usuario> eUsu = hUsu.elements();
		Usuario usu;
		
		while(eUsu.hasMoreElements()){
			usu = eUsu.nextElement();
			boolean hab = usu.getHabilitado();
			String habi = String.valueOf(hab);
			//System.out.println(usu.getCi());
			/*if(usu.getCi().equals(" ")){ //Para que no imprima usuario de grupo u oficina
				System.out.println("Entra");
			}*/
			String carga [] = {usu.getCi(), usu.getNombre()+" "+usu.getApellido(), habi};
			
			if(usu.getPass_admin().equals("null")){ // para que no traiga los usuarios administradores
				if(!carga[1].equals("null null")){ //Para evitar que imprima usuarios de Grupo u Oficina	
					modelo.addRow(carga);
				}
			}
		}
		
		return modelo;
	}
	
	
	/**
	 * Table Model con Administradores
	 * @return Table Model
	 */
	public DefaultTableModel DevTablaAdmins(){
		String col[] = {"Cédula","Nombre", "Habilitado"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);
		
		Enumeration<Usuario> eUsu = hUsu.elements();
		Usuario usu;
		
		while(eUsu.hasMoreElements()){
			usu = eUsu.nextElement();
			boolean hab = usu.getHabilitado();
			String habi = String.valueOf(hab);
			
			String carga [] = {usu.getCi(), usu.getNombre()+" "+usu.getApellido(), habi};
			if(!usu.getPass_admin().equals("null")){
				modelo.addRow(carga);
			}	
		}
		
		return modelo;
	}
	
	/**
	 * Coprueba que no existan usuarioss ingresados en la base. 
	 * Utilizada para primer ingreso
	 * @return true si la base no riene ingresado usuarios
	 * @throws SQLException
	 */
	public boolean CompurebaVacio() throws SQLException{
		ResultSet rs = null;
		try {
			rs = BD.DevTodoUsuario();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!rs.next()){
			return true;
		}
		return false;
		
	}
	
	/**
	 * Comprueba con el id de usuario si es una oficina
	 * @param id
	 * @return Devuelve true si es oficina
	 * @throws SQLException
	 */
	public boolean esOficina(int id) throws SQLException{
		ResultSet rs = null;
		rs = BD.TraeOficina(id);
		if (rs.next()){
			return true;
		}
		return false;
		
		
	}
	
	/**
	 * Proporciona el nombre del grupo u oficina a travez del id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String nombreOficina(int id)throws SQLException{
		ResultSet rs = null;
		rs = BD.TraeOficina(id);
		String of="";
		while(rs.next()){
			of = rs.getString("nombre");
		}
		return of;
	}
	
	
	

}
