package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import InterfazGrafica.PanelEjercicio;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

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
		if(e.getActionCommand().equals("Realizar")){
			try {
				panelej.getPanelAlumno().getPanelContenido().cambiarCarta("RealizarEj");
			} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
					| IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Devuelve el panel del ejercicio
	 * @return panelej
	 */
	public PanelEjercicio getPanelEjercicio(){
		return panelej;
	}
	
	
}
