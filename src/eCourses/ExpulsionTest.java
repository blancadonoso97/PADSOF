package eCourses;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import Asignatura.Asignatura;

/**
* 
* Clase para definir el test de las expulsiones de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class ExpulsionTest {

	private Alumno alum;
	private Asignatura asig;
	private Expulsion exp1;
	
	@Before
	public void inicializar() throws Exception{
		
		asig = new Asignatura("PADSOF",true);
		alum = new Alumno("Blanca","Donoso","blanca.martinezdonoso@estudiante.uam.es","89549","lamaslista");
		exp1 = new Expulsion(true, 1, 1, 2017, 1, 1, 2020, alum, asig);
		
	}
	
	
	@Test
	public void testComprobarFecha() {
		Calendar fechaActual = Calendar.getInstance();
		assertEquals(true, exp1.comprobarFecha(fechaActual));
	}

}
