package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Logica.Fachada;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class FrmMuestraCuentas extends JInternalFrame {

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
		
		JScrollPane scrlMCMostrarCuentas = new JScrollPane(tblMuestraCuentas);
		scrlMCMostrarCuentas.setEnabled(false);
		scrlMCMostrarCuentas.setSize(430, 330);
		scrlMCMostrarCuentas.setLocation(10, 57);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrlMCMostrarCuentas, BorderLayout.CENTER);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(10, 409, 89, 23);
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
