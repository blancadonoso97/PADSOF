package InterfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Clase para definir el panel de inicio de sesion
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelInicioSesion extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelInicioSesion() {

		JLabel nombre = new JLabel("Nombre");
		final JTextField campo = new JTextField(20);
	
		JLabel contrasena = new JLabel("Contraseña");
		JPasswordField password = new JPasswordField(15);
		
		JButton boton = new JButton("Iniciar sesion");

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, campo.getText());
			}
		});

		this.add(nombre);
		this.add(campo);
		this.add(contrasena);
		this.add(password);
		this.add(boton);

	}

}
