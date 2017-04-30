package InterfazGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase para definir el panel de contenido dentro del panel de profesor o alumno
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelContenido extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel hola;
	
	/**
	 * Constructor de la clase PanelContenido
	 */
	public PanelContenido(){
		
		
		this.hola = new JLabel("Hola");
		this.add(hola);
		
		
	}

}
