package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;

import Persistencia.FachadaBD;


public class Telefono {
	
	private String numTel;
	private int id;
//	private int tipoTel;

	FachadaBD BD = FachadaBD.getInstancia();
	
	public Telefono(){
		
	}
	
	public Telefono(int idUsu, String numTel) {
		this.numTel = numTel;
		this.id = idUsu;
		//BD.InsertTel(idUsu, numTel);
	}
		
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNumTel() {
		return numTel;
	}
	
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	public void InsertTel(int idUsu, String numTel){
		
		if (!numTel.equals("")){
			
			BD.InsertTel(idUsu, numTel);
			
		}
	}
	
	/*public Telefono cargaDesdeBD(int idUsu) throws SQLException{
		ResultSet rs = BD.ConFilaTel(idUsu);
		Telefono tel = new Telefono();
		tel.id = idUsu;
		String numTel=null;
		if(rs.next()){
			tel.numTel = rs.getString("telefono");
		}
		
		return tel;
	}*/
	
	

}
