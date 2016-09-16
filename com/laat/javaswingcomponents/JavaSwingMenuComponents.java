package com.laat.javaswingcomponents;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * Los componentes de men� son elementos que permiten
 * crear una barra de menu con diversas opciones y personalizaci�n.
 * 
 */
public class JavaSwingMenuComponents extends JFrame{
	
	JMenuBar barraMenu;
	JMenu menu1, menu2, menu3;
	JMenuItem itemMenu1, itemMenu2, itemMenu3, itemMenu4, itemMenu5;
	JCheckBoxMenuItem itemCajaSeleccion;
	JRadioButtonMenuItem itemRadioBoton;
	JPopupMenu menuEmergente;
	JSeparator separador;

	
	public JavaSwingMenuComponents(){
		
		//Creaci�n de los componentes
		itemMenu1 = new JMenuItem("Item1");					//Crear item de menu
		itemMenu2 = new JMenuItem("Item2");
		itemMenu3 = new JMenuItem("Item3");
		itemMenu4 = new JMenuItem("Item4");
		itemMenu5 = new JMenuItem("Item5");
		
		itemCajaSeleccion = new JCheckBoxMenuItem("Item caja selecci�n");	//Crear item de caja de selecci�n
		itemRadioBoton = new JRadioButtonMenuItem("Item radio bot�n");		//Crear item de radio bot�n
		
		separador = new JSeparator();						//Crear separador
		
		menu1 = new JMenu("Menu1");						//Crear Menu
		menu2 = new JMenu("Menu2");
		menu3 = new JMenu("Menu3");
		
		//Agregar componentes al menu, el orden en el que sean agregados ser� en el que se visualicen
		menu1.add(itemMenu1);							//Agregar item a menu
		menu1.add(itemCajaSeleccion);						//Agregar item de caja de selecci�n al menu
		menu1.add(itemRadioBoton);
		menu1.add(menu2);							//Agregar men�3 dentro del men� 1
		menu1.add(separador);							//Agregar Separador al menu
		menu1.add(itemMenu2);
		
		//Agregar componentes al Menu2, el cual se encuentra dentro del men� 1
		menu2.add(itemMenu3);
		menu2.add(itemMenu4);
		
		menu3.add(itemMenu5);
		
		barraMenu = new JMenuBar();						//Crear barra de men�
		
		//Agregar menu a la barra
		barraMenu.add(menu1);
		barraMenu.add(menu3);
		
		//Agregar componente al contenedor por defecto de la ventana
		setJMenuBar(barraMenu);
		
		setLayout(null);							//Declarar el dise�o libre o Nulo
		setLocationRelativeTo(null);						//Centrar ventana respecto al componente padre
		setSize(310,170);							//Tama�o de ventana (Ancho, Alto)
		setTitle("JavaSwingMenuComponents");						//T�tulo de la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);				//Finalizar el programa al cerrar la ventana		
		setVisible(true);							//Visibilidad de la ventana
	}
	
	public static void main(String[] args) {
		new JavaSwingMenuComponents();
	}
}