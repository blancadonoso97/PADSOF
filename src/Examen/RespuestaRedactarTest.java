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
* Clase para definir el test de las respuestas de tipo redactar de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class RespuestaRedactarTest {
	private ArrayList<Opcion> opcionesPregunta = new ArrayList<Opcion>();
	private Opcion op1;
	private Opcion op2;
	private Opcion op3;
	private Ejercicio ej1;
	private Asignatura asi;
	private Tema tema1;
	private PreguntaRedactar pregM;
	private Alumno alumno;
	private RespuestaRedactar respM;
	
	@Before
	public void inicializar() throws Exception{
		asi = new Asignatura("cirel",true);
		tema1 = new Tema(asi,"tema1",true);
		op1 = new Opcion("blanco",false,pregM);
		op2 = new Opcion("gris",true,pregM); 
		op3= new Opcion("rojo",true,pregM);
		opcionesPregunta.add(op1);
		opcionesPregunta.add(op2);
		opcionesPregunta.add(op3);
		ej1 = new Ejercicio(tema1,false, 8,1,3,2016,5,4,2017,"Examen");
		pregM = new PreguntaRedactar("Mi coche es rojo",(1/3),0, ej1,opcionesPregunta);	
		alumno = new Alumno("Blanca","Donoso","blanca.martinezdonoso@estudiante.uam.es","89549","lamaslista");
		respM = new RespuestaRedactar(pregM,alumno,"gris");
	}
	
	@Test
	public void testContestarPregunta() {
		respM.calcularNota();
		assertEquals(1/3,respM.getNota(),0);
		assertEquals(opcionesPregunta,pregM.getOpciones());
		
	}

}
