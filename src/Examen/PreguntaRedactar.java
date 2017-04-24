package Examen;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import eCourses.Alumno;

/**
 * Clase para definir las preguntas de tipo redactar
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PreguntaRedactar extends Pregunta implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	

	
	/**
	 * Constructor de la clase PreguntaRedactar
	 * @param pregunta Titulo de la pregunta
	 * @param punt Puntuacion
	 * @param ejercicio Ejercicio al que pertenece
	 * @param op Array de opciones que contiene
	 */
	public PreguntaRedactar(String pregunta,double puntC,double puntI,Ejercicio ejercicio,ArrayList<Opcion> op){
		super(pregunta,puntC,puntI,ejercicio,op);
	    
	    this.setTipoPregunta(2);
	}
	
	/**
	 * Contesta la pregunta de tipo redactar
	 * @param alum Alumno que contesta
	 * @param resp Respuesta del alumno
	 */
	public void contestarPregunta(Alumno alum, String resp){
		Collections.shuffle(opciones);
		
		RespuestaRedactar respR = new RespuestaRedactar(this,alum,resp);
		respR.calcularNota();
		this.anyadirRespuesta(respR);
		
	
		return;
	}
	
	/**
	 * Obtiene el array de opciones de la pregunta
	 * @return opciones
	 */
	public ArrayList<Opcion> getOpciones(){
		return opciones;
	}
	
	/**
	 * Obtiene el tamano del array de opciones de la pregunta
	 * @return respuestas.size()
	 */
	public int getNrespuestas(){
		return respuestas.size();
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
	 * Obtiene el alumno que contesta
	 * @param respM Respuesta del alumno
	 * @return el alumno si ha respondido, null en caso contrario
	 */
	public Alumno getAlumno(RespuestaRedactar respM){
		for(Respuesta re:respuestas){
			if(re.equals(respM)){
				return re.getAlumno();
			}
		}
		return null;
	}
}
