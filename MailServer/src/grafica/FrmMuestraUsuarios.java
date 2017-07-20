package grafica;

import static grafica.principal.abreVentana;
import static grafica.principal.apareceLogo;
import static grafica.principal.cierraVentana;
import static grafica.principal.desapareceLogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.sql.SQLException;

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
import Logica.Usuario;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrmMuestraUsuarios extends JInternalFrame {

	public static String id = new String();
	public static int desdemuestra = 0;
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
		setBounds(20, 30, 465, 500);
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
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setBounds(142, 0, 164, 34);
		getContentPane().add(lblUsuarios);
		
		JScrollPane scrlMUsuarios = new JScrollPane(tblMUsuarios);
		scrlMUsuarios.setEnabled(false);
		scrlMUsuarios.setSize(414, 301);
		scrlMUsuarios.setLocation(17, 57);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrlMUsuarios, BorderLayout.CENTER);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos = tblMUsuarios.getSelectedRow();
				if (pos == -1){
					JOptionPane.showMessageDialog(new JPanel(), "Debe elegir el registro que quiere editar");
				}else{
					id = (String) tblMUsuarios.getValueAt(pos, 0);
					//System.out.println(id);
					cierraVentana(detalle);
					desdemuestra = 1; //Utilizad para avisarle que vengo desde el listado y no desde busqyeda 
					detalle = new FrmEdicionUsuario(id); //detalle = new FrmEdicionUsuario();
					abreVentana(detalle);
					desapareceLogo();
				}
			}
		});
		btnEditar.setBounds(17, 409, 414, 50);
		getContentPane().add(btnEditar);
		
		JLabel lblEnGrisUsuarios = new JLabel("En gris usuarios no activos del sistema");
		lblEnGrisUsuarios.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblEnGrisUsuarios.setForeground(Color.GRAY);
		lblEnGrisUsuarios.setBounds(44, 369, 360, 29);
		getContentPane().add(lblEnGrisUsuarios);
		
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
		
		
		tblMUsuarios.getColumnModel().getColumn(0).setWidth(250);
		
		/*Ocukto la columna que tiene el valor de Usuario eliminado*/
		TableColumn myTableColumn1 = tblMUsuarios.getColumnModel().getColumn(2);
		tblMUsuarios.getColumnModel().removeColumn(myTableColumn1);
		
		
		tblMUsuarios.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());
		tblMUsuarios.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer());
		//tblMUsuarios.getColumnModel().getColumn(2).setCellRenderer(new CustomRenderer());
		

	}

	/**
	 * Metodo para remarcar en color los usuarios deshabilitados
	 * 
	 *
	 */
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
