package Conectividad;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.SMTPTransport;
import javax.activation.*;
import com.icegreen.greenmail.util.ServerSetupTest;

/*Esta clase se utiliza para enviar un mail de prueba al servidor */

public class PruebaCli {
	
    private static final String USER_PASSWORD = "123";
    private static final String USER_NAME = "aloustau";
    private static final String EMAIL_USER_ADDRESS = "aloustau@inet.com";
    private static final String EMAIL_TO = "someone@localhost.com";
    private static final String EMAIL_SUBJECT = "Test E-Mail";
    private static final String EMAIL_TEXT = "This is a test e-mail.";
    private static final String LOCALHOST = "127.0.0.1";
	
	public void PruebaCli(){
	}

	public void Enviar() {    
	      // Se guarda al destinatario del correo
	      String to = "jgardio@ipa.com";

	      // se guarda al emisor del correo
	      String from = "aloustau@inet.com";

	      // Aca estamos asumiendo que el email sale de Localhost lo cual para esta prueba es asi.
	      String host = "localhost";

	      // Se obtienen las propiedades del sistema
	      Properties properties = System.getProperties();

	      // Se realiza el setup del servidor de correo
	      properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("mail.smtp.auth", "true");
	      properties.put("mail.smtp.port", ServerSetupTest.SMTP.getPort());

	      // Se obtiene las sesion por defecto
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         // Creal el objeto MimeMessage por defecto
	         MimeMessage message = new MimeMessage(session);

	         // Hace el set del cabezal para el From
	         message.setFrom(new InternetAddress(from));

	         // Hace el set del cabezal para el To
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Hace el set para el Asunto
	         message.setSubject("Mensaje de Prueba");

	         // Ahora seteamos el cuerpo del mensaje
	         message.setText("Estoy escribiendo estas lineas para probar el cuerpo del mensaje");

	         // Se envia el mensaje
	         //Transport.send(message);
	         SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
	         t.connect(LOCALHOST, EMAIL_USER_ADDRESS, USER_PASSWORD);
		     t.sendMessage(message, message.getAllRecipients());
	         t.close();
		     
	         //System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
}
