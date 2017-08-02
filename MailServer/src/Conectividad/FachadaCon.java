package Conectividad;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;

import com.icegreen.greenmail.user.UserException;

public class FachadaCon {

	private static FachadaCon instancia;
	
	//Esta clase utiliza el patron Singleton
	public static FachadaCon getInstancia(){
		if (instancia == null)
			instancia = new FachadaCon();
			
		return instancia;
	}
	
	// Incia el Servicio que escucha en un puerto TCP esperando el mail
	public void InciaServ() throws SQLException{
		SmtpServ P = SmtpServ.getInstancia();
		P.start();

	}
	
	public void DetenerServ() throws SQLException{
		SmtpServ P = SmtpServ.getInstancia();
		P.tearDown();

	}
	
	public void InciaCli() throws SQLException, IOException, MessagingException, UserException, InterruptedException{
		PruebaCli C = new PruebaCli();
		SmtpServ P = SmtpServ.getInstancia();
		C.Enviar();
		P.setMailsBD();
	}
	
	public void ObtenerMail() throws IOException, MessagingException, UserException, InterruptedException, SQLException{
		POP3Serv Q = POP3Serv.getInstancia();
		SmtpServ P = SmtpServ.getInstancia();
		P.getMailsBD();
		Q.getMails();
	}
	
	public void IniSocket() throws SQLException{
		InfoSocket I = InfoSocket.getInstancia();
		I.start();
	}
}
