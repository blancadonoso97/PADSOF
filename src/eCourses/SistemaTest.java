package eCourses;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
* 
* Clase para definir el test del sistema de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class SistemaTest {

	private Sistema eCourses;
	
	
	@Before
	public void inicializar() throws Exception{
		
		eCourses = new Sistema("archivoProf.txt", "archivoAlum.txt");
		eCourses.agregarAsignatura("Asignatura", true);
		eCourses.agregarTema("Tema 2", eCourses.getAsignatura("Asignatura"), true);
	}

	@Test
	public void testGuardarSistema() throws IOException {
		eCourses.guardarSistema("sistematest.txt");
		Path path = Paths.get("sistematest.txt");
		Files.exists(path);
	}

	@Test
	public void testCargarSistema() throws ClassNotFoundException, IOException {
		eCourses.guardarSistema("sistematest.txt");
		eCourses = Sistema.cargarSistema("sistematest.txt");
		assertNotNull(eCourses);
	}

	@Test
	public void testCargarDatosProfesor() throws ClassNotFoundException, IOException {
		
		assertEquals(true, eCourses.getEsProfesor());
		assertEquals(true, eCourses.getLogIn());
		
	}

	@Test
	public void testCargarAlumnos() throws IOException {
		assertNotNull(eCourses.getAlumnos().get(0));
	}

	@Test
	public void testComprobarLogIn() {
		assertEquals(true, eCourses.getLogIn());
	}

	@Test
	public void testComprobarMatricula() throws InvalidEmailAddressException, FailedInternetConnectionException, ClassNotFoundException, IOException {
		eCourses = Sistema.cargarSistema("sistematest.txt");
		eCourses.comprobarLogIn("1289", "JoA");
		eCourses.agregarSolicitud(eCourses.getAsignatura("Asignatura"));
		eCourses.comprobarLogIn("0001", "passprof");
		eCourses.aceptarMatricula(eCourses.getMatricula("1289", "Asignatura"));
		assertEquals(true, eCourses.comprobarMatricula(eCourses.getAlumno("1289"), eCourses.getAsignatura("Asignatura"), eCourses.getMatricula("1289", "Asignatura")));
	}

	@Test
	public void testComprobarExpulsion() throws InvalidEmailAddressException, FailedInternetConnectionException, IOException, ClassNotFoundException {
		eCourses = Sistema.cargarSistema("sistematest.txt");
		eCourses.comprobarLogIn("1297", "Coero");
		eCourses.agregarSolicitud(eCourses.getAsignatura("Asignatura"));
		eCourses.guardarSistema("sistematest.txt");
		eCourses = Sistema.cargarSistema("sistematest.txt");
		eCourses.comprobarLogIn("0001", "passprof");
		eCourses.aceptarMatricula(eCourses.getMatricula("1297", "Asignatura"));
		Expulsion exp1 = new Expulsion(false, eCourses.getAlumno("1297"), eCourses.getAsignatura("Asignatura"));
		eCourses.expulsarAlumno(exp1);
		assertEquals(true, eCourses.comprobarExpulsion(eCourses.getAlumno("1297"), eCourses.getAsignatura("Asignatura"), exp1));
	}

	@Test
	public void testAceptarMatricula() throws InvalidEmailAddressException, FailedInternetConnectionException, ClassNotFoundException, IOException {
		eCourses = Sistema.cargarSistema("sistematest.txt");
		eCourses.comprobarLogIn("1289", "JoA");
		eCourses.agregarSolicitud(eCourses.getAsignatura("Asignatura"));
		eCourses.guardarSistema("sistematest.txt");
		eCourses = Sistema.cargarSistema("sistematest.txt");
		eCourses.comprobarLogIn("0001", "passprof");
		assertEquals(true, eCourses.aceptarMatricula(eCourses.getMatricula("1289", "Asignatura")));
		
	}

	@Test
	public void testExpulsarAlumno() throws InvalidEmailAddressException, FailedInternetConnectionException, ClassNotFoundException, IOException {
		eCourses = Sistema.cargarSistema("sistematest.txt");
		eCourses.comprobarLogIn("1297", "Coero");
		eCourses.agregarSolicitud(eCourses.getAsignatura("Asignatura"));
		eCourses.comprobarLogIn("0001", "passprof");
		eCourses.aceptarMatricula(eCourses.getMatricula("1297", "Asignatura"));
		Expulsion exp1 = new Expulsion(false, eCourses.getAlumno("1297"), eCourses.getAsignatura("Asignatura"));
		assertEquals(true, eCourses.expulsarAlumno(exp1));
	}

	@Test
	public void testAgregarAsignatura() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertEquals(true, eCourses.agregarAsignatura("Asignatura2", true));
	}
	
	@Test
	public void testAgregarTema() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertEquals(true, eCourses.agregarTema("Tema 1", eCourses.getAsignatura("Asignatura"), true));
	}
	
	@Test
	public void testAgregarSubTema() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertEquals(true, eCourses.agregarSubtema("Subtema", eCourses.getTema("Tema 2"), true));
	}
	
	@Test
	public void testAgregarEjercicio() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertEquals(true, eCourses.agregarEjercicio(eCourses.getTema("Tema 2"), 10, 1, 1, 2017, 1, 1, 2018, "Ejercicio 1"));
	}
	
	@Test
	public void testAgregarApuntes() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertEquals(true, eCourses.agregarApuntes(eCourses.getTema("Tema 2"), "Contenido apuntes", 1, 1, 2017, true, "Apuntes 1"));
	}
	
	@Test
	public void testAgregarSolicitud() throws ClassNotFoundException, IOException {
		eCourses = Sistema.cargarSistema("sistematest.txt");
		eCourses.comprobarLogIn("1289", "JoA");
		assertEquals(true, eCourses.agregarSolicitud(eCourses.getAsignatura("Asignatura")));
	}

	@Test
	public void testComprobarEsProfesor() throws ClassNotFoundException, IOException {
		eCourses = Sistema.cargarSistema("sistematest.txt");
		eCourses.comprobarLogIn("0001", "passprof");
		assertEquals(true, eCourses.getEsProfesor());
	}




}
