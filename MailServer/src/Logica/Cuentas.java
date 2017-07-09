package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Persistencia.FachadaBD;

/** Clase de ejemplo que muestra la sintaxis
 * elemental de un programa en java
 * @author 
 * @version 1.0
 * 
*/ 


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
		this.setCuentas = this.cargaCuentasdesdeBD();
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
				c.setIdUsuario(id_user);
				c.setNomU(nom_u);
				c.setDominio(nom_d);
				set.add(c);
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
				
		String col[] = {"Id_Usuario","Cuenta"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);

		for (int i=0; i < setCuentas.size(); i++){
			String id, cuenta;
			int id_user;
			String nomUser, nomDominio;
			
			nomUser = setCuentas.get(i).getNom_u();
			nomDominio = setCuentas.get(i).getDominio();
			id_user = setCuentas.get(i).getId();
			
			id=""+id_user;
			cuenta = nomUser+"@"+nomDominio;
			
			String carga [] = {id, cuenta};	   
		   	modelo.addRow(carga);
		}
		return modelo;
	}

	public void modify(int id, String nom_us, String nom_dom, String pass){
//		BD.Modifica_cuentaPS(id, nom_us, nom_dom, pass);
		
//		ArrayList<Cuenta> cuentas = this.getsetCuentas();
// 		Iterator<Cuenta> aux = cuentas.iterator();
// 		while(aux.hasNext()){
// 			if(aux.next().getNom_u().equals(nom_us))
// 				aux.next().setContraseña_cuenta(pass);
// 		}
// 		System.out.println("Dentro de cuentas " + aux.next().getContraseña_cuenta());
	}
	


}
