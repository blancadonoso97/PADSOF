package InterfazGrafica;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Asignatura.Asignatura;
import Asignatura.Tema;
import Controladores.ControladorAgregarContenido;

/**
 * Clase para definir el panel de crear ejercicio
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelCrearEjercicio extends JPanel {

	private static final long serialVersionUID = 1L;

	private PanelContenido contenedor;

	private JButton crearpregunta;
	private JButton crearejercicio;
	private JComboBox<String> listatemas;
	private JRadioButton ordenado;
	private JTextField peso;

	private JTextField diaini;
	private JTextField mesini;
	private JTextField anyoini;

	private JTextField diafin;
	private JTextField mesfin;
	private JTextField anyofin;

	private JTextField nombre;

	/**
	 * Constructor de la clase PanelCrearEjercicio
	 * 
	 * @param cont Panel de contenido
	 */
	public PanelCrearEjercicio(PanelContenido cont) {

		this.contenedor = cont;

		this.listatemas = new JComboBox<String>();

		this.crearpregunta = new JButton("Crear Pregunta");
		this.crearejercicio = new JButton("Crear Ejercicio");

		this.ordenado = new JRadioButton("Preguntas ordenadas");

		this.peso = new JTextField(2);

		this.diaini = new JTextField(2);
		this.mesini = new JTextField(2);
		this.anyoini = new JTextField(4);

		this.diafin = new JTextField(2);
		this.mesfin = new JTextField(2);
		this.anyofin = new JTextField(4);

		this.nombre = new JTextField(20);

		// Anadir contenido
		this.add(nombre);
		this.add(peso);
		this.add(ordenado);

		this.add(diaini);
		this.add(mesini);
		this.add(anyoini);

		this.add(diafin);
		this.add(mesfin);
		this.add(anyofin);

		this.add(listatemas);

		this.add(crearpregunta);
		this.add(crearejercicio);

		// Anade el controlador para el boton de crear asignatura
		ControladorAgregarContenido controlador = new ControladorAgregarContenido(
				contenedor.getContenedorProf().getVentana(), this);

		// Configurar el panel con el controlador
		this.setControlador(controlador);

	}

	/**
	 * Anade un controlador al boton
	 * @param c Controlador a anadir
	 */
	public void setControlador(ActionListener c) {
		crearejercicio.addActionListener(c);
		crearpregunta.addActionListener(c);
	}

	/**
	 * Obtiene el nombre del ejercicio
	 * @return Nombre del ejercicio
	 */
	public String getNombreEjercicio() {
		return nombre.getText();
	}
	
	/**
	 * Devuelve el peso del ejercicio
	 * @return Peso del ejercicio
	 */
	public double getPeso(){
		return Double.parseDouble(peso.getText());
	}

	/**
	 * Obtiene el dia de inicio introducido
	 * @return Dia inicio
	 */
	public int getDiaIni() {

		return Integer.parseInt(diaini.getText());
	}

	/**
	 * Obtiene el mes de inicio introducido
	 * @return Mes inicio
	 */
	public int getMesIni() {

		return Integer.parseInt(mesini.getText());
	}

	/**
	 * Obtiene el anyo de inicio introducido
	 * @return Anyo inicio
	 */
	public int getAnyoIni() {

		return Integer.parseInt(anyoini.getText());
	}
	
	/**
	 * Obtiene el dia de fin introducido
	 * @return Dia fin
	 */
	public int getDiaFin() {

		return Integer.parseInt(diafin.getText());
	}

	/**
	 * Obtiene el mes de fin introducido
	 * @return Mes fin
	 */
	public int getMesFin() {

		return Integer.parseInt(mesfin.getText());
	}

	/**
	 * Obtiene el anyo de fin introducido
	 * @return Anyo fin
	 */
	public int getAnyoFin() {

		return Integer.parseInt(anyofin.getText());
	}
	
	/**
	  * Comprueba la seleccion de ordenado
	  * @return true si se selecciona ordenado, false en caso contrario
	  */
	 public boolean comprobarSeleccion(){
		 
		 if(ordenado.isSelected()){
			 return true;
		 }else
			 return false;
		 
	 }
	 
	 /**
	  * Actualiza la lista con los temas existentes
	  */
	 public void actualizarTabla(){
		 
		ArrayList<Asignatura> asigexistentes = new ArrayList<Asignatura>();
			
		asigexistentes = contenedor.getContenedorProf().getVentana().getSistema().getAsignaturas();
		
		listatemas.removeAllItems();
		
		for (Asignatura a : asigexistentes){
			
			for (Tema b : a.getTemas()){
				listatemas.addItem(b.getNombre());
			}
			
		}
		
 
	 }

}
