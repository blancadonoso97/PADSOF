package Examen;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Asignatura.Asignatura;
import InterfazGrafica.PanelAlumno;
import eCourses.SolicitudMatricula;

public class PanelMatricula {

	 private JList<String> listaAsig;
	 private JList<String> listaMat;
	 private JList<String> listaPen;
	 private PanelAlumno cont;
	 

	public PanelMatricula(PanelAlumno contenedor){
	
	DefaultListModel<String> modeloListaAsignaturas;
	DefaultListModel<String> modeloListaMatriculadas;
	DefaultListModel<String> modeloListaPendientes;
	
	ArrayList<SolicitudMatricula> solicitud;
	ArrayList<Asignatura> asignProf;
	ArrayList<Asignatura> asignMat;
	ArrayList<Asignatura> asignPen = new ArrayList<Asignatura>();
	
	this.cont = contenedor;
	
	asignProf = this.cont.getVentana().getSistema().getAsignaturas();
	asignMat = this.cont.getVentana().getSistema().getAlumnoLog().getAsignaturas();
	solicitud = this.cont.getVentana().getSistema().getAlumnoLog().getSolicitudesMat();
	
	for(SolicitudMatricula s : solicitud){
		asignPen.add(s.getAsignatura());
	}
	
	modeloListaAsignaturas = new DefaultListModel<String>();
	modeloListaMatriculadas = new DefaultListModel<String>();
	modeloListaPendientes = new DefaultListModel<String>();
	
	for(Asignatura a : asignProf){
		modeloListaAsignaturas.addElement(a.getNombre());
	}
	
	for(Asignatura a : asignMat){
		modeloListaMatriculadas.addElement(a.getNombre());
	}

	for(Asignatura a : asignPen){
		modeloListaPendientes.addElement(a.getNombre());
	}
	
	this.listaAsig = new JList<String>(modeloListaAsignaturas);
	this.listaAsig = new JList<String>(modeloListaMatriculadas);
	this.listaAsig = new JList<String>(modeloListaPendientes);
	
	}
}
