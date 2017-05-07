package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import Asignatura.Tema;
import Controladores.ControladorEditarContenido;

import javax.swing.JTabbedPane;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelEditarAsignatura  extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private PanelProfesor contenedorProf;
	private JTabbedPane tabbedPane;
	private SpringLayout springLayout;
	private DefaultListModel<String> temas = new DefaultListModel<String>(); 
	private JList<String> listatemas;
	private JButton editar;
	private JButton anyadir;
	private JButton eliminar;
	
	PanelEditarAsignatura(PanelContenido cont){
		
		this.contenedorProf = cont.getContenedorProf();
		
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		this.springLayout = new SpringLayout();
		setLayout(springLayout);
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 95, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 53, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, 475, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, -50, SpringLayout.EAST, this);
		add(tabbedPane);
		
		this.temas.addElement("La asignatura no contiene temas");
		this.listatemas = new JList<String>(temas);
		
		tabbedPane.addTab("Temas", null, listatemas, null);
		
		this.anyadir = new JButton("Añadir");
		springLayout.putConstraint(SpringLayout.NORTH, anyadir, 60, SpringLayout.SOUTH, tabbedPane);
		springLayout.putConstraint(SpringLayout.WEST, anyadir, 129, SpringLayout.WEST, this);
		ControladorEditarContenido c = new ControladorEditarContenido(this);
		this.setControlador(c,"anyadir");
		this.add(anyadir);
		
		this.editar = new JButton("Editar");
		springLayout.putConstraint(SpringLayout.NORTH, editar, 0, SpringLayout.NORTH, anyadir);
		springLayout.putConstraint(SpringLayout.WEST, editar, 126, SpringLayout.EAST, anyadir);
		this.setControlador(c,"editar");
		this.add(editar);
		
		this.eliminar = new JButton("Eliminar");
		springLayout.putConstraint(SpringLayout.NORTH, eliminar, 0, SpringLayout.NORTH, anyadir);
		springLayout.putConstraint(SpringLayout.WEST, eliminar, 128, SpringLayout.EAST, editar);
		
		this.setControlador(c,"eliminar");
		this.add(eliminar);
		
	}
	
	public void setControlador(ActionListener c,String nombre){
		if(nombre.equals("anyadir")){
			this.anyadir.addActionListener(c);
		}else if(nombre.equals("editar")){
			this.editar.addActionListener(c);
		}else if(nombre.equals("eliminar")){
			this.eliminar.addActionListener(c);
		}
	}
	
	public String getNombreTemaSeleccionado(){
		if(this.listatemas.getSelectedValue() == null){
			return "";
		}else{
			return this.listatemas.getSelectedValue();
			
		}
	}
	
	public PanelProfesor getPanelProf(){
		return this.contenedorProf;
	}
	public String getNombreAsignatura(){
	
		return this.contenedorProf.getPanelContenido().getPanelPrincipal().getNombreAsignaturaSeleccionada();
		
	}
	public void actualizarAsignatura(){
		
		ArrayList<Tema> tem;
		
		tem = this.contenedorProf.getVentana().getSistema().getAsignatura(this.contenedorProf.getPanelContenido().getPanelPrincipal().getNombreAsignaturaSeleccionada()).getTemas();
		
		temas.removeAllElements();
		if(!tem.isEmpty()){
			
				
			for(Tema a : tem){
				temas.addElement(a.getNombre());
			}
					
		}else{
			this.temas.addElement("La asignatura no contiene temas");
		}
		
	}
	
}
