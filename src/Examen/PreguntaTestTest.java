package Examen;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Asignatura.Asignatura;
import Asignatura.Tema;
import eCourses.Alumno;

/**
* 
* Clase para definir el test de las preguntas de tipo test de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class PreguntaTestTest {
	private ArrayList<Opcion> opcionesPregunta = new ArrayList<Opcion>();
	private Opcion opcionAlumno;
	private Opcion op1;
	private Opcion op2;
	private Opcion op3;
	private Ejercicio ej1;
	private Asignatura asi;
	private Tema tema1;
	private PreguntaTest pregT;
	private Alumno alumno;
	private RespuestaTest respT;
	
	@Before
	public void inicializar() throws Exception{
		asi = new Asignatura("cirel",true);
		tema1 = new Tema(asi,"tema1",true);
		op1 = new Opcion("blanco",false,pregT);
		op2 = new Opcion("gris",true,pregT); 
		op3= new Opcion("rojo",true,pregT);
		opcionesPregunta.add(op1);
		opcionesPregunta.add(op2);
		opcionesPregunta.add(op3);
		opcionAlumno=op1;
		ej1 = new Ejercicio(tema1,true, 8,1,3,2016,5,4,2017,"Examen");
		pregT = new PreguntaTest("Mi coche es rojo",(1/3),0, ej1,opcionesPregunta);	
		alumno = new Alumno("Blanca","Donoso","blanca.martinezdonoso@estudiante.uam.es","89549","lamaslista");
	}
	
	@Test
	public void testContestarPregunta() {

		pregT.contestarPregunta(opcionAlumno,alumno);
		assertEquals(1,pregT.getNrespuestas(),0);
		respT = (RespuestaTest) pregT.respuestas.get(0);
		assertEquals(alumno,pregT.getAlumno(respT));	
		assertEquals(opcionesPregunta,pregT.getOpciones());
		
	}
	
}
