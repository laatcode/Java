package lookandfeel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * Look and feel se refiere a los temas de nuestras aplicaciones
 * Look proviene de la apariencia que tienen los componentes y feel de la forma en como se comportan
 * Estos temas pueden ser internos  (incluidos en el JDK) o externos, que pueden ser descargados de otros sitios como http://www.jtattoo.net/
 * Los temas externos deben se agregados a través de librerias que proporciona cada distribuidor de temas, con lo cual solo cambiaría el código para ser invocado el tema.
 *  
 */

public class JavaLookAndFeel extends JFrame{
	
	JPanel panel, panelComponentes;
	JMenuBar barra;
	JMenu menu1, menu2;
	JMenuItem item1, item2, item3;
	JSeparator separador;
	JComboBox<String> cajaCombo;
	JLabel etiqueta;
	JTextField campoTexto;
	JButton boton;
	JCheckBox cajaSeleccion;
	JRadioButton radioBoton;
	JToggleButton botonActivacion;
	JSlider deslizador;
	JSpinner rotador;
	JProgressBar barraProgreso;
	
	//Metodo para actualizar el look and feel en tiempo de ejecución
	public void cambiarLookAndFeel(){
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public JavaLookAndFeel(){
		
		item1 = new JMenuItem("Item 1");
		item2 = new JMenuItem("Item 2");
		item3 = new JMenuItem("Item 3");
		menu1 = new JMenu("Menu 1");
		menu2 = new JMenu("Menu 2");
		separador = new JSeparator();
		barra = new JMenuBar();
		
		menu2.add(item3);
		
		menu1.add(item1);
		menu1.add(menu2);
		menu1.add(separador);
		menu1.add(item2);
		barra.add(menu1);
		
		cajaCombo = new JComboBox<String>();
		//Se selecciona el nombre del look and feel por defecto
		cajaCombo.setSelectedItem(UIManager.getLookAndFeel().getName());
		
		//Se recorren los temas instalados y se asignan a la caja combo
		for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
			cajaCombo.addItem(info.getName());
		}
		//Evento que se ejecuta cuando se selecciona un tema
		cajaCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					//Se obtiene el nombre del tema seleccionado en la caja combo
				    String look = cajaCombo.getSelectedItem().toString();
				    //Se recorren los temas instalado y cuando es igual al de la caja combo, lo asigna como tema con el nombre de la clase 
				    for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
				    	if (look.equals(info.getName())) {
				            UIManager.setLookAndFeel(info.getClassName());
				            break;
				        }
				    }
				    //Al final se ejecuta el metodo para actualizar el tema en tiempo real
				    cambiarLookAndFeel();
				    }catch(Exception ex){
				        JOptionPane.showMessageDialog(getContentPane(), "Error al cargar el tema "+ex);
				    }
			}
		});
		
		//Se crea una etiqueta con texto de nombre de la clase del tema por defecto
		etiqueta = new JLabel(UIManager.getLookAndFeel().getClass().getName());
		panel = new JPanel();
		panel.setLayout(new FlowLayout(1, 20, 20));
		panel.add(cajaCombo);
		panel.add(etiqueta);
		
		campoTexto = new JTextField(30);
		boton = new JButton("Botón");
		cajaSeleccion = new JCheckBox("CajaSelección");
		radioBoton = new JRadioButton("Radio Botón");
		botonActivacion = new JToggleButton("Botón de activación");
		deslizador = new JSlider(0,100);
		rotador = new JSpinner();
		barraProgreso = new JProgressBar(0,100);
		barraProgreso.setValue(75);
		
		panelComponentes = new JPanel();
		panelComponentes.setLayout(new GridLayout(8, 1, 20,10));
		panelComponentes.add(campoTexto);
		panelComponentes.add(boton);
		panelComponentes.add(cajaSeleccion);
		panelComponentes.add(radioBoton);
		panelComponentes.add(botonActivacion);
		panelComponentes.add(deslizador);
		panelComponentes.add(rotador);
		panelComponentes.add(barraProgreso);
		
		add(panel, BorderLayout.NORTH);
		add(panelComponentes, BorderLayout.CENTER);
		setJMenuBar(barra);
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Java Look & Feel");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JavaLookAndFeel();
	}
}