package grafica;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Logica.Fachada;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmNuevoDominio extends JInternalFrame {

	private JTextField txtADdominio;
	private static final long serialVersionUID = 1L;
	private Fachada FCLogica = Fachada.getInstancia(); 

	/**
	 * Create the frame.
	 */
	public FrmNuevoDominio() {
		setBounds(20, 60, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblADtitulo = new JLabel("Agregar Dominio");
		lblADtitulo.setBounds(150, 11, 150, 26);
		lblADtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblADtitulo.setFont(new Font("Goudy Old Style", Font.BOLD, 21));
		getContentPane().add(lblADtitulo);
		
		JLabel lblADdominio = new JLabel("Nombre");
		lblADdominio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblADdominio.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblADdominio.setBounds(75, 69, 65, 30);
		getContentPane().add(lblADdominio);
		
		txtADdominio = new JTextField();
		txtADdominio.setColumns(10);
		txtADdominio.setBounds(144, 69, 250, 30);
		getContentPane().add(txtADdominio);
		
		JButton btnADagregar = new JButton("Agregar");
		btnADagregar.setBounds(75, 210, 319, 30);
		getContentPane().add(btnADagregar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(144, 120, 99, 26);
		getContentPane().add(comboBox);
		comboBox.addItem("1"); comboBox.addItem("2"); comboBox.addItem("3");
		
		
		JLabel lblPrioridad = new JLabel("Prioridad");
		lblPrioridad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrioridad.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblPrioridad.setBounds(51, 116, 89, 30);
		getContentPane().add(lblPrioridad);
		
		JLabel lblAlta = new JLabel("1 - Alta"); lblAlta.setBounds(298, 120, 78, 26); getContentPane().add(lblAlta);
		JLabel lblMedia = new JLabel("2 - Media"); lblMedia.setBounds(298, 142, 78, 26); getContentPane().add(lblMedia);
		JLabel lblBaja = new JLabel("3 - Baja"); lblBaja.setBounds(298, 162, 78, 26); getContentPane().add(lblBaja);
		
		
		btnADagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dominio = txtADdominio.getText();
				String prioridad = comboBox.getSelectedItem().toString();
				int pri = Integer.parseInt(prioridad);
				FCLogica.altaDominio(dominio, pri);
			}
		});

	}
}
