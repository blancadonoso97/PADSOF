package InterfazGrafica;

import java.awt.Dimension;
import java.awt.event.ActionListener;

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
	
	private JButton boton;
	private JLabel contrasena; 
	private JLabel nombre; 
	private JTextField id;
	private JPasswordField password;
	
	
	public PanelInicioSesion() {

		SpringLayout layout = new SpringLayout();

		this.setLayout(layout);

		this.nombre = new JLabel("Nombre/Email:");
		this.id = new JTextField(15);

		this.contrasena = new JLabel("Contraseña:");
		this.password = new JPasswordField(15);

		this.boton = new JButton("Iniciar sesion");
		
		// Label nombre
		layout.putConstraint(SpringLayout.WEST, nombre, 10, SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH, nombre, 10, SpringLayout.NORTH, this);
		
		// Label contrasena
		layout.putConstraint(SpringLayout.WEST, contrasena, 10, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, contrasena, 20, SpringLayout.SOUTH, nombre);
		
		layout.putConstraint(SpringLayout.EAST, contrasena, 10, SpringLayout.WEST, password);
		
		// Campo id
		layout.putConstraint(SpringLayout.WEST, id, 10, SpringLayout.EAST, nombre);

		layout.putConstraint(SpringLayout.NORTH, id, 10, SpringLayout.NORTH, this);

		// Campo password
		layout.putConstraint(SpringLayout.WEST, password, 0, SpringLayout.WEST, nombre);

		layout.putConstraint(SpringLayout.WEST, password, 0, SpringLayout.WEST, id);

		layout.putConstraint(SpringLayout.NORTH, password, 10, SpringLayout.SOUTH, id);
		
		// Boton Inicar Sesion
		layout.putConstraint(SpringLayout.NORTH, boton, 10, SpringLayout.SOUTH, password);
		
		layout.putConstraint(SpringLayout.WEST, boton, 0, SpringLayout.WEST, id);

		this.setPreferredSize(new Dimension(250, 50));
		this.setVisible(true);

		this.add(nombre);
		this.add(id);
		this.add(contrasena);
		this.add(password);
		this.add(boton);

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
	  * @return Nombre/email
	  */
	 public String getId() {
		 return id.getText();
	 }
	 
	 /**
	  * Obtiene
	  * @return password
	  */
	 public String getPass(){
		 return String.valueOf(password.getPassword());
	 }
	 

}
