package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import InterfazGrafica.PanelCrearAsignatura;
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
	 * Constructor de la clase ControladorCrearAsignatura
	 * @param vent Ventana asociada al panel
	 * @param pan Panel asociado al controlador
	 */
	public ControladorCrearAsignatura(VentanaInicial vent, PanelCrearAsignatura pan){
	
		this.ventana = vent;
		this.panel = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(ventana.getSistema().getEsProfesor()){
			panel.getContenedor().cambiarCarta("Asignatura");
		}
		
		
	}

	
	
	
}
