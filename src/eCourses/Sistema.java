package eCourses;

import java.io.*;

import java.util.ArrayList;

import Asignatura.Apuntes;
import Asignatura.Asignatura;
import Asignatura.Tema;
import Examen.Ejercicio;
import es.uam.eps.padsof.emailconnection.*;

/**
 * 
 * Clase para definir el sistema de la aplicacion
 * 
 * @author Miguel Angel Marroyo Bouzada, Blanca Martinez Donoso
 *
 */
public class Sistema implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String idProfesor;
	private String contProfesor;
	private boolean esProfesor;
	private boolean logIn;
	private Alumno alumnoLog;

	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	ArrayList<Expulsion> expulsiones = new ArrayList<Expulsion>();
	ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
	ArrayList<SolicitudMatricula> solicitudes = new ArrayList<SolicitudMatricula>();

	/**
	 * Construcutor de la clase Sistema
	 * 
	 * @param archivoProf Archivo con los datos del profesor
	 * @param archivoAlum Archivo con los datos de los alumnos
	 */
	public Sistema(String archivoProf, String archivoAlum) throws IOException, ClassNotFoundException{
	
		String Fichero = "sistema.txt";
		File fichero = new File(Fichero);
		
		if (fichero.exists()){
			
			Sistema.cargarSistema("sistema.txt");
			
		}else{
			this.cargarDatosProfesor(archivoProf);
			this.cargarAlumnos(archivoAlum);
		}

	}

	/**
	 * Guarda en un fichero el objeto sistema
	 * @param archivo fichero donde guardar
	 */
	public void guardarSistema(String archivo) throws IOException {

		File file = new File (archivo);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(this);

		oos.close();

		return;
	}

	/**
	 * Carga de un fichero el objeto sistema
	 * @param archivo fichero de donde leer
	 */
	public static Sistema cargarSistema(String archivo) throws IOException, ClassNotFoundException {

		File file = new File (archivo);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);

		Sistema sist = (Sistema) ois.readObject();
		
		sist.setEsProfesor(false);
		sist.setLogIn(false);
		sist.setAlumnoLogIn(null);
				
		ois.close();
		return sist;

	}
	
	/**
	 * Guarda en el sistema el id y la contrasena del profesor
	 * @param archivoProf Archivo a leer
	 */
	public void cargarDatosProfesor(String archivoProf) throws IOException, ClassNotFoundException{
	
		File fichero = new File(archivoProf);
		
		if(!fichero.exists()){
			return;
		}
		
		FileReader fileReader = new FileReader(fichero);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		StringBuffer stringBuffer = new StringBuffer();
		String linea = null;
		
		String separador = ";";
		
		bufferedReader.readLine(); /* Lee la primera linea (que debe ignorar)*/
		
		while ((linea = bufferedReader.readLine()) != null) {
			stringBuffer.append(linea);
			stringBuffer.append("\n");
				
			String[] datos = new String[5];
			datos = linea.split(separador);
					
			idProfesor = datos[3];
			contProfesor = datos[4];
		}
		
		fileReader.close();
		return;
		
	}

	/**
	 * Carga en el sistema todos los alumnos
	 * @param archivo Archivo a leer
	 */
	public void cargarAlumnos(String archivo) throws IOException{
		
		File fichero = new File(archivo);
		
		if(!fichero.exists()){
			return;
		}
		
		FileReader fileReader = new FileReader(fichero);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		StringBuffer stringBuffer = new StringBuffer();
		String linea = null;
		
		String separador = ";";
		
		bufferedReader.readLine(); /* Lee la primera linea (que debe ignorar)*/
		
		while ((linea = bufferedReader.readLine()) != null) {
			stringBuffer.append(linea);
			stringBuffer.append("\n");
				
			String[] datos = new String[5];
			datos = linea.split(separador);
							
			Alumno alum = new Alumno(datos[0], datos[1], datos[2], datos[3], datos[4]);
			
			/* Solo anade un alumno si su correo es correcto*/
			if (EmailSystem.isValidEmailAddr(alum.getEmail())){
				alumnos.add(alum);
			}
				
			
		}
		
		fileReader.close();
						
	}
	
	/**
	 * Simula el envio de una notificacion por email a un alumno
	 * @param usuario Usuario al que se le envia la notificacion
	 * @param titulonot Titulo de la notificacion
	 * @param notificacion Contenido de la notificacion
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public void enviarNotificacion(Alumno usuario, String titulonot, String notificacion) throws InvalidEmailAddressException, FailedInternetConnectionException {
		
		EmailSystem.send(usuario.getEmail(), titulonot, notificacion);
		System.out.println(usuario.getEmail() + " " + titulonot + " " + notificacion); /* Imprime por pantalla la notificacion para poder comprobar que es correcta*/
		return;

	}
	
	/**
	 * Comprueba que el alumno se ha identificado correctamente
	 * @param id Identificador a comprobar (puede ser un id o un email)
	 * @param contra Contrasena a comprobar
	 * @return true si el login es correcto, false en caso contrario
	 */
	public boolean comprobarLogIn(String id, String contra) {

		/* Obtiene cada alumno y compara su id/email y contrasena*/
		for (Alumno alum : alumnos){
			
			if(alum.getId().equals(id) || alum.getEmail().equals(id)){
				
				if(alum.getContrasena().equals(contra)){
					logIn = true;
					alumnoLog  = alum; /* Establece el alumno logueado*/
					return true;
				}
				
			}
			
		}
		
		/* Si sale del bucle quiere decir que el id y contrasena no pertencen a un alumno por lo que prueba con el profesor*/
		return this.comprobarEsProfesor(id, contra);		
		
	}
	
	/**
	 * Cierra la sesion y guarda el estado de la aplicacion
	 * @param archivo Archivo donde guardar el sistema
	 * @throws IOException
	 */
	public void logOut(String archivo) throws IOException{
		
		logIn = false;
		esProfesor = false;
		alumnoLog = null;
		this.guardarSistema(archivo);
		
		return;
		
	}
	
	/**
	 * Comprueba si el id y la contrasena es la del profesor y pone el atributo
	 * esProfesor a true
	 * @param id Identificador a comprobar
	 * @param pass Contrasena a comprobar
	 * @return true si es un profesor, false si es alumno
	 */
	public boolean comprobarEsProfesor(String id, String pass) {

		if (idProfesor.equals(id)) {
			if (contProfesor.equals(pass)) {
				esProfesor = true;
				logIn = true;
				alumnoLog = null;
				return true;
			} else
				esProfesor = false;
			return false;
		} else
			esProfesor = false;
		return false;

	}

	/**
	 * Comprueba si un alumno esta matriculado en una asignatura
	 * @param alum alumno
	 * @param asig asignatura
	 * @param solic solicitud de matricula
	 * @return true si el alumno esta matriculado en la asignatura, false en caso contrario
	 */
	public boolean comprobarMatricula(Alumno alum, Asignatura asig, SolicitudMatricula solic) {
		
		if (solic.getAlumno().equals(alum) && solic.getAsignatura().equals(asig) && solic.getMatricula()){
			
			return true;
			
		}else
			return false;
		
	}
	
	/**
	 * Comprueba si el alumno esta expulsado de la asignatura
	 * @param alum alumno
	 * @param asig asignatura
	 * @param exp expulsion
	 * @return true si el alumno esta expulsado, false en caso contrario
	 */
	public boolean comprobarExpulsion(Alumno alum, Asignatura asig, Expulsion exp){
		
		if(exp.getAlumno().equals(alum) && exp.getAsignatura().equals(asig)){
						
			if(exp.getExpulsado() == false){
				alum.agregarAsignatura(exp.getAsignatura());
				expulsiones.remove(this); //Si la expulsion ya no esta vigente, se elimina
				return false;
			}
			
			return true;

		}else
			return true;
		
	}

	/**
	 * Anade una solicitud de matricula al sistema
	 * @param mat Matricula a agregar
	 * @return true si se anade la matricula correctamente, false en caso contrario
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public boolean aceptarMatricula(SolicitudMatricula mat) throws InvalidEmailAddressException, FailedInternetConnectionException {
		
		if(esProfesor){

			mat.setMatricula(true);
			
			getAlumno(mat.getAlumno().getId()).agregarAsignatura(getAsignatura(mat.getAsignatura().getNombre()));
			getAsignatura(mat.getAsignatura().getNombre()).agregarAlumno(getAlumno(mat.getAlumno().getId()));
				
			enviarNotificacion(mat.getAlumno(), "Matricula", "Su matricula en la asignatura " + mat.getAsignatura().getNombre() + " ha sido aceptada\n");

			return true;	
		}
		
		return false;

	}
	
	/**
	 * Deniega la matricula del alumno
	 * @param mat Matricula a denegar
	 * @return true si se deniega la matricula correctamente, false en caso contrario
	 * @throws InvalidEmailAddressException
	 * @throws FailedInternetConnectionException
	 */
	public boolean denegarMatricula(SolicitudMatricula mat) throws InvalidEmailAddressException, FailedInternetConnectionException{
				
		if(esProfesor){
			
			mat.setMatricula(false);
			mat.getAlumno().eliminarSolicitud(mat);

			enviarNotificacion(mat.getAlumno(), "Matricula", "Su matricula en la asignatura " + mat.getAsignatura().getNombre() + " ha sido denegada\n");

			return true;
		}
		
		
		return false;
	}

	/**
	 * Anade una expulsion al sistema
	 * @param exp Expulsion a agregar
	 * @return true si se anade la expulsion correctamente, false en caso contrario
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public boolean expulsarAlumno(Expulsion exp) throws InvalidEmailAddressException, FailedInternetConnectionException {
		
		if(esProfesor){
			
			if (expulsiones.add(exp)) {
				
				exp.setExpulsado(true);
				exp.getAlumno().eliminarAsignatura(exp.getAsignatura());
				
				enviarNotificacion(exp.getAlumno(), "Expulsion", "Ha sido expulsado de la asignatura: " + exp.getAsignatura().getNombre() + "\n");
				
				return true;
			}
			
			return false;
			
		}
		
		return false;

	}

	/**
	 * Crea una asignatura en el sistema. Solo puede crearse si el usuario es un
	 * profesor
	 * @param nombre Nombre de la nueva asignatura
	 * @param visibilidad Visibilidad de la nueva asignatura
	 * @return true si se ha creado y anadido, false en caso contrario
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public boolean agregarAsignatura(String nombre, boolean visibilidad) throws InvalidEmailAddressException, FailedInternetConnectionException {
		
		if (esProfesor) {

			Asignatura asig = new Asignatura(nombre, visibilidad);
			this.asignaturas.add(asig);		
			return true;
			
			
		} else
			return false;

	}
	
	/**
	 * Anade un nuevo tema a una asignatura
	 * @param nombre Nombre del nuevo tema
	 * @param asig Asignatura donde anadir el tema
	 * @param visibilidad Visibilidad del nuevo tema
	 * @return true si se ha creado y anadido, false en caso contrario
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public boolean agregarTema (String nombre, Asignatura asig, boolean visibilidad) throws InvalidEmailAddressException, FailedInternetConnectionException{
		
		if(esProfesor){
			
			Tema tema = new Tema (asig, nombre, visibilidad);
			
			asig.agregarTema(tema);
			
			/* Si la asignatura no esta visible, el tema tampoco*/
			if(!asig.esVisible()){
				return true;
			}
			
			/* Si el tema esta visible avisara a los alumnos de su creacion*/
			ArrayList<Alumno> alum = asig.getAlumnos();
			
			if(tema.esVisible()){

				for (Alumno a : alum){
						enviarNotificacion(a, "Nuevo tema", "La asignatura" + asig.getNombre() + "contiene el nuevo tema" + nombre);
				}
				
			}
		
			return true;
			
		}else
			return false;
		
	}
	
	/**
	 * Elimina un tema de una asignatura
	 * @param nombretema Nombre del tema a eliminar
	 * @param nombreasig Nombre de la asignatura a la que pertenece
	 * @return true si se ha eliminado de la asignatura, false en caso contrario
	 */
	public boolean eliminarTema(String nombretema, String nombreasig){
		
		return this.getAsignatura(nombreasig).getTemas().remove(this.getAsignatura(nombreasig).getTema(nombretema));
		
	}
	
	/**
	 * Anade un nuevo subtema a un tema
	 * @param nombre Nombre del subtema
	 * @param tema Tema donde anadir el subtema
	 * @param visibilidad Visibilidad del nuevo subtema
	 * @return true si se ha creado y anadido, false en caso contrario
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public boolean agregarSubtema(String nombre, Tema tema, boolean visibilidad) throws InvalidEmailAddressException, FailedInternetConnectionException{
		
		if(esProfesor){
			
			Tema subtema = new Tema (tema.getAsignatura(), nombre, visibilidad);
			
			tema.agregarTema(subtema);
			
			/* Si el tema no esta visible, el subtema tampoco*/
			if(!tema.esVisible()){
				return true;
			}
			
			/* Si el subtema esta visible avisara a los alumnos de su creacion*/
			ArrayList<Alumno> alum = tema.getAsignatura().getAlumnos();
		
			if(subtema.esVisible()){

				for (Alumno a : alum){
						enviarNotificacion(a, "Nuevo subtema", "El tema " + tema.getNombre() + " contiene el nuevo subtema " + nombre);
				}
				
			}

			return true;
			
		}else
			return false;
		
	}
	
	/**
	 * Agrega un nuevo ejercicio a un tema
	 * @param tema Tema donde anadir el ejercicio
	 * @param peso Peso del ejercicio
	 * @param realizado Estado del ejercicio
	 * @param diaI Dia de inicio
	 * @param mesI Mes de inicio
	 * @param anyoI Anyo de inicio
	 * @param diaF Dia de finalizacion
	 * @param mesF Mes de finalizacion
	 * @param anyoF Anyo de finalizacion
	 * @param nombre Nombre del ejercicio
	 * @return true si se ha creado y anadido, false en caso contrario
	 * @throws InvalidEmailAddressException
	 * @throws FailedInternetConnectionException
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public boolean agregarEjercicio(Tema tema,boolean ordenado,double peso, int diaI, int mesI, int anyoI, int diaF, int mesF, int anyoF, String nombre) throws InvalidEmailAddressException, FailedInternetConnectionException, ClassNotFoundException, IOException{
			
		if(this.esProfesor){
			
			Ejercicio ejercicio = new Ejercicio (tema, ordenado, peso, diaI, mesI, anyoI, diaF, mesF, anyoF, nombre);
			
			tema.agregarEjercicio(ejercicio);
			
			/* Si el tema no esta visible, el ejercicio tampoco*/
			if(!tema.esVisible()){
				return true;
			}
			
			/* Si el ejercicio esta visible avisara a los alumnos de su creacion*/
			ArrayList<Alumno> alum = tema.getAsignatura().getAlumnos();
		
			if(ejercicio.getVisible()){
				
				for (Alumno a : alum){
						enviarNotificacion(a, "Nuevo ejercicio", "El tema " + tema.getNombre() + " contiene un nuevo ejercicio " + nombre);
				}

				
			}

			return true;
			
			
		}else
			return false;
		
	}
	
	/**
	 * Anade nuevos apuntes a un tema
	 * @param tema Tema donde anadir los apuntes
	 * @param contenido Contenido de los apuntes
	 * @param dia Dia de inicio
	 * @param mes Mes de inicio
	 * @param anyo Anyo de inicio 
	 * @param v1 Visibilidad de los apuntes
	 * @param titulo Titulo de los apuntes
	 * @return true si se ha creado y anadido, false en caso contrario
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public boolean agregarApuntes(Tema tema, String contenido, int dia, int mes, int anyo, boolean v1, String titulo) throws InvalidEmailAddressException, FailedInternetConnectionException{
				
		if(esProfesor){
			
			Apuntes apuntes = new Apuntes (tema, contenido, dia, mes, anyo, v1, titulo);
			
			tema.agregarApuntes(apuntes);
			
			if(!tema.esVisible()){
				return true;
			}
			
			/* Si los apuntes estan visibles avisara a los alumnos de su creacion*/
			ArrayList<Alumno> alum = tema.getAsignatura().getAlumnos();
			
			if(apuntes.getVisible()){

				for (Alumno a : alum){
						enviarNotificacion(a, "Nuevos apuntes", "El tema " + tema.getNombre() + " contiene los nuevos apuntes " + titulo);
				}

				
			}
						
			return true;
			
		}else
			return false;
		
		
	}
	
	/**
	 * Elimina unos apuntes de un tema
	 * @param nombreasig Nombre de la asignatura a la que pertenece el tema
	 * @param nombretema Nombre del tema al que pertenecen los apuntes
	 * @param nombreapuntes Nombre de los apuntes
	 * @return true si se eliminan correctamente, false en caso contrario
	 */
	public boolean eliminarApuntes(String nombreasig, String nombretema, String nombreapuntes){
		
		return this.getAsignatura(nombreasig).getTemas().remove(this.getAsignatura(nombreasig).getTema(nombretema));
		
	}
	
	/**
	 * Crea y agrega una nueva solicitud (creada por el alumno logueado)
	 * @param asig Asignatura a la que se desea matricular el alumno
	 * @return true si se agrega correctamente, false en caso contrario
	 */
	public boolean agregarSolicitud(Asignatura asig){
		
		/* Solo se puede crear una solicitud de matricula en una asignatura visible*/
		if(!esProfesor && asig.esVisible()){
			
			SolicitudMatricula matricula = new SolicitudMatricula(alumnoLog, asig, false);
			
			alumnoLog.agregarSolicitud(matricula);
			
			solicitudes.add(matricula);
			
			return true;
		}else 
			return false;
		
		
	}	

	
	/**
	 * Set del id del profesor
	 * @param newId
	 */
	public void setIdProfesor(String newId){
		
		idProfesor = newId;
		return;
	}
	
	/**
	 * Set de la contrasena del profesor
	 * @param newCont
	 */
	public void setContProfesor(String newCont){
		
		contProfesor = newCont;
		return;
	}
	
	/**
	 * Set del parametro esProfesor
	 * @param newEsProfesor
	 */
	public void setEsProfesor(boolean newEsProfesor){
		esProfesor = newEsProfesor;
		return;
	}
	
	/**
	 * Set del parametro logIn
	 * @param newLogIn
	 */
	public void setLogIn(boolean newLogIn){
		logIn = newLogIn;
		return;
	}
	
	/**
	 * Set del alumno logueado
	 * @param alum
	 */
	public void setAlumnoLogIn(Alumno alum){
		alumnoLog = alum;
		return;
	}

	/**
	 * Get del alumno logueado
	 * @return alumnoLog
	 */
	public Alumno getAlumnoLog(){
		return alumnoLog;
	}
	
	/**
	 * Get del id del profesor
	 * @return idProfesor
	 */
	public String getIdProfesor(){
		
		return idProfesor;
	}
	
	/**
	 * Get de la contrasena del profesor
	 * @return contProfesor
	 */
	public String getContProfesor(){

		return contProfesor;
	}
	
	/**
	 * Get del parametro esProfesor
	 * @return esProfesor
	 */
	public boolean getEsProfesor(){
		return esProfesor;
	}
	
	/**
	 * Get del parametro logIn
	 * @return logIn
	 */
	public boolean getLogIn(){
		return logIn;
	}
	
	/**
	 * Get del array de alumnos
	 * @return alumnos
	 */
	public ArrayList<Alumno> getAlumnos(){
		return alumnos;
	}
	
	/**
	 * Get del array de asignaturas
	 * @return asignaturas
	 */
	public ArrayList<Asignatura> getAsignaturas(){
		return asignaturas;
	}
	
	/**
	 * Get del array de expulsiones
	 * @return expulsiones
	 */
	public ArrayList<Expulsion> getExpulsiones(){
		return expulsiones;
	}
	
	/**
	 * Get del array de solicitudes
	 * @return solicitudes
	 */
	public ArrayList<SolicitudMatricula> getSolicitudes(){
		return solicitudes;
	}
	
	/**
	 * Obtiene una asignatura del sistema en funcion de su nombre
	 * @param nomAsig Nombre de la asignatura a obtener
	 * @return la asignatura si se encuentra en el sistema, null en caso contrario
	 */
	public Asignatura getAsignatura(String nomAsig){
		
		for(Asignatura a: asignaturas){
			
			if(a.getNombre().equals(nomAsig)){
				return a;
			}
			
		}
		
		return null;
	}
	
	/**
	 * Obtiene un tema del sistema en funcion de su nombre
	 * @param nomTema Nombre del tema a obtener
	 * @return el tema si se encuentra en el sistema, null en caso contrario
	 */
	public Tema getTema(String nomTema){
		
		for(Asignatura a: asignaturas){
			
			for (Tema b: a.getTemas()){
				if(b.getNombre().equals(nomTema)){
					return b;
				}
			}
						
		}
		
		return null;
	}
	
	/**
	 * Obtiene un alumno del sistema en funcion de su identificador
	 * @param idAlum Id del alumno
	 * @return el alumno si se encuentra en el sistema, null en caso contrario
	 */
	public Alumno getAlumno(String idAlum){
		
		for(Alumno a: alumnos){
			
			if(a.getId().equals(idAlum)){
				return a;
			}
			
		}
		
		return null;
	}
	
	/**
	 * Obtiene la solicitud de un alumno en una asignatura
	 * @param idAlumno Id del alumno
	 * @param nombreAsig Nombre de la asignatura de la solicitud
	 * @return la solicitud si se encuentra en el sistema, null en caso contrario
	 */
	public SolicitudMatricula getMatricula(String idAlumno, String nombreAsig){
		
		for(SolicitudMatricula a: solicitudes){
			
			if(a.getAlumno().getId().equals(idAlumno)){
				
				if(a.getAsignatura().getNombre().equals(nombreAsig)){
					return a;
				}
				
				
			}
			
		}
		
		return null;
		
	}
	
	/**
	 * Obtiene la expulsion de un alumno en una asignatura
	 * @param idAlumno Id del alumno
	 * @param nombreAsig Nombre de la asignatura de la solicitud
	 * @return la expulsion si se encuentra en el sistema, null en caso contrario
	 */
	public Expulsion getExpulsion(String idAlumno, String nombreAsig){
		
		for(Expulsion a: expulsiones){
			
			if(a.getAlumno().getId().equals(idAlumno)){
				
				if(a.getAsignatura().getNombre().equals(nombreAsig)){
					return a;
				}
				
				
			}
			
		}
		
		return null;
		
	}

	
}
