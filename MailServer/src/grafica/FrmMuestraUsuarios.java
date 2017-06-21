package grafica;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class FrmMuestraUsuarios extends JInternalFrame {

	private JTable tblMUsuarios; 
	/**
	 * Create the frame.
	 */
	public FrmMuestraUsuarios() {
		setBounds(20, 60, 450, 300);
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 89, 337, 385);
		add(scrollPane);
		
		tblMUsuarios = new JTable();
		scrollPane.setViewportView(tblMUsuarios);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setBounds(133, 31, 164, 34);
		add(lblUsuarios);

	}

}
