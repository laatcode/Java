package javaswingcomponents;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * JList permite visualizar y manipular una lista de objetos.
 * Permite configurar la seleccion de uno o varios elementos a través del método setSelectionMode
 * 
 */

public class JavaList extends JFrame implements ActionListener{
	JPanel pDatos, pListas, pIZ, pBotones;
	JLabel lNombre;
	JTextField tNombre;
	JButton bAgregar, bIzquierda, bDerecha, bEliminar, bBorrarLista;
	JList<String> lista1, lista2;
	DefaultListModel<String> modeloLista1, modeloLista2;
	JScrollPane pDeslizableLista1, pDeslizableLista2;
	
	@Override
	public void actionPerformed(ActionEvent ae){
		String str = ae.getActionCommand();
		if(str.equals("Agregar")){
			//Agregar elemento a la lista
			modeloLista1.addElement(tNombre.getText());
			//Asignar modelo a la lista
			lista1.setModel(modeloLista1);
			tNombre.setText("");
		}
		if(str.equals("Eliminar")){
			if(lista1.getSelectedIndex()>=0){
				int[] indices = lista1.getSelectedIndices();
				for(int i= indices.length; i>0; i--){
					//Eliminar un elemento de la lista a través del indice
					modeloLista1.removeElementAt(indices[i-1]);
				}
			}
			if(lista2.getSelectedIndex()>=0){
				int[] indices = lista2.getSelectedIndices();
				for(int i= indices.length; i>0; i--){
					modeloLista2.removeElementAt(indices[i-1]);
				}
			}
		}
		if(str.equals(">")){
			if(lista1.getSelectedIndex()>=0){
				//Almacenar en valores todos los objetos seleccionados de la lista1
				List<String> valores = lista1.getSelectedValuesList();
				for(int i=0; i<valores.size(); i++){
					modeloLista2.addElement(valores.get(i));
					lista2.setModel(modeloLista2);
				}
				int[] indices = lista1.getSelectedIndices();
				for(int i= indices.length; i>0; i--){
					modeloLista1.removeElementAt(indices[i-1]);
				}
			}
		}
		if(str.equals("<")){
			if(lista2.getSelectedIndex()>=0){
				List<String> valores = lista2.getSelectedValuesList();
				for(int i=0; i<valores.size(); i++){
					modeloLista1.addElement(valores.get(i));
					lista1.setModel(modeloLista1);
				}
				int[] indices = lista2.getSelectedIndices();
				for(int i= indices.length; i>0; i--){
					modeloLista2.removeElementAt(indices[i-1]);
				}
			}
		}
		if(str.equals("Borrar listas")){
			//Borrar todos los elementos de la lista
			modeloLista1.removeAllElements();
			modeloLista2.removeAllElements();
		}
	}
	
	public JavaList(){		
		GridBagConstraints constraints = new GridBagConstraints();
		
		pDatos = new JPanel();
		pDatos.setLayout(new GridBagLayout());
		pListas = new JPanel();
		pListas.setLayout(new GridBagLayout());
		pIZ = new JPanel();
		pIZ.setLayout(new GridLayout(2, 1));
		pBotones = new JPanel();
		pBotones.setLayout(new FlowLayout(1,20,20));
		
		lNombre = new JLabel("Nombre:");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(20,20,0,0 );
		pDatos.add(lNombre, constraints);
		
		tNombre = new JTextField();
		tNombre.addActionListener(this);
		tNombre.setActionCommand("Agregar");
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 6;
		constraints.weightx = 1.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets( 20,10,0,0 );
		pDatos.add(tNombre, constraints);
		
		bAgregar = new JButton("Agregar");
		bAgregar.addActionListener(this);
		constraints.gridx = 7;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(20,10,0,20 );
		pDatos.add(bAgregar, constraints);
		
		//Creación de la lista de tipo String
		lista1 = new JList<String>();
		pDeslizableLista1 = new JScrollPane(lista1);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.gridheight = 4;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(10,20,0,0 );
		pListas.add(pDeslizableLista1, constraints);
		
		lista2 = new JList<String>();
		pDeslizableLista2 = new JScrollPane(lista2);
		constraints.gridx = 5;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.gridheight = 4;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(10,10,0,20 );
		pListas.add(pDeslizableLista2, constraints);
		
		bDerecha = new JButton(">");
		bDerecha.addActionListener(this);
		bIzquierda = new JButton("<");
		bIzquierda.addActionListener(this);
		pIZ.add(bDerecha);
		pIZ.add(bIzquierda);
		
		constraints.gridx = 4;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 2;
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(10,10,10,10);
		pListas.add(pIZ, constraints);
		
		bEliminar = new JButton("Eliminar");
		bEliminar.addActionListener(this);
		bBorrarLista = new JButton("Borrar listas");
		bBorrarLista.addActionListener(this);
		pBotones.add(bEliminar);
		pBotones.add(bBorrarLista);
		
		//Cración del modelo de tipo String
		modeloLista1 = new DefaultListModel<String>();
		modeloLista2 = new DefaultListModel<String>();
		
		add(pDatos, BorderLayout.NORTH);
		add(pListas, BorderLayout.CENTER);
		add(pBotones, BorderLayout.SOUTH);
		setSize(500,400);
		setTitle("Java List");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new JavaList();
	}
}