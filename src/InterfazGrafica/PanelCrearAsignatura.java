package InterfazGrafica;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controladores.ControladorCrearAsignatura;

/**
 * Clase para definir el panel de crear asignatura
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelCrearAsignatura extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private PanelContenido contenedor;
	
	private JLabel nombreasig;
	private JTextField camponombre;
	private JRadioButton visible;
	private JRadioButton novisible;
	private ButtonGroup visibilidad;
	
	private JButton crearAsig;
	
	/**
	 * Constructor de la clase PanelCrerAsignatura
	 */
	public PanelCrearAsignatura(PanelContenido cont){
		
		this.contenedor = cont;
		
		this.nombreasig = new JLabel("Nombre de la asignatura:");
		this.camponombre = new JTextField(20);
		this.visible = new JRadioButton("Asignatura visible");
		this.novisible = new JRadioButton("Asignatura no visible");
		
		this.visibilidad = new ButtonGroup();
		
		// Anadimos las opciones a visibilidad
		visibilidad.add(visible);
		visibilidad.add(novisible);
		
		// Anadimos los componentes al panel
		this.add(nombreasig);
		this.add(camponombre);
		this.add(visible);
		this.add(novisible);
		this.add(crearAsig);
		
		// Anade el controlador para el boton de inicio
		ControladorCrearAsignatura controlador = new ControladorCrearAsignatura(contenedor.getContenedorProf().getVentana(),this);
				
		// Configurar el panel con el controlador
		this.setControlador(controlador);

	}
	
	
	/**
	 * Devuelve el panel que contiene a crear asignatura
	 * @return contenedor
	 */
	public PanelContenido getContenedor(){
		return contenedor;
	}
	
	/**
	 * Devuelve el nombre de la asignatura creada
	 * @return Nombre asignatura
	 */
	public String getNombreAsig(){
		return camponombre.getText();
	}
	
	/**
	 * Anade un controlador al boton
	 * @param c Controlador a anadir
	 */
	 public void setControlador(ActionListener c) {
		 crearAsig.addActionListener(c);
	 }
	 
	 /**
	  * Comprueba la seleccion de opciones
	  * @return true si se selecciona visible, false en caso contrario
	  */
	 public boolean comprobarSeleccion(){
		 
		 if(visible.isSelected()){
			 return true;
		 }else
			 return false;
		 
	 }
	

}
