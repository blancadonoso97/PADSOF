package InterfazGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que implementa el panel para editar un ejercicio
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelEditarEjercicio extends JPanel{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor que implementa la interfaz grafica del panel para editar un ejercicio
	 * @param cont panel del contenido
	 */
	public PanelEditarEjercicio(PanelContenido cont){
		
		JLabel texto = new JLabel("Estas dentro de editar ejercicio");
		this.add(texto);
	
	}
	
	
	public void actualizaEj(){
		
	}
}
