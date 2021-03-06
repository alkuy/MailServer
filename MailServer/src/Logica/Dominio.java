package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Persistencia.FachadaBD;

public class Dominio {
	
	private String nombre_dominio;
	private int prioridad;
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	public Dominio(){
		
	}
	/** M�todo constructor de la clase.
	 * @param nombre_dominio Nombre de dominio. 
	 * @param prioridad Prioridad del dominio */
	public Dominio(String nombre_dominio, int prioridad) {
		this.nombre_dominio = nombre_dominio;
		this.prioridad = prioridad;
		BD.InsertDom(nombre_dominio, prioridad);
	}
	
	/** M�todo que retorna el nombre de nombre de dominio.
	 * @return Nombre de dominio. */
	public String getNombre_dominio() {
		return nombre_dominio;
	}
	
	/** M�todo que retorna la prioridad del dominio.
	 * @return Prioridad del dominio. */
	public int getPrioridad() {
		return prioridad;
	}
	

	public void setNombre_dominio(String nombre_dominio) {
		this.nombre_dominio = nombre_dominio;
	}
	
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	

	/** M�todo que retoena un array con los dominios cargados en la base 
	 * @return ArrayList con dominios y prioridades 
	 */
	public ArrayList<Dominio> carga_dominios(){
		ArrayList<Dominio> dominios = new ArrayList<Dominio>();
		ResultSet rs = null;
		
		try {
			rs=BD.ConTablaDom();
			while(rs.next()){
				Dominio doms = new Dominio();
				doms.nombre_dominio = rs.getString("nom_dominio");
				doms.prioridad = rs.getInt("prioridad");
				dominios.add(doms);
			
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		return dominios;
		
	}
	
/**
 * M�todo que solo trae nombres de dominios para comboBox	
 * @return ArrayList<String>
 */
	public ArrayList<String> carga_nom_dom(){
		ArrayList<String> dominios = new ArrayList<String>();
		ResultSet rs = null;
		
		try {
			rs=BD.ConTablaDom();
			while(rs.next()){
				String dom_nom = rs.getString("nom_dominio");
				dominios.add(dom_nom);
			
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		return dominios;
		
	}
	
	/**
	 * Tabla con los dominios
	 * @return modeltable
	 * @throws SQLException
	 */
	public DefaultTableModel DevTablaDom() throws SQLException{
		
		JTable tblMDominios;			
		String col[] = {"Dominio","Prioridad"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);
						
		tblMDominios = new JTable(modelo);
		tblMDominios.setRowSelectionAllowed(false);
		tblMDominios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
			java.sql.ResultSet rs;
			rs = BD.ConTablaDom();
			// Bucle para cada resultado en la consulta
			while (rs.next())
			{
			   // Se crea un array que ser una de las filas de la tabla.
			   Object [] fila = new Object[2]; // Hay dos columnas en la tabla

			   // Se rellena cada posicion del array con una de las columnas de la tabla en base de datos.
			   for (int i=0;i<2;i++)
			      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

			   // Se anade al modelo la fila completa.
			   modelo.addRow(fila);
			}
						
		
		return modelo;
	}

	/**
	 * Trae la prioridad del dominio que le pasemos
	 * @param Dominio
	 * @return prioridad (int)
	 */
	public int trae_prioridad(String Dominio){
		java.sql.ResultSet rs;
		int pri = 0;
		try {
			rs = BD.ConFilaDom(Dominio);
			while (rs.next()){
				pri = rs.getInt("prioridad");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pri;
		
	}
	
/*-----------------------------------------------------------------*/
}
