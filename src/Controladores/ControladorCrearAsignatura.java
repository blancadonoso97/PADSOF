package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelCrearAsignatura;
import InterfazGrafica.PanelInicioSesion;
import InterfazGrafica.VentanaInicial;


/**
 * Clase para definir el controlador del boton Crear Asignatura -> (PanelCrearAsignatura)
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class ControladorCrearAsignatura implements ActionListener{

	private VentanaInicial ventana;
	private PanelCrearAsignatura panel;
	
	/**
	 * Constructor de la clase ControladorInicioSesion
	 * @param sist Sistema (eCourses)
	 * @param pan Panel asociado al controlador
	 */
	public ControladorCrearAsignatura(VentanaInicial vent, PanelCrearAsignatura pan){
	
		this.ventana = vent;
		this.panel = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if (panel.getNombreAsig().equals("")) {
			 JOptionPane.showMessageDialog(panel, "Debe introducir un nombre para la asignatura", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		
		 if(ventana.getSistema().crearAsignatura(panel.getNombreAsig(), panel.getPass()) == false){
			 JOptionPane.showMessageDialog(panel, "Error al crear asignatura", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		 }else
			 JOptionPane.showMessageDialog(panel, "Asignatura creada correctamente", "Crear Asignatura", JOptionPane.OK_OPTION);
		 
		if(ventana.getSistema().getEsProfesor()){
			ventana.cambiarCarta("Profesor");
		}else if(ventana.getSistema().getEsProfesor() == false && ventana.getSistema().getLogIn()){
			ventana.cambiarCarta("Alumno");
		}
		
		
		
	}

	
	
	
}
