package grafica;
import static grafica.principal.abreVentana;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Logica.Fachada;
import java.awt.Color;


public class FrmNuevoUsuario extends JInternalFrame {

	public static String documento = new String();
	public static String nombre = new String();
	public static String apellido = new String();
	public static String calle  = new String();
	public static String nroPuerta  = new String();
	public static String apto  = new String();
	public static String numTel1   = new String();
	public static String numTel2  = new String();
	public static int cuentazero = 0;
	private static final long serialVersionUID = 1L;
	
	private JTextField txtUNnombre;
	private JTextField txtUNapellido;
	private JTextField txtUNdocumento;
	/*private JFormattedTextField txtUNdocumento;
	private NumberFormat numerico;*/ //Un detalle que estaria bueno pero no resolvi aun
	private JTextField txtUNcalle;
	private JTextField txtUNnroPuerta;
	private JTextField txtUNapto;
	private JTextField txtUNtelefono1;
	private JTextField txtUNtelefono2;
	private JRadioButton rdbtnConCuenta;
	private JRadioButton rdbtnAdministrador;
	private JLabel lblFaltanCampos;
	private final ButtonGroup rdbtnTipoUsuario = new ButtonGroup();
	
	private FrmNuevaCuenta cuenta;
	
	private Fachada FCLogica = Fachada.getInstancia(); 
	private static JPanel VentPrincipal = principal.getInstancia();
	private JTextField txtPassAdmin;
	/**
	 * Create the frame.
	 */
	public FrmNuevoUsuario() {
		setBounds(20, 30, 450, 515);
		getContentPane().setLayout(null);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo Usuario");
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setFont(new Font("Goudy Old Style", Font.BOLD, 21));
		lblNuevoUsuario.setBounds(138, -14, 166, 46);
		getContentPane().add(lblNuevoUsuario);
		
		/*BOTON DE CERRAR*/
		JButton btnCerrar = new JButton("");
		 btnCerrar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 	}
		 });
		 btnCerrar.setIcon(new ImageIcon(FrmNuevoDominio.class.getResource("/imagenes/cerrar.png")));
		 btnCerrar.setBounds(10, 0, 35, 35);
		 getContentPane().add(btnCerrar);
		 /*FIN DE BOTON DE CERRAR*/
		
		
		/*Nombre*/
		JLabel lblUNnombre = new JLabel("Nombre");
		lblUNnombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNnombre.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNnombre.setBounds(28, 32, 100, 30);
		getContentPane().add(lblUNnombre);
		
		txtUNnombre = new JTextField();
		txtUNnombre.setBounds(138, 32, 250, 30);
		getContentPane().add(txtUNnombre);
		txtUNnombre.setColumns(10);
		
		JLabel lblUNapellido = new JLabel("Apellido");
		lblUNapellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNapellido.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNapellido.setBounds(28, 73, 100, 30);
		getContentPane().add(lblUNapellido);
		
	
		txtUNapellido = new JTextField();
		txtUNapellido.setBounds(138, 73, 250, 30);
		getContentPane().add(txtUNapellido);
		txtUNapellido.setColumns(10);
		
		JLabel lblUNdocumento = new JLabel("Documento");
		lblUNdocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNdocumento.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNdocumento.setBounds(28, 117, 100, 30);
		getContentPane().add(lblUNdocumento);
		
		
		//txtUNdocumento = new JFormattedTextField();//Esto aun sin resolver, se vera mas adelante si da el tiempo de meterle este lujo
		txtUNdocumento = new JTextField();
		txtUNdocumento.setColumns(10);
		txtUNdocumento.setBounds(138, 117, 250, 30);
		getContentPane().add(txtUNdocumento);
		
		txtUNcalle = new JTextField();
		txtUNcalle.setColumns(10);
		txtUNcalle.setBounds(138, 197, 250, 30);
		getContentPane().add(txtUNcalle);
		
		JLabel lblUNcalle = new JLabel("Calle");
		lblUNcalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNcalle.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNcalle.setBounds(28, 197, 100, 30);
		getContentPane().add(lblUNcalle);
		
		txtUNnroPuerta = new JTextField();
		txtUNnroPuerta.setColumns(10);
		txtUNnroPuerta.setBounds(138, 238, 94, 30);
		getContentPane().add(txtUNnroPuerta);
		
		JLabel lblUNnroPuerta = new JLabel("Nro Puerta");
		lblUNnroPuerta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNnroPuerta.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNnroPuerta.setBounds(28, 238, 100, 30);
		getContentPane().add(lblUNnroPuerta);
		
		JLabel lblUNapto = new JLabel("Apto");
		lblUNapto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNapto.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNapto.setBounds(264, 238, 48, 30);
		getContentPane().add(lblUNapto);
		
		txtUNapto = new JTextField();
		txtUNapto.setColumns(10);
		txtUNapto.setBounds(322, 238, 67, 30);
		getContentPane().add(txtUNapto);
		
		txtUNtelefono1 = new JTextField();
		txtUNtelefono1.setColumns(10);
		txtUNtelefono1.setBounds(138, 279, 250, 30);
		getContentPane().add(txtUNtelefono1);
		
		JLabel lblUNtelefono1 = new JLabel("Tel\u00E9fono");
		lblUNtelefono1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNtelefono1.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNtelefono1.setBounds(28, 279, 100, 30);
		getContentPane().add(lblUNtelefono1);
		
		txtUNtelefono2 = new JTextField();
		txtUNtelefono2.setColumns(10);
		txtUNtelefono2.setBounds(138, 320, 250, 30);
		getContentPane().add(txtUNtelefono2);
		
		JLabel lblUNtelefono2 = new JLabel("Tel\u00E9fono");
		lblUNtelefono2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNtelefono2.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNtelefono2.setBounds(28, 320, 100, 30);
		getContentPane().add(lblUNtelefono2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 176, 388, 21);
		getContentPane().add(separator);
		
		
		JRadioButton rdbtnConCuenta = new JRadioButton("Con cuenta");
	
		rdbtnTipoUsuario.add(rdbtnConCuenta);
		rdbtnConCuenta.setBounds(145, 361, 94, 23);
		getContentPane().add(rdbtnConCuenta);
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		
		rdbtnTipoUsuario.add(rdbtnAdministrador);
		rdbtnAdministrador.setBounds(244, 361, 109, 23);
		getContentPane().add(rdbtnAdministrador);
		
		
		/*Etiqueta que avisa el error de campos faltantes*/
		lblFaltanCampos = new JLabel("Hay campos con errores");
		lblFaltanCampos.setForeground(Color.RED);
		lblFaltanCampos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFaltanCampos.setBounds(122, 464, 220, 21);
		getContentPane().add(lblFaltanCampos);
		lblFaltanCampos.setVisible(false);
		
		txtPassAdmin = new JTextField();
		txtPassAdmin.setColumns(10);
		txtPassAdmin.setBounds(138, 393, 250, 30);
		getContentPane().add(txtPassAdmin);
		txtPassAdmin.setVisible(false);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblContrasea.setBounds(48, 391, 90, 30);
		getContentPane().add(lblContrasea);
		lblContrasea.setVisible(false);
		
		/*Se muestra el campo de pass para admin*/ 
		rdbtnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPassAdmin.setVisible(true);
				lblContrasea.setVisible(true);
			}
		});
		
		rdbtnConCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPassAdmin.setVisible(false);
				lblContrasea.setVisible(false);
			}
		});
		
		/*INSTANCIO txt documento para pasarle a nueva cuenta*/
		//JTextField txtCNdocumento = FrmNuevaCuenta.getInstancia();
		
		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			Verificaciones verifica = new Verificaciones();
			public void actionPerformed(ActionEvent arg0) {
				/*Remplaza algun caracter que pueda complicar al guardar*/
				
				/*Instancio la clase verificacion*/
				Verificaciones verifica = new Verificaciones();
				boolean continua = true;
				/*Realizo todas las verificaciones de campos*/
				int i=0;
				while(i == 0){
				if (!verifica.cant_caracteres(txtUNnombre, 20, 1)){continua = false; break;}
				if (!verifica.cant_caracteres(txtUNapellido, 20, 1)){continua = false; break;}
				if (!verifica.cant_caracteres(txtUNdocumento, 8, 7)){
					continua = false; break;
				}else{
					if(!verifica.numerico(txtUNdocumento)){continua = false; break;}
				}
				
				if(!verifica.verificaCedula(txtUNdocumento)){continua = false; break;}
				
				if (!verifica.cant_caracteres(txtUNcalle, 50, 0)){continua = false; break;}
				if (!verifica.cant_caracteres(txtUNnroPuerta, 4, 0)){continua = false; break;}
				if (!verifica.cant_caracteres(txtUNapto, 4, 0)){continua = false; break;}
				if (!verifica.cant_caracteres(txtUNtelefono1, 10, 0)){
					continua = false; break;
				}else{
					if(!verifica.numerico(txtUNtelefono1)){continua = false; break;}
					}
				if (!verifica.cant_caracteres(txtUNtelefono2, 10, 0)){
					continua = false; break;
				}else{	
					if(!verifica.numerico(txtUNtelefono2)){continua = false; break;}
					}
				i=1;
				}
				nombre = verifica.remplazoCaracteres(txtUNnombre.getText());
				apellido = verifica.remplazoCaracteres(txtUNapellido.getText());
				documento = txtUNdocumento.getText();
				calle = verifica.remplazoCaracteres(txtUNcalle.getText());
				nroPuerta = verifica.remplazoCaracteres(txtUNnroPuerta.getText());
				apto = verifica.remplazoCaracteres(txtUNapto.getText());
				numTel1 = verifica.remplazoCaracteres(txtUNtelefono1.getText());
				numTel2 = verifica.remplazoCaracteres(txtUNtelefono2.getText());
				
				/*FIN VERIFICACIONES*/
				if (continua == true){
					
						/*Debo ver que tipo de cuenta va a crear*/
						if (rdbtnConCuenta.isSelected()){
							/*El campo de contrase;a de administrador queda oculto*/
							cuentazero = 1; /*Este dato sirve para enviar a cuanta indicandole que es un nuevo usuario*/
							cuenta = new FrmNuevaCuenta(); 
							abreVentana(cuenta); /*Abro cuenta y le envio los valores*/
							dispose(); /*Cierro esta ventana (nuevoUsuaroi)*/
						}
						
						if (rdbtnAdministrador.isSelected()){
							String pass = txtPassAdmin.getText();
							try {
								FCLogica.altaUsuarioAdmin(documento, nombre, apellido, pass, calle, nroPuerta, apto, numTel1, numTel2);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							dispose();
						}
						
						
					
				}else{
					lblFaltanCampos.setVisible(true);
				}
			}
		});
		btnAgregarUsuario.setBounds(59, 434, 329, 30);
		getContentPane().add(btnAgregarUsuario);
		
		JLabel lblsinPuntosNi = new JLabel("(Sin puntos ni guiones: Ejemplo 1.234.567-8 -> 12345678)");
		lblsinPuntosNi.setFont(new Font("Sylfaen", Font.ITALIC, 10));
		lblsinPuntosNi.setBounds(134, 151, 290, 14);
		getContentPane().add(lblsinPuntosNi);
		
	}
	
	
}
