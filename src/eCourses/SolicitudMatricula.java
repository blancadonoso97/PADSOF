
package eCourses;

import java.io.Serializable;

import Asignatura.Asignatura;

/**
 * Clase para definir las solicitudes de matriculas de los alumnos
 * @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
 *
 */
public class SolicitudMatricula implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private boolean aceptada;
	private Alumno alumno;
	private Asignatura asignatura;
	
	/**
	 * Constructor de la clase SolicitudMatricula
	 * 
	 * @param alum Alumno que solicita matricularse
	 * @param asig Asignatura donde se desea matricular al alumno
	 * @param b1 Estado de la solicitud
	 */
	public SolicitudMatricula(Alumno alum, Asignatura asig, boolean b1){
	
		this.aceptada = b1;
		this.alumno = alum;
		this.asignatura = asig;				
	}
	
		
	/**
	 * Set del estado de la matricula
	 * @param b1 Nuevo estado de la matricula
	 */
	public void setMatricula(boolean b1){
		aceptada = b1;
		return;
	}
	
	
	/**
	 * Set del alumno
	 * @param a1 Alumno que solicita la matricula
	 */
	public void setAlumno(Alumno a1){
		alumno=a1;
		return;
	}
	
	/**
	 * Set de la asignatura
	 * @param as1 Asignatura donde se desea matricular
	 */
	public void setAsignatura(Asignatura as1){
		asignatura= as1;
		return;
	}
	
	/**
	 * Devuelve el estado de la matricula (aceptada o no)
	 * @return aceptada
	 */
	public boolean getMatricula(){
		return aceptada;
	}
	
	/**
	 * Devuelve el alumno que hizo la solicitud
	 * @return alumno
	 */
	public Alumno getAlumno(){
		return alumno;
	}
	
	/**
	 * Devuelve la asignatura de la solicitud
	 * @return asignatura
	 */
	public Asignatura getAsignatura(){
		return asignatura;
	}
	

}
