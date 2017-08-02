package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;

import Persistencia.FachadaBD;

public class Cuenta {
	
	FachadaBD BD = FachadaBD.getInstancia();
	
	private int id_usuario; // Esto se debe traer de la tabla Usuario 
	private String nom_u; // Solo agregue esto aca. No se porque no se pudo de entrada, por eso no lo puse en el contructor
	private String contraseña_cuenta;
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

	/** Método constructor de la clase. */
	/*
	public Cuenta(String contraseña_cuenta, String dominio, Correos correos) {
		this.contraseña_cuenta = contraseña_cuenta;
		this.dominio = dominio;
		this.correos = new Correos();
	}*/
	
	/** Método que retorna la contraseña de la cuenta de usuario.
	 * @return Contraseña de la cuenta de usuario. */
	public String getContraseña_cuenta() {
		return contraseña_cuenta;
	}
	
	public String getDominio() {
		return dominio;
	}
	
	public Correos getCorreos() {
		return correos;
	}
	
	/** Método para modificar la contraseña de la cuenta de usuario.
	 * @param contraseña_cuenta Nueva contraseña de la cuenta de usuario.
	 * @return No retorna nada. */
	public void setContraseña_cuenta(String contraseña_cuenta) {
		this.contraseña_cuenta = contraseña_cuenta;
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
		this.contraseña_cuenta = null;
		this.dominio = null;
		this.id_usuario = 0;
		this.nom_u = null;
	}
	
}
