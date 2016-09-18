package layoutmanager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * BoxLayout permite organzar los componentes ya sea por filas o columnas seg�n se defina
 * Los componentes se ajustan al tama�o propio del componente
 * 
 */
public class JavaBoxLayout extends JFrame{
	
	JButton boton1, boton2, boton3, boton4, boton5, boton6;
	
	public JavaBoxLayout(){
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
		
		//Configurar dise�o de JFrame a BoxLayout
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));	//En los parametros se le indica el componente que lo contiene y la alineaci�n que se desea, si es horizontal o vertical
		setLocationRelativeTo(null);
		setSize(300,300);
		setTitle("Java Box Layout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JavaBoxLayout();
	}
}