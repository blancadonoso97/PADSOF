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
	private int preguntasCorrectas;
	
	
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
		int preguntasTotalesCorrectas=0;
		int preguntasInc = 0;
		
		for(Opcion o: pregunta.getOpciones()){
			
			if(o.getMarcada() && o.getEsCorrecta()){
				preguntasCorrectas++;
			}
			
			else if(o.getMarcada() && o.getEsCorrecta()==false){
				preguntasInc++;
			}
		}
		
		for(Opcion o: pregunta.getOpciones()){
			
			if(o.getEsCorrecta()){
				preguntasTotalesCorrectas++;
			}
		}
		
		if(preguntasTotalesCorrectas == preguntasCorrectas && preguntasInc == 0){
			this.setNota(this.pregunta.getPuntuacion());
			return;
		}
		
		else if(preguntasTotalesCorrectas == preguntasCorrectas && preguntasInc > 0){
		
			nota=this.pregunta.getPuntuacion();
			
			(nota) /= ((double)preguntasTotalesCorrectas);
			
			nota*=preguntasCorrectas;
			
			this.setNota(nota);
			
			return;
		}
		else{
			
			nota=this.pregunta.getPuntuacion();
			
			(nota) /= ((double)preguntasTotalesCorrectas);
			
			nota*=preguntasCorrectas;
			
			this.setNota(nota);
			
			return;
		}
	}
	
	
}