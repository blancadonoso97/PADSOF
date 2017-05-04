package InterfazGrafica;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Asignatura.Asignatura;
import eCourses.SolicitudMatricula;

public class PanelMatricula {
	
		private JList<String> asignAsignaturas;
		private JList<String> asignMatriculas;
		private JList<String> asignPendientes; 
		private PanelAlumno contAl;
		
		PanelMatricula(PanelAlumno cont){
		DefaultListModel<String> modeloasign = new DefaultListModel<String>(); 
		DefaultListModel<String> modelomat = new DefaultListModel<String>(); 
		DefaultListModel<String> modelopen = new DefaultListModel<String>(); 
		
		ArrayList<SolicitudMatricula> solicitud;
		ArrayList<Asignatura> asignaturas;
		ArrayList<Asignatura> matriculadas;
		ArrayList<Asignatura> pendientes = new ArrayList<Asignatura>();
		
		this.contAl = cont;
			
		solicitud = this.contAl.getVentana().getSistema().getAlumnoLog().getSolicitudesMat();
		asignaturas = this.contAl.getVentana().getSistema().getAsignaturas();
		matriculadas = this.contAl.getVentana().getSistema().getAlumnoLog().getAsignaturas();
		
		for(SolicitudMatricula s : solicitud){
			pendientes.add(s.getAsignatura());
		}
		
		for(Asignatura a : asignaturas){
			modeloasign.addElement(a.getNombre());
		}
		
		for(Asignatura a : matriculadas){
			modelomat.addElement(a.getNombre());
		}
		
		for(Asignatura a : pendientes){
			modelopen.addElement(a.getNombre());
		}
		 
		this.asignAsignaturas = new JList<String>(modeloasign);
		 
		this.asignMatriculas = new JList<String>(modelomat);
	 
		this.asignPendientes = new JList<String>(modelopen);
		
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
		
		
		
}
