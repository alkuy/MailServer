package Conectividad;
import static Conectividad.SmtpServ.*;

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
import com.icegreen.greenmail.util.ServerSetupTest;
import com.sun.mail.smtp.SMTPTransport;
import com.dumbster.smtp.SmtpMessage;
import com.icegreen.greenmail.Managers;
import com.icegreen.greenmail.store.FolderException;
import com.icegreen.greenmail.store.MailFolder;
import com.icegreen.greenmail.user.GreenMailUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class POP3Serv {

	//private GreenMail mailServer;
	private static POP3Serv instancia;
	private GreenMail POPServer;
	Fachada FC = Fachada.getInstancia();
	
	//Esta clase utiliza el patron Singleton
	public static POP3Serv getInstancia() throws SQLException{
		if (instancia == null)
			instancia = new POP3Serv();
		return instancia;
	}
		
	public POP3Serv() throws SQLException{
		setUp();
	}
	
	//@Before
    public void setUp() throws SQLException {
    	POPServer = new GreenMail(ServerSetupTest.POP3);
        POPServer.start();
        this.cargaCuentas();
    }
 
   //@After
    public void tearDown() {
    	POPServer.stop();
    }
    
    //Esta funcion carga las cuentas de la BD a la API SMTP para que el cliente se pueda autenticar
    public void cargaCuentas() throws SQLException{
    	String UserName, UserDom, UserAddress, UserPass;
    	int UserId;
    	java.sql.ResultSet rs = null;
    	
    	rs = FC.CuentasDesdeBD();
    	while (rs.next()){
    		UserName = rs.getString("nom_usuario");
    		UserDom = rs.getString("nom_dominio");
    		UserId = rs.getInt("id_usuario");
    		UserPass = rs.getString("password");
    		//UserPass = FC.ObtenPass(UserName);
    		UserAddress = UserName+"@"+UserDom;
    		POPServer.setUser(UserAddress, UserName, UserPass);
    	}
    }
    
    
    public void getMailsBDUsu(String Usu, String Dom) throws FolderException, Exception {
    	String mailFrom, mailTo, mailSubjet, mailText; 
    	String NomEmi, DomEmi, NomDest, DomDest, DestPass, fecha;
    	boolean Enviado = true;
    	boolean SeEnvio = false;
    	int IdConv;
    	java.sql.ResultSet rs = FC.ObtieneCorreosBDUsu(Usu, Dom);
    	GreenMailUser Usuario;
    	Managers managers = new Managers();
    	
    	while(rs.next()){
    		
    		NomEmi = rs.getString("nom_usuario_emisor");
    		DomEmi = rs.getString("nom_dominio_emisor");
    		NomDest = rs.getString("nom_usuario_receptor");
    		DomDest = rs.getString("nom_dominio_receptor");
    		IdConv = rs.getInt("id_conversacion");
    		mailFrom = NomEmi+"@"+DomEmi;
    		mailTo = NomDest+"@"+DomDest;
    		mailSubjet = IdConv+"%"+rs.getString("asunto");
    		mailText = rs.getString("texto");
    		fecha = rs.getString("fecha");
    		SeEnvio = rs.getBoolean("Enviado");
    		
    		//Arregla la fecha para que pueda hacer el Update en la BD
    		String anio = fecha.substring(0, fecha.indexOf(" "));
    		String[] Arr = anio.split("-");
    		String[] hora = fecha.split("\\s");
    		fecha = Arr[0]+Arr[1]+Arr[2]+" "+hora[1];
    		
    		//Crea un mensaje con JavaMail
    		MimeMessage message = new MimeMessage((Session) null);
            message.setFrom(new InternetAddress(mailFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
            mailTo));
            message.setSubject(mailSubjet);
            message.setText(mailText);
            
            DestPass = FC.ObtenPass(NomDest, DomDest);
            //Usuario = managers.getUserManager().getUser(Usu);
            Usuario = POPServer.setUser(mailTo, Usu, DestPass);
            System.out.println(Usuario.getLogin()); 
            
            if (!SeEnvio){
            	//Almacenamos los mensaje en memoria para el INBOX de cada usuario
            	Usuario.deliver(message);
            	FC.Correo_Enviado(fecha, Enviado);
            }
    	}
    }
    
    public void BorraMailDeBoxes() throws FolderException{
    	POPServer.purgeEmailFromAllMailboxes();
    }
 
}
