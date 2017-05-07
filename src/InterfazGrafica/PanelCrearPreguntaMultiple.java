package InterfazGrafica;

import javax.swing.JPanel;

import Examen.Ejercicio;

/**
 * Clase para definir el panel de crear pregunta de tipo opcion multiple
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelCrearPreguntaMultiple extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private PanelContenido contenedor;
	private Ejercicio ejercicio;
	
	public PanelCrearPreguntaMultiple(PanelContenido cont, Ejercicio ej){
		
		this.contenedor = cont;
		this.ejercicio = ej;
		
		
	}
	
	
	
}
