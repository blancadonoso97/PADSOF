package InterfazGrafica;


import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import javax.swing.SpringLayout;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.SystemColor;

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
	
	/**
	 * Constructor de la clase PanelCrearSubtema
	 * @param cont Panel contenido
	 */
	public PanelCrearSubtema(PanelContenido cont){
		setBackground(UIManager.getColor("Checkbox.select"));
		
		this.contenedor = cont;

		this.lista = new JComboBox<String>(); 
		
		this.nombretema = new JLabel("Nombre del subtema:");
		nombretema.setForeground(SystemColor.activeCaption);
		nombretema.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		this.camponombre = new JTextField(20);
		this.visible = new JRadioButton("Subtema visible");
		visible.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		visible.setForeground(SystemColor.activeCaption);
		visible.setBackground(UIManager.getColor("Checkbox.select"));
		
		this.novisible = new JRadioButton("Subtema no visible");
		novisible.setForeground(SystemColor.activeCaption);
		novisible.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		novisible.setBackground(UIManager.getColor("Checkbox.select"));
		
		this.visibilidad = new ButtonGroup();
		
		this.crearSubtema = new JButton("Crear subtema");
		
		// Anadimos las opciones a visibilidad
		visibilidad.add(visible);
		visibilidad.add(novisible);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, crearSubtema, 53, SpringLayout.SOUTH, camponombre);
		springLayout.putConstraint(SpringLayout.EAST, crearSubtema, 0, SpringLayout.EAST, nombretema);
		springLayout.putConstraint(SpringLayout.SOUTH, nombretema, -278, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lista, -100, SpringLayout.NORTH, camponombre);
		springLayout.putConstraint(SpringLayout.NORTH, camponombre, 33, SpringLayout.SOUTH, nombretema);
		springLayout.putConstraint(SpringLayout.WEST, camponombre, 105, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, camponombre, -128, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, nombretema, 367, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, novisible, -2, SpringLayout.NORTH, visible);
		springLayout.putConstraint(SpringLayout.NORTH, visible, -3, SpringLayout.NORTH, lista);
		springLayout.putConstraint(SpringLayout.EAST, visible, -10, SpringLayout.EAST, novisible);
		springLayout.putConstraint(SpringLayout.EAST, novisible, -198, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, lista, 78, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lista, 253, SpringLayout.WEST, this);
		setLayout(springLayout);
		
		// Anadimos los componentes al panel
		this.add(nombretema);
		this.add(camponombre);
		this.add(novisible);
		this.add(visible);
		this.add(crearSubtema);
		this.add(lista);
		
		// Anade el controlador para el boton de crear asignatura
		ControladorAgregarContenido controlador = new ControladorAgregarContenido(contenedor.getContenedorProf().getVentana(),this);
		
		JLabel lblTema = DefaultComponentFactory.getInstance().createLabel("Tema :");
		springLayout.putConstraint(SpringLayout.NORTH, lblTema, 4, SpringLayout.NORTH, novisible);
		springLayout.putConstraint(SpringLayout.WEST, lblTema, 133, SpringLayout.WEST, this);
		lblTema.setForeground(SystemColor.activeCaption);
		lblTema.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		add(lblTema);
		
		JLabel lblNuevoSubtema = DefaultComponentFactory.getInstance().createTitle("Nuevo Subtema");
		springLayout.putConstraint(SpringLayout.NORTH, lblNuevoSubtema, 122, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNuevoSubtema, 318, SpringLayout.WEST, this);
		lblNuevoSubtema.setForeground(SystemColor.activeCaption);
		lblNuevoSubtema.setFont(new Font("Nimbus Sans L", Font.BOLD, 31));
		add(lblNuevoSubtema);
	
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
