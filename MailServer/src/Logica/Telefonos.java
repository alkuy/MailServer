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
	
	/*public ArrayList<Telefono> cargaDesdeBD(int idUsu) throws SQLException{	//tengo que poner aca el rs para cargar los 2 telefonos
		ArrayList<Telefono> auxTels = new ArrayList<Telefono>();
		Telefono tel = new Telefono();
		auxTels.add(tel.cargaDesdeBD(idUsu));
		
		System.out.println("TELEFONOS | " + idUsu);
		imprimirTels(auxTels);
		return auxTels;
	}*/
	public ArrayList<Telefono> cargaDesdeBD(int idUsu) throws SQLException{
		ArrayList<Telefono> auxTels = new ArrayList<Telefono>();
		ResultSet rs = BD.ConFilaTel(idUsu);
//		Telefono tel = new Telefono();
		
		while(rs.next()){
			Telefono tel = new Telefono(idUsu, rs.getString("telefono"));
			auxTels.add(tel);
		}
		
//		System.out.println("TELEFONOS | " + idUsu);
//		imprimirTels(auxTels);
		return auxTels;
	}
	
	public ArrayList<Telefono> getSetTelefonos() {
		return setTelefonos;
	}
	
	public String retornarTelx(ArrayList<Telefono> tels, int x){
//		String numTel;
//		System.out.println("ANTES"+x);
//		if(tels.get(x). != null){
//			System.out.println("SOY UN PUTO NULL con "+x);
//			numTel = tels.get(x).getNumTel();
//		}
//		else
//			numTel = "";
//		return numTel;
		
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
