package eCourses;

import java.io.Serializable;
import java.util.*;

import Asignatura.Asignatura;

/**
 * Clase para definir los alumnos de la aplicacion
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class Alumno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String contrasena;
	private String id;
	private String email;
	private String nombre;
	private String apellidos;
	
	ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
	ArrayList<SolicitudMatricula> matriculas = new ArrayList<SolicitudMatricula>();
	
	/**
	 * Constructor de la clase Alumno
	 * 
	 * @param nombre Nombre del alumno
	 * @param apellidos Apellidos del alumno
	 * @param email Correo del alumno
	 * @param id Identificador
	 * @param contra Contrasena
	 */
	public Alumno(String nombre, String apellidos, String email, String id, String contra){
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id = id;
		this.contrasena = contra;
		this.email=email;	
	}
	
	/**
	 * Agrega una solicitud de matricula al alumno
	 * @param sol Solicitud a agregar
	 * @return true si se agrega correctamente, false en caso contrario
	 */
	public boolean agregarSolicitud(SolicitudMatricula sol){
		
		return matriculas.add(sol);
		
	}
	
	/**
	 * Elimina una solicitud de matricula del alumno
	 * @param sol Solicitud a eliminar
	 * @return true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarSolicitud(SolicitudMatricula sol){
		return matriculas.remove(sol);
	}
	
	/**
	 * Agrega una asignatura al alumno
	 * @param asig Asignatura a agregar
	 * @return true si se agrega correctamente, false en caso contrario
	 */
	public boolean agregarAsignatura(Asignatura asig){
		
		return asignaturas.add(asig);
	}
	
	/**
	 * Elimina una asignatura del alumno
	 * @param asig Asignatura a eliminar
	 * @return true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarAsignatura(Asignatura asig){
		return asignaturas.remove(asig);
	}
	
	/**
	 * Set de la contrasena del alumno
	 * @param contra Contrasena nueva
	 */
	public void setContrasena(String contra){
		contrasena = contra;
		return;
	}
	
	/**
	 * Set del id del alumno
	 * @param id1 Id nuevo
	 */
	public void setId(String id1){
		id = id1;
		return;
	}
	
	/**
	 * Set del email del alumno
	 * @param em Email nuevo
	 */
	public void setEmail(String em){
		email = em;
		return;
	}
	
	/**
	 * Set del nombre del alumno
	 * @param nom Nombre nuevo
	 */
	public void setNombre(String nom){
		nombre = nom;
		return;
	}
	
	/**
	 * Set de los apellidos del alumno
	 * @param ap Apellidos nuevo
	 */
	public void setApellidos(String ap){
		apellidos = ap;
		return;
	}
	
	/**
	 * Get del email del alumno
	 * @return email
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * Get de la contrasena del alumno
	 * @return contrasena
	 */
	public String getContrasena(){
		return contrasena;
	}
	
	/**
	 * Get del id del alumno
	 * @return idBlanca
	 */
	public String getId(){
		return id;
	}
	
	/**
	 * Get del nombre del alumno
	 * @return nombre
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Get de los apellidos del alumno
	 * @return apellidos
	 */
	public String getApellidos(){
		return apellidos;
	}

	/**
	 * Obtiene una asignatura del alumno por su nombre
	 * @param nomAsign Nombre de la asignatura a devolver
	 * @return
	 */
	public Asignatura getAsignatura(String nomAsign){
		
		for(Asignatura a: asignaturas){
			if(a.getNombre().equals(nomAsign)){
				return a;
			}
			
				
		}
		return null;
	}
		
}
