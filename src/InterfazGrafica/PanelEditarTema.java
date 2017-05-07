package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import Asignatura.Apuntes;
import Asignatura.Tema;
import Controladores.ControladorEditarContenido;
import Examen.Ejercicio;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class PanelEditarTema extends JPanel{

	private PanelProfesor contenedorProf;
	private JTabbedPane tabbedPane;
	private DefaultListModel<String> subtemas = new DefaultListModel<String>(); 
	private DefaultListModel<String> apuntes = new DefaultListModel<String>(); 
	private DefaultListModel<String> ejercicios = new DefaultListModel<String>(); 
	private JList<String> listaejercicios;
	private JList<String> listaapuntes;
	private JList<String> listasubtemas;
	private JButton editar;
	private JButton anyadir;
	private JButton eliminar;
	private JScrollPane scrollPane;
	private SpringLayout springLayout;
	
	private static final long serialVersionUID = 1L;
	
	
	PanelEditarTema(PanelContenido cont){
		this.springLayout = new SpringLayout();
		setLayout(springLayout);
		
		this.scrollPane = new JScrollPane();
		this.contenedorProf = cont.getContenedorProf();
		this.springLayout.putConstraint(SpringLayout.NORTH, this.scrollPane, 39, SpringLayout.NORTH, this);
		this.springLayout.putConstraint(SpringLayout.WEST, this.scrollPane, 50, SpringLayout.WEST, this);
		this.springLayout.putConstraint(SpringLayout.SOUTH,this.scrollPane, -116, SpringLayout.SOUTH, this);
		this.springLayout.putConstraint(SpringLayout.EAST, this.scrollPane, -48, SpringLayout.EAST, this);
		
		this.apuntes.addElement("No existe ningun apunte");
		this.ejercicios.addElement("No existe ningun ejercicio");
		this.subtemas.addElement("No existe ningun subtema");
		
		this.add(scrollPane);
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.scrollPane.setViewportView(tabbedPane);
		
		this.listaejercicios = new JList<String>(ejercicios);
		this.tabbedPane.addTab("Ejercicios", null, listaejercicios, null);
		
		this.listaapuntes = new JList<String>(apuntes);
		this.tabbedPane.addTab("Apuntes", null, listaapuntes, null);
		
		this.listasubtemas = new JList<String>(subtemas);
		tabbedPane.addTab("Subtemas", null, listasubtemas, null);
		
		this.anyadir = new JButton("Añadir");
		
		springLayout.putConstraint(SpringLayout.NORTH, anyadir, 34, SpringLayout.SOUTH, this.scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, anyadir, 108, SpringLayout.WEST, this);
		ControladorEditarContenido c = new ControladorEditarContenido(this);
		this.setControlador(c,"anyadir");
		this.add(anyadir);
		
		this.editar = new JButton("Editar");
		
		this.springLayout.putConstraint(SpringLayout.NORTH, this.editar, 0, SpringLayout.NORTH, this.anyadir);
		this.springLayout.putConstraint(SpringLayout.WEST, this.editar, 74, SpringLayout.EAST, this.anyadir);
		this.setControlador(c,"editar");
		this.add(editar);
		
		this.eliminar = new JButton("Eliminar");
		
		this.springLayout.putConstraint(SpringLayout.NORTH, this.eliminar, 0, SpringLayout.NORTH, this.anyadir);
		this.springLayout.putConstraint(SpringLayout.WEST, this.eliminar, 86, SpringLayout.EAST, this.editar);
		
		this.setControlador(c,"eliminar");
		this.add(eliminar);
		
	}
	
	public String getNombreTema(){
		
		return this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado();
		
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
	
	public PanelProfesor getPanelProf(){
		return this.contenedorProf;
	}
	
	public void actualizarTema() throws ClassNotFoundException, InvalidEmailAddressException, FailedInternetConnectionException, IOException{
		
		ArrayList<Tema> tem;
		ArrayList<Apuntes> apun;
		ArrayList<Ejercicio> ej;
		
		
		if(!this.getNombreSubtemaSeleccionado().equals("") && !this.getNombreSubtemaSeleccionado().equals("varios")  ){
			
			
				 
			Tema TemaPadre =this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado());
					 
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
							if(a.esVisible()==true){
								subtemas.addElement(a.getNombre());
							}
						}
									
					}else{
						this.subtemas.addElement("No existe ningun subtema");
					}
						
					if(!apun.isEmpty()){
							
						for(Apuntes a : apun){
							if(a.getVisible()==true){
								apuntes.addElement(a.getTitulo());
							}
							
						}
									
					}else{
						this.apuntes.addElement("No existe ningun apunte");
					}
						
					if(!ej.isEmpty()){
								
						for(Ejercicio a : ej){
							if(a.getVisible() == true){
								ejercicios.addElement(a.getNombre());
							}
						}
									
					}else{
						this.ejercicios.addElement("No existe ningun ejercicio"); 	
					}
						
						
						
				}
						
			}
			
			return;
		}
		
		
		tem = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado()).getTemas();
		apun = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado()).getApuntes();
		ej = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado()).getEjercicios();
		
		subtemas.removeAllElements();
		apuntes.removeAllElements();
		ejercicios.removeAllElements();
		
		if(!tem.isEmpty()){	
			
			for(Tema a : tem){
				if(a.esVisible()==true){
					subtemas.addElement(a.getNombre());
				}
			}
						
		}else{
			this.subtemas.addElement("No existe ningun subtema");
		}
			
		if(!apun.isEmpty()){
				
			for(Apuntes a : apun){
				if(a.getVisible()==true){
					apuntes.addElement(a.getTitulo());
				}
				
			}
						
		}else{
			this.apuntes.addElement("No existe ningun apunte");
		}
			
		if(!ej.isEmpty()){
					
			for(Ejercicio a : ej){
				if(a.getVisible() == true){
					ejercicios.addElement(a.getNombre());
				}
			}
						
		}else{
			this.ejercicios.addElement("No existe ningun ejercicio");
		}
		
	}
	
	public void setControlador(ActionListener c,String nombre){
		if(nombre.equals("anyadir")){
			this.anyadir.addActionListener(c);
		}else if(nombre.equals("editar")){
			this.editar.addActionListener(c);
		}else if(nombre.equals("eliminar")){
			this.eliminar.addActionListener(c);
		}
	}
}
