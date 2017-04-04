package eCourses;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import Asignatura.Asignatura;
import Asignatura.Tema;
import Examen.Ejercicio;
import Examen.Opcion;
import Examen.PreguntaTest;
import eCourses.Alumno;

/**
* 
* Clase para definir el test de las estadisticas de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class EstadisticaTest {

	private Alumno alumno1;
	private Alumno alumno2;
	private Asignatura asig1;
	private Estadistica est;
	private Ejercicio ej1;
	private Tema tema1;
	private PreguntaTest preg1;
	private Opcion op1;
	private Opcion op2;
	private ArrayList<Opcion> opcionesProfe = new ArrayList<Opcion>();
	private ArrayList<Opcion> opcionesAlumno1 = new ArrayList<Opcion>();
	private ArrayList<Opcion> opcionesAlumno2 = new ArrayList<Opcion>();
	
	
	@Before 
	public void inicializar() throws Exception{
		asig1 = new Asignatura("PADSOF",true);
		alumno1 = new Alumno("Blanca","Donoso","blanca.martinezdonoso@estudiante.uam.es","89549","lamaslista");
		alumno2 = new Alumno("diego","Donoso","diego.martinezdonoso@estudiante.uam.es","89530","elmaslisto");
		asig1.agregarAlumno(alumno1);
		asig1.agregarAlumno(alumno2);
		alumno1.agregarAsignatura(asig1);
		alumno2.agregarAsignatura(asig1);
		est = new Estadistica(asig1);
	
		tema1 = new Tema(asig1,"tema1",true);
	
		ej1 = new Ejercicio(tema1,10,1,3,2016,5,4,2017,"Examen");
		preg1 = new PreguntaTest("Mi coche es rojo",10,ej1,opcionesProfe);
		op1 = new Opcion("blanco",true,preg1);
		op2 = new Opcion("gris",false,preg1);
		opcionesProfe.add(op1);
		opcionesProfe.add(op2);
		preg1.setOpciones(opcionesProfe);
		opcionesAlumno1.add(op2);
		opcionesAlumno2.add(op1);
		ej1.AgregarPregunta(preg1);
		asig1.agregarTema(tema1);
		tema1.agregarEjercicio(ej1);
		asig1.agregarEstadistica(est);
		ej1.realizarEjercicio(alumno1,opcionesAlumno1);
		ej1.realizarEjercicio(alumno2, opcionesAlumno2);
	}
	
	@Test
	public void testGetPorcentajeAlumnosRealizado() {
		assertEquals(100,est.getPorcentajeAlumnosRealizado(ej1),0);
	}

	@Test
	public void testGetPorcentajeAlumnosReCorrectamente() {
		assertEquals(50,est.getPorcentajeAlumnosReCorrectamente(ej1),0);
		
	}

}
