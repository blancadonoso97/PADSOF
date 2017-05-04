package InterfazGrafica;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 * Clase para definir el panel de contenido dentro del panel de profesor o alumno
 * 
 * @author Miguel Angel Bouzada, Blanca Martinez Donoso
 *
 */
public class PanelContenido extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static CardLayout cartas = new CardLayout();
	
	private PanelProfesor contenedorProf;
	private PanelAlumno contenedorAlum;
	
	/**
	 * Constructor de la clase PanelContenido
	 */
	public PanelContenido(PanelProfesor cont){
		
		this.contenedorProf = cont;
		
		this.setLayout(cartas);
		
		// Panel crear asignatura
		JPanel crearasignatura = new PanelCrearAsignatura(this);
				
		// Panel crear tema
		JPanel creartema = new PanelCrearTema();
		
		// Panel crear subtema
		JPanel crearsubtema = new PanelCrearSubtema();
				
		// Panel crear apuntes
		JPanel crearapuntes = new PanelCrearApuntes();
		
		// Panel crear ejercicio
		JPanel crearejercicio = new PanelCrearEjercicio();
				
		// Anadir paneles
		cartas.addLayoutComponent(crearasignatura, "Asignatura");
		cartas.addLayoutComponent(creartema, "Tema");
		cartas.addLayoutComponent(crearsubtema, "Subtema");
		cartas.addLayoutComponent(crearapuntes, "Apuntes");
		cartas.addLayoutComponent(crearejercicio, "Ejercicio");
		
		
		this.add(crearasignatura);
		this.add(creartema);
		this.add(crearsubtema);
		this.add(crearapuntes);
		this.add(crearejercicio);
		
		
		
	}
	
	/**
	 * Cosntructor de la clase PanelContenido
	 * @param alumno Panel del alumno
	 */
	public PanelContenido(PanelAlumno alumno){
		
		this.contenedorAlum = alumno;
	}
	
	
	/**
	 * Permite cambiar entre paneles
	 * @param nombre Nombre del panel al que se quiere cambiar
	 */
	public void cambiarCarta(String nombre){
		
		if(nombre.equals("Asignatura")){
			cartas.show(this, "Asignatura");
			
		}else if(nombre.equals("Tema")){
			cartas.show(this, "Tema");
			
		}else if(nombre.equals("Subtema")){
			cartas.show(this, "Subtema");
			
		}else if(nombre.equals("Apuntes")){
			cartas.show(this, "Apuntes");
			
		}else if(nombre.equals("Ejercicio")){
			cartas.show(this, "Ejercicio");
			
		}
		
	}
	
	/**
	 * Devuelve el panel contenedor Profesor
	 * @return contenedorProf
	 */
	public PanelProfesor getContenedorProf(){
		return contenedorProf;
	}
	
	/**
	 * Devuelve el panel contenedor Alumno
	 * @return contenedorAlum
	 */
	public PanelAlumno getContenedorAlum(){
		return contenedorAlum;
	}
	
	
	
	

}
