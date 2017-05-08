package InterfazGrafica;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Asignatura.Asignatura;
import Asignatura.Tema;
import Controladores.ControladorAgregarContenido;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

/**
 * Clase para definir el panel de crear Apuntes
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelCrearApuntes extends JPanel{

	private static final long serialVersionUID = 1L;
	
private PanelContenido contenedor;
	
	private JLabel nombreapuntes;
	private JTextField camponombre;
	private JLabel contenidoapuntes;
	private JLabel fechavisual;
	private JTextField campotexto;
	private JTextField dia;
	private JTextField mes;
	private JTextField anyo;
	private JRadioButton visible;
	private JRadioButton novisible;
	private ButtonGroup visibilidad;
	
	private JButton crearApuntes;
	private JComboBox<String> listaasig;
	
	private Component rigidArea;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private Component rigidArea_4;
	private Component rigidArea_5;
	
	/**
	 * Constructor de la clase PanelCrearApuntes
	 * @param cont Panel que contiene a PanelCrearApuntes
	 */
	public PanelCrearApuntes(PanelContenido cont){
		
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.contenedor = cont;

		this.listaasig = new JComboBox<String>();
		listaasig.add(new JLabel("Seleccione una asignatura"));
		
		this.nombreapuntes = new JLabel("Nombre de los apuntes:");
		this.camponombre = new JTextField(30);
		
		this.contenidoapuntes = new JLabel("Contenido de los apuntes:");
		this.campotexto = new JTextField(20);
		
		this.fechavisual = new JLabel("Fecha de inicio: Dia/Mes/Año");
		
		this.dia = new JTextField(2);
		this.mes = new JTextField(2);
		this.anyo = new JTextField(4);
		
		this.visible = new JRadioButton("Apuntes visibles");
		visible.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.novisible = new JRadioButton("Apuntes no visibles");
		novisible.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.visibilidad = new ButtonGroup();
		
		this.crearApuntes = new JButton("Crear Apuntes");
		crearApuntes.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		// Anadimos las opciones a visibilidad
		visibilidad.add(visible);
		visibilidad.add(novisible);
				
		// Anadimos los componentes al panel
		this.add(nombreapuntes);
		
		rigidArea = Box.createRigidArea(new Dimension(0, 20));
		add(rigidArea);
		this.add(camponombre);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(20, 0));
		add(rigidArea_1);
		this.add(visible);
		
		rigidArea_2 = Box.createRigidArea(new Dimension(20, 40));
		add(rigidArea_2);
		this.add(novisible);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		add(rigidArea_3);
		
		this.add(contenidoapuntes);
		this.add(campotexto);
		this.add(fechavisual);
		this.add(dia);
		this.add(mes);
		this.add(anyo);

		rigidArea_4 = Box.createRigidArea(new Dimension(1000, 30));
		add(rigidArea_4);
		this.add(crearApuntes);
		
		rigidArea_5 = Box.createRigidArea(new Dimension(0, 50));
		add(rigidArea_5);
		this.add(listaasig);
		
		// Anade el controlador para el boton de crear asignatura
		ControladorAgregarContenido controlador = new ControladorAgregarContenido(contenedor.getContenedorProf().getVentana(),this);
						
		// Configurar el panel con el controlador
		this.setControlador(controlador);
		
	}
	
	/**
	 * Devuelve el panel que contiene a crear asignatura
	 * @return contenedor
	 */
	public PanelContenido getContenedor(){
		return contenedor;
	}
	
	/**
	 * Devuelve el nombre de los apuntes creados
	 * @return Nombre tema
	 */
	public String getNombreApuntes(){
		return camponombre.getText();
	}
	
	/**
	 * Devuelve el contenido de los apuntes creados
	 * @return Texto
	 */
	public String getContenidoApuntes(){
		return campotexto.getText();
	}
	
	/**
	 * Obtiene el dia introducido
	 * @return Dia
	 */
	public int getDia(){
		
		return Integer.parseInt(dia.getText());
	}
	
	/**
	 * Obtiene el mes introducido
	 * @return Mes
	 */
	public int getMes(){
		
		return Integer.parseInt(mes.getText());
	}
	
	/**
	 * Obtiene el anyo introducido
	 * @return Anyo
	 */
	public int getAnyo(){
		
		return Integer.parseInt(anyo.getText());
	}
	
	/**
	 * Devuelve el tema
	 * @return tema deseado
	 */
	public String getNombreTema(){
		
		String valorSeleccionado = (String)listaasig.getSelectedItem();
		
		return valorSeleccionado;
		
	}
	
	/**
	 * Anade un controlador al boton
	 * @param c Controlador a anadir
	 */
	 public void setControlador(ActionListener c) {
		 crearApuntes.addActionListener(c);
	 }
	 
	 /**
	  * Comprueba la seleccion de opciones
	  * @return true si se selecciona visible, false en caso contrario
	  */
	 public boolean comprobarSeleccion(){
		 
		 if(visible.isSelected()){
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
		
		listaasig.removeAllItems();
		
		for (Asignatura a : asigexistentes){
			
			for (Tema b : a.getTemas()){
				listaasig.addItem(b.getNombre());
			}
			
		}
		
 
	 }
	

}
