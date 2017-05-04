package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelMatricula;
import InterfazGrafica.VentanaInicial;

public class ControladorMatricula  implements ActionListener{

	private VentanaInicial ventana;
	private PanelMatricula panel;
	
	/**
	 * Constructor de la clase ControladorInicioSesion
	 * @param sist Sistema (eCourses)
	 * @param pan Panel asociado al controlador
	 */
	public ControladorMatricula(VentanaInicial vent, PanelMatricula pan){
	
		this.ventana = vent;
		this.panel = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	int i;
	boolean exist = false;
	
		if (panel.getNombre().equals("")) {
			 JOptionPane.showMessageDialog(panel, "Debe introducir una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		}
		
		for(i=0;i<panel.getListaAsignaturas().getModel().getSize();i++){
			if(panel.getListaAsignaturas().getModel().getElementAt(i).equals(panel.getNombre())){
				exist = true;
			}
		}
		
		if(!exist){
			 JOptionPane.showMessageDialog(panel, "Esa asignatura no existe", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		}
		
		if(e.getActionCommand().equals("Solicitar")){
			
			if(!ventana.getSistema().getEsProfesor()){
				panel.realizarSolicitud();
				panel.actualizartablas();
				panel.getPanelAlumno().getPanelContenido().cambiarCarta("Solicitud");
			}
			
		}
	}

	
	
}
