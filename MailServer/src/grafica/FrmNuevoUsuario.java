package grafica;
import Logica.Fachada;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class FrmNuevoUsuario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUNnombre;
	private JTextField txtUNapellido;
	private JTextField txtUNdocumento;
	private JTextField txtUNcalle;
	private JTextField txtUNnroPuerta;
	private JTextField txtUNapto;
	private JTextField txtUNtelefono1;
	private JTextField txtUNtelefono2;
	private final ButtonGroup rdbtnTipoUsuario = new ButtonGroup();
	/**
	 * Create the panel.
	 */
	
	private Fachada FCLogica = Fachada.getInstancia();
	public FrmNuevoUsuario() {
		
		setBounds(20, 60, 450, 500);
		setLayout(null);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo Usuario");
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setFont(new Font("Goudy Old Style", Font.BOLD, 21));
		lblNuevoUsuario.setBounds(136, 11, 166, 46);
		add(lblNuevoUsuario);
		
		/*Nombre*/
		JLabel lblUNnombre = new JLabel("Nombre");
		lblUNnombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNnombre.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNnombre.setBounds(28, 70, 100, 30);
		add(lblUNnombre);
		
		txtUNnombre = new JTextField();
		txtUNnombre.setBounds(138, 70, 250, 30);
		add(txtUNnombre);
		txtUNnombre.setColumns(10);
		
		JLabel lblUNapellido = new JLabel("Apellido");
		lblUNapellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNapellido.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNapellido.setBounds(28, 111, 100, 30);
		add(lblUNapellido);
		
	
		txtUNapellido = new JTextField();
		txtUNapellido.setBounds(138, 111, 250, 30);
		add(txtUNapellido);
		txtUNapellido.setColumns(10);
		
		JLabel lblUNdocumento = new JLabel("Documento");
		lblUNdocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNdocumento.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNdocumento.setBounds(28, 155, 100, 30);
		add(lblUNdocumento);
				
		txtUNdocumento = new JTextField();
		txtUNdocumento.setColumns(10);
		txtUNdocumento.setBounds(138, 155, 250, 30);
		add(txtUNdocumento);
		
		txtUNcalle = new JTextField();
		txtUNcalle.setColumns(10);
		txtUNcalle.setBounds(138, 238, 250, 30);
		add(txtUNcalle);
		
		JLabel lblUNcalle = new JLabel("Calle");
		lblUNcalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNcalle.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNcalle.setBounds(28, 238, 100, 30);
		add(lblUNcalle);
		
		txtUNnroPuerta = new JTextField();
		txtUNnroPuerta.setColumns(10);
		txtUNnroPuerta.setBounds(138, 279, 94, 30);
		add(txtUNnroPuerta);
		
		JLabel lblUNnroPuerta = new JLabel("Nro Puerta");
		lblUNnroPuerta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNnroPuerta.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNnroPuerta.setBounds(28, 279, 100, 30);
		add(lblUNnroPuerta);
		
		JLabel lblUNapto = new JLabel("Apto");
		lblUNapto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNapto.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNapto.setBounds(264, 279, 48, 30);
		add(lblUNapto);
		
		txtUNapto = new JTextField();
		txtUNapto.setColumns(10);
		txtUNapto.setBounds(322, 279, 67, 30);
		add(txtUNapto);
		
		txtUNtelefono1 = new JTextField();
		txtUNtelefono1.setColumns(10);
		txtUNtelefono1.setBounds(138, 320, 250, 30);
		add(txtUNtelefono1);
		
		JLabel lblUNtelefono1 = new JLabel("Tel\u00E9fono");
		lblUNtelefono1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNtelefono1.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNtelefono1.setBounds(28, 320, 100, 30);
		add(lblUNtelefono1);
		
		txtUNtelefono2 = new JTextField();
		txtUNtelefono2.setColumns(10);
		txtUNtelefono2.setBounds(138, 361, 250, 30);
		add(txtUNtelefono2);
		
		JLabel lblUNtelefono2 = new JLabel("Tel\u00E9fono");
		lblUNtelefono2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNtelefono2.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNtelefono2.setBounds(28, 361, 100, 30);
		add(lblUNtelefono2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 196, 388, 21);
		add(separator);
		
		JRadioButton rdbtnConCuenta = new JRadioButton("Con cuenta");
		rdbtnTipoUsuario.add(rdbtnConCuenta);
		rdbtnConCuenta.setBounds(145, 409, 94, 23);
		add(rdbtnConCuenta);
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnTipoUsuario.add(rdbtnAdministrador);
		rdbtnAdministrador.setBounds(244, 409, 109, 23);
		add(rdbtnAdministrador);
		
		
		/*Etiqueta que avisa el error de campos faltantes*/
		JLabel lblFaltanCampos = new JLabel("* Faltan campos obligatorios");
		lblFaltanCampos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFaltanCampos.setBounds(168, 439, 220, 21);
		add(lblFaltanCampos);
		lblFaltanCampos.setVisible(false);
		
		/*INSTANCIO txt documento para pasarle a nueva cuenta*/
		JTextField txtCNdocumento = FrmNuevaCuenta.getInstancia();
		
		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtUNnombre.getText();
				String apellido = txtUNapellido.getText();
				String documento = txtUNdocumento.getText();
				String calle = txtUNcalle.getText();
				String nroPuerta = txtUNnroPuerta.getText();
				String apto = txtUNapto.getText();
				
		
				if(verifica(nombre, apellido, documento)){
					try {
						FCLogica.altaUsu(documento, nombre, apellido, calle, nroPuerta, apto);
						/*Cierro Ventana*/
						setVisible(false);
						/*Levanto la de cuenta*/
						
						/*Debo ver que tipo de cuenta va a crear*/
						if (rdbtnConCuenta.isSelected()){
							JPanel pan = principal.getInstancia();
							FrmNuevaCuenta cuenta = new FrmNuevaCuenta();
							/*Paso el numero de documento*/
							txtCNdocumento.setText(documento);
							txtCNdocumento.setBounds(150, 74, 250, 30);
							pan.add(cuenta);
							cuenta.add(txtCNdocumento);
						}
						
						if (rdbtnAdministrador.isSelected()){
							JPanel pan = principal.getInstancia();
					
							/*txtCNdocumento.setText(documento);
							txtCNdocumento.setBounds(150, 74, 250, 30);
							pan.add(cuenta);
							cuenta.add(txtCNdocumento);*/
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					lblFaltanCampos.setVisible(true);
				}	
			}
		});
		btnAgregarUsuario.setBounds(142, 459, 246, 30);
		add(btnAgregarUsuario);
		

	}
	/**Metodo que verifica si los campos obligatorios fueron cargados
	 * @param campo_nombre, campo_apellido, campo_documento.
	 * @return true si fueron cargados los tres
	 */
	public boolean verifica(String nom, String ape, String docu){
		boolean verificacion = true;
		/*Declaro dos bordes, uno para indicar cuando el campo falta, el tro para volverlo a su estado inicial*/
		Border bordeROJO = BorderFactory.createLineBorder(Color.RED, 2);
		Border bordeCOMUN = BorderFactory.createLineBorder(Color.BLACK, 1);
		if (nom.isEmpty()){
			verificacion = false;
			this.txtUNnombre.setBorder(bordeROJO);
		}else{
			this.txtUNnombre.setBorder(bordeCOMUN);
		}
		if (ape.isEmpty()){
			verificacion = false;
			this.txtUNapellido.setBorder(bordeROJO);
		}else{
			this.txtUNapellido.setBorder(bordeCOMUN);
		}
		if (docu.isEmpty()){
			verificacion = false;
			this.txtUNdocumento.setBorder(bordeROJO);
		}else{
			this.txtUNdocumento.setBorder(bordeCOMUN);
		}
		if(rdbtnTipoUsuario.isSelected(null)){
			verificacion = false;
			System.out.println("FALTA RDBTN");
		}
		return verificacion;
		
	}
}
