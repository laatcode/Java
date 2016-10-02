package event;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * Los eventos del mouse, se implementan a través de las interfaces MouseListener y MouseMotionListener.
 *  MouseListener permite controlar cuando el mouse es clickeado, presionado, liberado y cunado el puntero a ingresado o salido de un componente
 *  MouseMotionListener permite controlar cuando el mouse se ha movido dentro de un componente y cuando un componente es arrastrado, es decir, cuando el mouse se mueve mientras se mantiene presionado un botón
 * 
 */

//Se implementan las interfaces requeridas
public class JavaMouseListener extends JFrame implements MouseListener, MouseMotionListener{
	Container panel;
	JPanel panelSuperior;
	JLabel lPosicion;
	JButton boton;
	JTextArea area;
	JScrollPane panelDeslizable;
	Point posicionMouse;
	
	/*
	 * Inicio de metodos de interfaz MouseMotionListener
	 */
	//Evento que controla cuando se arrastra un componente
	@Override
	public void mouseDragged(MouseEvent e) {
	}
	
	//Evento que controla cuando el mouse se mueve dentro de un componente
	@Override
	public void mouseMoved(MouseEvent e) {
		posicionMouse = MouseInfo.getPointerInfo().getLocation();
		lPosicion.setText("Posición del mouse: X:"+posicionMouse.getX()+" Y: "+posicionMouse.getY());
	}
	/*
	 * Fin de metodos de interfaz MouseMotionListener
	 */
	
	/*
	 * Inicio de metodos de interfaz MouseListener
	 */
	//Evento que controla cuando se ha hecho clic en algún botón
	@Override
	public void mouseClicked(MouseEvent e) {
		area.append("Mouse clickeado\n");
	}
	//Evento que controla cuando el cursor del mouse ha entrado en el area de un componente
	@Override
	public void mouseEntered(MouseEvent e) {
		area.append("Mouse ha ingresado\n");
	}
	//Evento que controla cuando el cursor del mouse ha salido del area de un componente
	@Override
	public void mouseExited(MouseEvent e) {
		area.append("Mouse ha salido\n");
	}
	//Evento que controla cuando se ha presionado un botón del mouse
	@Override
	public void mousePressed(MouseEvent e) {
		//Valida si se ha presionado el botón derecho del mouse
		if(e.isMetaDown()){
			area.append("Botón derecho presionado\n");
		}else{
			//Valida si se ha presionado el botón central o de scroll del mouse
			if(e.isAltDown()){
				area.append("Botón central presionado o combinación con tecla alt\n");
			}else{
				//Valida si se ha presionado el botón izquierdo del mouse junto con la tecla shift
				if(e.isShiftDown()){
					area.append("Botón izquierdo presionado con tecla shift\n");
				}else{
					//Si ninguna de las opciones previas cumple las condiciones, entonces se ha presionado el botón derecho y se ejecuta lo que se desea realizar
					area.append("Botón izquierdo presionado\n");
				}
			}
		}
	}
	//Evento que controla cuando el botón se ha liberado
	@Override
	public void mouseReleased(MouseEvent e) {
		area.append("Mouse ha sido liberado\n");
	}
	/*
	 * Fin de metodos de interfaz MouseListener
	 */
	
	public JavaMouseListener(){
		panel=getContentPane();
		setLayout(new GridLayout(2,1));
		//Se obtiene la posición del mouse respecto a la pantalla
		posicionMouse = MouseInfo.getPointerInfo().getLocation();
		lPosicion = new JLabel("Posición del mouse: X:"+posicionMouse.getX()+" Y: "+posicionMouse.getY());
		lPosicion.setBounds(0,10, 220, 20);
		boton = new JButton("Muéveme");
		//Se crea escuchador de eventos de mouse
		boton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            //Metodo de arrastrar un componente
			public void mouseDragged(MouseEvent e) {
            	//Se valida que se haya presionado el botón inquierdo
            	if(!e.isMetaDown()&&!e.isAltDown()&&!e.isAltDown()&&!e.isShiftDown()){
            		posicionMouse = MouseInfo.getPointerInfo().getLocation();
            		//Se asigna la ubicación del botón en donde se encuentre el cursor con base en la ubicación de la ventana  
            		boton.setBounds((int)(posicionMouse.getX()-panel.getLocationOnScreen().getX()), (int)(posicionMouse.getY()-panel.getLocationOnScreen().getY()), 100, 20);
            	}
            }
        });
		boton.setBounds(50,40, 100, 20);
		panelSuperior = new JPanel();
		panelSuperior.setLayout(null);
		panelSuperior.add(lPosicion);
		panelSuperior.add(boton);
		area = new JTextArea();
		panelDeslizable = new JScrollPane(area);
		//Se asigna el escuchador de eventos del mouse a la ventana principal para la interfase MouseListener
		addMouseListener(this);
		//Se asigna el escuchador de eventos del mouse a la ventana principal para la interfase MouseMotionListener
		addMouseMotionListener(this);
		
		add(panelSuperior);
		add(panelDeslizable);
		
		setTitle("Java Mouse Listener");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JavaMouseListener();
	}
}
