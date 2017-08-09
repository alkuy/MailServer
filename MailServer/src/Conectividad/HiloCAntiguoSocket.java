package Conectividad;

import java.io.*;
import java.net.*;
import java.util.Properties;
import java.sql.SQLException;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.icegreen.greenmail.Managers;
import com.icegreen.greenmail.store.FolderException;
import com.icegreen.greenmail.user.GreenMailUser;
import com.icegreen.greenmail.user.UserException;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;

import Logica.Fachada;


import Persistencia.FachadaBD;

public class HiloCAntiguoSocket extends Thread {

	private Socket socket;
	private DataOutputStream salida;
	private DataInputStream entrada;
	private int IdSession;
	
	private FachadaBD BD = FachadaBD.getInstancia();
//	private GreenMail POPServer;
	Fachada FC = Fachada.getInstancia();
	
//    public void setUp() {
//        POPServer = new GreenMail(ServerSetupTest.POP3);
//        POPServer.start();
//    }
    
//    public void tearDown() {
//        POPServer.stop();
//    }
	
	public  HiloCAntiguoSocket(Socket S, int Id){
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
		String NomUsu, msg, fecha, Signal;
		boolean Enviado = false;
		
		try {
			NomUsu = entrada.readUTF();
			java.sql.ResultSet rs = FC.ObtieneCorreosBDUsu(NomUsu);
			
			while(rs.next()){
				fecha = rs.getString("fecha");
				
	    		//Arregla la fecha para que pueda hacer el Update en la BD
	    		String anio = fecha.substring(0, fecha.indexOf(" "));
	    		String[] Arr = anio.split("-");
	    		String[] hora = fecha.split("\\s");
	    		fecha = Arr[0]+Arr[1]+Arr[2]+" "+hora[1];
	    		
	    		FC.Correo_Enviado(fecha, Enviado);
			}
			
			POP3Serv POP3 = POP3Serv.getInstancia();
			POP3.getMailsBDUsu(NomUsu);
			msg = "Echo";
			salida.writeUTF(msg);
			Signal = entrada.readUTF();
			if (Signal.equals("OK")){
				POP3.BorraMailDeBoxes();
			}else
				System.out.println("Error en Conexion POP3");
		} catch (Exception e){}
		Desconectar();
	}
}
