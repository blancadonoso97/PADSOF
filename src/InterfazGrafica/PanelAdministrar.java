package InterfazGrafica;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Asignatura.Asignatura;
import Controladores.ControladorAdministrar;
import eCourses.Alumno;
import eCourses.Expulsion;
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
	
	private JTable tablaAsignaturas;
	private DefaultTableModel modeloasig;
	
	private JButton aceptar;
	private JButton denegar;
	private JButton expulsar;
	
	
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
		
		this.aceptar = new JButton("Aceptar peticion");
		this.denegar = new JButton("Denegar peticion");
		this.expulsar = new JButton("Expulsar");
		
		
		this.add(aceptar);
		this.add(denegar);
		this.add(expulsar);
		
		ControladorAdministrar controlador = new ControladorAdministrar(contenedor.getContenedorProf().getVentana(),this);
		
		this.setControlador(controlador);
		
	}
	
	
	/**
	 * Anade un controlador a los botones
	 * @param c Controlador a anadir
	 */
	 public void setControlador(ActionListener c) {
		 aceptar.addActionListener(c);
		 denegar.addActionListener(c);
		 expulsar.addActionListener(c);
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
	public SolicitudMatricula getMatricula(){
		
		
		int fila = tablaMatricula.getSelectedRow();
		String idAlumno = tablaMatricula.getModel().getValueAt(fila, 0).toString(); // Id = columna 0
		
		String nombreAsig = tablaMatricula.getModel().getValueAt(fila, 0).toString(); // Nombre = columna 1
		
		return contenedor.getContenedorProf().getVentana().getSistema().getMatricula(idAlumno, nombreAsig);
		
		
	}
	
	/**
	 * Devuelve la expulsion asociada al alumno
	 * @return
	 */
	public Expulsion getExpulsion(){
		
		int fila = tablaMatricula.getSelectedRow();
		String idAlumno = tablaMatricula.getModel().getValueAt(fila, 0).toString(); // Id = columna 0
		
		String nombreAsig = tablaMatricula.getModel().getValueAt(fila, 0).toString(); // Nombre = columna 1

		return contenedor.getContenedorProf().getVentana().getSistema().getExpulsion(idAlumno, nombreAsig);
		
		
	}
	
	/**
	 * Obtiene el id del alumno en la tabla de Asignaturas
	 * @return Alumno seleccionado
	 */
	public Alumno getAlumno(){
		
		int fila = tablaExpulsion.getSelectedRow();
		int columna = tablaExpulsion.getSelectedColumn();
		
		String idAlumno = tablaExpulsion.getModel().getValueAt(fila, columna).toString();
		
		return contenedor.getContenedorProf().getVentana().getSistema().getAlumno(idAlumno);
		
	}
	
	/**
	 * Obtiene la asignatura en la tabla de asignaturas
	 * @return Asignatura (columna) seleccionada
	 */
	public Asignatura getAsignatura(){
		
		int columna = tablaExpulsion.getSelectedColumn();
		String nombreAsig = tablaExpulsion.getModel().getValueAt(0, columna).toString();
		
		return contenedor.getContenedorProf().getVentana().getSistema().getAsignatura(nombreAsig);
	}
	
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
	
	
	/**
	 * Actualiza la tabla de asignaturas
	 */
	public void actualizarTablaAsignaturas(){
		
		
		
	}
	
}
