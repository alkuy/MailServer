package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;

import Persistencia.FachadaBD;

public class Cuenta {
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	private int id_usuario; // Esto se debe traer de la tabla Usuario 
	private String nom_u; // Solo agregue esto aca. No se porque no se pudo de entrada, por eso no lo puse en el contructor
	private String contrase�a_cuenta;
	private String dominio;
	private int es_lista;
	private boolean habilitada;
	
	private Correos correos;
	//private Dominio dominio; // Por que es del tipo dominios ?????
	
	private static Cuenta instancia;
	public static Cuenta getInstancia() {
		if(instancia == null)
			instancia = new Cuenta();
		
		return instancia;
	}

	/**
	 * Constructor de la clase vacio
	 * */
	public Cuenta(){
		
	}

	/** M�todo constructor de la clase. */
	/*
	public Cuenta(String contrase�a_cuenta, String dominio, Correos correos) {
		this.contrase�a_cuenta = contrase�a_cuenta;
		this.dominio = dominio;
		this.correos = new Correos();
	}*/
	
	/** M�todo que retorna la contrase�a de la cuenta de usuario.
	 * @return Contrase�a de la cuenta de usuario. */
	public String getContrase�a_cuenta() {
		return contrase�a_cuenta;
	}
	
	public String getDominio() {
		return dominio;
	}
	
	public Correos getCorreos() {
		return correos;
	}
	
	/** M�todo para modificar la contrase�a de la cuenta de usuario.
	 * @param contrase�a_cuenta Nueva contrase�a de la cuenta de usuario.
	 * @return No retorna nada. */
	public void setContrase�a_cuenta(String contrase�a_cuenta) {
		this.contrase�a_cuenta = contrase�a_cuenta;
	}
	
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	
	public void setCorreos(Correos correos) {
		this.correos = correos;
	}
		
	public String getNom_u() {
		return nom_u;
	}
	
	public void setNomU(String nombre){
		this.nom_u = nombre;
	}
	
	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}

	/**
	 * A partir de la cedula devuelve el id del usuario, para poder asociarlo a la cuenta
	 * */
	public void setIdUsuario(String cedula){
		try {
			int id = BD.Devolver_id(cedula);
			this.id_usuario = id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setIdUsuario(int id){
		this.id_usuario = id;
		
	}
	
	public int getId(){
		return this.id_usuario;
	}
	
	public int getEs_lista() {
		return es_lista;
	}

	public void setEs_lista(int es_lista) {
		this.es_lista = es_lista;
	}
	

	public void LimpiaCuenta(){
		this.contrase�a_cuenta = null;
		this.dominio = null;
		this.id_usuario = 0;
		this.nom_u = null;
	}
	
}
