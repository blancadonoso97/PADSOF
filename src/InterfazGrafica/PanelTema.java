package InterfazGrafica;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;

import Asignatura.Apuntes;
import Asignatura.Tema;
import Controladores.ControladorAccederContenido;
import Examen.Ejercicio;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JTabbedPane;

public class PanelTema extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelProfesor contenedorProf;
	private PanelAlumno contenedorAlum;
	private JButton acceder;
	private DefaultListModel<String> subtemas = new DefaultListModel<String>(); 
	private DefaultListModel<String> apuntes = new DefaultListModel<String>(); 
	private DefaultListModel<String> ejercicios = new DefaultListModel<String>(); 
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JList<String> listasubtemas;
	private JList<String> listaapuntes;
	private JList<String> listaejercicios;
	private JTabbedPane tabbedPane;
	
	PanelTema(PanelContenido cont){
		
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		
		ControladorAccederContenido controlador = new ControladorAccederContenido(this);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		this.apuntes.addElement("No existe ningun apunte");
		this.ejercicios.addElement("No existe ningun ejercicio");
		this.subtemas.addElement("No existe ningun subtema");
		
		this.acceder = new JButton("Acceder");
		springLayout.putConstraint(SpringLayout.WEST, acceder, 309, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, acceder, -371, SpringLayout.EAST, this);
		acceder.setFont(new Font("WenQuanYi Micro Hei Mono", Font.BOLD, 12));
		this.setControlador(controlador);
		
		this.add(acceder);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, acceder, 40, SpringLayout.SOUTH, tabbedPane);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 115, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 68, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, -203, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 703, SpringLayout.WEST, this);
		add(tabbedPane);
		
		
		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.SOUTH, acceder, 38, SpringLayout.SOUTH, scrollPane);
		tabbedPane.addTab("Apuntes", null, scrollPane, null);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 137, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -167, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 49, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 318, SpringLayout.WEST, this);
		
		listaapuntes = new JList<String>(apuntes);
		scrollPane.setViewportView(listaapuntes);
		
		scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Ejercicios", null, scrollPane_1, null);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -180, SpringLayout.SOUTH, this);
		
		listaejercicios = new JList<String>(ejercicios);
		scrollPane_1.setViewportView(listaejercicios);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 56, SpringLayout.EAST, scrollPane);
		
		
		scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("Subtemas", null, scrollPane_2, null);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_2, 578, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_2, -28, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_2, 188, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_2, -180, SpringLayout.SOUTH, this);
		
		
		listasubtemas = new JList<String>(subtemas);
		scrollPane_2.setViewportView(listasubtemas);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 0, SpringLayout.NORTH, scrollPane_2);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -40, SpringLayout.WEST, scrollPane_2);
		
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
	
	public String getNombreTema(){
		if(this.contenedorProf != null){
			return this.contenedorProf.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado();
		}else{
			return this.contenedorAlum.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado();
		}
	}

	
	public String getNombreApunteSeleccionado(){
		if(this.listaapuntes.getSelectedValue() == null){
			return "";
		}else if(this.listaapuntes.getSelectedValue() != null && (this.listaejercicios.getSelectedValue()!=null || this.listasubtemas.getSelectedValue()!=null)){
			return "varios";
		}else{
			return this.listaapuntes.getSelectedValue();
		}
	}
	
	public String getNombreEjercicioSeleccionado(){
		
		if(this.listaejercicios.getSelectedValue() == null){
			return "";
		}else if(this.listaejercicios.getSelectedValue() != null && (this.listaapuntes.getSelectedValue()!=null || this.listasubtemas.getSelectedValue()!=null)){
			return "varios";
		}else{
			return this.listaejercicios.getSelectedValue();
		}
		
	}
	
	public String getNombreSubtemaSeleccionado(){

		if(this.listasubtemas.getSelectedValue() == null){
			return "";
		}else if(this.listasubtemas.getSelectedValue() != null && (this.listaapuntes.getSelectedValue()!=null || this.listaejercicios.getSelectedValue()!=null)){
			return "varios";
		}else{
			return this.listasubtemas.getSelectedValue();
		}
		
	}
	
	public void actualizarContenido(){
	
		ArrayList<Tema> tem;
		ArrayList<Apuntes> apun;
		ArrayList<Ejercicio> ej;
		
		this.add(acceder);
		
		if(!this.getNombreSubtemaSeleccionado().equals("") && !this.getNombreSubtemaSeleccionado().equals("varios")  ){
			
			if(this.contenedorProf != null){
				 
				Tema TemaPadre =this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado());
					 
				for(Tema t : TemaPadre.getTemas()){
					if(t.getNombre().equals(this.getNombreSubtemaSeleccionado())){
						 
						tem = t.getTemas();
						apun =t.getApuntes();
						ej = t.getEjercicios();
						
						subtemas.removeAllElements();
						apuntes.removeAllElements();
						ejercicios.removeAllElements();
						
						if(!tem.isEmpty()){	
								
							for(Tema a : tem){
								subtemas.addElement(a.getNombre());
							}
									
						}else{
							this.subtemas.addElement("No existe ningun subtema");
						}
						
						if(!apun.isEmpty()){
							
							for(Apuntes a : apun){
								apuntes.addElement(a.getTitulo());
							}
									
						}else{
							this.apuntes.addElement("No existe ningun apunte");
						}
						
						if(!ej.isEmpty()){
								
							for(Ejercicio a : ej){
								ejercicios.addElement(a.getNombre());
							}
									
						}else{
							this.ejercicios.addElement("No existe ningun ejercicio"); 	
						}
						
						
						
					}
						
				}
					
				
			}else{
				
				Tema TemaPadre =this.contenedorAlum.getVentana().getSistema().getTema(this.contenedorAlum.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado());
				 
				for(Tema t : TemaPadre.getTemas()){
					if(t.getNombre().equals(this.getNombreSubtemaSeleccionado())){
						 
						tem = t.getTemas();
						apun =t.getApuntes();
						ej = t.getEjercicios();
						
						subtemas.removeAllElements();
						apuntes.removeAllElements();
						ejercicios.removeAllElements();
						
						if(!tem.isEmpty()){	
								
							for(Tema a : tem){
								subtemas.addElement(a.getNombre());
							}
									
						}else{
							this.subtemas.addElement("No existe ningun subtema");
						}
						
						if(!apun.isEmpty()){
							
							for(Apuntes a : apun){
								apuntes.addElement(a.getTitulo());
							}
									
						}else{
							this.apuntes.addElement("No existe ningun apunte");
						}
						
						if(!ej.isEmpty()){
								
							for(Ejercicio a : ej){
								ejercicios.addElement(a.getNombre());
							}
									
						}else{
							this.ejercicios.addElement("No existe ningun ejercicio"); 	
						}
						
						
						
					}
						
				}
				
			}
			
			
		}
		else if(this.contenedorProf != null){
			
			
			tem = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).getTemas();
			apun = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).getApuntes();
			ej = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).getEjercicios();
			
			if(!tem.isEmpty()){
				subtemas.removeAllElements();
					
				for(Tema a : tem){
					subtemas.addElement(a.getNombre());
				}
						
			}
			
			if(!apun.isEmpty()){
				apuntes.removeAllElements();
					
				for(Apuntes a : apun){
					apuntes.addElement(a.getTitulo());
				}
						
			}
			
			if(!ej.isEmpty()){
				ejercicios.removeAllElements();
					
				for(Ejercicio a : ej){
					ejercicios.addElement(a.getNombre());
				}
						
			}
			
		}
		
		else if(this.contenedorAlum != null && this.contenedorAlum.getVentana().getSistema().getAlumnoLog()!=null){
			
			
			tem = this.contenedorAlum.getVentana().getSistema().getTema(this.contenedorAlum.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).getTemas();
			apun = this.contenedorAlum.getVentana().getSistema().getTema(this.contenedorAlum.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).getApuntes();
			ej = this.contenedorAlum.getVentana().getSistema().getTema(this.contenedorAlum.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).getEjercicios();
			
			if(!tem.isEmpty()){
				subtemas.removeAllElements();
					
				for(Tema a : tem){
					subtemas.addElement(a.getNombre());
				}
						
			}
			
			if(!apun.isEmpty()){
				apuntes.removeAllElements();
					
				for(Apuntes a : apun){
					apuntes.addElement(a.getTitulo());
				}
						
			}
			
			if(!ej.isEmpty()){
				ejercicios.removeAllElements();
					
				for(Ejercicio a : ej){
					ejercicios.addElement(a.getNombre());
				}
						
			}
					
			
		}
			
	}
	
	
	public void setControlador(ActionListener c){
		acceder.addActionListener(c);
	}
}
