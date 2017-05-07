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

import Asignatura.Tema;
import Controladores.ControladorAccederContenido;
import Controladores.ControladorEditarContenido;

public class PanelAsignatura extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelProfesor contenedorProf;
	private PanelAlumno contenedorAlum;
	private JButton acceder;
	private DefaultListModel<String> temas = new DefaultListModel<String>(); 
	private JScrollPane scrollPane;
	private JList<String> listatemas;
	private JTabbedPane tabbedPane;
	private JButton editar;
	
	PanelAsignatura(PanelContenido cont){
		
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
		
		
		this.listatemas = new JList<String>(temas);
		scrollPane.setViewportView(listatemas);
		
		tabbedPane.addTab("Temas", null, scrollPane, null);
		
		
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
	
	public PanelProfesor getPanelProf(){
		return this.contenedorProf;
	}
			
	public String getNombreTemaSeleccionado(){
		if(this.listatemas.getSelectedValue() == null){
			return "";
		}else{
			return this.listatemas.getSelectedValue();
			
		}
	}
	
	public String getNombreAsignatura(){
		if(this.contenedorProf != null){
			return this.contenedorProf.getPanelContenido().getPanelPrincipal().getNombreAsignaturaSeleccionada();
		}else{
			return this.contenedorAlum.getPanelContenido().getPanelPrincipal().getNombreAsignaturaSeleccionada();
		}
		
	}

	
	public void actualizarTemas(){
		
	ArrayList<Tema> tem;
		
		if(this.contenedorProf != null){
			
			tem = this.contenedorProf.getVentana().getSistema().getAsignatura(this.contenedorProf.getPanelContenido().getPanelPrincipal().getNombreAsignaturaSeleccionada()).getTemas();
			
			
			if(!tem.isEmpty()){
				temas.removeAllElements();
					
				for(Tema a : tem){
					temas.addElement(a.getNombre());
				}
				
				
			}else{
				temas.removeAllElements();
				this.temas.addElement("No existe ningun tema");
			}
			
			
		}
		
		else if(this.contenedorAlum != null){
			
			
			tem = this.contenedorAlum.getVentana().getSistema().getAsignatura(this.contenedorAlum.getPanelContenido().getPanelPrincipal().getNombreAsignaturaSeleccionada()).getTemas();

			if(!tem.isEmpty()){
				temas.removeAllElements();
				
				for(Tema a : tem){
					if(a.esVisible()==true){
						temas.addElement(a.getNombre());
					}
					
				}
				if(temas.isEmpty()){
					this.temas.addElement("No existe ningun tema");
				}
						
			}else{
				temas.removeAllElements();
				this.temas.addElement("No existe ningun tema");
			}
					
			
		}
			
			
	}
	
	
	public void setControlador(ActionListener c,String nombre){
		if(nombre.equals("acceder")){
			acceder.addActionListener(c);
		}if(nombre.equals("editar")){
			editar.addActionListener(c);
		}
	}
	

}
