package Controladores;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import InterfazGrafica.PanelEditarApunte;
import InterfazGrafica.PanelEditarAsignatura;
import InterfazGrafica.PanelEditarTema;
import InterfazGrafica.PanelPrincipal;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ControladorEditarContenido   implements ActionListener{
	
	private PanelPrincipal panelp;
	private PanelEditarAsignatura panela;
	private PanelEditarTema panelt;
	private PanelEditarApunte panelap;
	
	/**
	 * Constructor de la clase ControladorInicioSesion
	 * @param sist Sistema (eCourses)
	 * @param pan Panel asociado al controlador
	 */
	public ControladorEditarContenido(PanelPrincipal pan){
	
		this.panelp = pan;
		
	}
	
	public ControladorEditarContenido(PanelEditarAsignatura pan){
		
		this.panela = pan;
		
	}
	
	public ControladorEditarContenido(PanelEditarTema pan){
		
		this.panelt = pan;
		
	}
	
	public ControladorEditarContenido(PanelEditarApunte pan){
		
		this.panelap = pan;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
		int i;
		boolean exist = false;
		
		if(panelp != null){	
			
			if (panelp.getNombreAsignaturaSeleccionada().equals("")) {
				 JOptionPane.showMessageDialog(panelp, "Debe seleccionar una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			else{
				for(i=0;i<panelp.getPanelProfesor().getVentana().getSistema().getAsignaturas().size();i++){
					if(panelp.getPanelProfesor().getVentana().getSistema().getAsignaturas().get(i).getNombre().equals(panelp.getNombreAsignaturaSeleccionada())){
						exist = true;
					}
				}
			}
			
			
			if(!exist){
				 JOptionPane.showMessageDialog(panelp, "Esa asignatura no existe", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			
			
		try {
			panelp.getPanelProfesor().getPanelContenido().cambiarCarta("EditarAsig");
		} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
				| IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
			
		}
		
		else if(panela != null){
			
			if(e.getActionCommand().equals("Añadir")){
				try {
					panela.getPanelProf().getPanelContenido().cambiarCarta("Tema");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return;
			}
			if (panela.getNombreTemaSeleccionado().equals("")) {
				 JOptionPane.showMessageDialog(panela, "Debe seleccionar un tema", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			for(i=0;i<panela.getPanelProf().getVentana().getSistema().getAsignatura(panela.getNombreAsignatura()).getTemas().size();i++){
				if(panela.getPanelProf().getVentana().getSistema().getAsignatura(panela.getNombreAsignatura()).getTemas().get(i).getNombre().equals(panela.getNombreTemaSeleccionado())){
					exist = true;
				}
			}
			
			
			if(!exist){
				 JOptionPane.showMessageDialog(panela, "Ese tema no existe", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			if(e.getActionCommand().equals("Editar")){
				try {
					panela.getPanelProf().getPanelContenido().cambiarCarta("EditarTem");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
			else if(e.getActionCommand().equals("Eliminar")){
				panela.getPanelProf().getVentana().getSistema().eliminarTema(panela.getNombreTemaSeleccionado(), panela.getNombreAsignatura());
				try {
					panela.getPanelProf().getPanelContenido().cambiarCarta("EditarAsig");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}else if(panelt != null){
			
			if(panelt.getNombreApunteSeleccionado().equals("") && panelt.getNombreEjercicioSeleccionado().equals("") && panelt.getNombreSubtemaSeleccionado().equals("") && e.getActionCommand().equals("Añadir")){
				
				JFrame ventana = new JFrame("ventana");
						
				// obtener contenedor, asignar layout
				Container contenedor = ventana.getContentPane();
				contenedor.setLayout(new FlowLayout());
				
				// crear componentes
				
				JLabel etiqueta = new JLabel("Introduzca que tipo de elemento desea añadir: ");
				JTextField campo = new JTextField(10);
				JButton boton = new JButton("Haz click");
				// añadir componentes al contenedor
				contenedor.add(etiqueta);
				contenedor.add(campo);
				contenedor.add(boton);
				
				// mostrar ventana
				ventana.setSize(500,100);
				ventana.setLocation(200, 150);
				ventana.setVisible(true);
				
				// asociar acciones a componentes
				boton.addActionListener
				(	new ActionListener() {
				
						public void actionPerformed(ActionEvent e) {
							if(campo.getText().equals("ejercicio") || campo.getText().equals("Ejercicio") ||  campo.getText().equals("Ejercicios") || campo.getText().equals("ejercicio")){
								ventana.setVisible(false);
								try {
									panelt.getPanelProf().getPanelContenido().cambiarCarta("Ejercicio");
								} catch (ClassNotFoundException | InvalidEmailAddressException
										| FailedInternetConnectionException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
							else if(campo.getText().equals("apunte") || campo.getText().equals("Apuntes") ||  campo.getText().equals("Apunte") || campo.getText().equals("apuntes")){
								ventana.setVisible(false);
								try {
									panelt.getPanelProf().getPanelContenido().cambiarCarta("Apuntes");
								} catch (ClassNotFoundException | InvalidEmailAddressException
										| FailedInternetConnectionException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}else if (campo.getText().equals("subtema") || campo.getText().equals("Subtema") ||  campo.getText().equals("Tema") || campo.getText().equals("tema")){
								ventana.setVisible(false);
								try {
									panelt.getPanelProf().getPanelContenido().cambiarCarta("Subtema");
								} catch (ClassNotFoundException | InvalidEmailAddressException
										| FailedInternetConnectionException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}else{
								ventana.setVisible(false);
								 JOptionPane.showMessageDialog(panelt, "Debe introducir el nombre de un elemento para añadir", "Error", JOptionPane.ERROR_MESSAGE);
								
							}
						}
					}
				);
				
			}
			
			
			
			else if (panelt.getNombreApunteSeleccionado().equals("") && panelt.getNombreEjercicioSeleccionado().equals("") && panelt.getNombreSubtemaSeleccionado().equals("")) {
				 JOptionPane.showMessageDialog(panelt, "Debe seleccionar a que quiere acceder del tema", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			else if (panelt.getNombreApunteSeleccionado().equals("varios") || panelt.getNombreEjercicioSeleccionado().equals("varios") || panelt.getNombreSubtemaSeleccionado().equals("varios")){
				 JOptionPane.showMessageDialog(panelt, "Debe seleccionar solo un contenido al que quiera acceder", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			
			
			else if(!panelt.getNombreApunteSeleccionado().equals("") && !panelt.getNombreApunteSeleccionado().equals("varios")){
				 
				 
				for( i=0 ;i < panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(panelt.getNombreTema()).getNApuntes() ; i++){
					if(panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(panelt.getNombreTema()).getApuntes().get(i).getTitulo().equals(panelt.getNombreApunteSeleccionado())){
						exist = true;
					}
				}
				
				if(!exist){
					JOptionPane.showMessageDialog(panelt, "Lo que ha seleccionado no existe", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(e.getActionCommand().equals("Editar")){
					try {
						panelt.getPanelProf().getPanelContenido().cambiarCarta("EditarAp");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				else if(e.getActionCommand().equals("Eliminar")){
					
					panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(panelt.getNombreTema()).getApunte(panelt.getNombreApunteSeleccionado()).setVisible(false);
					try {
						panelt.getPanelProf().getPanelContenido().cambiarCarta("EditarTem");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
			
			else if(!panelt.getNombreSubtemaSeleccionado().equals("") && !panelt.getNombreSubtemaSeleccionado().equals("varios")){
				
				for( i=0 ;i < panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(panelt.getNombreTema()).getNTemas() ; i++){
					
					if(panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(panelt.getNombreTema()).getTemas().get(i).getNombre().equals(panelt.getNombreSubtemaSeleccionado())){
						exist = true;
					}
				}
				
				if(!exist){
					JOptionPane.showMessageDialog(panelt, "Lo que ha seleccionado no existe", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(e.getActionCommand().equals("Editar")){
					try {
						panelt.getPanelProf().getPanelContenido().cambiarCarta("EditarTem");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				else if(e.getActionCommand().equals("Eliminar")){
					
					panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(panelt.getNombreTema()).getTema(panelt.getNombreSubtemaSeleccionado()).setVisibilidad(false);
					try {
						panelt.getPanelProf().getPanelContenido().cambiarCarta("EditarTem");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				
			}
			else if(!panelt.getNombreEjercicioSeleccionado().equals("") && !panelt.getNombreEjercicioSeleccionado().equals("varios")){
				 
				 
				for( i=0 ;i < panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(panelt.getNombreTema()).getNEjercicios() ; i++){
					
					if(panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(panelt.getNombreTema()).getEjercicios().get(i).getNombre().equals(panelt.getNombreEjercicioSeleccionado())){
						exist = true;
					}
				}
				
				if(!exist){
					JOptionPane.showMessageDialog(panelt, "Lo que ha seleccionado no existe", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(e.getActionCommand().equals("Editar")){
					try {
						
						panelt.getPanelProf().getPanelContenido().cambiarCarta("EditarEj");
					
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						
						
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				else if(e.getActionCommand().equals("Eliminar")){
					
					panelt.getPanelProf().getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(panelt.getNombreTema()).getEjercicio(panelt.getNombreEjercicioSeleccionado()).setVisible(false);
					
					try {
						panelt.getPanelProf().getPanelContenido().cambiarCarta("EditarTem");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
			
			
		}
		else if(panelap != null){
			if(e.getActionCommand().equals("Guardar")){
				try {
					 JOptionPane.showMessageDialog(panelap, "Se ha editado correctamente los apuntes", "Guardar", JOptionPane.INFORMATION_MESSAGE);
					 
					panelap.getPanelProf().getPanelContenido().cambiarCarta("GuardarAp");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
