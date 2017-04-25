package Asignatura;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Examen.Ejercicio;

/**
* 
* Clase para definir el test de los temas de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class TemaTest {
	private Asignatura asi;
	private Tema tema1;
	private Tema tema2;
	private Apuntes ap1;
	private Ejercicio ej1;
	
	@Before
	public void inicializar() throws Exception{
		asi = new Asignatura("cirel",true);
		tema1 = new Tema(asi,"tema1",true);
		tema2 = new Tema(asi,"tema2",true);
		ap1 = new Apuntes(tema1,"Textaco del bueno",22,03,2017,true,"Yo soy tonto");
		ej1 = new Ejercicio(tema2,false, 8,22,01,2017,05,04,2017,"Examen");
		
	}
	
	@Test
	public void testAccederTema() {
		assertEquals("tema1",tema1.getNombre());
		assertEquals("tema2",tema2.getNombre());
		assertEquals(true,tema1.esVisible());
		assertEquals(true,tema2.esVisible());
		tema1.agregarTema(tema2);
		assertEquals(tema2,tema1.getTema("tema2"));
		assertEquals(1,tema1.getNTemas(),0);
	}
	
	@Test
	public void testAccederApuntes() {
		tema1.agregarApuntes(ap1);
		assertEquals(ap1,tema1.getApunte("Yo soy tonto"));
		assertEquals(1,tema1.getNApuntes(),0);
		
	}
	
	@Test
	public void testAccederEjercicio() {
		tema2.agregarEjercicio(ej1);
		assertEquals(1,tema2.getNEjercicios(),0);
		assertEquals(ej1,tema2.getEjercicio("Examen"));
		
	
	}
}
