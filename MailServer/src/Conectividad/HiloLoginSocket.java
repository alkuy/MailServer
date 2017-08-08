package Conectividad;

import static grafica.FrmMuestraCuentas.id;

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

public class HiloLoginSocket extends Thread {
	
	private Socket socket;
	private DataOutputStream salida;
	private DataInputStream entrada;
	private int IdSession;
	
	private FachadaBD BD = FachadaBD.getInstancia();
	private Fachada FC = Fachada.getInstancia();
	
	
	public  HiloLoginSocket(Socket S, int Id){
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
		String NomUsu, NomDom, Pass, P ,msg;
		
		try {
			
			NomUsu = entrada.readUTF();
			NomDom = entrada.readUTF();
			Pass = entrada.readUTF();

			if (FC.VerificaCuenta(NomUsu, NomDom) && FC.desOhabCuenta(Integer.valueOf(id), NomUsu, NomDom)){
				P = FC.ObtenPass(NomUsu);
				if (Pass.compareTo(P) == 0)
					msg = "Valido";
				else
					msg = "NoPass";
			}else{
				msg = "NoCuenta";
			}
			
			salida.writeUTF(msg);
		} catch (Exception e){}
		
		Desconectar();
	}

}
