package Logica;

import java.util.ArrayList;

public class Telefonos {
	
	private ArrayList<Telefono> setTelefonos;
	
	public Telefonos() {
		this.setTelefonos = new ArrayList<>();
	}
	
	public void Insertar (Telefono tel){
		this.setTelefonos.add(tel);
	}

}
