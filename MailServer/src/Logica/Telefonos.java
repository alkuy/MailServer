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
	
	public ArrayList<Telefono> cargaDesdeBD(int idUsu) throws SQLException{	//tengo que poner aca el rs para cargar los 2 telefonos
		ArrayList<Telefono> auxTels = new ArrayList<Telefono>();
//		ResultSet rs = BD.ConFilaTel(idUsu);
		Telefono tel = new Telefono();
		auxTels.add(tel.cargaDesdeBD(idUsu));
		
		System.out.println("TELEFONOS | " + idUsu);
		imprimirTels(auxTels);
//		System.out.println("ANTES DE RETORNAR");
		return auxTels;
	}
	
	public ArrayList<Telefono> getSetTelefonos() {
		return setTelefonos;
	}
	
	public String retornarTelx(ArrayList<Telefono> tels, int x){
//		tel1=tels.get(0).getNumTel();
//		tel1=tels.get(x).getNumTel();
//		tel2=tels.get(1).getNumTel();
		return tels.get(x).getNumTel();
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
