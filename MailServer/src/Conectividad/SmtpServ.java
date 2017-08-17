package Conectividad;

import Logica.Cuenta;
import Logica.Fachada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Iterator;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.table.DefaultTableModel;

import com.icegreen.greenmail.user.UserException;
import com.icegreen.greenmail.user.UserManager;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import com.icegreen.greenmail.util.ServerSetupTest;
import com.sun.mail.smtp.SMTPTransport;
import com.dumbster.smtp.SmtpMessage;
import com.icegreen.greenmail.Managers;
import com.icegreen.greenmail.store.FolderException;
import com.icegreen.greenmail.store.MailFolder;
import com.icegreen.greenmail.user.GreenMailUser;
import com.icegreen.greenmail.smtp.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmtpServ extends Thread{

	 public static GreenMail mailServer;
	 private Thread t;
	 private static final String USER_PASSWORD = "123";
	 private static final String USER_PASSWORD2 = "123";
	 private static final String USER_NAME = "aloustau";
	 private static final String USER_NAME2 = "jgardio";
	 private static final String EMAIL_USER_ADDRESS = "aloustau@inet.com";
	 private static final String EMAIL_USER_ADDRESS2 = "jgardio@ipa.com";
	 private static final String EMAIL_TO = "someone@localhost.com";
	 private static final String EMAIL_SUBJECT = "Test E-Mail";
	 private static final String EMAIL_TEXT = "This is a test e-mail.";
	 private static final String LOCALHOST = "127.0.0.1";
	 private ArrayList<Cuenta> setCuentas;
	 private static SmtpServ instancia;
	 private int cantMails;
	 private Fachada FCLogica = Fachada.getInstancia();
	 
	//Esta clase utiliza el patron Singleton
		public static SmtpServ getInstancia() throws SQLException{
			if (instancia == null)
				instancia = new SmtpServ();
				
			return instancia;
		}
		
		public SmtpServ() throws SQLException{
			setUp();
		}
	 
	    //@Before
	    public void setUp() throws SQLException {
	    	ServerSetup setup = new ServerSetup(3025, "localhost", "smtp");
	        mailServer = new GreenMail(setup);
	        mailServer.start();
	        cargaCuenta();
	    }
	 
	    //@After
	    public void tearDown() {
	        mailServer.stop();
	    }
	    
	    //Esta funcion carga las cuentas de la BD a la API SMTP para que el cliente se pueda autenticar
	    public void cargaCuenta() throws SQLException{
	    	String UserName, UserDom, UserAddress, UserPass;
	    	int UserId;
	    	java.sql.ResultSet rs = null;
	    	
	    	rs = FCLogica.CuentasDesdeBD();
	    	while (rs.next()){
	    		UserName = rs.getString("nom_usuario");
	    		UserDom = rs.getString("nom_dominio");
	    		UserId = rs.getInt("id_usuario");
	    		UserPass = rs.getString("password");
	    		UserAddress = UserName+"@"+UserDom;
	    		mailServer.setUser(UserAddress, UserName, UserPass);
	    	}
	    }
	    
	    //Metodo para cargar cada mail que llega al servidor a la base de datos
	    public void setMailsBD() throws IOException, MessagingException, UserException, InterruptedException, SQLException {
	    	String NomUsu, NomRecp, DomUsu, DomRecp;
	    	int UserIdE, UserIdR;   	
	    	Random rnd = new Random();
	        
	    	MimeMessage[] messages = mailServer.getReceivedMessages();
	        MimeMessage m = messages[0];
 
	        NomUsu = m.getFrom()[0].toString().substring(0, m.getFrom()[0].toString().indexOf("@"));
	        DomUsu = m.getFrom()[0].toString().substring(m.getFrom()[0].toString().indexOf("@")+1);
	        
			NomRecp = m.getHeader("To")[0].toString().substring(0, m.getHeader("To")[0].toString().indexOf("@"));
			DomRecp = m.getHeader("To")[0].toString().substring(m.getHeader("To")[0].toString().indexOf("@")+1);
			
			UserIdE = FCLogica.IdUsuario(NomUsu, DomUsu);
			UserIdR = FCLogica.IdUsuario(NomRecp, DomRecp);
			
			FCLogica.CargaCorreoBD(m.getFrom()[0].toString(), UserIdE, m.getHeader("To")[0].toString(), UserIdR, m.getSubject(),  (int)(rnd.nextDouble() * 10000), m.getContent().toString());
	    }
	    
	    public void getMailsBD() throws SQLException, AddressException, MessagingException, UserException {
	    	String mailFrom, mailTo, mailSubjet, mailText; 
	    	String NomEmi, DomEmi, NomDest, DomDest, DestPass;
	    	java.sql.ResultSet rs = FCLogica.ObtieneCorreosBD();
	    	GreenMailUser Usuario = null;
	    	
	    	while(rs.next()){
	    		
	    		NomEmi = rs.getString("nom_usuario_emisor");
	    		DomEmi = rs.getString("nom_dominio_emisor");
	    		NomDest = rs.getString("nom_usuario_receptor");
	    		DomDest = rs.getString("nom_dominio_receptor");
	    		mailFrom = NomEmi+"@"+DomEmi;
	    		mailTo = NomDest+"@"+DomDest;
	    		mailSubjet = rs.getString("asunto");
	    		mailText = rs.getString("texto");
	    		
	    		//Crea un mensaje con JavaMail
	    		MimeMessage message = new MimeMessage((Session) null);
	            message.setFrom(new InternetAddress(mailFrom));
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
	            mailTo));
	            message.setSubject(mailSubjet);
	            message.setText(mailText);
	            
	            DestPass = FCLogica.ObtenPass(NomDest, DomDest);
	            Usuario = mailServer.setUser(mailTo, DomDest, DestPass);
	            
	            //Almacenamos los mensaje en memoria para el INBOX de cada usuario
	            Usuario.deliver(message);
	    	}
	    	
	    	MimeMessage[] messages = mailServer.getReceivedMessages();
	    	this.cantMails = messages.length;
	    }
	    
