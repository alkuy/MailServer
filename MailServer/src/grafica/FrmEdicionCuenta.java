package grafica;
import static grafica.principal.*;
import static grafica.FrmMuestraCuentas.*;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import Logica.Fachada;
import Logica.Usuario;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;

public class FrmEdicionCuenta extends JInternalFrame {

	private Fachada FCLogica = Fachada.getInstancia();
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	/**
	 * Create the frame.
	 */
	public FrmEdicionCuenta() {
		
		setBounds(550, 30, 300, 340);
		getContentPane().setLayout(null);
		toFront();
		
		try {
			if(FCLogica.esOficina(Integer.valueOf(id))){ //Me fijo si es una oficina
				
				JLabel lblCuenta = new JLabel("Cuenta");
				lblCuenta.setForeground(Color.RED);
				lblCuenta.setHorizontalAlignment(SwingConstants.CENTER);
				//lblCuenta.setText(FCLogica.nomOficina(Integer.valueOf(id)));
				lblCuenta.setText(nombrecuenta);
				lblCuenta.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
				lblCuenta.setBounds(10, 0, 263, 31);
				getContentPane().add(lblCuenta);
				
				String nomUsu = nombrecuenta.substring(0, nombrecuenta.indexOf("@"));
				String nomDom = nombrecuenta.substring(nombrecuenta.indexOf("@")+1);
			
				
				JCheckBox chckbxHabilitada = new JCheckBox("Deshabilitada");
				chckbxHabilitada.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
				chckbxHabilitada.setBounds(19, 138, 145, 31);
				getContentPane().add(chckbxHabilitada);
				
				if(!FCLogica.OfEstaHabilitada(Integer.valueOf(id))){
					chckbxHabilitada.setSelected(true);
				}
				
				JCheckBox chkResetPass = new JCheckBox("Resetear Contrase\u00F1a");
				chkResetPass.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
				chkResetPass.setBounds(19, 172, 211, 31);
				getContentPane().add(chkResetPass);
				
				
				JButton btnGuardar = new JButton("Guardar y Cerrar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {		
						if(chkResetPass.isSelected()){
							FCLogica.resetPassOfi(Integer.valueOf(id));
						}
						boolean habilitado = true;
						if(chckbxHabilitada.isSelected()){
							habilitado = false;
						}
						try {
							FCLogica.habilitaOficina(Integer.valueOf(id), habilitado);
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
							cierraVentana(frmmuestracuentas);
							frmmuestracuentas = new FrmMuestraCuentas();
							abreVentana(frmmuestracuentas);
						apareceLogo();
						dispose();
					}
				});
				btnGuardar.setBounds(19, 220, 246, 35);
				getContentPane().add(btnGuardar);
				
			}else{
				Usuario usu = FCLogica.findUsu(Integer.valueOf(id));
			
			JLabel lblDocumento = new JLabel("Documento");
			lblDocumento.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
			lblDocumento.setBounds(19, 42, 100, 31);
			getContentPane().add(lblDocumento);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
			lblNombre.setBounds(19, 71, 100, 31);
			getContentPane().add(lblNombre);
			
			JLabel lblApellido = new JLabel("Apellido");
			lblApellido.setFont(new Font("Goudy Old Style", Font.PLAIN, 17));
			lblApellido.setBounds(19, 100, 100, 31);
			getContentPane().add(lblApellido);
			
			JLabel lblCuenta = new JLabel("Cuenta");
			lblCuenta.setForeground(Color.RED);
			lblCuenta.setHorizontalAlignment(SwingConstants.CENTER);
			lblCuenta.setText(nombrecuenta);
			lblCuenta.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
			lblCuenta.setBounds(10, 0, 263, 31);
			getContentPane().add(lblCuenta);
			
			txtDocumento = new JTextField();
			txtDocumento.setEditable(false);
			txtDocumento.setBounds(128, 45, 145, 23);
			getContentPane().add(txtDocumento);
			txtDocumento.setColumns(10);
			txtDocumento.setText(usu.getCi());
			
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(129, 79, 145, 23);
			getContentPane().add(txtNombre);
			txtNombre.setText(usu.getNombre());
			
			txtApellido = new JTextField();
			txtApellido.setEditable(false);
			txtApellido.setColumns(10);
			txtApellido.setBounds(128, 108, 145, 23);
			getContentPane().add(txtApellido);
			txtApellido.setText(usu.getApellido());
			
			JCheckBox chckbxHabilitada = new JCheckBox("Deshabilitada");
			chckbxHabilitada.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
			chckbxHabilitada.setBounds(19, 138, 145, 31);
			getContentPane().add(chckbxHabilitada);
			
			JCheckBox chkResetPass = new JCheckBox("Resetear Contrase\u00F1a");
			chkResetPass.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
			chkResetPass.setBounds(19, 172, 211, 31);
			getContentPane().add(chkResetPass);
			
			String nomUsu = nombrecuenta.substring(0, nombrecuenta.indexOf("@"));
			String nomDom = nombrecuenta.substring(nombrecuenta.indexOf("@")+1);
			
			if(!FCLogica.desOhabCuenta(Integer.valueOf(id), nomUsu, nomDom)){
				chckbxHabilitada.setSelected(true);
			}
			
			JButton btnGuardar = new JButton("Guardar y Cerrar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {		
					if(chkResetPass.isSelected()){
						FCLogica.resetPassCuenta(Integer.valueOf(id), nomUsu, nomDom, usu.getCi()); //El ultimo es pass, pero el reseteo pone la cedula.
					}
					boolean habilitado = true;
					if(chckbxHabilitada.isSelected()){
						habilitado = false;
					}
					FCLogica.deshabCuenta(Integer.valueOf(id), nomUsu, nomDom, habilitado);	
						cierraVentana(frmmuestracuentas);
						frmmuestracuentas = new FrmMuestraCuentas();
						abreVentana(frmmuestracuentas);
					apareceLogo();
					dispose();
				}
			});
			btnGuardar.setBounds(19, 220, 246, 35);
			getContentPane().add(btnGuardar);
			
			
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Fin if
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apareceLogo();
				dispose();
			}
		});
		btnCerrar.setBounds(19, 262, 246, 35);
		getContentPane().add(btnCerrar);
	}
}
