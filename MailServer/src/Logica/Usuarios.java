package Logica;

import java.util.Hashtable;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
*/ 

public class Usuarios {
	
	private Hashtable<String, Usuario> hUsu;
	
	/** M�todo constructor de la colecci�n Usuarios. */
	public Usuarios() {
		this.hUsu = new Hashtable<>();
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
		return this.hUsu.get(nom_usuario);
	}
	
	/** M�todo que sustituye el viejo usuario en el diccionario por el nuevo usuario.
	 * <b>Precondici�n</b>: el usuario es miembro del diccionario.
	 * @param usu usuario a modificar en la colecci�n Usuarios.
	 * @return No retorna nada. */
	public void modify(Usuario usu){
		delete(usu.getNom_usuario());
		this.hUsu.put(usu.getNom_usuario(), usu);
	}
	
	/** M�todo que dado nombre de usuario de un usuario lo dada de baja del diccionario.
	 * <b>Precondici�n</b>: el usuario es miembro del diccionario.
	 * @param nom_usuario nombre de usuario perteneciente al usuario a dar de baja.
	 * @return No retorna nada. */
	public void delete(String nom_usuario){
		this.hUsu.remove(nom_usuario);
	}

}
