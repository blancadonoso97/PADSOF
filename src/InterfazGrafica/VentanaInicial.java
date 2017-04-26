package InterfazGrafica;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controladores.ControladorInicioSesion;
import eCourses.Sistema;

/**
 * Clase para definir la ventana principal del programa
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class VentanaInicial extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private Sistema sistema;
	
	private static CardLayout cartas = new CardLayout();
	
	private static Container contenedor;

	public VentanaInicial(Sistema sist){
		
		this.sistema = sist;
		
		this.setLayout(cartas);

		VentanaInicial.contenedor = this.getContentPane();
		
		contenedor.setLayout(cartas);
		
		// Panel de inicio de sesion
		JPanel panelinicio = new PanelInicioSesion();
		
		// Panel alumno
		JPanel panelalumno = new PanelAlumno();
		
		// Panel profesor
		JPanel panelprofesor = new PanelProfesor();
		
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
		
		// Escala la ventana al tamaño maximo del monitor
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());  
		this.setSize(xSize,ySize);
	
		this.setVisible(true);
	
		// Anade el controlador para el boton de inicio
		ControladorInicioSesion controlador = new ControladorInicioSesion(this,(PanelInicioSesion) panelinicio);
		
		// Configurar el panel con el controlador
		((PanelInicioSesion) panelinicio).setControlador(controlador);
		
	}
	
	/**
	 * Permite cambiar entre paneles
	 * @param nombre Nombre del panel al que se quiere cambiar
	 */
	public void cambiarCarta(String nombre){
		
		if(nombre.equals("Inicio")){
			cartas.show(contenedor, "Inicio");
		}else if(nombre.equals("Alumno")){
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
	

}
