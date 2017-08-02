package Conectividad;
import static Conectividad.SmtpServ.*;

import java.io.IOException;
import java.util.Properties;
 
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.icegreen.greenmail.user.GreenMailUser;
import com.icegreen.greenmail.user.UserException;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;

public class POP3Serv {

	//private GreenMail mailServer;
	private static POP3Serv instancia;
	private static final String USER_PASSWORD = "123";
	private static final String USER_PASSWORD2 = "132";
	private static final String USER_NAME = "aloustau";
	private static final String USER_NAME2 = "jgardio";
	private static final String EMAIL_USER_ADDRESS = "aloustau@inet.com";
	private static final String EMAIL_USER_ADDRESS2 = "jgardio@ipa.com";
	private static final String LOCALHOST = "127.0.0.1";
	
	//Esta clase utiliza el patron Singleton
	public static POP3Serv getInstancia(){
		if (instancia == null)
			instancia = new POP3Serv();
		return instancia;
	}
		
	public POP3Serv(){
		//setUp();
	}
	
	//@Before
//    public void setUp() {
//        mailServer = new GreenMail(ServerSetupTest.POP3);
//        mailServer.start();
//    }
 
   //@After
//    public void tearDown() {
//        mailServer.stop();
//    }
 
    //@Test
    public void getMails() throws IOException, MessagingException, UserException, InterruptedException {
 
    	int contador, i;
        // fetch the e-mail from pop3 using javax.mail ..
        Properties props = new Properties();
        props.setProperty("mail.pop3.connectiontimeout", "5000");
        Session session = Session.getInstance(props);
        URLName urlName = new URLName("pop3", LOCALHOST, ServerSetupTest.POP3.getPort(), null, USER_NAME2, USER_PASSWORD2);
        Store store = session.getStore(urlName);
        store.connect();
 
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
        Message[] messages = folder.getMessages();
        contador = folder.getMessageCount();
        i = 0;
        while (contador > 0){
        	Message m = messages[i];
        	System.out.println("Nuevo e-mail de " + m.getFrom()[0].toString() + " | " + "Para: " +  m.getHeader("To")[0].toString() + " | " + "Asunto: " +  m.getSubject());
        	System.out.println(m.getContent().toString());
        	contador--;
        	i++;
        }

    }
}
