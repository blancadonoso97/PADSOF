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
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;

public class PanelMatricula extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private PanelAlumno contAl;
	private JButton boton;
	private DefaultListModel<String> modeloasign = new DefaultListModel<String>(); 
	private DefaultListModel<String> modelomat = new DefaultListModel<String>(); 
	private DefaultListModel<String> modelopen = new DefaultListModel<String>(); 
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JList<String> listasignaturas;
	private JList<String> listmatriculadas;
	private JList<String> listpendientes;
		
	PanelMatricula(PanelAlumno cont){
		
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.contAl = cont;
		
		this.modelopen.addElement("No existe una asignatura pendiente de matricular");
		this.modeloasign.addElement("No existe ninguna asignatura");
		this.modelomat.addElement("No existe ninguna asignatura matriculada");
		
		ControladorMatricula controlador = new ControladorMatricula(this.contAl.getVentana(),this);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		this.boton = new JButton("Solicitar");
		springLayout.putConstraint(SpringLayout.WEST, boton, 122, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, boton, -577, SpringLayout.EAST, this);
		boton.setFont(new Font("WenQuanYi Micro Hei Mono", Font.BOLD, 12));
		this.setControlador(controlador);
		this.add(boton);
		
		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, boton, 42, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 137, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -167, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 49, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 318, SpringLayout.WEST, this);
		add(scrollPane);
		
		scrollPane_1 = new JScrollPane();
		springLayout.putConstraint(SpringLayout.SOUTH, boton, 305, SpringLayout.NORTH, scrollPane_1);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 56, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -180, SpringLayout.SOUTH, this);
		
		listasignaturas = new JList<String>(modeloasign);
		scrollPane.setViewportView(listasignaturas);
		add(scrollPane_1);
		
		scrollPane_2 = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 0, SpringLayout.NORTH, scrollPane_2);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -40, SpringLayout.WEST, scrollPane_2);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_2, 578, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_2, -28, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_2, 188, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_2, -180, SpringLayout.SOUTH, this);
		
		listmatriculadas = new JList<String>(modelomat);
		scrollPane_1.setViewportView(listmatriculadas);
		add(scrollPane_2);
		
		listpendientes = new JList<String>(modelopen);
		scrollPane_2.setViewportView(listpendientes);
	}
	
	 public void setControlador(ActionListener c) {
		 boton.addActionListener(c);
	 }
		
	public JList<String> getListaAsignaturas(){
		return this.listasignaturas;
	}
		
	public JList<String> getListaMatriculadas(){
		return this.listmatriculadas;
	}
		
	public JList<String> getListaPendientes(){
		return this.listpendientes;
	}
	
	public PanelAlumno getPanelAlumno(){
		return this.contAl;
	}
	
	public String getNombre(){
		
		return this.contAl.getVentana().getSistema().getAsignatura(this.listasignaturas.getSelectedValue()).getNombre();
	}
	
	public void realizarSolicitud(){
		this.contAl.getVentana().getSistema().getAlumnoLog().agregarSolicitud(new SolicitudMatricula(this.contAl.getVentana().getSistema().getAlumnoLog(),this.contAl.getVentana().getSistema().getAsignatura(this.listasignaturas.getSelectedValue()),false));
		return ;
	}
	
	public void actualizartablas(){
			 
			
		ArrayList<SolicitudMatricula> solicitudes ;
		ArrayList<Asignatura> asignaturas;
		ArrayList<Asignatura> matriculadas;
		ArrayList<Asignatura> pendientes = new ArrayList<Asignatura>();
			
			
			
		solicitudes = this.contAl.getVentana().getSistema().getAlumnoLog().getSolicitudesMat();
		asignaturas = this.contAl.getVentana().getSistema().getAsignaturas();
		matriculadas = this.contAl.getVentana().getSistema().getAlumnoLog().getAsignaturas();
			
				
		if(!solicitudes.isEmpty()){
			modelopen.removeAllElements();
				
			for(SolicitudMatricula s : solicitudes){
				pendientes.add(s.getAsignatura());
			}
					
		
			for(Asignatura a : pendientes){
				modelopen.addElement(a.getNombre());
			}
		}
		
			
		if(!asignaturas.isEmpty()){
			modeloasign.removeAllElements();
				
			for(Asignatura a : asignaturas){
				modeloasign.addElement(a.getNombre());
			}
					
		}
				
		if(!matriculadas.isEmpty()){
			modelomat.removeAllElements();	
				
			for(Asignatura a : matriculadas){
				modelomat.addElement(a.getNombre());
			}
				
		}
	
		return;
	}
		
	
}
