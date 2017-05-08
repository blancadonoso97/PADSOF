package Controladores;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Examen.Opcion;
import Examen.Pregunta;
import Examen.PreguntaMultiple;
import Examen.PreguntaRedactar;
import Examen.PreguntaTest;
import InterfazGrafica.PanelCrearOpcion;
import InterfazGrafica.PanelCrearPreguntaMultiple;
import InterfazGrafica.PanelCrearPreguntaRedactar;
import InterfazGrafica.PanelCrearPreguntaTest;
import InterfazGrafica.VentanaInicial;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase que implementa el controlador de los botones de crear una pregunta
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class ControladorCrearPregunta implements ActionListener{

	private VentanaInicial ventana;
	
	private PanelCrearPreguntaRedactar panelpreguntaredactar;
	private PanelCrearPreguntaTest panelpreguntatest;
	private PanelCrearPreguntaMultiple panelpreguntamultiple;
	private PanelCrearOpcion opcion;
	
	/**
	 * Constructor para la clase PanelCrearPreguntaRedactar
	 * 
	 * @param vent
	 *            Ventana asociada al panel
	 * @param pan
	 *            Panel crear pregunta redactar
	 */
	public ControladorCrearPregunta(VentanaInicial vent, PanelCrearPreguntaRedactar pan) {

		this.ventana = vent;
		this.panelpreguntaredactar = pan;

	}

	/**
	 * Constructor para la clase PanelCrearPreguntaTest
	 * 
	 * @param vent
	 *            Ventana asociada al panel
	 * @param pan
	 *            Panel crear pregunta test
	 */
	public ControladorCrearPregunta(VentanaInicial vent, PanelCrearPreguntaTest pan) {

		this.ventana = vent;
		this.panelpreguntatest = pan;

	}

	/**
	 * Constructor para la clase PanelCrearPreguntaMultiple
	 * 
	 * @param vent
	 *            Ventana asociada al panel
	 * @param pan
	 *            Panel crear pregunta multiple
	 */
	public ControladorCrearPregunta(VentanaInicial vent, PanelCrearPreguntaMultiple pan) {

		this.ventana = vent;
		this.panelpreguntamultiple = pan;

	}
	
	/**
	 * Constructor para la clase PanelCrearOpcion
	 * @param vent Ventana asociada al panel
	 * @param pan Panel crear opcion
	 */
	public ControladorCrearPregunta(VentanaInicial vent, PanelCrearOpcion pan){
		
		this.ventana = vent;
		this.opcion = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Crear pregunta redactar")) {

			if(ventana.getSistema().getEsProfesor()){
				
				Pregunta pregunta = new PreguntaRedactar(panelpreguntaredactar.getEnunciado(),  panelpreguntaredactar.getSuma() , panelpreguntaredactar.getResta(), panelpreguntaredactar.getEjercicio(), new ArrayList<Opcion>());
				
				panelpreguntaredactar.getEjercicio().AgregarPregunta(pregunta);
				
				panelpreguntaredactar.setPregunta(pregunta);
				
				JOptionPane.showMessageDialog(panelpreguntaredactar, "La pregunta ha sido creada", "Crear pregunta", JOptionPane.INFORMATION_MESSAGE);
				return;
				
				
			}
			
			

		} else if (e.getActionCommand().equals("Crear pregunta test")) {

			if(ventana.getSistema().getEsProfesor()){
				
				Pregunta pregunta = new PreguntaTest(panelpreguntatest.getEnunciado(), panelpreguntatest.getSuma() ,  panelpreguntatest.getResta(), panelpreguntatest.getEjercicio(), new ArrayList<Opcion>());
				
				panelpreguntatest.getEjercicio().AgregarPregunta(pregunta);
				
				panelpreguntatest.setPregunta(pregunta);
				
				JOptionPane.showMessageDialog(panelpreguntatest, "La pregunta ha sido creada", "Crear pregunta", JOptionPane.INFORMATION_MESSAGE);
				return;
				
				
			}
			
			

		} else if (e.getActionCommand().equals("Crear pregunta multiple")) {

			if(ventana.getSistema().getEsProfesor()){
				
				Pregunta pregunta = new PreguntaMultiple(panelpreguntamultiple.getEnunciado(), panelpreguntamultiple.getSuma() , panelpreguntamultiple.getResta(), panelpreguntamultiple.getEjercicio(), new ArrayList<Opcion>());
				
				panelpreguntamultiple.getEjercicio().AgregarPregunta(pregunta);
				
				panelpreguntamultiple.setPregunta(pregunta);
				
				JOptionPane.showMessageDialog(panelpreguntamultiple, "La pregunta ha sido creada", "Crear pregunta", JOptionPane.INFORMATION_MESSAGE);
				return;
				
				
			}
			
			

		}else if (e.getActionCommand().equals("Volver")){
			
			
			try {
				ventana.getPanelProfesor().getPanelContenido().cambiarCarta("Ejercicio");
			} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
					| IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}else if (e.getActionCommand().equals("Crear nueva opcion")){
			
			try {
				ventana.getPanelProfesor().getPanelContenido().cambiarCarta("Opcion");
			} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
					| IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else if (e.getActionCommand().equals("Crear opcion")){
			
			if(opcion.getPregunta().anyadirOpcion(new Opcion(opcion.getEnunciado(), opcion.comprobarSeleccion(), opcion.getPregunta())) == false){
				
				JOptionPane.showMessageDialog(opcion, "Error al crear la opcion", "Error", JOptionPane.ERROR_MESSAGE);
				return;
				
			}else{
				JOptionPane.showMessageDialog(panelpreguntamultiple, "La opcion ha sido creada", "Crear opcion", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			
			
		}
		
	}

	
	
}

