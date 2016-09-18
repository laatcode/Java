package layoutmanager;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * GridLayout permite organzar los componentes a través de una cuadrícula
 * Por la cantidad de filas y columnas
 * Los componentes se ajustan al tamaño del area de su contenedor
 * 
 */
public class JavaGridLayout extends JFrame{
	
	JButton boton1, boton2, boton3, boton4, boton5, boton6;
	
	public JavaGridLayout(){
		boton1 = new JButton("Botón 1");
		boton2 = new JButton("Botón 2");
		boton3 = new JButton("Botón 3");
		boton4 = new JButton("Botón 4");
		boton5 = new JButton("Botón 5");
		
		//Agregar componetes al contenedor
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
		
		//Configurar diseño de JFrame a GridLayout
		setLayout(new GridLayout(3, 2));	//En los parametros se puede controlar la catidad de filas, columnas y la distancia de los componentes
		setLocationRelativeTo(null);
		setSize(300,300);
		setTitle("Java Grid Layout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JavaGridLayout();
	}
}