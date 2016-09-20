package javaswingcomponents;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * JFileChooser permite navegar por los archivos del disco a través de una ventana prediseñada
 * Permite navegar a traves de ventana para guardar o abrir archivos
 * 
 */

public class JavaFileChooser extends JFrame implements ActionListener{
	JPanel pTexto, pArea, pBotones;
	JLabel lTitulo;
	JTextArea area;
	JScrollPane panelDeslizable;
	JButton bAbrir, bGuardar;
	JFileChooser selectorArchivos;
	
	@Override
	public void actionPerformed(ActionEvent ae){
		String str = ae.getActionCommand();
		if(str.equals("Abrir")){
			String texto="";
			//Se crea el objeto selector de archivos
			selectorArchivos = new JFileChooser();
			//Se muestra el selector de archivos de tipo abrir
			selectorArchivos.showOpenDialog(this);
			//Se obtiene el archivo seleccionado
			File archivo = selectorArchivos.getSelectedFile();
			if(archivo != null){
				area.setText("");
				try{
					FileReader lectorArchivo = new FileReader(archivo);
					BufferedReader lectorBuffer = new BufferedReader(lectorArchivo);
					while((texto = lectorBuffer.readLine())!=null){
						area.append(texto+ "\n");
				    }
				    lectorBuffer.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(this, "Error al leer el archivo "+e, "Error", 0);
				}
			}
		}
		if(str.equals("Guardar")){
			String texto="";
			//Se crea el objeto selector de archivos
			selectorArchivos = new JFileChooser();
			//Se muestra el selector de archivos de tipo guardar
			selectorArchivos.showSaveDialog(this);
			//Se obtiene el archivo seleccionado
			File archivo = selectorArchivos.getSelectedFile();
			if(archivo!=null){
				try{
					FileWriter escritorArchivos=new FileWriter(archivo+".txt");
					escritorArchivos.write(area.getText());
					escritorArchivos.close();
					JOptionPane.showMessageDialog(this, "Archivo guardado con éxito");
				}catch(Exception e){
					JOptionPane.showMessageDialog(this, "Error al guardar el achivo "+e, "Error",0);
				}
			}
		}
	}
	
	public JavaFileChooser(){
		lTitulo = new JLabel("Lector y creador de textos JAVA");
		pTexto = new JPanel();
		pTexto.add(lTitulo);
		
		area = new JTextArea();
		panelDeslizable = new JScrollPane(area);
		pArea = new JPanel();
		pArea.setLayout(new BoxLayout(pArea, BoxLayout.X_AXIS));
		pArea.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		pArea.add(panelDeslizable);
		
		bAbrir = new JButton("Abrir");
		bAbrir.addActionListener(this);
		bGuardar = new JButton("Guardar");
		bGuardar.addActionListener(this);
		pBotones = new JPanel();
		pBotones.add(bAbrir);
		pBotones.add(bGuardar);
		
		add(pTexto, BorderLayout.NORTH);
		add(pArea, BorderLayout.CENTER);
		add(pBotones, BorderLayout.SOUTH);
		
		setSize(450,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("JavaFileChooser");
		setVisible(true);
	}
	public static void main(String[] args) {
		new JavaFileChooser();
	}
}