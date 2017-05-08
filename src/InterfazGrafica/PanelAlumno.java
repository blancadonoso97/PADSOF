package InterfazGrafica;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase para definir el panel cuando se inicia sesion como Alumno
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelAlumno extends JPanel{


	private static final long serialVersionUID = 1L;
	
	private VentanaInicial ventana;
		
	private PanelBarraHerramientas barraHerramientas;
	private PanelContenido contenido;
	
	/**
	 * Constructor de la clase PanelAlumno
	 * @param vent Ventana que contiene el panel
	 * @throws IOException 
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 * @throws ClassNotFoundException 
	 */
	public PanelAlumno(VentanaInicial vent) throws ClassNotFoundException, InvalidEmailAddressException, FailedInternetConnectionException, IOException{
	
		this.ventana = vent;
		
		BorderLayout layout = new BorderLayout();

		this.setLayout(layout);
		
		this.barraHerramientas = new PanelBarraHerramientas(this);
		
		this.contenido = new PanelContenido(this);
		this.barraHerramientas.actualizarestado();
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
	
	 public PanelBarraHerramientas getPanelHerramientas(){
		 return this.barraHerramientas;
	 }
	 /**
	  * Devuelve el panel del contenido 
	  * @return  panel del contenido
	  */
	 public PanelContenido getPanelContenido(){
		 return this.contenido;
	 }

}
