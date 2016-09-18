package javaswingcomponents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * Los componentes atómicos son elementos que no pueden
 * almacenar otros objetos o componentes gráficos.
 * No se integra el componente JScrollPane debido a que
 * se puede ver en componentes de texto.
 * 
 */
public class JavaSwingContainerComponents extends JFrame{
	
	JFrame ventana;
	JPanel panel;
	JSplitPane panelDivision;
	JTabbedPane panelPestana;
	JDesktopPane panelEscritorio;
	JInternalFrame ventanaInterna;
	JDialog dialogo;
	JButton boton1, boton2, boton3, boton4, boton5, boton6;

	
	public JavaSwingContainerComponents(){
		
		//Creación de los componentes
		boton1 = new JButton("Ejecutar Ventana Dialogo");
		//Acción para poder ejecutar el componente JDialog
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				class VentanaDialogo extends JDialog{							//Creación de la clase VentanaDialogo que extiende de JDialog
					public VentanaDialogo(JFrame padre){						//Constructor de VentanaDialogo
						super(padre, true);							//Contructor de la super clase para que se comporte como una ventana modal
						setSize(300,200);							//Tamaño de la ventana de dialogo
						setTitle("Ventana Dialogo");						//Título de la ventana de dialogo
						setLocationRelativeTo(padre);						//Ubicación relativa a la ventana padre que la llama.
						setVisible(true);							//Visibilidad de la ventana
					}
				}
				new VentanaDialogo(JavaSwingContainerComponents.this);					//Creación de la instancia de la VentanaDialogo a la cual se le pasa la misma clase para que la reconozca como padre
			}
		});
		boton2 = new JButton("Boton1 de prueba");								
		boton3 = new JButton("Boton2 de prueba");
		boton4 = new JButton("Boton1 de prueba");
		boton5 = new JButton("Boton2 de prueba");
		boton6 = new JButton("Boton2 de prueba");
		
		ventana = new JFrame();											//Creación de ventana
		panel = new JPanel();											//Creación de panel
		panel.setBorder(BorderFactory.createLineBorder(Color.black));						//Borde para poder visualizar el panel, por defecto no trae borde
		panel.setBounds(10, 10, 280, 40);
		panel.add(boton1);											//Agregar botón al panel
		
		
		
		panelDivision = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);						//Creación de panel de división de forma horizontal
		panelDivision.setBounds(10,60, 280, 40);
		panelDivision.add(boton2);										//Asignación de componentes al panel de division
		panelDivision.add(boton3);
		
		panelPestana = new JTabbedPane();									//Crea un panel de pestañas, si se llenan los parametros se puede modificar la posición de las pestañas.
		panelPestana.setBounds(10, 110, 280, 60);
		panelPestana.add("Pestaña1",boton4);									//Agregar pestaña con su respectivo conponente. Usar internamente un contenedor si se desea agregar varios componentes dentro de una pestaña
		panelPestana.add("Pestaña2",boton5);
		
		panelEscritorio = new JDesktopPane();									//Crea un panel escritorio el cual permite crear ventanas internas en su interior
		panelEscritorio.setBounds(10,180,280,100);
		ventanaInterna = new JInternalFrame("Ventana Interna", true, true, true, true);				//Crea una ventana interna (Titulo, modificarTamaño, Cerrable, maximizable, minimizable) Se puede alternar el constructor en el mismo orden
		ventanaInterna.add(boton6);										//Agregar componente a ventana interna
		ventanaInterna.pack();											//Dimensionar la ventana interna según los componentes que posea, es importante hacerlo luego de cargar los componentes. Si no se ejecuta la ventana interna tendrá tamaño 0,0 y no se visualizará
		ventanaInterna.setVisible(true);
		panelEscritorio.add(ventanaInterna);
		
		
		//Agregar componente al contenedor por defecto de la ventana
		ventana.add(panel);
		ventana.add(panelDivision);
		ventana.add(panelPestana);
		ventana.add(panelEscritorio);
		
		
		ventana.setLayout(null);										//Declarar el diseño libre o Nulo
		ventana.setLocationRelativeTo(null);									//Centrar ventana respecto al componente padre
		ventana.setSize(320,350);										//Tamaño de ventana (Ancho, Alto)
		ventana.setTitle("JavaSwingContainerCompnents");							//Título de la ventana
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);							//Finalizar el programa al cerrar la ventana		
		ventana.setVisible(true);										//Visibilidad de la ventana
	}
	
	public static void main(String[] args) {
		new JavaSwingContainerComponents();
	}
}