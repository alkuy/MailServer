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

import com.icegreen.greenmail.user.UserException;

import Conectividad.FachadaCon;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.mail.MessagingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JToggleButton;

public class FrmPruebaServidor extends JInternalFrame {
	private FachadaCon FCCon = FachadaCon.getInstancia();
	private static boolean smtp = false;
	private static boolean pop = false;
	
	
	/**
	 * Create the frame.
	 */
	public FrmPruebaServidor() {
		//FCCon.InciaServ();
		
		setBounds(20, 60, 519, 360);
		getContentPane().setLayout(null);
		
		JLabel lblDominios = new JLabel("Log de Eventos");
		lblDominios.setHorizontalAlignment(SwingConstants.CENTER);
		lblDominios.setFont(new Font("Goudy Old Style", Font.BOLD, 24));
		lblDominios.setBounds(53, 13, 190, 40);
		getContentPane().add(lblDominios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(22, 66, 305, 245);
		getContentPane().add(scrollPane);
		
		JTextArea MensajeServ = new JTextArea();
		scrollPane.setViewportView(MensajeServ);
		MensajeServ.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		MensajeServ.setBorder(null);
		MensajeServ.setEditable(false);
		
		MessageConsole mc = new MessageConsole(MensajeServ);
		mc.redirectOut();
		
		JToggleButton SMTP = new JToggleButton("Servicio SMTP");
		SMTP.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (SMTP.isSelected()){
					try {
						FCCon.InciaServ();
						System.out.println("Servicio STMP Iniciado");
						smtp = true;
					} catch (SQLException | MessagingException | UserException e1) {
						// TODO Bloque catch generado automáticamente
						e1.printStackTrace();
					}
				}else{
					try {
						FCCon.DetenerServ();
						System.out.println("Servicio STMP Detenido");
						smtp = false;
					} catch (SQLException e1) {
						// TODO Bloque catch generado automáticamente
						e1.printStackTrace();
					}
				}
				
			}
		});
		SMTP.setBounds(339, 89, 145, 25);
		getContentPane().add(SMTP);
		
		JToggleButton POP3 = new JToggleButton("Servicio POP3");
		POP3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (POP3.isSelected()){
					try {
						FCCon.IniPOPServ();
						System.out.println("Servicio POP3 Iniciado");
						pop = true;
					} catch (SQLException e1) {
						// TODO Bloque catch generado automáticamente
						e1.printStackTrace();
					}
				}else{
					try {
						FCCon.DetPOPServ();
						System.out.println("Servicio POP3 Detenido");
						pop = false;
					} catch (SQLException e1) {
						// TODO Bloque catch generado automáticamente
						e1.printStackTrace();
					}
				}
				
			}
		});
		POP3.setBounds(339, 136, 145, 25);
		getContentPane().add(POP3);
		

		if(smtp){
			SMTP.setSelected(true);
		}
		if(pop){
			POP3.setSelected(true);
		}

		
		

	}
}
