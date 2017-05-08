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

import InterfazGrafica.PanelAsignatura;
import InterfazGrafica.PanelEditarApunte;
import InterfazGrafica.PanelEditarAsignatura;
import InterfazGrafica.PanelEditarEjercicio;
import InterfazGrafica.PanelEditarTema;
import InterfazGrafica.PanelPrincipal;
import InterfazGrafica.PanelTema;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase que implementa el controlador de los botones para editar el contenido de los paneles
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class ControladorEditarContenido  implements ActionListener{
	
	private PanelPrincipal panelp;
	private PanelEditarAsignatura panela;
	private PanelEditarTema panelt;
	private PanelEditarApunte panelap;
	private PanelAsignatura panelas;
	private PanelTema paneltem;
	private PanelEditarEjercicio paneledej;
	
	/**
	 * Constructor de la clase ControladorEditarContenido
	 * @param pan Panel principal
	 */
	public ControladorEditarContenido(PanelPrincipal pan){
	
		this.panelp = pan;
		
	}
	
	/**
	 * Constructor de la clase ControladorEditarContenido
	 * @param pan Panel de editar una asignatura
	 */
	public ControladorEditarContenido(PanelEditarAsignatura pan){
		
		this.panela = pan;
		
	}

	/**
	 * Constructor de la clase ControladorEditarContenido
	 * @param pan2 Panel de una asignatura
	 */
	public ControladorEditarContenido(PanelAsignatura pan2){
		
		this.panelas = pan2;
		
	}
	
	/**
	 * Constructor de la clase ControladorEditarContenido
	 * @param pan Panel de editar un tema
	 */
	public ControladorEditarContenido(PanelEditarTema pan){
		
		this.panelt = pan;
		
	}
	
	
	/**
	 * Constructor de la clase ControladorEditarContenido
	 * @param pan Panel de un tema
	 */
	public ControladorEditarContenido(PanelTema pan){
		
		this.paneltem = pan;
		
	}
	
	/**
	 * Constructor de la clase ControladorEditarContenido
	 * @param pan Panel de editar un apunte
	 */
	public ControladorEditarContenido(PanelEditarApunte pan){
		
		this.panelap = pan;
		
	}
	
	public ControladorEditarContenido(PanelEditarEjercicio pan){
		
		this.paneledej = pan;
		
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
			
			
		}else if(panelas !=null ){
			if (panelas.getNombreTemaSeleccionado().equals("")) {
				 JOptionPane.showMessageDialog(panelas, "Debe seleccionar un tema", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			for(i=0;i<panelas.getPanelProf().getVentana().getSistema().getAsignatura(panelas.getNombreAsignatura()).getTemas().size();i++){
				if(panelas.getPanelProf().getVentana().getSistema().getAsignatura(panelas.getNombreAsignatura()).getTemas().get(i).getNombre().equals(panelas.getNombreTemaSeleccionado())){
					exist = true;
				}
			}
			
			
			if(!exist){
				 JOptionPane.showMessageDialog(panelas, "Ese tema no existe", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			if(e.getActionCommand().equals("Editar")){
				try {
					
					panelas.getPanelProf().getPanelContenido().cambiarCarta("EditarTem");
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
			
			else if(e.getActionCommand().equals("Guardar")){
				try {
					 JOptionPane.showMessageDialog(panelt, "Se ha editado correctamente el tema", "Guardar", JOptionPane.INFORMATION_MESSAGE);
					 
					 panelt.getPanelProf().getPanelContenido().cambiarCarta("GuardarTem");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
			
			
		}else if(paneltem != null){
		
			
			 if (paneltem.getNombreApunteSeleccionado().equals("") && paneltem.getNombreEjercicioSeleccionado().equals("") && paneltem.getNombreSubtemaSeleccionado().equals("")) {
				 JOptionPane.showMessageDialog(paneltem, "Debe seleccionar a que quiere acceder del tema", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			else if (paneltem.getNombreApunteSeleccionado().equals("varios") || paneltem.getNombreEjercicioSeleccionado().equals("varios") || paneltem.getNombreSubtemaSeleccionado().equals("varios")){
				 JOptionPane.showMessageDialog(paneltem, "Debe seleccionar solo un contenido al que quiera acceder", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			
			
			else if(!paneltem.getNombreApunteSeleccionado().equals("") && !paneltem.getNombreApunteSeleccionado().equals("varios")){
				 
				 
				for( i=0 ;i < paneltem.getPanelProf().getVentana().getSistema().getAsignatura(paneltem.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(paneltem.getNombreTema()).getNApuntes() ; i++){
					if(paneltem.getPanelProf().getVentana().getSistema().getAsignatura(paneltem.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(paneltem.getNombreTema()).getApuntes().get(i).getTitulo().equals(paneltem.getNombreApunteSeleccionado())){
						exist = true;
					}
				}
				
				if(!exist){
					JOptionPane.showMessageDialog(paneltem, "Lo que ha seleccionado no existe", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(e.getActionCommand().equals("Editar")){
					try {
						paneltem.getPanelProf().getPanelContenido().cambiarCarta("EditarAp");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				
				
			}
			
			else if(!paneltem.getNombreSubtemaSeleccionado().equals("") && !paneltem.getNombreSubtemaSeleccionado().equals("varios")){
				
				for( i=0 ;i < paneltem.getPanelProf().getVentana().getSistema().getAsignatura(paneltem.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(paneltem.getNombreTema()).getNTemas() ; i++){
					
					if(paneltem.getPanelProf().getVentana().getSistema().getAsignatura(paneltem.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(paneltem.getNombreTema()).getTemas().get(i).getNombre().equals(paneltem.getNombreSubtemaSeleccionado())){
						exist = true;
					}
				}
				
				if(!exist){
					JOptionPane.showMessageDialog(paneltem, "Lo que ha seleccionado no existe", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(e.getActionCommand().equals("Editar")){
					try {
						paneltem.getPanelProf().getPanelContenido().cambiarCarta("EditarTem");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				
				
			}
			else if(!paneltem.getNombreEjercicioSeleccionado().equals("") && !paneltem.getNombreEjercicioSeleccionado().equals("varios")){
				 
				 
				for( i=0 ;i < paneltem.getPanelProf().getVentana().getSistema().getAsignatura(paneltem.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(paneltem.getNombreTema()).getNEjercicios() ; i++){
					
					if(paneltem.getPanelProf().getVentana().getSistema().getAsignatura(paneltem.getPanelProf().getPanelContenido().getPanelEdAsig().getNombreAsignatura()).getTema(paneltem.getNombreTema()).getEjercicios().get(i).getNombre().equals(paneltem.getNombreEjercicioSeleccionado())){
						exist = true;
					}
				}
				
				if(!exist){
					JOptionPane.showMessageDialog(paneltem, "Lo que ha seleccionado no existe", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(e.getActionCommand().equals("Editar")){
					try {
						
						paneltem.getPanelProf().getPanelContenido().cambiarCarta("EditarEj");
					
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
		}else if(paneledej != null){
			if(e.getActionCommand().equals("Crear pregunta multiple")){
				
				paneledej.getPanelProfesor().getPanelContenido().getPanelCrearEjercicio().setEjercicio(paneledej.getEjercicio());
				
				try {
					this.paneledej.getPanelProfesor().getPanelContenido().cambiarCarta("Multiple");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else if(e.getActionCommand().equals("Crear pregunta redactar")){
				
				paneledej.getPanelProfesor().getPanelContenido().getPanelCrearEjercicio().setEjercicio(paneledej.getEjercicio());
				
				try {
					this.paneledej.getPanelProfesor().getPanelContenido().cambiarCarta("Redactar");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}else if(e.getActionCommand().equals("Crear pregunta test")){

				paneledej.getPanelProfesor().getPanelContenido().getPanelCrearEjercicio().setEjercicio(paneledej.getEjercicio());
				
				try {
					this.paneledej.getPanelProfesor().getPanelContenido().cambiarCarta("Test");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}else if(e.getActionCommand().equals("Borrar pregunta test")){
				
				
				
				
			}else if(e.getActionCommand().equals("Borrar pregunta redactar")){
				
				
				
				
			}else if(e.getActionCommand().equals("Borrar pregunta multiple")){
				
				
				
				
			}
		}
	}
}
