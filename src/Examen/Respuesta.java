package Examen;


import java.io.Serializable;

import eCourses.Alumno;


/**
 * Clase para definir las respuesta de las preguntas de los ejercicios
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public abstract class Respuesta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Alumno alumno;
	private double nota;
	private boolean realizado;
	
	/**
	 * Constructor de la clase Respuesta
	 * 
	 * @param alumno Alumno que responde
	 */
	public Respuesta(Alumno alumno){
		this.alumno=alumno;
		this.nota=0;
	}
	
	/**
	 * Get del alumno que responde
	 * @return alumno
	 */
	public Alumno getAlumno(){
		return alumno;
	}
	
	/**
	 * Get de la nota de la respuesta
	 * @return nota
	 */
	public double getNota(){
		return nota;
	}
	
	/**
	 * Set de la nota de la respuesta
	 * @param not Nota
	 */
	public void setNota(double not){
		nota=not;
		return;
	}
	
	/**
	 * Set del estado de la respuesta
	 * @param r1 Estado de realizacion
	 */
	public void setRealizado(boolean r1){
		realizado = r1;
		return;
	}
	
	/**
	 * Obtiene el estado de realizacion
	 * @return realizado
	 */ 
	public boolean getRealizado(){
		return realizado;
	}
}
