package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import InterfazGrafica.PanelAsignatura;
import InterfazGrafica.PanelPrincipal;
import InterfazGrafica.PanelTema;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase que implementa el controlador de los botones para acceder a un
 * contenido de los distintos paneles
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
 *
 */
public class ControladorAccederContenido implements ActionListener {

	private PanelPrincipal panelp;
	private PanelAsignatura panela;
	private PanelTema panelt;

	/**
	 * Constructor de la clase ControladorAccederContenido
	 * @param pan Panel principal
	 */
	public ControladorAccederContenido(PanelPrincipal pan) {

		this.panelp = pan;

	}

	/**
	 * Constructor de la clase ControladorAccederContenido
	 * @param pan Panel de una asignatura
	 */
	public ControladorAccederContenido(PanelAsignatura pan) {

		this.panela = pan;

	}

	/**
	 * Constructor de la clase ControladorAccederContenido
	 * @param pan Panel de un tema
	 */
	public ControladorAccederContenido(PanelTema pan) {

		this.panelt = pan;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int i;
		boolean exist = false;

		if (panelp != null) {

			if (panelp.getNombreAsignaturaSeleccionada().equals("")) {
				JOptionPane.showMessageDialog(panelp, "Debe seleccionar una asignatura", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (panelp.getPanelAlumno() != null) {

				for (i = 0; i < panelp.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignaturas()
						.size(); i++) {
					if (panelp.getPanelAlumno().getVentana().getSistema().getAlumnoLog().getAsignaturas().get(i)
							.getNombre().equals(panelp.getNombreAsignaturaSeleccionada())) {
						exist = true;
					}
				}

			} else {
				for (i = 0; i < panelp.getPanelProfesor().getVentana().getSistema().getAsignaturas().size(); i++) {
					if (panelp.getPanelProfesor().getVentana().getSistema().getAsignaturas().get(i).getNombre()
							.equals(panelp.getNombreAsignaturaSeleccionada())) {
						exist = true;
					}
				}
			}

			if (!exist) {
				JOptionPane.showMessageDialog(panelp, "Esa asignatura no existe", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (panelp.getPanelProfesor() != null) {
				try {
					panelp.getPanelProfesor().getPanelContenido().cambiarCarta("AccederAsig");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				try {
					panelp.getPanelAlumno().getPanelContenido().cambiarCarta("AccederAsig");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		else if (panela != null) {

			if (panela.getNombreTemaSeleccionado().equals("")) {
				JOptionPane.showMessageDialog(panela, "Debe seleccionar una asignatura", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (panela.getPanelAlumno() != null) {

				for (i = 0; i < panela.getPanelAlumno().getVentana().getSistema().getAlumnoLog()
						.getAsignatura(panela.getNombreAsignatura()).getTemas().size(); i++) {
					if (panela.getPanelAlumno().getVentana().getSistema().getAlumnoLog()
							.getAsignatura(panela.getNombreAsignatura()).getTemas().get(i).getNombre()
							.equals(panela.getNombreTemaSeleccionado())) {
						exist = true;
					}
				}

			} else {
				for (i = 0; i < panela.getPanelProf().getVentana().getSistema()
						.getAsignatura(panela.getNombreAsignatura()).getTemas().size(); i++) {
					if (panela.getPanelProf().getVentana().getSistema().getAsignatura(panela.getNombreAsignatura())
							.getTemas().get(i).getNombre().equals(panela.getNombreTemaSeleccionado())) {
						exist = true;
					}
				}
			}

			if (!exist) {
				JOptionPane.showMessageDialog(panela, "Ese tema no existe", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (panela.getPanelProf() != null) {
				try {
					panela.getPanelProf().getPanelContenido().cambiarCarta("AccederTem");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				try {
					panela.getPanelAlumno().getPanelContenido().cambiarCarta("AccederTem");
				} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
						| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		else if (panelt != null) {

			if (panelt.getNombreApunteSeleccionado().equals("") && panelt.getNombreEjercicioSeleccionado().equals("")
					&& panelt.getNombreSubtemaSeleccionado().equals("")) {
				JOptionPane.showMessageDialog(panelt, "Debe seleccionar a que quiere acceder del tema", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (panelt.getNombreApunteSeleccionado().equals("varios")
					|| panelt.getNombreEjercicioSeleccionado().equals("varios")
					|| panelt.getNombreSubtemaSeleccionado().equals("varios")) {
				JOptionPane.showMessageDialog(panelt, "Debe seleccionar solo un contenido al que quiera acceder",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!panelt.getNombreApunteSeleccionado().equals("")
					&& !panelt.getNombreApunteSeleccionado().equals("varios")) {

				if (panelt.getPanelAlumno() != null) {

					for (i = 0; i < panelt.getPanelAlumno().getVentana().getSistema()
							.getAlumnoLog().getAsignatura(panelt.getPanelAlumno().getPanelContenido()
									.getPanelAsignatura().getNombreAsignatura())
							.getTema(panelt.getNombreTema()).getNApuntes(); i++) {

						if (panelt.getPanelAlumno().getVentana().getSistema().getAlumnoLog()
								.getAsignatura(panelt.getPanelAlumno().getPanelContenido().getPanelAsignatura()
										.getNombreAsignatura())
								.getTema(panelt.getNombreTema()).getApuntes().get(i).getTitulo()
								.equals(panelt.getNombreApunteSeleccionado())) {
							exist = true;
						}
					}

				} else {
					for (i = 0; i < panelt.getPanelProf()
							.getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido()
									.getPanelAsignatura().getNombreAsignatura())
							.getTema(panelt.getNombreTema()).getNApuntes(); i++) {
						if (panelt.getPanelProf().getVentana().getSistema()
								.getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelAsignatura()
										.getNombreAsignatura())
								.getTema(panelt.getNombreTema()).getApuntes().get(i).getTitulo()
								.equals(panelt.getNombreApunteSeleccionado())) {
							exist = true;
						}
					}
				}

				if (!exist) {
					JOptionPane.showMessageDialog(panelt, "Lo que ha seleccionado no existe", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (panelt.getPanelProf() != null) {
					try {
						panelt.getPanelProf().getPanelContenido().cambiarCarta("AccederApunte");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {
						panelt.getPanelAlumno().getPanelContenido().cambiarCarta("AccederApunte");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

			else if (!panelt.getNombreSubtemaSeleccionado().equals("")
					&& !panelt.getNombreSubtemaSeleccionado().equals("varios")) {

				if (panelt.getPanelAlumno() != null) {

					for (i = 0; i < panelt.getPanelAlumno().getVentana().getSistema()
							.getAlumnoLog().getAsignatura(panelt.getPanelAlumno().getPanelContenido()
									.getPanelAsignatura().getNombreAsignatura())
							.getTema(panelt.getNombreTema()).getTemas().size(); i++) {

						if (panelt.getPanelAlumno().getVentana().getSistema().getAlumnoLog()
								.getAsignatura(panelt.getPanelAlumno().getPanelContenido().getPanelAsignatura()
										.getNombreAsignatura())
								.getTema(panelt.getNombreTema()).getTemas().get(i).getNombre()
								.equals(panelt.getNombreSubtemaSeleccionado())) {
							exist = true;
						}
					}

				} else {
					for (i = 0; i < panelt.getPanelProf()
							.getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido()
									.getPanelAsignatura().getNombreAsignatura())
							.getTema(panelt.getNombreTema()).getTemas().size(); i++) {
						if (panelt.getPanelProf().getVentana().getSistema()
								.getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelAsignatura()
										.getNombreAsignatura())
								.getTema(panelt.getNombreTema()).getTemas().get(i).getNombre()
								.equals(panelt.getNombreSubtemaSeleccionado())) {
							exist = true;
						}
					}
				}

				if (!exist) {
					JOptionPane.showMessageDialog(panelt, "Lo que ha seleccionado no existe", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (panelt.getPanelProf() != null) {
					try {
						panelt.getPanelProf().getPanelContenido().cambiarCarta("AccederTem");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {
						panelt.getPanelAlumno().getPanelContenido().cambiarCarta("AccederTem");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

			else if (!panelt.getNombreEjercicioSeleccionado().equals("")
					&& !panelt.getNombreEjercicioSeleccionado().equals("varios")) {

				if (panelt.getPanelAlumno() != null) {

					for (i = 0; i < panelt.getPanelAlumno().getVentana().getSistema()
							.getAlumnoLog().getAsignatura(panelt.getPanelAlumno().getPanelContenido()
									.getPanelAsignatura().getNombreAsignatura())
							.getTema(panelt.getNombreTema()).getNEjercicios(); i++) {

						if (panelt.getPanelAlumno().getVentana().getSistema().getAlumnoLog()
								.getAsignatura(panelt.getPanelAlumno().getPanelContenido().getPanelAsignatura()
										.getNombreAsignatura())
								.getTema(panelt.getNombreTema()).getEjercicios().get(i).getNombre()
								.equals(panelt.getNombreEjercicioSeleccionado())) {
							exist = true;
						}
					}

				} else {
					for (i = 0; i < panelt.getPanelProf()
							.getVentana().getSistema().getAsignatura(panelt.getPanelProf().getPanelContenido()
									.getPanelAsignatura().getNombreAsignatura())
							.getTema(panelt.getNombreTema()).getNEjercicios(); i++) {
						if (panelt.getPanelProf().getVentana().getSistema()
								.getAsignatura(panelt.getPanelProf().getPanelContenido().getPanelAsignatura()
										.getNombreAsignatura())
								.getTema(panelt.getNombreTema()).getEjercicios().get(i).getNombre()
								.equals(panelt.getNombreEjercicioSeleccionado())) {
							exist = true;
						}
					}
				}

				if (!exist) {
					JOptionPane.showMessageDialog(panelt, "Lo que ha seleccionado no existe", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (panelt.getPanelProf() != null) {
					JOptionPane.showMessageDialog(panelt, "El profesor no puede realizar el ejercicio", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					try {
						panelt.getPanelProf().getPanelContenido().cambiarCarta("AccederEj");
					} catch (ClassNotFoundException | InvalidEmailAddressException | FailedInternetConnectionException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

		}

	}

}
