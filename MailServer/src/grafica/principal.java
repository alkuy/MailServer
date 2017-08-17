package grafica;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Component;

import Conectividad.FachadaCon;
import Logica.Fachada;

public class principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel VentPrincipal;
	private static JLabel ImagenLogo = null;
	private static JMenuBar menuBar;
	private static JLabel lblCorreoPintituciones;
	private static JLabel lblVersion;
	private static JLabel lblCreadoEnInet;
	
	
	private FrmMuestraDominios frmmuestradominios;
	public static FrmMuestraCuentas frmmuestracuentas;
	private FrmNuevaCuenta frmcuenta; 
	private FrmNuevoUsuario frmusuario;
	private FrmNuevoDominio frmdominionuevo;
	public static FrmMuestraUsuarios frmmuestrausuarios;
	private FrmBuscaUsuario frmbuscausuario;
	private FrmMuestraAdmins frmadmins;
	private FrmPruebaServidor frmPruebaServidor;
	public static FrmEdicionUsuario EdicUsuario;
	public static FrmEdicionCuenta edicCuenta;
	public static FrmAdminCambiaPass AdminPass;
	
	Fachada FL = Fachada.getInstancia();
	FachadaCon FC = FachadaCon.getInstancia();
	private JTextField txtApellidoAdmin;
	private JTextField txtNombreAdmin;
	
	
	public static JPanel getInstancia() {
		if(VentPrincipal == null)
			VentPrincipal = new JPanel();
		
		return VentPrincipal;
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public principal() throws SQLException {
		FC.IniSocket();
     	setResizable(false);
		/**
		 * Panel Principal*/
     	setTitle("Administrador");
     	setIconImage(Toolkit.getDefaultToolkit().getImage(principal.class.getResource("/imagenes/ico-mail.png")));
     	setBackground(new Color(0, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		VentPrincipal = new JPanel();
		VentPrincipal.setBackground(new Color(0, 128, 128));
		VentPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(VentPrincipal);
		VentPrincipal.setLayout(null);
		
		/*······························*/
		/*MENU ARRIBA PRINCIPAL*/
		/*······························*/
		
		
		
		//FL.cambiaPassCuenta("diego","ces", "44903589", "44903589");
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 982, 21);
		VentPrincipal.add(menuBar);
		
		JMenu mnCuenta = new JMenu("Cuentas");
		menuBar.add(mnCuenta);
		
		JMenuItem mntmNuevoCuenta = new JMenuItem("Nueva");
		mnCuenta.add(mntmNuevoCuenta);
		
		JMenuItem mntmVerCuentas = new JMenuItem("Ver cuentas");
		mnCuenta.add(mntmVerCuentas);
		
/*		JMenuItem mntmBuscarCuenta = new JMenuItem("Buscar");
		mnCuenta.add(mntmBuscarCuenta);
	*/	
		JMenu mnUsuario = new JMenu("Usuarios");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmNuevoUsuario = new JMenuItem("Nuevo");
		mnUsuario.add(mntmNuevoUsuario);
		
		JMenuItem mntmVerUsuarios = new JMenuItem("Ver Usuarios");
		mnUsuario.add(mntmVerUsuarios);
		
		JMenuItem mntmBuscarUsuario = new JMenuItem("Buscar");
		mnUsuario.add(mntmBuscarUsuario);
		
		JMenu mnConfiguracion = new JMenu("Configuracion");
		menuBar.add(mnConfiguracion);
		
		JMenuItem mntmAgregarDominio = new JMenuItem("Agregar Dominio");
		mnConfiguracion.add(mntmAgregarDominio);
		
		JMenuItem mntmDominios = new JMenuItem("Ver Dominios");
		mnConfiguracion.add(mntmDominios);
		
		JMenuItem mntmAdministradores = new JMenuItem("Administradores");
		mnConfiguracion.add(mntmAdministradores);
		
		JMenuItem mntmPruebaServidor = new JMenuItem("EstadoServ");
		mntmPruebaServidor.setBorder(null);
		mntmPruebaServidor.setMaximumSize(new Dimension(145, 56));
		mntmPruebaServidor.setPreferredSize(new Dimension(145, 24));
		menuBar.add(mntmPruebaServidor);
		
		/*······························*/
		/*Termina MENU ARRIBA*/
		/*······························*/
		
		lblCorreoPintituciones = new JLabel("Correo Para Instituciones Educativas");
			lblCorreoPintituciones.setHorizontalAlignment(SwingConstants.CENTER);
			lblCorreoPintituciones.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
			lblCorreoPintituciones.setBounds(576, 443, 250, 30);
			VentPrincipal.add(lblCorreoPintituciones);
		
		lblVersion = new JLabel("Version 1.0");
		lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersion.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
		lblVersion.setBounds(576, 470, 250, 30);
		VentPrincipal.add(lblVersion);
		
		lblCreadoEnInet = new JLabel("Creado en INET");
		lblCreadoEnInet.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreadoEnInet.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
		lblCreadoEnInet.setBounds(576, 499, 250, 30);
		VentPrincipal.add(lblCreadoEnInet);
		
		/*...............................*/
		/*########  LOGIN    ############*/

		JTextField txtLOGusuario = new JTextField();
		txtLOGusuario.setBounds(140, 180, 200, 30);
		VentPrincipal.add(txtLOGusuario);
		txtLOGusuario.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(140, 230, 200, 30);
		VentPrincipal.add(passwordField);
		
		JLabel ImgUserLog = new JLabel(new ImageIcon(principal.class.getResource("/imagenes/userLog.png")));
		ImgUserLog.setBounds(90, 180, 30, 30);
		VentPrincipal.add(ImgUserLog);
		
		JLabel ImgKeyLog = new JLabel(new ImageIcon(principal.class.getResource("/imagenes/keyLog.png")));
		ImgKeyLog.setBounds(90, 230, 30, 30);
		VentPrincipal.add(ImgKeyLog);
		
		JLabel lblLogin = new JLabel("LogIn");
		lblLogin.setBounds(120, 139, 208, 30);
		VentPrincipal.add(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Goudy Old Style", Font.BOLD, 28));
		
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.setBounds(90, 300, 250, 40);
		VentPrincipal.add(btnNewButton);
		
		ImagenLogo = new JLabel(new ImageIcon(principal.class.getResource("/imagenes/logo-mail.png")));
		ImagenLogo.setBounds(521, 81, 362, 248);
		VentPrincipal.add(ImagenLogo);
		
		JLabel lblDocumento = new JLabel("(Documento)");
		lblDocumento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocumento.setFont(new Font("Goudy Old Style", Font.BOLD, 14));
		lblDocumento.setBounds(340, 179, 88, 30);
		VentPrincipal.add(lblDocumento);
		lblDocumento.setVisible(false);

		
		JLabel lblPrimer = new JLabel("Primer Ingreso");
		lblPrimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimer.setFont(new Font("Goudy Old Style", Font.BOLD, 28));
		lblPrimer.setBounds(108, 371, 208, 30);
		VentPrincipal.add(lblPrimer);
		
		txtApellidoAdmin = new JTextField();
		txtApellidoAdmin.setBounds(140, 109, 200, 30);
		VentPrincipal.add(txtApellidoAdmin);
		txtApellidoAdmin.setColumns(10);
		txtApellidoAdmin.setVisible(false);
		
		txtNombreAdmin = new JTextField();
		txtNombreAdmin.setColumns(10);
		txtNombreAdmin.setBounds(140, 64, 200, 30);
		VentPrincipal.add(txtNombreAdmin);
		txtNombreAdmin.setVisible(false);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		lblApellido.setBounds(74, 112, 69, 22);
		VentPrincipal.add(lblApellido);
		lblApellido.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		lblNombre.setBounds(74, 68, 69, 21);
		lblNombre.setVisible(false);
		VentPrincipal.add(lblNombre);
		
		JLabel lblIngreseSusDatos = new JLabel("Ingrese sus datos y una contrase\u00F1a");
		lblIngreseSusDatos.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		lblIngreseSusDatos.setBounds(118, 399, 257, 30);
		lblIngreseSusDatos.setVisible(false);
		VentPrincipal.add(lblIngreseSusDatos);
		
		JLabel lblTuNombreDe = new JLabel("Tu nombre de usuario ser\u00E1 tu n\u00FAmero de documento");
		lblTuNombreDe.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		lblTuNombreDe.setBounds(68, 429, 339, 44);
		VentPrincipal.add(lblTuNombreDe);
		lblTuNombreDe.setVisible(false);
		lblPrimer.setVisible(false);
		
		if(FL.BaseNueva()){
			JOptionPane.showMessageDialog(null, "Bienvenido a EDUMAIL. Ingrese usuario y password nuevos. Usuario debe ser su documento");
			lblPrimer.setVisible(true);
			lblDocumento.setVisible(true);
			lblNombre.setVisible(true);
			lblApellido.setVisible(true);
			txtNombreAdmin.setVisible(true);
			txtApellidoAdmin.setVisible(true);
			lblLogin.setVisible(false);
			lblIngreseSusDatos.setVisible(true);
			lblTuNombreDe.setVisible(true);
		}
		
		
		/*La barra es invisible al comienzo hasta que se loguea el usuario*/
		menuBar.setVisible(false);
		/*##############################################################*/
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Verificaciones verifica = new Verificaciones();
		
				try{
					if(FL.BaseNueva()){
						boolean continua = true;
						if(!verifica.verificaCedula(txtLOGusuario))continua=false;
						if(!verifica.cant_caracteres(txtNombreAdmin, 20, 1))continua=false;
						if(!verifica.cant_caracteres(txtApellidoAdmin, 20, 1))continua=false;
						if(!verifica.cant_caracteres(passwordField, 20, 1))continua=false;
						
						if(continua){
							String nombreAdmin = txtNombreAdmin.getText();
							String apellidoAdmin = txtApellidoAdmin.getText();
							ImgUserLog.setVisible(false);ImgKeyLog.setVisible(false);txtLOGusuario.setVisible(false); passwordField.setVisible(false);
							btnNewButton.setVisible(false); lblLogin.setVisible(false); lblPrimer.setVisible(false); lblIngreseSusDatos.setVisible(false); lblDocumento.setVisible(false);
							lblNombre.setVisible(false); lblApellido.setVisible(false); txtNombreAdmin.setVisible(false); txtApellidoAdmin.setVisible(false);
							lblTuNombreDe.setVisible(false); menuBar.setVisible(true);
							FL.altaUsuarioAdmin(txtLOGusuario.getText(), nombreAdmin, apellidoAdmin, passwordField.getText(), null, null, null, null, null);
						}
					}else{
					
						if (verifica.verifica_admin(txtLOGusuario.getText(),passwordField.getText())){
						
							ImgUserLog.setVisible(false);
							ImgKeyLog.setVisible(false);
							txtLOGusuario.setVisible(false);
							passwordField.setVisible(false);
							btnNewButton.setVisible(false);
							lblLogin.setVisible(false);
							menuBar.setVisible(true);
						}else{
							passwordField.setText(null);
							JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
						
					    }
				  
					}
				 } catch (Exception d){ }		
			}
		});

		
		/*############  FIN LOGIN ######################################*/
		
	
		/*#######################################*/
		/*#########     ACCIONES    #############*/
		/*#######################################*/
		
		
		/*############################################################################################################*/
		/*#####    BOTONES D BARRA DE MENU   -    LLAMAN A LOS CORRESPONDIENTES FORMULARIOS    #######################*/
		
		
		mntmNuevoCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cierraTodo();
				frmcuenta = new FrmNuevaCuenta();
				abreVentana(frmcuenta);
			
			
			}
		});
		
		mntmNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cierraTodo();
				frmusuario = new FrmNuevoUsuario();
				abreVentana(frmusuario);
	
			}
		});
		
		mntmVerCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cierraTodo();
				frmmuestracuentas = new FrmMuestraCuentas();
				abreVentana(frmmuestracuentas);
				
			}
		});
		
		mntmAgregarDominio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cierraTodo();
				frmdominionuevo = new FrmNuevoDominio();
				abreVentana(frmdominionuevo);
			
			}
		});
		
		
		mntmDominios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cierraTodo();
				frmmuestradominios = new FrmMuestraDominios();
				abreVentana(frmmuestradominios);
				
			
			}
		});
		
		mntmVerUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cierraTodo();
				frmmuestrausuarios = new FrmMuestraUsuarios();
				abreVentana(frmmuestrausuarios);
				
			}
		});
		
		mntmPruebaServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cierraTodo();
				frmPruebaServidor = new FrmPruebaServidor();
				abreVentana(frmPruebaServidor);
			
			}
		});
		
		mntmBuscarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cierraTodo();
				frmbuscausuario = new FrmBuscaUsuario();
				abreVentana(frmbuscausuario);
			}
		});
		
		mntmAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cierraTodo();
				frmadmins = new FrmMuestraAdmins();
				abreVentana(frmadmins);
				
			}
		});
		
		/*################   FIN  -   BOTONES D BARRA DE MENU  ###############################*/
		/*####################################################################################*/
		
		
	}
	/**
	 * Abre las ventanas sin marco
	 * @param panel
	 */
	public static void abreVentana(JInternalFrame panel){
		VentPrincipal.add(panel);
		BasicInternalFrameTitlePane titlePane =
			      (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) panel.getUI()).
			      getNorthPane();
		panel.remove(titlePane);
		panel.setVisible(true);
		panel.toFront();
	}
	/**
	 * Cierra JinternalFram verificando si fue abierto
	 * @param panel
	 */
	public static void cierraVentana(JInternalFrame panel){
		if (panel !=null){
			panel.dispose();
		}
	}
	/**
	 * Invisible el logo y las letras de credito
	 */
	public static void desapareceLogo(){
		ImagenLogo.setVisible(false);
		lblCorreoPintituciones.setVisible(false);
		lblVersion.setVisible(false);
		lblCreadoEnInet.setVisible(false);
	}
	/**
	 * Visible el logo y las letras de credito
	 */
	public static void apareceLogo(){
		ImagenLogo.setVisible(true);
		lblCorreoPintituciones.setVisible(true);
		lblVersion.setVisible(true);
		lblCreadoEnInet.setVisible(true);
	}
	/*Solucionar esto. Quiero deshabilitar menuItem cuando abro determinada ventana*/
	public static void menuHabilitado(){
		menuBar.setVisible(true);
	}
	public static void menuDesHabilitado(){
		menuBar.setVisible(false);
	}
	
	
	public void cierraTodo(){
		cierraVentana(frmusuario);
		cierraVentana(frmcuenta);
		cierraVentana(frmmuestracuentas);
		cierraVentana(frmdominionuevo);
		cierraVentana(frmmuestradominios);
		cierraVentana(frmPruebaServidor);
		cierraVentana(frmmuestrausuarios);
		cierraVentana(EdicUsuario);
		cierraVentana(edicCuenta);
		cierraVentana(frmadmins);
		cierraVentana(frmbuscausuario);
		cierraVentana(AdminPass);
		
	}
}
