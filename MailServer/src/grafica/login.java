package grafica;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel ImgUserLog = null;
	private JLabel ImgKeyLog = null;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/imagenes/ico-mail.png")));
		setBackground(new Color(0, 0, 153));
		setTitle("Administrador - Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 500, 200);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("RadioButton.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		ImgUserLog = new JLabel(new ImageIcon(login.class.getResource("/imagenes/userLog.png")));
		ImgUserLog.setBounds(46, 42, 30, 30);
		contentPane.add(ImgUserLog);
		
		ImgKeyLog = new JLabel(new ImageIcon(login.class.getResource("/imagenes/keyLog.png")));
		ImgKeyLog.setBounds(46, 94, 30, 30);
		contentPane.add(ImgKeyLog);
		
		textField = new JTextField();
		textField.setBounds(86, 42, 250, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(86, 94, 250, 30);
		contentPane.add(passwordField);
		
		principal vent_principal  = new principal();
		JButton btnIngresar = new JButton("New button");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vent_principal.setVisible(true);
				dispose();
			}
		});
		btnIngresar.setIcon(new ImageIcon(login.class.getResource("/imagenes/enter.png")));
		btnIngresar.setBounds(365, 34, 100, 100);
		btnIngresar.setOpaque(false);
		btnIngresar.setContentAreaFilled(false);
		btnIngresar.setBorderPainted(false);
		contentPane.add(btnIngresar);
		
	}
}
