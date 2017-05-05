package InterfazGrafica;


import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import Asignatura.Asignatura;
import Controladores.ControladorAccederContenido;


public class PanelPrincipal extends JPanel{

	
	private static final long serialVersionUID = 1L;
	
	private PanelProfesor contenedorProf;
	private PanelAlumno contenedorAlum;
	private ArrayList<Asignatura> asig;
	private ButtonGroup asignaturas;
	private JButton acceder;
	
	PanelPrincipal(PanelContenido cont){
		
		

		if(cont.getContenedorProf()!=null){
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		this.contenedorProf = cont.getContenedorProf();
		}else{
			setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
			this.contenedorAlum = cont.getContenedorAlum();
		}
		
		
	}
	

	public PanelAlumno getPanelAlumno(){
		return this.contenedorAlum;
	}
	
	public PanelProfesor getPanelProfesor(){
		return this.contenedorProf;
	}
			
	public String getNombre(){
		if(this.asignaturas.getSelection() == null){
			return "";
		}else{
			if(this.contenedorProf != null){
				return this.contenedorProf.getVentana().getSistema().getAsignatura(this.asignaturas.getSelection().getActionCommand()).getNombre();
			}else{
				return this.contenedorAlum.getVentana().getSistema().getAlumnoLog().getAsignatura(this.asignaturas.getSelection().getActionCommand()).getNombre();
			}
			
		}
	}
	
	public ArrayList<Asignatura> getAsignaturas(){
		return this.asig;
	}
	
	
	public void actualizarAsignaturas(){
		
		this.removeAll();
		acceder= new JButton("Acceder");
		
		
		if(this.contenedorProf != null){
			
			ControladorAccederContenido cont = new ControladorAccederContenido(this);
			this.setControlador(cont);
			this.add(acceder);
			
			this.asig = this.contenedorProf.getVentana().getSistema().getAsignaturas();
			
				if(!this.asig.isEmpty()){
					int i;
					JRadioButton[] botones = new JRadioButton[this.asig.size()];
					asignaturas = new ButtonGroup();
					
					for(i=0; i<this.asig.size();i++){
						botones[i] = new JRadioButton("b");
					}
						
					i = 0;
					for(Asignatura a : this.asig){
						botones[i].setText(a.getNombre());
						botones[i].setActionCommand(a.getNombre());
						asignaturas.add(botones[i]);
						this.add(botones[i]);
						i++;
					}
					
					
					
				}else{
					JLabel texto = new JLabel("No hay asignatura");
					this.removeAll();
					this.add(texto);
					
				}
			
		}
		
		else if(this.contenedorAlum != null && this.contenedorAlum.getVentana().getSistema().getAlumnoLog()!=null){
			
			ControladorAccederContenido cont = new ControladorAccederContenido(this);
			this.setControlador(cont);
			this.add(acceder);
			
			this.asig = this.contenedorAlum.getVentana().getSistema().getAlumnoLog().getAsignaturas();
			
			if(!this.asig.isEmpty()){
				int i;
				JRadioButton[] botones = new JRadioButton[this.asig.size()];
				asignaturas = new ButtonGroup();
				
				for(i=0; i<this.asig.size();i++){
					botones[i] = new JRadioButton("b");
				}
					
				i = 0;
				for(Asignatura a : this.asig){
					botones[i].setText(a.getNombre());
					asignaturas.add(botones[i]);
					this.add(botones[i]);
					i++;
				}
			}else{
				JLabel texto = new JLabel("No hay asignatura");
				this.removeAll();
				this.add(texto);
				
			}
		}
			
	}
	
	
	public void setControlador(ActionListener c){
		acceder.addActionListener(c);
	}
	
	
	
	
	
}


