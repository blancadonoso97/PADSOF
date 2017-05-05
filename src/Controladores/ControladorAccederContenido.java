package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelAsignatura;
import InterfazGrafica.PanelPrincipal;
import InterfazGrafica.PanelTema;

public class ControladorAccederContenido  implements ActionListener {

	private PanelPrincipal panelp;
	private PanelAsignatura panela;
	private PanelTema panelt;
	
	/**
	 * Constructor de la clase ControladorInicioSesion
	 * @param sist Sistema (eCourses)
	 * @param pan Panel asociado al controlador
	 */
	public ControladorAccederContenido(PanelPrincipal pan){
	
		this.panelp = pan;
		
	}
	
	public ControladorAccederContenido(PanelAsignatura pan){
		
		this.panela = pan;
		
	}
	
	public ControladorAccederContenido(PanelTema pan){
		
		this.panelt = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	int i;
	boolean exist = false;
	
		
		if(panelp != null){	
			
			if (panelp.getNombre().equals("")) {
				 JOptionPane.showMessageDialog(panelp, "Debe seleccionar una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			if(panelp.getPanelAlumno()!=null){
				
				for(i=0;i<panelp.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignaturas().size();i++){
					if(panelp.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignaturas().get(i).getNombre().equals(panelp.getNombre())){
						exist = true;
					}
				}
				
			}else{
				for(i=0;i<panelp.getPanelProfesor().getVentana().getSistema().getAsignaturas().size();i++){
					if(panelp.getPanelProfesor().getVentana().getSistema().getAsignaturas().get(i).getNombre().equals(panelp.getNombre())){
						exist = true;
					}
				}
			}
			
			
			if(!exist){
				 JOptionPane.showMessageDialog(panelp, "Esa asignatura no existe", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			
			if(panelp.getPanelProfesor()!=null){
				panelp.getPanelProfesor().getPanelContenido().cambiarCarta("AccederAsig");	
			}else{
				panelp.getPanelAlumno().getPanelContenido().cambiarCarta("AccederAsig");	
			}
		}
		
		else if(panela != null){
			
			if (panela.getNombre().equals("")) {
				 JOptionPane.showMessageDialog(panela, "Debe seleccionar una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			
			if(panela.getPanelAlumno()!=null){
				
				for(i=0;i<panela.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignatura(panela.getNombreAsig()).accederTema().size();i++){
					if(panela.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignatura(panela.getNombreAsig()).accederTema().get(i).getNombre().equals(panela.getNombre())){
						exist = true;
					}
				}
				
			}else{
				for(i=0;i<panela.getPanelProf().getVentana().getSistema().getAsignatura(panela.getNombreAsig()).accederTema().size();i++){
					if(panela.getPanelProf().getVentana().getSistema().getAsignatura(panela.getNombreAsig()).accederTema().get(i).getNombre().equals(panela.getNombre())){
						exist = true;
					}
				}
			}
			
			if(!exist){
				 JOptionPane.showMessageDialog(panela, "Ese tema no existe", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			
			if(panela.getPanelProf()!=null){
				panela.getPanelProf().getPanelContenido().cambiarCarta("AccederTem");	
			}else{
				panela.getPanelAlumno().getPanelContenido().cambiarCarta("AccederTem");	
			}
		}
			
		
			
			
		
	
	}

}
