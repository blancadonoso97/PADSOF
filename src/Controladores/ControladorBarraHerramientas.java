package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import InterfazGrafica.PanelBarraHerramientas;
import InterfazGrafica.VentanaInicial;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;


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
				try {
					panel.getPanelProfe().getPanelContenido().cambiarCarta("Asignatura");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else if(e.getActionCommand().equals("Crear Tema")){
			
			if(ventana.getSistema().getEsProfesor()){
				try {
					panel.getPanelProfe().getPanelContenido().cambiarCarta("Tema");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else if(e.getActionCommand().equals("Crear Subtema")){
			
			if(ventana.getSistema().getEsProfesor()){
				try {
					panel.getPanelProfe().getPanelContenido().cambiarCarta("Subtema");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else if(e.getActionCommand().equals("Crear Apuntes")){
			
			if(ventana.getSistema().getEsProfesor()){
				try {
					panel.getPanelProfe().getPanelContenido().cambiarCarta("Apuntes");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else if(e.getActionCommand().equals("Solicitar Matricula")){
			
			if(!ventana.getSistema().getEsProfesor()){
				try {
					panel.getPanelAlumno().getPanelContenido().cambiarCarta("Matricula");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else if(e.getActionCommand().equals("Pagina Principal")){
			
			if(!ventana.getSistema().getEsProfesor()){
				try {
					panel.getPanelAlumno().getPanelContenido().cambiarCarta("Principal");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				try {
					panel.getPanelProfe().getPanelContenido().cambiarCarta("Principal");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				try {
					panel.getPanelProfe().getPanelContenido().cambiarCarta("Administrar");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}else if(e.getActionCommand().equals("Crear Ejercicio")){
			
			if(ventana.getSistema().getEsProfesor()){
				
				try {
					panel.getPanelProfe().getPanelContenido().cambiarCarta("Ejercicio");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
		}

	}

	
	
	
}
