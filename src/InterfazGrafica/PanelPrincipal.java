package InterfazGrafica;


import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import Asignatura.Asignatura;
import Controladores.ControladorAccederContenido;
import Controladores.ControladorEditarContenido;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

/**
 * Clase que implementa el panel principal
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelPrincipal extends JPanel{

	
	private static final long serialVersionUID = 1L;
	
	private PanelProfesor contenedorProf;
	private PanelAlumno contenedorAlum;
	private JButton editar;
	private DefaultListModel<String> asignaturas = new DefaultListModel<String>(); 
	private JScrollPane scrollPane;
	private JList<String> listasignaturas;
	private JTabbedPane tabbedPane;
	private JButton acceder;
	
	/**
	 * Constructor que implementa la interfaz grafica del panel principal
	 * @param cont Panel del contenido 
	 */
	public PanelPrincipal(PanelContenido cont){
		setBackground(UIManager.getColor("Checkbox.select"));
		
		ControladorAccederContenido controlador = new ControladorAccederContenido(this);
		ControladorEditarContenido controla= new ControladorEditarContenido(this);
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		
		 acceder = new JButton("Acceder");
		 springLayout.putConstraint(SpringLayout.NORTH, acceder, 613, SpringLayout.NORTH, this);
		 springLayout.putConstraint(SpringLayout.WEST, acceder, 155, SpringLayout.WEST, this);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 86, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, -132, SpringLayout.NORTH, acceder);
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 674, SpringLayout.WEST, this);
		
		
		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 137, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -167, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 49, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 318, SpringLayout.WEST, this);
		
		
		listasignaturas = new JList<String>(asignaturas);
		scrollPane.setViewportView(listasignaturas);
		
		tabbedPane.addTab("Asignaturas", null, scrollPane, null);
				
		this.add(tabbedPane);

		if(cont.getContenedorProf()!=null){
			
		this.contenedorProf = cont.getContenedorProf();

		
		springLayout.putConstraint(SpringLayout.WEST, acceder, 156, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, acceder, -450, SpringLayout.EAST, this);
		
		
		this.editar = new JButton("Editar");
		
		springLayout.putConstraint(SpringLayout.NORTH, acceder, 28, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, editar, 0, SpringLayout.NORTH, acceder);
		springLayout.putConstraint(SpringLayout.WEST, editar, 110, SpringLayout.EAST, acceder);
		springLayout.putConstraint(SpringLayout.EAST, editar, 273, SpringLayout.EAST, acceder);
	
		this.setControlador(controla,"editar");
		

		this.add(editar);
		
		}else{
			
			this.contenedorAlum = cont.getContenedorAlum();
		
			springLayout.putConstraint(SpringLayout.NORTH, acceder, 28, SpringLayout.SOUTH, scrollPane);
			springLayout.putConstraint(SpringLayout.WEST, acceder, 284, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.EAST, acceder, -322, SpringLayout.EAST, this);
			
			

			
		}
		
		this.setControlador(controlador,"acceder");
		add(acceder);
		
		JLabel lblEcourses = new JLabel("eCourses");
		springLayout.putConstraint(SpringLayout.NORTH, lblEcourses, 81, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEcourses, -561, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 38, SpringLayout.SOUTH, lblEcourses);
		springLayout.putConstraint(SpringLayout.WEST, lblEcourses, 200, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblEcourses, -213, SpringLayout.EAST, this);
		lblEcourses.setForeground(SystemColor.activeCaption);
		lblEcourses.setFont(new Font("Nimbus Sans L", Font.BOLD | Font.ITALIC, 74));
		add(lblEcourses);
	}
	
	/**
	 * Funcion que devuelve el panel del alumno 
	 * @return contenedorAlum
	 */
	public PanelAlumno getPanelAlumno(){
		return contenedorAlum;
	}
	
	/**
	 * Funcion que devuelve el panel del profesor
	 * @return contenedorProf
	 */
	public PanelProfesor getPanelProfesor(){
		return contenedorProf;
	}
			
	/**
	 * Funcion que devuelve el nombre de la asignatura seleccionada
	 * @return Nombre de la asignatura seleccionada
	 */
	public String getNombreAsignaturaSeleccionada(){
		
		if(this.listasignaturas.getSelectedValue() == null){
			return "";
		}else{
			if(this.contenedorProf != null){
				return this.contenedorProf.getVentana().getSistema().getAsignatura(this.listasignaturas.getSelectedValue()).getNombre();
			}else{
				return this.contenedorAlum.getVentana().getSistema().getAlumnoLog().getAsignatura(this.listasignaturas.getSelectedValue()).getNombre();
			}
			
		}
	}
	
	/**
	 * Funcion que actualiza el estado del panel principal
	 */
	public void actualizarAsignaturas(){
		ArrayList<Asignatura> asig;
		
		if(this.contenedorProf != null){
			
			asig = this.contenedorProf.getVentana().getSistema().getAsignaturas();
			
			
			if(!asig.isEmpty()){
				asignaturas.removeAllElements();
					
				for(Asignatura a : asig){
					asignaturas.addElement(a.getNombre());
				}
						
			}
			
			
		}
		
		else if(this.contenedorAlum != null && this.contenedorAlum.getVentana().getSistema().getAlumnoLog()!=null){
			
			
			asig = this.contenedorAlum.getVentana().getSistema().getAlumnoLog().getAsignaturas();

			if(!asig.isEmpty()){
				asignaturas.removeAllElements();
					
				for(Asignatura a : asig){
					if(a.getVisible() == true){
						asignaturas.addElement(a.getNombre());
					}
					
				}
				if(asignaturas.isEmpty()){
					this.asignaturas.addElement("No existe ninguna asignatura");
				}
						
			}else{
				this.asignaturas.addElement("No existe ninguna asignatura");
			}
					
			
		}
			
	}
	
	/**
	 * Funcion que modifica el controlador de los botones
	 * @param c Controlador elegido
	 * @param nombreBoton Nombre del boton
	 */
	public void setControlador(ActionListener c,String nombreBoton){
		if(nombreBoton.equals("acceder")){
			acceder.addActionListener(c);
		}else if(nombreBoton.equals("editar")){
			editar.addActionListener(c);
		}
		
	}
}


