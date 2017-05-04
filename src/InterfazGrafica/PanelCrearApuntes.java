package InterfazGrafica;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Asignatura.Asignatura;
import Asignatura.Tema;
import Controladores.ControladorAgregarContenido;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

/**
 * Clase para definir el panel de crear Apuntes
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelCrearApuntes extends JPanel{

	private static final long serialVersionUID = 1L;
	
private PanelContenido contenedor;
	
	private JLabel nombreapuntes;
	private JTextField camponombre;
	private JRadioButton visible;
	private JRadioButton novisible;
	private ButtonGroup visibilidad;
	
	private JButton crearApuntes;
	
	private JList<String> lista;
	private Component rigidArea;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private Component rigidArea_4;
	private Component rigidArea_5;
	
	public PanelCrearApuntes(PanelContenido cont){
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.contenedor = cont;
		
		DefaultListModel<String> temas = new DefaultListModel<String>();
		
		ArrayList<Asignatura> asigexistentes = new ArrayList<Asignatura>();
		
		asigexistentes = cont.getContenedorProf().getVentana().getSistema().getAsignaturas();
		
		// Anadimos las asignaturas existentes a la lista de asignaturas donde se puede crear un tema
		for (Asignatura a : asigexistentes){
			
			for (Tema b : a.getTemas()){
				temas.addElement(b.getNombre());
			}
			
		}
		
		this.lista = new JList<String>(temas);
		lista.setValueIsAdjusting(true);
		
		this.nombreapuntes = new JLabel("Nombre de los apuntes:");
		this.camponombre = new JTextField(30);
		this.visible = new JRadioButton("Apuntes visibles");
		visible.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		this.novisible = new JRadioButton("Apuntes no visibles");
		novisible.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.visibilidad = new ButtonGroup();
		
		this.crearApuntes = new JButton("Crear Apuntes");
		crearApuntes.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		// Anadimos las opciones a visibilidad
		visibilidad.add(visible);
		visibilidad.add(novisible);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(120, 200));
		add(rigidArea_3);
		
		// Anadimos los componentes al panel
		this.add(nombreapuntes);
		
		rigidArea = Box.createRigidArea(new Dimension(0, 20));
		add(rigidArea);
		this.add(camponombre);
		
		rigidArea_2 = Box.createRigidArea(new Dimension(300, 40));
		add(rigidArea_2);
		this.add(visible);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(20, 0));
		add(rigidArea_1);
		this.add(novisible);
		
		rigidArea_4 = Box.createRigidArea(new Dimension(1000, 30));
		add(rigidArea_4);
		this.add(crearApuntes);
		
		rigidArea_5 = Box.createRigidArea(new Dimension(0, 50));
		add(rigidArea_5);
		this.add(lista);
		
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
	 * Devuelve el nombre del tema creado
	 * @return Nombre tema
	 */
	public String getNombreApuntes(){
		return camponombre.getText();
	}
	
	
	
	/**
	 * Devuelve la asignatura
	 * @return Asignatura deseada
	 */
	public Asignatura getNombreAsignatura(){
		
		return contenedor.getContenedorProf().getVentana().getSistema().getAsignatura((lista.getSelectedValue()));
		
	}
	
	/**
	 * Anade un controlador al boton
	 * @param c Controlador a anadir
	 */
	 public void setControlador(ActionListener c) {
		 crearApuntes.addActionListener(c);
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
