package InterfazGrafica;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 * Clase para definir el panel de herramientas dentro del panel de profesor o alumno
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelBarraHerramientas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JButton desconectar;
	private JTree contenido;
	private DefaultMutableTreeNode asignaturas = new DefaultMutableTreeNode("Asignaturas"); // Raiz del arbol contenido
	
	
	public PanelBarraHerramientas(){
		
		
		this.desconectar = new JButton("Cerrar Sesion");
		this.add(desconectar);
		
		this.contenido = new JTree(asignaturas);
		
		// Por defecto se pueden seleccionar varios nodos en el árbol. Para poder seleccionar sólo uno, usar setSelectionModel
		contenido.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		// Para añadir hijos al nodo raiz (o a otros nodos del árbol) usamos el método add(<nodo>)
		asignaturas.add(new DefaultMutableTreeNode("tema 1"));
		asignaturas.add(new DefaultMutableTreeNode("tema 2"));
		
		DefaultMutableTreeNode repositorio = new DefaultMutableTreeNode("repositorio de ejemplos");
		
		repositorio.add(new DefaultMutableTreeNode("ejemplo 1"));
		
		asignaturas.add(repositorio);
		
		this.add(contenido);
		
		
	}

}
