package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelMatricula;
import InterfazGrafica.VentanaInicial;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ControladorMatricula  implements ActionListener{

	private VentanaInicial ventana;
	private PanelMatricula panel;
	
	/**
	 * Constructor de la clase ControladorInicioSesion
	 * @param sist Sistema (eCourses)
	 * @param pan Panel asociado al controlador
	 */
	public ControladorMatricula(VentanaInicial vent, PanelMatricula pan){
	
		this.ventana = vent;
		this.panel = pan;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	int i;
	boolean exist = false;
	
		if (panel.getNombre().equals("")) {
			 JOptionPane.showMessageDialog(panel, "Debe introducir una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		}
		if(panel.getNombre().equals("varios")){
			JOptionPane.showMessageDialog(panel, "Solo puede elegir una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		}
		
		for(i=0;i<panel.getListaAsignaturas().getModel().getSize();i++){
			if(panel.getListaAsignaturas().getModel().getElementAt(i).equals(panel.getNombre())){
				exist = true;
			}
		}
		
		if(!exist){
			 JOptionPane.showMessageDialog(panel, "Esa asignatura no existe", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		}
		
		if(e.getActionCommand().equals("Solicitar")){
			
			if(!ventana.getSistema().getEsProfesor()){
				if(!ventana.getSistema().agregarSolicitud(ventana.getSistema().getAsignatura(panel.getNombre()))){
					
					JOptionPane.showMessageDialog(panel, "Ya ha solicitado una matricula en esa asignatura", "Error", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				JOptionPane.showMessageDialog(panel, "Se ha realizado la solicitud de matricula en la asignatura "+ panel.getNombre(), "Solicitar Matricula", JOptionPane.INFORMATION_MESSAGE);
				panel.actualizartablas();
				try {
					panel.getPanelAlumno().getPanelContenido().cambiarCarta("Solicitud");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	}

	
	
}
