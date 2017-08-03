package grafica;

import static grafica.principal.apareceLogo;
import static grafica.principal.cierraVentana;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Icon;
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
		setBounds(20, 30, 450, 360);
		getContentPane().setLayout(null);
		
		/*BOTON DE CERRAR*/
		JButton btnCerrar = new JButton("");
		 btnCerrar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 	}
		 });
		 btnCerrar.setBounds(0, 0, 19, 19);
		ImageIcon iconocerrar = new ImageIcon(principal.class.getResource("/imagenes/cerrar.png"));
		Icon iconClose = new ImageIcon(iconocerrar.getImage().getScaledInstance(btnCerrar.getWidth(),btnCerrar.getHeight(),Image.SCALE_DEFAULT));
		btnCerrar.setIcon(iconClose);
		getContentPane().add(btnCerrar);
			 /*FIN DE BOTON DE CERRAR*/
		 /*FIN DE BOTON DE CERRAR*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 76, 343, 220);
		getContentPane().add(scrollPane);
		
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
		lblDominios.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		lblDominios.setBounds(137, 0, 159, 40);
		getContentPane().add(lblDominios);

	}

}
