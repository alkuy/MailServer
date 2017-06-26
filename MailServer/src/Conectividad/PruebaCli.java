package Conectividad;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/*Esta clase se utiliza para enviar un mail de prueba al servidor */

public class PruebaCli {
	
	public void PruebaCli(){
	}

	public void Enviar() {    
	      // Se guarda al destinatario del correo
	      String to = "jgardio@anep.com";

	      // se guarda al emisor del correo
	      String from = "amolino@ces.com";

	      // Aca estamos asumiendo que el email sale de Localhost lo cual para esta prueba es asi.
	      String host = "localhost";

	      // Se obtienen las propiedades del sistema
	      Properties properties = System.getProperties();

	      // Se realiza el setup del servidor de correo
	      properties.setProperty("mail.smtp.host", host);

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
	         Transport.send(message);
	         
	         //System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
}
