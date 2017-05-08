package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import Controladores.ControladorEditarContenido;

import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JButton;
/**
 * Clase que implementa el panel para editar un apunte
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelEditarApunte extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private PanelProfesor contenedorProf;
	private JScrollPane scrollPane;
	private SpringLayout springLayout;
	private JTextPane contenido;
	private JEditorPane texto;
	private JEditorPane titulonew;
	private JRadioButton visible;
	private JRadioButton novisible;
	private ButtonGroup visibilidad;
	private JButton guardar;
	
	/**
	 * Constructor que implementa la interfaz grafica del panel de editar unos apuntes
	 * @param cont panel del contenido
	 */
	public PanelEditarApunte(PanelContenido cont){
		
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.springLayout = new SpringLayout();
		setLayout(springLayout);
		
		this.scrollPane = new JScrollPane();
		this.springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 178, SpringLayout.NORTH, this);
		this.springLayout.putConstraint(SpringLayout.WEST, scrollPane, 57, SpringLayout.WEST, this);
		this.springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -321, SpringLayout.SOUTH, this);
		this.springLayout.putConstraint(SpringLayout.EAST, scrollPane, -52, SpringLayout.EAST, this);
		this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scrollPane);
		
		this.texto = new JEditorPane();
		this.scrollPane.setViewportView(texto);
		
		this.contenido = new JTextPane();
	
		this.contenedorProf = cont.getContenedorProf();
		
		this.titulonew = new JEditorPane();
		this.springLayout.putConstraint(SpringLayout.WEST, this.titulonew, 145, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, titulonew, -62, SpringLayout.NORTH, scrollPane);
		this.springLayout.putConstraint(SpringLayout.EAST, this.titulonew, -171, SpringLayout.EAST, this);
		this.add(titulonew);
		
		this.visible = new JRadioButton("Apuntes visibles");
		visible.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.novisible = new JRadioButton("Apuntes no visibles");
		springLayout.putConstraint(SpringLayout.NORTH, visible, 0, SpringLayout.NORTH, novisible);
		springLayout.putConstraint(SpringLayout.WEST, visible, 86, SpringLayout.EAST, novisible);
		springLayout.putConstraint(SpringLayout.NORTH, novisible, 56, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, novisible, -439, SpringLayout.EAST, this);
		novisible.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.visibilidad = new ButtonGroup();
		
		visibilidad.add(visible);
		visibilidad.add(novisible);
		this.add(novisible);
		this.add(visible);
		
		guardar = new JButton("Guardar");
		springLayout.putConstraint(SpringLayout.NORTH, guardar, 61, SpringLayout.SOUTH, novisible);
		springLayout.putConstraint(SpringLayout.WEST, guardar, 334, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, guardar, 437, SpringLayout.WEST, this);
		
		ControladorEditarContenido cont1 = new ControladorEditarContenido(this);
		this.setControlador(cont1);
		add(guardar);
		
		
	}

	/**
	 * Funcion que comprueba la seleccion de visibilidad de los apuntes 
	 * @return boolean true si es visible, de lo contrario false
	 */
	public boolean comprobarSeleccion(){
		 
		 if(visible.isSelected()){
			 return true;
		 }else {
			 return false;
		 }
			
	 }
	
	/**
	 * Funcion que devuelve el panel del profesor
	 * @return panel del profesor
	 */
	public PanelProfesor getPanelProf(){
		return this.contenedorProf;
	}
	 
	/**
	 * Funcion que modifica el controlador del boton guardar
	 * @param c controlador elegido
	 */
	 public void setControlador(ActionListener c) {
		 this.guardar.addActionListener(c);
	 }

	 /**
	  * Funcion que actualiza el estado de los apuntes despues de haberlos editado
	  */
	public void actualizarApunte(){
		
		if(!this.titulonew.getText().isEmpty()){
			if(!this.contenedorProf.getPanelContenido().getPanelEdTem().getNombreApunteSeleccionado().equals("")){
				this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdTem().getNombreTema()).getApunte(this.contenedorProf.getPanelContenido().getPanelEdTem().getNombreApunteSeleccionado()).setTexto(this.texto.getText());
				this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdTem().getNombreTema()).getApunte(this.contenedorProf.getPanelContenido().getPanelEdTem().getNombreApunteSeleccionado()).setVisible(this.comprobarSeleccion());
				this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelEdTem().getNombreTema()).getApunte(this.contenedorProf.getPanelContenido().getPanelEdTem().getNombreApunteSeleccionado()).setTitulo(this.titulonew.getText());
				
			}else{
				
				this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelTema().getNombreTema()).getApunte(this.contenedorProf.getPanelContenido().getPanelTema().getNombreApunteSeleccionado()).setTexto(this.texto.getText());
				this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelTema().getNombreTema()).getApunte(this.contenedorProf.getPanelContenido().getPanelTema().getNombreApunteSeleccionado()).setVisible(this.comprobarSeleccion());
				this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelTema().getNombreTema()).getApunte(this.contenedorProf.getPanelContenido().getPanelTema().getNombreApunteSeleccionado()).setTitulo(this.titulonew.getText());
				
			}
		}
		
		scrollPane.setColumnHeaderView(contenido);
	}
}