package grafica;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrmMuetraDominios extends JPanel {
	private JTable tblMDominios;

	/**
	 * Create the panel.
	 */
	public FrmMuetraDominios() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 76, 343, 217);
		add(scrollPane);
		
		tblMDominios = new JTable();
		scrollPane.setViewportView(tblMDominios);
		
		JLabel lblDominios = new JLabel("Dominios");
		lblDominios.setHorizontalAlignment(SwingConstants.CENTER);
		lblDominios.setFont(new Font("Goudy Old Style", Font.BOLD, 24));
		lblDominios.setBounds(153, 11, 159, 40);
		add(lblDominios);

	}
}
