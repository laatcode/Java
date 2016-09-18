package javaswingcomponents;

import java.awt.Color;
import java.util.Date;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * Los componentes de texto son elementos que permiten el ingreso
 * de información al programa a través de componentes gráficos.
 * 
 */
public class JavaSwingTextComponents extends JFrame{
	
	JTextField campoTexto;
	JFormattedTextField campoTextoFormateado;
	JPasswordField campoContrasena;
	JTextArea areaTexto;
	JScrollPane panelDesplazamiento, panelDesplazamiento2, panelDesplazamiento3;
	JEditorPane panelEditor;
	JTextPane panelTexto;
	StyleContext sc;
	DefaultStyledDocument doc;
	
	
	public JavaSwingTextComponents(){
		
		//Creación de los componentes
		campoTexto = new JTextField(20);										//Crea un campo de texto
		campoTexto.setToolTipText("Campo de texto");									//Muestra un texto de sugerencia al colocar el mouse sobre el componente
		campoTexto.setBounds(10, 10, 180, 20);										//Ubicación del componnete con parámetros (ubicación en X, ubicación en Y, Ancho, Alto)
		campoTextoFormateado = new JFormattedTextField(new Date());							//Crea un campo de texto con formato de fecha y asigna la fecha de hoy. Al perder el foco, el componente evalua el valor ingresado y lo intenta convertir al formato indicado, si no puede, asigna el último valor válido ingresado 
		campoTextoFormateado.setBounds(10, 40, 180, 20);
		campoContrasena = new JPasswordField();										//Crea un campo de contraseña donde al ingresar datos, no es visible el valor ingresado, por defecto es reemplazado por puntos
		campoContrasena.setEchoChar('*');										//Permite modificar los puntos por defecto al caracter que se desee colocar
		campoContrasena.setBounds(10, 70, 180, 20);
		areaTexto = new JTextArea("Texto de prueba\nEsta es una descripción"						//Crea un area de texto
		+ "para probar el panel de desplazamiento\nNo es necesario crear el"
		+ "area de texto con algun texto por defecto");							
		panelDesplazamiento = new JScrollPane(areaTexto);								//Crea un panel de desplazamiento cuando el contenido del componente que contiene sobrepasa las dimensiones (Es un componente atómico, pero es más usado en campos de tetxo)
		panelDesplazamiento.setBounds(10,100, 180, 60);									//La ubicación se agrega al panel y no al area debido a que es el panel el que contiene el area de texto
		panelEditor = new JEditorPane();										//Crea un area de texto con formato, los cuales puedens ser text/html, text/rtf o por defecto text/plain
		panelEditor.setContentType("text/html");									//Se configura para contener HTML
		panelEditor.setText("<b>hola</b><br>" + "<i>adios</i><br>"+							//Añadir texto en formato HTML. No permite añadir texto poco a poco.
							"<font face=\"arial\">fuente arial</font><br>"+
							"<font face=\"courier\">fuente courier</font><br>"+
							"<font size=\"24\">fuente grande</font><br>" +
							"<font color=\"red\">color rojo</font><br>" +
							"<img src=\"http://www.google.com.co/images/branding/googleg/1x/googleg_standard_color_128dp.png\">");
		panelDesplazamiento2 = new JScrollPane(panelEditor);
		panelDesplazamiento2.setBounds(10, 170, 180, 80);
		
		//Crea el contexto de estilo para el panel de texto y un estilo por defecto
		sc = new StyleContext();
		doc = new DefaultStyledDocument(sc);
		
		panelTexto = new JTextPane(doc);										//Crea el panel de texto con el estilo por defecto
		panelDesplazamiento3 = new JScrollPane(panelTexto);
		panelDesplazamiento3.setBounds(10,260, 180, 80);
		
		Style estiloTitulo = sc.addStyle("Título", null);								//Crear estilo
		estiloTitulo.addAttribute(StyleConstants.Foreground, Color.red);						//Asignar atributo Color de letra rojo al estilo
		estiloTitulo.addAttribute(StyleConstants.FontSize, new Integer(19));						//Asignar atributo Tamaño de la letra al estilo
		estiloTitulo.addAttribute(StyleConstants.FontFamily, "serif");							//Asignar atributo Tipo de letra al estilo
		estiloTitulo.addAttribute(StyleConstants.Bold, new Boolean(true));						//Asignar atributo Activar negrita al estilo
	    String textoTitulo = "Lorem Ipsum";
	    String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
	    + " Vestibulum fermentum nulla vitae orci eleifend, non pulvinar nunc "
	    + "tincidunt. Nam a felis ac justo tincidunt luctus. Proin ac ultrices sem."
	    + " Maecenas sagittis eu massa non rhoncus. Sed eu posuere lorem, non tempus"
	    + " dui. Duis sed nisl nec ligula imperdiet imperdiet interdum et neque. "
	    + "Maecenas metus ligula, convallis sit amet mi ac, commodo viverra nisl. "
	    + "Phasellus dui risus, rutrum non ultrices ut, pellentesque vitae mi. "
	    + "Suspendisse potenti. Donec eu rutrum ex. Donec vitae pulvinar ipsum,"
	    + " sed bibendum mauris.";
	    
	    try{
	    	doc.insertString(0, textoTitulo, null);										//Agrega la variable tTitulo al documento desde la posición 0 y sin atributos, el primer parámetro siempre debe ser mayor o igual a 0
	    	doc.insertString(12, texto, null);										//Agrega la variable texto al documento desde la posición 12 que es donde acaba el título y sin atributos.
	    	doc.setCharacterAttributes(0, 9, estiloTitulo, false);								//Aplicar el estiloTitulo desde la posición 0 hasta la 9 y un valor boolean por si se desea reeplazar atributos existentes o fusionarlos
	    }catch(BadLocationException ble){
	    	System.out.println("Error al asignar el estilo: "+ble);
	    }
		
		//Agregar componente al contenedor por defecto
		add(campoTexto);
		add(campoTextoFormateado);
		add(campoContrasena);
		add(panelDesplazamiento);											//Se agrega el panel de desplazamiento y no el area debido a que el panel es el que contiene el area
		add(panelDesplazamiento2);
		add(panelDesplazamiento3);
		
		setLayout(null);												//Declarar el diseño libre o Nulo
		setLocationRelativeTo(null);											//Centrar ventana respecto al componente padre
		setSize(310,400);												//Tamaño de ventana (Ancho, Alto)
		setTitle("JavaSwingTextComponents");										//Título de la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);									//Finalizar el programa al cerrar la ventana		
		setVisible(true);												//Visibilidad de la ventana
	}
	
	public static void main(String[] args) {
		new JavaSwingTextComponents();
	}
}