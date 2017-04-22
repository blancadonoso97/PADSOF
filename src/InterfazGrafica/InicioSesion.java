package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		ventana.setLayout(new BorderLayout());

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
		ventana.setSize(500, 500);
		ventana.setVisible(true);
		
	}
	

}
