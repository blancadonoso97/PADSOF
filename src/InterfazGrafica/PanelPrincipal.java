package InterfazGrafica;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import Asignatura.Asignatura;
import Controladores.ControladorAccederContenido;

public class PanelPrincipal extends JPanel{

	
	private static final long serialVersionUID = 1L;
	
	private PanelProfesor contenedorProf;
	private PanelAlumno contenedorAlum;
	private JButton acceder;
	private JButton editar;
	private DefaultListModel<String> asignaturas = new DefaultListModel<String>(); 
	private JScrollPane scrollPane;
	private JList<String> listasignaturas;
	
	PanelPrincipal(PanelContenido cont){
		
		
		this.asignaturas.addElement("No existe ninguna asignatura");
		
		ControladorAccederContenido controlador = new ControladorAccederContenido(this);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		
		scrollPane = new JScrollPane();
		
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -227, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 694, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 137, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 49, SpringLayout.WEST, this);
		
		
		listasignaturas = new JList<String>(asignaturas);
		scrollPane.setViewportView(listasignaturas);
		
		
		this.add(scrollPane);
		
		
		if(cont.getContenedorProf()!=null){
			
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		this.contenedorProf = cont.getContenedorProf();
		
		this.acceder = new JButton("Acceder");
		
		springLayout.putConstraint(SpringLayout.WEST, acceder, 156, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, acceder, -450, SpringLayout.EAST, this);
		acceder.setFont(new Font("WenQuanYi Micro Hei Mono", Font.BOLD, 12));
		
		this.editar = new JButton("Editar");
		
		springLayout.putConstraint(SpringLayout.NORTH, acceder, 28, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, editar, 0, SpringLayout.NORTH, acceder);
		springLayout.putConstraint(SpringLayout.WEST, editar, 110, SpringLayout.EAST, acceder);
		springLayout.putConstraint(SpringLayout.EAST, editar, 273, SpringLayout.EAST, acceder);
		
		this.setControlador(controlador,"acceder");
		this.setControlador(controlador,"editar");
		
		this.add(acceder);
		this.add(editar);
		
		}else{
			setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
			this.contenedorAlum = cont.getContenedorAlum();
			
			this.acceder = new JButton("Acceder");
			springLayout.putConstraint(SpringLayout.NORTH, acceder, 28, SpringLayout.SOUTH, scrollPane);
			springLayout.putConstraint(SpringLayout.WEST, acceder, 284, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.EAST, acceder, -322, SpringLayout.EAST, this);
			acceder.setFont(new Font("WenQuanYi Micro Hei Mono", Font.BOLD, 12));
			
			this.setControlador(controlador,"acceder");
			this.add(acceder);
		}
		
		
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
					asignaturas.addElement(a.getNombre());
				}
						
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


