package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controladores.ControladorInicioSesion;
import eCourses.Sistema;

/**
 * Clase para definir la ventana principal del programa
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class InicioSesion extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private Sistema sistema;
	
	private static JPanel cartas;

	public InicioSesion(Sistema sist){
		
		this.sistema = sist;
		
		cartas = new JPanel(new CardLayout());
		
		this.setLayout(new CardLayout());

		Container contenedor = this.getContentPane();
		
		contenedor.setLayout(new BorderLayout());
		
		// Panel de inicio de sesion
		JPanel panel = new PanelInicioSesion();
		
		contenedor.add(panel, BorderLayout.CENTER);
		
		cartas.add(panel);
		
		// Panel del profesor
		
		// Panel del alumno
		
		ImageIcon image = new ImageIcon("eCourses.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		JPanel panelImage = new JPanel(new BorderLayout());
		panelImage.add(label, BorderLayout.CENTER );
		
		contenedor.add(panelImage, BorderLayout.NORTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Escala la ventana al tamaño maximo del monitor
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());  
		this.setSize(xSize,ySize);
	
		this.setVisible(true);
		
		// Anade el controlador para el boton de inicio
		ControladorInicioSesion controlador = new ControladorInicioSesion(this,(PanelInicioSesion) panel);
		
		// Configurar el panel con el controlador
		((PanelInicioSesion) panel).setControlador(controlador);
		
	}
	
	public void cambiarCarta(){
		
	}
	
	/**
	 * Obtiene el sistema asociado a la ventana
	 * @return sistema
	 */
	public Sistema getSistema(){
		return sistema;
	}
	
	/**
	 * Obtiene el conjunto de cartas (paneles) de la ventana
	 * @return cartas
	 */
	public JPanel getCartas(){
		return cartas;
	}


}
