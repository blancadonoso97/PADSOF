package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Examen.Ejercicio;

/**
 * Clase para definir el panel de crear pregunta de tipo redactar
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelCrearPreguntaRedactar extends JPanel{

	private static final long serialVersionUID = 1L;

	private PanelContenido contenedor;
	private Ejercicio ejercicio;
	
	private JTextField enunciado;
	
	public PanelCrearPreguntaRedactar(PanelContenido cont, Ejercicio ej){
		
		this.contenedor = cont;
		this.ejercicio = ej;
		
		this.enunciado = new JTextField(40);
		
		
	}
	
}
