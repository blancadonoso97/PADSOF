package InterfazGrafica;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controladores.ControladorCrearPregunta;
import Examen.Ejercicio;
import Examen.Pregunta;

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
	private JLabel sumalab;
	private JLabel restalab;
	private JTextField enunciado;
	private JTextField suma;
	private JTextField resta;
	private JButton opcion;
	private JButton crear;
	private JButton volver;
	
	private Pregunta preguntacreada;
	
	/**
	 * Constructor de la clase PanelCrearPreguntaRedactar
	 * @param cont PanelCrearEjercicio
	 */
	public PanelCrearPreguntaRedactar(PanelCrearEjercicio cont){
		
		this.contenedor = cont;
		this.ejercicio = null;
		this.enunciado = new JTextField(40);
		this.suma = new JTextField(2);
		this.resta = new JTextField(2);
		this.opcion = new JButton("Crear nueva opcion");
		this.nombre = new JLabel("Enunciado de la pregunta");
		this.sumalab = new JLabel("La pregunta correcta suma x puntos:");
		this.restalab = new JLabel("La pregunta incorrecta resta x puntos:");
		this.crear = new JButton("Crear pregunta redactar");
		this.volver = new JButton("Volver");
		
		this.add(nombre);
		this.add(enunciado);
		this.add(sumalab);
		this.add(suma);
		this.add(restalab);
		this.add(resta);
		this.add(opcion);
		this.add(crear);
		this.add(volver);
		
		ControladorCrearPregunta controlador = new ControladorCrearPregunta(contenedor.getContenido().getContenedorProf().getVentana(), this);
		
		this.setControlador(controlador);
		
	}
	
	/**
	 * Anade un controlador al boton crear/volver
	 * @param c Controlador a anadir
	 */
	public void setControlador(ActionListener c) {
		crear.addActionListener(c);
		volver.addActionListener(c);
		opcion.addActionListener(c);
	}
	
	/**
	 * Obtiene el enunciado de la pregunta
	 * @return enunciado de la pregunta
	 */
	public String getEnunciado(){
		
		return enunciado.getText();
		
	}
	
	/**
	 * Devuelve el valor que suma cada pregunta correcta al ejercicio
	 * @return suma
	 */
	public int getSuma(){
		
		return Integer.parseInt(suma.getText());
		
	}
	
	/**
	 * Devuelve el valor que resta cada pregunta incorrecta al ejercicio
	 * @return resta
	 */
	public int getResta(){
		return Integer.parseInt(resta.getText());
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
	
	/**
	 * Obtiene la pregunta creada
	 * @return preguntacreada
	 */
	public Pregunta getPregunta(){
		
		return preguntacreada;
	}
	
	/**
	 * Set de la pregunta creada
	 * @param preg Pregunta creada
	 */
	public void setPregunta(Pregunta preg){
		preguntacreada = preg;
	}
	
}
