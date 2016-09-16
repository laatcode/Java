package com.laat.javaswingcomponents;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * Los componentes at�micos son elementos que no pueden
 * almacenar otros objetos o componentes gr�ficos.
 * 
 */
public class JavaSwingAtomicComponents extends JFrame{
	JLabel etiqueta;
	JButton boton;
	JComboBox<String> combo;
	JCheckBox cajaSeleccion;
	JRadioButton radioBoton;
	JToggleButton botonActivacion;
	JSlider deslizador;
	JSpinner rotador;
	JProgressBar barraProgreso;
	
	public JavaSwingAtomicComponents(){
		
		//Creaci�n de los componentes
		etiqueta = new JLabel("Etiqueta");						//Permite crear etiquetas con el texto que se le indique
		etiqueta.setBounds(10,10,50,20);						//Ubicaci�n del componnete con par�metros (ubicaci�n en X, ubicaci�n en Y, Ancho, Alto)
		cajaSeleccion = new JCheckBox("Caja selecci�n");				//Crea una caja de selecci�n
		cajaSeleccion.setBounds(70, 10, 110, 20);
		radioBoton = new JRadioButton("Radio Bot�n");					//Crea un radio bot�n
		radioBoton.setBounds(190, 10, 110, 20);
		combo = new JComboBox<String>();						//Crea una caja de seledcci�n de tipo String
		combo.setBounds(10,40,130,20);
		combo.addItem("");								//Agregar item a la caja de selecci�n
		combo.addItem("Item 1");
		combo.addItem("Item 2");
		combo.addItem("Item 3");
		rotador = new JSpinner();							//Crea un rotador
		rotador.setBounds(150, 40, 100, 20);
		boton = new JButton("Bot�n");							//Crea un bot�n con el texto que se le indique
		boton.setBounds(10, 70, 130, 20);
		botonActivacion = new JToggleButton("Bot�n activaci�n");			//Crea un bot�n de activaci�n
		botonActivacion.setBounds(150, 70, 130, 20);
		deslizador = new JSlider(0,100);						//Crea un deslizador de 0 a 100
		deslizador.setBounds(10, 100, 130, 20);
		barraProgreso = new JProgressBar(0, 100);					//Crea una barra de progreso de 0 a 100
		barraProgreso.setBounds(150, 100, 130, 20);
		
		
		//Agregar componente al contenedor por defecto
		add(etiqueta);
		add(boton);
		add(combo);
		add(cajaSeleccion);
		add(radioBoton);
		add(botonActivacion);
		add(deslizador);
		add(rotador);
		add(barraProgreso);
		
		setLayout(null);								//Declarar el dise�o libre o Nulo
		setLocationRelativeTo(null);							//Centrar ventana respecto al componente padre
		setSize(310,170);								//Tama�o de ventana (Ancho, Alto)
		setTitle("JavaSwingAnatomicComponents");					//T�tulo de la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);					//Finalizar el programa al cerrar la ventana		
		setVisible(true);								//Visibilidad de la ventana
	}
	
	public static void main(String[] args) {
		new JavaSwingAtomicComponents();
	}
}