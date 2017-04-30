package InterfazGrafica;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * Clase para definir el panel cuando se inicia sesion como Profesor
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelProfesor extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton boton;
	
	/**
	 * Constructor de la clase PanelProfesor
	 */
	public PanelProfesor(){
		
		SpringLayout layout = new SpringLayout();

		this.setLayout(layout);
		
		this.boton = new JButton("Cerrar Sesión");
		
		this.add(boton);
		
		
		
	}

}
