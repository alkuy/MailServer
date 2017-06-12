package grafica;
import java.awt.BorderLayout;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class FrmMuestraCuentas extends JPanel {

	private JTable tblMuestraCuentas;
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public FrmMuestraCuentas() {
		setBounds(20, 60, 450, 500);
		setLayout(null);
		
		String col[] = {"id-usuario","Cuenta"};

		DefaultTableModel TablaForma = new DefaultTableModel(col, 0);

		tblMuestraCuentas = new JTable(TablaForma);
		tblMuestraCuentas.setRowSelectionAllowed(false);
		tblMuestraCuentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		/*Para Cargar Array list aqui*/
		TablaForma.addRow(col);
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
}
