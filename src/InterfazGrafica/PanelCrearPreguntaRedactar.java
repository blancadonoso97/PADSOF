package InterfazGrafica;

import javax.swing.JButton;
import javax.swing.JLabel;
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

	private PanelCrearEjercicio contenedor;
	private Ejercicio ejercicio;
	
	private JLabel nombre;
	private JTextField enunciado;
	private JButton opcion;
	
	public PanelCrearPreguntaRedactar(PanelCrearEjercicio cont){
		
		this.contenedor = cont;
		this.ejercicio = null;
		this.enunciado = new JTextField(40);
		this.opcion = new JButton("Crear opcion");
		this.nombre = new JLabel("Enunciado de la pregunta");
		
		this.add(nombre);
		this.add(enunciado);
		this.add(opcion);
		
		
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
