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
	
	PanelPrincipal(PanelContenido cont){
		ControladorAccederContenido controlador = new ControladorAccederContenido(this);
		ControladorEditarContenido controla= new ControladorEditarContenido(this);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		
		 acceder = new JButton("Acceder");
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 155, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 614, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, -184, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 115, SpringLayout.NORTH, this);
		
		
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
			
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
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
			setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
			this.contenedorAlum = cont.getContenedorAlum();
		
			springLayout.putConstraint(SpringLayout.NORTH, acceder, 28, SpringLayout.SOUTH, scrollPane);
			springLayout.putConstraint(SpringLayout.WEST, acceder, 284, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.EAST, acceder, -322, SpringLayout.EAST, this);
			
			

			
		}
		
		this.setControlador(controlador,"acceder");
		
		springLayout.putConstraint(SpringLayout.NORTH, acceder, 61, SpringLayout.SOUTH, tabbedPane);
		springLayout.putConstraint(SpringLayout.WEST, acceder, 0, SpringLayout.WEST, tabbedPane);
		add(acceder);
	}
	

	public PanelAlumno getPanelAlumno(){
		return this.contenedorAlum;
	}
	
	public PanelProfesor getPanelProfesor(){
		return this.contenedorProf;
	}
			
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
	
	
	public void setControlador(ActionListener c,String nombreBoton){
		if(nombreBoton.equals("acceder")){
			acceder.addActionListener(c);
		}else if(nombreBoton.equals("editar")){
			editar.addActionListener(c);
		}
		
	}
}


