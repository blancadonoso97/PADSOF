package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelAsignatura;
import InterfazGrafica.PanelPrincipal;
import InterfazGrafica.VentanaInicial;

public class ControladorAccederContenido  implements ActionListener {
	private VentanaInicial ventana;
	private PanelPrincipal panelp;
	private PanelAsignatura panela;
	
	/**
	 * Constructor de la clase ControladorInicioSesion
	 * @param sist Sistema (eCourses)
	 * @param pan Panel asociado al controlador
	 */
	public ControladorAccederContenido(VentanaInicial vent, PanelPrincipal pan){
	
		this.ventana = vent;
		this.panelp = pan;
		
	}
	
	public ControladorAccederContenido(VentanaInicial vent, PanelAsignatura pan){
		
		this.ventana = vent;
		this.panela = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	int i;
	boolean exist = false;
	
		
			
			if (panelp.getNombre().equals("")) {
				 JOptionPane.showMessageDialog(panelp, "Debe seleccionar una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			
			for(i=0;i<ventana.getSistema().getAsignaturas().size();i++){
				if(ventana.getSistema().getAsignaturas().get(i).getNombre().equals(panelp.getNombre())){
					exist = true;
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

}
