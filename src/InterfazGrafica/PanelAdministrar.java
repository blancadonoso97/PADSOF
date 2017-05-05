package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import eCourses.SolicitudMatricula;

/**
 * Clase para definir el panel de administrar contenido, ver notas, ver matriculas, expulsar
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelAdministrar extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private PanelContenido contenedor;
	
	private JTable tablaMatricula;
	private DefaultTableModel modelomat;
	
	private JTable tablaExpulsion;
	private DefaultTableModel modeloexp;
	
	
	/**
	 * Constructor de la clase PanelAdministrar
	 * @param cont Panel contenido
	 */
	public PanelAdministrar(PanelContenido cont){
		
		this.contenedor = cont;
		
		// Creacion de la tabla con las peticiones de matricula
		this.modelomat = new DefaultTableModel(new String[] {"Alumno", "Asignatura a matricularse"}, 0);
		this.tablaMatricula.setModel(modelomat);
		
		// Creacion de la tabla de expulsiones
		this.modeloexp = new DefaultTableModel(new String[] {"Alumno", "Expulsado de"}, 0);
		this.tablaExpulsion.setModel(modeloexp);
		
		// Creacion de la tabla de asignaturas
		
	}
	
	
	/**
	 * Devuelve el panel que contiene a crear asignatura
	 * @return contenedor
	 */
	public PanelContenido getContenedor(){
		return contenedor;
	}
	
	/**
	 * Obtiene la solicitud de matricula de la tabla
	 * @return Solicitud de matricula
	 */
	/*public SolicitudMatricula getMatricula(){
		
		
		return modelomat.getDataVector().elementAt(tablaMatricula.getSelectedRow());
		
		
	}*/
	
	/**
	 * Actualiza la tabla de peticiones de matricula
	 */
	public void actualizarTablaMatriculas(){
		
		
		
	}
	
	
	/**
	 * Actualiza la tabla de expulsiones
	 */
	public void actualizarTablaExpulsiones(){
		
		
		
	}
	
	
}
