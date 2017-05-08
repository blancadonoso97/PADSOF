package InterfazGrafica;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Controladores.ControladorCrearPregunta;
import Examen.Ejercicio;
import Examen.Pregunta;
import javax.swing.SpringLayout;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.SystemColor;

/**
 * Clase para definir el panel de crear pregunta de tipo opcion multiple
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelCrearPreguntaMultiple extends JPanel{

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
	 * Constructor de la clase PanelCrearPreguntaMultiple
	 * @param cont Panel crear ejercicio
	 */
	public PanelCrearPreguntaMultiple(PanelCrearEjercicio cont){
		setBackground(UIManager.getColor("Checkbox.select"));
		this.contenedor = cont;
		this.ejercicio = null;
		
		this.enunciado = new JTextField(40);
		this.suma = new JTextField(2);
		this.resta = new JTextField(2);
		this.opcion = new JButton("Crear nueva opcion");
		this.nombre = new JLabel("Enunciado de la pregunta");
		nombre.setForeground(SystemColor.activeCaption);
		nombre.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		this.sumalab = new JLabel("La pregunta correcta suma x puntos:");
		sumalab.setForeground(SystemColor.activeCaption);
		sumalab.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		this.restalab = new JLabel("La pregunta incorrecta resta x puntos:");
		restalab.setForeground(SystemColor.activeCaption);
		restalab.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		this.volver = new JButton("Volver");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, nombre, -26, SpringLayout.NORTH, enunciado);
		springLayout.putConstraint(SpringLayout.NORTH, resta, -2, SpringLayout.NORTH, sumalab);
		springLayout.putConstraint(SpringLayout.WEST, resta, 31, SpringLayout.EAST, restalab);
		springLayout.putConstraint(SpringLayout.WEST, volver, 485, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, opcion, -125, SpringLayout.WEST, volver);
		springLayout.putConstraint(SpringLayout.NORTH, restalab, 0, SpringLayout.NORTH, sumalab);
		springLayout.putConstraint(SpringLayout.WEST, restalab, 103, SpringLayout.EAST, suma);
		springLayout.putConstraint(SpringLayout.NORTH, suma, -2, SpringLayout.NORTH, sumalab);
		springLayout.putConstraint(SpringLayout.WEST, suma, 29, SpringLayout.EAST, sumalab);
		springLayout.putConstraint(SpringLayout.NORTH, sumalab, 97, SpringLayout.SOUTH, enunciado);
		springLayout.putConstraint(SpringLayout.WEST, sumalab, 47, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, enunciado, 215, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, volver, 0, SpringLayout.NORTH, opcion);
		setLayout(springLayout);
		
		this.add(nombre);
		this.add(enunciado);
		this.add(sumalab);
		this.add(suma);
		this.add(restalab);
		this.crear = new JButton("Crear pregunta multiple");
		springLayout.putConstraint(SpringLayout.EAST, nombre, 0, SpringLayout.EAST, crear);
		springLayout.putConstraint(SpringLayout.SOUTH, enunciado, -142, SpringLayout.NORTH, crear);
		springLayout.putConstraint(SpringLayout.NORTH, opcion, 55, SpringLayout.SOUTH, crear);
		springLayout.putConstraint(SpringLayout.WEST, crear, 319, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, crear, -243, SpringLayout.SOUTH, this);
		this.add(crear);
		this.add(resta);
		this.add(opcion);
		this.add(volver);
		
		ControladorCrearPregunta controlador = new ControladorCrearPregunta(contenedor.getContenido().getContenedorProf().getVentana(), this);
		
		JLabel lblNuevaPreguntaMultiple = DefaultComponentFactory.getInstance().createTitle("Nueva Pregunta Multiple");
		springLayout.putConstraint(SpringLayout.NORTH, lblNuevaPreguntaMultiple, 56, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNuevaPreguntaMultiple, 272, SpringLayout.WEST, this);
		lblNuevaPreguntaMultiple.setForeground(SystemColor.activeCaption);
		lblNuevaPreguntaMultiple.setFont(new Font("Nimbus Sans L", Font.BOLD, 31));
		add(lblNuevaPreguntaMultiple);
		
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
