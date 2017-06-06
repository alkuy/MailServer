package grafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

public class principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel ImagenLogo = null;
	private JTextField txtUNnombre;
	private JTextField txtUNapellido;
	private JTextField txtUNdocumento;
	private JTextField txtCNdocumento;
	private JTextField txtCNnombre;
	private final ButtonGroup grpbtnSelectTipoCuenta = new ButtonGroup();
	private JTable tblMuestraCuentas;
	private JTable tblDominios;
	private JTextField txtADdominio;
	private JTable table;
	private JTextField txtUNcalle;
	private JTextField txtUNnroPuerta;
	private JTextField txtUNapto;
	private JTextField textField;
	private JTextField textField_1;
	private JTable tblmuestraCuentas;
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
		
		JPanel PanMuestraCuentas = new JPanel();
		PanMuestraCuentas.setBounds(20, 60, 450, 500);
		contentPane.add(PanMuestraCuentas);
		PanMuestraCuentas.setLayout(null);
		

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
		
		
		ImagenLogo = new JLabel(new ImageIcon(principal.class.getResource("/imagenes/logo-mail.png")));
		ImagenLogo.setBounds(499, 81, 362, 248);
		contentPane.add(ImagenLogo);
		/**
		 * Menu Bar
		 */
		
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
		
		/**
		 * Panel de Nuevo Usuario
		 * */
		
		
		JPanel PanNuevoUsuario = new JPanel();
		PanNuevoUsuario.setBounds(20, 60, 450, 500);
		contentPane.add(PanNuevoUsuario);
		PanNuevoUsuario.setLayout(null);
		
		txtUNnombre = new JTextField();
		txtUNnombre.setBounds(138, 70, 250, 30);
		PanNuevoUsuario.add(txtUNnombre);
		txtUNnombre.setColumns(10);
		
		JLabel lblUNnombre = new JLabel("Nombre");
		lblUNnombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNnombre.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNnombre.setBounds(28, 70, 100, 30);
		PanNuevoUsuario.add(lblUNnombre);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo Usuario");
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setFont(new Font("Goudy Old Style", Font.BOLD, 21));
		lblNuevoUsuario.setBounds(136, 11, 166, 46);
		PanNuevoUsuario.add(lblNuevoUsuario);
		
		txtUNapellido = new JTextField();
		txtUNapellido.setBounds(138, 111, 250, 30);
		PanNuevoUsuario.add(txtUNapellido);
		txtUNapellido.setColumns(10);
		
		JLabel lblUNapellido = new JLabel("Apellido");
		lblUNapellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNapellido.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNapellido.setBounds(28, 111, 100, 30);
		PanNuevoUsuario.add(lblUNapellido);
		
		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.setBounds(138, 431, 246, 30);
		PanNuevoUsuario.add(btnAgregarUsuario);
		
		JLabel lblUNdocumento = new JLabel("Documento");
		lblUNdocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNdocumento.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNdocumento.setBounds(28, 155, 100, 30);
		PanNuevoUsuario.add(lblUNdocumento);
		
				
		txtUNdocumento = new JTextField();
		txtUNdocumento.setColumns(10);
		txtUNdocumento.setBounds(138, 155, 250, 30);
		PanNuevoUsuario.add(txtUNdocumento);
		
		txtUNcalle = new JTextField();
		txtUNcalle.setColumns(10);
		txtUNcalle.setBounds(138, 238, 250, 30);
		PanNuevoUsuario.add(txtUNcalle);
		
		JLabel lblUNcalle = new JLabel("Calle");
		lblUNcalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNcalle.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNcalle.setBounds(28, 238, 100, 30);
		PanNuevoUsuario.add(lblUNcalle);
		
		txtUNnroPuerta = new JTextField();
		txtUNnroPuerta.setColumns(10);
		txtUNnroPuerta.setBounds(138, 279, 94, 30);
		PanNuevoUsuario.add(txtUNnroPuerta);
		
		JLabel lblUNnroPuerta = new JLabel("Nro Puerta");
		lblUNnroPuerta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNnroPuerta.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNnroPuerta.setBounds(28, 279, 100, 30);
		PanNuevoUsuario.add(lblUNnroPuerta);
		
		JLabel lblUNapto = new JLabel("Apto");
		lblUNapto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNapto.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNapto.setBounds(264, 279, 48, 30);
		PanNuevoUsuario.add(lblUNapto);
		
		txtUNapto = new JTextField();
		txtUNapto.setColumns(10);
		txtUNapto.setBounds(322, 279, 67, 30);
		PanNuevoUsuario.add(txtUNapto);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(138, 320, 250, 30);
		PanNuevoUsuario.add(textField);
		
		JLabel lblUNtelefono1 = new JLabel("Tel\u00E9fono");
		lblUNtelefono1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNtelefono1.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNtelefono1.setBounds(28, 320, 100, 30);
		PanNuevoUsuario.add(lblUNtelefono1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 361, 250, 30);
		PanNuevoUsuario.add(textField_1);
		
		JLabel lblUNtelefono2 = new JLabel("Tel\u00E9fono");
		lblUNtelefono2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNtelefono2.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNtelefono2.setBounds(28, 361, 100, 30);
		PanNuevoUsuario.add(lblUNtelefono2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(56, 226, 384, 15);
		PanNuevoUsuario.add(separator_1);
		PanNuevoUsuario.setVisible(false);
		
		JPanel PanAgregarDominio = new JPanel();
		PanAgregarDominio.setBounds(20, 60, 450, 300);
		contentPane.add(PanAgregarDominio);
		PanAgregarDominio.setLayout(null);
		
		JLabel lblADtitulo = new JLabel("Agregar Dominio");
		lblADtitulo.setBounds(150, 11, 150, 26);
		lblADtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblADtitulo.setFont(new Font("Goudy Old Style", Font.BOLD, 21));
		PanAgregarDominio.add(lblADtitulo);
		
		JLabel lblADdominio = new JLabel("Nombre");
		lblADdominio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblADdominio.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblADdominio.setBounds(75, 105, 65, 30);
		PanAgregarDominio.add(lblADdominio);
		
		txtADdominio = new JTextField();
		txtADdominio.setColumns(10);
		txtADdominio.setBounds(144, 105, 250, 30);
		PanAgregarDominio.add(txtADdominio);
		
		JButton btnADagregar = new JButton("Agregar");
		btnADagregar.setBounds(75, 177, 319, 30);
		PanAgregarDominio.add(btnADagregar);
		
		JPanel PanDominios = new JPanel();
		PanDominios.setBounds(20, 60, 450, 500);
		contentPane.add(PanDominios);
		
		tblDominios = new JTable();
		PanDominios.add(tblDominios);
		
		
		
		JPanel PanNuevoCuenta = new JPanel();
		PanNuevoCuenta.setBounds(20, 60, 450, 300);
		contentPane.add(PanNuevoCuenta);
		PanNuevoCuenta.setLayout(null);
		
		JLabel lblNuevaCuenta = new JLabel("Nueva Cuenta");
		lblNuevaCuenta.setBounds(163, 5, 123, 26);
		lblNuevaCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCuenta.setFont(new Font("Goudy Old Style", Font.BOLD, 21));
		PanNuevoCuenta.add(lblNuevaCuenta);
		
		JComboBox cboNCdominio = new JComboBox();
		cboNCdominio.setBounds(150, 207, 250, 30);
		PanNuevoCuenta.add(cboNCdominio);
		
		JLabel lblCNNombreUsuario = new JLabel("Nombre Usuario");
		lblCNNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNNombreUsuario.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCNNombreUsuario.setBounds(10, 166, 136, 30);
		PanNuevoCuenta.add(lblCNNombreUsuario);
		
		txtCNnombre = new JTextField();
		txtCNnombre.setColumns(10);
		txtCNnombre.setBounds(150, 166, 250, 30);
		PanNuevoCuenta.add(txtCNnombre);
		
		JLabel lblCNdominio = new JLabel("Dominio");
		lblCNdominio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNdominio.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCNdominio.setBounds(46, 207, 100, 30);
		PanNuevoCuenta.add(lblCNdominio);
		
		JLabel lblNombreApellidoO = new JLabel("Nombre Apellido o No existe");
		lblNombreApellidoO.setBounds(150, 105, 250, 30);
		PanNuevoCuenta.add(lblNombreApellidoO);
		
		JButton btnCNingresar = new JButton("New button");
		btnCNingresar.setBounds(150, 248, 250, 30);
		PanNuevoCuenta.add(btnCNingresar);
		
		JRadioButton rdbtnGrupoUOficina = new JRadioButton("Grupo u Oficina");
		grpbtnSelectTipoCuenta.add(rdbtnGrupoUOficina);
		rdbtnGrupoUOficina.setBounds(257, 48, 109, 23);
		PanNuevoCuenta.add(rdbtnGrupoUOficina);
		
		JRadioButton rdbtnCNpersona = new JRadioButton("Persona");
		grpbtnSelectTipoCuenta.add(rdbtnCNpersona);
		rdbtnCNpersona.setBounds(160, 48, 89, 23);
		PanNuevoCuenta.add(rdbtnCNpersona);
		
		
		JLabel lblCNdocumento = new JLabel("Documento");
		lblCNdocumento.setBounds(46, 72, 100, 30);
		lblCNdocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNdocumento.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		PanNuevoCuenta.add(lblCNdocumento);
		
		
		txtCNdocumento = new JTextField();
		txtCNdocumento.setBounds(150, 74, 250, 30);
		txtCNdocumento.setColumns(10);
		PanNuevoCuenta.add(txtCNdocumento);
		txtCNdocumento.setEditable(false);
		
		JLabel lblCNtipo = new JLabel("Tipo de cuenta");
		lblCNtipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNtipo.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCNtipo.setBounds(10, 42, 136, 30);
		PanNuevoCuenta.add(lblCNtipo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 146, 388, 9);
		PanNuevoCuenta.add(separator);
		
		/**
		 * Meustra Cuentas
		 */
		
		JPanel PanModificarCuenta = new JPanel();
		PanModificarCuenta.setBounds(20, 60, 450, 30);
		contentPane.add(PanModificarCuenta);

		/*#######################################################################33*/
		 
		/*############################################################################3*/
		
		//pack();
						
		
		/**
		 * Paneles no visibles
		 * Hasta ser llamados
		 */
		PanNuevoCuenta.setVisible(false);
		PanDominios.setVisible(false);
		PanAgregarDominio.setVisible(false);
		PanModificarCuenta.setVisible(false);
		PanMuestraCuentas.setVisible(false);
		
		
		/*#######################################*/
		/*ACCIONES*/
		
		
		mntmNuevoCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanNuevoUsuario.setVisible(false);
				PanMuestraCuentas.setVisible(false);
				PanDominios.setVisible(false);
				PanAgregarDominio.setVisible(false);
				PanNuevoCuenta.setVisible(true);
				
			}
		});
		
		mntmNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanNuevoCuenta.setVisible(false);
				PanMuestraCuentas.setVisible(false);
				PanDominios.setVisible(false);
				PanAgregarDominio.setVisible(false);
				PanNuevoUsuario.setVisible(true);
				
			}
		});
		
		mntmVerCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanNuevoCuenta.setVisible(false);
				PanDominios.setVisible(false);
				PanNuevoUsuario.setVisible(false);
				PanAgregarDominio.setVisible(false);
				PanMuestraCuentas.setVisible(true);
			}
		});
		
		mntmAgregarDominio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanNuevoCuenta.setVisible(false);
				PanDominios.setVisible(false);
				PanNuevoUsuario.setVisible(false);
				PanMuestraCuentas.setVisible(false);
				PanAgregarDominio.setVisible(true);
				
			}
		});
		
		rdbtnGrupoUOficina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCNdocumento.setEditable(false);
			}
		});
		
		
		rdbtnCNpersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCNdocumento.setEditable(true);	
			}
		});
	}
}
