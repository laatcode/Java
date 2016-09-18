package layoutmanager;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * FlowLayout es el dise�o por defecto de los JPanel
 * Permite organzar los componentes en orden secuencial uno detras de otro
 * Los componentes se ajustan al tama�o propio del componente
 * 
 */
public class JavaFlowLayout extends JFrame{
	
	JButton boton1, boton2, boton3, boton4, boton5;
	
	public JavaFlowLayout(){
		boton1 = new JButton("Bot�n 1");
		boton2 = new JButton("Bot�n 2");
		boton3 = new JButton("Bot�n 3");
		boton4 = new JButton("Bot�n 4");
		boton5 = new JButton("Bot�n 5");
		
		//Agregar componetes al contenedor
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
		
		//Configurar dise�o de JFrame a FlowLayout
		setLayout(new FlowLayout());	//En los parametros se puede controlar la alineaci�n y la distancia de los componentes
		setLocationRelativeTo(null);
		setSize(300,300);
		setTitle("Java Flow Layout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JavaFlowLayout();
	}
}