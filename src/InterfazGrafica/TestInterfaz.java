package InterfazGrafica;

import java.io.File;
import java.io.IOException;

import eCourses.Sistema;

/**
 * Clase para ejecutar la interfaz grafica
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 */
public class TestInterfaz {

	public static void main(String[] args)  throws ClassNotFoundException, IOException{
		
		Sistema sistema = Sistema.getInstance();
		
		String Fichero = "sistema.txt";
		File fichero = new File(Fichero);
		
		if (fichero.exists()){
			
			sistema = sistema.cargarSistema("sistema.txt");
			
		}
		
		new VentanaInicial(sistema);
		
	}
	
}
 