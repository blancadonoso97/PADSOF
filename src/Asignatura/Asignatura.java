package Asignatura;
import java.io.Serializable;
import java.util.*;
import eCourses.Estadistica;
import eCourses.Alumno;

/**
* 
* Clase para definir las asignaturas de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class Asignatura implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private boolean visible;
	
	ArrayList<Tema> temas = new ArrayList<Tema>();
	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	ArrayList<Estadistica> estadisticas = new ArrayList<Estadistica>();
	
	
	/**
	 * Constructor de la clase asignatura
	 * 
	 * @param newNombre Nombre de la asignatura
	 * @param visibilidad Visibilidad de la asignatura
	 */
	public Asignatura(String newNombre, boolean visibilidad){
		
		this.nombre = newNombre;
		this.visible = visibilidad;
	}
	
	/**
	 * Devuelve los temas contenidos en la asignatura
	 * @return temas
	 */
	public ArrayList<Tema> accederTema(){
		
		return temas;
	}
	
	/**
	 * Agrega un tema a la asignatura
	 * @param tema Tema a agregar
	 * @return true si se anade correctamente, false en caso contrario
	 */
	public boolean agregarTema(Tema tema){
		
		return temas.add(tema);
		
	}
	
	/**
	 * Agrega una estadistica a la asignatura
	 * @param est Estadistica a agregar
	 * @return true si se anade correctamente, false en caso contrario
	 */
	public boolean agregarEstadistica(Estadistica est){
		return estadisticas.add(est);
	}
	
	
	/**
	 * Agrega un alumno a la asignatura
	 * @param alum Alumno a agregar
	 * @return true si se anade correctamente, false en caso contrario
	 */
	public boolean agregarAlumno(Alumno alum){
		
		return alumnos.add(alum);
	}
	
	/**
	 * Devuelve los alumnos matriculados en la asignatura
	 * @return alumnos
	 */
	public ArrayList<Alumno> getAlumnos(){
		return alumnos;
	}
	
	
	/**
	 * Set del nombre de la asignatura
	 * @param newNombre Nombre de la asignatura
	 */
	public void setNombre(String newNombre){
		
		nombre = newNombre;
		return;
	}
	
	
	/**
	 * Set de la visibilidad de la asignatura
	 * @param newVisible Visibilidad de la asignaturas
	 */
	public void setVisible(boolean newVisible){
		
		visible = newVisible;
		
		if(visible == false){
			for(Tema t: temas){
				t.setVisibilidad(false);
			}
		}
		return;
	}
	
	/**
	 * 
	 * @return nombre Nombre de la asignatura
	 */
	public String getNombre(){
		
		return nombre;
	}
	
	/**
	 * Devuelve el numero de temas contenidos en la asignatura
	 * @return temas.size() Numero de temas en la asignatura (tamano del arraylist de temas)
	 */
	public Integer getNTemas(){
		
		return temas.size();
	}
	
	/**
	 * Devuelve la visibilidad de la asignatura
	 * @return visible
	 */
	public boolean getVisible(){
		return visible;
	}
	
	/**
	 * Obtiene un tema de la asignatura en funcion de su nombre
	 * @param nomTema Nombre del tema a obtener
	 * @return el tema si esta contenido en la asignatura, null en caso contrario
	 */
	public Tema getTema(String nomTema){
		
		for(Tema a: temas){
			
			if(a.getNombre().equals(nomTema)){
				return a;
			}
			
		}
		
		return null;
	}
	
	/**
	 * Obtiene los temas contenidos en la asignatura
	 * @return temas
	 */
	public ArrayList<Tema> getTemas(){
		return temas;
	}
	
	/**
	 * Obtiene un alumno de la asignatura en funcion de su id
	 * @param idAlum Id del alumno a obtener
	 * @return el alumno si esta contenido en la asignatura, null en caso contrario
	 */
	public Alumno getAlumno(String idAlum){
		
		for (Alumno a: alumnos){
			if(a.getId().equals(idAlum)){
				return a;
			}
				
		}
		
		return null;
		
	}
	
	/**
	 * Comprueba la visibilidad de la asignatura. Si la asignatura no es visible, los temas dentro de ella tampoco
	 * @return true si es visible, false en caso contrario
	 */
	public boolean esVisible(){
		
		if(this.visible==false){
			for(Tema t: temas){
				t.setVisibilidad(false);
			}
			return false;
		}else{
			return true;
		}	
	}
}
