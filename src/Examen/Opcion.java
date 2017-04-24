package Examen;


import java.io.Serializable;

/**
 * 
 * Clase para definir la opcion de una pregunta de tipo test o multiple
 * @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
 *
 */
public class Opcion implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String enunciado;
	private boolean esCorrecta;
	private Pregunta preg;
	private boolean marcada;
	
	/**
	 * Constructor de la clase Opcion
	 * 
	 * @param enunciado Enunciado de la opcion
	 * @param correcta Si la opcion es correcta o no
	 * @param preg Pregunta a la que pertenece la opcion
	 */
	public Opcion(String enunciado, boolean correcta,Pregunta preg,int ident) {
		this.enunciado = enunciado;
		this.esCorrecta = correcta;
		this.marcada = false;
		this.preg = preg;
	
	}

	/**
	 * Devuelve el enunciado de la opcion
	 * @return enunciado
	 */
	public String getEnunciado() {
		return enunciado;
	}
	


	/**
	 * Devuelve la pregunta a la que pertenece la opcion
	 * @return preg
	 */
	public Pregunta getPregunta(){
		return preg;
	}
	
	/**
	 * Set de la pregunta a la que pertenece la opcion
	 * @param p1 Pregunta
	 */
	public void setPregunta(Pregunta p1){
		preg = p1;
		return;
	}
	
	/**
	 * Devuelve un booleano que determinara si esta marcada o no esa opcion
	 * @return marcada
	 */
	public boolean getMarcada() {
		return marcada;
	}

	/**
	 * Devuelve si la opcion es correcta o no
	 * @return esCorrecta
	 */
	public boolean getEsCorrecta() {
		return esCorrecta;
	}

	/**
	 * Modifica el estado de marcada de la opcion
	 * @param newm Nuevo estado de marcada
	 */
	public void setMarcada(boolean newm) {
		marcada = newm;
		return;
	}
	
	/**
	 * Modifica el atributo que indica si la opcion es correcta o no
	 * @param newcorr Indica si la opcion correcta o no
	 */
	public void setEsCorrecta(boolean newcorr){
		esCorrecta = newcorr;
		return;
	}
	
	/**
	 * Set del enunciado de la opcion
	 * @param newenun Nuevo enunciado
	 */
	public void setEnunciado(String newenun){
		enunciado = newenun;
		return;
	}

}
