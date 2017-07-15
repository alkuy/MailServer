package grafica;
import static grafica.principal.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Logica.Fachada;
import grafica.FrmMuestraUsuarios.CustomRenderer;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
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
		//setBorder(new EmptyBorder(0, 0, 0, 0));
		setBounds(20, 60, 465, 500);
		getContentPane().setLayout(null);

		/*BOTON DE CERRAR*/
		JButton btnCerrar = new JButton("");
		 btnCerrar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		apareceLogo();
		 		cierraVentana(detalle);
		 		dispose();
		 	}
		 });
		 btnCerrar.setIcon(new ImageIcon(FrmNuevoDominio.class.getResource("/imagenes/cerrar.png")));
		 btnCerrar.setBounds(10, 0, 35, 35);
		 getContentPane().add(btnCerrar);
		 /*FIN DE BOTON DE CERRAR*/
		
		
		this.SetTable();
		/*#############################*/
		
		JLabel lblCuentas = new JLabel("Cuentas");
		lblCuentas.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		lblCuentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuentas.setBounds(142, 0, 164, 34);
		getContentPane().add(lblCuentas);

		
		JScrollPane scrlMCMostrarCuentas = new JScrollPane(tblMuestraCuentas);
		scrlMCMostrarCuentas.setEnabled(false);
		scrlMCMostrarCuentas.setSize(430, 301);
		scrlMCMostrarCuentas.setLocation(10, 57);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrlMCMostrarCuentas, BorderLayout.CENTER);
		
		JLabel lblEnGrisUsuarios = new JLabel("En gris usuarios no activos del sistema");
		lblEnGrisUsuarios.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblEnGrisUsuarios.setForeground(Color.GRAY);
		lblEnGrisUsuarios.setBounds(37, 369, 360, 29);
		getContentPane().add(lblEnGrisUsuarios);
	
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Cargo el valor del id de la tabla*/
				int pos = tblMuestraCuentas.getSelectedRow();
				if (pos == -1){
					JOptionPane.showMessageDialog(new JPanel(), "Debe elegir el registro que quiere editar");
				}else{
				id = (String) tblMuestraCuentas.getValueAt(pos, 0);
				nombrecuenta = (String) tblMuestraCuentas.getValueAt(pos, 1);
				cierraVentana(detalle);
			
				detalle = new FrmEdicionCuenta(); //<- asi lo tenias
				
//				detalle = new FrmEdicionCuenta(Integer.valueOf(id)); //Para probar
				abreVentana(detalle);
				desapareceLogo();
				//menuDesHabilitado(); //No funciona aún
				//dispose();
				}
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
		
		tblMuestraCuentas.getColumnModel().getColumn(0).setWidth(250);
		
		/*Ocukto la columna que tiene el valor de Usuario eliminado*/
		TableColumn myTableColumn1 = tblMuestraCuentas.getColumnModel().getColumn(2);
		tblMuestraCuentas.getColumnModel().removeColumn(myTableColumn1);
		
		
		tblMuestraCuentas.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());
		tblMuestraCuentas.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer());
		
	}
	
	class CustomRenderer extends DefaultTableCellRenderer 
	{
	private static final long serialVersionUID = 6703872492730589499L;

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	    {
	        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

	        String estado = (String)table.getModel().getValueAt(row, 2);
	        if ("false".equals(estado)){
	        	setBackground(Color.GRAY);
	        }else{
	        	setBackground(Color.WHITE);
	        }
	     
	        return cellComponent;
	    }
	}

}
