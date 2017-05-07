package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Examen.Pregunta;
import Examen.PreguntaMultiple;
import Examen.PreguntaRedactar;
import Examen.PreguntaTest;
import InterfazGrafica.PanelCrearPreguntaMultiple;
import InterfazGrafica.PanelCrearPreguntaRedactar;
import InterfazGrafica.PanelCrearPreguntaTest;
import InterfazGrafica.VentanaInicial;

public class ControladorCrearPregunta implements ActionListener{

	private VentanaInicial ventana;
	
	private PanelCrearPreguntaRedactar panelpreguntaredactar;
	private PanelCrearPreguntaTest panelpreguntatest;
	private PanelCrearPreguntaMultiple panelpreguntamultiple;
	
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Crear pregunta redactar")) {

			if(ventana.getSistema().getEsProfesor()){
				
				Pregunta pregunta = new PreguntaRedactar(panelpreguntaredactar.getEnunciado(), 0 , 0, panelpreguntaredactar.getEjercicio(), null);
				
				panelpreguntaredactar.getEjercicio().AgregarPregunta(pregunta);
				
				panelpreguntaredactar.setPregunta(pregunta);
				
				
			}
			
			

		} else if (e.getActionCommand().equals("Crear pregunta test")) {

			if(ventana.getSistema().getEsProfesor()){
				
				Pregunta pregunta = new PreguntaTest(panelpreguntatest.getEnunciado(), 0 , 0, panelpreguntatest.getEjercicio(), null);
				
				panelpreguntatest.getEjercicio().AgregarPregunta(pregunta);
				
				panelpreguntatest.setPregunta(pregunta);
				
				
			}
			
			

		} else if (e.getActionCommand().equals("Crear pregunta multiple")) {

			if(ventana.getSistema().getEsProfesor()){
				
				Pregunta pregunta = new PreguntaMultiple(panelpreguntamultiple.getEnunciado(), 0 , 0, panelpreguntamultiple.getEjercicio(), null);
				
				panelpreguntamultiple.getEjercicio().AgregarPregunta(pregunta);
				
				panelpreguntamultiple.setPregunta(pregunta);
				
				
			}
			
			

		}
		
	}

	
	
	
	
	
	
	
	
}

