package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import InterfazGrafica.PanelCrearPreguntaMultiple;
import InterfazGrafica.PanelCrearPreguntaRedactar;
import InterfazGrafica.PanelCrearPreguntaTest;
import InterfazGrafica.VentanaInicial;

public class ControladorCrearEjercicio implements ActionListener {

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

				panelpreguntaredactar.getPanelEjercicio().cambiarCarta("Redactar");

			}

		} else if (e.getActionCommand().equals("Crear pregunta test")) {

			if (ventana.getSistema().getEsProfesor()) {

				panelpreguntatest.getPanelEjercicio().cambiarCarta("Test");

			}

		} else if (e.getActionCommand().equals("Crear pregunta multiple")) {

			if (ventana.getSistema().getEsProfesor()) {

				panelpreguntamultiple.getPanelEjercicio().cambiarCarta("Multiple");

			}

		}

	}

}
