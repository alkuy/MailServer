package grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Conectividad.FachadaCon;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Component;

public class FrmPruebaServidor extends JInternalFrame {
	private FachadaCon FCCon = FachadaCon.getInstancia();
	
	
	/**
	 * Create the frame.
	 */
	public FrmPruebaServidor() {
		FCCon.InciaServ();
		
		setBounds(20, 60, 450, 360);
		getContentPane().setLayout(null);
		
		JLabel lblDominios = new JLabel("Prueba del Servidor");
		lblDominios.setHorizontalAlignment(SwingConstants.CENTER);
		lblDominios.setFont(new Font("Goudy Old Style", Font.BOLD, 24));
		lblDominios.setBounds(22, 13, 190, 40);
		getContentPane().add(lblDominios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(22, 66, 270, 245);
		getContentPane().add(scrollPane);
		
		JTextArea MensajeServ = new JTextArea();
		scrollPane.setViewportView(MensajeServ);
		MensajeServ.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		MensajeServ.setBorder(null);
		MensajeServ.setEditable(false);
		
		MessageConsole mc = new MessageConsole(MensajeServ);
		mc.redirectOut();
		mc.redirectErr(Color.RED, null);

		
		JButton btnInciarServidor = new JButton("Inciar Servicio");
		btnInciarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FCCon.ComenzarServ();
				//MensajeServ.append();
			}
		});
		btnInciarServidor.setBounds(295, 81, 127, 25);
		getContentPane().add(btnInciarServidor);
		
		JButton btnNewButton = new JButton("Enviar Mail");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FCCon.InciaCli();
				try {
					this.finalize();
				} catch (Throwable e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(295, 132, 127, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Detener Servicio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FCCon.DetenerServ();
			}
		});
		btnNewButton_1.setBounds(295, 178, 127, 25);
		getContentPane().add(btnNewButton_1);
		

		

		
		

	}
}
