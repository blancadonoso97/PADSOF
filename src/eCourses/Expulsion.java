package eCourses;
import java.io.Serializable;

import Asignatura.Asignatura;

/**
* 
* Clase para definir la expulsion de una asignatura
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class Expulsion implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean expulsado;
	private Alumno alumno;
	private Asignatura asignatura;
	
	/**
	 * Constructor de la clase Expulsion
	 * 
	 * @param newExpulsado Estado de la expulsion
	 * @param newAlumno Alumno expulsado
	 * @param newAsig Asignatura de la que el alumno esta expulsado
	 */
	public Expulsion(boolean newExpulsado, Alumno newAlumno, Asignatura newAsig){
		
		this.expulsado = newExpulsado;
		this.alumno = newAlumno;
		this.asignatura = newAsig;
		
	}
	
	/**
	 * Set del estado de la expulsion
	 * @param newExpulsado Marca si la expulsion esta vigente o no
	 */
	public void setExpulsado(boolean newExpulsado){
		
		expulsado = newExpulsado;
		return;
		
	}
		
	/**
	 * Set del alumno
	 * @param newAlum Alumno expulsado
	 */
	public void setAlumno(Alumno newAlum){
		alumno = newAlum;
		return;
	}
	
	/**
	 * Set de la asignatura
	 * @param newAsig Asignatura de la expulsion
	 */
	public void setAsignatura(Asignatura newAsig){
		asignatura = newAsig;
		return;
	}
	
	/**
	 * Get del estado de la expulsion
	 * @return expulsado Marca si la expulsion esta vigente o no
	 */
	public boolean getExpulsado(){
		return expulsado;
	}
	
	/**
	 * Get del alumno expulsado
	 * @return alumno Alumno expulsado
	 */
	public Alumno getAlumno(){
		return alumno;
	}
	
	/**
	 * Get de la asignatura de la que ha sido expulsado el alumno
	 * @return asignatura Asignatura de la que ha sido expulsado el alumno
	 */
	public Asignatura getAsignatura(){
		return asignatura;
	}
	
}
