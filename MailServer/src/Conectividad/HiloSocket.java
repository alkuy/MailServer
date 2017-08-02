package Conectividad;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import Persistencia.FachadaBD;

public class HiloSocket extends Thread{
	
	private Socket socket;
	private DataOutputStream salida;
	private BufferedReader entrada;
	private int IdSession;
	private FachadaBD BD = FachadaBD.getInstancia();
	
	public  HiloSocket(Socket S, int Id){
		this.socket = S;
		this.IdSession = Id;
		try {
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
		java.sql.ResultSet rs;
		String NomDom, respuesta;
		int Prioridad;
		
		try {
			rs = BD.ConTablaDom();
			while (rs.next()){
				NomDom = rs.getString("nom_dominio");
				Prioridad = rs.getInt("prioridad");
				salida.writeUTF(NomDom);
				//respuesta = entrada.readLine();
				salida.writeInt(Prioridad);
				//respuesta = entrada.readLine();
			}
			salida.writeUTF("fin");
		} catch (IOException | SQLException e){	}
		
		Desconectar();
	}
}
