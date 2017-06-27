package grafica;
import static grafica.FrmMuestraCuentas.*;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import Logica.Fachada;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDetalleCuenta extends JInternalFrame {

	private Fachada FCLogica = Fachada.getInstancia();
	/**
	 * Create the frame.
	 */
	public FrmDetalleCuenta() {
		setBounds(550, 100, 300, 340);
		getContentPane().setLayout(null);
		toFront();
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblNombre.setBounds(36, 42, 100, 31);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblApellido.setBounds(36, 71, 100, 31);
		getContentPane().add(lblApellido);
		
		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
		lblCuenta.setBounds(36, 103, 263, 31);
		getContentPane().add(lblCuenta);
		
		JButton btnResetearContrasea = new JButton("Resetear Contrase\u00F1a");
		btnResetearContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnResetearContrasea.setBounds(19, 210, 246, 46);
		getContentPane().add(btnResetearContrasea);

	}
}
