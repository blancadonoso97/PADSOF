package InterfazGrafica;

import java.io.IOException;

import eCourses.Sistema;

public class TestInterfaz {

	public void main(String[] args)  throws ClassNotFoundException, IOException{
		
		Sistema sistema = new Sistema("archivoProf.txt", "archivoAlum.txt");
		
		InicioSesion eCourses = new InicioSesion(sistema);
		
	}
	
	
	
}
