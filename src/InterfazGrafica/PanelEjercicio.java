package InterfazGrafica;


import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;

import Examen.Ejercicio;
import Examen.PreguntaMultiple;
import Examen.PreguntaRedactar;
import Examen.PreguntaTest;

import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Panel;
import javax.swing.JLabel;

/**
 * Clase que implementa el panel del ejercicio
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelEjercicio extends JPanel{
		
		
		private static final long serialVersionUID = 1L;
		private PanelAlumno contenedorAlum;
		private JButton realizar;
		private JTabbedPane tabbedPane;
		private Ejercicio ejercicio;
		private JEditorPane respuesta;
		
		/**
		 * Constructor que immplementa la interfaz grafica del panel de un ejercicio
		 * @param cont
		 */
		public PanelEjercicio(PanelContenido cont){
		
			this.contenedorAlum = cont.getContenedorAlum();
			
			SpringLayout springLayout = new SpringLayout();
			setLayout(springLayout);

			this.realizar = new JButton("Realizar");
			springLayout.putConstraint(SpringLayout.WEST, realizar, 312, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.EAST, realizar, -368, SpringLayout.EAST, this);
			
			
			this.add(realizar);
			
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
			ejercicio = this.contenedorAlum.getVentana().getSistema().getAsignatura(this.contenedorAlum.getPanelContenido().getPanelAsignatura().getNombreAsignatura()).getTema(this.contenedorAlum.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).getEjercicio(this.contenedorAlum.getPanelContenido().getPanelTema().getNombreEjercicioSeleccionado());
			
			ArrayList<Panel> panel = new ArrayList<Panel>();
			this.tabbedPane.removeAll();
				
			for(i=0; i<this.ejercicio.getNPreguntas();i++){
		
				panel.add(new Panel());
				
				tabbedPane.addTab("Pregunta "+i, null, panel.get(i), null);
				
				if(this.ejercicio.getPreguntas().get(i).getTipoPregunta() == 1){
					//multiple
					
					PreguntaMultiple pregM = (PreguntaMultiple) this.ejercicio.getPreguntas().get(i);
					JRadioButton[] opciones = new JRadioButton[pregM.getOpciones().size()];
					ButtonGroup grupoBot = new ButtonGroup();
					
					for(j=0;j<pregM.getOpciones().size();j++){
						opciones[j] = new JRadioButton(pregM.getOpciones().get(j).getEnunciado());
						grupoBot.add(opciones[j]);
						panel.get(i).add(opciones[j], grupoBot);
					}
					
					
				}else if(this.ejercicio.getPreguntas().get(i).getTipoPregunta() == 2){
					//test
					
					PreguntaTest pregT = (PreguntaTest) this.ejercicio.getPreguntas().get(i);
					JRadioButton[] opciones = new JRadioButton[pregT.getOpciones().size()];
					
					for(j=0;j<pregT.getOpciones().size();j++){
						opciones[j] = new JRadioButton(pregT.getOpciones().get(j).getEnunciado());
					}
					
				}else{
					//Redactar
					
					PreguntaRedactar pregR = (PreguntaRedactar) this.ejercicio.getPreguntas().get(i);
					
					SpringLayout sl_panel = new SpringLayout();
					panel.get(i).setLayout(sl_panel);
					
					respuesta = new JEditorPane();
					sl_panel.putConstraint(SpringLayout.WEST, respuesta, 85, SpringLayout.WEST, panel.get(i));
					sl_panel.putConstraint(SpringLayout.EAST, respuesta, 528, SpringLayout.WEST, panel.get(i));
					panel.get(i).add(respuesta);
					
			
					JLabel lblEnunciadoDeLa = new JLabel(pregR.getEnunciado());
					sl_panel.putConstraint(SpringLayout.SOUTH, lblEnunciadoDeLa, -191, SpringLayout.SOUTH, panel.get(i));
					sl_panel.putConstraint(SpringLayout.NORTH, respuesta, 45, SpringLayout.SOUTH, lblEnunciadoDeLa);
					sl_panel.putConstraint(SpringLayout.WEST, lblEnunciadoDeLa, 178, SpringLayout.WEST, panel.get(i));
					panel.get(i).add(lblEnunciadoDeLa);
					
					
				}
				
			
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