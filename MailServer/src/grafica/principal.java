package grafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel VPrincipal;
	private JLabel ImagenLogo = null;
	
	public static JPanel getInstancia() {
		if(VPrincipal == null)
			VPrincipal = new JPanel();
		
		return VPrincipal;
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
		setBounds(100, 100, 900, 600);
		VPrincipal = new JPanel();
		VPrincipal.setBackground(new Color(0, 128, 128));
		VPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(VPrincipal);
		VPrincipal.setLayout(null);
		
		/*······························*/
		/*MENU ARRIBA PRINCIPAL*/
		/*······························*/
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 894, 21);
		VPrincipal.add(menuBar);
		
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
		
		JMenu mnConfiguracion = new JMenu("Configuracion");
		menuBar.add(mnConfiguracion);
		
		JMenuItem mntmAgregarDominio = new JMenuItem("Agregar Dominio");
		mnConfiguracion.add(mntmAgregarDominio);
		
		JMenuItem mntmDominios = new JMenuItem("Ver Dominios");
		mnConfiguracion.add(mntmDominios);
		
		/*······························*/
		/*Termina MENU ARRIBA*/
		/*······························*/
		
		ImagenLogo = new JLabel(new ImageIcon(principal.class.getResource("/imagenes/logo-mail.png")));
		ImagenLogo.setBounds(499, 81, 362, 248);
		VPrincipal.add(ImagenLogo);
		
			JLabel lblCorreoPintituciones = new JLabel("Correo Para Instituciones Educativas");
			lblCorreoPintituciones.setHorizontalAlignment(SwingConstants.CENTER);
			lblCorreoPintituciones.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
			lblCorreoPintituciones.setBounds(576, 443, 250, 30);
			VPrincipal.add(lblCorreoPintituciones);
		
		JLabel lblVersion = new JLabel("Version 1.0");
		lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersion.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
		lblVersion.setBounds(576, 470, 250, 30);
		VPrincipal.add(lblVersion);
		
		JLabel lblCreadoEnInet = new JLabel("Creado en INET");
		lblCreadoEnInet.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreadoEnInet.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
		lblCreadoEnInet.setBounds(576, 499, 250, 30);
		VPrincipal.add(lblCreadoEnInet);
		
		/*...............................*/
		/*########  LOGIN    ############*/

		JTextField txtLOGusuario = new JTextField();
		txtLOGusuario.setBounds(140, 180, 200, 30);
		VPrincipal.add(txtLOGusuario);
		txtLOGusuario.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(140, 230, 200, 30);
		VPrincipal.add(passwordField);
		
		JLabel ImgUserLog = new JLabel(new ImageIcon(principal.class.getResource("/imagenes/userLog.png")));
		ImgUserLog.setBounds(90, 180, 30, 30);
		VPrincipal.add(ImgUserLog);
		
		JLabel ImgKeyLog = new JLabel(new ImageIcon(principal.class.getResource("/imagenes/keyLog.png")));
		ImgKeyLog.setBounds(90, 230, 30, 30);
		VPrincipal.add(ImgKeyLog);
		
		JLabel lblLogin = new JLabel("LogIn");
		lblLogin.setBounds(120, 100, 208, 30);
		VPrincipal.add(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Goudy Old Style", Font.BOLD, 28));
		
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.setBounds(90, 300, 250, 40);
		VPrincipal.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImgUserLog.setVisible(false);
				ImgKeyLog.setVisible(false);
				txtLOGusuario.setVisible(false);
				passwordField.setVisible(false);
				btnNewButton.setVisible(false);
				lblLogin.setVisible(false);
				menuBar.setVisible(true);
					
			}
		});

		
		/*############  FIN LOGIN ######################################*/
		
		/*···························*/
		/*Formulario Nuevo Usuario*/
		/*······························*/
		
		FrmNuevoUsuario frmusuario = new FrmNuevoUsuario();
		frmusuario.setBounds(20, 60, 450, 500);
		VPrincipal.add(frmusuario);
		
		/*Formulario Nueva Cuenta*/
		FrmNuevaCuenta frmcuenta = new FrmNuevaCuenta();
		frmcuenta.setBounds(20, 60, 450, 300);
		VPrincipal.add(frmcuenta);
		
		FrmNuevoDominio frmdominionuevo = new FrmNuevoDominio();
		frmdominionuevo.setBounds(20, 60, 450, 300);
		VPrincipal.add(frmdominionuevo);
		
		FrmMuestraCuentas frmmuestracuentas = new FrmMuestraCuentas();
		frmmuestracuentas.setBounds(20, 60, 450, 500);
		VPrincipal.add(frmmuestracuentas);
		
		/*#########   EL DE INICIO DE LOGIN   ################*/
		/*FrmLogin LOGIN = new FrmLogin();
		LOGIN.setBounds(20, 60, 500, 200);
		contentPane.add(LOGIN);*/
		/*##################################################3*/
		
		
		/*GAFICOS COSTADO*/
		
			
		
		/*############################################*/
		 /* Paneles no visibles Hasta ser llamados */
		/*############################################*/
		
		menuBar.setVisible(false);
		frmusuario.setVisible(false);
		frmcuenta.setVisible(false);
		frmdominionuevo.setVisible(false);
		frmmuestracuentas.setVisible(false);
		
		

	
		/*#######################################*/
		/*#########     ACCIONES    #############*/
		/*#######################################*/
		
		
		/*############################################################################################################*/
		/*#####    BOTONES D BARRA DE MENU   -    LLAMAN A LOS CORRESPONDIENTES FORMULARIOS    #######################*/
		
		
		mntmNuevoCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmusuario.setVisible(false);
				frmcuenta.setVisible(true);
				frmdominionuevo.setVisible(false);
				frmmuestracuentas.setVisible(false);
			
			}
		});
		
		mntmNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmusuario.setVisible(true);
				frmcuenta.setVisible(false);
				frmdominionuevo.setVisible(false);
				frmmuestracuentas.setVisible(false);
	
			}
		});
		
		mntmVerCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmusuario.setVisible(false);
				frmcuenta.setVisible(false);
				frmdominionuevo.setVisible(false);
				frmmuestracuentas.setVisible(true);
			}
		});
		
		mntmAgregarDominio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmusuario.setVisible(false);
				frmcuenta.setVisible(false);
				frmmuestracuentas.setVisible(false);
				frmdominionuevo.setVisible(true);
	
			
				
			}
		});
		
		/*################   FIN  -   BOTONES D BARRA DE MENU  ###############################*/
		/*####################################################################################*/
		
	}
}
