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
	private FrmMuestraCuentas frmmuestracuentas;
	private FrmNuevaCuenta frmcuenta; 
	private FrmNuevoUsuario frmusuario;
	private FrmNuevoDominio frmdominionuevo;
	private FrmMuestraUsuarios frmmuestrausuarios;
	private FrmPruebaServidor frmPruebaServidor;
	
	public static JPanel getInstancia() {
		if(VentPrincipal == null)
			VentPrincipal = new JPanel();
		
		return VentPrincipal;
	}

	/**
	 * Create the frame.
	 */
	public principal() {
     	setResizable(false);
		/**
		 * Panel Principal*/
     	setTitle("Admisnitrador");
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
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 982, 21);
		VentPrincipal.add(menuBar);
		
		JMenu mnCuenta = new JMenu("Cuentas");
		menuBar.add(mnCuenta);
		
		JMenuItem mntmNuevoCuenta = new JMenuItem("Nueva");
		mnCuenta.add(mntmNuevoCuenta);
		
		JMenuItem mntmVerCuentas = new JMenuItem("Ver cuentas");
		mnCuenta.add(mntmVerCuentas);
		
		JMenu mnUsuario = new JMenu("Usuarios");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmNuevoUsuario = new JMenuItem("Nuevo");
		mnUsuario.add(mntmNuevoUsuario);
		
		JMenuItem mntmVerUsuarios = new JMenuItem("Ver Usuarios");
		mnUsuario.add(mntmVerUsuarios);
		
		JMenu mnConfiguracion = new JMenu("Configuracion");
		menuBar.add(mnConfiguracion);
		
		JMenuItem mntmAgregarDominio = new JMenuItem("Agregar Dominio");
		mnConfiguracion.add(mntmAgregarDominio);
		
		JMenuItem mntmDominios = new JMenuItem("Ver Dominios");
		mnConfiguracion.add(mntmDominios);
		
		JMenuItem mntmPruebaServidor = new JMenuItem("PruebaServidor");
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
		lblLogin.setBounds(120, 100, 208, 30);
		VentPrincipal.add(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Goudy Old Style", Font.BOLD, 28));
		
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.setBounds(90, 300, 250, 40);
		VentPrincipal.add(btnNewButton);
		
		ImagenLogo = new JLabel(new ImageIcon(principal.class.getResource("/imagenes/logo-mail.png")));
		ImagenLogo.setBounds(521, 81, 362, 248);
		VentPrincipal.add(ImagenLogo);
		
		
		/*La barra es invisible al comienzo hasta que se loguea el usuario*/
		menuBar.setVisible(false);
		/*##############################################################*/
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Verificaciones verifica = new Verificaciones();
		
		try{
			
			 if (verifica.verifica_admin(txtLOGusuario.getText(),passwordField.getText())){
				
				ImgUserLog.setVisible(false);
				ImgKeyLog.setVisible(false);
				txtLOGusuario.setVisible(false);
				passwordField.setVisible(false);
				btnNewButton.setVisible(false);
				lblLogin.setVisible(false);
				menuBar.setVisible(true);
					
			 } else {
				 
				 passwordField.setText(null);
				
				 JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
				
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
				frmcuenta = new FrmNuevaCuenta();
				abreVentana(frmcuenta);
			
				cierraVentana(frmmuestracuentas);
				cierraVentana(frmusuario);
				cierraVentana(frmdominionuevo);
				cierraVentana(frmmuestradominios);
				cierraVentana(frmmuestrausuarios);
				cierraVentana(frmPruebaServidor);
			
			}
		});
		
		mntmNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmusuario = new FrmNuevoUsuario();
				abreVentana(frmusuario);
				
				cierraVentana(frmmuestracuentas);
				cierraVentana(frmcuenta);
				cierraVentana(frmdominionuevo);
				cierraVentana(frmmuestradominios);
				cierraVentana(frmmuestrausuarios);
				cierraVentana(frmPruebaServidor);
			}
		});
		
		mntmVerCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmmuestracuentas = new FrmMuestraCuentas();
				abreVentana(frmmuestracuentas);
				
				cierraVentana(frmusuario);
				cierraVentana(frmcuenta);
				cierraVentana(frmdominionuevo);
				cierraVentana(frmmuestradominios);
				cierraVentana(frmmuestrausuarios);
				cierraVentana(frmPruebaServidor);
			}
		});
		
		mntmAgregarDominio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmdominionuevo = new FrmNuevoDominio();
				abreVentana(frmdominionuevo);
				
				cierraVentana(frmusuario);
				cierraVentana(frmcuenta);
				cierraVentana(frmmuestracuentas);
				cierraVentana(frmmuestradominios);
				cierraVentana(frmmuestrausuarios);
				cierraVentana(frmPruebaServidor);
			}
		});
		
		
		mntmDominios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmmuestradominios = new FrmMuestraDominios();
				abreVentana(frmmuestradominios);
				
				cierraVentana(frmusuario);
				cierraVentana(frmcuenta);
				cierraVentana(frmmuestracuentas);
				cierraVentana(frmdominionuevo);
				cierraVentana(frmmuestrausuarios);
				cierraVentana(frmPruebaServidor);
			}
		});
		
		mntmVerUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmmuestrausuarios = new FrmMuestraUsuarios();
				abreVentana(frmmuestrausuarios);
				
				cierraVentana(frmusuario);
				cierraVentana(frmcuenta);
				cierraVentana(frmmuestracuentas);
				cierraVentana(frmdominionuevo);
				cierraVentana(frmmuestradominios);
				cierraVentana(frmPruebaServidor);
			}
		});
		
		mntmPruebaServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPruebaServidor = new FrmPruebaServidor();
				abreVentana(frmPruebaServidor);
				
				cierraVentana(frmmuestrausuarios);
				cierraVentana(frmusuario);
				cierraVentana(frmcuenta);
				cierraVentana(frmmuestracuentas);
				cierraVentana(frmdominionuevo);
				cierraVentana(frmmuestradominios);
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
	public void cierraVentana(JInternalFrame panel){
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
		menuBar.setEnabled(true);
	}
	public static void menuDesHabilitado(){
		VentPrincipal.setEnabled(false);
	}
}
