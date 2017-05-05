package Controladores;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelCrearApuntes;
import InterfazGrafica.PanelCrearAsignatura;
import InterfazGrafica.PanelCrearTema;
import InterfazGrafica.VentanaInicial;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase para definir el controlador del boton Crear Asignatura -> (PanelCrearAsignatura)
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class ControladorAgregarContenido implements ActionListener{

	private VentanaInicial ventana;
	private PanelCrearAsignatura panelasig;
	private PanelCrearTema paneltema;
	private PanelCrearApuntes panelapuntes;
	
	/**
	 * Constructor de la clase ControladorAgregarAsignatura
	 * @param vent Ventana asociada al panel
	 * @param pan Panel crear asignatura
	 */
	public ControladorAgregarContenido(VentanaInicial vent, PanelCrearAsignatura pan){
	
		this.ventana = vent;
		this.panelasig = pan;
		
	}
	
	/**
	 * Constructor de la clase ControladorAgregarAsignatura
	 * @param vent Ventana asociada al panel
	 * @param pan Panel crear tema
	 */
	public ControladorAgregarContenido(VentanaInicial vent, PanelCrearTema pan){
		
		this.ventana = vent;
		this.paneltema = pan;
		
	}
	
	/**
	 * Constructor de la clase ControladorAgregarAsignatura
	 * @param vent Ventana asociada al panel
	 * @param pan Panel crear apuntes
	 */
	public ControladorAgregarContenido(VentanaInicial vent, PanelCrearApuntes pan){
		
		this.ventana = vent;
		this.panelapuntes = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		 if(e.getActionCommand().equals("Crear asignatura")){
			 
			 if (panelasig.getNombreAsig().equals("")) {
				 JOptionPane.showMessageDialog(panelasig, "Debe introducir un nombre para la asignatura", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }
			
			 try {
				if(ventana.getSistema().agregarAsignatura(panelasig.getNombreAsig(), panelasig.comprobarSeleccion()) == false){
					 JOptionPane.showMessageDialog(panelasig, "Error al crear la asignatura", "Error", JOptionPane.ERROR_MESSAGE);
					 return;
				 }else{
					 JOptionPane.showMessageDialog(panelasig, "La asignatura " + panelasig.getNombreAsig() + " ha sido creada", "Crear asignatura", JOptionPane.INFORMATION_MESSAGE);
					 return;
				 }
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (InvalidEmailAddressException e1) {
				e1.printStackTrace();
			} catch (FailedInternetConnectionException e1) {
				e1.printStackTrace();
			}
			 
		 }else if(e.getActionCommand().equals("Crear tema")){
			 
			 if (paneltema.getNombreTema().equals("")) {
				 JOptionPane.showMessageDialog(paneltema, "Debe introducir un nombre para el tema", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }
			
			 try {
				if(ventana.getSistema().agregarTema(paneltema.getNombreTema(), paneltema.getNombreAsignatura(), paneltema.comprobarSeleccion()) == false){
					 JOptionPane.showMessageDialog(paneltema, "Error al crear el tema", "Error", JOptionPane.ERROR_MESSAGE);
					 return;
				 }else{
					 JOptionPane.showMessageDialog(paneltema, "El tema " + paneltema.getNombreTema() + " ha sido creado", "Crear tema", JOptionPane.INFORMATION_MESSAGE);
					 return;
				 }
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (InvalidEmailAddressException e1) {
				e1.printStackTrace();
			} catch (FailedInternetConnectionException e1) {
				e1.printStackTrace();
			}
			 
			 
		 }else if(e.getActionCommand().equals("Crear apuntes")){
			 
			 if (paneltema.getNombreTema().equals("")) {
				 JOptionPane.showMessageDialog(paneltema, "Debe introducir un nombre para el tema", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }
			
			 try {
				if(ventana.getSistema().agregarTema(paneltema.getNombreTema(), paneltema.getNombreAsignatura(), paneltema.comprobarSeleccion()) == false){
					 JOptionPane.showMessageDialog(paneltema, "Error al crear el tema", "Error", JOptionPane.ERROR_MESSAGE);
					 return;
				 }else{
					 JOptionPane.showMessageDialog(paneltema, "El tema " + paneltema.getNombreTema() + " ha sido creado", "Crear tema", JOptionPane.INFORMATION_MESSAGE);
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
	
}