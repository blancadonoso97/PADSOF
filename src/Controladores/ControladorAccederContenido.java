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
			
			if (panelp.getNombreAsignaturaSeleccionada().equals("")) {
				 JOptionPane.showMessageDialog(panelp, "Debe seleccionar una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			if(panelp.getPanelAlumno()!=null){
				
				for(i=0;i<panelp.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignaturas().size();i++){
					if(panelp.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignaturas().get(i).getNombre().equals(panelp.getNombreAsignaturaSeleccionada())){
						exist = true;
					}
				}
				
			}else{
				for(i=0;i<panelp.getPanelProfesor().getVentana().getSistema().getAsignaturas().size();i++){
					if(panelp.getPanelProfesor().getVentana().getSistema().getAsignaturas().get(i).getNombre().equals(panelp.getNombreAsignaturaSeleccionada())){
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
			
			if (panela.getNombreTemaSeleccionado().equals("")) {
				 JOptionPane.showMessageDialog(panela, "Debe seleccionar una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			
			if(panela.getPanelAlumno()!=null){
				
				for(i=0;i<panela.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignatura(panela.getNombreAsignatura()).getTemas().size();i++){
					if(panela.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignatura(panela.getNombreAsignatura()).getTemas().get(i).getNombre().equals(panela.getNombreTemaSeleccionado())){
						exist = true;
					}
				}
				
			}else{
				for(i=0;i<panela.getPanelProf().getVentana().getSistema().getAsignatura(panela.getNombreAsignatura()).getTemas().size();i++){
					if(panela.getPanelProf().getVentana().getSistema().getAsignatura(panela.getNombreAsignatura()).getTemas().get(i).getNombre().equals(panela.getNombreTemaSeleccionado())){
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
		
		else if(panelt != null){
			
			if (panelt.getNombreApunteSeleccionado().equals("") && panelt.getNombreEjercicioSeleccionado().equals("") && panelt.getNombreSubtemaSeleccionado().equals("")) {
				 JOptionPane.showMessageDialog(panelt, "Debe seleccionar a que quiere acceder del tema", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			if (panelt.getNombreApunteSeleccionado().equals("varios") || panelt.getNombreEjercicioSeleccionado().equals("varios") || panelt.getNombreSubtemaSeleccionado().equals("varios")){
				 JOptionPane.showMessageDialog(panelt, "Debe seleccionar solo un contenido al que quiera acceder", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			
			
			if(!panelt.getNombreApunteSeleccionado().equals("") && !panelt.getNombreApunteSeleccionado().equals("varios")){
				
			
				 
				if(panelt.getPanelAlumno()!=null){
					
					for(i=0;i<panelt.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignatura(panelt.getPanelAlumno().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getNApuntes();i++){
						
						if(panelt.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignatura(panelt.getPanelAlumno().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getApuntes().get(i).getTitulo().equals(panelt.getNombreApunteSeleccionado())){
							exist = true;
						}
					}
					
				}else{
					for(i=0;i<panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getNApuntes();i++){
						if(panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getApuntes().get(i).getTitulo().equals(panelt.getNombreApunteSeleccionado())){
							exist = true;
						}
					}
				}
				
				if(!exist){
					 JOptionPane.showMessageDialog(panelt, "Lo que ha seleccionado no existe", "Error", JOptionPane.ERROR_MESSAGE);
					 return;
				}
				
				
				if(panelt.getPanelProf()!=null){
					panelt.getPanelProf().getPanelContenido().cambiarCarta("AccederApunte");	
				}else{
					panelt.getPanelAlumno().getPanelContenido().cambiarCarta("AccederApunte");	
				}
				
				
				
				
			}
			
			else if(!panelt.getNombreSubtemaSeleccionado().equals("") && !panelt.getNombreSubtemaSeleccionado().equals("varios")){
				
				
				if(panelt.getPanelAlumno()!=null){
					
					for(i=0;i<panelt.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignatura(panelt.getPanelAlumno().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getTemas().size();i++){
						
						if(panelt.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignatura(panelt.getPanelAlumno().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getTemas().get(i).getNombre().equals(panelt.getNombreSubtemaSeleccionado())){
							exist = true;
						}
					}
					
				}else{
					for(i=0;i<panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getTemas().size();i++){
						if(panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getTemas().get(i).getNombre().equals(panelt.getNombreSubtemaSeleccionado())){
							exist = true;
						}
					}
				}
				
				if(!exist){
					 JOptionPane.showMessageDialog(panelt, "Lo que ha seleccionado no existe", "Error", JOptionPane.ERROR_MESSAGE);
					 return;
				}
				
				
				if(panelt.getPanelProf()!=null){
					panelt.getPanelProf().getPanelContenido().cambiarCarta("AccederTem");	
				}else{
					panelt.getPanelAlumno().getPanelContenido().cambiarCarta("AccederTem");	
				}
				
				
				
				
			}
			
			else if(!panelt.getNombreEjercicioSeleccionado().equals("") && !panelt.getNombreEjercicioSeleccionado().equals("varios")){
				
			
				 
				if(panelt.getPanelAlumno()!=null){
					
					for(i=0;i<panelt.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignatura(panelt.getPanelAlumno().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getNEjercicios();i++){
						
						if(panelt.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignatura(panelt.getPanelAlumno().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getEjercicios().get(i).getNombre().equals(panelt.getNombreEjercicioSeleccionado())){
							exist = true;
						}
					}
					
				}else{
					for(i=0;i<panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getNEjercicios();i++){
						if(panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(panelt.getNombreTema()).getEjercicios().get(i).getNombre().equals(panelt.getNombreEjercicioSeleccionado())){
							exist = true;
						}
					}
				}
				
				if(!exist){
					 JOptionPane.showMessageDialog(panelt, "Lo que ha seleccionado no existe", "Error", JOptionPane.ERROR_MESSAGE);
					 return;
				}
				
				
				if(panelt.getPanelProf()!=null){
					panelt.getPanelProf().getPanelContenido().cambiarCarta("AccederEj");	
				}else{
					panelt.getPanelAlumno().getPanelContenido().cambiarCarta("AccederEj");	
				}
				
				
			}
			
		}	
		
	
	}

}
