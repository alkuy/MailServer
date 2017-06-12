package grafica;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrmMuestraUsuarios extends JPanel {
	private JTable tblMUsuarios;

	/**
	 * Create the panel.
	 */
	public FrmMuestraUsuarios() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 89, 337, 385);
		add(scrollPane);
		
		tblMUsuarios = new JTable();
		scrollPane.setViewportView(tblMUsuarios);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setFont(new Font("Goudy Old Style", Font.BOLD, 24));
		lblUsuarios.setBounds(133, 31, 164, 34);
		add(lblUsuarios);

	}
}
