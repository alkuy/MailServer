package grafica;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class FrmMuestraCuentas extends JPanel {

	/**
	 * 
	 */
	private JTable tblMuestraCuentas;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public FrmMuestraCuentas() {
		setBounds(20, 60, 450, 500);
		setLayout(null);
		
		String[] columnas_muestra_cuentas ={"Id", "Correo"};
		
		Object[][] datos_muestra_cuentas = {
				{"1", "correo@mail"},
				
			};
		
		
		tblMuestraCuentas = new JTable(datos_muestra_cuentas, columnas_muestra_cuentas);
		tblMuestraCuentas.setRowSelectionAllowed(false);
		tblMuestraCuentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrlMCMostrarCuentas = new JScrollPane(tblMuestraCuentas);
		scrlMCMostrarCuentas.setEnabled(false);
		scrlMCMostrarCuentas.setSize(400, 200);
		scrlMCMostrarCuentas.setLocation(25, 57);
		//Agregamos el JScrollPane al contenedor
		add(scrlMCMostrarCuentas, BorderLayout.CENTER);

	}

}
