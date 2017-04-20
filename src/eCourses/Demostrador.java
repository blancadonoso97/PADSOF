package eCourses;

import java.io.IOException;
import java.util.ArrayList;

import Asignatura.Asignatura;
import Asignatura.Tema;
import Examen.Opcion;
import Examen.PreguntaMultiple;
import Examen.PreguntaRedactar;
import Examen.PreguntaTest;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase para comprobar la funcionalidad de la aplicacion
 * 
 * @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
 *
 */
public class Demostrador {

	public static void main(String[] args) throws ClassNotFoundException, IOException, InvalidEmailAddressException, FailedInternetConnectionException{
		
		/* Se inicia el sistema desde el usuario profesor
		 * esProf = true
		 * logIn = true
		 */
		Sistema sistema = new Sistema("0001", "passprof", "archivoProf.txt", "archivoAlum.txt");	
		
		System.out.println("EsProfesor = " + sistema.getEsProfesor());
		System.out.println("Log In = " + sistema.getLogIn());
		
		/* Agregar una asignatura visible*/
		sistema.agregarAsignatura("Adsof", true);
		
		/* Asig1 = Adsof*/
		Asignatura asig1 = sistema.getAsignatura("Adsof");
		
		/* Agregar un tema visible*/
		sistema.agregarTema("Tema 1", asig1, true);
		
		Tema tema1 = asig1.getTema("Tema 1");
		
		/* Agregar un ejercicio visible*/
		sistema.agregarEjercicio(sistema.getAsignatura("Adsof").getTema("Tema 1"), 10, 1, 1, 2017, 31, 12, 2017, "Ejercicio 1");
		
		/* Creamos dos respuestas (opciones) posibles para una pregunta de tipo redactar*/
		ArrayList<Opcion> opciones1 = new ArrayList<Opcion>();

		
		PreguntaRedactar p1 = new PreguntaRedactar("¿Cuanto es 1 + 1?", 5, sistema.getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1"), opciones1);
		
		
		Opcion op1 = new Opcion("Dos", true,p1);
		Opcion op2 = new Opcion("2", true,p1);
		
		opciones1.add(op1);
		opciones1.add(op2);
		p1.setOpciones(opciones1);
		sistema.getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1").AgregarPregunta(p1);
		
		/* Creamos 3 opciones para una pregunta de tipo test (respuesta unica)*/
		ArrayList<Opcion> opciones2 = new ArrayList<Opcion>();
		
		PreguntaTest p2 = new PreguntaTest("¿Cuanto es 2 + 1?", 3, sistema.getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1"), opciones2);
		
		

		Opcion op12 = new Opcion("2", true,p2);
		Opcion op22 = new Opcion("3", false,p2);
		Opcion op32 = new Opcion("0", false,p2);
		
		opciones2.add(op12);
		opciones2.add(op22);
		opciones2.add(op32);
		
		p2.setOpciones(opciones2);
		
		sistema.getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1").AgregarPregunta(p2);
		
		/* Creamos 3 opciones para una pregunta de tipo test multiple*/
		ArrayList<Opcion> opciones3 = new ArrayList<Opcion>();

		
		PreguntaMultiple p3 = new PreguntaMultiple("¿Cuanto es 2 + 2?", 2, sistema.getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1"), opciones3);
		
		Opcion op13 = new Opcion("4", true,p3);
		Opcion op23 = new Opcion("Cuatro", true,p3);
		Opcion op33 = new Opcion("Ocho", false,p3);
		
		opciones3.add(op13);
		opciones3.add(op23);
		opciones3.add(op33);
		p3.setOpciones(opciones3);
		sistema.getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1").AgregarPregunta(p3);
		
		/* Agregar apuntes visibles*/
		sistema.agregarApuntes(tema1, "Esto es una prueba del contenido de unos apuntes", 1, 1, 2017, true, "Apuntes 1");
		
		/* Agregar un subtema visible*/
		sistema.agregarSubtema("Subtema 1", tema1, true);
		
		/* Agregar una asignatura no visible*/
		sistema.agregarAsignatura("Padsof", false);
		
		/* Asig2 = Padsof*/
		Asignatura asig2 = sistema.getAsignatura("Padsof");
		
		/* Agregar un tema visible a una asignatura no visible*/
		sistema.agregarTema("Tema 1", asig2, true);
		
		/* Guarda el sistema (Log out)*/
		sistema.guardarSistema("sistema.txt");
		
		/* Carga el sistema
		 * esProfesor = false
		 * logIn = false
		 */
		sistema = Sistema.cargarSistema("sistema.txt");
				
		/* Inicia sesion desde un alumno
		 * Alumno = Jorge Alcazar
		 */
		sistema.comprobarLogIn("1289", "JoA");
		System.out.println("EsProfesor = " + sistema.getEsProfesor());
		System.out.println("Log In = " + sistema.getLogIn());
		System.out.println("Id usuario logueado = " + sistema.getAlumnoLog().getId());
		
		/* El alumno logueado realiza una solicitud de matricula en asig1(visible) y asig2 (no visible)*/
		if(sistema.agregarSolicitud(asig1)){
			System.out.println(asig1.getNombre() + " -> Solicitud agregada");
		}
		
		/* Como la asignatura no es visible, no agrega la solicitud*/
		if(sistema.agregarSolicitud(asig2)){
			System.out.println(asig2.getNombre() + " -> Solicitud agregada");
		}
		 
		/* Como no puede hacer nada, el alumno se desconecta*/
		sistema.guardarSistema("sistema.txt");
		
		sistema = Sistema.cargarSistema("sistema.txt");
		
		/* Inicia sesion desde un alumno
		 * Alumno = Roberto Paz
		 */
		sistema.comprobarLogIn("5766", "Rerto");
		System.out.println("EsProfesor = " + sistema.getEsProfesor());
		System.out.println("Log In = " + sistema.getLogIn());
		System.out.println("Id usuario logueado = " + sistema.getAlumnoLog().getId());
		
		/* El alumno logueado realiza una solicitud de matricula en asig1(visible)*/
		if(sistema.agregarSolicitud(asig1)){
			System.out.println(asig1.getNombre() + " -> Solicitud agregada");
		}
		
		/* Como no puede hacer nada, el alumno se desconecta*/
		sistema.guardarSistema("sistema.txt");
		
		/* Carga el sistema
		 * esProfesor = false
		 * logIn = false
		 */
		sistema = Sistema.cargarSistema("sistema.txt");
		
		/* Inicia la sesion como profesor
		 * esProfesor = true
		 * logIn = true
		 */
		sistema.comprobarLogIn("0001", "passprof");
		System.out.println("EsProfesor = " + sistema.getEsProfesor());
		System.out.println("Log In = " + sistema.getLogIn());
		
		/* El profesor acepta la matricula realizadas por el alumno 1289*/
		SolicitudMatricula sol1 = sistema.getMatricula("1289", "Adsof");
		SolicitudMatricula sol2 = sistema.getMatricula("5766", "Adsof");
		
		sistema.aceptarMatricula(sol1);
		sistema.aceptarMatricula(sol2);
		
		/* Acceder/realizar ejercicio visible*/
		ArrayList <Opcion> opcionesAlum = new ArrayList<Opcion>();
		opcionesAlum.add(op1);
		opcionesAlum.add(op23);
		
		if(sistema.getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1").realizarEjercicio(sistema.getAlumnoLog(),opcionesAlum) == false){
			System.out.println("El profesor no puede realizar un ejercicio");
		}
		

				
		/* El profesor se desconecta*/
		sistema.guardarSistema("sistema.txt");
		
		/* Carga el sistema
		 * esProfesor = false
		 * logIn = false
		 */
		sistema = Sistema.cargarSistema("sistema.txt");
		
		/* Inicia sesion desde un alumno
		 * Alumno = Jorge Alcazar
		 */
		sistema.comprobarLogIn("1289", "JoA");
		System.out.println("EsProfesor = " + sistema.getEsProfesor());
		System.out.println("Log In = " + sistema.getLogIn());
		System.out.println("Id usuario logueado = " + sistema.getAlumnoLog().getId());
		
		System.out.println();	
		System.out.println("El usuario accede a los apuntes 1 del tema 1 de adsof");
		sistema.getAlumnoLog().getAsignatura("Adsof").getTema("Tema 1").getApunte("Apuntes 1").mostrarApuntes();
		System.out.println();
		
		/* Acceder/realizar ejercicio visible*/
		ArrayList <Opcion> opcionesAlum1 = new ArrayList<Opcion>();
		opcionesAlum1.add(op2);
		opcionesAlum1.add(op33);
		opcionesAlum1.add(op22);
		
		
		sistema.getAlumnoLog().getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1").realizarEjercicio(sistema.getAlumnoLog(),opcionesAlum1);
		System.out.println("El alumno ha sacado en el ejercicio un: " + sistema.getAlumnoLog().getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1").calcularNota(sistema.getAlumnoLog()));
		
		
		if(sistema.getAlumnoLog().getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1").realizarEjercicio(sistema.getAlumnoLog(),opcionesAlum1) == false ){
			System.out.println("Este alumno ya realizó el ejercicio anteriormente, no puede volver a realizarlo");
		}
		/* El alumno se desconecta*/
		sistema.guardarSistema("sistema.txt");
		
		
		sistema = Sistema.cargarSistema("sistema.txt");
		
		/* Inicia sesion desde un alumno
		 * Alumno = Roberto Paz
		 */
		sistema.comprobarLogIn("5766", "Rerto");
		System.out.println("EsProfesor = " + sistema.getEsProfesor());
		System.out.println("Log In = " + sistema.getLogIn());
		System.out.println("Id usuario logueado = " + sistema.getAlumnoLog().getId());
		
		System.out.println();	
		System.out.println("El usuario accede a los apuntes 1 del tema 1 de adsof");
		sistema.getAlumnoLog().getAsignatura("Adsof").getTema("Tema 1").getApunte("Apuntes 1").mostrarApuntes();
		System.out.println();
		
		/* Acceder/realizar ejercicio visible*/
		ArrayList <Opcion> opcionesAlum2 = new ArrayList<Opcion>();
		opcionesAlum2.add(op2);
		opcionesAlum2.add(op12);
		opcionesAlum2.add(op13);
		opcionesAlum2.add(op23);
		
		
		sistema.getAlumnoLog().getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1").realizarEjercicio(sistema.getAlumnoLog(),opcionesAlum2);
		System.out.println("El alumno ha sacado en el ejercicio un: " + sistema.getAlumnoLog().getAsignatura("Adsof").getTema("Tema 1").getEjercicio("Ejercicio 1").calcularNota(sistema.getAlumnoLog()));
		
		/* Carga el sistema
		 * esProfesor = false
		 * logIn = false
		 */
		sistema = Sistema.cargarSistema("sistema.txt");
		
		/* Inicia la sesion como profesor
		 * esProfesor = true
		 * logIn = true
		 */
		sistema.comprobarLogIn("0001", "passprof");
		System.out.println("EsProfesor = " + sistema.getEsProfesor());
		System.out.println("Log In = " + sistema.getLogIn());
		
		/* El profesor expulsa al alumno 1289 de la asignatura Adsof*/
		Expulsion exp1 = new Expulsion(false, 1, 1, 2017, 1, 1, 2018, sistema.getAlumno("1289"), sistema.getAsignatura("Adsof"));
		
		sistema.expulsarAlumno(exp1);
		
		/* El profesor se desconecta*/
		sistema.guardarSistema("sistema.txt");
		
		/* Carga el sistema
		 * esProfesor = false
		 * logIn = false
		 */
		sistema = Sistema.cargarSistema("sistema.txt");
		
		/* Inicia sesion desde un alumno
		 * Alumno = Jorge Alcazar
		 */
		sistema.comprobarLogIn("1289", "JoA");
		System.out.println("EsProfesor = " + sistema.getEsProfesor());
		System.out.println("Log In = " + sistema.getLogIn());
		System.out.println("Id usuario logueado = " + sistema.getAlumnoLog().getId());
		
		/* El usuario 1289 ha sido expulsado del tema adsof por lo que no puede acceder a su contenido*/
		System.out.println();	
		System.out.println("Comprobamos que el alumno esta expulsado");	
		if (sistema.comprobarExpulsion(sistema.getAlumnoLog(), sistema.getAsignatura("Adsof"), sistema.getExpulsion(sistema.getAlumnoLog().getId(), sistema.getAsignatura("Adsof").getNombre()))){
			System.out.println("No puedes acceder a la asignatura");
		}
		System.out.println();
				
		System.out.println("Final del demostrador\n");
				
		return;
		
	}
	
}
