package InterfazGrafica;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
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
	private JButton desconectar;
	private JTree contenido;
	private DefaultMutableTreeNode asignaturas = new DefaultMutableTreeNode("Asignaturas"); // Raiz del arbol contenido
	
	
	public PanelBarraHerramientas(){
		
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
		
		
		
		this.setVisible(true);
		
	}

}
