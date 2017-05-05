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
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.UIManager;

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
	private Component rigidArea;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private Component rigidArea_4;
	private Component rigidArea_5;
		
	PanelMatricula(PanelAlumno cont){
		
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.contAl = cont;
		
		this.modelopen.addElement("No existe una asignatura pendiente de matricular");
		this.modeloasign.addElement("No existe ninguna asignatura");
		this.modelomat.addElement("No existe ninguna asignatura matriculada");
		
		this.asignAsignaturas = new JList<String>(modeloasign);
		this.asignMatriculas = new JList<String>(modelomat);
		this.asignPendientes = new JList<String>(modelopen);
		
		JLabel nombre = new JLabel("Introduzca el nombre de la asignatura que desea matricularse: ");
		nombre.setFont(new Font("WenQuanYi Micro Hei Mono", Font.BOLD, 13));
		this.nombreAsig = new JTextField(30);
		
		ControladorMatricula controlador = new ControladorMatricula(this.contAl.getVentana(),this);
		
		
		rigidArea = Box.createRigidArea(new Dimension(0, 50));
		add(rigidArea);
		
		this.add(nombre);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(0, 20));
		add(rigidArea_1);
		this.add(nombreAsig);
		
		rigidArea_2 = Box.createRigidArea(new Dimension(100, 30));
		add(rigidArea_2);
		
		this.boton = new JButton("Solicitar");
		boton.setFont(new Font("WenQuanYi Micro Hei Mono", Font.BOLD, 12));
		this.setControlador(controlador);
		this.add(boton);
		
		
		rigidArea_3 = Box.createRigidArea(new Dimension(0, 70));
		add(rigidArea_3);
		this.add(asignAsignaturas);
		
		rigidArea_4 = Box.createRigidArea(new Dimension(20, 0));
		add(rigidArea_4);
		this.add(asignMatriculas);
		
		rigidArea_5 = Box.createRigidArea(new Dimension(20, 0));
		add(rigidArea_5);
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
