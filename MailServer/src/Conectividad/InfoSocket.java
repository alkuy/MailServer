package Conectividad;

import java.net.*;
import java.sql.SQLException;
import java.io.*;

public class InfoSocket extends Thread {

	private static InfoSocket instancia;
	private ServerSocket server;
	private Socket socket;
	private int puerto = 5000;
	
	//Esta clase utiliza el patron Singleton
	public static InfoSocket getInstancia() throws SQLException{
		if (instancia == null)
			instancia = new InfoSocket();
					
		return instancia;
	}
	
	public InfoSocket(){
		
	}
	
	@Override
	public void run(){
		try{
			server = new ServerSocket(puerto);
			int IdSession = 0;
			
			while (true){
				socket = new Socket();
				socket = server.accept();
				((HiloSocket) new HiloSocket(socket, IdSession)).start();
				IdSession++;
			}
		}catch(Exception e){};
	}
	
	
}
