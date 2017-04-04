package eCourses;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Asignatura.Asignatura;

/**
* 
* Clase para definir el test de los alumnos de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class AlumnoTest {
	private Asignatura padsof;
	private Alumno alumno;
	
	@Before
	public void inicializar() throws Exception{
		padsof = new Asignatura("PADSOF",true);
		alumno = new Alumno("Blanca","Donoso","blanca.martinezdonoso@estudiante.uam.es","89549","lamaslista");
	}
	
	@Test
	public void testAgregarAlumno() {
		assertEquals("Blanca",alumno.getNombre());
		assertEquals("Donoso",alumno.getApellidos());
		assertEquals("blanca.martinezdonoso@estudiante.uam.es",alumno.getEmail());
		assertEquals("89549",alumno.getId());
		assertEquals("lamaslista",alumno.getContrasena());
	}
	
	@Test
	public void testAgregarAsignatura() {
		alumno.agregarAsignatura(padsof);
		assertEquals(padsof,alumno.getAsignatura("PADSOF"));
	}

}
