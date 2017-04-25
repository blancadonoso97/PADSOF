package Examen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import eCourses.Alumno;

/**
 * Clase para definir las preguntas de tipo test
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PreguntaTest extends Pregunta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor de la clase PreguntaTest
	 * @param pregunta Enunciado de la pregunta
	 * @param punt Puntuacion
	 * @param ejercicio Ejercicio al que pertenece
	 * @param op Array de opciones de la pregunta
	 */
	public PreguntaTest(String pregunta,double puntC,double puntI,Ejercicio ejercicio,ArrayList<Opcion> op) {
		
	    super(pregunta,puntC,puntI,ejercicio,op);
	    this.setTipoPregunta(3);
	}

	/**
	 * Guarda la opcion elegida por el alumno como correcta en su variable respuesta
	 * @param op Opcion marcada por el alumno
	 * @return true si se contesta correctamente, false en caso contrario
	 */
	public boolean contestarPregunta(Opcion op,Alumno al){
		
		RespuestaTest respT;
		
		if(!ejercicio.getOrdenado()){
			Collections.shuffle(opciones);
		}
	
		op.setMarcada(true);
				
		respT =  new RespuestaTest(this,al);
		respT.calcularNota();
		anyadirRespuesta(respT);
				
		return true;
			
	
	}

	/**
	 * Obtiene el array de opciones de la pregunta
	 * @return opciones
	 */
	public ArrayList<Opcion> getOpciones(){
		return opciones;
	}
	
	/**
	 * Set del array de opciones de la pregunta
	 * @param op Array de opciones
	 */
	public void setOpciones(ArrayList<Opcion> op){
		opciones = op;
		return;
	}
	
	/**
	 * Obtiene el numero de respuestas almacenadas
	 * @return respuestas.size()
	 */
	public int getNrespuestas(){
		return respuestas.size();
	}
	
	/**
	 * Obtiene el numero de opciones de la respuesta
	 * @return opciones.size()
	 */
	public int getNopciones(){
		return opciones.size();
	}
	
	/**
	 * Obtiene el alumno que contesta
	 * @param respM Respuesta de tipo multiple del alumno
	 * @return el alumno, null en caso contrario
	 */
	public Alumno getAlumno(RespuestaTest respM){
		
		
		for(Respuesta re:respuestas){
			if(re.equals(respM)){
				return re.getAlumno();
			}
		}
		return null;
	}
}