package InterfazGrafica;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * Clase para definir el panel de inicio de sesion
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelInicioSesion extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private VentanaInicial ventana;
	
	private JButton boton;
	private JLabel contrasena; 
	private JLabel nombre; 
	private JTextField id;
	private JPasswordField password;
	private JLabel imagen;
	
	/**
	 * Constructor de la clase PanelInicioSesion
	 * @param vent Ventana que contiene el panel
	 * @throws IOException
	 */
	public PanelInicioSesion(VentanaInicial vent) throws IOException {

		this.ventana = vent;
		
		SpringLayout layout = new SpringLayout();

		this.setLayout(layout);
		
		ImageIcon icono = new ImageIcon("eCourses.png", "Logo");
		this.imagen = new JLabel(icono);
		
		
		this.nombre = new JLabel("Id/Email:");
		this.id = new JTextField(15);

		this.contrasena = new JLabel("Contraseña:");
		this.password = new JPasswordField(15);

		this.boton = new JButton("Iniciar sesion");
		
		// Anadir los componentes al panel
		this.add(nombre);
		this.add(id);
		this.add(contrasena);
		this.add(password);
		this.add(boton);
		this.add(imagen);
				
		// Reorganizar la posicion de los componentes
		
		// Campo id
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, id, 0, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, id, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		// Campo password
		layout.putConstraint(SpringLayout.NORTH, password, 10, SpringLayout.SOUTH, id);
		layout.putConstraint(SpringLayout.WEST, password, 20, SpringLayout.EAST, nombre);

		// Label nombre
		layout.putConstraint(SpringLayout.EAST, nombre, -20, SpringLayout.WEST, id);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, nombre, 0, SpringLayout.VERTICAL_CENTER, id);
		
		// Label contrasena
		layout.putConstraint(SpringLayout.NORTH, contrasena, 10, SpringLayout.SOUTH, nombre);
		layout.putConstraint(SpringLayout.EAST, contrasena, -20, SpringLayout.WEST, password);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, contrasena, 0, SpringLayout.VERTICAL_CENTER, password);

		// Boton Iniciar Sesion
		layout.putConstraint(SpringLayout.NORTH, boton, 10, SpringLayout.SOUTH, password);
		layout.putConstraint(SpringLayout.WEST, boton, 50, SpringLayout.EAST, nombre);
		
		// Imagen
		layout.putConstraint(SpringLayout.SOUTH, imagen, -30, SpringLayout.NORTH, id);
		layout.putConstraint(SpringLayout.WEST, imagen, 10, SpringLayout.EAST, nombre);
				
		this.setVisible(true);

		

	}
	
	
	/**
	 * Anade un controlador al boton
	 * @param c Controlador a anadir
	 */
	 public void setControlador(ActionListener c) {
		 boton.addActionListener(c);
	 }
	 
	 /**
	  * Obtiene el id introducido por el usuario
	  * @return Id o email
	  */
	 public String getId() {
		 return id.getText();
	 }
	 
	 /**
	  * Obtiene la contrasena introducida
	  * @return passText
	  */
	 public String getPass(){
		 
		 String passText = new String(password.getPassword());
		 
		 return passText;
	 }	 
	 
	 /**
	  * Devuelve la ventana que contiene el panel
	  * @return ventana
	  */
	 public VentanaInicial getVentana(){
		 
		 return ventana;
		 
	 }

}
