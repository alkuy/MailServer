package grafica;
import static grafica.principal.*;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import Logica.Fachada;
import Logica.Usuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEdicionUsuario extends JInternalFrame {

	private Fachada FCLogica = Fachada.getInstancia();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDocumento;
	private JTextField txtTel2;
	private JTextField txtTel1;
	private JTextField txtCalle;
	private JTextField txtNroPuerta;
	private JTextField txtApto;

	
	/**
	 * Create the frame.
	 */
	public FrmEdicionUsuario(String id) { //Este id es cedula
//		System.out.println(id);
		int id_usuario = FCLogica.getID(id);
		Usuario usu = FCLogica.findUsu(id_usuario);
		
		
		setBounds(550, 100, 350, 440);
		getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(84, 2, 240, 30);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setText(usu.getNombre());
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(84, 43, 240, 30);
		getContentPane().add(txtApellido);
		txtApellido.setText(usu.getApellido());
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(84, 84, 240, 30);
		getContentPane().add(txtDocumento);
		txtDocumento.setText(usu.getCi());
		
		txtTel1 = new JTextField();
		txtTel1.setColumns(10);
		txtTel1.setBounds(84, 218, 240, 30);
		getContentPane().add(txtTel1);
		String numTel1 = FCLogica.retornarTelx(FCLogica.getID(id), 0);
		txtTel1.setText(numTel1); //tel 1 es el 0
		
		txtTel2 = new JTextField();
		txtTel2.setColumns(10);
		txtTel2.setBounds(84, 259, 240, 30);
		getContentPane().add(txtTel2);
		String numTel2 = FCLogica.retornarTelx(FCLogica.getID(id), 1);
		txtTel2.setText(numTel2);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(84, 130, 240, 30);
		getContentPane().add(txtCalle);
		txtCalle.setText(usu.getCalle());
		
		txtNroPuerta = new JTextField();
		txtNroPuerta.setColumns(10);
		txtNroPuerta.setBounds(84, 171, 70, 30);
		getContentPane().add(txtNroPuerta);
		txtNroPuerta.setText(usu.getNro_puerta());
		
		txtApto = new JTextField();
		txtApto.setColumns(10);
		txtApto.setBounds(254, 171, 70, 30);
		getContentPane().add(txtApto);
		txtApto.setText(usu.getApto());
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblNombre.setBounds(10, 0, 64, 30);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblApellido.setBounds(10, 43, 64, 30);
		getContentPane().add(lblApellido);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDocumento.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblDocumento.setBounds(0, 84, 74, 30);
		getContentPane().add(lblDocumento);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalle.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblCalle.setBounds(10, 130, 64, 30);
		getContentPane().add(lblCalle);
		
		JLabel lblNroPuerta = new JLabel("Nro");
		lblNroPuerta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNroPuerta.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblNroPuerta.setBounds(10, 171, 64, 30);
		getContentPane().add(lblNroPuerta);
		
		JLabel lblTel1 = new JLabel("Tel\u00E9fono");
		lblTel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel1.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblTel1.setBounds(10, 218, 64, 30);
		getContentPane().add(lblTel1);
		
		JLabel lblTel2 = new JLabel("Tel\u00E9fono");
		lblTel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel2.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblTel2.setBounds(10, 259, 64, 30);
		getContentPane().add(lblTel2);
		
		JLabel lblApto = new JLabel("Apto");
		lblApto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApto.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblApto.setBounds(184, 171, 64, 30);
		getContentPane().add(lblApto);
		
		JButton btnGuardar = new JButton("Guardar y Cerrar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FCLogica.modifyUsuario(id_usuario, txtDocumento.getText(), txtNombre.getText(), 
						txtApellido.getText(), txtCalle.getText(), txtNroPuerta.getText(), 
						txtApto.getText());
				dispose();
				apareceLogo();
				
			}
		});
		btnGuardar.setBounds(15, 317, 303, 35);
		getContentPane().add(btnGuardar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				apareceLogo();
			}
		});
		btnCerrar.setBounds(15, 363, 303, 35);
		getContentPane().add(btnCerrar);
		toFront();

	}
}


