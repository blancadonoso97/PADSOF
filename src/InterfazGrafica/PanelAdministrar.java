package InterfazGrafica;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Asignatura.Asignatura;
import Controladores.ControladorAdministrar;
import eCourses.Alumno;
import eCourses.Expulsion;
import eCourses.SolicitudMatricula;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

/**
 * Clase para definir el panel de administrar contenido, ver notas, ver matriculas, expulsar
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
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
	private JButton readmitir;
	private JButton estadisticas;
	
	
	/**
	 * Constructor de la clase PanelAdministrar
	 * @param cont Panel contenido
	 */
	public PanelAdministrar(PanelContenido cont){
		setBackground(UIManager.getColor("Checkbox.select"));
		this.contenedor = cont;
		
		// Creacion de la tabla con las peticiones de matricula
		this.modelomat = new DefaultTableModel(new String[] {"Alumno", "Asignatura a matricularse"}, 0);
		
		// Creacion de la tabla de expulsiones
		this.modeloexp = new DefaultTableModel(new String[] {"Alumno", "Expulsado de"}, 0);
		
		this.aceptar = new JButton("Aceptar Matricula");
		this.denegar = new JButton("Denegar Matricula");
		this.expulsar = new JButton("Expulsar");
		this.readmitir = new JButton("Readmitir");
		this.estadisticas = new JButton("Ver estadisticas");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, estadisticas, 77, SpringLayout.EAST, expulsar);
		springLayout.putConstraint(SpringLayout.NORTH, expulsar, 0, SpringLayout.NORTH, aceptar);
		springLayout.putConstraint(SpringLayout.EAST, expulsar, 0, SpringLayout.EAST, readmitir);
		springLayout.putConstraint(SpringLayout.NORTH, readmitir, 0, SpringLayout.NORTH, denegar);
		springLayout.putConstraint(SpringLayout.WEST, readmitir, 61, SpringLayout.EAST, denegar);
		springLayout.putConstraint(SpringLayout.NORTH, denegar, 565, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, aceptar, -35, SpringLayout.NORTH, denegar);
		springLayout.putConstraint(SpringLayout.WEST, denegar, 0, SpringLayout.WEST, aceptar);
		springLayout.putConstraint(SpringLayout.WEST, aceptar, 147, SpringLayout.WEST, this);
		setLayout(springLayout);
		this.add(aceptar);
		this.add(denegar);
		this.add(expulsar);
		this.add(readmitir);
		this.add(estadisticas);
		
		ControladorAdministrar controlador = new ControladorAdministrar(contenedor.getContenedorProf().getVentana(),this);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 189, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, -45, SpringLayout.NORTH, aceptar);
		springLayout.putConstraint(SpringLayout.NORTH, estadisticas, 69, SpringLayout.SOUTH, tabbedPane);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 127, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, -156, SpringLayout.EAST, this);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		add(tabbedPane);
		
		this.tablaMatricula = new JTable();
		tabbedPane.addTab("Matriculas", null, tablaMatricula, null);
		springLayout.putConstraint(SpringLayout.NORTH, tablaMatricula, 17, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tablaMatricula, 25, SpringLayout.WEST, this);
		this.tablaMatricula.setModel(modelomat);
		this.tablaExpulsion = new JTable();
		tabbedPane.addTab("Expulsiones", null, tablaExpulsion, null);
		this.tablaExpulsion.setModel(modeloexp);
		springLayout.putConstraint(SpringLayout.NORTH, tablaExpulsion, 17, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tablaExpulsion, 180, SpringLayout.WEST, this);
		this.tablaAsignaturas = new JTable();
		tablaAsignaturas.setBorder(new LineBorder(new Color(211, 211, 211)));
		tabbedPane.addTab("Asignaturas", null, tablaAsignaturas, null);
		springLayout.putConstraint(SpringLayout.NORTH, tablaAsignaturas, 17, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tablaAsignaturas, 335, SpringLayout.WEST, this);
		
		JLabel lblAdministracionAsignaturas = new JLabel("Administracion Asignaturas");
		springLayout.putConstraint(SpringLayout.WEST, lblAdministracionAsignaturas, 208, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblAdministracionAsignaturas, -48, SpringLayout.NORTH, tabbedPane);
		lblAdministracionAsignaturas.setForeground(SystemColor.activeCaption);
		lblAdministracionAsignaturas.setFont(new Font("Nimbus Sans L", Font.BOLD, 31));
		add(lblAdministracionAsignaturas);
		
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
		 readmitir.addActionListener(c);
		 estadisticas.addActionListener(c);
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
		
		String nombreAsig = tablaMatricula.getModel().getValueAt(fila, 1).toString(); // Nombre = columna 1
		
		return contenedor.getContenedorProf().getVentana().getSistema().getMatricula(idAlumno, nombreAsig);
		
		
	}
	
	/**
	 * Devuelve la expulsion asociada al alumno
	 * @return Expulsion del alumno
	 */
	public Expulsion getExpulsion(){
		
		int fila = tablaAsignaturas.getSelectedRow();
		int columna = tablaAsignaturas.getSelectedColumn();
		
		String idAlumno = tablaAsignaturas.getModel().getValueAt(fila, columna).toString(); // Id = columna 0
		
		String nombreAsig = tablaAsignaturas.getModel().getValueAt(0, columna).toString(); // Nombre = columna 1

		return contenedor.getContenedorProf().getVentana().getSistema().getExpulsion(idAlumno, nombreAsig);
		
		
	}
	
	/**
	 * Devuelve la expulsion vigente
	 * @return Expulsion vigente
	 */
	public Expulsion getExpulsionVigente(){
		
		
		int fila = tablaExpulsion.getSelectedRow();
		int columna = tablaExpulsion.getSelectedColumn();
		
		String idAlumno = tablaExpulsion.getModel().getValueAt(fila, columna).toString(); // Id = columna 0
		
		String nombreAsig = tablaExpulsion.getModel().getValueAt(fila, 1).toString(); // Nombre = columna 1

		return contenedor.getContenedorProf().getVentana().getSistema().getExpulsion(idAlumno, nombreAsig);
		
		
		
	}
	
	/**
	 * Obtiene el id del alumno en la tabla de Asignaturas
	 * @return Alumno seleccionado
	 */
	public Alumno getAlumnoAsignaturas(){
		
		int fila = tablaAsignaturas.getSelectedRow();
		int columna = tablaAsignaturas.getSelectedColumn();
		
		String idAlumno = tablaAsignaturas.getModel().getValueAt(fila, columna).toString();
		
		return contenedor.getContenedorProf().getVentana().getSistema().getAlumno(idAlumno);
		
	}
	
	/**
	 * Obtiene la asignatura en la tabla de asignaturas
	 * @return Asignatura (columna) seleccionada
	 */
	public Asignatura getAsignaturaAsig(){
		
		int columna = tablaAsignaturas.getSelectedColumn();
		int fila = tablaAsignaturas.getSelectedRow();
		String nombreAsig = tablaAsignaturas.getModel().getValueAt(fila, columna).toString();
		
		return contenedor.getContenedorProf().getVentana().getSistema().getAsignatura(nombreAsig);
	}
	
	/**
	 * Obtiene el id del alumno en la tabla de matriculas
	 * @return Alumno seleccionado
	 */
	public Alumno getAlumnoMatriculas(){
		
		int fila = tablaMatricula.getSelectedRow();
		int columna = tablaMatricula.getSelectedColumn();
		
		String idAlumno = tablaMatricula.getModel().getValueAt(fila, columna).toString();
		
		return contenedor.getContenedorProf().getVentana().getSistema().getAlumno(idAlumno);
		
	}
	
	/**
	 * Obtiene la asignatura en la tabla de matriculas
	 * @return Asignatura (columna) seleccionada
	 */
	public Asignatura getAsignaturaMat(){
		
		int columna = tablaMatricula.getSelectedColumn();
		String nombreAsig = tablaMatricula.getModel().getValueAt(0, columna).toString();
		
		return contenedor.getContenedorProf().getVentana().getSistema().getAsignatura(nombreAsig);
	}
	
	/**
	 * Obtiene el id del alumno en la tabla de expulsiones
	 * @return Alumno seleccionado
	 */
	public Alumno getAlumnoExpulsion(){
		
		int fila = tablaExpulsion.getSelectedRow();
		int columna = tablaExpulsion.getSelectedColumn();
		
		String idAlumno = tablaExpulsion.getModel().getValueAt(fila, columna).toString();
		
		return contenedor.getContenedorProf().getVentana().getSistema().getAlumno(idAlumno);
		
	}
	
	/**
	 * Obtiene la asignatura en la tabla de expulsiones
	 * @return Asignatura seleccionada
	 */
	public Asignatura getAsignaturaExp(){
		
		int fila = tablaExpulsion.getSelectedRow();
		String nombreAsig = tablaExpulsion.getModel().getValueAt(fila, 1).toString();
		
		return contenedor.getContenedorProf().getVentana().getSistema().getAsignatura(nombreAsig);
	}
	
	/**
	 * Actualiza la tabla de peticiones de matricula
	 */
	public void actualizarTablaMatriculas(){
		
		tablaMatricula.removeAll();

		modelomat = new DefaultTableModel(new String[] {"Alumno", "Asignatura a matricularse"}, 0);
		
		modelomat.addRow(new String[]{"Alumno", "Asignatura a matricularse"});
		
		ArrayList<SolicitudMatricula> matexistentes = new ArrayList<SolicitudMatricula>();
		
		matexistentes = contenedor.getContenedorProf().getVentana().getSistema().getSolicitudes();

		for (SolicitudMatricula a : matexistentes){
			
			modelomat.addRow(new Object[]{a.getAlumno().getId(), a.getAsignatura().getNombre()});
			
		}
		
		tablaMatricula.setModel(modelomat);
		
	}
	
	
	/**
	 * Actualiza la tabla de expulsiones
	 */
	public void actualizarTablaExpulsiones(){
		
		tablaExpulsion.removeAll();

		modeloexp = new DefaultTableModel(new String[] {"Alumno", "Expulsado de"}, 0);
		
		modeloexp.addRow(new String[]{"Alumno", "Expulsado de"});
		
		ArrayList<Expulsion> expexistentes = new ArrayList<Expulsion>();
		
		expexistentes = contenedor.getContenedorProf().getVentana().getSistema().getExpulsiones();
		
		for (Expulsion a : expexistentes){
			
			modeloexp.addRow(new Object[]{a.getAlumno().getId(), a.getAsignatura().getNombre()});
			
		}
		
		tablaExpulsion.setModel(modeloexp);
		
	}
	
	
	/**
	 * Actualiza la tabla de asignaturas
	 */
	public void actualizarTablaAsignaturas(){
		
		modeloasig = new DefaultTableModel();
		
		ArrayList<Asignatura> asigexistentes = new ArrayList<Asignatura>();
		
		asigexistentes = contenedor.getContenedorProf().getVentana().getSistema().getAsignaturas();
		
		tablaAsignaturas.removeAll();
		
		modeloasig.addColumn("Alumnos por asignatura");
		
		for (Asignatura a : asigexistentes){
			 
			modeloasig.addRow(new Object[]{a.getNombre()});
			
			 for (Alumno b: a.getAlumnos()){
				 
				 modeloasig.addRow(new Object[]{b.getId()});

			 }

		 }
		
		 tablaAsignaturas.setModel(modeloasig);
		 
		
		
	}
}
