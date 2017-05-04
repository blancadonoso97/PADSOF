package InterfazGrafica;

import java.awt.BorderLayout;
import javax.swing.JPanel;


/**
 * Clase para definir el panel cuando se inicia sesion como Profesor
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelProfesor extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private VentanaInicial ventana;
		
	private PanelBarraHerramientas barraHerramientas;
	private PanelContenido contenido;
	
	/**
	 * Constructor de la clase PanelAlumno
	 * @param vent Ventana que contiene el panel
	 */
	public PanelProfesor(VentanaInicial vent){
		
		this.ventana = vent;
		
		BorderLayout layout = new BorderLayout();

		this.setLayout(layout);
		
		this.barraHerramientas = new PanelBarraHerramientas(this);
		
		this.contenido = new PanelContenido(this);
		
		this.add(barraHerramientas, BorderLayout.WEST);
		this.add(contenido);
		
	}	
	
	
	/**
	  * Devuelve la ventana que contiene el panel
	  * @return ventana
	  */
	 public VentanaInicial getVentana(){
		 
		 return ventana;
		 
	 }
	 
	 /**
	  * Devuelve el panel de barra de herramientas
	  * @return barraHerramientas
	  */
	 public PanelBarraHerramientas getPanelHerramientas(){
		 return barraHerramientas;
	 }
	 
	 /**
	  * Devuelve el panel de contenido
	  * @return contenido
	  */
	 public PanelContenido getPanelContenido(){
		 return contenido;
	 }
	

}
