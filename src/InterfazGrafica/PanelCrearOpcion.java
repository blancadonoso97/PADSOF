package InterfazGrafica;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controladores.ControladorCrearPregunta;
import Examen.Pregunta;

/**
 * Clase para definir el panel de crear opcion
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelCrearOpcion extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private PanelContenido contenedor;
	private Pregunta pregunta;
	
	private JTextField enunciado;
	private JRadioButton escorrecta;
	private JButton crearopcion;
	private JButton volver;
	
	/**
	 * Constructor de la clase PanelCrearOpcion
	 * @param cont Panel contenido
	 * @param pan Panel pregunta redactar
	 */
	public PanelCrearOpcion(PanelContenido cont, PanelCrearPreguntaRedactar pan){
		
		this.contenedor = cont;
		this.pregunta = pan.getPregunta();
		
		this.enunciado = new JTextField(40);
		this.escorrecta = new JRadioButton("Opcion correcta");
		this.crearopcion = new JButton("Crear opcion");
		this.volver = new JButton("Volver");
		
		this.add(enunciado);
		this.add(escorrecta);
		this.add(crearopcion);
		this.add(volver);
		
		// Anade el controlador para el boton de crear opcion
		ControladorCrearPregunta controlador = new ControladorCrearPregunta(contenedor.getContenedorProf().getVentana(), this);

		// Configurar el panel con el controlador
		this.setControlador(controlador);
		
		
	}
	
	/**
	 * Constructor de la clase PanelCrearOpcion
	 * @param cont Panel contenido
	 * @param pan Panel pregunta multiple
	 */
	public PanelCrearOpcion(PanelContenido cont, PanelCrearPreguntaMultiple pan){
		
		this.contenedor = cont;
		this.pregunta = pan.getPregunta();
		
		this.enunciado = new JTextField(40);
		this.escorrecta = new JRadioButton("Opcion correcta");
		this.crearopcion = new JButton("Crear opcion");
		this.volver = new JButton("Volver");
		
		this.add(enunciado);
		this.add(escorrecta);
		this.add(crearopcion);
		this.add(volver);
		
		// Anade el controlador para el boton de crear opcion
		ControladorCrearPregunta controlador = new ControladorCrearPregunta(contenedor.getContenedorProf().getVentana(), this);

		// Configurar el panel con el controlador
		this.setControlador(controlador);
		
		
	}
	
	/**
	 * Constructor de la clase PanelCrearOpcion
	 * @param cont Panel contenido
	 * @param pan Panel pregunta test
	 */
	public PanelCrearOpcion(PanelContenido cont, PanelCrearPreguntaTest pan){
		
		this.contenedor = cont;
		this.pregunta = pan.getPregunta();
		
		this.enunciado = new JTextField(40);
		this.escorrecta = new JRadioButton("Opcion correcta");
		this.crearopcion = new JButton("Crear opcion");
		this.volver = new JButton("Volver");
		
		this.add(enunciado);
		this.add(escorrecta);
		this.add(crearopcion);
		this.add(volver);
		
		// Anade el controlador para el boton de crear opcion
		ControladorCrearPregunta controlador = new ControladorCrearPregunta(contenedor.getContenedorProf().getVentana(), this);

		// Configurar el panel con el controlador
		this.setControlador(controlador);
		
		
	}
	
	/**
	 * Anade un controlador al boton crear y volver
	 * @param c Controlador a anadir
	 */
	public void setControlador(ActionListener c) {
		crearopcion.addActionListener(c);
		volver.addActionListener(c);
	}
	
	/**
	 * Devuelve el enunciado de la opcion
	 * @return enunciado de la opcion
	 */
	public String getEnunciado(){
		return enunciado.getText();
	}
	
	/**
	 * Devuelve la pregunta que contiene a la opcion
	 * @return pregunta
	 */
	public Pregunta getPregunta(){
		
		return pregunta;
	}
	
	/**
	 * Set de la pregunta
	 * @param preg Pregunta
	 */
	public void setPregunta(Pregunta preg){
		
		pregunta = preg;
		
	}
	
	/**
	 * Devuelve el panel de contenido
	 * @return contenedor
	 */
	public PanelContenido getContenido(){
		return contenedor;
	}
	
	/**
	  * Comprueba la seleccion de escorrecta
	  * @return true si se selecciona escorrecta, false en caso contrario
	  */
	 public boolean comprobarSeleccion(){
		 
		 if(escorrecta.isSelected()){
			 return true;
		 }else
			 return false;
		 
	 }

}
