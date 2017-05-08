package InterfazGrafica;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Controladores.ControladorCrearPregunta;
import Examen.Pregunta;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

/**
 * Clase para definir el panel de crear opcion
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelCrearOpcion extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private PanelContenido contenedor;
	private Pregunta pregunta;
	
	private PanelCrearPreguntaRedactar redactar;
	private PanelCrearPreguntaTest test;
	private PanelCrearPreguntaMultiple multiple;
	
	private JTextField enunciado;
	private JRadioButton escorrecta;
	private JButton crearopcion;
	private JButton volver;
	
	/**
	 * Constructor de la clase PanelCrearOpcion
	 * @param cont Panel contenido
	 * @param pan Panel pregunta redactar
	 * @wbp.parser.constructor
	 */
	public PanelCrearOpcion(PanelContenido cont, PanelCrearPreguntaRedactar pan){
		setBackground(UIManager.getColor("Checkbox.select"));
		this.contenedor = cont;
		this.pregunta = pan.getPregunta();
		this.redactar = pan;
		
		this.enunciado = new JTextField(40);
		this.escorrecta = new JRadioButton("Opcion correcta");
		escorrecta.setForeground(SystemColor.activeCaption);
		escorrecta.setBackground(UIManager.getColor("Checkbox.select"));
		escorrecta.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		this.crearopcion = new JButton("Crear opcion");
		this.volver = new JButton("Volver");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, escorrecta, 304, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, enunciado, 206, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, enunciado, -50, SpringLayout.NORTH, escorrecta);
		springLayout.putConstraint(SpringLayout.WEST, escorrecta, 359, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, volver, 0, SpringLayout.NORTH, crearopcion);
		springLayout.putConstraint(SpringLayout.WEST, volver, 167, SpringLayout.EAST, crearopcion);
		springLayout.putConstraint(SpringLayout.WEST, crearopcion, 228, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, crearopcion, -199, SpringLayout.SOUTH, this);
		setLayout(springLayout);
		
		this.add(enunciado);
		this.add(escorrecta);
		this.add(crearopcion);
		this.add(volver);
		
		// Anade el controlador para el boton de crear opcion
		ControladorCrearPregunta controlador = new ControladorCrearPregunta(contenedor.getContenedorProf().getVentana(), this);
		
		JLabel lblEnunciado = new JLabel("Enunciado :");
		springLayout.putConstraint(SpringLayout.WEST, lblEnunciado, 386, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEnunciado, -6, SpringLayout.NORTH, enunciado);
		lblEnunciado.setForeground(SystemColor.activeCaption);
		lblEnunciado.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		add(lblEnunciado);
		
		JLabel lblNuevaOpcion = new JLabel("Nueva Opcion");
		springLayout.putConstraint(SpringLayout.NORTH, lblNuevaOpcion, 77, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNuevaOpcion, 326, SpringLayout.WEST, this);
		lblNuevaOpcion.setForeground(SystemColor.activeCaption);
		lblNuevaOpcion.setFont(new Font("Nimbus Sans L", Font.BOLD, 31));
		add(lblNuevaOpcion);

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
		this.multiple = pan;
		
		this.enunciado = new JTextField(40);
		this.escorrecta = new JRadioButton("Opcion correcta");
		this.crearopcion = new JButton("Crear opcion");
		this.volver = new JButton("Volver");
		
		this.add(enunciado);
		this.add(escorrecta);
		this.add(crearopcion);
		this.add(volver);
		
		
		this.enunciado = new JTextField(40);
		this.escorrecta = new JRadioButton("Opcion correcta");
		escorrecta.setForeground(SystemColor.activeCaption);
		escorrecta.setBackground(UIManager.getColor("Checkbox.select"));
		escorrecta.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		this.crearopcion = new JButton("Crear opcion");
		this.volver = new JButton("Volver");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, escorrecta, 304, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, enunciado, 206, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, enunciado, -50, SpringLayout.NORTH, escorrecta);
		springLayout.putConstraint(SpringLayout.WEST, escorrecta, 359, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, volver, 0, SpringLayout.NORTH, crearopcion);
		springLayout.putConstraint(SpringLayout.WEST, volver, 167, SpringLayout.EAST, crearopcion);
		springLayout.putConstraint(SpringLayout.WEST, crearopcion, 228, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, crearopcion, -199, SpringLayout.SOUTH, this);
		setLayout(springLayout);
		
		this.add(enunciado);
		this.add(escorrecta);
		this.add(crearopcion);
		this.add(volver);
		
		// Anade el controlador para el boton de crear opcion
		ControladorCrearPregunta controlador = new ControladorCrearPregunta(contenedor.getContenedorProf().getVentana(), this);

		// Configurar el panel con el controlador
		this.setControlador(controlador);
		JLabel lblEnunciado = new JLabel("Enunciado :");
		springLayout.putConstraint(SpringLayout.WEST, lblEnunciado, 386, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEnunciado, -6, SpringLayout.NORTH, enunciado);
		lblEnunciado.setForeground(SystemColor.activeCaption);
		lblEnunciado.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		add(lblEnunciado);
		
		JLabel lblNuevaOpcion = new JLabel("Nueva Opcion");
		springLayout.putConstraint(SpringLayout.NORTH, lblNuevaOpcion, 77, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNuevaOpcion, 326, SpringLayout.WEST, this);
		lblNuevaOpcion.setForeground(SystemColor.activeCaption);
		lblNuevaOpcion.setFont(new Font("Nimbus Sans L", Font.BOLD, 31));
		add(lblNuevaOpcion);

		// Configurar el panel con el controlador
		this.setControlador(controlador);
		
		
	}
	
	/**
	 * Constructor de la clase PanelCrearOpcion
	 * @param cont Panel contenido
	 * @param pan Panel pregunta test
	 */
	public PanelCrearOpcion(PanelContenido cont, PanelCrearPreguntaTest pan){
		
		setBackground(UIManager.getColor("Checkbox.select"));
		this.contenedor = cont;
		this.pregunta = pan.getPregunta();
		this.test = pan;
		
		this.enunciado = new JTextField(40);
		this.escorrecta = new JRadioButton("Opcion correcta");
		escorrecta.setForeground(SystemColor.activeCaption);
		escorrecta.setBackground(UIManager.getColor("Checkbox.select"));
		escorrecta.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		this.crearopcion = new JButton("Crear opcion");
		this.volver = new JButton("Volver");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, escorrecta, 304, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, enunciado, 206, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, enunciado, -50, SpringLayout.NORTH, escorrecta);
		springLayout.putConstraint(SpringLayout.WEST, escorrecta, 359, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, volver, 0, SpringLayout.NORTH, crearopcion);
		springLayout.putConstraint(SpringLayout.WEST, volver, 167, SpringLayout.EAST, crearopcion);
		springLayout.putConstraint(SpringLayout.WEST, crearopcion, 228, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, crearopcion, -199, SpringLayout.SOUTH, this);
		setLayout(springLayout);
		
		this.add(enunciado);
		this.add(escorrecta);
		this.add(crearopcion);
		this.add(volver);
		
		// Anade el controlador para el boton de crear opcion
				ControladorCrearPregunta controlador = new ControladorCrearPregunta(contenedor.getContenedorProf().getVentana(), this);
		
		JLabel lblEnunciado = new JLabel("Enunciado :");
		springLayout.putConstraint(SpringLayout.WEST, lblEnunciado, 386, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEnunciado, -6, SpringLayout.NORTH, enunciado);
		lblEnunciado.setForeground(SystemColor.activeCaption);
		lblEnunciado.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		add(lblEnunciado);
		
		JLabel lblNuevaOpcion = new JLabel("Nueva Opcion");
		springLayout.putConstraint(SpringLayout.NORTH, lblNuevaOpcion, 77, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNuevaOpcion, 326, SpringLayout.WEST, this);
		lblNuevaOpcion.setForeground(SystemColor.activeCaption);
		lblNuevaOpcion.setFont(new Font("Nimbus Sans L", Font.BOLD, 31));
		add(lblNuevaOpcion);

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
	 
	 /**
	  * Devuelve el panel de pregunta redactar
	  * @return redactar
	  */
	 public PanelCrearPreguntaRedactar getRedactar(){
		 return redactar;
	 }
	 
	 /**
	  * Devuelve el panel de pregunta multiple
	  * @return multiple
	  */
	 public PanelCrearPreguntaMultiple getMultiple(){
		 return multiple;
	 }
	 
	 /**
	  * Devuelve el panel de pregunta test
	  * @return test
	  */
	 public PanelCrearPreguntaTest getTest(){
		 return test;
	 }
}
