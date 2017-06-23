package grafica;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;

public class FrmNuevoUAdministrador extends JInternalFrame {
	private JTextField txtNAnombre;
	private JPasswordField passwordField;
	/**
	 * Create the frame.
	 */
	public FrmNuevoUAdministrador() {
		setTitle("Nuevo Administrador");
		setForeground(Color.LIGHT_GRAY);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBounds(20, 60, 450, 300);
		getContentPane().setLayout(null);
		
		txtNAnombre = new JTextField();
		txtNAnombre.setBounds(188, 103, 200, 30);
		getContentPane().add(txtNAnombre);
		txtNAnombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblNombre.setBounds(111, 104, 67, 25);
		getContentPane().add(lblNombre);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 144, 200, 30);
		getContentPane().add(passwordField);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblContrasea.setBounds(93, 144, 90, 26);
		getContentPane().add(lblContrasea);
		
		JLabel lblUsuarioAdministradorNuevo = new JLabel("Usuario Administrador Nuevo");
		lblUsuarioAdministradorNuevo.setFont(new Font("Goudy Old Style", Font.BOLD, 24));
		lblUsuarioAdministradorNuevo.setBounds(72, 26, 305, 30);
		getContentPane().add(lblUsuarioAdministradorNuevo);

	}
}
