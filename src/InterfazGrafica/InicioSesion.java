package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controladores.ControladorInicioSesion;
import eCourses.Sistema;

/**
 * Clase para definir la ventana de inicio de sesion (log in)
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class InicioSesion extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main (String args[]) throws ClassNotFoundException, IOException{
		
		JFrame ventana = new JFrame("Bienvenido a eCourses");
		
		ventana.setLayout(new BorderLayout());
		
		Sistema sistema = new Sistema("archivoProf.txt", "archivoAlum.txt");

		Container contenedor = ventana.getContentPane();
		
		contenedor.setLayout(new BorderLayout());
		
		JPanel panel = new PanelInicioSesion();
		
		contenedor.add(panel, BorderLayout.CENTER);
		
		ImageIcon image = new ImageIcon("eCourses.png");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		JPanel panelImage = new JPanel(new BorderLayout());
		panelImage.add(label, BorderLayout.CENTER );
		
		contenedor.add(panelImage, BorderLayout.NORTH);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Escala la ventana al tamaño maximo del monitor
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());  
		ventana.setSize(xSize,ySize);
	
		ventana.setVisible(true);
		
		// Anade el controlador para el boton de inicio
		ControladorInicioSesion controlador = new ControladorInicioSesion(sistema, (PanelInicioSesion) panel);
		
		// Configurar el panel con el controlador
		((PanelInicioSesion) panel).setControlador(controlador);
		
	}	

}
