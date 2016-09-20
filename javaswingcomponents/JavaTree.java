package javaswingcomponents;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * Los JTree permiten representar a través de un arbol jerárquico
 * Están compuestos de nodos a los que se pueden agregar eventos o acciones
 * 
 */

public class JavaTree extends JFrame implements TreeSelectionListener{
	private JPanel panelPrincipal, panelCartas;
    JTree arbol;
    JScrollPane pDeslizableArbol,pDeslizableArea;
    JTextArea area;
    JPanel panel1,panel2,panel3,panel4,panel5;
    
    //Metodo escuchador al cambiar el nodo seleccionado del arbol
    @Override
	public void valueChanged(TreeSelectionEvent e){
    	DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();
    	CardLayout cardLayout = (CardLayout) panelCartas.getLayout();
    			
		if (nodoSeleccionado.getUserObject().equals("Archivo1")){
			//Muestra el panel1
			cardLayout.show(panelCartas, "Panel1");
		}
		if (nodoSeleccionado.getUserObject().equals("Archivo2")){
			//Muestra el panel2
			cardLayout.show(panelCartas, "Panel2");
		}
		if (nodoSeleccionado.getUserObject().equals("Archivo3")){
			//Muestra el panel3
			cardLayout.show(panelCartas, "Panel3");
		}
		if (nodoSeleccionado.getUserObject().equals("Archivo4")){
			//Muestra el panel4
			cardLayout.show(panelCartas, "Panel4");
		}
		if (nodoSeleccionado.getUserObject().equals("Archivo5")){
			//Muestra el panel5
			cardLayout.show(panelCartas, "Panel5");
		}
		
		area.append("Ruta: ");
		//Obtenemos la ruta seleccionada
		TreePath rutaSeleccionada = e.getPath();
		//Se almacena nodo por nodo en un vector
		Object [] nodos = rutaSeleccionada.getPath();
		//Se recorre para agregarlo al area de texto
		for (int i=0; i<nodos.length;i++){
			Object nodo=nodos[i];
			area.append(nodo.toString()+" / ");
		}
		area.append("\n");
	}

    public JavaTree(){
    	//Creación de nodo principal
        DefaultMutableTreeNode carpetaRaiz = new DefaultMutableTreeNode("Carpeta");
        //Creación del modelo por defecto del arbol
        DefaultTreeModel modelo = new DefaultTreeModel(carpetaRaiz);
        //Creación del arbol a través del modelo
        arbol = new JTree(modelo);
        //Evento escuchador de selección de un componente del arbol
        arbol.getSelectionModel().addTreeSelectionListener(this);
        
        //Creación de nodo a manera de rama del arbol
        DefaultMutableTreeNode subCarpeta = new DefaultMutableTreeNode("SubCarpeta");
        //Creación de nodo a manera de hoja del arbol
        DefaultMutableTreeNode archivo1 = new DefaultMutableTreeNode("Archivo1");
        DefaultMutableTreeNode archivo2 = new DefaultMutableTreeNode("Archivo2");
        //Agregar rama y hojas al nodo principal en la posición 0, 1 y 2
        modelo.insertNodeInto(subCarpeta, carpetaRaiz, 0);
        modelo.insertNodeInto(archivo1, carpetaRaiz, 1);
        modelo.insertNodeInto(archivo2, carpetaRaiz, 2);
        
        //Creación de hojas
        DefaultMutableTreeNode archivo3 = new DefaultMutableTreeNode("Archivo3");
        DefaultMutableTreeNode archivo4 = new DefaultMutableTreeNode("Archivo4");
        DefaultMutableTreeNode archivo5 = new DefaultMutableTreeNode("Archivo5");
        //Agregar hojas creadas a la rama Subcarpeta en la posición 0, 1 y 2
        modelo.insertNodeInto(archivo3, subCarpeta, 0);
        modelo.insertNodeInto(archivo4, subCarpeta, 1);
        modelo.insertNodeInto(archivo5, subCarpeta, 2);
        
        //Agregar arbol a un panel deslizable
        pDeslizableArbol = new JScrollPane(arbol);
        
        //Creación de paneles con colores de fondo
        panel1 = new JPanel();
		panel1.setBackground(Color.white);	
		panel2 = new JPanel();
		panel2.setBackground(Color.black);
		panel3 = new JPanel();
		panel3.setBackground(Color.blue);
		panel4 = new JPanel();
		panel4.setBackground(Color.gray);
		panel5 = new JPanel();
		panel5.setBackground(Color.cyan);
        
		//Inclusión de paneles a panel de cartas
        panelCartas = new JPanel();
        panelCartas .setLayout(new CardLayout());
        panelCartas.add(panel1, "Panel1");
        panelCartas.add(panel2, "Panel2");
        panelCartas.add(panel3, "Panel3");
        panelCartas.add(panel4, "Panel4");
        panelCartas.add(panel5, "Panel5");
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(1, 2));
        panelPrincipal.add(pDeslizableArbol);
        panelPrincipal.add(panelCartas);
        
        area = new JTextArea();
        pDeslizableArea = new JScrollPane(area);
        
        add(panelPrincipal);
        add(pDeslizableArea);
        setLayout(new GridLayout(2, 1));
        setSize(340,300);
        setTitle("Java Tree");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	public static void main(String[] args){
		new JavaTree();
	}
}