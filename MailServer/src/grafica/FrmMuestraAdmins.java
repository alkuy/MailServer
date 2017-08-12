package grafica;

import static grafica.principal.AdminPass;
import static grafica.principal.abreVentana;
import static grafica.principal.apareceLogo;
import static grafica.principal.cierraVentana;
import static grafica.principal.desapareceLogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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


public class FrmMuestraAdmins extends JInternalFrame {
	
	/**
	 * 
	 */
	private String id = new String();
	private static final long serialVersionUID = 1L;
	private JTable tblMUsuarios;
	private Fachada FCLogica = Fachada.getInstancia();

	/**
	 * Create the frame.
	 */
	public FrmMuestraAdmins() {
		setBounds(20, 30, 465, 500);
		getContentPane().setLayout(null);
		
		/*BOTON DE CERRAR*/
		JButton btnCerrar = new JButton("");
		 btnCerrar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		apareceLogo();
		 		cierraVentana(AdminPass);
		 		dispose();
		 	}
		 });
		 
		btnCerrar.setBounds(0, 0, 19, 19);
		ImageIcon iconocerrar = new ImageIcon(principal.class.getResource("/imagenes/cerrar.png"));
		Icon iconClose = new ImageIcon(iconocerrar.getImage().getScaledInstance(btnCerrar.getWidth(),btnCerrar.getHeight(),Image.SCALE_DEFAULT));
		btnCerrar.setIcon(iconClose);
		getContentPane().add(btnCerrar);
		 /*FIN DE BOTON DE CERRAR*/
		
		
	this.SetTable();
		
		JLabel lblUsuarios = new JLabel("Administradores");
		lblUsuarios.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setBounds(123, 0, 202, 34);
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
					cierraVentana(AdminPass);
					AdminPass = new FrmAdminCambiaPass(id); //detalle = new FrmEdicionUsuario();
					abreVentana(AdminPass);
					desapareceLogo();
				}
			}
		});
		btnEditar.setBounds(17, 409, 414, 50);
		getContentPane().add(btnEditar);
		
	}
	
	
	public void SetTable(){
		String col[] = {"Documento","Nombre"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);
		try{
			modelo = FCLogica.DevTablaAdmins();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		tblMUsuarios = new JTable(modelo);
		tblMUsuarios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		//tblMUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
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
                // this cell is the anchor and the table has the focus
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
