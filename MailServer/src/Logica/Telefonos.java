package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import Persistencia.FachadaBD;


public class Telefonos {
	
	private ArrayList<Telefono> setTelefonos;
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	public Telefonos() {
		this.setTelefonos = new ArrayList<>();
	}
	
	public Telefonos(int id) throws SQLException{
		this.setTelefonos = cargaDesdeBD(id);
	}
	
	public void Insertar (Telefono tel){
		this.setTelefonos.add(tel);
	}
	
	public void Modificar(int id_usuario, String oldTel, String newTel, int tel1o2){
		this.setTelefonos.get(tel1o2).setNumTel(newTel);
		BD.Modifica_tel(id_usuario, oldTel, newTel);
	}
	
	public ArrayList<Telefono> cargaDesdeBD(int idUsu) throws SQLException{
		ArrayList<Telefono> auxTels = new ArrayList<Telefono>();
		ResultSet rs = BD.ConFilaTel(idUsu);
		
		while(rs.next()){
			Telefono tel = new Telefono(idUsu, rs.getString("telefono"));
			auxTels.add(tel);
		}
		return auxTels;
	}
	
	public ArrayList<Telefono> getSetTelefonos() {
		return setTelefonos;
	}
	
	public String retornarTelx(ArrayList<Telefono> tels, int x){
		int cont=0;
		Iterator<Telefono> iteTels = tels.iterator();
		while(iteTels.hasNext()){
			Telefono auxTel = iteTels.next();
			if(cont==x)
				return auxTel.getNumTel();
			cont++;
		}
		return "";
	}
	
	public void imprimirTels(ArrayList<Telefono> tels){
		Iterator<Telefono> iteTels = tels.iterator();
		while(iteTels.hasNext()){
			Telefono auxTel = iteTels.next();
			System.out.println(auxTel.getId());
			System.out.println(auxTel.getNumTel());
		}
	}
	
	

}
