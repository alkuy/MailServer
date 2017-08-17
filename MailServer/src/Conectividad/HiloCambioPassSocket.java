package Conectividad;

import java.io.*;
import java.net.*;
import Logica.Fachada;


import Persistencia.FachadaBD;

public class HiloCambioPassSocket extends Thread {

	private Socket socket;
	private DataOutputStream salida;
	private DataInputStream entrada;
	private int IdSession;
	
	private FachadaBD BD = FachadaBD.getInstancia();

	Fachada FC = Fachada.getInstancia();

	
	public  HiloCambioPassSocket(Socket S, int Id){
		this.socket = S;
		this.IdSession = Id;
		try {
			entrada = new DataInputStream(socket.getInputStream());
			salida = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e){}
	}
	
	public void Desconectar(){
		try{
			socket.close();
		} catch (IOException e){}
	}
	

	@Override
	public void run(){
		String NomUsu, DomUsu, OldPass, msg, Pass, Signal;
		
		try {
			NomUsu = entrada.readUTF();
			
			DomUsu = entrada.readUTF();
			
			OldPass = entrada.readUTF();
			
			Pass = entrada.readUTF();

			Signal = entrada.readUTF();
			
			
			if (Signal.equals("OK")){
				FC.cambiaPassCuenta(NomUsu, DomUsu, OldPass);
			}else
				System.out.println("Error en Conexion");
		}catch (Exception e){}
		
		Desconectar();
	}
}
