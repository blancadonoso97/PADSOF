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

import Asignatura.Asignatura;
import Controladores.ControladorAgregarContenido;
import javax.swing.UIManager;
import javax.swing.SpringLayout;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.SystemColor;

/**
 * Clase para definir el panel de crear tema
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
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
	private JComboBox<String>lista;
	
	/**
	 * Constructor que implementa la intefaz grafica del panel crear un tema
	 * @param cont panel del contenido
	 */
	public PanelCrearTema(PanelContenido cont){
		setBackground(UIManager.getColor("Checkbox.select"));
		
		this.contenedor = cont;

		this.lista = new JComboBox<String>(); 
		
		this.nombretema = new JLabel("Nombre del tema:");
		nombretema.setForeground(SystemColor.activeCaption);
		nombretema.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		this.camponombre = new JTextField(20);
		this.visible = new JRadioButton("Tema visible");
		visible.setForeground(SystemColor.activeCaption);
		visible.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		visible.setBackground(UIManager.getColor("Checkbox.select"));
		
		this.novisible = new JRadioButton("Tema no visible");
		novisible.setForeground(SystemColor.activeCaption);
		novisible.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		novisible.setBackground(UIManager.getColor("Checkbox.select"));
		
		this.visibilidad = new ButtonGroup();
		
		// Anadimos las opciones a visibilidad
		visibilidad.add(visible);
		visibilidad.add(novisible);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, camponombre, 439, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, novisible, 223, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, lista, 3, SpringLayout.NORTH, novisible);
		springLayout.putConstraint(SpringLayout.WEST, lista, 132, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lista, -681, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, visible, -6, SpringLayout.NORTH, novisible);
		springLayout.putConstraint(SpringLayout.EAST, visible, -272, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, novisible, -257, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, nombretema, 390, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, nombretema, -6, SpringLayout.NORTH, camponombre);
		springLayout.putConstraint(SpringLayout.WEST, camponombre, 169, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, camponombre, 745, SpringLayout.WEST, this);
		setLayout(springLayout);
		
		// Anadimos los componentes al panel
		this.add(nombretema);
		this.add(camponombre);
		this.add(visible);
		this.add(novisible);
		this.add(lista);
		
		// Anade el controlador para el boton de crear asignatura
		ControladorAgregarContenido controlador = new ControladorAgregarContenido(contenedor.getContenedorProf().getVentana(),this);
		
		this.crearTema = new JButton("Crear tema");
		springLayout.putConstraint(SpringLayout.NORTH, crearTema, 73, SpringLayout.SOUTH, camponombre);
		springLayout.putConstraint(SpringLayout.EAST, crearTema, -413, SpringLayout.EAST, this);
		this.add(crearTema);
		
		JLabel lblNuevoTema = DefaultComponentFactory.getInstance().createTitle("Nuevo Tema");
		springLayout.putConstraint(SpringLayout.NORTH, lblNuevoTema, 109, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNuevoTema, 325, SpringLayout.WEST, this);
		lblNuevoTema.setForeground(SystemColor.activeCaption);
		lblNuevoTema.setFont(new Font("Nimbus Sans L", Font.BOLD, 31));
		add(lblNuevoTema);
		
		JLabel lblAsignatura = DefaultComponentFactory.getInstance().createLabel("Asignatura:");
		springLayout.putConstraint(SpringLayout.NORTH, lblAsignatura, 4, SpringLayout.NORTH, visible);
		springLayout.putConstraint(SpringLayout.WEST, lblAsignatura, 151, SpringLayout.WEST, this);
		lblAsignatura.setForeground(SystemColor.activeCaption);
		lblAsignatura.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		add(lblAsignatura);
	
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
		
		String valorSeleccionado = (String)lista.getSelectedItem();
		
		return contenedor.getContenedorProf().getVentana().getSistema().getAsignatura((valorSeleccionado));
		
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
		
		lista.removeAllItems();
		
		 for (Asignatura a : asigexistentes){
				lista.addItem(a.getNombre());
				
			}
		 
	 }
}
