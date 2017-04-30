package InterfazGrafica;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Clase para definir el panel cuando se inicia sesion como Profesor
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelProfesor extends JPanel{

	private static final long serialVersionUID = 1L;
		
	private JPanel barraHerramientas;
	private JPanel contenido;
	
	/**
	 * Constructor de la clase PanelProfesor
	 */
	public PanelProfesor(){
		
		BorderLayout layout = new BorderLayout();

		this.setLayout(layout);
		
		this.barraHerramientas = new PanelBarraHerramientas();
		
		this.contenido = new PanelContenido();
		
		
		
	}	
	

}