//	    public void getMailsBDUsu(String Usu) throws FolderException, Exception {
//	    	String mailFrom, mailTo, mailSubjet, mailText; 
//	    	String NomEmi, DomEmi, NomDest, DomDest, DestPass;
//	    	java.sql.ResultSet rs = FCLogica.ObtieneCorreosBDUsu(Usu);
//	    	GreenMailUser Usuario;
//	    	Managers managers = new Managers();
//	    	
//	    	while(rs.next()){
//	    		
//	    		NomEmi = rs.getString("nom_usuario_emisor");
//	    		DomEmi = rs.getString("nom_dominio_emisor");
//	    		NomDest = rs.getString("nom_usuario_receptor");
//	    		DomDest = rs.getString("nom_dominio_receptor");
//	    		mailFrom = NomEmi+"@"+DomEmi;
//	    		mailTo = NomDest+"@"+DomDest;
//	    		mailSubjet = rs.getString("asunto");
//	    		mailText = rs.getString("texto");
//	    		
//	    		//Crea un mensaje con JavaMail
//	    		MimeMessage message = new MimeMessage((Session) null);
//	            message.setFrom(new InternetAddress(mailFrom));
//	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
//	            mailTo));
//	            message.setSubject(mailSubjet);
//	            message.setText(mailText);
//	            
//	            DestPass = FCLogica.ObtenPass(NomDest);
//	            //Usuario = managers.getUserManager().getUser(Usu);
//	            Usuario = mailServer.setUser(Usu, DomDest, DestPass);
//	            
//	            //Almacenamos los mensaje en memoria para el INBOX de cada usuario
//	            mailServer.getManagers().getImapHostManager().getInbox(Usuario).store(message);
//	            //Usuario.deliver(message);
//	    	}
//	    }
	    
	    @Override
		public void run(){

	    	String NomUsu, NomRecp, DomUsu, DomRecp;
	    	int UserIdE, UserIdR, cont, aux;   	
	    	Random rnd = new Random();
	    	MimeMessage[] messages;
	    	cont = 0;
			while(true){
				messages = mailServer.getReceivedMessages();
		        if (cont < messages.length){
//		        	cont = messages.length;
//		        	aux = cont - this.cantMails;
//		        	cont = 0;
		        	while(cont < messages.length){
		        		MimeMessage m = messages[cont];
		        		try {
		        			
		        			NomUsu = m.getFrom()[0].toString().substring(0, m.getFrom()[0].toString().indexOf("@"));
		        			DomUsu = m.getFrom()[0].toString().substring(m.getFrom()[0].toString().indexOf("@")+1);
		        			
		        			NomRecp = m.getHeader("To")[0].toString().substring(0, m.getHeader("To")[0].toString().indexOf("@"));
		        			DomRecp = m.getHeader("To")[0].toString().substring(m.getHeader("To")[0].toString().indexOf("@")+1);
		        		
		        			UserIdE = FCLogica.IdUsuario(NomUsu, DomUsu);
		        			UserIdR = FCLogica.IdUsuario(NomRecp, DomRecp);
		        		
		        			System.out.println("Nuevo e-mail de " + m.getFrom()[0].toString() + " | " + "Para: " +  m.getHeader("To")[0].toString() + " | " + "Asunto: " +  m.getSubject());
				
		        			FCLogica.CargaCorreoBD(m.getFrom()[0].toString(), UserIdE, m.getHeader("To")[0].toString(), UserIdR, m.getSubject(),  (int)(rnd.nextDouble() * 10000), m.getContent().toString());
		        			cont++;
		        		}catch(Exception e){}
		        	}

		        }

				try {
					mailServer.purgeEmailFromAllMailboxes();
					Thread.sleep(5000);
				}catch (InterruptedException | FolderException e){
					e.printStackTrace();
				}
			cont = 0;
			}
	    }
	    
}
