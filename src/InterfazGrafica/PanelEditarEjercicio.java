package InterfazGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEditarEjercicio extends JPanel{

	private static final long serialVersionUID = 1L;
	
	PanelEditarEjercicio(PanelContenido cont){
		JLabel texto = new JLabel("Estas dentro de editar ejercicio");
		this.add(texto);
	}
	
	
	public void actualizaEj(){
		
	}
}
