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

public class HiloUsuSocket extends Thread {

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
	
	public  HiloUsuSocket(Socket S, int Id){
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
	
//    public void getMailsBDUsu(String Usu) throws FolderException, Exception {
//    	String mailFrom, mailTo, mailSubjet, mailText; 
//    	String NomEmi, DomEmi, NomDest, DomDest, DestPass;
//    	java.sql.ResultSet rs = FC.ObtieneCorreosBDUsu(Usu);
//    	GreenMailUser Usuario;
//    	Managers managers = new Managers();
//    	
//    	while(rs.next()){
//    		
//    		NomEmi = rs.getString("nom_usuario_emisor");
//    		DomEmi = rs.getString("nom_dominio_emisor");
//    		NomDest = rs.getString("nom_usuario_receptor");
//    		DomDest = rs.getString("nom_dominio_receptor");
//    		mailFrom = NomEmi+"@"+DomEmi;
//    		mailTo = NomDest+"@"+DomDest;
//    		mailSubjet = rs.getString("asunto");
//    		mailText = rs.getString("texto");
//    		
//    		//Crea un mensaje con JavaMail
//    		MimeMessage message = new MimeMessage((Session) null);
//            message.setFrom(new InternetAddress(mailFrom));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
//            mailTo));
//            message.setSubject(mailSubjet);
//            message.setText(mailText);
//            
//            DestPass = FC.ObtenPass(NomDest);
//            //Usuario = managers.getUserManager().getUser(Usu);
//            Usuario = POPServer.setUser(Usu, DomDest, DestPass);
//            
//            //Almacenamos los mensaje en memoria para el INBOX de cada usuario
//            //POPServer.getManagers().getImapHostManager().getInbox(Usuario).store(message);
//            Usuario.deliver(message);
//    	}
//    }

	@Override
	public void run(){
		String NomUsu, Signal, msg, DomUsu;
		
		try {
			POP3Serv POP3 = POP3Serv.getInstancia();
			NomUsu = entrada.readUTF();
			DomUsu = entrada.readUTF();
			POP3.getMailsBDUsu(NomUsu, DomUsu);
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
