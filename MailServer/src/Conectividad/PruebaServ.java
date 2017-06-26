package Conectividad;
import java.util.Arrays;
import java.util.Iterator;
import com.dumbster.smtp.*;


public class PruebaServ implements Runnable {
	private Thread t;
	private SimpleSmtpServer Server;
	private static PruebaServ instancia;
	
	//Esta clase utiliza el patron Singleton
	public static PruebaServ getInstancia(){
		if (instancia == null)
			instancia = new PruebaServ();
			
		return instancia;
	}
	
	public PruebaServ(){
		Server = SimpleSmtpServer.start();
		this.t = new Thread(this);
	}
	
	public void run(){
		String Esperando = "Esperando e-mails...";
		while(true){
			System.out.println("Recibido " + this.Server.getReceivedEmailSize());
			if(this.Server.getReceivedEmailSize() > 0){
				Iterator it = this.Server.getReceivedEmail();
				while(it.hasNext()){
					SmtpMessage s = (SmtpMessage) it.next();
					System.out.println("Nuevo e-mail de " + Arrays.toString(s.getHeaderValues("From")) + " | " + "Para: " +  Arrays.toString(s.getHeaderValues("To")) + " | " + "Asunto: " +  Arrays.toString(s.getHeaderValues("Subject")));
					System.out.println(s.getBody());
					System.out.println("\n");
					it.remove();
				}
			}
			try {
				Thread.sleep(5000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public void ServStart(){
		if(t.isAlive())
			t.resume();
		else
			t.start();
	}
	
	public void Servstop(){
		t.suspend();
	}
}
