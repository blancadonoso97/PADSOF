package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelCrearEjercicio;
import InterfazGrafica.PanelCrearPreguntaMultiple;
import InterfazGrafica.PanelCrearPreguntaRedactar;
import InterfazGrafica.PanelCrearPreguntaTest;
import InterfazGrafica.VentanaInicial;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ControladorCrearEjercicio implements ActionListener {

	private VentanaInicial ventana;

	private PanelCrearEjercicio panelejercicio;
	private PanelCrearPreguntaRedactar panelpreguntaredactar;
	private PanelCrearPreguntaTest panelpreguntatest;
	private PanelCrearPreguntaMultiple panelpreguntamultiple;

	/**
	 * Constructor para la clase PanelCrearEjercicio
	 * @param vent Ventana asociada al panel
	 * @param pan Panel crear ejercicio
	 */
	public ControladorCrearEjercicio(VentanaInicial vent, PanelCrearEjercicio pan){
		
		this.ventana = vent;
		this.panelejercicio = pan;
	}
	
	/**
	 * Constructor para la clase PanelCrearPreguntaRedactar
	 * 
	 * @param vent
	 *            Ventana asociada al panel
	 * @param pan
	 *            Panel crear pregunta redactar
	 */
	public ControladorCrearEjercicio(VentanaInicial vent, PanelCrearPreguntaRedactar pan) {

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
	public ControladorCrearEjercicio(VentanaInicial vent, PanelCrearPreguntaTest pan) {

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
	public ControladorCrearEjercicio(VentanaInicial vent, PanelCrearPreguntaMultiple pan) {

		this.ventana = vent;
		this.panelpreguntamultiple = pan;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Crear pregunta redactar")) {

			if (ventana.getSistema().getEsProfesor()) {

				try {
					panelpreguntaredactar.getPanelEjercicio().getContenido().cambiarCarta("Redactar");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panelpreguntaredactar.setEjercicio(panelpreguntaredactar.getPanelEjercicio().getEjercicio()); // Pasamos el ejercicio creado a la pregunta

			}

		} else if (e.getActionCommand().equals("Crear pregunta test")) {

			if (ventana.getSistema().getEsProfesor()) {

				try {
					panelpreguntatest.getPanelEjercicio().getContenido().cambiarCarta("Test");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panelpreguntatest.setEjercicio(panelpreguntatest.getPanelEjercicio().getEjercicio()); // Pasamos el ejercicio creado a la pregunta

			}

		} else if (e.getActionCommand().equals("Crear pregunta multiple")) {

			if (ventana.getSistema().getEsProfesor()) {

				try {
					panelpreguntamultiple.getPanelEjercicio().getContenido().cambiarCarta("Multiple");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panelpreguntamultiple.setEjercicio(panelpreguntamultiple.getPanelEjercicio().getEjercicio()); // Pasamos el ejercicio creado a la pregunta

			}

		}else if (e.getActionCommand().equals("Crear Ejercicio")){
			
			
			try {
				if(ventana.getSistema().agregarEjercicio(panelejercicio.getTema(), panelejercicio.comprobarSeleccion(), panelejercicio.getPeso(), panelejercicio.getDiaIni(), panelejercicio.getMesIni(), panelejercicio.getAnyoIni(), 
						panelejercicio.getDiaFin(), panelejercicio.getMesFin(), panelejercicio.getAnyoFin(), panelejercicio.getNombreEjercicio()) == false){
					
					JOptionPane.showMessageDialog(panelejercicio, "Error al crear el ejercicio", "Error", JOptionPane.ERROR_MESSAGE);
					 return;
				}else{
					
					panelejercicio.setEjercicio(panelejercicio.getTema().getEjercicio(panelejercicio.getNombreEjercicio())); // Set del ejercicio al panel de crear ejercicio
					
					JOptionPane.showMessageDialog(panelejercicio, "El ejercicio " + panelejercicio.getNombreEjercicio() + " ha sido creado", "Crear ejercicio", JOptionPane.INFORMATION_MESSAGE);
					 return;
				}
				
			} catch (InvalidEmailAddressException | FailedInternetConnectionException | ClassNotFoundException
					| IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}

	}

}
