package Logica;

import Persistencia.FachadaBD;

public class Telefono {
	
	private String numTel;
//	private int tipoTel;
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	public Telefono(int idUsu, String numTel) {
		this.numTel = numTel;
		BD.InsertTel(idUsu, numTel);
	}
	
	public String getNumTel() {
		return numTel;
	}
	
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

}
