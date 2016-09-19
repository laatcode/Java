package layoutmanager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * GridLayout permite organzar los componentes a través de una cuadrícula
 * Por la cantidad de filas y columnas
 * Los componentes se ajustan al tamaño del area de su contenedor
 * 
 */
public class JavaGridBagLayout extends JFrame{
	
	JPanel panel;
	JLabel etiqueta;
	JTextField campoTexto;
	JTextArea areaTexto;
	JScrollPane panelDeslizable;
	JButton bEnviar, bAceptar, bCancelar, boton4, boton5, boton6;
	
	public JavaGridBagLayout(){
		
		panel = new JPanel(); 								//Creación de panel para ubicar los componentes con mejor orden  
		panel.setLayout(new GridBagLayout());				//Configurar el diseño del panel a GridBagLayout
		
		/*Creación del componente de restricciones para el diseño, en este caso usamos uno solo,
		 *razón por al cual hay que redefinirlo por cada componente, pero pueden ser usados varios*/
		GridBagConstraints constraints=new GridBagConstraints();
		
		etiqueta = new JLabel("Etiqueta");
		constraints.gridx = 0; 								// Ubicacion en x.
		constraints.gridy = 0; 								// Ubicacion en Y
		constraints.gridwidth = 1; 							// Cantidad de columnas que ocupa.
		constraints.gridheight = 1; 						// Cantidad de filas que ocupa.
		constraints.weightx = 0.0; 							//Crecimiento exponencial del componente en x
		constraints.weighty = 0.0; 							//Crecimiento exponencial del componente en y
		constraints.fill = GridBagConstraints.NONE; 		//Hacia donde crece puede ser horizontal, vertical, ambos o ninguno
		constraints.insets = new Insets( 20,20,0,0 );		//Distancia Arriba, izquierda, abajo, derecha
		panel.add(etiqueta, constraints); 					//Agregar componente al contenedor
		
		campoTexto = new JTextField();
		constraints.gridx = 1; 								// Ubicacion en x.
		constraints.gridy = 0; 								// Ubicacion en Y
		constraints.gridwidth = 3; 							// Cantidad de columnas que ocupa.
		constraints.gridheight = 1; 						// Cantidad de filas que ocupa.
		constraints.weightx = 1.0; 							//Crecimiento exponencial del componente en x
		constraints.weighty = 0.0; 							//Crecimiento exponencial del componente en y
		constraints.fill = GridBagConstraints.HORIZONTAL; 	//Hacia donde crece puede ser horizontal, vertical, ambos o ninguno
		constraints.insets = new Insets( 20,10,0,0 );		//Distancia Arriba, izquierda, abajo, derecha
		panel.add(campoTexto, constraints); 				//Agregar componente al contenedor
		
		bEnviar = new JButton("Enviar");
		constraints.gridx = 4; 								// Ubicacion en x.
		constraints.gridy = 0; 								// Ubicacion en Y
		constraints.gridwidth = 1; 							// Cantidad de columnas que ocupa.
		constraints.gridheight = 1; 						// Cantidad de filas que ocupa.
		constraints.weightx = 0.0; 							//Crecimiento exponencial del componente en x
		constraints.weighty = 0.0; 							//Crecimiento exponencial del componente en y
		constraints.fill = GridBagConstraints.NONE; 		//Hacia donde crece
		constraints.insets = new Insets( 20,10,0,20 );		//Distancia Arriba, izquierda, abajo, derecha
		panel.add(bEnviar, constraints);
		
		areaTexto = new JTextArea();
		panelDeslizable = new JScrollPane(areaTexto);
		constraints.gridx = 0; 
		constraints.gridy = 1; 
		constraints.gridwidth = 5;
		constraints.gridheight = 3;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets( 10,20,0,20 );
		panel.add(panelDeslizable, constraints);
		
		bAceptar = new JButton("Aceptar");
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets( 10,10,20,10 );
		panel.add(bAceptar, constraints);
		
		bCancelar = new JButton("Cancelar");
		constraints.gridx = 3;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets( 10,10,20,10 );
		panel.add(bCancelar, constraints);
		
		add(panel);												//Adición del panel a la ventana principal
		
		setLocationRelativeTo(null);
		setSize(400,300);
		setTitle("Java GridBagLayout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JavaGridBagLayout();
	}
}