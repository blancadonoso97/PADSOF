package InterfazGrafica;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.UIManager;

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
	private PanelMatricula solicitarmatricula;
	private PanelCrearAsignatura asig;
	private PanelCrearTema temas;
	private PanelCrearSubtema subtemas;
	private PanelCrearApuntes apuntes;
	private PanelPrincipal paginaprinc;
	private PanelCrearEjercicio ejercicios;	
	private PanelAsignatura panelasig;
	private PanelTema paneltem;
	private PanelApunte panelap;
	private PanelEjercicio panelej;
	private PanelAdministrar paneladmin;
	/**
	 * Constructor de la clase PanelContenido
	 * @wbp.parser.constructor
	 */
	public PanelContenido(PanelProfesor cont){
	
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.contenedorProf = cont;
		
		this.setLayout(cartas);
		
		// Panel crear asignatura
		this.asig = new PanelCrearAsignatura(this);
				
		// Panel crear tema
		this.temas = new PanelCrearTema(this);
		
		// Panel crear subtema
		this.subtemas = new PanelCrearSubtema(this);
				
		// Panel crear apuntes
		this.apuntes = new PanelCrearApuntes(this);
		
		// Panel crear ejercicio
		this.ejercicios = new PanelCrearEjercicio(/*this*/);
		
		// Panel administar
		this.paneladmin = new PanelAdministrar(this);
		
		
		this.paginaprinc = new PanelPrincipal(this);
		
		
		this.panelasig = new PanelAsignatura(this);
		
		this.paneltem = new PanelTema(this);
		
		this.panelap = new PanelApunte(this);
		
		this.panelej = new PanelEjercicio(this);
		
		
		cartas.addLayoutComponent(this.asig, "Asignatura");
		cartas.addLayoutComponent(this.temas, "Tema");
		cartas.addLayoutComponent(this.apuntes, "Apuntes");
		cartas.addLayoutComponent(this.subtemas, "Subtema");
		cartas.addLayoutComponent(this.ejercicios, "Ejercicios");
		cartas.addLayoutComponent(this.paginaprinc, "Principal");
		cartas.addLayoutComponent(this.panelasig, "AccederAsig");
		cartas.addLayoutComponent(this.paneltem, "AccederTem");
		cartas.addLayoutComponent(this.paneltem, "AccederApunte");
		cartas.addLayoutComponent(this.panelej, "AccederEj");
		cartas.addLayoutComponent(this.paneladmin, "Administrar");

	
		this.paginaprinc.actualizarAsignaturas();
		this.add(this.paginaprinc);
		
		
	}
	
	/**
	 * Cosntructor de la clase PanelContenido
	 * @param alumno Panel del alumno
	 */
	public PanelContenido(PanelAlumno alumno){
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		this.contenedorAlum = alumno;
		
		this.setLayout(cartas);
		
		// Panel crear solicitud matricula
		this.solicitarmatricula = new PanelMatricula(this.contenedorAlum);
		
		this.paginaprinc = new PanelPrincipal(this);
		
		this.panelasig = new PanelAsignatura(this);
		
		this.paneltem = new PanelTema(this);
		
		this.panelap = new PanelApunte(this);
		
		this.panelej = new PanelEjercicio(this);
		
		
		// Anadir panelpaneltemes
		cartas.addLayoutComponent(this.solicitarmatricula, "Matricula");
		cartas.addLayoutComponent(this.paginaprinc, "Principal");
		cartas.addLayoutComponent(this.panelasig, "AccederAsig");
		cartas.addLayoutComponent(this.paneltem, "AccederTem");
		cartas.addLayoutComponent(this.panelej, "AccederEj");
		
		this.paginaprinc.actualizarAsignaturas();
		this.add(this.paginaprinc);
	}
	
	public PanelPrincipal getPanelPrincipal(){
		return this.paginaprinc;
	}
	
	public PanelAsignatura getPanelAsignatura(){
		return this.panelasig;
	}
	
	public PanelApunte getPanelApunte(){
		return this.panelap;
	}
	
	public PanelTema getPanelTema(){
		return this.paneltem;
	}
	
	/**
	 * Permite cambiar entre paneles
	 * @param nombre Nombre del panel al que se quiere cambiar
	 */
	public void cambiarCarta(String nombre){
		
		if(nombre.equals("Asignatura")){
			this.removeAll();
			this.add(this.asig);
			cartas.show(this, "Asignatura");
			
		}else if(nombre.equals("Tema")){
			this.removeAll();
			this.temas.actualizarTabla();
			this.add(this.temas);
			cartas.show(this, "Tema");
			
		}else if(nombre.equals("Subtema")){
			this.removeAll();
			this.subtemas.actualizarTabla();
			this.add(this.subtemas);
			cartas.show(this, "Subtema");
			
		}else if(nombre.equals("Apuntes")){
			this.removeAll();
			this.apuntes.actualizarTabla();
			this.add(this.apuntes);
			cartas.show(this, "Apuntes");
			
		}else if(nombre.equals("Ejercicio")){
			this.removeAll();
			this.add(this.ejercicios);
			cartas.show(this, "Ejercicio");
			
		}else if(nombre.equals("Matricula") || nombre.equals("Solicitud")){
			this.removeAll();
			this.solicitarmatricula.actualizartablas();
			this.add(this.solicitarmatricula);
			cartas.show(this, "Matricula");
			
		}else if(nombre.equals("Principal")){
			this.removeAll();
			this.paginaprinc.actualizarAsignaturas();
			this.add(this.paginaprinc);
			cartas.show(this, "Principal");
			
		}else if(nombre.equals("AccederAsig")){
			this.removeAll();
			this.panelasig.actualizarTemas();
			this.add(this.panelasig);
			cartas.show(this, "AccederAsig");
			
		}else if(nombre.equals("AccederTem")){
			this.removeAll();
			this.paneltem.actualizarContenido();
			this.add(this.paneltem);
			cartas.show(this, "AccederTem");
		}else if(nombre.equals("Administrar")){
			this.removeAll();
			this.paneladmin.actualizarTablaAsignaturas();
			this.paneladmin.actualizarTablaExpulsiones();
			this.paneladmin.actualizarTablaMatriculas();
			this.add(this.paneladmin);
			cartas.show(this, "Administrar");
		}
		else if(nombre.equals("AccederApunte")){
			this.removeAll();
			this.panelap.actualizarApuntes();
			this.add(this.panelap);
			cartas.show(this, "AccederApunte");
		}
		else if(nombre.equals("AccederEj")){
			this.removeAll();
			this.add(this.panelej);
			cartas.show(this, "AccederEj");
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
	
	public PanelMatricula getMatricula(){
		return this.solicitarmatricula;
	}
}
