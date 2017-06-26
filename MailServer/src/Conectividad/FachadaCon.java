package Conectividad;


public class FachadaCon {

	private static FachadaCon instancia;
	
	//Esta clase utiliza el patron Singleton
	public static FachadaCon getInstancia(){
		if (instancia == null)
			instancia = new FachadaCon();
			
		return instancia;
	}
	
	// Incia el Servicio que escucha en un puerto TCP esperando el mail
	public void InciaServ(){
		PruebaServ P = PruebaServ.getInstancia();
	}
	
	public void ComenzarServ(){
		PruebaServ P = PruebaServ.getInstancia();
		P.ServStart();
	}
	
	public void DetenerServ(){
		PruebaServ P = PruebaServ.getInstancia();
		P.Servstop();
	}
	
	public void InciaCli(){
		PruebaCli C = new PruebaCli();
		C.Enviar();
	}
}
