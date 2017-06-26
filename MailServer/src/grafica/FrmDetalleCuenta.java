package grafica;
import static grafica.FrmMuestraCuentas.*;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import Logica.Fachada;

import javax.swing.JButton;
import java.awt.Font;

public class FrmDetalleCuenta extends JInternalFrame {

	private Fachada FCLogica = Fachada.getInstancia();
	/**
	 * Create the frame.
	 */
	public FrmDetalleCuenta() {
		setBounds(100, 100, 450, 340);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblNombre.setBounds(85, 42, 100, 31);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblApellido.setBounds(184, 42, 100, 31);
		getContentPane().add(lblApellido);
		
		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblCuenta.setBounds(85, 109, 263, 31);
		getContentPane().add(lblCuenta);
		
		JButton btnResetearContrasea = new JButton("Resetear Contrase\u00F1a");
		btnResetearContrasea.setBounds(74, 224, 274, 46);
		getContentPane().add(btnResetearContrasea);

	}
}
