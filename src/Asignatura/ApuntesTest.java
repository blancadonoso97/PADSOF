package Asignatura;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;


/**
* 
* Clase para definir el test de los apuntes de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class ApuntesTest {

	private Asignatura asi;
	private Tema tema1;
	private Apuntes apuntes1;
	
	@Before
	public void inicializar() throws Exception{
		
		asi = new Asignatura("Cirel", true);
		tema1 = new Tema(asi,"Tema 1", true);
		
		apuntes1 = new Apuntes(tema1, "Texto de los apuntes", 1, 1, 2017, true, "Apuntes 1");
	}
	
	
	@Test
	public void testComprobarVisible() throws InvalidEmailAddressException, FailedInternetConnectionException, ClassNotFoundException, IOException {
		assertEquals(true, apuntes1.comprobarVisible());
	}

}
