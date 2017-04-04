package Asignatura;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
* 
* Clase para definir el test de las asignaturas de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class AsignaturaTest {
	private Asignatura padsof;
	private Tema tema1;
	private Tema tema2;
	
	@Before
	public void inicializar() throws Exception{
		padsof = new Asignatura("PADSOF",true);
		tema1 = new Tema(padsof,"diseño",true);
		tema2 = new Tema(padsof, "implementacion",false);
		return;
	}
	
	@Test
	public void testAgregarAsignatura() {
		assertEquals("PADSOF",padsof.getNombre());
		assertEquals(true,padsof.esVisible());
		return;
		
	}
	
	@Test
	public void testAgregarTema() {
		padsof.agregarTema(tema1);
		assertEquals(1,padsof.getNTemas(),0);
		assertEquals(tema1,padsof.getTema("diseño"));
		padsof.agregarTema(tema2);
		assertEquals(2,padsof.getNTemas(),0);
		assertEquals(tema1,padsof.getTema("diseño"));
		assertEquals(tema2,padsof.getTema("implementacion"));
		return;
	}

}
