package InterfazGrafica;


import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import Asignatura.Asignatura;


public class PanelAsignaturas extends JPanel{

	
	private static final long serialVersionUID = 1L;
	
	private PanelProfesor contenedorProf;
	private PanelAlumno contenedorAlum;
	private ArrayList<Asignatura> asig;
	
	PanelAsignaturas(PanelContenido cont){
		
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
			
		
	public void actualizarAsignaturas(){
		
		if(this.contenedorProf != null){
				this.removeAll();
				this.asig = this.contenedorProf.getVentana().getSistema().getAsignaturas();
				
				if(!this.asig.isEmpty()){
					int i;
					JRadioButton[] botones = new JRadioButton[this.asig.size()];
				
					for(i=0; i<this.asig.size();i++){
						botones[i] = new JRadioButton("b");
					}
						
					i = 0;
					for(Asignatura a : this.asig){
						botones[i].setText(a.getNombre());
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
			this.removeAll();
			this.asig = this.contenedorAlum.getVentana().getSistema().getAlumnoLog().getAsignaturas();
			
			if(!this.asig.isEmpty()){
				int i;
				JRadioButton[] botones = new JRadioButton[this.asig.size()];
			
				for(i=0; i<this.asig.size();i++){
					botones[i] = new JRadioButton("b");
				}
					
				i = 0;
				for(Asignatura a : this.asig){
					botones[i].setText(a.getNombre());
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
}
