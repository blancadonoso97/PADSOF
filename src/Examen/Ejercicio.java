package Examen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import Asignatura.Tema;
import eCourses.Alumno;

/**
 * 
 * Clase para definir los ejercicios de la aplicacion
 * 
 * @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
 *
 */
public class Ejercicio implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private double peso;
	private boolean visible;
	private Calendar fechaInicio = Calendar.getInstance();
	private Calendar fechaFin = Calendar.getInstance();
	private String nombre;
	private Tema tema;

	ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	
	
	/**
	 * Constructor de la clase Ejercicio
	 * @param newTema Tema al que pertenece
	 * @param peso Peso del ejercicio
	 * @param diaI Dia inicio
	 * @param mesI Mes inicio
	 * @param anyoI Anyo inicio
	 * @param diaF Dia fin
	 * @param mesF Mes fin
	 * @param anyoF Anyo fin
	 * @param newNombre Nombre del ejercicio
	 */
	public Ejercicio(Tema newTema, double peso, int diaI, int mesI, int anyoI, int diaF, int mesF, int anyoF,String newNombre) {

		this.tema = newTema;
		this.peso = peso;
		this.fechaInicio.set(Calendar.YEAR, anyoI);
		this.fechaInicio.set(Calendar.MONTH, mesI);
		this.fechaInicio.set(Calendar.DATE, diaI);
		this.fechaFin.set(Calendar.YEAR, anyoF);
		this.fechaFin.set(Calendar.MONTH, mesF);
		this.fechaFin.set(Calendar.DATE, diaF);
		this.nombre = newNombre;
		this.visible=getVisible();
		

	}

	/**
	 * Set del peso del ejercicio
	 * @param p1 Nuevo peso del ejercicio
	 */
	public void setPeso(double p1) {
		peso = p1;
		return;
	}


	/**
	 * Set de la visibilidad del ejercicios
	 * @param v1 Nueva visibilidad del ejercicio
	 */
	public void setVisible(boolean v1) {
		visible = v1;
		return;
	}

	/**
	 * Devuelve el numero de preguntas en el ejercicio
	 * @return preguntas.size()
	 */
	public int getNPreguntas(){
		return preguntas.size();
	}

	/**
	 * Devuelve el numero de alumnos del ejercicio
	 * @return alumnos.size()
	 */
	public int getNAlumnos(){
		return alumnos.size();
	}
	
	/**
	 * Get del peso del ejercicio
	 * @return peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Devuelve un alumno del ejercicio
	 * @param nombreAl Nombre del alumno a buscar
	 * @return el alumno si se encuentra en el ejercicio, null en caso contrario
	 */
	public Alumno getAlumno(String nombreAl){
		for(Alumno a: alumnos){
			if(a.getNombre().equals(nombreAl)){
				return a;
			}
		}
		return null;
	}

	/**
	 * Get de la visibilidad del ejercicio
	 * @return visible
	 */
	public boolean getVisible() {
		
		Calendar calendar = Calendar.getInstance(); /* Obtiene la fecha actual*/
		
		if (calendar.compareTo(fechaInicio)>0 && calendar.compareTo(fechaFin)<0){
			visible = true;
			return true;
		}else{
			visible = false;
			return false;
		}
	}


	/**
	 * Get de la fecha de finalizacion del ejercicio
	 * @return fechaFin
	 */
	public Calendar getfechaFin() {
		return fechaFin;
	}

	/**
	 * Get de la fecha de inicio del ejercicio
	 * @return fechaInicio
	 */
	public Calendar getfechaInicio() {
		return fechaInicio;
	}
	
	/**
	 * Get del nombre del ejercicio
	 * @return nombre
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Get del tema al que pertenece el ejercicio
	 * @return tema
	 */
	public Tema getTema(){
		return tema;
	}
	
	/**
	 * Devuelve el conjunto de alumnos en el ejercicio
	 * @return alumnos
	 */
	public ArrayList<Alumno> getAlumnos(){
		return alumnos;
	}

	/**
	 * Set del dia, mes y anyo de inicio del ejercicio
	 * @param dia Nuevo dia para la fecha de inicio
	 * @param mes Nuevo mes para la fecha de inicio
	 * @param anyo Nuevo anyo para la fecha de inicio
	 */
	public void setFechaInicio(int dia, int mes, int anyo) {
		fechaInicio.set(Calendar.YEAR, anyo);
		fechaInicio.set(Calendar.MONTH, mes);
		fechaInicio.set(Calendar.DATE, dia);

		return;
	}

	/**
	 * Set del dia, mes y anyo de fin del ejercicio
	 * @param dia Nuevo dia para la fecha de fin
	 * @param mes Nuevo mes para la fecha de fin
	 * @param anyo Nuevo anyo para la fecha de fin
	 */
	public void setFechaFin(int dia, int mes, int anyo) {
		fechaFin.set(Calendar.YEAR, anyo);
		fechaFin.set(Calendar.MONTH, mes);
		fechaFin.set(Calendar.DATE, dia);

		return;
	}

	/**
	 * Calcula la nota total del ejercicio
	 * @return nota Nota total calculada a partir de la suma de todas las preguntas
	 */
	public double calcularNota(Alumno al) {
		double nota=0;
		
		for(Pregunta preg: preguntas){
			for(Respuesta resp : preg.getRespuestas()){
				if(resp.getAlumno().equals(al)){
					nota+=resp.getNota();
				}
			}
		}
		
		return nota;
	}

	/**
	 * Agrega una pregunta al ejercicio
	 * @param pregunta Pregunta a agregar
	 * @return true si se agrega correctamente, false en caso contrario
	 */
	public boolean AgregarPregunta(Pregunta pregunta) {
		
		return preguntas.add(pregunta);
	
	}

	/**
	 * Elimina una pregunta del ejercicio
	 * @param pregunta
	 * @return true si se elimina correctamente, false en caso contrario
	 */
	public boolean BorrarPregunta(Pregunta pregunta) {
		
		for (Pregunta a : preguntas) {
			if (a.equals(pregunta)) {
				return preguntas.remove(a);
			}
		}
		
		return false;

	}
	
	/**
	 * Obtienen una pregunta del ejercicio a partir de su nombre
	 * @param nombrePregun Nombre de la pregunta
	 * @return la pregunta si se encuentra en el ejercicio, null en caso contrario
	 */
	public Pregunta getPregunta(String nombrePregun){
		
		for(Pregunta preg: preguntas){
			
			if(preg.getEnunciado().equals(nombrePregun)){
				return preg;
			}
		}
		
		return null;
	}
	
	/**
	 * Devuelve el conjunto de preguntas en el ejercicio
	 * @return preguntas
	 */
	public ArrayList<Pregunta> getPreguntas(){
		return preguntas;
	}
	

	/**
	 * Realiza el ejercicio
	 * @param alumno Alumno que contesta
	 * @param opciones Opciones que envia el alumno como contestadas
	 * @return true si se contesta correctamente, false en caso contrario
	 */
	public boolean realizarEjercicio(Alumno alumno,ArrayList<Opcion> opciones){
	
		if(alumno == null){
			
			return false;
			
		}
		
		if(this.visible==true){
			
			for(Alumno al: alumnos){
			
				if(al.equals(alumno)){
				
					return false;
				}
				
			}
		
			for(Pregunta p: preguntas){
				if(p.getTipoPregunta() == 1){
					//Multiple
						
					PreguntaMultiple pregM =(PreguntaMultiple) p;
					pregM.contestarPregunta(opciones,alumno);
						
					
				}else if(p.getTipoPregunta() == 2){
					//redactar
						
					PreguntaRedactar pregR =(PreguntaRedactar) p;
					pregR.contestarPregunta(alumno,opciones.get(0).getEnunciado());
						
					
				}else{
					//test
						
					PreguntaTest pregT =(PreguntaTest) p;
					for(Opcion op : pregT.getOpciones()){
						for(Opcion o : opciones){
							if(o.getEnunciado().equals(op.getEnunciado()) && o.getPregunta().getEnunciado().equals(op.getPregunta().getEnunciado())){
								pregT.contestarPregunta(op,alumno);
							}
						}
					}
									
				}
			}
				
			alumnos.add(alumno);
			return true;
			
		}
		
		
			
		return false;
		
	}
		
	
	
}
