package Controladores;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelCrearApuntes;
import InterfazGrafica.PanelCrearAsignatura;
import InterfazGrafica.PanelCrearEjercicio;
import InterfazGrafica.PanelCrearSubtema;
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
	private PanelCrearSubtema panelsubtema;
	private PanelCrearEjercicio panelejercicio;
	
	/**
	 * Constructor para la clase PanelCrearAsignatura
	 * @param vent Ventana asociada al panel
	 * @param pan Panel crear asignatura
	 */
	public ControladorAgregarContenido(VentanaInicial vent, PanelCrearAsignatura pan){
	
		this.ventana = vent;
		this.panelasig = pan;
		
	}
	
	/**
	 * Constructor para la clase PanelCrearTema
	 * @param vent Ventana asociada al panel
	 * @param pan Panel crear tema
	 */
	public ControladorAgregarContenido(VentanaInicial vent, PanelCrearTema pan){
		
		this.ventana = vent;
		this.paneltema = pan;
		
	}
	
	/**
	 * Constructor para la clase PanelCrearApuntes
	 * @param vent Ventana asociada al panel
	 * @param pan Panel crear apuntes
	 */
	public ControladorAgregarContenido(VentanaInicial vent, PanelCrearApuntes pan){
		
		this.ventana = vent;
		this.panelapuntes = pan;
		
	}
	
	/**
	 * Constructor para la clase PanelCrearSubtema
	 * @param vent Ventana asociada al panel
	 * @param pan Panel crear subtema
	 */
	public ControladorAgregarContenido(VentanaInicial vent, PanelCrearSubtema pan){
		
		this.ventana = vent;
		this.panelsubtema = pan;
		
	}
	
	/**
	 * Constructor para la clase PanelCrearEjercicio
	 * @param vent Ventana asociada al panel
	 * @param pan Panel crear subtema
	 */
	public ControladorAgregarContenido(VentanaInicial vent, PanelCrearEjercicio pan){
		
		this.ventana = vent;
		this.panelejercicio = pan;
		
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
			 
			 
		 }else if(e.getActionCommand().equals("Crear Apuntes")){
			 
			 if (panelapuntes.getNombreApuntes().equals("")) {
				 JOptionPane.showMessageDialog(panelapuntes, "Debe introducir un nombre para los apuntes", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }else if (panelapuntes.getContenidoApuntes().equals("")) {
				 JOptionPane.showMessageDialog(panelapuntes, "Debe introducir contenido para los apuntes", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }
			
			 try {
				if(ventana.getSistema().agregarApuntes(panelapuntes.getContenedor().getContenedorProf().getVentana().getSistema().getTema(panelapuntes.getNombreTema()), panelapuntes.getContenidoApuntes(), panelapuntes.getDia(), panelapuntes.getMes(), panelapuntes.getAnyo(), panelapuntes.comprobarSeleccion(), panelapuntes.getNombreApuntes()) == false){
					 JOptionPane.showMessageDialog(panelapuntes, "Error al crear los apuntes", "Error", JOptionPane.ERROR_MESSAGE);
					 return;
				 }else{
					 JOptionPane.showMessageDialog(panelapuntes, "Los apuntes " + panelapuntes.getNombreApuntes() + " han sido creados", "Crear apuntes", JOptionPane.INFORMATION_MESSAGE);
					 return;
				 }
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (InvalidEmailAddressException e1) {
				e1.printStackTrace();
			} catch (FailedInternetConnectionException e1) {
				e1.printStackTrace();
			}
			 
			 
		 }else if(e.getActionCommand().equals("Crear subtema")){
			 
			 if (panelsubtema.getNombreSubtema().equals("")) {
				 JOptionPane.showMessageDialog(panelsubtema, "Debe introducir un nombre para el subtema", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }
			
			 try {
				if(ventana.getSistema().agregarSubtema(panelsubtema.getNombreSubtema(), panelsubtema.getContenedor().getContenedorProf().getVentana().getSistema().getTema(panelsubtema.getNombreTema()), panelsubtema.comprobarSeleccion()) == false){
					 JOptionPane.showMessageDialog(panelsubtema, "Error al crear el subtema", "Error", JOptionPane.ERROR_MESSAGE);
					 return;
				 }else{
					 JOptionPane.showMessageDialog(panelsubtema, "El subtema " + panelsubtema.getNombreSubtema() + " ha sido creado", "Crear subtema", JOptionPane.INFORMATION_MESSAGE);
					 return;
				 }
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (InvalidEmailAddressException e1) {
				e1.printStackTrace();
			} catch (FailedInternetConnectionException e1) {
				e1.printStackTrace();
			}
			 
			 
		 }else if(e.getActionCommand().equals("Crear ejercicio")){
			 
			 if(panelejercicio.getNombreEjercicio().equals("")){
				 JOptionPane.showMessageDialog(panelejercicio, "Debe introducir un enunciado para el ejercicio", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }
			 
			 // Crear el ejercicio (con todas sus preguntas ya añadidas)
			 
		 }
		
		
	}
	
}