package Examen;


import java.io.Serializable;

import eCourses.Alumno;

/**
 * Clase para definir las respuestas para las preguntas de tipo opcion multiple
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class RespuestaMultiple extends Respuesta implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private PreguntaMultiple pregunta;
	
	
	/**
	 * Constructor de la clase RespuestaMultiple
	 * 
	 * @param preg Pregunta a la que pertenece
	 * @param al Alumno que contesta
	 */
	public RespuestaMultiple(PreguntaMultiple preg,Alumno al){
		
		super(al);
		
		this.pregunta=preg;
		

	}
	
	/**
	 * Comprueba que las respuestas marcadas sean las correctas
	 * @return true si se ha marcado una opcion, false en caso contrario
	 */
	public void calcularNota(){
		double nota;
		int preguntasCor=0;
		int preguntasInc = 0;
		
		for(Opcion o: pregunta.getOpciones()){
			
			if(o.getMarcada() && o.getEsCorrecta()){
				preguntasCor++;
			}
			
			else if(o.getMarcada() && o.getEsCorrecta()==false){
				preguntasInc++;
			}
			else if(o.getMarcada()==false && o.getEsCorrecta()){
				preguntasInc++;
			}
		}
		
	
	preguntasCor*= pregunta.getPuntuacionCorrecta();
	preguntasInc*=pregunta.getPuntuacionIncorrecta();
	nota = preguntasCor - preguntasInc;
	
	this.setNota(nota);
	return;
	}
	
}