package grafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import Logica.Dominio;
import Logica.Fachada;



public class FrmNuevaCuenta extends JPanel {
	
	private JTextField txtCNnombre;
	private static JTextField txtCNdocumento;
	private JButton btnCNingresar;
	private final ButtonGroup grpbtnSelectTipoCuenta = new ButtonGroup();
	
	/*Instancio la fachada*/
	private Fachada FCLogica = Fachada.getInstancia();

	/*El campo de documento que en algun caso lo traigo de Nuevo Usuario*/
	public static JTextField getInstancia() {
		if(txtCNdocumento == null)
			txtCNdocumento = new JTextField();
		
		return txtCNdocumento;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public FrmNuevaCuenta() {
		/**
		 * Instancio clase de Verificaciones
		 */
		Verificaciones verifica = new Verificaciones();
		
		setBounds(20, 60, 450, 300);
		setLayout(null);
		
		JLabel lblNuevaCuenta = new JLabel("Nueva Cuenta");
		lblNuevaCuenta.setBounds(163, 5, 123, 26);
		lblNuevaCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCuenta.setFont(new Font("Goudy Old Style", Font.BOLD, 21));
		add(lblNuevaCuenta);
		
		/**
		 * ComboBox con dominios
		 */
		
		
		JComboBox cboNCdominio = new JComboBox();
		cboNCdominio.setBounds(150, 207, 250, 30);
		

		ArrayList<String> dominios = new ArrayList<String>();
		dominios = (ArrayList<String>) FCLogica.carga_dominios();
		for (int i = 0; i< dominios.size(); i++){
			cboNCdominio.addItem(dominios.get(i));
		}
		
		add(cboNCdominio);
		
		JLabel lblCNNombreUsuario = new JLabel("Nombre Usuario");
		lblCNNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNNombreUsuario.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCNNombreUsuario.setBounds(10, 166, 136, 30);
		add(lblCNNombreUsuario);
		
		JTextField txtCNnombre = new JTextField();
		txtCNnombre.setColumns(10);
		txtCNnombre.setBounds(150, 166, 250, 30);
		add(txtCNnombre);
		
		JLabel lblCNdominio = new JLabel("Dominio");
		lblCNdominio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNdominio.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCNdominio.setBounds(46, 207, 100, 30);
		add(lblCNdominio);
		
		JLabel lblNoExiste = new JLabel("El documento no existe, ingrese usuario nuevo");
		lblNoExiste.setBounds(150, 105, 250, 30);
		add(lblNoExiste);
		lblNoExiste.setVisible(false);
		
		JRadioButton rdbtnGrupoUOficina = new JRadioButton("Grupo u Oficina");
		grpbtnSelectTipoCuenta.add(rdbtnGrupoUOficina);
		rdbtnGrupoUOficina.setBounds(257, 48, 109, 23);
		add(rdbtnGrupoUOficina);
		
		JRadioButton rdbtnCNpersona = new JRadioButton("Persona");
		grpbtnSelectTipoCuenta.add(rdbtnCNpersona);
		rdbtnCNpersona.setBounds(160, 48, 89, 23);
		add(rdbtnCNpersona);
		
		
		JLabel lblCNdocumento = new JLabel("Documento");
		lblCNdocumento.setBounds(46, 72, 100, 30);
		lblCNdocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNdocumento.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		add(lblCNdocumento);
		
		JLabel lblCNtipo = new JLabel("Tipo de cuenta");
		lblCNtipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNtipo.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCNtipo.setBounds(10, 42, 136, 30);
		add(lblCNtipo);
		
		
		
		rdbtnGrupoUOficina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCNdocumento.setEditable(false);
			}
		});
		
		
		rdbtnCNpersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCNdocumento.setEditable(true);	
			}
		});
		
		JTextField txtCNdocumento = FrmNuevaCuenta.getInstancia();
		if(txtCNdocumento.getText().isEmpty()){
			rdbtnCNpersona.setSelected(true);
			//txtCNdocumento.setEditable(false);
		}
		txtCNdocumento.setBounds(150, 74, 250, 30);
		txtCNdocumento.setColumns(8);
		add(txtCNdocumento);
		
		
		
		btnCNingresar = new JButton("INGRESAR");
		btnCNingresar.addActionListener(new ActionListener() {
			/**
			 * Ingresa la nueva cuenta
			 * Concatena usuario con dominio
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				if (verifica.documento(txtCNdocumento) && verifica.campo_vacio(txtCNnombre)){
					String documento = txtCNdocumento.getText();
					
					String nom_usuario = txtCNnombre.getText();
					String dominio = cboNCdominio.getSelectedItem().toString();
					String cedula = txtCNdocumento.getText();
					
					boolean existe = FCLogica.VerificaCuenta(nom_usuario, dominio);
					if (existe){
						JOptionPane.showMessageDialog(new JPanel(), "La cuenta ya existe, debe elegir otro nombre");
					}else{
						FCLogica.altaCuentaPersonal(cedula, nom_usuario, dominio);
						limpiaCampos();
						setVisible(false);
					}
				
					
				}else{
					//System.out.println("Faltan campos");
				}
			}
		});
		btnCNingresar.setBounds(150, 248, 250, 30);
		add(btnCNingresar);
		
	
		
		
	}
	
	public void limpiaCampos(){
		txtCNnombre.setText(null);
		txtCNdocumento.setText(null);
		grpbtnSelectTipoCuenta.clearSelection();
	}

}
