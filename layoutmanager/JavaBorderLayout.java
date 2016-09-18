package layoutmanager;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * BorderLayout, es el diseño por defecto de JFrame
 * Permite organzar los componentes a través de  puntos cardinales
 * Norte, Sur, Este, Oeste y Centro
 * Los componentes se ajustan al tamaño del area de su contenedor
 * 
 */
public class JavaBorderLayout extends JFrame{
	
	JButton boton1, boton2, boton3, boton4, boton5;
	
	public JavaBorderLayout(){
		boton1 = new JButton("Norte");
		boton2 = new JButton("Sur");
		boton3 = new JButton("Este");
		boton4 = new JButton("Oeste");
		boton5 = new JButton("Centro");
		
		//Agregar componetes al contenedor
		this.add(boton1, BorderLayout.NORTH);
		this.add(boton2, BorderLayout.SOUTH);
		this.add(boton3, BorderLayout.EAST);
		this.add(boton4, BorderLayout.WEST);
		this.add(boton5, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setSize(300,300);
		setTitle("Java Border Layout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JavaBorderLayout();
	}

}
