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
import Controladores.ControladorAgregarContenido;

/**
 * Clase para definir el panel de crear tema
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelCrearTema extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private PanelContenido contenedor;
	
	private JLabel nombretema;
	private JTextField camponombre;
	private JRadioButton visible;
	private JRadioButton novisible;
	private ButtonGroup visibilidad;
	private JButton crearTema;
	private DefaultListModel<String> asignaturas = new DefaultListModel<String>();
	private JList<String> lista;
	
	public PanelCrearTema(PanelContenido cont){
		
		this.contenedor = cont;

		this.lista = new JList<String>(asignaturas); 
		
		this.nombretema = new JLabel("Nombre del tema:");
		this.camponombre = new JTextField(20);
		this.visible = new JRadioButton("Tema visible");
		this.novisible = new JRadioButton("T no visible");
		
		this.visibilidad = new ButtonGroup();
		
		this.crearTema = new JButton("Crear tema");
		
		// Anadimos las opciones a visibilidad
		visibilidad.add(visible);
		visibilidad.add(novisible);
		
		// Anadimos los componentes al panel
		this.add(nombretema);
		this.add(camponombre);
		this.add(visible);
		this.add(novisible);
		this.add(crearTema);
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
	public String getNombreTema(){
		return camponombre.getText();
	}
	
	/**
	 * Devuelve la asignatura seleccionada
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
		 crearTema.addActionListener(c);
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
		 
		 for (Asignatura a : asigexistentes){
				
				asignaturas.addElement(a.getNombre());
				
			}
		 
	 }
	

}
