package InterfazGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelEjercicio extends JPanel{
		
		
		private static final long serialVersionUID = 1L;

		PanelEjercicio(PanelContenido cont){
			
			JLabel texto = new JLabel("Estas dentro del ejercicio");
			this.add(texto);
		}

}