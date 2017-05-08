package InterfazGrafica;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Asignatura.Asignatura;
import Asignatura.Tema;
import Controladores.ControladorAgregarContenido;

/**
 * Clase para definir el panel de crear subtema
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelCrearSubtema extends JPanel{

	private static final long serialVersionUID = 1L;

	private PanelContenido contenedor;
	
	private JLabel nombretema;
	private JTextField camponombre;
	private JRadioButton visible;
	private JRadioButton novisible;
	private ButtonGroup visibilidad;
	private JButton crearSubtema;
	private JComboBox<String>lista;
	
	private Component rigidArea;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private Component rigidArea_4;
	private Component rigidArea_5;
	private Component rigidArea_6;
	
	/**
	 * Constructor de la clase PanelCrearSubtema
	 * @param cont Panel contenido
	 */
	public PanelCrearSubtema(PanelContenido cont){
		
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.contenedor = cont;

		this.lista = new JComboBox<String>(); 
		
		this.nombretema = new JLabel("Nombre del subtema:");
		this.camponombre = new JTextField(20);
		this.visible = new JRadioButton("Subtema visible");
		visible.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.novisible = new JRadioButton("Subtema no visible");
		novisible.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.visibilidad = new ButtonGroup();
		
		this.crearSubtema = new JButton("Crear subtema");
		
		// Anadimos las opciones a visibilidad
		visibilidad.add(visible);
		visibilidad.add(novisible);
		
		rigidArea = Box.createRigidArea(new Dimension(0, 50));
		add(rigidArea);
		
		// Anadimos los componentes al panel
		this.add(nombretema);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(0, 20));
		add(rigidArea_1);
		this.add(camponombre);
		
		rigidArea_2 = Box.createRigidArea(new Dimension(20, 0));
		add(rigidArea_2);
		this.add(novisible);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(0, 30));
		add(rigidArea_3);
		this.add(visible);

		rigidArea_4 = Box.createRigidArea(new Dimension(100, 30));
		add(rigidArea_4);
		this.add(crearSubtema);
		
		rigidArea_5 = Box.createRigidArea(new Dimension(0, 70));
		add(rigidArea_5);
		this.add(lista);
		
		rigidArea_6 = Box.createRigidArea(new Dimension(0, 50));
		add(rigidArea_6);
		
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
	 * Devuelve el nombre del subtema creado
	 * @return Nombre subtema
	 */
	public String getNombreSubtema(){
		return camponombre.getText();
	}
	
	/**
	 * Devuelve el tema
	 * @return tema deseado
	 */
	public String getNombreTema(){
		
		String valorSeleccionado = (String)lista.getSelectedItem();
		
		return valorSeleccionado;
		
	}
	
	/**
	 * Anade un controlador al boton
	 * @param c Controlador a anadir
	 */
	 public void setControlador(ActionListener c) {
		 crearSubtema.addActionListener(c);
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
	 
	 /**
	  * Actualiza la lista con las asignaturas existentes
	  */
	 public void actualizarTabla(){
		 
		 ArrayList<Asignatura> asigexistentes = new ArrayList<Asignatura>();
			
			asigexistentes = contenedor.getContenedorProf().getVentana().getSistema().getAsignaturas();
			
			lista.removeAllItems();
			
			for (Asignatura a : asigexistentes){
				
				for (Tema b : a.getTemas()){
					lista.addItem(b.getNombre());
				}
				
			}
		 
	 }
	
	
	
}
