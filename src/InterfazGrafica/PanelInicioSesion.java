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
import javax.swing.UIManager;

/**
 * Clase para definir el panel de inicio de sesion
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
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
		
		setForeground(UIManager.getColor("PasswordField.background"));
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));

		this.ventana = vent;
		
		SpringLayout layout = new SpringLayout();

		this.setLayout(layout);
		
		ImageIcon icono = new ImageIcon("eCourses.png", "Logo");
		this.imagen = new JLabel(icono);
		
		layout.putConstraint(SpringLayout.WEST, imagen, 174, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, imagen, -169, SpringLayout.EAST, this);
		imagen.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		
		this.nombre = new JLabel("Id/Email:");
		this.id = new JTextField(30);
		layout.putConstraint(SpringLayout.NORTH, nombre, 1, SpringLayout.NORTH, id);
		layout.putConstraint(SpringLayout.EAST, nombre, -40, SpringLayout.WEST, id);
		layout.putConstraint(SpringLayout.NORTH, imagen, -232, SpringLayout.NORTH, id);
		layout.putConstraint(SpringLayout.SOUTH, imagen, -85, SpringLayout.NORTH, id);
		
		this.contrasena = new JLabel("Contraseña:");
		this.password = new JPasswordField(30);
		layout.putConstraint(SpringLayout.NORTH, contrasena, -35, SpringLayout.NORTH, password);
		layout.putConstraint(SpringLayout.SOUTH, contrasena, 33, SpringLayout.NORTH, password);
		layout.putConstraint(SpringLayout.EAST, contrasena, -26, SpringLayout.WEST, password);
		layout.putConstraint(SpringLayout.NORTH, password, 43, SpringLayout.SOUTH, id);
		layout.putConstraint(SpringLayout.WEST, password, 0, SpringLayout.WEST, id);

		this.boton = new JButton("Iniciar sesion");
		layout.putConstraint(SpringLayout.NORTH, boton, 90, SpringLayout.SOUTH, password);
		layout.putConstraint(SpringLayout.WEST, boton, 452, SpringLayout.WEST, this);
		
		// Anadir los componentes al panel
		this.add(nombre);
		this.add(id);
		this.add(contrasena);
		this.add(password);
		this.add(boton);
		this.add(imagen);

		layout.putConstraint(SpringLayout.VERTICAL_CENTER, id, 0, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, id, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, nombre, 0, SpringLayout.VERTICAL_CENTER, id);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, contrasena, 0, SpringLayout.VERTICAL_CENTER, password);
				
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
