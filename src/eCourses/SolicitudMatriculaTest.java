package eCourses;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Asignatura.Asignatura;

/**
* 
* Clase para definir el test de las solicitudes de matricula de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class SolicitudMatriculaTest {
	private Asignatura padsof;
	private Alumno alumno;
	private SolicitudMatricula matricula;
	
	@Before
	public void inicializar() throws Exception{
		padsof = new Asignatura("PADSOF",true);
		alumno = new Alumno("Blanca","Donoso","blanca.martinezdonoso@estudiante.uam.es","89549","lamaslista");
		matricula = new SolicitudMatricula(alumno,padsof, false);
	}
	
	@Test
	public void testSolicitarMatricula() {
		assertEquals(alumno,matricula.getAlumno());
		assertEquals(padsof,matricula.getAsignatura());
		assertEquals(false,matricula.getMatricula());
		matricula.setMatricula(true);
		assertEquals(true,matricula.getMatricula());
	}
	
}
