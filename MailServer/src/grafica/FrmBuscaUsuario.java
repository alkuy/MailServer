package grafica;

import static grafica.principal.abreVentana;
import static grafica.FrmMuestraUsuarios.*;
import static grafica.principal.apareceLogo;
import static grafica.principal.cierraVentana;
import static grafica.principal.desapareceLogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Logica.Fachada;
import Logica.Usuario;
import grafica.FrmMuestraCuentas.CustomRenderer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;

public class FrmBuscaUsuario extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDocumento;
	private JLabel lblNombreApellido;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblTelefono2;
	private JButton btnEditar;
	private int id_usuario = 0;
		
	private String documento = null;
	private FrmEdicionUsuario detalle;
	
	private Fachada FCLogica = Fachada.getInstancia();
	private JTable table;


	/**
	 * Create the frame.
	 */
	public FrmBuscaUsuario() {
		
		setTitle("Busca Usuarios");
		setForeground(Color.LIGHT_GRAY);
		//setBorder(new EmptyBorder(0, 0, 0, 0));
		setBounds(20, 30, 450, 475);
		getContentPane().setLayout(null);
		
		/*BOTON DE CERRAR*/
		JButton btnCerrar = new JButton("");
		btnCerrar.setBounds(10, 0, 35, 35);
		 btnCerrar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		cierraVentana(detalle);
		 		apareceLogo();
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
		 
			JLabel lblBuscarUsuario = new JLabel("Buscar Usuario");
			lblBuscarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblBuscarUsuario.setBounds(120, 0, 193, 24);
			lblBuscarUsuario.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
			getContentPane().add(lblBuscarUsuario);
		 
		 /*Etiquetas titulos*/
		 JLabel lblN = new JLabel("Nombre");
		 lblN.setBounds(23, 102, 78, 30);
			lblN.setHorizontalAlignment(SwingConstants.RIGHT);
			lblN.setFont(new Font("Gloucester MT Extra Condensed", Font.PLAIN, 18));
			getContentPane().add(lblN);
			
			JLabel lblt1 = new JLabel("Tel\u00E9fono");
			lblt1.setBounds(23, 132, 78, 30);
			lblt1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblt1.setFont(new Font("Gloucester MT Extra Condensed", Font.PLAIN, 18));
			getContentPane().add(lblt1);
			
			JLabel lblt2 = new JLabel("Tel\u00E9fono");
			lblt2.setBounds(23, 160, 78, 30);
			lblt2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblt2.setFont(new Font("Gloucester MT Extra Condensed", Font.PLAIN, 18));
			getContentPane().add(lblt2);
			
			JLabel lbld = new JLabel("Direcci\u00F3n");
			lbld.setBounds(23, 191, 78, 30);
			lbld.setHorizontalAlignment(SwingConstants.RIGHT);
			lbld.setFont(new Font("Gloucester MT Extra Condensed", Font.PLAIN, 18));
			getContentPane().add(lbld);
		/*Fin de etiquetas titulos*/	
		
			
		
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(123, 61, 210, 30);
		getContentPane().add(txtDocumento);
		txtDocumento.setColumns(10);
		
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(23, 63, 90, 22);
		lblDocumento.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
		getContentPane().add(lblDocumento);
		
		lblNombreApellido = new JLabel("Datos basicos");
		lblNombreApellido.setBounds(123, 102, 210, 30);
		lblNombreApellido.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		getContentPane().add(lblNombreApellido);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(123, 191, 210, 30);
		lblDireccion.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		getContentPane().add(lblDireccion);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(123, 132, 210, 30);
		lblTelefono.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		getContentPane().add(lblTelefono);
		
		lblTelefono2 = new JLabel("Telefono2");
		lblTelefono2.setBounds(123, 160, 210, 30);
		lblTelefono2.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		getContentPane().add(lblTelefono2);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(123, 382, 210, 40);
		getContentPane().add(btnEditar);
		
		MostrarEtiquetas(false);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBounds(348, 61, 30, 30);
		btnBuscar.setIcon(new ImageIcon(FrmBuscaUsuario.class.getResource("/imagenes/lupa.jpg")));
		getContentPane().add(btnBuscar);
		
	
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				documento = txtDocumento.getText();
				id_usuario = FCLogica.getID(documento);
				if (id_usuario !=0){
					Usuario usu = FCLogica.findUsu(id_usuario);
					lblNombreApellido.setText(usu.getNombre()+" "+usu.getApellido());
					lblDireccion.setText(usu.getCalle()+" "+usu.getNro_puerta()+" "+usu.getApto());
					lblTelefono.setText(FCLogica.retornarTelx(FCLogica.getID(txtDocumento.getText()), 0));
					lblTelefono2.setText(FCLogica.retornarTelx(FCLogica.getID(txtDocumento.getText()), 1));
					
					SetTable(id_usuario);
					
					MostrarEtiquetas(true);
				}else{
					JOptionPane.showMessageDialog(null, "El usuario no existe" , null, JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cierraVentana(detalle);
				desdemuestra = 0;
				detalle = new FrmEdicionUsuario(documento); //detalle = new FrmEdicionUsuario();
				abreVentana(detalle);
				desapareceLogo();
			}
		});
		
		
	}
	
	public void SetTable(int idUsuario){
		String col[] = {"Cuenta","Habilitada"};
		DefaultTableModel modelo = new DefaultTableModel(col,0);
		try{
			modelo = FCLogica.DevCuentasUsuario(idUsuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table = new JTable(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrlContTabla = new JScrollPane(table);
		scrlContTabla.setEnabled(false);
		scrlContTabla.setBounds(39, 263, 355, 88);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrlContTabla, BorderLayout.CENTER);
		
		
		/*Ocukto la columna que tiene el valor de Usuario eliminado*/
		TableColumn myTableColumn1 = table.getColumnModel().getColumn(1);
		table.getColumnModel().removeColumn(myTableColumn1);
		
		
		table.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());

		//tblMuestraCuentas.getColumnModel().getColumn(0).setWidth(250);
		
	}
	
	class CustomRenderer extends DefaultTableCellRenderer 
	{
	private static final long serialVersionUID = 6703872492730589499L;

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	    {
	        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

	        String estado = (String)table.getModel().getValueAt(row, 1);
	        if ("false".equals(estado)){
	        	setBackground(Color.GRAY);
	        }else{
	        	setBackground(Color.WHITE);
	        }
	     
	        return cellComponent;
	    }
	}

	
	
	public void MostrarEtiquetas(boolean m){
		lblNombreApellido.setVisible(m);
		lblDireccion.setVisible(m);
		lblTelefono.setVisible(m);
		lblTelefono2.setVisible(m);
		btnEditar.setEnabled(m);
	}
}
