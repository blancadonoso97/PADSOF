package InterfazGrafica;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import Asignatura.Asignatura;
import eCourses.SolicitudMatricula;

public class PanelMatricula extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private PanelAlumno contAl;
	private JList<String> asignAsignaturas;
	private JList<String> asignMatriculas;
	private JList<String> asignPendientes;
		
	PanelMatricula(PanelAlumno cont){
	
		
		DefaultListModel<String> modeloasign = new DefaultListModel<String>(); 
		DefaultListModel<String> modelomat = new DefaultListModel<String>(); 
		DefaultListModel<String> modelopen = new DefaultListModel<String>(); 
		
		this.contAl = cont;
		
		modelopen.addElement("No existe una asignatura pendiente de matricular");
		modeloasign.addElement("No existe ninguna asignatura");
		modelomat.addElement("No existe ninguna asignatura matriculada");
		
		asignAsignaturas = new JList<String>(modeloasign);
		asignMatriculas = new JList<String>(modelomat);
		asignPendientes = new JList<String>(modelopen);
		
		this.add(asignAsignaturas);
		this.add(asignMatriculas);
		this.add(asignPendientes);
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
		
	public void actualizartablas(){
			
		DefaultListModel<String> modeloasign = new DefaultListModel<String>(); 
		DefaultListModel<String> modelomat = new DefaultListModel<String>(); 
		DefaultListModel<String> modelopen = new DefaultListModel<String>(); 
			
			ArrayList<SolicitudMatricula> solicitudes ;
			ArrayList<Asignatura> asignaturas;
			ArrayList<Asignatura> matriculadas;
			ArrayList<Asignatura> pendientes = new ArrayList<Asignatura>();
			
			
				
			solicitudes = this.contAl.getVentana().getSistema().getAlumnoLog().getSolicitudesMat();
			asignaturas = this.contAl.getVentana().getSistema().getAsignaturas();
			matriculadas = this.contAl.getVentana().getSistema().getAlumnoLog().getAsignaturas();
			
				
			if(solicitudes.isEmpty() == false){
			
				for(SolicitudMatricula s : solicitudes){
					pendientes.add(s.getAsignatura());
				}
					
		
				for(Asignatura a : pendientes){
					modelopen.addElement(a.getNombre());
				}
			}
		
			
			if(asignaturas.isEmpty() == false){
					
				for(Asignatura a : asignaturas){
					modeloasign.addElement(a.getNombre());
				}
					
			}
				
			if(matriculadas.isEmpty() == false){
					
				for(Asignatura a : matriculadas){
					modelomat.addElement(a.getNombre());
				}
				
			}
				 
			this.asignAsignaturas = new JList<String>(modeloasign);
			this.asignMatriculas = new JList<String>(modelomat);
			this.asignPendientes = new JList<String>(modelopen);
				
		return;
	}
		
		
}
