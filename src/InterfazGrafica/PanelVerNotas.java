package InterfazGrafica;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Asignatura.Asignatura;
import Asignatura.Tema;
import Examen.Ejercicio;
import eCourses.Alumno;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

/**
 * Clase para definir el panel para ver las notas del alumno
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelVerNotas extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private PanelContenido contenedor;
	
	private JTable tablaNotas;
	private DefaultTableModel modelo;
	
	
	/**
	 * Constructor de la clase PanelVerNotas
	 * @param cont Panel de contenido
	 */
	public PanelVerNotas(PanelContenido cont){
		setBackground(UIManager.getColor("Checkbox.select"));
		this.contenedor = cont;
		
		this.modelo = new DefaultTableModel(new String[] {"Ejercicio", "Nota"}, 0);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 187, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 148, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -159, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -172, SpringLayout.EAST, this);
		add(scrollPane);
		
		this.tablaNotas = new JTable();
		scrollPane.setViewportView(tablaNotas);
		springLayout.putConstraint(SpringLayout.NORTH, tablaNotas, 5, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tablaNotas, 219, SpringLayout.WEST, this);
		this.tablaNotas.setModel(modelo);
		
		JLabel lblMisNotas = new JLabel("Notas");
		springLayout.putConstraint(SpringLayout.WEST, lblMisNotas, 415, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblMisNotas, -62, SpringLayout.NORTH, scrollPane);
		lblMisNotas.setForeground(SystemColor.activeCaption);
		lblMisNotas.setFont(new Font("Nimbus Sans L", Font.BOLD, 31));
		add(lblMisNotas);
		
	}
	
	/**
	 * Obtiene el panel contenedor
	 * @return contenedor
	 */
	public PanelContenido getContenedor(){
		return contenedor;
	}
	
	
	/**
	 * Actualiza la tabla de notas
	 */
	public void actualizarTabla(){
		
		tablaNotas.removeAll();
		
		modelo = new DefaultTableModel(new String[] {"Ejercicio", "Nota"}, 0);
		
		modelo.addRow(new String[]{"Ejercicio", "Nota"});
		
		ArrayList<Asignatura> asigexistentes = new ArrayList<Asignatura>();
		
		Alumno alumno = contenedor.getContenedorAlum().getVentana().getSistema().getAlumnoLog();
		asigexistentes = contenedor.getContenedorAlum().getVentana().getSistema().getAlumnoLog().getAsignaturas();
		
		for (Asignatura a : asigexistentes){
			
			for (Tema b: a.getTemas()){
				
				for (Ejercicio c: b.getEjercicios()){
					
					modelo.addRow(new Object[]{c.getNombre(), c.calcularNota(alumno)});
					
				}		
				
			}
			
		}
		
		 tablaNotas.setModel(modelo);
		
	}
}
