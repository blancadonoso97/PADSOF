package InterfazGrafica;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase para definir la ventana de inicio de sesion (log in)
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class InicioSesion extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main (String args[]){
		
		JFrame ventana = new JFrame("Bienvenido a eCourses");

		Container contenedor = ventana.getContentPane();
		
		contenedor.setLayout(new FlowLayout());
		
		JPanel panel = new PanelInicioSesion();
		
		contenedor.add(panel);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(900,700);
		ventana.setVisible(true);
		
	}
	

}