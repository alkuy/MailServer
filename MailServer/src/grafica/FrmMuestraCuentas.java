package grafica;
import static grafica.principal.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Logica.Fachada;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMuestraCuentas extends JInternalFrame {
	
	public static String id = new String();
	public static String nombrecuenta = new String();
	
	private FrmEdicionCuenta detalle;

	private JTable tblMuestraCuentas;
	private static final long serialVersionUID = 1L;
	
	private Fachada FCLogica = Fachada.getInstancia();
	/**
	 * Create the frame.
	 */
	public FrmMuestraCuentas() {
		setTitle("Cuentas");
		setForeground(Color.LIGHT_GRAY);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBounds(20, 60, 450, 500);
		getContentPane().setLayout(null);
		
		
		this.SetTable();
		/*#############################*/
		
		JLabel lblCuentas = new JLabel("Cuentas");
		lblCuentas.setFont(new Font("Goudy Old Style", Font.BOLD, 24));
		lblCuentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuentas.setBounds(133, 11, 164, 34);
		getContentPane().add(lblCuentas);

		
		JScrollPane scrlMCMostrarCuentas = new JScrollPane(tblMuestraCuentas);
		scrlMCMostrarCuentas.setEnabled(false);
		scrlMCMostrarCuentas.setSize(430, 330);
		scrlMCMostrarCuentas.setLocation(10, 57);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrlMCMostrarCuentas, BorderLayout.CENTER);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Cargo el valor del id de la tabla*/
				int pos = tblMuestraCuentas.getSelectedRow();
				id = (String) tblMuestraCuentas.getValueAt(pos, 0);
				nombrecuenta = (String) tblMuestraCuentas.getValueAt(pos, 1);
				//System.out.println(id);
				detalle = new FrmEdicionCuenta();
				abreVentana(detalle);
				desapareceLogo();
				menuDesHabilitado();
				//dispose();
			}
		});
		btnEditar.setBounds(10, 409, 430, 53);
		getContentPane().add(btnEditar);

	}
	
	public void SetTable(){
		String col[] = {"id-usuario","Cuenta"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);
		try{
			modelo = FCLogica.DevCuentasCompleto();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		tblMuestraCuentas = new JTable(modelo);
		tblMuestraCuentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

	}
	
	

}
