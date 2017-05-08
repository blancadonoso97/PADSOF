package InterfazGrafica;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import Asignatura.Apuntes;
import Asignatura.Asignatura;
import Asignatura.Tema;
import Controladores.ControladorBarraHerramientas;
import Examen.Ejercicio;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

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
 * 
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
	private JButton administrar;
	private JButton desconectar;
	private JButton vernotas;
	
	private JTree contenido;
	private JScrollPane pane;
	private ArrayList<Asignatura> asigna;
	private DefaultMutableTreeNode nodohijo;
	private DefaultMutableTreeNode nodonieto;
	private DefaultMutableTreeNode asignaturas = new DefaultMutableTreeNode("Asignaturas"); // Raiz del arbol contenido
																						
	private PanelProfesor contProfe;
	private PanelAlumno contAlumno;
	private Component rigidArea_4;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private JLabel individuo;
	private Component rigidArea_1;
	private DefaultTreeModel modelo;
	private BoxLayout layout;
	private ControladorBarraHerramientas controlador;

	/**
	 * Contructor del panel de herramientas para el profesor
	 * @param profesor Panel del profesor
	 * @wbp.parser.constructor
	 */
	public PanelBarraHerramientas(PanelProfesor profesor) {
		
		layout = new BoxLayout(this, 1);
		
		this.contProfe = profesor;
		
		controlador = new ControladorBarraHerramientas(contProfe.getVentana(), this);
		
		this.hola = new JLabel("Bienvenido");
		this.tema = new JButton("Crear Tema");
		this.ejercicio = new JButton("Crear Ejercicio");
		
		this.modelo = new DefaultTreeModel(asignaturas);
		this.asignatura = new JButton("Crear Asignatura");
		this.subtema = new JButton("Crear Subtema");
		this.apuntes = new JButton("Crear Apuntes");
		this.administrar = new JButton("Administrar");
		this.principal = new JButton("Pagina Principal");
		
		pane = new JScrollPane();
		
		this.contenido = new JTree(modelo);
		this.desconectar = new JButton("Cerrar Sesion");

	}

	/**
	 * Constructor del panel de herramientas para el alumno
	 * @param alumno Panel del alumno log
	 */
	public PanelBarraHerramientas(PanelAlumno alumno) {

		this.contAlumno = alumno;
		layout = new BoxLayout(this, 1);
		
		this.hola = new JLabel("Bienvenido");
		
		this.modelo = new DefaultTreeModel(asignaturas);
		
		this.matricula = new JButton("Solicitar Matricula");
		this.vernotas = new JButton("Ver notas");
		this.desconectar = new JButton("Cerrar Sesion");
		
	
		
		this.contenido = new JTree(modelo);
		this.principal = new JButton("Pagina Principal");
		
		controlador = new ControladorBarraHerramientas(contAlumno.getVentana(), this);
		
		pane = new JScrollPane();

	}

	/**
	 * Obtiene el panel del alumno
	 * @return contAlumno
	 */
	public PanelAlumno getPanelAlumno() {
		return contAlumno;
	}

	/**
	 * Obtiene el panel del profesor
	 * @return contProfe
	 */
	public PanelProfesor getPanelProfe() {
		return contProfe;
	}

	/**
	 * Actualiza el estado de la barra de herramientas
	 * @throws ClassNotFoundException
	 * @throws InvalidEmailAddressException
	 * @throws FailedInternetConnectionException
	 * @throws IOException
	 */
	public void actualizarestado() throws ClassNotFoundException, InvalidEmailAddressException,
			FailedInternetConnectionException, IOException {

		this.removeAll();

		if (this.contProfe != null) {

			this.setLayout(layout);

			rigidArea_1 = Box.createRigidArea(new Dimension(0, 20));
			add(rigidArea_1);
			
			hola.setHorizontalAlignment(SwingConstants.LEADING);
			hola.setForeground(SystemColor.activeCaption);
			hola.setFont(new Font("Nimbus Sans L", Font.BOLD | Font.ITALIC, 24));
			this.add(hola);
			
			Component rigidArea_9 = Box.createRigidArea(new Dimension(0, 10));
			add(rigidArea_9);
			
			individuo = new JLabel("Profesor");
			
			individuo.setHorizontalAlignment(SwingConstants.LEADING);
			individuo.setForeground(SystemColor.activeCaption);
			individuo.setFont(new Font("Nimbus Sans L", Font.BOLD, 30));
			this.add(individuo);
			
			rigidArea_4 = Box.createRigidArea(new Dimension(0, 70));
			add(rigidArea_4);
			
			this.add(asignatura);
			this.add(Box.createRigidArea(new Dimension(0, 20)));

			this.add(tema);
			this.add(Box.createRigidArea(new Dimension(0, 20)));

			this.add(subtema);
			this.add(Box.createRigidArea(new Dimension(0, 20)));
			this.add(ejercicio);
			this.add(Box.createRigidArea(new Dimension(0, 20)));

			this.add(apuntes);
			this.add(Box.createRigidArea(new Dimension(0, 20)));

			rigidArea_2 = Box.createRigidArea(new Dimension(0, 20));
			add(rigidArea_2);

			this.add(administrar);

			this.add(principal);
			Component rigidArea = Box.createRigidArea(new Dimension(0, 20));
			this.add(rigidArea);

			// Configurar los botones con el controlador
			this.setControlador("Asignatura", controlador);
			this.setControlador("Tema", controlador);
			this.setControlador("Apuntes", controlador);
			this.setControlador("Principal", controlador);
			this.setControlador("Subtema", controlador);
			this.setControlador("Administrar", controlador);
			this.setControlador("Ejercicio", controlador);

			asigna = this.contProfe.getVentana().getSistema().getAsignaturas();

			if (asignaturas.getChildCount() > 0) {
				contenido.setModel(null);
			}

			int x = 0;
			int i = 0;
			
			modelo = new DefaultTreeModel(asignaturas);
			
			contenido.setModel(modelo);
			
			modelo = (DefaultTreeModel)contenido.getModel();

			for (Asignatura a : asigna) {

				modelo.insertNodeInto(new DefaultMutableTreeNode(a.getNombre()), asignaturas, i);
				nodohijo = (DefaultMutableTreeNode) modelo.getChild(asignaturas, i);

				int j = 0;
				

				for (Tema t : a.getTemas()) {
					
					modelo.insertNodeInto(new DefaultMutableTreeNode(t.getNombre()), nodohijo, j);
					nodonieto = (DefaultMutableTreeNode) modelo.getChild(nodohijo, j);

					x = 0;
					for (Apuntes ap : t.getApuntes()) {
						modelo.insertNodeInto(new DefaultMutableTreeNode(ap.getTitulo()), nodonieto, x);
						x++;
					}
					for (Tema sub : t.getTemas()) {
						modelo.insertNodeInto(new DefaultMutableTreeNode(sub.getNombre()), nodonieto, x);
						x++;
					}
					for (Ejercicio ej : t.getEjercicios()) {
						modelo.insertNodeInto(new DefaultMutableTreeNode(ej.getNombre()), nodonieto, x);
						x++;
					}
					j++;
				}
				
				i++;
			}

			this.contenido.setModel(modelo);
			this.add(pane);

			contenido.setFont(new Font("Dialog", Font.BOLD , 12));
			contenido.setVisibleRowCount(10);
			contenido.setForeground(SystemColor.menu);
			contenido.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(102, 153, 102)),
					new LineBorder(new Color(102, 153, 102), 1, true)));
			contenido.setBackground(SystemColor.menu);
			contenido.setAlignmentX(Component.LEFT_ALIGNMENT);

			contenido.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			pane.setColumnHeaderView(contenido);
			rigidArea_3 = Box.createRigidArea(new Dimension(0, 70));
			add(rigidArea_3);

			this.add(desconectar);
			this.setControlador("Logout", controlador);

			this.setVisible(true);

		}

		else if (this.contAlumno != null && this.contAlumno.getVentana().getSistema().getAlumnoLog() != null) {

			this.setLayout(layout);

			rigidArea_1 = Box.createRigidArea(new Dimension(0, 20));
			add(rigidArea_1);
			
			hola.setHorizontalAlignment(SwingConstants.LEADING);
			hola.setForeground(SystemColor.activeCaption);
			hola.setFont(new Font("Nimbus Sans L", Font.BOLD | Font.ITALIC, 24));
			this.add(hola);
			
			Component rigidArea_9 = Box.createRigidArea(new Dimension(0, 10));
			add(rigidArea_9);
			
			individuo = new JLabel(this.contAlumno.getVentana().getSistema().getAlumnoLog().getNombre());
			
			individuo.setHorizontalAlignment(SwingConstants.LEADING);
			individuo.setForeground(SystemColor.activeCaption);
			individuo.setFont(new Font("Nimbus Sans L", Font.BOLD, 30));
			this.add(individuo);
			
			rigidArea_4 = Box.createRigidArea(new Dimension(0, 70));
			add(rigidArea_4);

			this.add(matricula);

			this.add(Box.createRigidArea(new Dimension(0, 20)));

			this.add(principal);

			this.add(Box.createRigidArea(new Dimension(0, 20)));
			
			this.add(vernotas);

			if (this.contAlumno.getVentana().getSistema().getAlumnoLog() != null) {

				rigidArea_2 = Box.createRigidArea(new Dimension(0, 20));
				add(rigidArea_2);

				this.setControlador("Matricula", controlador);
				this.setControlador("Logout", controlador);
				this.setControlador("Principal", controlador);
				this.setControlador("Ver notas", controlador);

				asigna = this.contAlumno.getVentana().getSistema().getAlumnoLog().getAsignaturas();
				if (asignaturas.getChildCount() > 0) {
					modelo.removeNodeFromParent((DefaultMutableTreeNode) asignaturas.getChildAt(0));
				}

				int i = 0;
				
				for (Asignatura a : asigna) {
					
					modelo.insertNodeInto(new DefaultMutableTreeNode(a.getNombre()), asignaturas, i);
					nodohijo = (DefaultMutableTreeNode) modelo.getChild(asignaturas, i);
					
					int j = 0;
					
					for (Tema t : a.getTemas()) {
						
						if (t.esVisible() == true) {
							modelo.insertNodeInto(new DefaultMutableTreeNode(t.getNombre()), nodohijo, j);
							nodonieto = (DefaultMutableTreeNode) modelo.getChild(nodohijo, j);

							int x = 0;
							for (Apuntes ap : t.getApuntes()) {
								if (ap.getVisible() == true) {
									modelo.insertNodeInto(new DefaultMutableTreeNode(ap.getTitulo()), nodonieto, x);
								}

								x++;
							}
							for (Tema sub : t.getTemas()) {
								if (sub.esVisible() == true) {
									modelo.insertNodeInto(new DefaultMutableTreeNode(sub.getNombre()), nodonieto, x);
								}

								x++;
							}
							for (Ejercicio ej : t.getEjercicios()) {
								if (ej.getVisible() == true) {
									modelo.insertNodeInto(new DefaultMutableTreeNode(ej.getNombre()), nodonieto, x);
								}

								x++;
							}
						}

						j++;
					}

					i++;
				}

				this.contenido.setModel(modelo);
				this.add(pane);

				contenido.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
				contenido.setVisibleRowCount(10);
				contenido.setForeground(SystemColor.menu);
				
				contenido.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(102, 153, 102)),
						new LineBorder(new Color(102, 153, 102), 1, true)));
				
				contenido.setBackground(SystemColor.menu);
				
				contenido.setAlignmentX(Component.LEFT_ALIGNMENT);

				contenido.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
				pane.setColumnHeaderView(contenido);
				rigidArea_3 = Box.createRigidArea(new Dimension(0, 70));
				add(rigidArea_3);
				this.add(pane);

				this.add(desconectar);
				this.setVisible(true);

			}
		}
	}

	/**
	 * Anade un controlador al boton
	 * @param c Controlador a anadir
	 */
	public void setControlador(String nombreBoton, ActionListener c) {

		if (nombreBoton.equals("Asignatura")) {
			asignatura.addActionListener(c);
		} else if (nombreBoton.equals("Logout")) {
			desconectar.addActionListener(c);
		} else if (nombreBoton.equals("Matricula")) {
			matricula.addActionListener(c);
		} else if (nombreBoton.equals("Tema")) {
			tema.addActionListener(c);
		} else if (nombreBoton.equals("Subtema")) {
			subtema.addActionListener(c);
		} else if (nombreBoton.equals("Apuntes")) {
			apuntes.addActionListener(c);
		} else if (nombreBoton.equals("Principal")) {
			principal.addActionListener(c);
		} else if (nombreBoton.equals("Administrar")) {
			administrar.addActionListener(c);
		} else if (nombreBoton.equals("Ejercicio")) {
			ejercicio.addActionListener(c);
		} else if (nombreBoton.equals("Ver notas")){
			vernotas.addActionListener(c);
		}

	}
}
