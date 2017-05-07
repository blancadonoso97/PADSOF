package InterfazGrafica;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Asignatura.Asignatura;
import Asignatura.Tema;
import Controladores.ControladorCrearEjercicio;
import Examen.Ejercicio;

/**
 * Clase para definir el panel de crear ejercicio
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelCrearEjercicio extends JPanel {

	private static final long serialVersionUID = 1L;

	private PanelContenido contenedor;
	
	private static CardLayout cartas = new CardLayout();
	
	private PanelCrearPreguntaMultiple preguntamultiple;
	private PanelCrearPreguntaTest preguntatest;
	private PanelCrearPreguntaRedactar preguntaredactar;

	private JLabel pregunta;
	
	private JButton crearpreguntamultiple;
	private JButton crearpreguntaredactar;
	private JButton crearpreguntatest;
	
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
	
	private Ejercicio ejerciciocreado;

	/**
	 * Constructor de la clase PanelCrearEjercicio
	 * 
	 * @param cont Panel de contenido
	 */
	public PanelCrearEjercicio(PanelContenido cont) {

		this.contenedor = cont;

		this.listatemas = new JComboBox<String>();

		this.pregunta = new JLabel("Crear pregunta de tipo:");
		
		this.crearpreguntamultiple = new JButton("Respuesta multiple");
		this.crearpreguntaredactar = new JButton("Redactar");
		this.crearpreguntatest = new JButton("Respuesta unica");
		
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
		
		this.preguntamultiple = new PanelCrearPreguntaMultiple(this);
		this.preguntaredactar = new PanelCrearPreguntaRedactar(this);
		this.preguntatest = new PanelCrearPreguntaTest(this);

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

		this.add(pregunta);
		this.add(crearpreguntamultiple);
		this.add(crearpreguntaredactar);
		this.add(crearpreguntatest);
		this.add(crearejercicio);

		cartas.addLayoutComponent(this.preguntamultiple, "Multiple");
		cartas.addLayoutComponent(this.preguntatest, "Test");
		cartas.addLayoutComponent(this.preguntaredactar, "Redactar");
		
		ControladorCrearEjercicio controlador = new ControladorCrearEjercicio(contenedor.getContenedorProf().getVentana(), preguntamultiple);
		
		this.setControladorMult(controlador);

		ControladorCrearEjercicio controlador2 = new ControladorCrearEjercicio(contenedor.getContenedorProf().getVentana(), preguntaredactar);
		
		this.setControladorRed(controlador2);
		
		ControladorCrearEjercicio controlador3 = new ControladorCrearEjercicio(contenedor.getContenedorProf().getVentana(), preguntatest);
		
		this.setControladorTest(controlador3);
		
		ControladorCrearEjercicio controlador4 = new ControladorCrearEjercicio(contenedor.getContenedorProf().getVentana(), this);
		
		this.setControladorRed(controlador4);
		
	}

	/**
	 * Anade un controlador al boton multiple
	 * @param c Controlador a anadir
	 */
	public void setControladorMult(ActionListener c) {
		crearpreguntamultiple.addActionListener(c);
	}
	
	/**
	 * Anade un controlador al boton redactar
	 * @param c Controlador a anadir
	 */
	public void setControladorRed(ActionListener c) {
		crearpreguntaredactar.addActionListener(c);
	}
	
	/**
	 * Anade un controlador al boton test
	 * @param c Controlador a anadir
	 */
	public void setControladorTest(ActionListener c) {
		crearpreguntatest.addActionListener(c);
	}
	
	/**
	 * Anade un controlador al boton ejercicio
	 * @param c Controlador a anadir
	 */
	public void setControlador(ActionListener c) {
		crearejercicio.addActionListener(c);
	}
	
	/**
	 * Permite cambiar de carta dentro de crear ejercicio
	 * @param nombre Nombre de la carta a cambiar
	 */
	public void cambiarCarta(String nombre){
		
		if(nombre.equals("Multiple")){
			
		}else if(nombre.equals("Test")){
			
		}else if(nombre.equals("Redactar")){
			
		}
		
		
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
	  * Devuelve el tema
	  * @return tema deseado
	  */
	public Tema getTema(){
			
		String valorSeleccionado = (String)listatemas.getSelectedItem();	
		
		return contenedor.getContenedorProf().getVentana().getSistema().getTema(valorSeleccionado);		
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
	 
	 /**
	  * Obtiene el panel de contenido
	  * @return contenedor
	  */
	 public PanelContenido getContenido(){
		 return contenedor;
	 }
	 
	 /**
	  * Obtiene el ejercicio creado
	  * @return ejerciciocreado
	  */
	 public Ejercicio getEjercicio(){
		 return ejerciciocreado;
	 }

}
