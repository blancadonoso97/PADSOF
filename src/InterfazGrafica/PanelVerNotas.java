package InterfazGrafica;

import javax.swing.JPanel;

/**
 * Clase para definir el panel para ver las notas del alumno
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelVerNotas extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private PanelContenido contenedor;
	
	
	/**
	 * Constructor de la clase PanelVerNotas
	 * @param cont Panel de contenido
	 */
	public PanelVerNotas(PanelContenido cont){
		
		this.contenedor = cont;
	}
	
	/**
	 * Obtiene el panel contenedor
	 * @return contenedor
	 */
	public PanelContenido getContenedor(){
		return contenedor;
	}
	
	
	/**
	 * Actualiza la tabla de notas
	 */
	public void actualizarTabla(){
		
		
		
		
	}
	

}
