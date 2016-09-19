package layoutmanager;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * CardLayout permite visualizar un compnente a la vez, dejando los demás ocultos como si fueran cartas de juego
 * Los componentes se mantienen uno detrás de otro visualizando soloamente uno.
 * Los componentes se ajustan al tamaño del area de su contenedor
 * 
 */
public class JavaCardLayout extends JFrame implements ItemListener{
	
	JPanel panelCartas, panelCajaCombo, panelTexto, panelBotones;
	JComboBox<String> cajaCombo;
	JTextField campoTexto;
	JButton boton1, boton2, boton3;
	
	public JavaCardLayout(){
		cajaCombo = new JComboBox<String>();
		cajaCombo.addItem("Campo de texto");
		cajaCombo.addItem("Botones");
		cajaCombo.addItemListener(this);
		panelCajaCombo = new JPanel();							//Panel para la caja de combo, por defecto FlowLayout
		panelCajaCombo.add(cajaCombo);
		
		campoTexto = new JTextField(20);
		panelTexto = new JPanel();								//Panel para la caja de texto, por defecto FlowLayout
		panelTexto.add(campoTexto);
		
		boton1 = new JButton("Botón 1");
		boton2 = new JButton("Botón 2");
		boton3 = new JButton("Botón 3");
		panelBotones = new JPanel();
		panelBotones.add(boton1);
		panelBotones.add(boton2);
		panelBotones.add(boton3);
		
		panelCartas = new JPanel();								//Panel de cartas para visualizar componentes, uno a la vez
		panelCartas .setLayout(new CardLayout());				//Configuración del panel para diseño de cartas
		panelCartas.add(panelTexto, "Campo de texto");			//Se agrega panel de texto a panel de cartas con etiqueta "Campo de texto"
		panelCartas.add(panelBotones, "Botones");				//Se agrega panel de botones a panel de cartas con etiqueta "Botones"
		
		//Agregar componetes al contenedor general (Ventana)
		add(panelCajaCombo, BorderLayout.PAGE_START);
		add(panelCartas, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setSize(300,200);
		setTitle("Java Card Layout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setVisible(true);
	}
	
	/*Se sobre escribe el evento de ItemListener para reconozca el texto de la caja de combo
	 * con el fin de que al cambiar el estado de la caja de combo, se visualuce en el panel
	 * de cartas, el panel correspondiente a la etiqueta igual al de la caja de combo
	 */
	@Override
	public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(panelCartas.getLayout());
        cl.show(panelCartas, (String)evt.getItem());
    }
	
	public static void main(String[] args) {
		new JavaCardLayout();
	}
}