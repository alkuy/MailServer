package grafica;

import static grafica.principal.abreVentana;
import static grafica.principal.desapareceLogo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Logica.Fachada;
import Logica.Usuario;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMuestraUsuarios extends JInternalFrame {

	public static String id = new String();
	
	private FrmEdicionUsuario detalle;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblMUsuarios;
	private Fachada FCLogica = Fachada.getInstancia();
	/**
	 * Create the frame.
	 */
	public FrmMuestraUsuarios() {
		setBounds(20, 60, 450, 500);
		getContentPane().setLayout(null);
		
		this.SetTable();
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Goudy Old Style", Font.BOLD, 24));
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setBounds(133, 11, 164, 34);
		getContentPane().add(lblUsuarios);
		
		JScrollPane scrlMUsuarios = new JScrollPane(tblMUsuarios);
		scrlMUsuarios.setEnabled(false);
		scrlMUsuarios.setSize(414, 326);
		scrlMUsuarios.setLocation(10, 57);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrlMUsuarios, BorderLayout.CENTER);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos = tblMUsuarios.getSelectedRow();
				id = (String) tblMUsuarios.getValueAt(pos, 0);
				//System.out.println(id);
				detalle = new FrmEdicionUsuario(id); //detalle = new FrmEdicionUsuario();
				abreVentana(detalle);
				desapareceLogo();
				
			}
		});
		btnEditar.setBounds(10, 398, 414, 50);
		getContentPane().add(btnEditar);
		
	}
	
	public void SetTable(){
		String col[] = {"Documento","Nombre"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);
		try{
			modelo = FCLogica.DevUsuariosCompleto();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		tblMUsuarios = new JTable(modelo);
		tblMUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

	}


}
