package javaswingcomponents;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JavaTable extends JFrame implements ActionListener{
	
	JPanel pDatos, pLimpiar;
	JLabel lNombre;
	JTextField tNombre;
	JComboBox<String> cEstado;
	JButton bEnviar, bEditar, bEliminar, bLimpiar;
	JTable tabla;
	DefaultTableModel modeloTabla;
	JScrollPane scroll;
	int contador = 1;
	
	//Eventos de los componentes
	@Override
	public void actionPerformed(ActionEvent ae){
		String str = ae.getActionCommand();
		if(str.equals("Enviar")){
			//Se almacenan los datos a adicionar en la tabla en un vector
			String[] datos = {contador+"", tNombre.getText(), cEstado.getSelectedItem().toString()};
			//Se agrega el vector a la tabla
			modeloTabla.addRow(datos);
			tNombre.setText("");
			contador++;
		}
		if(str.equals("Editar")){
			//Se valida que se haya seleccionado al menos una fila de la tabla
			if(tabla.getSelectedRow()!=-1){
				//Se coleccionan todas las filas seleccionadas en un vector
				int[] filas = tabla.getSelectedRows();
				//Se recorre el vector 
				for(int i =filas.length; i>0; i--){
					//se evalua si la columna seleccionada es igual a 1 (Nombre)
					if(tabla.getSelectedColumn()==1){
						//Se modifica el registro con posición (filas[i-1], 1) con el texto del campo tNombre
						modeloTabla.setValueAt(tNombre.getText(), filas[i-1], 1);
					}
					//se evalua si la columna seleccionada es igual a 2 (Estado)
					if(tabla.getSelectedColumn()==2){
						//Se modifica el registro con posición (filas[i-1], 2) con el texto seleccionado del campo cEstado
						modeloTabla.setValueAt(cEstado.getSelectedItem(), filas[i-1], 2);
					}
				}
			}else{
				JOptionPane.showMessageDialog(this, "Debe seleccionar al menos una fila de la tabla");
			}
		}
		if(str.equals("Eliminar")){
			//Se valida que se haya seleccionado al menos una fila de la tabla
			if(tabla.getSelectedRow()!=-1){
				//Se almacena en un vector todas las filas seleccionadas de la tabla
				int[] filas = tabla.getSelectedRows();
				for(int i =filas.length; i>0; i--){
					//Se elimina una a una la fila con numero i-1
					modeloTabla.removeRow(filas[i-1]);
				}
			}else{
				JOptionPane.showMessageDialog(this, "Debe seleccionar al menos una fila de la tabla");
			}
		}
		if(str.equals("Limpiar Tabla")){
			//Se asigna a i la cantidad de filas totales que posee la tabla y se recorre
			for(int i = tabla.getRowCount(); i>0;i--){
				//Se elimina una a una la fila con numero i-1
				modeloTabla.removeRow(i-1);
			}
			contador = 1;
		}
	}
	
	public JavaTable(){
		
		pDatos = new JPanel();
		lNombre = new JLabel("Nombre:");
		tNombre = new JTextField(20);
		String[] estado = {"", "Activo", "Inactivo"};
		cEstado = new JComboBox<String>(estado);
		bEnviar = new JButton("Enviar");
		bEnviar.addActionListener(this);
		bEditar = new JButton("Editar");
		bEditar.addActionListener(this);
		bEliminar = new JButton("Eliminar");
		bEliminar.addActionListener(this);
		
		pDatos.add(lNombre);
		pDatos.add(tNombre);
		pDatos.add(cEstado);
		pDatos.add(bEnviar);
		pDatos.add(bEditar);
		pDatos.add(bEliminar);
		
		//Se crea un vector con el nombre de las columnas que tendrá la tabla
		String[] nombreColumnas = {"No.", "Nombre", "Estado"};
		//Se crea el modelo de la tabla por defecto
		modeloTabla = new DefaultTableModel(nombreColumnas, 0){
			//Metodo para no permitir edición sobre la tabla
			public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        //Se crea la tabla con los atributos definidos en el modelo
		tabla = new JTable(modeloTabla);
		//Se asigna la tabla a un JScrollPane
		scroll = new JScrollPane(tabla);
		
		pLimpiar = new JPanel();
		bLimpiar = new JButton("Limpiar Tabla");
		bLimpiar.addActionListener(this);
		pLimpiar.add(bLimpiar);
		
		add(pDatos, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(pLimpiar, BorderLayout.SOUTH);
		
		setSize(700,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new JavaTable().setVisible(true);
	}
}