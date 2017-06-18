package grafica;
import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Logica.Fachada;

import javax.swing.JButton;
/*
 * */
public class FrmMuestraCuentas extends JPanel {

	private JTable tblMuestraCuentas;
	private static final long serialVersionUID = 1L;
	
	private Fachada FCLogica = Fachada.getInstancia();
	/**
	 * Create the panel.
	 */
	public FrmMuestraCuentas() {
		setBounds(20, 60, 450, 500);
		setLayout(null);
		
		this.SetTable();
		/*#############################*/
		
		JScrollPane scrlMCMostrarCuentas = new JScrollPane(tblMuestraCuentas);
		scrlMCMostrarCuentas.setEnabled(false);
		scrlMCMostrarCuentas.setSize(400, 200);
		scrlMCMostrarCuentas.setLocation(25, 57);
		//Agregamos el JScrollPane al contenedor
		add(scrlMCMostrarCuentas, BorderLayout.CENTER);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(33, 453, 89, 23);
		add(btnEditar);

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
