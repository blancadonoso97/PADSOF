package Examen;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Asignatura.Asignatura;
import Asignatura.Tema;

/**
* 
* Clase para definir el test de las opciones de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class OpcionTest {
	private Asignatura asi;
	private Tema tema1;
	private Ejercicio ej1;
	private Pregunta preg1;
	private ArrayList<Opcion> opciones1 = new ArrayList<Opcion>();
	private Opcion op1;
	private Opcion op2;
	
	@Before
	public void inicializar() throws Exception{
		asi = new Asignatura("cirel",true);
		tema1 = new Tema(asi,"tema1",true);
		ej1 = new Ejercicio(tema1,8,1,3,2016,5,4,2017,"Examen");
		preg1 = new PreguntaTest("Mi coche es rojo",(1/3),ej1,opciones1);
		opciones1.add(op1);
		opciones1.add(op2);
		op1 = new Opcion("El cielo es azul",true,preg1);
		op2 = new Opcion("El cielo es rojo",false,preg1);
	}
	
	@Test
	public void testOpcion() {
	
		assertEquals("El cielo es azul",op1.getEnunciado());
		assertEquals("El cielo es rojo",op2.getEnunciado());
		assertEquals(true,op1.getEsCorrecta());
		assertEquals(false,op2.getEsCorrecta());
		op1.setMarcada(true);
		assertEquals(true,op1.getMarcada());
		assertEquals(false,op2.getMarcada());
		
	}

}
