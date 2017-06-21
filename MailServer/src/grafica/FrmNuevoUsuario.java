package grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
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

public class FrmNuevoUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtUNnombre;
	private JTextField txtUNapellido;
	private JTextField txtUNdocumento;
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
	private JPanel VentPrincipal = principal.getInstancia();
	/**
	 * Create the frame.
	 */
	public FrmNuevoUsuario() {
		setBounds(20, 30, 450, 530);
		getContentPane().setLayout(null);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo Usuario");
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setFont(new Font("Goudy Old Style", Font.BOLD, 21));
		lblNuevoUsuario.setBounds(136, 11, 166, 46);
		getContentPane().add(lblNuevoUsuario);
		
		/*Nombre*/
		JLabel lblUNnombre = new JLabel("Nombre");
		lblUNnombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNnombre.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNnombre.setBounds(28, 70, 100, 30);
		getContentPane().add(lblUNnombre);
		
		txtUNnombre = new JTextField();
		txtUNnombre.setBounds(138, 70, 250, 30);
		getContentPane().add(txtUNnombre);
		txtUNnombre.setColumns(10);
		
		JLabel lblUNapellido = new JLabel("Apellido");
		lblUNapellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNapellido.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNapellido.setBounds(28, 111, 100, 30);
		getContentPane().add(lblUNapellido);
		
	
		txtUNapellido = new JTextField();
		txtUNapellido.setBounds(138, 111, 250, 30);
		getContentPane().add(txtUNapellido);
		txtUNapellido.setColumns(10);
		
		JLabel lblUNdocumento = new JLabel("Documento");
		lblUNdocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNdocumento.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNdocumento.setBounds(28, 155, 100, 30);
		getContentPane().add(lblUNdocumento);
				
		txtUNdocumento = new JTextField();
		txtUNdocumento.setColumns(10);
		txtUNdocumento.setBounds(138, 155, 250, 30);
		getContentPane().add(txtUNdocumento);
		
		txtUNcalle = new JTextField();
		txtUNcalle.setColumns(10);
		txtUNcalle.setBounds(138, 238, 250, 30);
		getContentPane().add(txtUNcalle);
		
		JLabel lblUNcalle = new JLabel("Calle");
		lblUNcalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNcalle.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNcalle.setBounds(28, 238, 100, 30);
		getContentPane().add(lblUNcalle);
		
		txtUNnroPuerta = new JTextField();
		txtUNnroPuerta.setColumns(10);
		txtUNnroPuerta.setBounds(138, 279, 94, 30);
		getContentPane().add(txtUNnroPuerta);
		
		JLabel lblUNnroPuerta = new JLabel("Nro Puerta");
		lblUNnroPuerta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNnroPuerta.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNnroPuerta.setBounds(28, 279, 100, 30);
		getContentPane().add(lblUNnroPuerta);
		
		JLabel lblUNapto = new JLabel("Apto");
		lblUNapto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNapto.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNapto.setBounds(264, 279, 48, 30);
		getContentPane().add(lblUNapto);
		
		txtUNapto = new JTextField();
		txtUNapto.setColumns(10);
		txtUNapto.setBounds(322, 279, 67, 30);
		getContentPane().add(txtUNapto);
		
		txtUNtelefono1 = new JTextField();
		txtUNtelefono1.setColumns(10);
		txtUNtelefono1.setBounds(138, 320, 250, 30);
		getContentPane().add(txtUNtelefono1);
		
		JLabel lblUNtelefono1 = new JLabel("Tel\u00E9fono");
		lblUNtelefono1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNtelefono1.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNtelefono1.setBounds(28, 320, 100, 30);
		getContentPane().add(lblUNtelefono1);
		
		txtUNtelefono2 = new JTextField();
		txtUNtelefono2.setColumns(10);
		txtUNtelefono2.setBounds(138, 361, 250, 30);
		getContentPane().add(txtUNtelefono2);
		
		JLabel lblUNtelefono2 = new JLabel("Tel\u00E9fono");
		lblUNtelefono2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUNtelefono2.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblUNtelefono2.setBounds(28, 361, 100, 30);
		getContentPane().add(lblUNtelefono2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 196, 388, 21);
		getContentPane().add(separator);
		
		
		JRadioButton rdbtnConCuenta = new JRadioButton("Con cuenta");
		rdbtnTipoUsuario.add(rdbtnConCuenta);
		rdbtnConCuenta.setBounds(145, 409, 94, 23);
		getContentPane().add(rdbtnConCuenta);
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnTipoUsuario.add(rdbtnAdministrador);
		rdbtnAdministrador.setBounds(244, 409, 109, 23);
		getContentPane().add(rdbtnAdministrador);
		
		
		/*Etiqueta que avisa el error de campos faltantes*/
		lblFaltanCampos = new JLabel("* Faltan campos obligatorios");
		lblFaltanCampos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFaltanCampos.setBounds(168, 439, 220, 21);
		getContentPane().add(lblFaltanCampos);
		lblFaltanCampos.setVisible(false);
		
		/*INSTANCIO txt documento para pasarle a nueva cuenta*/
		JTextField txtCNdocumento = FrmNuevaCuenta.getInstancia();
		
		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			Verificaciones verifica = new Verificaciones();
			public void actionPerformed(ActionEvent arg0) {
				String nombre = verifica.remplazoCaracteres(txtUNnombre.getText());
				String apellido = verifica.remplazoCaracteres(txtUNapellido.getText());
				String documento = verifica.remplazoCaracteres(txtUNdocumento.getText());
				String calle = verifica.remplazoCaracteres(txtUNcalle.getText());
				String nroPuerta = verifica.remplazoCaracteres(txtUNnroPuerta.getText());
				String apto = verifica.remplazoCaracteres(txtUNapto.getText());
				String numTel = verifica.remplazoCaracteres(txtUNtelefono1.getText());
				
				/*Instancio la clase verificacion*/
				Verificaciones verifica = new Verificaciones();
				if(verifica.campo_vacio(txtUNnombre) && verifica.campo_vacio(txtUNapellido) && verifica.documento(txtUNdocumento)){
					try {
						FCLogica.altaUsu(documento, nombre, apellido, calle, nroPuerta, apto, numTel);
						/*Cierro Ventana*/
						setVisible(false);
						/*Levanto la de cuenta*/
						
						/*Debo ver que tipo de cuenta va a crear*/
						if (rdbtnConCuenta.isSelected()){
							cuenta = new FrmNuevaCuenta();
							abreVentana(cuenta);
							txtCNdocumento.setText(documento);
							txtCNdocumento.setBounds(150, 74, 250, 30);
						}
						
						if (rdbtnAdministrador.isSelected()){
							
					
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
		getContentPane().add(btnAgregarUsuario);
	}
	
	public void abreVentana(JInternalFrame panel){
		VentPrincipal.add(panel);
		BasicInternalFrameTitlePane titlePane =
			      (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) panel.getUI()).
			      getNorthPane();
		panel.remove(titlePane);
		panel.setVisible(true);
	}
}
