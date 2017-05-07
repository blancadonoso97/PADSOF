package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Examen.Ejercicio;

/**
 * Clase para definir el panel de crear pregunta de tipo opcion multiple
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelCrearPreguntaMultiple extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private PanelCrearEjercicio contenedor;
	private Ejercicio ejercicio;
	
	private JTextField enunciado;
	
	public PanelCrearPreguntaMultiple(PanelCrearEjercicio cont, Ejercicio ej){
		
		this.contenedor = cont;
		this.ejercicio = ej;
		
		this.enunciado = new JTextField(40);
	}
	
	/**
	 * Obtiene el enunciado de la pregunta
	 * @return enunciado de la pregunta
	 */
	public String getEnunciado(){
		
		return enunciado.getText();
		
	}
	
	/**
	 * Obtiene el panel de crear ejercicio
	 * @return contenedor
	 */
	public PanelCrearEjercicio getPanelEjercicio(){
		
		return contenedor;
	}
	
	/**
	 * Obtiene el ejercicio asociado al panel
	 * @return ejercicio
	 */
	public Ejercicio getEjercicio(){
		return ejercicio;
	}
	
}
