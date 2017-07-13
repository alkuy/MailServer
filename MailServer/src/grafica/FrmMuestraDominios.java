package grafica;

import static grafica.principal.apareceLogo;
import static grafica.principal.cierraVentana;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Logica.Fachada;

public class FrmMuestraDominios extends JInternalFrame {
	private JTable tblMDominios;
	private Fachada FCLogica = Fachada.getInstancia();
	
	/**
	 * Create the frame.
	 */
	public FrmMuestraDominios() {
		setBounds(20, 60, 450, 360);
		setLayout(null);
		
		/*BOTON DE CERRAR*/
		JButton btnCerrar = new JButton("");
		 btnCerrar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 	}
		 });
		 btnCerrar.setIcon(new ImageIcon(FrmNuevoDominio.class.getResource("/imagenes/cerrar.png")));
		 btnCerrar.setBounds(10, 0, 35, 35);
		 getContentPane().add(btnCerrar);
		 /*FIN DE BOTON DE CERRAR*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 76, 343, 220);
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
