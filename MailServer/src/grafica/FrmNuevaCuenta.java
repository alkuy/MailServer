package grafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrmNuevaCuenta extends JPanel {
	
	private JTextField txtCNnombre;
	private JTextField txtCNdocumento;
	private JButton btnCNingresar;
	private final ButtonGroup grpbtnSelectTipoCuenta = new ButtonGroup();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public FrmNuevaCuenta() {
		setBounds(20, 60, 450, 300);
		setLayout(null);
		
		JLabel lblNuevaCuenta = new JLabel("Nueva Cuenta");
		lblNuevaCuenta.setBounds(163, 5, 123, 26);
		lblNuevaCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCuenta.setFont(new Font("Goudy Old Style", Font.BOLD, 21));
		add(lblNuevaCuenta);
		
		JComboBox cboNCdominio = new JComboBox();
		cboNCdominio.setBounds(150, 207, 250, 30);
		add(cboNCdominio);
		
		JLabel lblCNNombreUsuario = new JLabel("Nombre Usuario");
		lblCNNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNNombreUsuario.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCNNombreUsuario.setBounds(10, 166, 136, 30);
		add(lblCNNombreUsuario);
		
		txtCNnombre = new JTextField();
		txtCNnombre.setColumns(10);
		txtCNnombre.setBounds(150, 166, 250, 30);
		add(txtCNnombre);
		
		JLabel lblCNdominio = new JLabel("Dominio");
		lblCNdominio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNdominio.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCNdominio.setBounds(46, 207, 100, 30);
		add(lblCNdominio);
		
		JLabel lblNombreApellidoO = new JLabel("Nombre Apellido o No existe");
		lblNombreApellidoO.setBounds(150, 105, 250, 30);
		add(lblNombreApellidoO);
		
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
		
		
		txtCNdocumento = new JTextField();
		txtCNdocumento.setBounds(150, 74, 250, 30);
		txtCNdocumento.setColumns(10);
		add(txtCNdocumento);
		txtCNdocumento.setEditable(false);
		
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
		
		
		btnCNingresar = new JButton("INGRESAR");
		btnCNingresar.setBounds(150, 248, 250, 30);
		add(btnCNingresar);
		
	}

}
