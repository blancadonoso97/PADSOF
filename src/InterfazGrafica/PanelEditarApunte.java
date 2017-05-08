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
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.SystemColor;
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
		
		setBackground(UIManager.getColor("Checkbox.select"));
		
		this.springLayout = new SpringLayout();
		setLayout(springLayout);
		
		this.scrollPane = new JScrollPane();
		this.springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 268, SpringLayout.NORTH, this);
		this.springLayout.putConstraint(SpringLayout.WEST, scrollPane, 58, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -51, SpringLayout.EAST, this);
		this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scrollPane);
		
		this.texto = new JEditorPane();
		this.scrollPane.setViewportView(texto);
		
		this.contenido = new JTextPane();
	
		this.contenedorProf = cont.getContenedorProf();
		
		this.titulonew = new JEditorPane();
		springLayout.putConstraint(SpringLayout.WEST, titulonew, 149, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, titulonew, -167, SpringLayout.EAST, this);
		this.add(titulonew);
		
		this.visible = new JRadioButton("Apuntes visibles");
		visible.setBackground(UIManager.getColor("Checkbox.select"));
		
		this.novisible = new JRadioButton("Apuntes no visibles");
		springLayout.putConstraint(SpringLayout.NORTH, novisible, 421, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -17, SpringLayout.NORTH, novisible);
		springLayout.putConstraint(SpringLayout.NORTH, visible, 6, SpringLayout.SOUTH, novisible);
		springLayout.putConstraint(SpringLayout.WEST, visible, 10, SpringLayout.WEST, novisible);
		springLayout.putConstraint(SpringLayout.WEST, novisible, 103, SpringLayout.WEST, this);
		novisible.setBackground(UIManager.getColor("Checkbox.select"));
		
		this.visibilidad = new ButtonGroup();
		
		visibilidad.add(visible);
		visibilidad.add(novisible);
		this.add(novisible);
		this.add(visible);
		
		guardar = new JButton("Guardar");
		springLayout.putConstraint(SpringLayout.NORTH, guardar, -1, SpringLayout.NORTH, visible);
		springLayout.putConstraint(SpringLayout.WEST, guardar, 147, SpringLayout.EAST, visible);
		springLayout.putConstraint(SpringLayout.EAST, guardar, 504, SpringLayout.WEST, this);
		
		ControladorEditarContenido cont1 = new ControladorEditarContenido(this);
		this.setControlador(cont1);
		add(guardar);
		
		JLabel lblContenido = DefaultComponentFactory.getInstance().createLabel("Contenido : ");
		springLayout.putConstraint(SpringLayout.SOUTH, titulonew, -24, SpringLayout.NORTH, lblContenido);
		springLayout.putConstraint(SpringLayout.WEST, lblContenido, 0, SpringLayout.WEST, guardar);
		springLayout.putConstraint(SpringLayout.SOUTH, lblContenido, -6, SpringLayout.NORTH, scrollPane);
		lblContenido.setForeground(SystemColor.activeCaption);
		lblContenido.setFont(new Font("Nimbus Sans L", Font.BOLD, 17));
		add(lblContenido);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Titulo : ");
		springLayout.putConstraint(SpringLayout.WEST, lblNewJgoodiesLabel, 414, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewJgoodiesLabel, -6, SpringLayout.NORTH, titulonew);
		lblNewJgoodiesLabel.setForeground(SystemColor.activeCaption);
		lblNewJgoodiesLabel.setFont(new Font("Nimbus Sans L", Font.BOLD, 17));
		add(lblNewJgoodiesLabel);
		
		JLabel lblEditarApuntes = DefaultComponentFactory.getInstance().createTitle("Editar Apuntes");
		springLayout.putConstraint(SpringLayout.WEST, lblEditarApuntes, 339, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEditarApuntes, -39, SpringLayout.NORTH, lblNewJgoodiesLabel);
		lblEditarApuntes.setForeground(SystemColor.activeCaption);
		lblEditarApuntes.setFont(new Font("Nimbus Sans L", Font.BOLD, 32));
		add(lblEditarApuntes);
		
		
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