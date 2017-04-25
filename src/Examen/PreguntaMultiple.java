package Examen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import eCourses.Alumno;

/**
 * 
 * Clase para definir una pregunta de opcion multiple
 * @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
 *
 */
public class PreguntaMultiple extends Pregunta implements Serializable{
	
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor de la clase PreguntaMultiple
	 * @param pregunta Enunciado de la pregunta
	 * @param punt Puntuacion
	 * @param ejercicio Ejercicio al que pertenece
	 * @param op Opciones de la pregunta
	 */
	public PreguntaMultiple(String pregunta,double puntC,double puntI,Ejercicio ejercicio,ArrayList<Opcion> op) {
		
	    super(pregunta,puntC,puntI,ejercicio,op);
	    this.setTipoPregunta(1);
	}
	
	
	/**
	 * Contesta a la pregunta modificando la respuesta de esta
	 * @param op Opciones marcadas por el alumno 
	 * @return true si se ha contestado correctament, false en caso contrario
	 */
	public void contestarPregunta(ArrayList<Opcion> op,Alumno alum) {
		
		RespuestaMultiple respM;
		
		if(!ejercicio.getOrdenado()){
			Collections.shuffle(opciones);
		}
		
		for (Opcion op1 : opciones) {
			for (Opcion o : op) {
				if (o.getEnunciado().equals(op1.getEnunciado()) && o.getPregunta().getEnunciado().equals(op1.getPregunta().getEnunciado())) {
					op1.setMarcada(true);	
				}
			}
		}
		
		respM = new RespuestaMultiple(this,alum);
		respM.calcularNota();
		this.anyadirRespuesta(respM);
		return;
	}
	
	/**
	 * Obtiene las opciones de la pregunta
	 * @return opciones
	 */
	public ArrayList<Opcion> getOpciones(){
		return opciones;
	}
	
	/**
	 * Set de las opciones de la pregunta
	 * @param op Array de opciones
	 */
	public void setOpciones(ArrayList<Opcion> op){
		opciones = op;
		return;
	}
	
	/**
	 * Obtiene el numero de respuestas en la pregunta
	 * @return respuestas.size()
	 */
	public int getNrespuestas(){
		return respuestas.size();
	}
	
	/**
	 * Obtiene el alumno que contesta
	 * @param respM Respuesta de tipo multiple del alumno
	 * @return el alumno, null en caso contrario
	 */
	public Alumno getAlumno(RespuestaMultiple respM){
	
		for(Respuesta re:respuestas){
		
			if(re.equals(respM)){
				return re.getAlumno();
			}
			
		}
		
		return null;
	}
	
	
}
