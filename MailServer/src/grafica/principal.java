package grafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel ImagenLogo = null;

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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*······························*/
		/*MENU ARRIBA PRINCIPAL*/
		/*······························*/
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 894, 21);
		contentPane.add(menuBar);
		
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
		
		/*···························*/
		/*Formulario Nuevo Usuario*/
		/*······························*/
		FrmNuevoUsuario frmusuario = new FrmNuevoUsuario();
		frmusuario.setBounds(20, 60, 450, 500);
		contentPane.add(frmusuario);
		
		/*Formulario Nueva Cuenta*/
		FrmNuevaCuenta frmcuenta = new FrmNuevaCuenta();
		frmcuenta.setBounds(20, 60, 450, 300);
		contentPane.add(frmcuenta);
		
		FrmNuevoDominio frmdominionuevo = new FrmNuevoDominio();
		frmdominionuevo.setBounds(20, 60, 450, 300);
		contentPane.add(frmdominionuevo);
		
		FrmMuestraCuentas frmmuestracuentas = new FrmMuestraCuentas();
		frmmuestracuentas.setBounds(20, 60, 450, 500);
		contentPane.add(frmmuestracuentas);
		
		/*#########   EL DE INICIO DE LOGIN   ################*/
		/*FrmLogin LOGIN = new FrmLogin();
		LOGIN.setBounds(20, 60, 500, 200);
		contentPane.add(LOGIN);*/
		/*##################################################3*/
		
		
		/*GAFICOS COSTADO*/
		ImagenLogo = new JLabel(new ImageIcon(principal.class.getResource("/imagenes/logo-mail.png")));
		ImagenLogo.setBounds(499, 81, 362, 248);
		contentPane.add(ImagenLogo);
	
		JLabel lblCorreoPintituciones = new JLabel("Correo Para Instituciones Educativas");
		lblCorreoPintituciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreoPintituciones.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
		lblCorreoPintituciones.setBounds(576, 443, 250, 30);
		contentPane.add(lblCorreoPintituciones);
		
		JLabel lblVersion = new JLabel("Version 1.0");
		lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersion.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
		lblVersion.setBounds(576, 470, 250, 30);
		contentPane.add(lblVersion);
		
		JLabel lblCreadoEnInet = new JLabel("Creado en INET");
		lblCreadoEnInet.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreadoEnInet.setFont(new Font("Goudy Old Style", Font.PLAIN, 13));
		lblCreadoEnInet.setBounds(576, 499, 250, 30);
		contentPane.add(lblCreadoEnInet);
		
			
		
		/*############################################*/
		 /* Paneles no visibles Hasta ser llamados */
		/*############################################*/
		
	//	menuBar.setVisible(false);
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
