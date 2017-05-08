package InterfazGrafica;


import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;

import Examen.Ejercicio;
import Examen.Pregunta;
import Examen.PreguntaMultiple;
import Examen.PreguntaRedactar;
import Examen.PreguntaTest;

import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Clase que implementa el panel del ejercicio
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelEjercicio extends JPanel{
		
		private static final long serialVersionUID = 1L;
		
		private PanelAlumno contenedorAlum;
		private PanelProfesor cont;
		private JButton realizar;
		private JTabbedPane tabbedPane;
		private Ejercicio ejercicio;
		private JEditorPane respuesta;
		private ButtonGroup grupoBot;
		
		/**
		 * Constructor que immplementa la interfaz grafica del panel de un ejercicio
		 * @param cont Panel de contenido
		 */
		public PanelEjercicio(PanelContenido cont){
		
			this.cont= cont.getContenedorProf();
			
			SpringLayout springLayout = new SpringLayout();
			setLayout(springLayout);

			this.realizar = new JButton("Realizar");
			springLayout.putConstraint(SpringLayout.WEST, realizar, 312, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.EAST, realizar, -368, SpringLayout.EAST, this);
			
			this.add(realizar);
			grupoBot = new ButtonGroup();
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 99, SpringLayout.NORTH, this);
			springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, -151, SpringLayout.SOUTH, this);
			springLayout.putConstraint(SpringLayout.NORTH, realizar, 35, SpringLayout.SOUTH, tabbedPane);
			springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 97, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 732, SpringLayout.WEST, this);
			
			this.add(tabbedPane);
		}
		
		/**
		 * Funcion que actualiza el estado de un ejercicio 
		 */
		public void actualizarejercicio(){
			
			int i,j;
			ejercicio = this.cont.getVentana().getSistema().getAsignatura(this.cont.getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(this.cont.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).getEjercicio(this.cont.getPanelContenido().getPanelTema().getNombreEjercicioSeleccionado());
			
			
			ArrayList<JPanel> panel = new ArrayList<JPanel>();
			this.tabbedPane.removeAll();
				
			i=0;
			for(Pregunta p : ejercicio.getPreguntas()){
		
				panel.add(new JPanel());
				
				tabbedPane.addTab("Pregunta "+ (i+1), null, panel.get(i), null);
				
				
				if(p.getTipoPregunta() == 1){
					//multiple
				
					PreguntaMultiple pregM = (PreguntaMultiple)p;
					
					JLabel lblEnunciadoDeLa = new JLabel(pregM.getEnunciado());
					
					panel.get(i).add(lblEnunciadoDeLa);
					
					JOptionPane.showMessageDialog(this,pregM.getOpciones().size(), "Error",
							JOptionPane.ERROR_MESSAGE);
					
					for(j=0;j<pregM.getOpciones().size();j++){
						grupoBot.add(new JRadioButton(pregM.getOpciones().get(j).getEnunciado()));
						panel.get(i).add(new JRadioButton(pregM.getOpciones().get(j).getEnunciado()));
					}
					
					
					
				}else if(p.getTipoPregunta() == 3){
					//test
			
					
					
					PreguntaTest pregT = (PreguntaTest) p;
					
					JLabel lblEnunciadoDeLa = new JLabel(pregT.getEnunciado());
					
					panel.get(i).add(lblEnunciadoDeLa);
					
					JOptionPane.showMessageDialog(this,pregT.getOpciones().size(), "Error",
							JOptionPane.ERROR_MESSAGE);
					
					for(j=0;j<pregT.getOpciones().size();j++){
						grupoBot.add(new JRadioButton(pregT.getOpciones().get(j).getEnunciado()));
						panel.get(i).add(new JRadioButton(pregT.getOpciones().get(j).getEnunciado()));
					}
					
				}else{
					//Redactar
					
					
					PreguntaRedactar pregR = (PreguntaRedactar)p;
					
					respuesta = new JEditorPane();
				
			
					JLabel lblEnunciadoDeLa = new JLabel(pregR.getEnunciado());
					panel.get(i).add(lblEnunciadoDeLa);
					panel.get(i).add(respuesta);
					
					
					
				}
				
				i++;
			}
			
		
			
			
		}
		
		/**
		 * Funcion que responde a un ejercicio
		 */
		public void responderEjercicio(){
			
			int i;
			
			for(i=0; i<this.ejercicio.getNPreguntas();i++){
				
				if(this.ejercicio.getPreguntas().get(i).getTipoPregunta() == 1){
					//multiple
					
					
					
				}else if(this.ejercicio.getPreguntas().get(i).getTipoPregunta() == 2){
					//test
					
					
				}else{
					//Redactar
					
					
					
					
				}
				
			
			}
		}
		
		/**
		 * Funcion que modifica el controlador del boton realizar
		 * @param c controlador elegido
		 */
		public void setcontrolador(ActionListener c){
			
			this.realizar.addActionListener(c);
			
		}
}