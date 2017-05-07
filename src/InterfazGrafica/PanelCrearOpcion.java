package InterfazGrafica;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
	
	/**
	 * Constructor de la clase PanelCrearOpcion
	 * @param cont Panel contenido
	 * @param preg Pregunta a la que corresponde la opcion
	 */
	public PanelCrearOpcion(PanelContenido cont, Pregunta preg){
		
		this.contenedor = cont;
		this.pregunta = preg;
		
		this.enunciado = new JTextField(40);
		this.escorrecta = new JRadioButton("Opcion correcta");
		this.crearopcion = new JButton("Crear opcion");
		
		this.add(enunciado);
		this.add(escorrecta);
		this.add(crearopcion);
		
		// Anade el controlador para el boton de crear opcion
		//ControladorAgregarContenido controlador = new ControladorAgregarContenido(contenedor.getContenedorProf().getVentana(), this);

		// Configurar el panel con el controlador
		//this.setControlador(controlador);
		
		
	}
	
	/**
	 * Anade un controlador al boton
	 * @param c Controlador a anadir
	 */
	public void setControlador(ActionListener c) {
		crearopcion.addActionListener(c);
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
