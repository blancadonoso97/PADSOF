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
	private JTextField campotexto;
	private JRadioButton visible;
	private JRadioButton novisible;
	private ButtonGroup visibilidad;
	
	private JButton crearApuntes;
	
	private JList<String> lista;
	
	public PanelCrearApuntes(PanelContenido cont){
		
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
		
		this.nombreapuntes = new JLabel("Nombre del tema:");
		this.camponombre = new JTextField(20);
		this.campotexto = new JTextField(250);
		this.visible = new JRadioButton("Apuntes visibles");
		this.novisible = new JRadioButton("Apuntes no visibles");
		
		this.visibilidad = new ButtonGroup();
		
		this.crearApuntes = new JButton("Crear Apuntes");
		
		// Anadimos las opciones a visibilidad
		visibilidad.add(visible);
		visibilidad.add(novisible);
		
		// Anadimos los componentes al panel
		this.add(nombreapuntes);
		this.add(camponombre);
		this.add(campotexto);
		this.add(visible);
		this.add(novisible);
		this.add(crearApuntes);
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
	 * Devuelve el texto de los apuntes
	 * @return Texto apuntes
	 */
	public String getTexto(){
		return campotexto.getText();
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
