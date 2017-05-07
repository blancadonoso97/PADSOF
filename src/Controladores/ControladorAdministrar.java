package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelAdministrar;
import InterfazGrafica.VentanaInicial;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase para definir el controlador de los botones de PanelaAdministrar
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class ControladorAdministrar implements ActionListener{

	private VentanaInicial ventana;
	private PanelAdministrar panel;
	
	/**
	 * Constructor de la clase ControladorAdministrar
	 * @param vent Ventana Inicial
	 * @param pan Panel Administrar
	 */
	public ControladorAdministrar(VentanaInicial vent, PanelAdministrar pan){
		
		this.ventana = vent;
		this.panel = pan;
		
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Aceptar Matricula")){
		
			try {
				if(ventana.getSistema().aceptarMatricula(panel.getMatricula()) == false){
					JOptionPane.showMessageDialog(panel, "Error al aceptar la matricula", "Error", JOptionPane.ERROR_MESSAGE);
					return;	
				}else{
					JOptionPane.showMessageDialog(panel, "La peticion de matricula ha sido aceptada", "Aceptar matricula", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
					
			} catch (InvalidEmailAddressException e1) {
				e1.printStackTrace();
			} catch (FailedInternetConnectionException e1) {
				e1.printStackTrace();
			}
		
		}else if(e.getActionCommand().equals("Denegar Matricula")){
			
			try {
				if(ventana.getSistema().denegarMatricula(panel.getMatricula()) == false){
					JOptionPane.showMessageDialog(panel, "Error al denegar la matricula", "Error", JOptionPane.ERROR_MESSAGE);
					return;	
				}else{
					JOptionPane.showMessageDialog(panel, "La peticion de matricula ha sido denegada", "Denegar matricula", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
					
			} catch (InvalidEmailAddressException e1) {
				e1.printStackTrace();
			} catch (FailedInternetConnectionException e1) {
				e1.printStackTrace();
			}
			
		}else if(e.getActionCommand().equals("Expulsar")){
			
			
			if(ventana.getSistema().agregarExpulsion(panel.getAlumnoAsignaturas(), panel.getAsignaturaAsig()) == false){
				JOptionPane.showMessageDialog(panel, "Error al expulsar", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}else{
				
				try {
					if(ventana.getSistema().expulsarAlumno(panel.getExpulsion()) == false){
						JOptionPane.showMessageDialog(panel, "Error al expulsar al alumno", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}else{
						JOptionPane.showMessageDialog(panel, "El alumno "+ panel.getAlumnoAsignaturas().getNombre() + " ha sido expulsado de " + panel.getAsignaturaAsig().getNombre(), "Expulsar", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
					e1.printStackTrace();
				}
				
			}
			
			
			
		}else if(e.getActionCommand().equals("Readmitir")){
			
			
			panel.getExpulsionVigente().setExpulsado(false);
			
			
			if(ventana.getSistema().comprobarExpulsion(panel.getAlumnoExpulsion(), panel.getAsignaturaExp(), panel.getExpulsionVigente()) != false){
				JOptionPane.showMessageDialog(panel, "Error al readmitir al alumno", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}else{
				
				JOptionPane.showMessageDialog(panel, "El alumno "+ panel.getAlumnoExpulsion().getNombre() + " ha sido readmitido en " + panel.getAsignaturaExp().getNombre(), "Readmitir", JOptionPane.INFORMATION_MESSAGE);
				return;
				
			}
			
			
			
			
			
		}
		
		
	}

}
