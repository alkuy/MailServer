package Conectividad;

import java.net.*;
import java.sql.SQLException;
import java.io.*;

public class InfoSocket extends Thread {

	private static InfoSocket instancia;
	private ServerSocket server;
	private Socket socket;
	private DataInputStream entrada;
	private int puerto = 6000;
	
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
		String mensaje;
		try{
			server = new ServerSocket(puerto);
			int IdSession = 0;
			
			while (true){
				socket = new Socket();
				socket = server.accept();
				entrada = new DataInputStream(socket.getInputStream());
				
				mensaje = entrada.readUTF();
				if (mensaje.compareToIgnoreCase("Conn") == 0)
					((HiloSocket) new HiloSocket(socket, IdSession)).start();
				else if (mensaje.compareToIgnoreCase("Auth") == 0)
					((HiloLoginSocket) new HiloLoginSocket(socket, IdSession)).start();
				else if (mensaje.compareToIgnoreCase("Old") == 0)
					((HiloCAntiguoSocket) new HiloCAntiguoSocket(socket, IdSession)).start();
				else if (mensaje.compareToIgnoreCase("Pass") == 0)
					((HiloCambioPassSocket) new HiloCambioPassSocket(socket, IdSession)).start();
				else
					((HiloUsuSocket) new HiloUsuSocket(socket, IdSession)).start();
				IdSession++;
			}
		}catch(Exception e){};
	}
	
	
}
