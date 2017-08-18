package Logica;

import java.util.Calendar;
import java.util.Date;

import static grafica.FrmMuestraCuentas.nombrecuenta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


import Persistencia.FachadaBD;


/** Clase Logica Correo
 *
 *
*/ 

@SuppressWarnings("unused")
public class Correo {
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	private String CtaEmisor;
	private String CtaReceptor;
	private String asunto;
	private String Texto;
	private String fecha;
	private int IdEmisor;
	private int IdReceptor = 0;
	private int IdCorreo;
	private java.util.Date utilDate = new java.util.Date(); //fecha actual
	private long lnMilisegundos = utilDate.getTime();
	private boolean flag_respuesta;
	
	/** Método constructor de la clase.
	 * @param emisor Usuario emisor del correo.
	 * @param receptor Usuario receptor del correo.
	 * @param asunto Asunto del correo.
	 * @param flag_respuesta Indica si es respuesta 
	 * 			a un correo con el mismo asunto. */
	public Correo(String emisor, int IdEmisor, String receptor, int IdReceptor, String asunto, int IdCorreo, boolean flag_respuesta, String Text) {
		
		this.CtaEmisor = emisor;
		this.CtaReceptor = receptor;
		this.asunto = asunto;
		this.flag_respuesta = flag_respuesta;
		this.IdEmisor = IdEmisor;
		this.IdReceptor = IdReceptor;
		this.Texto = Text;
		this.IdCorreo = IdCorreo;
		
		Calendar Calendario = Calendar.getInstance();
		
		int anio = Calendario.get(Calendar.YEAR);
		int mes = Calendario.get(Calendar.MONTH) + 1;
		int dia = Calendario.get(Calendar.DAY_OF_MONTH);
		java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
		if (mes < 10){
			this.fecha = anio+"0"+mes+dia+" "+sqlTime;
		}
		else
			this.fecha = anio+mes+dia+" "+sqlTime;
	}

	/**
	 * @return el ctaEmisor
	 */
	public String getCtaEmisor() {
		return CtaEmisor;
	}

	/**
	 * @param ctaEmisor el ctaEmisor a establecer
	 */
	public void setCtaEmisor(String ctaEmisor) {
		CtaEmisor = ctaEmisor;
	}

	/**
	 * @return el ctaReceptor
	 */
	public String getCtaReceptor() {
		return CtaReceptor;
	}

	/**
	 * @param ctaReceptor el ctaReceptor a establecer
	 */
	public void setCtaReceptor(String ctaReceptor) {
		CtaReceptor = ctaReceptor;
	}

	/**
	 * @return el asunto
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * @param asunto el asunto a establecer
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * @return el texto
	 */
	public String getTexto() {
		return Texto;
	}

	/**
	 * @param texto el texto a establecer
	 */
	public void setTexto(String texto) {
		Texto = texto;
	}

	/**
	 * @return el idCorreo
	 */
	public int getIdCorreo() {
		return IdCorreo;
	}

	/**
	 * @param idCorreo el idCorreo a establecer
	 */
	public void setIdCorreo(int idCorreo) {
		IdCorreo = idCorreo;
	}

	/**
	 * @return el flag_respuesta
	 */
	public boolean isFlag_respuesta() {
		return flag_respuesta;
	}

	/**
	 * @param flag_respuesta el flag_respuesta a establecer
	 */
	public void setFlag_respuesta(boolean flag_respuesta) {
		this.flag_respuesta = flag_respuesta;
	}
	
	/**
	 * Carga los correos en la base
	 * @param Correo (objeto)
	 */
	public void CargarCorreoEnBase(Correo C){
		String NomUsu, DomUsu, NomRecp, DomRecp;
		NomUsu = C.CtaEmisor.substring(0, C.CtaEmisor.indexOf("@"));
		DomUsu = C.CtaEmisor.substring(C.CtaEmisor.indexOf("@")+1);
		NomRecp = C.CtaReceptor.substring(0, C.CtaReceptor.indexOf("@"));
		DomRecp = C.CtaReceptor.substring(C.CtaReceptor.indexOf("@")+1);
		
		BD.InsertCorreo(NomUsu, DomUsu, NomRecp, DomRecp, C.fecha, C.IdEmisor, C.IdReceptor, C.asunto, C.Texto, C.IdCorreo);	
	}
	
	/**
	 * Trae los correos desde la base
	 * @return Recordsest con correos
	 * @throws SQLException
	 */
	public java.sql.ResultSet ObtenerCorreoDeBase() throws SQLException{
		java.sql.ResultSet rs = BD.ConTablaCorreo();
		return rs;		
	}
	
	/**
	 * Trae los correos desde la base
	 * @return Recordsest con correos
	 * @throws SQLException
	 */
	public java.sql.ResultSet ObtenerCorreoDeBaseUsu(String Usu, String Dom) throws SQLException{
		java.sql.ResultSet rs = BD.ConTablaCorreoUsu(Usu, Dom);
		return rs;		
	}
	
	/**
	 * Trae los correos enviados desde la base
	 * @return Recordsest con correos
	 * @throws SQLException
	 */
	public void Correo_Enviado(String fecha, boolean Enviado){
		BD.Set_Enviado(fecha, Enviado);
	}
	

}
