package InterfazGrafica;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Asignatura.Asignatura;
import Controladores.ControladorMatricula;
import eCourses.SolicitudMatricula;

public class PanelMatricula extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private PanelAlumno contAl;
	private JButton boton;
	private DefaultListModel<String> modeloasign = new DefaultListModel<String>(); 
	private DefaultListModel<String> modelomat = new DefaultListModel<String>(); 
	private DefaultListModel<String> modelopen = new DefaultListModel<String>(); 
	private JList<String> asignAsignaturas;
	private JList<String> asignMatriculas;
	private JList<String> asignPendientes;
	private JTextField nombreAsig;
		
	PanelMatricula(PanelAlumno cont){
	
		
		this.contAl = cont;
		
		this.modelopen.addElement("No existe una asignatura pendiente de matricular");
		this.modeloasign.addElement("No existe ninguna asignatura");
		this.modelomat.addElement("No existe ninguna asignatura matriculada");
		
		this.asignAsignaturas = new JList<String>(modeloasign);
		this.asignMatriculas = new JList<String>(modelomat);
		this.asignPendientes = new JList<String>(modelopen);
		
		JLabel nombre = new JLabel("Introduzca el nombre de la asignatura que desea matricularse: ");
		this.nombreAsig = new JTextField(30);
		
		ControladorMatricula controlador = new ControladorMatricula(this.contAl.getVentana(),this);
		
		this.boton = new JButton("Solicitar");
		this.setControlador(controlador);
		this.add(boton);
		
		this.add(nombre);
		this.add(nombreAsig);
		this.add(asignAsignaturas);
		this.add(asignMatriculas);
		this.add(asignPendientes);
	}
	
	 public void setControlador(ActionListener c) {
		 boton.addActionListener(c);
	 }
		
	public JList<String> getListaAsignaturas(){
		return this.asignAsignaturas;
	}
		
	public JList<String> getListaMatriculadas(){
		return this.asignMatriculas;
	}
		
	public JList<String> getListaPendientes(){
		return this.asignPendientes;
	}
	
	public PanelAlumno getPanelAlumno(){
		return this.contAl;
	}
	
	public String getNombre(){
		return this.nombreAsig.getText();
	}
	
	public void realizarSolicitud(){
		this.contAl.getVentana().getSistema().getAlumnoLog().agregarSolicitud(new SolicitudMatricula(this.contAl.getVentana().getSistema().getAlumnoLog(),this.contAl.getVentana().getSistema().getAsignatura(this.nombreAsig.getText()),false));
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
