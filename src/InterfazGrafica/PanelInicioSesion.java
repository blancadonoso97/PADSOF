package InterfazGrafica;

import java.awt.event.ActionListener;
import java.io.IOException;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.SystemColor;

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
	
	/**
	 * Constructor de la clase PanelInicioSesion
	 * @param vent Ventana que contiene el panel
	 * @throws IOException
	 */
	public PanelInicioSesion(VentanaInicial vent) throws IOException {
		setBorder(new LineBorder(SystemColor.activeCaption, 5));
		
		setForeground(UIManager.getColor("PasswordField.background"));
		setBackground(UIManager.getColor("Checkbox.select"));

		this.ventana = vent;
		
		SpringLayout layout = new SpringLayout();

		this.setLayout(layout);
		
		
		
		this.nombre = new JLabel("Id/Email:");
		nombre.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		this.id = new JTextField(30);
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setFont(new Font("Dialog", Font.ITALIC, 14));
		layout.putConstraint(SpringLayout.NORTH, nombre, -1, SpringLayout.NORTH, id);
		layout.putConstraint(SpringLayout.EAST, nombre, -10, SpringLayout.WEST, id);
		
		this.contrasena = new JLabel("Contraseña:");
		layout.putConstraint(SpringLayout.EAST, contrasena, 0, SpringLayout.EAST, nombre);
		contrasena.setFont(new Font("Nimbus Sans L", Font.BOLD, 16));
		this.password = new JPasswordField(30);
		password.setToolTipText("");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Dialog", Font.ITALIC, 14));
		layout.putConstraint(SpringLayout.NORTH, contrasena, -17, SpringLayout.NORTH, password);
		layout.putConstraint(SpringLayout.NORTH, password, 43, SpringLayout.SOUTH, id);
		layout.putConstraint(SpringLayout.WEST, password, 0, SpringLayout.WEST, id);

		this.boton = new JButton("Iniciar sesion");
		layout.putConstraint(SpringLayout.NORTH, boton, 47, SpringLayout.SOUTH, password);
		layout.putConstraint(SpringLayout.EAST, boton, -456, SpringLayout.EAST, this);
		
		// Anadir los componentes al panel
		this.add(nombre);
		this.add(id);
		this.add(contrasena);
		this.add(password);
		this.add(boton);

		layout.putConstraint(SpringLayout.VERTICAL_CENTER, id, 0, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, id, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, nombre, 0, SpringLayout.VERTICAL_CENTER, id);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, contrasena, 0, SpringLayout.VERTICAL_CENTER, password);
		
		JLabel lblEcourses = DefaultComponentFactory.getInstance().createTitle("eCourses");
		layout.putConstraint(SpringLayout.NORTH, lblEcourses, -142, SpringLayout.NORTH, id);
		layout.putConstraint(SpringLayout.WEST, lblEcourses, 218, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, lblEcourses, -38, SpringLayout.NORTH, nombre);
		layout.putConstraint(SpringLayout.EAST, lblEcourses, -217, SpringLayout.EAST, this);
		lblEcourses.setHorizontalAlignment(SwingConstants.CENTER);
		lblEcourses.setForeground(SystemColor.activeCaption);
		lblEcourses.setFont(new Font("Nimbus Sans L", Font.BOLD | Font.ITALIC, 81));
		add(lblEcourses);
				
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
