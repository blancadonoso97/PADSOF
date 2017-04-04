package eCourses;

import java.io.Serializable;
import Asignatura.Asignatura;
import Examen.Ejercicio;


/**
 * 	Clase para definir las estadisticas de los ejercicios
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class Estadistica implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Asignatura asignatura;
	
	/**
	 * Contructor de la clase Estadistica
	 * 
	 * @param asignatura Asignatura a la que pertenece la estadistica
	 */
	public Estadistica(Asignatura asignatura){
	
		this.asignatura = asignatura;
	}
	
	/**
	 * Obtiene la asignatura a la que pertenece la estadistica
	 * @return asignatura
	 */
	public Asignatura getAsignatura(){
		return asignatura;
	}
	
	/**
	 * Devuelve el porcentaje de alumnos que han realizado un ejercicio
	 * @param ej Ejercicio a comprobar
	 * @return 100*res Porcentaje
	 */
	public double getPorcentajeAlumnosRealizado(Ejercicio ej){
		double res;
		
		res = (double) ej.getNAlumnos() / asignatura.getAlumnos().size();
		
		return 100*res;
		}
	
	
	/**
	 * Devuelve el porcentaje de alumnos que han contestado un ejercicio correctamente
	 * @param ej Ejercicio a comprobar
	 * @return res*100 Porcentaje
	 */
	public double getPorcentajeAlumnosReCorrectamente(Ejercicio ej){
		int alumnosExaminadosCorr = 0;
		double res;
		
		for(Alumno al: ej.getAlumnos()){
			if(ej.calcularNota(al) == ej.getPeso()){
				alumnosExaminadosCorr++;
			}
		}
		
		 res =(double) alumnosExaminadosCorr / ej.getAlumnos().size();
		 
		 return res*100;
	}
}
