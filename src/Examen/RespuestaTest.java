package Examen;


import java.io.Serializable;

import eCourses.Alumno;

/**
 * Clase para definir las respuestas para las preguntas de tipo opcion unica (test)
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class RespuestaTest extends Respuesta implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private PreguntaTest pregunta;
	
	/**
	 * Constructor de la clase RespuestaTest
	 * 
	 * @param preg Pregunta a la que pertenece
	 * @param al Alumno que contesta
	 */
	public RespuestaTest(PreguntaTest preg,Alumno al){
		
		super(al);
		
		this.pregunta=preg;
		
	}
	
	/**
	 * Comprueba que la respuesta elegida por el alumno sea correcta y este marcada
	 */
	public void calcularNota(){
		
		for(Opcion o: pregunta.getOpciones()){
			if(o.getMarcada()==true && o.getEsCorrecta()==true){
				this.setNota(this.pregunta.getPuntuacion());
				return;
			}
		}
		
		return;
	}
	
	
}
