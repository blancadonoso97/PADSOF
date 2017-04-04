package Examen;

import java.io.Serializable;
import java.util.ArrayList;

import Examen.Respuesta;

/**
 * 
 * Clase para definir las preguntas de los ejercicios de la aplicacion
 * @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
 *
 */
public abstract class Pregunta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	Ejercicio ejercicio;
	private double puntuacion;
	private String enunciado;
	private int tipoPregunta;
	

	ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

	/**
	 * Constructo de la clase Pregunta
	 * 
	 * @param pregunta Titulo de la pregunta
	 * @param punt Puntuacion total
	 * @param ejercicio Ejercicio al que pertenece
	 */
	public Pregunta(String pregunta, double punt,Ejercicio ejercicio) {
		this.puntuacion = punt;
		this.ejercicio=ejercicio;
		this.enunciado = pregunta;
		
	}

	/**
	 * Devuelve la puntuacion de la pregunta
	 * @return puntuacion
	 */
	public double getPuntuacion() {
		return puntuacion;
	}

	/**
	 * Devuelve el enunciado de la pregunta
	 * @return enunciado
	 */
	public String getEnunciado() {
		return enunciado;
	}

	/**
	 * Set del tipo de pregunta
	 * @param tipo Tipo de pregunta
	 */
	public void setTipoPregunta(int tipo) {
		tipoPregunta = tipo;
		return;
	}

	/**
	 * Obtiene el tipo de pregunta
	 * @return tipoPregunta
	 */
	public int getTipoPregunta() {
		return tipoPregunta;
	}
	
	/**
	 * Devuelve el id de la pregunta
	 * @return idPregunta
	 */
	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	/**
	 * Modifica la puntuacion de la pregunta
	 * @param pn Nueva puntuacion
	 */
	public void setPuntuacion(float pn) {
		puntuacion = pn;
		return;
	}

	/**
	 * Modifica el enunciado de la pregunta
	 * @param pregunta Nuevo enunciado
	 */
	public void setEnunciado(String pregunta) {
		enunciado = pregunta;
		return;
	}

	/**
	 * Devuelve el ArrayList de respuestas que contiene la pregunta
	 * @return respuestas
	 */
	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}
	
	/**
	 * Agrega una nueva respuesta a la pregunta
	 * @param resp Respuesta a insertar
	 * @return true si se agrega correctamente, false en caso contrario
	 */
	public boolean anyadirRespuesta(Respuesta resp) {
		return respuestas.add(resp);
	}

	/**
	 * Elimina una respuesta de la pregunta
	 * @param resp Respuesta a eliminar
	 * @return true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarRespuesta(Respuesta resp) {
		
		for (Respuesta r : respuestas) {
			if (r.equals(resp))
				respuestas.remove(r);
			return true;
		}
		return false;
	}

}