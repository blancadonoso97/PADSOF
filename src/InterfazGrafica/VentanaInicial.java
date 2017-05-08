package InterfazGrafica;

import java.awt.CardLayout;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controladores.ControladorInicioSesion;
import eCourses.Sistema;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

import javax.swing.UIManager;
import java.awt.Color;

/**
 * Clase para definir la ventana principal del programa
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class VentanaInicial extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private Sistema sistema;
	
	private static CardLayout cartas = new CardLayout();
	
	private static Container contenedor;
	private JPanel panelinicio;
	private PanelAlumno panelalumno;
	private PanelProfesor panelprofesor;
	
	/**
	 * Constructor de la clase VentanaInicial
	 * @param sist Sistema de la aplicacion
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InvalidEmailAddressException
	 * @throws FailedInternetConnectionException
	 */
	public VentanaInicial(Sistema sist) throws IOException, ClassNotFoundException, InvalidEmailAddressException, FailedInternetConnectionException{
		
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		
		this.sistema = sist;
		
		getContentPane().setLayout(cartas);

		VentanaInicial.contenedor = this.getContentPane();
		
		contenedor.setLayout(cartas);
		
		// Panel de inicio de sesion
		this.panelinicio = new PanelInicioSesion(this);
		
		// Panel alumno
		this.panelalumno = new PanelAlumno(this);
		
		// Panel profesor
		this.panelprofesor = new PanelProfesor(this);
		
		// Anadir paneles
		cartas.addLayoutComponent(panelinicio, "Inicio");
		cartas.addLayoutComponent(panelalumno, "Alumno");
		cartas.addLayoutComponent(panelprofesor, "Profesor");
		
		contenedor.add(panelinicio);
		contenedor.add(panelalumno);
		contenedor.add(panelprofesor);

		// Muestra inicialmente el primer panel
		cartas.show(contenedor, "Inicio");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		this.setSize(1039,707);
		this.setResizable(false);
	
		this.setVisible(true);
	
		// Anade el controlador para el boton de inicio
		ControladorInicioSesion controlador = new ControladorInicioSesion(this,(PanelInicioSesion) panelinicio);
		
		// Configurar el panel con el controlador
		((PanelInicioSesion) panelinicio).setControlador(controlador);
		
	}
	
	/**
	 * Permite cambiar entre paneles
	 * @param nombre Nombre del panel al que se quiere cambiar
	 * @throws IOException 
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 * @throws ClassNotFoundException 
	 */
	public void cambiarCarta(String nombre) throws ClassNotFoundException, InvalidEmailAddressException, FailedInternetConnectionException, IOException{
		
		if(nombre.equals("Inicio")){
			cartas.show(contenedor, "Inicio");
		}else if(nombre.equals("Alumno")){
			this.panelalumno.getPanelHerramientas().actualizarestado();
			this.panelalumno.getPanelContenido().getPanelPrincipal().actualizarAsignaturas();
			cartas.show(contenedor, "Alumno");
		}else if(nombre.equals("Profesor")){
			cartas.show(contenedor, "Profesor");
		}
		
	}
	
	/**
	 * Obtiene el sistema asociado a la ventana
	 * @return sistema
	 */
	public Sistema getSistema(){
		return sistema;
	}
	
	/**
	 * Obtiene el panel del profesor
	 * @return panelprofesor
	 */
	public PanelProfesor getPanelProfesor(){
		return panelprofesor;
	}
	
	/**
	 * Obtiene el panel del alumno
	 * @return panelalumno
	 */
	public PanelAlumno getPanelAlumno(){
		return panelalumno;
	}
	

}
