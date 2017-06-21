package grafica;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrmNuevoDominio extends JInternalFrame {

	private JTextField txtADdominio;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public FrmNuevoDominio() {
		setBounds(20, 60, 450, 300);
		setLayout(null);
		
		JLabel lblADtitulo = new JLabel("Agregar Dominio");
		lblADtitulo.setBounds(150, 11, 150, 26);
		lblADtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblADtitulo.setFont(new Font("Goudy Old Style", Font.BOLD, 21));
		add(lblADtitulo);
		
		JLabel lblADdominio = new JLabel("Nombre");
		lblADdominio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblADdominio.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblADdominio.setBounds(75, 105, 65, 30);
		add(lblADdominio);
		
		txtADdominio = new JTextField();
		txtADdominio.setColumns(10);
		txtADdominio.setBounds(144, 105, 250, 30);
		add(txtADdominio);
		
		JButton btnADagregar = new JButton("Agregar");
		btnADagregar.setBounds(75, 177, 319, 30);
		add(btnADagregar);

	}

}
