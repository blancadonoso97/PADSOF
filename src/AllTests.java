import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Asignatura.ApuntesTest;
import Asignatura.AsignaturaTest;
import Asignatura.TemaTest;
import Examen.EjercicioTest;
import Examen.OpcionTest;
import Examen.PreguntaMultipleTest;
import Examen.PreguntaRedactarTest;
import Examen.PreguntaTestTest;
import Examen.RespuestaMultipleTest;
import Examen.RespuestaRedactarTest;
import Examen.RespuestaTestTest;
import eCourses.AlumnoTest;
import eCourses.ExpulsionTest;
import eCourses.SistemaTest;
import eCourses.SolicitudMatriculaTest;

/**
* 
* Clase para definir el test que ejecuta todos los test existentes en la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/

@RunWith(Suite.class)
@SuiteClasses({
	ApuntesTest.class,
	AsignaturaTest.class,
	TemaTest.class,
	AlumnoTest.class,
	ExpulsionTest.class,
	SistemaTest.class,
	SolicitudMatriculaTest.class,
	EjercicioTest.class,
	OpcionTest.class,
	PreguntaMultipleTest.class,
	PreguntaRedactarTest.class,
	PreguntaTestTest.class,
	RespuestaMultipleTest.class,
	RespuestaRedactarTest.class,
	RespuestaTestTest.class
})

public class AllTests {

}