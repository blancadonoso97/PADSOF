package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import InterfazGrafica.VentanaInicial;

/**
 * Clase para definir el controlador de los botones de LogOut
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class ControladorLogOut implements ActionListener{

	private VentanaInicial ventana;
	
	/**
	 * Constructor de la clase ControladorLogOut
	 * @param vent Ventana asociada
	 */
	public ControladorLogOut(VentanaInicial vent){
	
		this.ventana = vent;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			ventana.getSistema().logOut("sistema.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.exit(0); // Sale de la aplicacion
		
	}

}
