package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelAsignaturas;
import InterfazGrafica.VentanaInicial;

public class ControladorAccederAsignatura  implements ActionListener {
	private VentanaInicial ventana;
	private PanelAsignaturas panel;
	
	/**
	 * Constructor de la clase ControladorInicioSesion
	 * @param sist Sistema (eCourses)
	 * @param pan Panel asociado al controlador
	 */
	public ControladorAccederAsignatura(VentanaInicial vent, PanelAsignaturas pan){
	
		this.ventana = vent;
		this.panel = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	int i;
	boolean exist = false;
	
		
			
			if (panel.getNombre().equals("")) {
				 JOptionPane.showMessageDialog(panel, "Debe seleccionar una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			if (panel.getNombre().equals("asignatura")) {
				 JOptionPane.showMessageDialog(panel, "NOOOOOMBRE BIEEEN", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			for(i=0;i<ventana.getSistema().getAsignaturas().size();i++){
				if(ventana.getSistema().getAsignaturas().get(i).equals(panel.getNombre())){
					exist = true;
				}
			}
			
			if(!exist){
				 JOptionPane.showMessageDialog(panel, "Esa asignatura no existe", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			if(e.getActionCommand().equals("AccederAsig")){
				if(panel.getPanelProfesor()!=null){
					panel.getPanelProfesor().getPanelContenido().cambiarCarta("AccederAsig");	
				}else{
					panel.getPanelAlumno().getPanelContenido().cambiarCarta("AccederAsig");	
				}
			}
			
		
		
	
	}

}
