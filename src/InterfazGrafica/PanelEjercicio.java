package InterfazGrafica;


import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import Controladores.ControladorRealizarEjercicio;
import Examen.Ejercicio;
import Examen.Opcion;
import Examen.Pregunta;
import Examen.PreguntaMultiple;
import Examen.PreguntaRedactar;
import Examen.PreguntaTest;

import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 * Clase que implementa el panel del ejercicio
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class PanelEjercicio extends JPanel{
		
		private static final long serialVersionUID = 1L;
		
		private PanelAlumno contenedorAlum;
		private JButton realizar;
		private JTabbedPane tabbedPane;
		private Ejercicio ejercicio;
		private JEditorPane respuesta;
		private ButtonGroup grupoBot;
		private ArrayList<JPanel> panel;
		private ArrayList<Opcion> opcionesmarcadas;
		
		/**
		 * Constructor que immplementa la interfaz grafica del panel de un ejercicio
		 * @param cont Panel de contenido
		 */
		public PanelEjercicio(PanelContenido cont){
			setBackground(UIManager.getColor("Checkbox.select"));
			this.contenedorAlum= cont.getContenedorAlum();
			
			SpringLayout springLayout = new SpringLayout();
			setLayout(springLayout);
			ControladorRealizarEjercicio cont1 = new ControladorRealizarEjercicio(this);
			this.realizar = new JButton("Realizar");
			springLayout.putConstraint(SpringLayout.WEST, realizar, 312, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.EAST, realizar, -368, SpringLayout.EAST, this);
			opcionesmarcadas = new ArrayList<Opcion> ();
			this.setcontrolador(cont1);
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
			ejercicio = this.contenedorAlum.getVentana().getSistema().getAsignatura
					(this.contenedorAlum.getPanelContenido().getPanelAsignatura().getNombreAsignatura())
					.getTema(this.contenedorAlum.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado())
					.getEjercicio(this.contenedorAlum.getPanelContenido().getPanelTema().getNombreEjercicioSeleccionado());
			
			
			panel = new ArrayList<JPanel>();
			
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
				
					
					for(j=0;j<pregM.getOpciones().size();j++){
						grupoBot.add(new JRadioButton(pregM.getOpciones().get(j).getEnunciado()));
						panel.get(i).add(new JRadioButton(pregM.getOpciones().get(j).getEnunciado()));
					}
					
					panel.get(i).setName("multiple");
				}else if(p.getTipoPregunta() == 3){
					//test
			
					
					
					PreguntaTest pregT = (PreguntaTest) p;
					
					JLabel lblEnunciadoDeLa = new JLabel(pregT.getEnunciado());
					
					panel.get(i).add(lblEnunciadoDeLa);
					
					JRadioButton boton;
					for(j=0;j<pregT.getOpciones().size();j++){
						boton = new JRadioButton(pregT.getOpciones().get(j).getEnunciado());
						grupoBot.add(boton);
						panel.get(i).add(boton);
					}
					
					panel.get(i).setName("test");
					
					
				}else{
					//Redactar
					
					
					PreguntaRedactar pregR = (PreguntaRedactar)p;
					
					respuesta = new JEditorPane();
				
			
					JLabel lblEnunciadoDeLa = new JLabel(pregR.getEnunciado());
					panel.get(i).add(lblEnunciadoDeLa);
					panel.get(i).add(respuesta);
					
					panel.get(i).setName("redactar");
					
				}
				
				i++;
			}
			
		
			
			
		}
		
		/**
		 * Funcion que responde a un ejercicio
		 */
		public void responderEjercicio(){
			
			int i=0;
			int j;
			
			
			for( i = 0 ; i < panel.size() ; i++){
				
				
				JLabel l = (JLabel)panel.get(i).getComponent(0);
					
				for(Pregunta preg : ejercicio.getPreguntas()){
						
					if(preg.getEnunciado().equals(l.getText())){
							
						if(preg.getTipoPregunta() == 1){
							//multiple
							PreguntaMultiple pregM = (PreguntaMultiple)preg;
								
							
								
							for(j=0;j<pregM.getOpciones().size();j++){
									
								JRadioButton elegido = (JRadioButton)panel.get(i).getComponent(j+1);
									
								if(elegido.isSelected()){
										
									for(Opcion o: pregM.getOpciones()){
										if(o.getEnunciado().equals(elegido.getText())){
											opcionesmarcadas.add(o);
										}
									}
								}
									
							}
								
								
								
						}else if(preg.getTipoPregunta() == 3){
							//test
						
								

						PreguntaTest pregT = (PreguntaTest) preg;
								
							for(j=0;j<pregT.getOpciones().size();j++){
									
								JRadioButton elegido = (JRadioButton)panel.get(i).getComponent(j+1);
									
								if(elegido.isSelected()){
										
									for(Opcion o: pregT.getOpciones()){
										if(o.getEnunciado().equals(elegido.getText())){
											opcionesmarcadas.add(o);
										}
									}
								}
									
							}
								
								
								
						}else{
							//Redactar
								
								
							PreguntaRedactar pregR = (PreguntaRedactar)preg;
							respuesta = (JEditorPane)panel.get(i).getComponent(1);
							
							for(Opcion o : pregR.getOpciones()){
									if(o.getEnunciado().equals(respuesta.getText())){
										opcionesmarcadas.add(o);
									}
							}
						}	
							
					}
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
		
		public ArrayList<Opcion> getOpcionesMarcadas(){
			return this.opcionesmarcadas;
		}
		
		
		public Ejercicio getEjercicio(){
			return this.contenedorAlum.getVentana().getSistema().getAsignatura
					(this.contenedorAlum.getPanelContenido().getPanelAsignatura().getNombreAsignatura()).
					getTema(this.contenedorAlum.getPanelContenido().getPanelAsignatura().getNombreTemaSeleccionado()).
					getEjercicio(this.contenedorAlum.getPanelContenido().getPanelTema().getNombreEjercicioSeleccionado());
		}
		/**
		 * Devuelve el panel del alumno
		 * @return contenedorAlum
		 */
		public PanelAlumno getPanelAlumno(){
			return contenedorAlum;
		}
}