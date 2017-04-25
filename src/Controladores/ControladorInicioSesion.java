package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelInicioSesion;
import eCourses.Sistema;

/**
 * Clase para definir el controlador de la ventana Inicio Sesion
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class ControladorInicioSesion implements ActionListener{

	private Sistema sistema;
	private PanelInicioSesion panel;
	
	public ControladorInicioSesion(Sistema sist, PanelInicioSesion pan){
	
		this.sistema = sist;
		this.panel = pan;
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if (panel.getId().equals("")) {
			 JOptionPane.showMessageDialog(panel, "Debe introducir un nombre", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		
		 if(sistema.comprobarLogIn(panel.getId(), panel.getPass()) == false){
			 JOptionPane.showMessageDialog(panel, "Error al iniciar sesion", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		
		
		
		// En funcion de si es alumno o profesor mostrara una vista u otra
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
