package eCourses;
import java.io.Serializable;
import java.util.Calendar;

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
	private Calendar fechaIniExp = Calendar.getInstance();
	private Calendar fechaFinExp = Calendar.getInstance();
	private Alumno alumno;
	private Asignatura asignatura;
	
	/**
	 * Constructor de la clase Expulsion
	 * 
	 * @param newExpulsado Estado de la expulsion
	 * @param diaI Dia de inicio
	 * @param mesI Mes de inicio
	 * @param anyoI Anyo de inicio
	 * @param diaF Dia de finalizacion
	 * @param mesF Mes de finalizacion
	 * @param anyoF Anyo de finalizacion
	 * @param newAlumno Alumno expulsado
	 * @param newAsig Asignatura de la que el alumno esta expulsado
	 */
	public Expulsion(boolean newExpulsado, int diaI, int mesI, int anyoI, int diaF, int mesF, int anyoF, Alumno newAlumno, Asignatura newAsig){
		
		this.expulsado = newExpulsado;
		this.fechaIniExp.set(Calendar.YEAR, anyoI);
		this.fechaIniExp.set(Calendar.MONTH, mesI);
		this.fechaIniExp.set(Calendar.DATE, diaI);
		this.fechaFinExp.set(Calendar.YEAR, anyoF);
		this.fechaFinExp.set(Calendar.MONTH, mesF);
		this.fechaFinExp.set(Calendar.DATE, diaF);
		this.alumno = newAlumno;
		this.asignatura = newAsig;
		
	}
	
	/**
	 * Comprueba si la fecha actual esta entre la fecha de inicio y fin de la expulsion
	 * @param fechaActual Fecha actual del sistema cuando realiza la comprobacion
	 * @return true si la expulsion es vigente, false en caso contrario
	 */
	public boolean comprobarFecha(Calendar fechaActual){
		
		if (fechaIniExp.compareTo(fechaActual) < 0 && fechaFinExp.compareTo(fechaActual) > 0){
			expulsado = true;
			return true;
		}else
			return false;
		
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
	 * Set de la fecha de inicio de la expulsion
	 * @param newFechaIni Fecha inicio del periodo de expulsion
	 */
	public void setFechaIniExp(Calendar newFechaIni){
		
		fechaIniExp = newFechaIni;
		return;
		
	}
	
	/**
	 * Set de la fecha de finalizacion de la expulsion
	 * @param newFechaFin Fecha fin del periodo de expulsion
	 */
	public void setFechaFinExp(Calendar newFechaFin){
		
		fechaFinExp = newFechaFin;
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
	 * Get de la fecha de inicio de la expulsion
	 * @return fechaIniExp Fecha inicio del periodo de expulsion
	 */
	public Calendar getFechaIniExp(){
		return fechaIniExp;
	}
	
	/**
	 * Get de la fecha de fin de la expulsion
	 * @return fechaFinExp Fecha fin del periodo de expulsion
	 */
	public Calendar getFechaFinExp(){
		return fechaFinExp;
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
