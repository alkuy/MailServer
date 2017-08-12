package grafica;

import static grafica.FrmMuestraCuentas.id;
import static grafica.principal.apareceLogo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import Logica.Fachada;
import Logica.Usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class FrmAdminCambiaPass extends JInternalFrame {
	private JTextField txtOldPass;
	private JTextField txtNewPass;
	private Fachada FCLogica = Fachada.getInstancia();


	/**
	 * Create the frame.
	 */
	public FrmAdminCambiaPass(String id) {
		int id_usuario = FCLogica.getID(id);
		Usuario usu = FCLogica.findUsu(Integer.valueOf(id_usuario));
		
		setBounds(550, 30, 300, 340);
		getContentPane().setLayout(null);
		
		JLabel lblIdAdmin = new JLabel("IDAdmin");
		lblIdAdmin.setForeground(Color.RED);
		lblIdAdmin.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
		lblIdAdmin.setBounds(47, 11, 168, 37);
		getContentPane().add(lblIdAdmin);
		lblIdAdmin.setText(id);
		
		txtOldPass = new JTextField();
		txtOldPass.setBounds(43, 107, 200, 30);
		getContentPane().add(txtOldPass);
		txtOldPass.setColumns(10);
		
		txtNewPass = new JTextField();
		txtNewPass.setBounds(43, 161, 200, 30);
		getContentPane().add(txtNewPass);
		txtNewPass.setColumns(10);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a actual");
		lblContraseaActual.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblContraseaActual.setBounds(43, 79, 144, 23);
		getContentPane().add(lblContraseaActual);
		
		JLabel lblContraseaNueva = new JLabel("Contrase\u00F1a nueva");
		lblContraseaNueva.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblContraseaNueva.setBounds(43, 137, 144, 23);
		getContentPane().add(lblContraseaNueva);
		
		JButton btnCambiar = new JButton("Cambiar Contraseña");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String OldPass = txtOldPass.getText();
				if(OldPass.equals(usu.getPass_admin())){
					String pass = txtNewPass.getText();
					FCLogica.cambiaPassAdmin(id_usuario, pass);
					JOptionPane.showMessageDialog(new JPanel(), "Ud cambio la contraseña");
					apareceLogo();
					dispose();
				}else{
					JOptionPane.showMessageDialog(new JPanel(), "La contraseña actual no coincide");
				}
			}
		});
		btnCambiar.setBounds(61, 218, 154, 30);
		getContentPane().add(btnCambiar);
		
	
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apareceLogo();
				dispose();
			}
		});
		btnNewButton.setBounds(61, 259, 154, 30);
		getContentPane().add(btnNewButton);
		
		

	}
}
