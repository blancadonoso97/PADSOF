package InterfazGrafica;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import Controladores.ControladorCrearAsignatura;
import Controladores.ControladorLogOut;

import java.awt.Component;

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
	private JButton desconectar;
	private JTree contenido;
	private DefaultMutableTreeNode asignaturas = new DefaultMutableTreeNode("Asignaturas"); // Raiz del arbol contenido
	private PanelProfesor contProfe;
	private PanelAlumno contAlumno;
	
	public PanelBarraHerramientas(PanelProfesor profesor){
		
		this.contProfe = profesor;
		
		BoxLayout layout = new BoxLayout(this, 1);

		this.setLayout(layout);
		
		this.hola = new JLabel("Bienvenido a eCourses");
		this.add(hola);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		this.tema = new JButton("Crear Tema");
		this.subtema = new JButton("Crear Subtema");
		this.apuntes = new JButton("Crear Apuntes");
		this.ejercicio = new JButton("Crear Ejercicio");
		this.desconectar = new JButton("Cerrar Sesion");
		this.add(Box.createRigidArea(new Dimension(0,5)));
		this.add(tema);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		this.add(subtema);
		
		this.asignatura = new JButton("Crear Asignatura");
		
		this.add(asignatura);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		this.add(apuntes);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		this.add(ejercicio);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		this.add(desconectar);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		
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
		
		
		// Modificar la posicion del contenido
		
		// Anade el controlador para el boton de crear asignatura
		ControladorCrearAsignatura controlador = new ControladorCrearAsignatura(contProfe.getVentana(),this);
						
		// Anade el controlador para el boton de log out
		ControladorLogOut logout = new ControladorLogOut(contProfe.getVentana());
		
		
		// Configurar el panel con el controlador
		this.setControlador("Asignatura", controlador);
		this.setControlador("Logout", logout);
		
		
		this.setVisible(true);
		
	}

	public PanelBarraHerramientas(PanelAlumno alumno){
		
		this.contAlumno = alumno;
		
		BoxLayout layout = new BoxLayout(this, 1);

		this.setLayout(layout);
		
		this.hola = new JLabel("Bienvenido a eCourses");
		this.add(hola);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		this.matricula = new JButton("Solicitar Matricula");
		this.desconectar = new JButton("Cerrar Sesion");
		this.add(matricula);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		this.add(desconectar);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		
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
		
		
		// Modificar la posicion del contenido
		
		
		
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
		 }
		 
		 
	 }
}
