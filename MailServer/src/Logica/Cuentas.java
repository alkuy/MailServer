package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Persistencia.FachadaBD;

public class Cuentas {
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	private ArrayList<Cuenta> setCuentas;
	private static Cuentas instancia;
	public static Cuentas getInstancia() {
		if(instancia == null)
			instancia = new Cuentas();
		
		return instancia;
	}

	
	/** Método constructor de la colección Cuentas. */
	public Cuentas() {
		this.setCuentas = new ArrayList<>();
	}
	
	public Cuentas(int id_usuario) {
		this.setCuentas = this.cargaCuentasDeUsuariodesdeBD(id_usuario);
	}
	
	/** Método que da de alta un cuenta al set.
	 * <BR><b>Precondición</b>: la cuenta a dar de alta no es miembro del set.</BR>
	 * @param cuenta Cuenta a dar de alta en la colección.
	 * @return No retorna nada. */
	public void Insertar(Cuenta cuenta){
		this.setCuentas.add(cuenta);
		BD.InsertCuenta(cuenta.getId(), cuenta.getNom_u(), cuenta.getDominio(), cuenta.getContraseña_cuenta(), cuenta.getEs_lista());
	}
	
	/** Determina sí el set está vacío o no.
	 * @param setCuentas Colección de cuentas a verificar.
	 * @return <u>True</u>: si la colección es vacía.
	 * <BR><u>False</u>: si la colección <b>NO</b> es vacía.</BR> */
	public boolean EsVacio(Cuentas setCuentas){
		return setCuentas == null;
	}
	
	/** Método que determina si la cuenta forma parte del set o no.
	 * @param cuenta Cuenta a verificar su existencia en la colección.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public boolean Pertenece(Cuenta cuenta){
		for(int i=0; i < setCuentas.size(); i++)
			if(setCuentas.get(i).equals(cuenta))
				return true;
		return false;
	}
	
	/** Método que da de baja a la cuenta del Set.
	 * <BR><b>Precondición</b>: la cuenta especificada pertenece al Set.</BR>
	 * @param cuenta Cuenta a verificar su existencia en la colección.
	 * @return <u>True</u>: si encuentra coincidencia.
	 * <BR><u>False</u>: si <b>NO</b> encuentra coincidencia.</BR> */
	public void Borrar(Cuenta cuenta){
		this.setCuentas.remove(cuenta);
	}
	
	/** Método que retorna la coleccion Set de Cuentas.
	 * <BR><b>Precondición</b>: la colección no debe ser vacía.</BR>
	 * @return Retorna el set de Cuentas. */
	public ArrayList<Cuenta> getsetCuentas(){
		return setCuentas;
	}
	
