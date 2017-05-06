package InterfazGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelApunte extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PanelApunte(PanelContenido cont){
		
		JLabel texto = new JLabel("Estas dentro de los apuntes");
		this.add(texto);
	}
}
