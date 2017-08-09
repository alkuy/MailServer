package grafica;
import static grafica.principal.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Logica.Fachada;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMuestraCuentas extends JInternalFrame {
	
	public static String id = new String();
	public static String nombrecuenta = new String();
	
	//private FrmEdicionCuenta edicCuenta;

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
		setBounds(20, 30, 465, 500);
		getContentPane().setLayout(null);

		/*BOTON DE CERRAR*/
		JButton btnCerrar = new JButton("");
		 btnCerrar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		apareceLogo();
		 		cierraVentana(edicCuenta);
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
				cierraVentana(edicCuenta);
			
				edicCuenta = new FrmEdicionCuenta(); //<- asi lo tenias
				
				
//				detalle = new FrmEdicionCuenta(Integer.valueOf(id)); //Para probar
				abreVentana(edicCuenta);
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
		tblMuestraCuentas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
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
	        
	        Color gricesito = new Color(240,240,240);
	        if (row%2==0){
	        	setBackground(gricesito);
	        }else{
	        	setBackground(Color.white);
	        }
	        
	        String estado = (String)table.getModel().getValueAt(row, 2);
	        if ("false".equals(estado)){
	        	setBackground(Color.gray);
	        }
	        
	        if (isSelected) {
	        	Color azulcito = new Color(47,79,79);
                this.setBackground(azulcito);
                this.setForeground(Color.white);
            } else {
                this.setForeground(Color.black);
            }
	        
	        
	     
	        return cellComponent;
	    }
	}

}
