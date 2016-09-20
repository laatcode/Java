package javaswingcomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * JFileChooser permite escoger un color a través de diferentes paletas prediseñadas
 * 
 */

public class JavaColorChooser extends JFrame implements ActionListener{
	JPanel pFondo, pBoton;
	JButton boton;
	
	public void actionPerformed(ActionEvent ae){
		String str = ae.getActionCommand();
		if(str.equals("Color")){
			//Se crea variable color
			Color color;
			//Se almacena en la variable el resultado del color seleccionado, se carga por defecto el color negro
			color = JColorChooser.showDialog(this, "Seleccione su color favorito", Color.black);
			//Se asigna como color de fondo al panel
			pFondo.setBackground(color);
		}
	}
	
	public JavaColorChooser(){
		pFondo = new JPanel();
		boton = new JButton("Color");
		boton.addActionListener(this);
		pBoton = new JPanel();
		pBoton.add(boton);
		
		add(pFondo, BorderLayout.CENTER);
		add(pBoton, BorderLayout.SOUTH);
		
		setSize(400,300);
		setTitle("JavaColorChooser");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JavaColorChooser();
	}
}