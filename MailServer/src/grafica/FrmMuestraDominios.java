package grafica;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


import Logica.Fachada;

public class FrmMuestraDominios extends JPanel {
	private JTable tblMDominios;
	private Fachada FCLogica = Fachada.getInstancia();
	/**
	 * Create the panel.
	 */
	public FrmMuestraDominios() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 76, 343, 217);
		add(scrollPane);
		
		String col[] = {"Dominio","Prioridad"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);
		
		try{
		modelo = FCLogica.DevDominioCompleto();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tblMDominios = new JTable(modelo);
		scrollPane.setViewportView(tblMDominios);
		
		JLabel lblDominios = new JLabel("Dominios");
		lblDominios.setHorizontalAlignment(SwingConstants.CENTER);
		lblDominios.setFont(new Font("Goudy Old Style", Font.BOLD, 24));
		lblDominios.setBounds(153, 11, 159, 40);
		add(lblDominios);

	}
}
