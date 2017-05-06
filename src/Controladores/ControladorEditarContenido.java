package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import InterfazGrafica.PanelAsignatura;
import InterfazGrafica.PanelPrincipal;
import InterfazGrafica.PanelTema;

public class ControladorEditarContenido   implements ActionListener{
	
	private PanelPrincipal panelp;
	private PanelAsignatura panela;
	private PanelTema panelt;
	
	/**
	 * Constructor de la clase ControladorInicioSesion
	 * @param sist Sistema (eCourses)
	 * @param pan Panel asociado al controlador
	 */
	public ControladorEditarContenido(PanelPrincipal pan){
	
		this.panelp = pan;
		
	}
	
	public ControladorEditarContenido(PanelAsignatura pan){
		
		this.panela = pan;
		
	}
	
	public ControladorEditarContenido(PanelTema pan){
		
		this.panelt = pan;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
}
