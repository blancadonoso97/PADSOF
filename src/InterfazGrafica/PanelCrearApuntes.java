package InterfazGrafica;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Asignatura.Asignatura;
import Asignatura.Tema;
import Controladores.ControladorAgregarContenido;
import javax.swing.UIManager;

import javax.swing.SpringLayout;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;

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
	private JTextField dia;
	private JTextField mes;
	private JTextField anyo;
	private JRadioButton visible;
	private JRadioButton novisible;
	private ButtonGroup visibilidad;
	
	private JButton crearApuntes;
	private JComboBox<String> listaasig;
	private JScrollPane scrollPane;
	
	/**
	 * Constructor de la clase PanelCrearApuntes
	 * @param cont Panel que contiene a PanelCrearApuntes
	 */
	public PanelCrearApuntes(PanelContenido cont){
		setBackground(UIManager.getColor("Checkbox.select"));
		
		this.contenedor = cont;

		this.listaasig = new JComboBox<String>();
		listaasig.add(new JLabel("Seleccione una asignatura"));
		
		this.nombreapuntes = new JLabel("Nombre de los apuntes:");
		nombreapuntes.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		nombreapuntes.setForeground(SystemColor.activeCaption);
		this.camponombre = new JTextField(30);
		
		this.contenidoapuntes = new JLabel("Contenido de los apuntes:");
		contenidoapuntes.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		contenidoapuntes.setForeground(SystemColor.activeCaption);
	
		
		this.fechavisual = new JLabel("Fecha de inicio: Dia/Mes/Año");
		fechavisual.setForeground(SystemColor.activeCaption);
		fechavisual.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		
		this.dia = new JTextField(2);
		this.mes = new JTextField(2);
		this.anyo = new JTextField(4);
		
		this.visible = new JRadioButton("Apuntes visibles");
		visible.setForeground(SystemColor.activeCaption);
		visible.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		visible.setBackground(UIManager.getColor("Checkbox.select"));
		
		this.novisible = new JRadioButton("Apuntes no visibles");
		novisible.setForeground(SystemColor.activeCaption);
		novisible.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		novisible.setBackground(UIManager.getColor("Checkbox.select"));
		
		this.visibilidad = new ButtonGroup();
		
		this.crearApuntes = new JButton("Crear Apuntes");
		crearApuntes.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		// Anadimos las opciones a visibilidad
		visibilidad.add(visible);
		visibilidad.add(novisible);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, novisible, 0, SpringLayout.WEST, visible);
		springLayout.putConstraint(SpringLayout.SOUTH, novisible, -6, SpringLayout.NORTH, visible);
		springLayout.putConstraint(SpringLayout.NORTH, visible, -6, SpringLayout.NORTH, dia);
		springLayout.putConstraint(SpringLayout.EAST, visible, -116, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, anyo, 6, SpringLayout.SOUTH, fechavisual);
		springLayout.putConstraint(SpringLayout.WEST, anyo, 36, SpringLayout.EAST, mes);
		springLayout.putConstraint(SpringLayout.WEST, listaasig, 38, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, listaasig, -701, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, mes, 0, SpringLayout.NORTH, dia);
		springLayout.putConstraint(SpringLayout.WEST, mes, 23, SpringLayout.EAST, dia);
		springLayout.putConstraint(SpringLayout.NORTH, dia, 6, SpringLayout.SOUTH, fechavisual);
		springLayout.putConstraint(SpringLayout.WEST, dia, 75, SpringLayout.EAST, listaasig);
		springLayout.putConstraint(SpringLayout.NORTH, fechavisual, 48, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, camponombre, -34, SpringLayout.NORTH, contenidoapuntes);
		springLayout.putConstraint(SpringLayout.WEST, contenidoapuntes, 170, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, listaasig, 73, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, nombreapuntes, 176, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, nombreapuntes, -6, SpringLayout.NORTH, camponombre);
		springLayout.putConstraint(SpringLayout.EAST, crearApuntes, -379, SpringLayout.EAST, this);
		setLayout(springLayout);
				
		// Anadimos los componentes al panel
		this.add(nombreapuntes);
		this.add(camponombre);
		this.add(visible);
		this.add(novisible);
		
		this.add(contenidoapuntes);
		this.add(fechavisual);
		this.add(dia);
		this.add(mes);
		this.add(anyo);
		this.add(crearApuntes);
		this.add(listaasig);
		
		// Anade el controlador para el boton de crear asignatura
		ControladorAgregarContenido controlador = new ControladorAgregarContenido(contenedor.getContenedorProf().getVentana(),this);
		
		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.SOUTH, contenidoapuntes, -6, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, camponombre, 0, SpringLayout.WEST, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, camponombre, 511, SpringLayout.WEST, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, crearApuntes, 64, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 271, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -185, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 38, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 549, SpringLayout.WEST, this);
		add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		JLabel lblAsignatura = DefaultComponentFactory.getInstance().createLabel("Asignatura :");
		springLayout.putConstraint(SpringLayout.WEST, fechavisual, 104, SpringLayout.EAST, lblAsignatura);
		springLayout.putConstraint(SpringLayout.NORTH, lblAsignatura, 48, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblAsignatura, 85, SpringLayout.WEST, this);
		lblAsignatura.setForeground(SystemColor.activeCaption);
		lblAsignatura.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		add(lblAsignatura);
						
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
