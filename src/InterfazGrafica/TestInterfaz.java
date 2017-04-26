package InterfazGrafica;

import java.io.IOException;

import eCourses.Sistema;

/**
 * Clase para ejecutar la interfaz grafica
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class TestInterfaz {

	public static void main(String[] args)  throws ClassNotFoundException, IOException{
		
		Sistema sistema = new Sistema("archivoProf.txt", "archivoAlum.txt");
		
		VentanaInicial eCourses = new VentanaInicial(sistema);
		
	}
	
	
	
}
