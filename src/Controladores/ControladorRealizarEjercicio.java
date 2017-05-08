package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import InterfazGrafica.PanelEjercicio;

/**
 * Clase que define el controlador de los botones del panel de realizar un ejercicio
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class ControladorRealizarEjercicio  implements ActionListener {

	private PanelEjercicio panelej;
	
	/**
	 * Constructor de la clase ControladorRealizarEjercicio 
	 * @param cont panel del ejercicio
	 */
	public ControladorRealizarEjercicio (PanelEjercicio cont){
		
		this.panelej = cont;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	/**
	 * Devuelve el panel del ejercicio
	 * @return panelej
	 */
	public PanelEjercicio getPanelEjercicio(){
		return panelej;
	}
	
	
}
