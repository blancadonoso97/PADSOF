package InterfazGrafica;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import Asignatura.Tema;
import Controladores.ControladorAccederContenido;

public class PanelAsignatura extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelAlumno panelAlum;
	private PanelProfesor panelProf;
	private ArrayList<Tema> temas;
	private ButtonGroup tem;
	private JButton acceder;
	
	PanelAsignatura(PanelContenido cont){
		
		if(cont.getContenedorProf()!=null){
			setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
			this.panelProf = cont.getContenedorProf();
			}else{
				setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
				this.panelAlum = cont.getContenedorAlum();
			}
	}
	

	public PanelAlumno getPanelAlumno(){
		return this.panelAlum;
	}
	
	public PanelProfesor getPanelProf(){
		return this.panelProf;
	}
			
	public String getNombre(){
		if(this.tem.getSelection() == null){
			return "";
		}else{
			
			return this.tem.getSelection().getActionCommand();
			
		}
	}
	
	public String getNombreAsig(){
		return this.panelProf.getPanelContenido().getPanelPrincipal().getNombre();
	}
	
	public ArrayList<Tema> getTemas(){
		return this.temas;
	}
	
	public void actualizarTemas(){
		
		this.removeAll();
		acceder= new JButton("Acceder");
		
		
		if(this.panelProf != null){
			
			ControladorAccederContenido cont = new ControladorAccederContenido(this);
			this.setControlador(cont);
			this.add(acceder);
			
			this.temas = this.panelProf.getVentana().getSistema().getAsignatura(this.panelProf.getPanelContenido().getPanelPrincipal().getNombre()).accederTema();
			
				if(!this.temas.isEmpty()){
					int i;
					JRadioButton[] botones = new JRadioButton[this.temas.size()];
					tem = new ButtonGroup();
					
					for(i=0; i<this.temas.size();i++){
						botones[i] = new JRadioButton("b");
					}
						
					i = 0;
					for(Tema a : this.temas){
						botones[i].setText(a.getNombre());
						botones[i].setActionCommand(a.getNombre());
						tem.add(botones[i]);
						this.add(botones[i]);
						i++;
					}
					
					
					
				}else{
					JLabel texto = new JLabel("No hay temas");
					this.removeAll();
					this.add(texto);
					
				}
			
		}
		
		else if(this.panelAlum != null && this.panelAlum.getVentana().getSistema().getAlumnoLog()!=null){
			
			ControladorAccederContenido cont = new ControladorAccederContenido(this);
			this.setControlador(cont);
			this.add(acceder);
			
			this.temas = this.panelAlum.getVentana().getSistema().getAlumnoLog().getAsignatura(this.panelAlum.getPanelContenido().getPanelPrincipal().getNombre()).accederTema();
			
			if(!this.temas.isEmpty()){
				int i;
				JRadioButton[] botones = new JRadioButton[this.temas.size()];
				tem = new ButtonGroup();
				
				for(i=0; i<this.temas.size();i++){
					botones[i] = new JRadioButton("b");
				}
					
				i = 0;
				for(Tema a : this.temas){
					botones[i].setText(a.getNombre());
					tem.add(botones[i]);
					this.add(botones[i]);
					i++;
				}
			}else{
				JLabel texto = new JLabel("No hay temas");
				this.removeAll();
				this.add(texto);
				
			}
		}
			
	}
	
	
	public void setControlador(ActionListener c){
		acceder.addActionListener(c);
	}
	
	
	
	

}