	/**
	 * Metodo que carga cuentas desde la base en arrayList
	 * @return ArrayList con cuentas
	 */
	public ArrayList<Cuenta> cargaCuentasdesdeBD(){
		ArrayList<Cuenta> set = new ArrayList<Cuenta>();
		ResultSet rs = null;
		try {
			rs = BD.ConTablaCuenta();
			while (rs.next()){
				Cuenta c = new Cuenta();
				int id_user = rs.getInt("id_usuario");
				String nom_u = rs.getString("nom_usuario");
				String nom_d = rs.getString("nom_dominio");
				boolean habilitada = rs.getBoolean("habilitada");
				c.setIdUsuario(id_user);
				c.setNomU(nom_u);
				c.setDominio(nom_d);
				c.setHabilitada(habilitada);
				set.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return set;
		
	}
	/**
	 * Carha el Array list con las cuentas a partir del id de usuario
	 * @param id_usuario
	 * @return ArryList
	 */
	public ArrayList<Cuenta> cargaCuentasDeUsuariodesdeBD(int id_usuario){
		ArrayList<Cuenta> set = new ArrayList<Cuenta>();
		ResultSet rs = null;
		try {
			rs = BD.ConTablaCuentaID(id_usuario);
			while (rs.next()){
				Cuenta auxCuenta = new Cuenta();
				auxCuenta.setIdUsuario(rs.getInt("id_usuario"));
				auxCuenta.setNomU(rs.getString("nom_usuario"));
				auxCuenta.setDominio(rs.getString("nom_dominio"));
				auxCuenta.setHabilitada(rs.getBoolean("habilitada"));
				set.add(auxCuenta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return set;
		
	}
	
	/**
	 * Carga la tabla con el Id de Usuario y la cuenta concatenando nombre y dominio
	 * @return TableModel
	 * @throws SQLException
	 */
	public DefaultTableModel DevTablaCuenta(){
		ArrayList<Cuenta> auxCuentas = this.cargaCuentasdesdeBD();
		String col[] = {"Id_Usuario","Cuenta", "Habilitada"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);

		for (int i=0; i < auxCuentas.size(); i++){
			String id, cuenta;
			int id_user;
			String nomUser, nomDominio;
			
			
			nomUser = auxCuentas.get(i).getNom_u();
			nomDominio = auxCuentas.get(i).getDominio();
			id_user = auxCuentas.get(i).getId();
			boolean habilitado = auxCuentas.get(i).isHabilitada();
			String habi = String.valueOf(habilitado);
			id=""+id_user;
			cuenta = nomUser+"@"+nomDominio;
			
			
			String carga [] = {id, cuenta, habi};	   
		   	modelo.addRow(carga);
		}
		return modelo;
	}

	/**
	 * Resetea el passwor de cuentas de personas
	 * Vuelve a ser el numero de documento
	 * @param id
	 * @param nom_us
	 * @param nom_dom
	 * @param pass
	 */
	public void resetPass(int id, String nom_us, String nom_dom, String pass){
		Iterator<Cuenta> iteCuentas = this.setCuentas.iterator();
		while(iteCuentas.hasNext()){
			Cuenta auxCuenta = iteCuentas.next();
			if(auxCuenta.getNom_u().equals(nom_us) && auxCuenta.getDominio().equals(nom_dom)){
				auxCuenta.setContraseña_cuenta(pass);
				BD.Modifica_cuentaPS(id, nom_us, nom_dom, pass);
			}
		}
	}
	
	/**
	 * Cambia el password de la cuenta en la base y memoria
	 * @param nom_us
	 * @param nom_dom
	 * @param pass
	 */
	public void cambiaPass(String nom_us, String nom_dom, String pass){
		Iterator<Cuenta> iteCuentas = this.setCuentas.iterator();
		while(iteCuentas.hasNext()){
			Cuenta auxCuenta = iteCuentas.next();
			if(auxCuenta.getNom_u().equals(nom_us) && auxCuenta.getDominio().equals(nom_dom)){
				auxCuenta.setContraseña_cuenta(pass);
				BD.Cambia_Psswd(nom_us, nom_dom, pass);
			}
		}
	}
	
	
	
	
	
	
	public void deshabCuenta(int id, String nom_us, String nom_dom, boolean habilitada){
		Iterator<Cuenta> iteCuentas = this.setCuentas.iterator();
		while(iteCuentas.hasNext()){
			Cuenta auxCuenta = iteCuentas.next();
			if(auxCuenta.getNom_u().equals(nom_us) && auxCuenta.getDominio().equals(nom_dom)){
				auxCuenta.setHabilitada(habilitada);
				BD.deshabCuenta(id, nom_us, nom_dom, habilitada);
			}
		}
	}
	
	public boolean desOhabCuenta(int id, String nom_us, String nom_dom){
		Iterator<Cuenta> iteCuentas = this.setCuentas.iterator();
		while(iteCuentas.hasNext()){
			Cuenta auxCuenta = iteCuentas.next();
			if(auxCuenta.getNom_u().equals(nom_us) && auxCuenta.getDominio().equals(nom_dom)){
				return auxCuenta.isHabilitada();
			}
		}
		return true;
	}
	
	public void imprimir(){
		Iterator<Cuenta> iteCuentas = this.setCuentas.iterator();
		while(iteCuentas.hasNext()){
			Cuenta auxCuenta = iteCuentas.next();
			
			System.out.println(
					auxCuenta.getId()+
					auxCuenta.getNom_u()+
					auxCuenta.getDominio()
					);
			
		}
	}
	
	/**
	 * Devuelve las cuentas de determinado usuario
	 * @param idUsuario
	 * @return
	 */
	public DefaultTableModel DevTablaCuentasUsuario(int idUsuario){
		ArrayList<Cuenta> auxCuentas = this.cargaCuentasdesdeBD();
		String col[] = {"Cuenta", "Habilitada"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);

		for (int i=0; i < auxCuentas.size(); i++){
			String cuenta;
			String nomUser, nomDominio;
			
			
			if (idUsuario == auxCuentas.get(i).getId()){
				nomUser = auxCuentas.get(i).getNom_u();
				nomDominio = auxCuentas.get(i).getDominio();
				//id_user = setCuentas.get(i).getId();
				boolean habilitado = auxCuentas.get(i).isHabilitada();
				String habi = String.valueOf(habilitado);
				//id=""+id_user;
				cuenta = nomUser+"@"+nomDominio;
				String carga [] = {cuenta, habi};	   
			   	modelo.addRow(carga);
			}
			
			
		}
		return modelo;
	}

	public boolean comprueba_cuenta(String usu, String dom){
		ArrayList<Cuenta> auxCuentas = this.cargaCuentasdesdeBD();
		String usuario, dominio, cadena1, cadena2;
		cadena2 = usu+dom;
		for (int i = 0; i < auxCuentas.size(); i++){ // sigo sin resolver bien esto
			usuario = auxCuentas.get(i).getNom_u().toString();
			dominio = auxCuentas.get(i).getDominio().toString();
			cadena1 = usuario+dominio;
			/*comparo lo ingresado con lo existente en el arraylist*/
			
			if (cadena1.equals(cadena2)){
				return true;
			}
			
		}
		return false;
	}
	
	public void habilitaOficina(int id, boolean habilita)throws SQLException{
		BD.habilitaOficina(id, habilita);
	}
	
	
	/**
	 * Se fija si la cuenta de Oficina esta Habilitada
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean estaHabilitadaOf(int id)throws SQLException{
		ResultSet rs = null;
		rs = BD.ConTablaCuentaID(id);
		boolean esta = false;
		while(rs.next()){
			esta = rs.getBoolean("habilitada");
		}
		return esta;
		
	}
	
}
