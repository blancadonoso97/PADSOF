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

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
/**
 * Clase que define el panel que permitira editar un tema
 * @author  Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
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
	private JRadioButton visible;
	private JRadioButton novisible;
	private ButtonGroup visibilidad;
	private JButton guardar;
	private JEditorPane titulonew;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor que implementa la interfaz grafica del panel que edita un tema
	 * @param cont Panel del contenido
	 */
	public PanelEditarTema(PanelContenido cont){
		
		this.springLayout = new SpringLayout();
		setLayout(springLayout);
		
		this.scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 101, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 49, SpringLayout.WEST, this);
		this.springLayout.putConstraint(SpringLayout.EAST, scrollPane, -49, SpringLayout.EAST, this);
		this.contenedorProf = cont.getContenedorProf();
		
		this.apuntes.addElement("No existe ningun apunte");
		this.ejercicios.addElement("No existe ningun ejercicio");
		this.subtemas.addElement("No existe ningun subtema");
		
		this.add(scrollPane);
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.scrollPane.setViewportView(tabbedPane);
		
		this.listaapuntes = new JList<String>(apuntes);
		this.tabbedPane.addTab("Apuntes", null, listaapuntes, null);
		
		this.listasubtemas = new JList<String>(subtemas);
		tabbedPane.addTab("Subtemas", null, listasubtemas, null);
		
		this.listaejercicios = new JList<String>(ejercicios);
		this.tabbedPane.addTab("Ejercicios", null, listaejercicios, null);
		
		this.anyadir = new JButton("Añadir");
		springLayout.putConstraint(SpringLayout.NORTH, anyadir, 298, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -17, SpringLayout.NORTH, anyadir);
		ControladorEditarContenido c = new ControladorEditarContenido(this);
		this.setControlador(c,"anyadir");
		this.add(anyadir);
		
		this.editar = new JButton("Editar");
		springLayout.putConstraint(SpringLayout.WEST, editar, 251, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, anyadir, -56, SpringLayout.WEST, editar);
		springLayout.putConstraint(SpringLayout.NORTH, editar, 0, SpringLayout.NORTH, anyadir);
		this.setControlador(c,"editar");
		this.add(editar);
		
		this.eliminar = new JButton("Eliminar");
		springLayout.putConstraint(SpringLayout.NORTH, eliminar, 0, SpringLayout.NORTH, anyadir);
		springLayout.putConstraint(SpringLayout.WEST, eliminar, 69, SpringLayout.EAST, editar);
		
		this.setControlador(c,"eliminar");
		this.add(eliminar);
		
		visible = new JRadioButton("Visible");
		springLayout.putConstraint(SpringLayout.NORTH, visible, 19, SpringLayout.SOUTH, eliminar);
		springLayout.putConstraint(SpringLayout.WEST, visible, 332, SpringLayout.WEST, this);
		
		novisible = new JRadioButton("No visible");
		springLayout.putConstraint(SpringLayout.NORTH, novisible, 0, SpringLayout.NORTH, visible);
		springLayout.putConstraint(SpringLayout.EAST, novisible, -30, SpringLayout.WEST, visible);
		
		this.visibilidad = new ButtonGroup();
		
		visibilidad.add(visible);
		visibilidad.add(novisible);
		this.add(novisible);
		this.add(visible);
		
		guardar = new JButton("Guardar");
		springLayout.putConstraint(SpringLayout.NORTH, guardar, 29, SpringLayout.SOUTH, novisible);
		springLayout.putConstraint(SpringLayout.WEST, guardar, 262, SpringLayout.WEST, this);
		
		ControladorEditarContenido cont1 = new ControladorEditarContenido(this);
		this.setControlador(cont1,"guardar");
		add(guardar);
		
		titulonew = new JEditorPane();
		springLayout.putConstraint(SpringLayout.WEST, titulonew, 135, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, titulonew, -21, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, titulonew, 505, SpringLayout.WEST, this);
		add(titulonew);
		
	}
	
	/**
	 * Funcion que devuelve el nombre del tema
	 * @return String nombre del tema
	 */
	public String getNombreTema(){
		
		return this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado();
		
	}

	/**
	 * Funcion que devuelve el nombre de los apuntes seleccionados
	 * @return String nombre de los apuntes
	 */
	public String getNombreApunteSeleccionado(){
		if(this.listaapuntes.getSelectedValue() == null){
			return "";
		}else if(this.listaapuntes.getSelectedValue() != null && (this.listaejercicios.getSelectedValue()!=null || this.listasubtemas.getSelectedValue()!=null)){
			return "varios";
		}else{
			return this.listaapuntes.getSelectedValue();
		}
	}
	
	/**
	 * Funcion que devuelve el nombre del ejercicio seleccionado
	 * @return String nombre del ejercicio
	 */
	public String getNombreEjercicioSeleccionado(){
		
		if(this.listaejercicios.getSelectedValue() == null){
			return "";
		}else if(this.listaejercicios.getSelectedValue() != null && (this.listaapuntes.getSelectedValue()!=null || this.listasubtemas.getSelectedValue()!=null)){
			return "varios";
		}else{
			return this.listaejercicios.getSelectedValue();
		}
		
	}
	
	/**
	 * Funcion que devuelve el nombre del subtema seleccionado
	 * @return String nombre del subtema
	 */
	public String getNombreSubtemaSeleccionado(){

		if(this.listasubtemas.getSelectedValue() == null){
			return "";
		}else if(this.listasubtemas.getSelectedValue() != null && (this.listaapuntes.getSelectedValue()!=null || this.listaejercicios.getSelectedValue()!=null)){
			return "varios";
		}else{
			return this.listasubtemas.getSelectedValue();
		}
		
	}
	
	/**
	 * Funcion que devuelve el panel del profesor
	 * @return PanelProfesor Panel del profesor
	 */
	public PanelProfesor getPanelProf(){
		return this.contenedorProf;
	}
	
	/**
	 * Funcion que devuelve la eleccion del profesor sobre la visibilidad del tema
	 * @return boolean true si esta visible , false si no lo esta
	 */
	public boolean comprobarSeleccion(){
		 
		 if(visible.isSelected()){
			 return true;
		 }else {
			 return false;
		 } 
	 }
	
	/**
	 * Funcion que actualiza el tema despues de ser editado o cuando se accede a el
	 * @throws ClassNotFoundException
	 * @throws InvalidEmailAddressException
	 * @throws FailedInternetConnectionException
	 * @throws IOException
	 */
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
		
		if(!this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado().equals("") ){
			tem = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado()).getTemas();
			apun = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado()).getApuntes();
			ej = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado()).getEjercicios();
			
			if(!this.titulonew.getText().isEmpty()){
				this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado()).setVisibilidad(this.comprobarSeleccion());
				this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdAsig().getNombreTemaSeleccionado()).setNombre(this.titulonew.getText());
			}
		}
		
		else{
			tem = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).getTemas();
			apun = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).getApuntes();
			ej = this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).getEjercicios();
			
			if(!this.titulonew.getText().isEmpty()){
				this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).setVisibilidad(this.comprobarSeleccion());
				this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).setNombre(this.titulonew.getText());
				
			}
		}
		
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
	
	/**
	 * Funcion que asigna los controladores a los distintos botones
	 * @param c el controlador correspondiente
	 * @param nombre nombre del boton
	 */
	public void setControlador(ActionListener c,String nombre){
		if(nombre.equals("anyadir")){
			this.anyadir.addActionListener(c);
		}else if(nombre.equals("editar")){
			this.editar.addActionListener(c);
		}else if(nombre.equals("eliminar")){
			this.eliminar.addActionListener(c);
		}else if(nombre.equals("guardar")){
			this.guardar.addActionListener(c);
		}
	}
}
