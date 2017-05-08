package InterfazGrafica;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Asignatura.Asignatura;
import Asignatura.Tema;
import Examen.Ejercicio;

/**
 * Clase para definir el panel de crear ejercicio
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelCrearEjercicio extends JPanel {

	private static final long serialVersionUID = 1L;

	private PanelContenido contenedor;

	private JLabel pregunta;
	private JLabel nombreej;
	private JLabel pesoej;
	private JLabel fechaini;
	private JLabel fechafin;
	
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
	 * @param cont Panel de contenido
	 */
	public PanelCrearEjercicio(PanelContenido cont) {
		setBackground(UIManager.getColor("Checkbox.select"));
		this.contenedor = cont;

		this.listatemas = new JComboBox<String>();

		this.pregunta = new JLabel("Crear pregunta de tipo:");
		this.nombreej = new JLabel("Nombre del ejercicio:");
		this.pesoej = new JLabel("Peso del ejercicio:");
		this.fechaini = new JLabel("Fecha de inicio: Dia/Mes/Año");
		this.fechafin = new JLabel("Fecha de fin: Dia/Mes/Año");
		
		this.crearpreguntamultiple = new JButton("Crear pregunta multiple");
		this.crearpreguntaredactar = new JButton("Crear pregunta redactar");
		this.crearpreguntatest = new JButton("Crear pregunta test");
		
		this.crearejercicio = new JButton("Crear Ejercicio");

		this.ordenado = new JRadioButton("Preguntas ordenadas");
		ordenado.setBackground(UIManager.getColor("Button.select"));

		this.peso = new JTextField(3);

		this.diaini = new JTextField(2);
		this.mesini = new JTextField(2);
		this.anyoini = new JTextField(4);

		this.diafin = new JTextField(2);
		this.mesfin = new JTextField(2);
		this.anyofin = new JTextField(4);

		this.nombre = new JTextField(20);
		
		// Anadir contenido
		this.add(nombreej);
		this.add(nombre);
		this.add(pesoej);
		this.add(peso);
		this.add(ordenado);

		this.add(fechaini);
		this.add(diaini);
		this.add(mesini);
		this.add(anyoini);

		this.add(fechafin);
		this.add(diafin);
		this.add(mesfin);
		this.add(anyofin);

		this.add(listatemas);

		this.add(pregunta);
		this.add(crearpreguntamultiple);
		this.add(crearpreguntaredactar);
		this.add(crearpreguntatest);
		this.add(crearejercicio);

		
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
	 
	 /**
	  * Set del ejercicio creado
	  * @param ej Ejercicio creado
	  */
	 public void setEjercicio(Ejercicio ej){
		 ejerciciocreado = ej;
	 }

}
