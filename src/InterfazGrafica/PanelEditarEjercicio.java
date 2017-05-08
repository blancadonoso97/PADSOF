package InterfazGrafica;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;

import Controladores.ControladorEditarContenido;
import Examen.Ejercicio;
import Examen.Pregunta;

import java.awt.event.ActionListener;


import javax.swing.JList;

/**
 * Clase que implementa el panel de editar el ejercicio
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelEditarEjercicio extends JPanel{
		
		private static final long serialVersionUID = 1L;
		
		private DefaultListModel<String> preguntas = new DefaultListModel<String>(); 
		private PanelProfesor contProf;
		private JTabbedPane tabbedPane;
		private JButton crearpreguntamultiple;
		private Ejercicio ejercicio;
		private JButton crearpreguntaredactar;
		private JButton crearpreguntatest;
		private JButton btnBorrarPreguntaTest;
		private JButton btnBorrarPreguntaRedactar;
		private JButton btnBorrarPreguntaMultiple;
		private JScrollPane scrollPane;
		
		/**
		 * Constructor de la clase PanelEditarEjercicio
		 * @param cont Panel de contenido
		 */
		public PanelEditarEjercicio(PanelContenido cont){
		
			this.contProf= cont.getContenedorProf();
			
			SpringLayout springLayout = new SpringLayout();
			setLayout(springLayout);

			this.crearpreguntamultiple = new JButton("Crear pregunta multiple");
			
			this.crearpreguntaredactar = new JButton("Crear pregunta redactar");
			springLayout.putConstraint(SpringLayout.NORTH, crearpreguntamultiple, 16, SpringLayout.SOUTH, crearpreguntaredactar);
			springLayout.putConstraint(SpringLayout.WEST, crearpreguntamultiple, 0, SpringLayout.WEST, crearpreguntaredactar);
			springLayout.putConstraint(SpringLayout.EAST, crearpreguntamultiple, 0, SpringLayout.EAST, crearpreguntaredactar);
			springLayout.putConstraint(SpringLayout.WEST, crearpreguntaredactar, 68, SpringLayout.WEST, this);
			this.crearpreguntatest = new JButton("Crear pregunta test");
			springLayout.putConstraint(SpringLayout.WEST, crearpreguntatest, 82, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.NORTH, crearpreguntaredactar, 23, SpringLayout.SOUTH, crearpreguntatest);
			
			ControladorEditarContenido cont1 = new ControladorEditarContenido(this);
			this.setcontrolador(cont1, "multiple");	
			this.setcontrolador(cont1, "redactar");	
			this.setcontrolador(cont1, "test");
			this.add(crearpreguntamultiple);
			this.add(crearpreguntaredactar);
			this.add(crearpreguntatest);
			
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 108, SpringLayout.NORTH, this);
			springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, -350, SpringLayout.SOUTH, this);
			springLayout.putConstraint(SpringLayout.NORTH, crearpreguntatest, 51, SpringLayout.SOUTH, tabbedPane);
			springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 50, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 685, SpringLayout.WEST, this);
			
			scrollPane = new JScrollPane();
			
			
			springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 137, SpringLayout.NORTH, this);
			springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -167, SpringLayout.SOUTH, this);
			springLayout.putConstraint(SpringLayout.WEST, scrollPane, 49, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.EAST, scrollPane, 318, SpringLayout.WEST, this);
			
			JList<String> listpreguntas = new JList<String>(preguntas);
			scrollPane.setViewportView(listpreguntas);
			tabbedPane.addTab("Preguntas", null, scrollPane, null);
			this.add(tabbedPane);
			
		
			btnBorrarPreguntaTest = new JButton("Borrar pregunta test");
			springLayout.putConstraint(SpringLayout.NORTH, btnBorrarPreguntaTest, 0, SpringLayout.NORTH, crearpreguntatest);
			springLayout.putConstraint(SpringLayout.WEST, btnBorrarPreguntaTest, 167, SpringLayout.EAST, crearpreguntatest);
			add(btnBorrarPreguntaTest);
			
			btnBorrarPreguntaRedactar = new JButton("Borrar pregunta redactar");
			springLayout.putConstraint(SpringLayout.NORTH, btnBorrarPreguntaRedactar, 0, SpringLayout.NORTH, crearpreguntaredactar);
			springLayout.putConstraint(SpringLayout.WEST, btnBorrarPreguntaRedactar, 133, SpringLayout.EAST, crearpreguntaredactar);
			add(btnBorrarPreguntaRedactar);
			
			btnBorrarPreguntaMultiple = new JButton("Borrar pregunta multiple");
			springLayout.putConstraint(SpringLayout.NORTH, btnBorrarPreguntaMultiple, 0, SpringLayout.NORTH, crearpreguntamultiple);
			springLayout.putConstraint(SpringLayout.EAST, btnBorrarPreguntaMultiple, 0, SpringLayout.EAST, btnBorrarPreguntaRedactar);
			add(btnBorrarPreguntaMultiple);
		}
		
		/**
		 * Funcion que actualiza el estado de un ejercicio 
		 */
		public void actualizarejercicio(){
			
			ejercicio = this.getEjercicio();
			
			if(!ejercicio.getPreguntas().isEmpty()){
				preguntas.removeAllElements();
					
				for(Pregunta a : ejercicio.getPreguntas()){
					preguntas.addElement(a.getEnunciado());
				}
				
				
			}else{
				preguntas.removeAllElements();
				this.preguntas.addElement("El ejercicio no tiene preguntas");
			}
		}
		
		
		/**
		 * Set del controlador
		 * @param c Controlador 
		 * @param nombre Nombre del boton
		 */
		public void setcontrolador(ActionListener c,String nombre){
			if(nombre.equals("multiple")){
				this.crearpreguntamultiple.addActionListener(c);
			}else if(nombre.equals("redactar")){
				this.crearpreguntaredactar.addActionListener(c);
			}else if(nombre.equals("test")){
				this.crearpreguntatest.addActionListener(c);
			}
			
		}
	
		/**
		 * Devuelve el ejercicio seleccionado
		 * @return Ejercicio seleccionado
		 */
		public Ejercicio getEjercicio(){
			return this.contProf.getVentana().getSistema().getAsignatura
					(this.contProf.getPanelContenido().getPanelAsignatura().getNombreAsignatura()).
					getTema(this.contProf.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).
					getEjercicio(this.contProf.getPanelContenido().getPanelTema().getNombreEjercicioSeleccionado());
		}
		
		/**
		 * Devuelve el panel del alumno
		 * @return contenedorAlum
		 */
		public PanelProfesor getPanelProfesor(){
			return this.contProf;
		}
}