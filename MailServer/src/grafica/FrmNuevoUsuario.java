package grafica;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	/**
	 * Create the panel.
	 */
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
		
		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.setBounds(138, 431, 246, 30);
		add(btnAgregarUsuario);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 206, 388, 21);
		add(separator);

	}
}
