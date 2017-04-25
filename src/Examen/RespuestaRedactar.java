package Examen;


import java.io.Serializable;

import eCourses.Alumno;

/**
 * 
 * Clase para definir una pregunta de tipo redactar
 * @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
 *
 */
public class RespuestaRedactar extends Respuesta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private PreguntaRedactar pregunta;
	private String respAlu;
	
	/**
	 * Constructor de la clase RespuestaRedactar
	 * 
	 * @param preg Pregunta a la que pertenece
	 * @param al Alumno que contesta
	 * @param respAlu Respuesta del alumno
	 */
	public RespuestaRedactar(PreguntaRedactar preg,Alumno al,String respAlu){
		
		super(al);
		this.respAlu=respAlu;
		this.pregunta=preg;
		
	}
	
	/**
	 * Calcula la nota de la pregunta
	 */
	public void calcularNota(){
		
		for(Opcion o: pregunta.getOpciones()){
			
			if(o.getEnunciado().equals(respAlu) && o.getEsCorrecta()){
				this.setNota(this.pregunta.getPuntuacionCorrecta());
				return;
				
			}
		}
		
		this.setNota(this.pregunta.getPuntuacionIncorrecta());
		return;
	}
	
}
