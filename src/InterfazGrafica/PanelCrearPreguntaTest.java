package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Examen.Ejercicio;

/**
 * Clase para definir el panel de crear pregunta de tipo test
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelCrearPreguntaTest extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private PanelCrearEjercicio contenedor;
	private Ejercicio ejercicio;
	
	private JTextField enunciado;
	
	public PanelCrearPreguntaTest(PanelCrearEjercicio cont){
		
		this.contenedor = cont;
		this.ejercicio = null;
		
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
	
	/**
	 * Set del ejercicio asociado a la pregunta
	 * @param ej Ejercicio asociado
	 */
	public void setEjercicio(Ejercicio ej){
		
		ejercicio = ej;
		
	}
	
}