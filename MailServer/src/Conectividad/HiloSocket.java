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
		java.sql.ResultSet rs, rsUsu;
		String NomDom, NomUsu, DomUsu, CuentaUsu, Nombre, Apellido, NomComp;
		int Prioridad, Id;
		NomComp = "";
		
		try {
			rs = BD.ConTablaDom();
			while (rs.next()){
				NomDom = rs.getString("nom_dominio");
				Prioridad = rs.getInt("prioridad");
				salida.writeUTF(NomDom);
				salida.writeInt(Prioridad);
			}
			salida.writeUTF("finDom");
		} catch (IOException | SQLException e){	}
		
		
		try {
			rs = BD.ConTablaCuenta();
		
			while (rs.next()){
				NomUsu = rs.getString("nom_usuario");
				DomUsu = rs.getString("nom_dominio");
				CuentaUsu = NomUsu+"@"+DomUsu;
				Id = rs.getInt("id_usuario");
				
				rsUsu = BD.ConFilaPer(Id);
				while(rsUsu.next()){
					Nombre = rsUsu.getString("nombre");
					Apellido = rsUsu.getString("apellido");
					NomComp = Nombre+" "+Apellido;
				}
				salida.writeUTF(NomComp);
				salida.writeUTF(CuentaUsu);
			}
			salida.writeUTF("fin");
		} catch (IOException | SQLException e){	}
		
		Desconectar();
	}
}
