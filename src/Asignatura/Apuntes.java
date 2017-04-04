package Asignatura;
import java.io.Serializable;
import java.util.Calendar;

/**
* 
* Clase para definir los apuntes de la aplicacion
* @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
*
*/
public class Apuntes implements Serializable{


	private static final long serialVersionUID = 1L;
	private Tema tema;
	private String texto;
	private Calendar fechaInicio = Calendar.getInstance();
	private boolean visible;
	private String titulo;
	

	/**
	 * Constructor de la clase Apuntes
	 * 
	 * @param newTema Tema al que pertenecen los apuntes
	 * @param t1 Texto de los apuntes
	 * @param dia Dia de inicio (visible)
	 * @param mes Mes de inicio (visible)
	 * @param anyo Anyo de inicio (visible)
	 * @param v1 Visibilidad
	 * @param titulo Nombre de los apuntes
	 */
	public Apuntes(Tema newTema, String t1, int dia, int mes, int anyo, boolean v1, String titulo) {
		this.tema = newTema;
		this.texto = t1;
		this.fechaInicio.set(Calendar.YEAR, anyo);
		this.fechaInicio.set(Calendar.DATE, dia);
		this.fechaInicio.set(Calendar.MONTH, mes);
		this.visible = v1;
		this.titulo = titulo;

	}

	/**
	 * Muestra el contenido de los apuntes (texto)
	 * Comprueba que sean visibles antes de mostrarlos
	 */
	public void mostrarApuntes() {
		
		if(this.comprobarVisible()){
			System.out.println(texto);
		}
		return;
	}
	
	/**
	 * Comprueba con la fecha actual si los apuntes pueden estar visibles o no
	 * @return true si estan visibles, false en caso contrario
	 */
	public boolean comprobarVisible(){
		
		Calendar calendar = Calendar.getInstance(); /* Obtiene la fecha actual*/
		
		if (calendar.compareTo(fechaInicio) > 0){
			visible = true;
			return true;
		}else
			visible = false;
			return false;
		
	}

	/**
	 * Anade texto a los apuntes
	 * @param t1 Texto de los apuntes
	 */
	public void setTexto(String t1) {
		texto = t1;
		return;
	}

	/**
	 * Cambia la fecha de inicio
	 * @param f1 Nueva fecha de inicio
	 */
	public void setFechaInicio(Calendar f1) {
		fechaInicio = f1;
		return;
	}

	/**
	 * Set de la visibilidad
	 * @param v1 Nueva visibilidad
	 */
	public void setVisible(boolean v1) {
		visible = v1;
		return;
	}

	/**
	 * Set del titulo
	 * @param newTitulo Titulo a cambiar
	 */
	public void setTitulo(String newTitulo) {
		titulo = newTitulo;
		return;
	}
	
	/**
	 * Set del tema al que pertenecen los apuntes
	 * @param newTema Tema al que pertenecen
	 */
	public void setTema(Tema newTema){
		tema = newTema;
		return;
	}

	/**
	 * Get de la visibilidad de los apuntes
	 * @return visible
	 */
	public boolean getVisible() {
		return visible;
	}

	/**
	 * Get del texto de los apuntes
	 * @return texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * Get de la fecha de inicio de los apuntes (fecha de visibilidad)
	 * @return fechaInicio
	 */
	public Calendar getCalendar() {
		return fechaInicio;
	}

	/**
	 * Get del titulo de los apuntes
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Get del tema al que pertenecen los apuntes
	 * @return tema
	 */
	public Tema getTema(){
		return tema;
	}

}
