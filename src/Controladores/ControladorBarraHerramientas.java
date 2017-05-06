package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import InterfazGrafica.PanelBarraHerramientas;
import InterfazGrafica.VentanaInicial;


/**
 * Clase para definir el controlador del boton Crear Asignatura -> (PanelCrearAsignatura)
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class ControladorBarraHerramientas implements ActionListener{

	private VentanaInicial ventana;
	private PanelBarraHerramientas panel;
	
	/**
	 * Constructor de la clase ControladorCrearAsignatura
	 * @param vent Ventana asociada al panel
	 * @param pan Panel asociado al controlador
	 */
	public ControladorBarraHerramientas(VentanaInicial vent, PanelBarraHerramientas pan){
	
		this.ventana = vent;
		this.panel = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Crear Asignatura")){
			
			if(ventana.getSistema().getEsProfesor()){
				panel.getPanelProfe().getPanelContenido().cambiarCarta("Asignatura");
			}
			
		}else if(e.getActionCommand().equals("Crear Tema")){
			
			if(ventana.getSistema().getEsProfesor()){
				panel.getPanelProfe().getPanelContenido().cambiarCarta("Tema");
			}
			
		}else if(e.getActionCommand().equals("Crear Subtema")){
			
			if(ventana.getSistema().getEsProfesor()){
				panel.getPanelProfe().getPanelContenido().cambiarCarta("Subtema");
			}
			
		}else if(e.getActionCommand().equals("Crear Apuntes")){
			
			if(ventana.getSistema().getEsProfesor()){
				panel.getPanelProfe().getPanelContenido().cambiarCarta("Apuntes");
			}
			
		}else if(e.getActionCommand().equals("Solicitar Matricula")){
			
			if(!ventana.getSistema().getEsProfesor()){
				panel.getPanelAlumno().getPanelContenido().cambiarCarta("Matricula");
			}
			
		}else if(e.getActionCommand().equals("Pagina Principal")){
			
			if(!ventana.getSistema().getEsProfesor()){
				panel.getPanelAlumno().getPanelContenido().cambiarCarta("Principal");
			}else{
				panel.getPanelProfe().getPanelContenido().cambiarCarta("Principal");
			}
			
		}else if(e.getActionCommand().equals("Cerrar Sesion")){
			
			try {
				ventana.getSistema().logOut("sistema.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			System.exit(0);
			
		}else if(e.getActionCommand().equals("Administrar")){

			if(ventana.getSistema().getEsProfesor()){
				panel.getPanelProfe().getPanelContenido().cambiarCarta("Administrar");
			}
			
			
		}

	}

	
	
	
}
