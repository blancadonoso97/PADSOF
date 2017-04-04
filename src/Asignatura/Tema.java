package Asignatura;

import java.io.Serializable;
import java.util.ArrayList;

import Examen.Ejercicio;

/**
 * Clase para definir los temas de cada asignatura de la aplicacion
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class Tema implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private boolean visible;
	private Asignatura asig;
	
	ArrayList<Tema> temas = new ArrayList<Tema>();
	ArrayList<Apuntes> apuntes = new ArrayList<Apuntes>();
	ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();

	/**
	 * Constructor de la clase Tema
	 * @param asignatura Asignatura a la que pertenece
	 * @param newNombre Nombre del tema
	 * @param newVisible Visibilidad del tema
	 */
	public Tema(Asignatura asignatura, String newNombre, boolean newVisible){
		
		this.nombre = newNombre;
		this.visible = newVisible;
		this.asig = asignatura;
		
	}
	
	/**
	 * Agrega une ejercicio al tema
	 * @param ejercicio Ejercicio a agregar
	 * @return true si se anade correctamente, false en caso contrario
	 */
	public boolean agregarEjercicio(Ejercicio ejercicio){

		return ejercicios.add(ejercicio);
		
	}
	
	/**
	 * Agrega un apunte al tema
	 * @param apunte Apuntes a agregar
	 * @return true si se anade correctamente, false en caso contrario
	 */
	public boolean agregarApuntes(Apuntes apunte){

		return apuntes.add(apunte);
		
	}
	
	/**
	 * Agrega un subtema al tema
	 * @param tema Tema a agregar
	 * @return true si se anade correctamente, false en caso contrario
	 */
	public boolean agregarTema(Tema tema){

		return temas.add(tema);
		
	}
	
	/**
	 * Devuelve un apunte en funcion de su nombre
	 * @param nombreAp Nombre de los apuntes
	 * @return los apuntes si se encuentran en el tema, null en caso contrario
	 */
	public Apuntes getApunte(String nombreAp){
		
		for(Apuntes ap: apuntes){
		
			if(ap.getTitulo().equals(nombreAp) && ap.getVisible()==true){
				return ap;
			}
			
		}
		
		return null;
		
	}
	
	/**
	 * Devuelve un ejercicio en funcion de su nombre
	 * @param nombreEj Nombre del ejercicio
	 * @return el ejercicio si se encuentran en el tema, null en caso contrario
	 */
	public Ejercicio getEjercicio(String nombreEj){
		
		for(Ejercicio ej: ejercicios){
			
			if(ej.getNombre().equals(nombreEj)/* && ej.getVisible()==true*/){
				return ej;
			}
		}
		
		return null;
	}

	
	/**
	 * Set del nombre del tema
	 * @param newNombre Nuevo nombre
	 */
	public void setNombre(String newNombre){
		nombre = newNombre;
		
		
		return;
	}
	
	
	/**
	 * Set de la visibilidad
	 * @param visib Nueva visibilidad
	 */
	public void setVisibilidad(boolean visib){
		visible = visib;
		
		if(visible == false){
			for(Tema t: temas){
				t.setVisibilidad(false);
			}
			for(Apuntes ap: apuntes){
				ap.setVisible(false);
			}
			for(Ejercicio ej: ejercicios){
				ej.setVisible(false);
			}
		}
		
		return;
	}
	
	
	/**
	 * Get del nombre del tema
	 * @return nombre
	 */
	public String getNombre(){
		return nombre;
	}
	
	
	/**
	 * Get de la asignatura a la que pertenece el tema
	 * @return asig
	 */
	public Asignatura getAsignatura(){
		return asig;
	}
	
	/**
	 * Get del numero de subtemas dentro del tema
	 * @return tamano del array temas
	 */
	public Integer getNTemas(){
		return temas.size();
	}
	
	/**
	 * Get del numero de apuntes dentro del tema
	 * @return tamano del array apuntes
	 */
	public Integer getNApuntes(){
		return apuntes.size();
	}
	
	/**
	 * Get del numero de ejercicios dentro del tema
	 * @return tamano del array ejercicios
	 */
	public Integer getNEjercicios(){
		return ejercicios.size();
	}
	
	/**
	 * Obtiene un subtema del tema en funcion de su nombre
	 * @param nomTema Nombre del subtema a obtener
	 * @return el subtema si esta contenido en la tema, null en caso contrario
	 */
	public Tema getTema(String nomTema){
		
		for(Tema a: temas){
		
			if(a.getNombre().equals(nomTema) && a.esVisible()==true)
			return a;
			
		}
		
		return null;
	}
	
	/**
	 * Obtiene los ejercicios contenidos en le tema
	 * @return ejercicios
	 */
	public ArrayList<Ejercicio> getEjercicios(){
		return ejercicios;
	}
	
	/**
	 * Comprueba la visibilidad del tema. Si el tema no es visible, su contenido tampoco
	 * @return true si es visible, false en caso contrario
	 */
	public boolean esVisible(){
		
		if(this.visible==false){
			for(Tema t: temas){
				t.setVisibilidad(false);
			}
			for(Apuntes ap: apuntes){
				ap.setVisible(false);
			}
			for(Ejercicio ej: ejercicios){
				ej.setVisible(false);
			}
			return false;
		}else{
			return true;
		}	
	}
	
}
