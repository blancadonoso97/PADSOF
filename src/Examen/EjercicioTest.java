package Examen;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Asignatura.Asignatura;
import Asignatura.Tema;
import eCourses.Alumno;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
* 
* Clase para definir el test de los ejercicios de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class EjercicioTest {
	private Asignatura asi;
	private Tema tema1;
	private Alumno alumno;
	private Ejercicio ej1;
	private PreguntaTest preg1;
	private PreguntaTest preg2;
	private Opcion op1;
	private Opcion op2;
	private Opcion op3;
	private Opcion op4;
	private ArrayList<Opcion> opciones1 = new ArrayList<Opcion>();
	private ArrayList<Opcion> opciones2 = new ArrayList<Opcion>();
	private ArrayList<Opcion> opcionesAlu = new ArrayList<Opcion>();
	
	@Before
	public void inicializar() throws Exception{
		asi = new Asignatura("cirel",true);
		tema1 = new Tema(asi,"tema1",true);
		alumno = new Alumno("Blanca","Donoso","blanca.martinezdonoso@estudiante.uam.es","89549","lamaslista");
		
		ej1 = new Ejercicio(tema1,false, 8,1,3,2016,5,4,2017,"Examen");
		preg1 = new PreguntaTest("Mi coche es rojo",(1/3),2, ej1,opciones1);
		preg2 = new PreguntaTest("La vaca da leche",(1/2),3, ej1,opciones2);
		op1 = new Opcion("blanco",false,preg1);
		op2 = new Opcion("gris",true,preg1); 
		op3 = new Opcion("rojo",false,preg2);
		op4 = new Opcion("naranja",true,preg2);
		opciones1.add(op1);
		opciones1.add(op2);
		opciones2.add(op3);
		opciones2.add(op4);
		preg1.setOpciones(opciones1);
		preg2.setOpciones(opciones2);
		opcionesAlu.add(op2);
		opcionesAlu.add(op3);
		}
	
	@Test
	public void testAgregarPregunta() throws ClassNotFoundException, InvalidEmailAddressException, FailedInternetConnectionException, IOException {
		ej1.AgregarPregunta(preg1);
		ej1.AgregarPregunta(preg2);
		assertEquals(preg1,ej1.getPregunta("Mi coche es rojo"));
		assertEquals(2,ej1.getNPreguntas(),0);
		ej1.BorrarPregunta(preg1);
		assertEquals(preg2,ej1.getPregunta("La vaca da leche"));
		assertEquals(1,ej1.getNPreguntas(),0);
		assertEquals(true,ej1.getVisible());
		assertEquals(true,ej1.realizarEjercicio(alumno,opcionesAlu));
		assertEquals(1/3,ej1.calcularNota(alumno),0);
	}
	
}
