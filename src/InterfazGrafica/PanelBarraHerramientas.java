package InterfazGrafica;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import Controladores.ControladorBarraHerramientas;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

/**
 * Clase para definir el panel de herramientas dentro del panel de profesor o alumno
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelBarraHerramientas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel hola;
	private JButton asignatura;
	private JButton tema;
	private JButton subtema;
	private JButton apuntes;
	private JButton ejercicio;
	private JButton matricula;
	private JButton principal;
	private JButton desconectar;
	private JTree contenido;
	private DefaultMutableTreeNode asignaturas = new DefaultMutableTreeNode("Asignaturas"); // Raiz del arbol contenido
	private PanelProfesor contProfe;
	private PanelAlumno contAlumno;
	private Component rigidArea_4;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private JLabel imagen;
	private Component rigidArea_1;
	
	/**
	 * @wbp.parser.constructor
	 */
	public PanelBarraHerramientas(PanelProfesor profesor){
		setBackground(SystemColor.menu);
		
		this.contProfe = profesor;
		
		BoxLayout layout = new BoxLayout(this, 1);

		this.setLayout(layout);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(0, 20));
		add(rigidArea_1);
		
		this.hola = new JLabel("Bienvenido a");
		hola.setHorizontalAlignment(SwingConstants.CENTER);
		hola.setFont(new Font("WenQuanYi Micro Hei Mono", Font.BOLD | Font.ITALIC, 30));
		this.add(hola);
		this.tema = new JButton("Crear Tema");
		this.ejercicio = new JButton("Crear Ejercicio");
		ImageIcon icono = new ImageIcon("eCourses.png", "Logo");
		this.imagen = new JLabel(icono);
		this.add(imagen);
		
		rigidArea_4 = Box.createRigidArea(new Dimension(0, 70));
		add(rigidArea_4);
		this.add(tema);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		this.asignatura = new JButton("Crear Asignatura");
		
		this.add(asignatura);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(ejercicio);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		this.principal = new JButton("Pagina Principal");

		this.add(principal);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		// Pruebas
		asignaturas.add(new DefaultMutableTreeNode("tema 1"));
		asignaturas.add(new DefaultMutableTreeNode("tema 2"));
		
		DefaultMutableTreeNode repositorio = new DefaultMutableTreeNode("repositorio de ejemplos");
		
		repositorio.add(new DefaultMutableTreeNode("ejemplo 1"));
		
		asignaturas.add(repositorio);

		
		// Modificar la posicion del contenido
		
		
		this.subtema = new JButton("Crear Subtema");
		this.add(subtema);
		
		rigidArea_2 = Box.createRigidArea(new Dimension(0, 20));
		add(rigidArea_2);
		this.apuntes = new JButton("Crear Apuntes");
		this.add(apuntes);
		Component rigidArea = Box.createRigidArea(new Dimension(0,20));
		this.add(rigidArea);
		
		
		this.contenido = new JTree(asignaturas);
		contenido.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		contenido.setVisibleRowCount(10);
		contenido.setForeground(SystemColor.menu);
		contenido.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(102, 153, 102)), new LineBorder(new Color(102, 153, 102), 1, true)));
		contenido.setBackground(SystemColor.menu);
		contenido.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		contenido.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		this.add(contenido);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(0, 70));
		add(rigidArea_3);
		this.desconectar = new JButton("Cerrar Sesion");
		this.add(desconectar);
		
		// Creacion del controlador
		ControladorBarraHerramientas controlador = new ControladorBarraHerramientas(contProfe.getVentana(),this);
		
		// Configurar los botones con el controlador
		this.setControlador("Asignatura", controlador);
		this.setControlador("Logout", controlador);
		this.setControlador("Tema", controlador);
		this.setControlador("Apuntes", controlador);
		this.setControlador("Principal", controlador);
		this.setControlador("Subtema", controlador);
		
		this.setVisible(true);
		
	}

	public PanelBarraHerramientas(PanelAlumno alumno){
		
		this.contAlumno = alumno;
		
		BoxLayout layout = new BoxLayout(this, 1);

		this.setLayout(layout);
		
		this.hola = new JLabel("Bienvenido a");
		hola.setHorizontalAlignment(SwingConstants.CENTER);
		hola.setFont(new Font("WenQuanYi Micro Hei Mono", Font.BOLD | Font.ITALIC, 30));
		this.add(hola);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		this.matricula = new JButton("Solicitar Matricula");
		this.desconectar = new JButton("Cerrar Sesion");
		
		ImageIcon icono = new ImageIcon("eCourses.png", "Logo");
		this.imagen = new JLabel(icono);
		this.add(imagen);
		
		rigidArea_4 = Box.createRigidArea(new Dimension(0, 70));
		add(rigidArea_4);
		
		this.add(matricula);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.principal = new JButton("Pagina Principal");

		this.add(principal);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		
		this.contenido = new JTree(asignaturas);
		contenido.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		contenido.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Pruebas
		asignaturas.add(new DefaultMutableTreeNode("tema 1"));
		asignaturas.add(new DefaultMutableTreeNode("tema 2"));
		
		DefaultMutableTreeNode repositorio = new DefaultMutableTreeNode("repositorio de ejemplos");
		
		repositorio.add(new DefaultMutableTreeNode("ejemplo 1"));
		
		asignaturas.add(repositorio);
		
		this.add(contenido);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(0, 70));
		add(rigidArea_3);
		
		this.add(desconectar);
		
		
		// Modificar la posicion del contenido
		
		// Creacion del controlador
		ControladorBarraHerramientas controlador = new ControladorBarraHerramientas(contAlumno.getVentana(),this);
				
		// Configurar los botones con el controlador
		this.setControlador("Matricula", controlador);
		this.setControlador("Logout", controlador);
		this.setControlador("Principal", controlador);
		this.setVisible(true);
		
	}

	public PanelAlumno getPanelAlumno(){
			return this.contAlumno;
	}
		
	public PanelProfesor getPanelProfe(){
			return this.contProfe;
	}
	
	/**
	 * Anade un controlador al boton
	 * @param c Controlador a anadir
	 */
	 public void setControlador(String nombreBoton, ActionListener c) {
		 
		 if(nombreBoton.equals("Asignatura")){
			 asignatura.addActionListener(c);
		 }else if (nombreBoton.equals("Logout")){
			 desconectar.addActionListener(c);
		 }else if(nombreBoton.equals("Matricula")){
			 matricula.addActionListener(c);
		 }else if(nombreBoton.equals("Tema")){
			 tema.addActionListener(c);
		 }else if(nombreBoton.equals("Subtema")){
			 subtema.addActionListener(c);
		 }else if(nombreBoton.equals("Apuntes")){
			 apuntes.addActionListener(c);
		 }else if(nombreBoton.equals("Principal")){
			 principal.addActionListener(c);
		 }
		 
		 
	 }
}
