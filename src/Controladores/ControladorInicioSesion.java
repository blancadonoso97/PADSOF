package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import InterfazGrafica.VentanaInicial;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import InterfazGrafica.PanelInicioSesion;

/**
 * Clase para definir el controlador de la ventana Inicio Sesion
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class ControladorInicioSesion implements ActionListener{

	private VentanaInicial ventana;
	private PanelInicioSesion panel;
	
	/**
	 * Constructor de la clase ControladorInicioSesion
	 * @param sist Sistema (eCourses)
	 * @param pan Panel asociado al controlador
	 */
	public ControladorInicioSesion(VentanaInicial vent, PanelInicioSesion pan){
	
		this.ventana = vent;
		this.panel = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if (panel.getId().equals("")) {
			 JOptionPane.showMessageDialog(panel, "Debe introducir un nombre", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		
		 if(ventana.getSistema().comprobarLogIn(panel.getId(), panel.getPass()) == false){
			 JOptionPane.showMessageDialog(panel, "Error al iniciar sesion", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		 
		if(ventana.getSistema().getEsProfesor()){
			try {
				ventana.cambiarCarta("Profesor");
			} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
					| IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(ventana.getSistema().getEsProfesor() == false && ventana.getSistema().getLogIn()){
			try {
				ventana.cambiarCarta("Alumno");
			} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
					| IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
	}

	
}
