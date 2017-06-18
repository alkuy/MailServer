package grafica;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Verificaciones {
	public Verificaciones(){
		
	}
	/**
	 * Varifica documento ingresado
	 * @param campo
	 * @return
	 */
	public boolean documento(JComponent campo) {
        // suponemos que JComponent será un JTextField
			if (campo instanceof JTextField){
				String texto = ((JTextField)campo).getText();
				try
					{
                    // Si se puede convertir en entero, está bien
					Integer.parseInt(texto);
					if(texto.length() > 8 || texto.length() < 6){
						JOptionPane.showMessageDialog(campo, "Ingreso mal su documento");
						return false;
					}else{
						return true;
					}	
				}catch (Exception e)
					{
					JOptionPane.showMessageDialog(campo, "Ingreso mal su documento");
					return false;
					}
			}

			return true;

	}
	
	public boolean campo_vacio(JComponent campo){
		Border bordeROJO = BorderFactory.createLineBorder(Color.RED, 2);
		Border bordeCOMUN = BorderFactory.createLineBorder(Color.BLACK, 1);
		if (campo instanceof JTextField){
			String texto = ((JTextField)campo).getText();
			if(texto.isEmpty()){
				//JOptionPane.showMessageDialog(campo, "Debe ingresar datos");
				campo.setBorder(bordeROJO);
				return false;
			}else{
				campo.setBorder(bordeCOMUN);
				return true;
			}
		
		}
		return false;
	}
}
