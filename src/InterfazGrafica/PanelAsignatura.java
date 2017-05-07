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

import Asignatura.Tema;
import Controladores.ControladorAccederContenido;

public class PanelAsignatura extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelProfesor contenedorProf;
	private PanelAlumno contenedorAlum;
	private JButton acceder;
	private DefaultListModel<String> temas = new DefaultListModel<String>(); 
	private JScrollPane scrollPane;
	private JList<String> listatemas;
	
	PanelAsignatura(PanelContenido cont){
		
		this.temas.addElement("No existe ningun tema");
		
		ControladorAccederContenido controlador = new ControladorAccederContenido(this);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		this.acceder = new JButton("Acceder");
		springLayout.putConstraint(SpringLayout.WEST, acceder, 110, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, acceder, -496, SpringLayout.EAST, this);
		acceder.setFont(new Font("WenQuanYi Micro Hei Mono", Font.BOLD, 12));
		
		
		
		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, acceder, 6, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 137, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -167, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 49, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 318, SpringLayout.WEST, this);
		
		
		listatemas = new JList<String>(temas);
		scrollPane.setViewportView(listatemas);
		
		this.setControlador(controlador);
		this.add(acceder);
		this.add(scrollPane);
		
		if(cont.getContenedorProf()!=null){
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		this.contenedorProf = cont.getContenedorProf();
		
		}else{
			setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
			this.contenedorAlum = cont.getContenedorAlum();
			
		}
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
						
			}
			
			
		}
		
		else if(this.contenedorAlum != null){
			
			
			tem = this.contenedorAlum.getVentana().getSistema().getAsignatura(this.contenedorAlum.getPanelContenido().getPanelPrincipal().getNombreAsignaturaSeleccionada()).getTemas();

			if(!tem.isEmpty()){
				temas.removeAllElements();
					
				for(Tema a : tem){
					temas.addElement(a.getNombre());
				}
						
			}
					
			
		}
			
			
	}
	
	
	public void setControlador(ActionListener c){
		acceder.addActionListener(c);
	}
	

}
