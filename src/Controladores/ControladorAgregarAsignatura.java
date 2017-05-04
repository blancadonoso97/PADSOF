package Controladores;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelCrearAsignatura;
import InterfazGrafica.VentanaInicial;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase para definir el controlador del boton Crear Asignatura -> (PanelCrearAsignatura)
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class ControladorAgregarAsignatura implements ActionListener{

	private VentanaInicial ventana;
	private PanelCrearAsignatura panel;
	
	/**
	 * Constructor de la clase ControladorAgregarAsignatura
	 * @param vent Ventana asociada al panel
	 * @param pan Panel asociado al controlador
	 */
	public ControladorAgregarAsignatura(VentanaInicial vent, PanelCrearAsignatura pan){
	
		this.ventana = vent;
		this.panel = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (panel.getNombreAsig().equals("")) {
			 JOptionPane.showMessageDialog(panel, "Debe introducir un nombre para la asignatura", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		
		 try {
			if(ventana.getSistema().agregarAsignatura(panel.getNombreAsig(), panel.comprobarSeleccion()) == false){
				 JOptionPane.showMessageDialog(panel, "Error al crear la asignatura", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }else{
				 JOptionPane.showMessageDialog(panel, "La asignatura " + panel.getNombreAsig() + " ha sido creada", "Crear asignatura", JOptionPane.INFORMATION_MESSAGE);
				 return;
			 }
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (InvalidEmailAddressException e1) {
			e1.printStackTrace();
		} catch (FailedInternetConnectionException e1) {
			e1.printStackTrace();
		}
			 
		
	}
	
}