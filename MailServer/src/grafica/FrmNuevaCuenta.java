package grafica;
import static grafica.FrmNuevoUsuario.*; //Para traer los datos del formulario usuario

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Logica.Fachada;

public class FrmNuevaCuenta extends JInternalFrame {

	private JTextField txtCNnombre;
	private JTextField txtCNdocumento;
	private JButton btnCNingresar;
	private final ButtonGroup grpbtnSelectTipoCuenta = new ButtonGroup();
	private JRadioButton rdbtnGrupoUOficina;
	private JLabel lblCamposErrores;
	/*Instancio la fachada*/
	private Fachada FCLogica = Fachada.getInstancia();

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public FrmNuevaCuenta() {
		Verificaciones verifica = new Verificaciones();
		
		setBounds(20, 30, 450, 330);
		getContentPane().setLayout(null);
		
		JLabel lblNuevaCuenta = new JLabel("Nueva Cuenta");
		lblNuevaCuenta.setBounds(114, 0, 206, 26);
		lblNuevaCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaCuenta.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		getContentPane().add(lblNuevaCuenta);
		
		/*BOTON DE CERRAR*/
		JButton btnCerrar = new JButton("");
		 btnCerrar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		limpiaCampos();
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
		
		/**
		 * ComboBox con dominios
		 * 
		 */
		JComboBox cboNCdominio = new JComboBox();
		cboNCdominio.setBounds(150, 207, 250, 30);
		

		ArrayList<String> dominios = new ArrayList<String>();
		dominios = (ArrayList<String>) FCLogica.carga_dominios();
		for (int i = 0; i< dominios.size(); i++){
			cboNCdominio.addItem(dominios.get(i));
		}
		
		getContentPane().add(cboNCdominio);
		
		JLabel lblCNNombreUsuario = new JLabel("Nombre Usuario");
		lblCNNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNNombreUsuario.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCNNombreUsuario.setBounds(10, 166, 136, 30);
		getContentPane().add(lblCNNombreUsuario);
		
		txtCNnombre = new JTextField();
		txtCNnombre.setBounds(150, 166, 250, 30);
		getContentPane().add(txtCNnombre);
		
		JLabel lblCNdominio = new JLabel("Dominio");
		lblCNdominio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNdominio.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCNdominio.setBounds(46, 207, 100, 30);
		getContentPane().add(lblCNdominio);
		
		rdbtnGrupoUOficina = new JRadioButton("Grupo u Oficina");
		grpbtnSelectTipoCuenta.add(rdbtnGrupoUOficina);
		rdbtnGrupoUOficina.setBounds(257, 48, 109, 23);
		getContentPane().add(rdbtnGrupoUOficina);
		
		JRadioButton rdbtnCNpersona = new JRadioButton("Persona");
		grpbtnSelectTipoCuenta.add(rdbtnCNpersona);
		rdbtnCNpersona.setBounds(160, 48, 89, 23);
		getContentPane().add(rdbtnCNpersona);
		
		
		JLabel lblCNdocumento = new JLabel("Documento");
		lblCNdocumento.setBounds(46, 72, 100, 30);
		lblCNdocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNdocumento.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		getContentPane().add(lblCNdocumento);
		
		JLabel lblCNtipo = new JLabel("Tipo de cuenta");
		lblCNtipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNtipo.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCNtipo.setBounds(10, 42, 136, 30);
		getContentPane().add(lblCNtipo);
		
		
		txtCNdocumento = new JTextField();
		getContentPane().add(txtCNdocumento);
		txtCNdocumento.setBounds(150, 74, 250, 30);
		txtCNdocumento.setColumns(8);
		
		if (cuentazero == 1){
			txtCNdocumento.setText(documento);
			txtCNdocumento.setEnabled(false);
			rdbtnCNpersona.setSelected(true);
			rdbtnGrupoUOficina.setEnabled(false);
		}
		
		
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

		lblCamposErrores = new JLabel("* Hay campos con errores");
		lblCamposErrores.setBounds(138, 106, 307, 30);
		getContentPane().add(lblCamposErrores);
		lblCamposErrores.setVisible(false);
		
		
		btnCNingresar = new JButton("INGRESAR");
		btnCNingresar.addActionListener(new ActionListener() {
			/**
			 * Ingresa la nueva cuenta
			 * Concatena usuario con dominio
			 */
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * PAra Cuenta Personal
				 */
				if (rdbtnCNpersona.isSelected()){ 
					/*Verificaciones*/
					boolean continua = true;
					if (!verifica.cant_caracteres(txtCNnombre, 20, 1)){
						continua = false;
					}else{	
						if(!verifica.caracteres_validos(txtCNnombre)){continua = false;}
						}
					if (!verifica.cant_caracteres(txtCNdocumento, 8, 7)){ //Limito entre 7 y 8 la cantidad de caracteres
						continua = false;
						if(!verifica.numerico(txtCNdocumento)){continua = false;} // Verifico si es numerico tot el campo
						}
					if(cuentazero == 0){ // Si no vengo desde el formulario usuario, verifico que la cedula exista en la base
						// Si vengo desde el formulario usuario no realizo esta comprobacion, porque aun no esta en la base
						if(!verifica.existe_cedula(txtCNdocumento.getText())){
							continua = false;
						}
					}	
					/*Fin verificaciones*/
					if (continua == true){
						//Variables con datos a cargar
						if(cuentazero == 0){ // Si no vengo desde el formulario anterior
							documento = txtCNdocumento.getText();
							}
						String nom_usuario = txtCNnombre.getText();
						String dominio = cboNCdominio.getSelectedItem().toString();
						//Verificamos la existencia de la cuenta
						boolean existe = FCLogica.VerificaCuenta(nom_usuario, dominio);
							if (existe){
								JOptionPane.showMessageDialog(new JPanel(), "La cuenta ya existe, debe elegir otro nombre");
							}else{
								try {
									if(cuentazero == 1){ // Si el formulario viene desde la creacion del usuario
									FCLogica.altaUsu(documento, nombre, apellido, calle, nroPuerta, apto, numTel1, numTel2);
									cuentazero = 0;
									}// Si no, es que estoy cargando una cuenta de un usuario ya existente
									FCLogica.altaCuentaPersonal(documento, nom_usuario, dominio);//Damos de alta
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								seguirEditando();
							}
				
					}else{
						lblCamposErrores.setVisible(true);
					}
					
				}
				
				/**
				 * PAra cuenta Grupal
				 */
				if (rdbtnGrupoUOficina.isSelected()){// Si seleccionamos cuenta de grupo
					if(verifica.cant_caracteres(txtCNnombre, 20, 1)){
						String nom_usuario = txtCNnombre.getText();
						String dominio = cboNCdominio.getSelectedItem().toString();
						boolean existe = FCLogica.VerificaCuenta(nom_usuario, dominio);
						if (existe){
							JOptionPane.showMessageDialog(new JPanel(), "La cuenta ya existe, debe elegir otro nombre");
						}else{
							try {
								/**
								 * Efectivamente se realiza el alta
								 */
								int id=FCLogica.altaUsuGrupo(nom_usuario);
								FCLogica.altaCuentaGrupo(id, nom_usuario, dominio);
								seguirEditando();
								
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}	
					}else{
						lblCamposErrores.setVisible(true);
					}
				}
						
			}				
		});
		btnCNingresar.setBounds(150, 248, 250, 30);
		getContentPane().add(btnCNingresar);		
	}
	
	public void limpiaCampos(){
		
		txtCNdocumento.setText(null);
		txtCNnombre.setText(null);
		grpbtnSelectTipoCuenta.clearSelection();
		txtCNdocumento.setEnabled(true);
		rdbtnGrupoUOficina.setEnabled(true);
		lblCamposErrores.setVisible(false);
	}
	
	public void seguirEditando(){
		int response = JOptionPane.showConfirmDialog(null, "La cuenta se cargo, desea seguir ingresando?", "Cuenta nueva ingresada",
		        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    if (response == JOptionPane.NO_OPTION) {
		      dispose();
		    } else if (response == JOptionPane.YES_OPTION) {
		    	limpiaCampos();
		    } else if (response == JOptionPane.CLOSED_OPTION) {
		      System.out.println("JOptionPane closed");
		    }
	}
	


}
