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
* Clase para definir el test de las respuestas de tipo multiple de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class RespuestaMultipleTest {
	private ArrayList<Opcion> opcionesPregunta = new ArrayList<Opcion>();
	private ArrayList<Opcion> opcionesAlumno = new ArrayList<Opcion>();
	private Opcion op1;
	private Opcion op2;
	private Opcion op3;
	private Ejercicio ej1;
	private Asignatura asi;
	private Tema tema1;
	private PreguntaMultiple pregM;
	private Alumno alumno;
	private RespuestaMultiple respM;
	
	@Before
	public void inicializar() throws Exception{
		asi = new Asignatura("cirel",true);
		tema1 = new Tema(asi,"tema1",true);

		ej1 = new Ejercicio(tema1,8,1,3,2016,5,4,2017,"Examen");
		pregM = new PreguntaMultiple("Mi coche es rojo",(1/3),ej1,opcionesPregunta);	
		alumno = new Alumno("Blanca","Donoso","blanca.martinezdonoso@estudiante.uam.es","89549","lamaslista");
		op1 = new Opcion("blanco",false,pregM);
		op2 = new Opcion("gris",true,pregM); 
		op3= new Opcion("rojo",true,pregM);
		opcionesPregunta.add(op1);
		opcionesPregunta.add(op2);
		opcionesPregunta.add(op3);
		opcionesAlumno.add(op1);
		opcionesAlumno.add(op3);
		pregM.setOpciones(opcionesPregunta);
		respM = new RespuestaMultiple(pregM,alumno);
	}
	
	@Test
	public void testContestarPregunta() {
		pregM.contestarPregunta(opcionesAlumno,alumno);
		assertEquals(alumno,respM.getAlumno());
		respM.calcularNota();
		assertEquals((1/6),respM.getNota(),0);
		assertEquals(opcionesPregunta,pregM.getOpciones());
		
	}
	
}
