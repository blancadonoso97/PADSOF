package InterfazGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelApunte extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelProfesor contenedorProf;
	private PanelAlumno contenedorAlum;
	private JScrollPane scrollPane;
	private JLabel titulo;
	private SpringLayout springLayout;
	private JTextPane contenido;
	
	PanelApunte(PanelContenido cont){
		setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		springLayout = new SpringLayout();
		setLayout(springLayout);
		
		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 54, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -56, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -55, SpringLayout.EAST, this);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
		contenido = new JTextPane();
		
	
		
		if(cont.getContenedorProf()!=null){
			this.contenedorProf = cont.getContenedorProf();
			
			}else{
				this.contenedorAlum = cont.getContenedorAlum();
			}
		
		
	}


	public void actualizarApuntes(){
	
		if(this.contenedorProf!=null){
		
			this.titulo = DefaultComponentFactory.getInstance().createTitle(this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelTema().getNombreTema()).getApunte(this.contenedorProf.getPanelContenido().getPanelTema().getNombreApunteSeleccionado()).getTitulo());
			this.springLayout.putConstraint(SpringLayout.NORTH, this.scrollPane, 13, SpringLayout.SOUTH, this.titulo);
			this.springLayout.putConstraint(SpringLayout.SOUTH, this.titulo, -504, SpringLayout.SOUTH, this);
			this.springLayout.putConstraint(SpringLayout.WEST, this.titulo, 318, SpringLayout.WEST, this);
			this.titulo.setFont(new Font("Dialog", Font.BOLD, 15));
			this.titulo.setHorizontalAlignment(SwingConstants.CENTER);

			this.contenido.setText(this.contenedorProf.getVentana().getSistema().getTema(this.contenedorProf.getPanelContenido().getPanelTema().getNombreTema()).getApunte(this.contenedorProf.getPanelContenido().getPanelTema().getNombreApunteSeleccionado()).getTexto());
			
		}else{
			
			this.titulo = DefaultComponentFactory.getInstance().createTitle(this.contenedorAlum.getVentana().getSistema().getTema(this.contenedorAlum.getPanelContenido().getPanelTema().getNombreTema()).getApunte(this.contenedorAlum.getPanelContenido().getPanelTema().getNombreApunteSeleccionado()).getTitulo());
			this.springLayout.putConstraint(SpringLayout.NORTH, this.scrollPane, 13, SpringLayout.SOUTH, this.titulo);
			this.springLayout.putConstraint(SpringLayout.SOUTH, this.titulo, -504, SpringLayout.SOUTH, this);
			this.springLayout.putConstraint(SpringLayout.WEST, this.titulo, 318, SpringLayout.WEST, this);
			this.titulo.setFont(new Font("Dialog", Font.BOLD, 15));
			this.titulo.setHorizontalAlignment(SwingConstants.CENTER);
			
			this.contenido.setText(this.contenedorAlum.getVentana().getSistema().getTema(this.contenedorAlum.getPanelContenido().getPanelTema().getNombreTema()).getApunte(this.contenedorAlum.getPanelContenido().getPanelTema().getNombreApunteSeleccionado()).getTexto());
		}
		
		this.add(titulo);
		scrollPane.setColumnHeaderView(contenido);
	}
}