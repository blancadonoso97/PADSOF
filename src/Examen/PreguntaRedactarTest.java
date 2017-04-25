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
* Clase para definir el test de las preguntas de tipo redactar de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class PreguntaRedactarTest {
	private ArrayList<Opcion> opcionesPregunta = new ArrayList<Opcion>();
	private Opcion op1;
	private Opcion op2;
	private Opcion op3;
	private Ejercicio ej1;
	private Asignatura asi;
	private Tema tema1;
	private PreguntaRedactar pregR;
	private Alumno alumno;
	private RespuestaRedactar respR;
	
	@Before
	public void inicializar() throws Exception{
		asi = new Asignatura("cirel",true);
		tema1 = new Tema(asi,"tema1",true);
		op1 = new Opcion("blanco",false,pregR);
		op2 = new Opcion("gris",true,pregR); 
		op3= new Opcion("rojo",true,pregR);
		opcionesPregunta.add(op1);
		opcionesPregunta.add(op2);
		opcionesPregunta.add(op3);
		ej1 = new Ejercicio(tema1,true, 8,1,3,2016,5,4,2017,"Examen");
		pregR = new PreguntaRedactar("Mi coche es rojo",(1/3),0, ej1,opcionesPregunta);	
		alumno = new Alumno("Blanca","Donoso","blanca.martinezdonoso@estudiante.uam.es","89549","lamaslista");
	}
	
	@Test
	public void testContestarPregunta() {

		pregR.contestarPregunta(alumno,"Contestar pregunta");
		assertEquals(1,pregR.getNrespuestas(),0);
		respR = (RespuestaRedactar) pregR.respuestas.get(0);
		assertEquals(alumno,pregR.getAlumno(respR));
		assertEquals(opcionesPregunta,pregR.getOpciones());
		
	}
	
}
