package InterfazGrafica;

import javax.swing.JPanel;

/**
 * Clase para definir el panel cuando se inicia sesion como Alumno
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelAlumno extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private VentanaInicial ventana;
	
	/**
	 * Constructor de la clase PanelAlumno
	 * @param vent Ventana que contiene el panel
	 */
	public PanelAlumno(VentanaInicial vent){
		
		
		this.ventana = vent;
		
		
		
	}
	
	/**
	  * Devuelve la ventana que contiene el panel
	  * @return ventana
	  */
	 public VentanaInicial getVentana(){
		 
		 return ventana;
		 
	 }
	

}
