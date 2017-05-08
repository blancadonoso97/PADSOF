package Examen;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import Asignatura.Tema;
import eCourses.Alumno;
import eCourses.Sistema;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

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
	private boolean ordenado;
	
	
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
	 * @throws IOException 
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 * @throws ClassNotFoundException 
	 */
	public Ejercicio(Tema newTema,boolean ord, double peso, int diaI, int mesI, int anyoI, int diaF, int mesF, int anyoF,String newNombre) throws ClassNotFoundException, InvalidEmailAddressException, FailedInternetConnectionException, IOException {

		this.tema = newTema;
		this.peso = peso;
		this.fechaInicio.set(Calendar.YEAR, anyoI);
		this.fechaInicio.set(Calendar.MONTH, mesI);
		this.fechaInicio.set(Calendar.DATE, diaI);
		this.fechaFin.set(Calendar.YEAR, anyoF);
		this.fechaFin.set(Calendar.MONTH, mesF);
		this.fechaFin.set(Calendar.DATE, diaF);
		this.nombre = newNombre;
		this.visible = getVisible();
		this.ordenado = ord;

	}

	/**
	 * Set del peso del ejercicio
	 * @param p1 Nuevo peso del ejercicio
	 */
	public void setPeso(double p1) {
		
		if(alumnos.size()>0) {
			return;
		}
		peso = p1;
		return;
	}


	/**
	 * Set de la visibilidad del ejercicios
	 * @param v1 Nueva visibilidad del ejercicio
	 */
	public void setVisible(boolean v1) {
		this.visible = v1;
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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public boolean getVisible() throws ClassNotFoundException, IOException, InvalidEmailAddressException, FailedInternetConnectionException {
		
		/*Calendar calendar = Calendar.getInstance(); /* Obtiene la fecha actual*/
		/*Sistema sist = Sistema.getInstance();
		
		if (calendar.compareTo(fechaInicio)>0 && calendar.compareTo(fechaFin)<0){
			
			if(!tema.esVisible()){
				tema.setVisibilidad(true);
				
				for(Tema t: tema.getTemas()){
					if(!t.esVisible()){
						t.setVisibilidad(true);
					}
				}
				
				if(!tema.getAsignatura().getVisible()){
					tema.getAsignatura().setVisible(true);
				}
			}
			if(!this.visible){

				for (Alumno a : tema.getAsignatura().getAlumnos()){
					sist.enviarNotificacion(a, "Nuevo ejercicio", "El tema " + tema.getNombre() + " contiene un nuevo ejercicio " + nombre);
				}
			
			}
			this.visible=true;
			return visible;
		}else{
			this.visible = false;
			return visible;
		}*/
		return true;
	}

	/**
	 * Comprueba si un alumno ha contestado a una pregunta del ejercicio
	 * @param p pregunta a contestar o contestada
	 * @param al alumno que comprobamos que haya contestado la pregunta
	 * @return true si ha contestado, false si no lo ha hecho
	 */
	public boolean preguntaContestadaAlumno(Pregunta p , Alumno al){
		
		for(Pregunta preg : preguntas){
			if(preg.equals(p)){
				for(Respuesta r : preg.getRespuestas()){
					if(r.getAlumno().equals(al)){
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean getOrdenado(){
		return this.ordenado;
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
		
		if(alumnos.size()>0) {
			return;
		}
		
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
		
		if(alumnos.size()>0) {
			return;
		}
		
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
		
		double nota = 0;
		
		for(Pregunta preg: preguntas){
			for(Respuesta resp : preg.getRespuestas()){
				if(resp.getAlumno().equals(al)){
					nota+=resp.getNota();
				}
			}
		}
		if(nota<0){
			nota = 0;
		}
		return nota;
	}

	/**
	 * Agrega una pregunta al ejercicio
	 * @param pregunta Pregunta a agregar
	 * @return true si se agrega correctamente, false en caso contrario
	 */
	public boolean AgregarPregunta(Pregunta pregunta) {
		
		if(alumnos.size()>0) {
			return false;
		}
		
		for(Pregunta p : preguntas){
			
			if(p == pregunta){
				return false;
			}
		}
		
		 if(preguntas.add(pregunta)){
			 return true;
		 }
		 
		 return false;
	}

	/**
	 * Elimina una pregunta del ejercicio
	 * @param pregunta
	 * @return true si se elimina correctamente, false en caso contrario
	 */
	public boolean BorrarPregunta(Pregunta pregunta) {
		
		if(alumnos.size()>0) {
			return false;
		}
		for (Pregunta a : preguntas) {
			if (a.equals(pregunta)) {
				 if(preguntas.remove(a)){
					 return true;
				 }
			}
		}
		
		return false;

	}
	
	
	/**
	 * Obtienen una pregunta del ejercicio a partir de su nombre
	 * @param nombrePregun Nombre de la pregunta
	 * @return la pregunta si se encuentra en el ejercicio, null en caso contrario
	 */
	public Pregunta getPregunta(String enunciado){
		
		for(Pregunta preg: preguntas){
			
			if(preg.getEnunciado().equals(enunciado)){
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
	 * Devuelve el porcentaje de alumnos que han realizado un ejercicio
	 * @param ej Ejercicio a comprobar
	 * @return 100*res Porcentaje
	 */
	public double getPorcentajeAlumnosRealizado(){
		double res;
		
		res = (double) this.getNAlumnos() / tema.getAsignatura().getAlumnos().size();
		
		return 100*res;
	}
	
	
	/**
	 * Devuelve el porcentaje de alumnos que han contestado un ejercicio correctamente
	 * @param ej Ejercicio a comprobar
	 * @return res*100 Porcentaje
	 */
	public double getPorcentajeAlumnosReCorrectamente(){
		int alumnosExaminadosCorr = 0;
		double res;
		
		for(Alumno al: this.getAlumnos()){
			if(this.calcularNota(al) == this.getPeso()){
				alumnosExaminadosCorr++;
			}
		}
		
		 res =(double) alumnosExaminadosCorr / this.getAlumnos().size();
		 
		 return res*100;
	}
	

	/**
	 * Realiza el ejercicio
	 * @param alumno Alumno que contesta
	 * @param opciones Opciones que envia el alumno como contestadas
	 * @return true si se contesta correctamente, false en caso contrario
	 * @throws IOException 
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 * @throws ClassNotFoundException 
	 */
	public boolean realizarEjercicio(Alumno alumno,ArrayList<Opcion> opciones) throws ClassNotFoundException, InvalidEmailAddressException, FailedInternetConnectionException, IOException{
		
		if(alumno == null){
			return false;	
		}
		
		if(this.getVisible() == true){
			
			for(Alumno al: alumnos){
			
				if(al.equals(alumno)){
				
					return false;
				}
				
			}
			
			if(!this.ordenado){
				Collections.shuffle(preguntas);
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
