package InterfazGrafica;

import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import Asignatura.Asignatura;
import Controladores.ControladorMatricula;
import eCourses.SolicitudMatricula;
import javax.swing.UIManager;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 * Clase que implementa el panel de la matricula
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelMatricula extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private PanelAlumno contenedorAlum;
	
	private DefaultListModel<String> modelopen = new DefaultListModel<String>(); 
	private DefaultListModel<String> modeloasign = new DefaultListModel<String>(); 
	private DefaultListModel<String> modelomat = new DefaultListModel<String>(); 
	
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	
	private JList<String> listasignaturas;
	private JList<String> listmatriculadas;
	private JList<String> listpendientes;
	
	private JButton boton;
	
	/**
	 * Constructor que implementa la interfaz grafica del panel para solicitud matricula 
	 * @param cont Panel del contenido
	 */
	public PanelMatricula(PanelAlumno cont){
		
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		this.contenedorAlum = cont;
		
		ControladorMatricula controlador = new ControladorMatricula(this.contenedorAlum.getVentana(),this);
	
		this.boton = new JButton("Solicitar");
		springLayout.putConstraint(SpringLayout.NORTH, boton, 532, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, boton, 328, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, boton, -352, SpringLayout.EAST, this);
		
		this.setControlador(controlador);
		this.add(boton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 140, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 105, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, -31, SpringLayout.NORTH, boton);
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, -95, SpringLayout.EAST, this);
		add(tabbedPane);
		
		
		scrollPane = new JScrollPane();
		tabbedPane.addTab("Asignaturas Totales", null, scrollPane, null);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 137, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 49, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -167, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 318, SpringLayout.WEST, this);
		
		listasignaturas = new JList<String>(modeloasign);
		scrollPane.setViewportView(listasignaturas);
		
		
		scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Asignaturas Matriculadas", null, scrollPane_1, null);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -180, SpringLayout.SOUTH, this);
		
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 56, SpringLayout.EAST, scrollPane);
		
		listmatriculadas = new JList<String>(modelomat);
		scrollPane_1.setViewportView(listmatriculadas);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 0, SpringLayout.NORTH, scrollPane_2);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -40, SpringLayout.WEST, scrollPane_2);
		
		
		scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("Asignaturas Pendientes", null, scrollPane_2, null);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_2, 188, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_2, 578, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_2, -180, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_2, -28, SpringLayout.EAST, this);
		
		
		listpendientes = new JList<String>(modelopen);
		scrollPane_2.setViewportView(listpendientes);
		
	}
	
	/**
	 * Funcion que modifica el controlador del boton
	 * @param c controlador elegido
	 */
	 public void setControlador(ActionListener c) {
		 boton.addActionListener(c);
	 }
		
	 /**
	  * Funcion que devuelve el JList de la lista de asignaturas
	  * @return lista de asignaturas totales
	  */
	public JList<String> getListaAsignaturas(){
		return this.listasignaturas;
	}
		
	/**
	 * Funcion que devuelve el JList de la lista de asignaturas matriculadas
	 * @return lista de asignaturas matriculadas
	 */
	public JList<String> getListaMatriculadas(){
		return this.listmatriculadas;
	}
		
	/**
	 * Funcion que devuelve el JList de la lista de asignaturas pendientes
	 * @return lista de asignaturas pendientes
	 */
	public JList<String> getListaPendientes(){
		return this.listpendientes;
	}
	
	/**
	 * Funcion que devuelve el panel del alumno
	 * @return panel del alumno
	 */
	public PanelAlumno getPanelAlumno(){
		return this.contenedorAlum;
	}
	
	/**
	 * Funcion que devuelve la asignatura elegida para soliticar una matricula
	 * @return nombre de la asignatura solicitada
	 */
	public String getNombre(){
		if(this.listasignaturas.getSelectedValue() == null){
			return "";
		}else if(this.listasignaturas.getSelectedValue() != null && (this.listmatriculadas.getSelectedValue()!=null || this.listpendientes.getSelectedValue() !=null)){
			return "varios";
		}else{
			return this.listasignaturas.getSelectedValue();
		}
	}
	

	/**
	 * Funcion que actualiza las tablas de todas diferentes listas
	 */
	public void actualizartablas(){
			 
			
		ArrayList<SolicitudMatricula> solicitudes;
		ArrayList<Asignatura> asignaturas;
		ArrayList<Asignatura> matriculadas;
		ArrayList<Asignatura> pendientes = new ArrayList<Asignatura>();
			
		solicitudes = this.contenedorAlum.getVentana().getSistema().getAlumnoLog().getSolicitudesMat();
		asignaturas = this.contenedorAlum.getVentana().getSistema().getAsignaturas();
		matriculadas = this.contenedorAlum.getVentana().getSistema().getAlumnoLog().getAsignaturas();
		
		modelopen.removeAllElements();
		modeloasign.removeAllElements();
		modelomat.removeAllElements();
		
		if(!solicitudes.isEmpty()){
			
			
			for(SolicitudMatricula s : solicitudes){
				pendientes.add(s.getAsignatura());
			}
					
			for(Asignatura a : pendientes){
				modelopen.addElement(a.getNombre());
			}
		}else{
			this.modelopen.addElement("No existe una asignatura pendiente de matricular");
			
		}
		
			
		if(!asignaturas.isEmpty()){
			
				
			for(Asignatura a : asignaturas){
				modeloasign.addElement(a.getNombre());
			}
					
		}else{
			this.modeloasign.addElement("No existe ninguna asignatura");
		}
				
		if(!matriculadas.isEmpty()){
			
				
			for(Asignatura a : matriculadas){
				modelomat.addElement(a.getNombre());
			}
			
				
		}else{
			this.modelomat.addElement("No existe ninguna asignatura matriculada");
		}
		
		
		return;
	}
}
