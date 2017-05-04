package InterfazGrafica;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controladores.ControladorAgregarContenido;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

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
	private Component rigidArea;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private Component rigidArea_4;
	
	/**
	 * Constructor de la clase PanelCrerAsignatura
	 */
	public PanelCrearAsignatura(PanelContenido cont){
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.contenedor = cont;
		
		this.nombreasig = new JLabel("Nombre de la asignatura:");
		this.camponombre = new JTextField(20);
		this.visible = new JRadioButton("Asignatura visible");
		visible.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		this.novisible = new JRadioButton("Asignatura no visible");
		novisible.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.visibilidad = new ButtonGroup();
		
		this.crearAsig = new JButton("Crear asignatura");
		
		// Anadimos las opciones a visibilidad
		visibilidad.add(visible);
		visibilidad.add(novisible);
		
		rigidArea = Box.createRigidArea(new Dimension(0, 50));
		add(rigidArea);
		
		// Anadimos los componentes al panel
		this.add(nombreasig);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(0, 20));
		add(rigidArea_1);
		this.add(camponombre);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(0, 70));
		add(rigidArea_3);
		this.add(visible);
		
		rigidArea_2 = Box.createRigidArea(new Dimension(20, 0));
		add(rigidArea_2);
		this.add(novisible);
		
		rigidArea_4 = Box.createRigidArea(new Dimension(0, 30));
		add(rigidArea_4);
		this.add(crearAsig);
		
		// Anade el controlador para el boton de crear asignatura
		ControladorAgregarContenido controlador = new ControladorAgregarContenido(contenedor.getContenedorProf().getVentana(),this);
				
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
