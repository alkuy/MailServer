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
				FC.cambiaPassCuenta(NomUsu, DomUsu, OldPass, Pass);
			}else
				System.out.println("Error en Conexion");
		}catch (Exception e){}
		
		Desconectar();
	}
}
