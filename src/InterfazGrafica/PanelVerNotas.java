package InterfazGrafica;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Asignatura.Asignatura;
import Asignatura.Tema;
import Examen.Ejercicio;
import eCourses.Alumno;

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
		
		this.contenedor = cont;
		
		this.tablaNotas = new JTable();
		
		this.modelo = new DefaultTableModel(new String[] {"Ejercicio", "Nota"}, 0);
		this.tablaNotas.setModel(modelo);
		
		this.add(tablaNotas);
		
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
		
		modelo = new DefaultTableModel();
		
		tablaNotas.removeAll();
		
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
