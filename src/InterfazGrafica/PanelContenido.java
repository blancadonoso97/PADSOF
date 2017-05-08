package InterfazGrafica;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import Controladores.ControladorCrearEjercicio;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase para definir el panel de contenido dentro del panel de profesor o alumno
 * 
 * @author Miguel Angel Marroyo, Blanca Martinez Donoso
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
	
	private PanelCrearEjercicio ejercicios;	
	private PanelCrearPreguntaMultiple preguntamultiple;
	private PanelCrearPreguntaTest preguntatest;
	private PanelCrearPreguntaRedactar preguntaredactar;
	private PanelCrearOpcion opcion1;
	private PanelCrearOpcion opcion2;
	private PanelCrearOpcion opcion3;
	
	private PanelPrincipal paginaprinc;
	private PanelAdministrar paneladmin;
	
	private PanelAsignatura panelasig;
	private PanelTema paneltem;
	private PanelApunte panelap;
	private PanelEjercicio panelej;
	
	private PanelVerNotas panelnotas;
	
	private PanelEditarAsignatura paneledasig;
	private PanelEditarTema paneledtem;
	private PanelEditarApunte paneledap;
	private PanelEditarEjercicio paneledej;
	
	/**
	 * Constructor de la clase PanelContenido
	 * @param cont Panel del profesor
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
		this.ejercicios = new PanelCrearEjercicio(this);
		
		// Paneles preguntas
		this.preguntamultiple = new PanelCrearPreguntaMultiple(ejercicios);
		this.preguntaredactar = new PanelCrearPreguntaRedactar(ejercicios);
		this.preguntatest = new PanelCrearPreguntaTest(ejercicios);
		
		// Panel administar
		this.paneladmin = new PanelAdministrar(this);
		
		// Panel principal
		this.paginaprinc = new PanelPrincipal(this);
		
		this.panelnotas = new PanelVerNotas(this);
		
		this.panelasig = new PanelAsignatura(this);
		
		this.paneltem = new PanelTema(this);
		
		this.panelap = new PanelApunte(this);
		
		this.panelej = new PanelEjercicio(this);
		
		// Paneles de edicion
		this.paneledasig = new PanelEditarAsignatura(this);
		
		this.paneledtem = new PanelEditarTema(this);
		
		this.paneledap = new PanelEditarApunte(this);
		
		this.paneledej = new PanelEditarEjercicio(this);
		
		cartas.addLayoutComponent(this.asig, "Asignatura");
		cartas.addLayoutComponent(this.temas, "Tema");
		cartas.addLayoutComponent(this.apuntes, "Apuntes");
		cartas.addLayoutComponent(this.subtemas, "Subtema");
		cartas.addLayoutComponent(this.ejercicios, "Ejercicio");
		cartas.addLayoutComponent(this.paginaprinc, "Principal");
		cartas.addLayoutComponent(this.panelasig, "AccederAsig");
		cartas.addLayoutComponent(this.paneltem, "AccederTem");
		cartas.addLayoutComponent(this.paneltem, "AccederApunte");
		cartas.addLayoutComponent(this.panelej, "AccederEj");
		cartas.addLayoutComponent(this.paneladmin, "Administrar");
		cartas.addLayoutComponent(this.paneledasig, "EditarAsig");
		cartas.addLayoutComponent(this.paneledtem, "EditarTem");
		cartas.addLayoutComponent(this.paneledtem, "EditarAp");
		cartas.addLayoutComponent(this.paneledtem, "EditarEj");
		cartas.addLayoutComponent(this.panelnotas, "Notas");
		
		cartas.addLayoutComponent(this.preguntamultiple, "Multiple");
		cartas.addLayoutComponent(this.preguntatest, "Test");
		cartas.addLayoutComponent(this.preguntaredactar, "Redactar");
		
		
		ControladorCrearEjercicio controlador = new ControladorCrearEjercicio(this.getContenedorProf().getVentana(), preguntamultiple);
		
		this.ejercicios.setControladorMult(controlador);

		ControladorCrearEjercicio controlador2 = new ControladorCrearEjercicio(this.getContenedorProf().getVentana(), preguntaredactar);
		
		this.ejercicios.setControladorRed(controlador2);
		
		ControladorCrearEjercicio controlador3 = new ControladorCrearEjercicio(this.getContenedorProf().getVentana(), preguntatest);
		
		this.ejercicios.setControladorTest(controlador3);
		
		ControladorCrearEjercicio controlador4 = new ControladorCrearEjercicio(this.getContenedorProf().getVentana(), this.ejercicios);
		
		this.ejercicios.setControlador(controlador4);

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
		
		cartas.addLayoutComponent(this.solicitarmatricula, "Matricula");
		cartas.addLayoutComponent(this.paginaprinc, "Principal");
		cartas.addLayoutComponent(this.panelasig, "AccederAsig");
		cartas.addLayoutComponent(this.paneltem, "AccederTem");
		cartas.addLayoutComponent(this.panelej, "AccederEj");

		cartas.addLayoutComponent(this.panelej, "RealizarEj");
		
		this.paginaprinc.actualizarAsignaturas();
		this.add(this.paginaprinc);
	}
	
	/**
	 * Obtiene el panel principal
	 * @return paginaprinc
	 */
	public PanelPrincipal getPanelPrincipal(){
		return paginaprinc;
	}
	
	/**
	 * Obtiene el panel de la asignatura
	 * @return panelasig
	 */
	public PanelAsignatura getPanelAsignatura(){
		return panelasig;
	}
	
	/**
	 * Obtiene el panel de los apuntes
	 * @return panelap
	 */
	public PanelApunte getPanelApunte(){
		return panelap;
	}
	
	/**
	 * Obtiene el panel de tema
	 * @return paneltem
	 */
	public PanelTema getPanelTema(){
		return paneltem;
	}
	
	/**
	 * Obtiene el panel de editar asignatura
	 * @return paneledasig
	 */
	 public PanelEditarAsignatura getPanelEdAsig(){
		 return paneledasig;
	 }
	 
	 /**
	  * Obtiene el panel de editar tema
	  * @return
	  */
	 public PanelEditarTema getPanelEdTem(){
		 return paneledtem;
	 }
	
	/**
	 * Permite cambiar entre paneles
	 * @param nombre Nombre del panel al que se quiere cambiar
	 * @throws IOException 
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 * @throws ClassNotFoundException 
	 */
	public void cambiarCarta(String nombre) throws ClassNotFoundException, InvalidEmailAddressException, FailedInternetConnectionException, IOException{
		
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
			
			
			preguntamultiple.setPregunta(null);
			preguntatest.setPregunta(null);
			preguntaredactar.setPregunta(null);
			
			this.removeAll();
			this.ejercicios.actualizarTabla();
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
			this.panelej.actualizarejercicio();
			this.add(this.panelej);
			cartas.show(this, "AccederEj");
		}
		else if(nombre.equals("EditarAsig")){
			
			this.removeAll();
			this.paneledasig.actualizarAsignatura();
			this.add(this.paneledasig);
			cartas.show(this, "EditarAsig");
			
		}else if(nombre.equals("RealizarEj")){
			
			this.removeAll();
			this.panelej.responderEjercicio();
	
			
			this.panelej.getEjercicio().realizarEjercicio(this.panelej.getPanelAlumno().
			getVentana().getSistema().getAlumnoLog(), this.panelej.getOpcionesMarcadas());
			
			JOptionPane.showMessageDialog(panelasig,this.panelej.getEjercicio().calcularNota(this.panelej.getPanelAlumno().
			getVentana().getSistema().getAlumnoLog()) , "Error", JOptionPane.ERROR_MESSAGE);
			
			this.panelej.actualizarejercicio();
			this.add(this.panelej);
			cartas.show(this, "RealizarEj");
		}else if(nombre.equals("EditarTem") || nombre.equals("GuardarTem")){
			
			this.removeAll();
			this.paneledtem.actualizarTema();
			this.add(this.paneledtem);
			cartas.show(this, "EditarTem");
			
		}else if(nombre.equals("EditarAp") || nombre.equals("GuardarAp")){
			
			this.removeAll();
			this.paneledap.actualizarApunte();
			this.add(this.paneledap);
			cartas.show(this, "GuardarAp");
			
		}else if(nombre.equals("EditarEj")){
			
			this.removeAll();
			this.add(this.paneledej);
			cartas.show(this, "EditarEj");
			
		}else if(nombre.equals("Multiple")){
			
			preguntamultiple = new PanelCrearPreguntaMultiple(ejercicios);
			preguntamultiple.setEjercicio(ejercicios.getEjercicio());
			cartas.addLayoutComponent(preguntamultiple, "Multiple");
			this.add(this.preguntamultiple);
			cartas.show(this, "Multiple");
			
		}else if(nombre.equals("Test")){
			
			preguntatest = new PanelCrearPreguntaTest(ejercicios);
			preguntatest.setEjercicio(ejercicios.getEjercicio());
			cartas.addLayoutComponent(preguntatest, "Test");
			this.add(this.preguntatest);
			cartas.show(this, "Test");
			
		}else if(nombre.equals("Redactar")){
			
			preguntaredactar = new PanelCrearPreguntaRedactar(ejercicios);
			preguntaredactar.setEjercicio(ejercicios.getEjercicio());
			cartas.addLayoutComponent(preguntaredactar, "Redactar");
			this.add(this.preguntaredactar);
			cartas.show(this, "Redactar");
			
		}else if(nombre.equals("Opcion")){
			
			if(preguntaredactar.getPregunta() != null){
				
				this.opcion1 = new PanelCrearOpcion(this, preguntaredactar);
				cartas.addLayoutComponent(this.opcion1, "Opcion1");
				opcion1.setPregunta(preguntaredactar.getPregunta());
				this.add(this.opcion1);
				cartas.show(this, "Opcion1");
				
			}else if(preguntatest.getPregunta() != null){
				
				this.opcion2 = new PanelCrearOpcion(this, preguntatest);
				cartas.addLayoutComponent(this.opcion2, "Opcion2");
				opcion2.setPregunta(preguntatest.getPregunta());
				this.add(this.opcion2);
				cartas.show(this, "Opcion2");
				
			}else if (preguntamultiple.getPregunta() != null){
				
				this.opcion3 = new PanelCrearOpcion(this, preguntamultiple);
				cartas.addLayoutComponent(this.opcion3, "Opcion3");
				opcion3.setPregunta(preguntamultiple.getPregunta());;
				this.add(this.opcion3);
				cartas.show(this, "Opcion3");
				
<<<<<<< HEAD
			}else if(nombre.equals("RealizarEj")){
				
				this.removeAll();
				this.panelej.responderEjercicio();
				this.panelej.getEjercicio().realizarEjercicio(this.panelej.getPanelAlumno().
				getVentana().getSistema().getAlumnoLog(), this.panelej.getOpcionesMarcadas());
				
				JOptionPane.showMessageDialog(panelasig, this.panelej.getEjercicio().calcularNota(this.panelej.getPanelAlumno().
				getVentana().getSistema().getAlumnoLog()), "Error", JOptionPane.ERROR_MESSAGE);
				
				this.panelej.actualizarejercicio();
				this.add(this.panelej);
				cartas.show(this, "RealizarEj");
				
			}else if(nombre.equals("RealizarEj")){
				
				panelnotas.actualizarTabla();
				this.add(this.panelnotas);
				cartas.show(this, "Notas");
				
=======
>>>>>>> 0e0501e1529a4b02d968ae1b530117a978f26893
			}
			
		}
		
	}
	
	/**
	 * Devuelve el panel de pregunta multiple
	 * @return preguntamultiple
	 */
	public PanelCrearPreguntaMultiple getPreguntaMultiple(){
		return preguntamultiple;
	}
	
	/**
	 * Devuelve el panel de pregunta test
	 * @return preguntatest
	 */
	public PanelCrearPreguntaTest getPreguntaTest(){
		return preguntatest;
	}
	
	/**
	 * Devuelve el panel de pregunta redactar
	 * @return preguntamultiple
	 */
	public PanelCrearPreguntaRedactar getPreguntaRedactar(){
		return preguntaredactar;
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
