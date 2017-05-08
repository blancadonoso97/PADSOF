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
import javax.swing.SpringLayout;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Clase para definir el panel de crear asignatura
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
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
	 * Constructor de la clase PanelCrearAsignatura
	 * @param cont Panel de contenido
	 */
	public PanelCrearAsignatura(PanelContenido cont){
		
		setBackground(UIManager.getColor("Checkbox.select"));
		
		this.contenedor = cont;
		
		this.nombreasig = new JLabel("Nombre de la asignatura:");
		nombreasig.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		nombreasig.setForeground(SystemColor.activeCaption);
		this.camponombre = new JTextField(20);
		camponombre.setHorizontalAlignment(SwingConstants.CENTER);
		this.visible = new JRadioButton("Asignatura visible");
		visible.setForeground(SystemColor.activeCaption);
		visible.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		visible.setBackground(UIManager.getColor("Checkbox.select"));
		this.novisible = new JRadioButton("Asignatura no visible");
		novisible.setForeground(SystemColor.activeCaption);
		novisible.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		novisible.setBackground(UIManager.getColor("Checkbox.select"));
		
		this.visibilidad = new ButtonGroup();
		
		this.crearAsig = new JButton("Crear asignatura");
		
		// Anadimos las opciones a visibilidad
		visibilidad.add(visible);
		visibilidad.add(novisible);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, novisible, 424, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, novisible, -96, SpringLayout.NORTH, nombreasig);
		springLayout.putConstraint(SpringLayout.NORTH, visible, 0, SpringLayout.NORTH, novisible);
		springLayout.putConstraint(SpringLayout.EAST, visible, -78, SpringLayout.WEST, novisible);
		springLayout.putConstraint(SpringLayout.WEST, nombreasig, 297, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, nombreasig, -6, SpringLayout.NORTH, camponombre);
		springLayout.putConstraint(SpringLayout.SOUTH, camponombre, -303, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, crearAsig, 60, SpringLayout.SOUTH, camponombre);
		springLayout.putConstraint(SpringLayout.WEST, crearAsig, 315, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, camponombre, 138, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, camponombre, 656, SpringLayout.WEST, this);
		setLayout(springLayout);
		
		// Anadimos los componentes al panel
		this.add(nombreasig);
		this.add(camponombre);
		this.add(visible);
		this.add(novisible);
		this.add(crearAsig);
		
		// Anade el controlador para el boton de crear asignatura
		ControladorAgregarContenido controlador = new ControladorAgregarContenido(contenedor.getContenedorProf().getVentana(),this);
		
		JLabel lblNuevaAsignatura = new JLabel("Nueva Asignatura");
		springLayout.putConstraint(SpringLayout.NORTH, lblNuevaAsignatura, 46, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNuevaAsignatura, 258, SpringLayout.WEST, this);
		lblNuevaAsignatura.setForeground(SystemColor.activeCaption);
		lblNuevaAsignatura.setFont(new Font("Nimbus Sans L", Font.BOLD, 32));
		add(lblNuevaAsignatura);
				
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
