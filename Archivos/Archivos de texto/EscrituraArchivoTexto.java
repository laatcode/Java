import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * La clase FileWriter permite escribir archvivos de caracteres.
 * El constructor de esta clase supone que la codificaci�n de caracteres predeterminada
 * y el tama�o predeterminado del b�fer de bytes son aceptables.
 * Para especificar estos valores, puede construir un OutputStreamWriter en un FileOutputStream.
 * 
 * La clase PrintWriter Imprime las representaciones formateadas de objetos en una secuencia de salida de texto (.
 * Esta clase implementa todos los m�todos de impresi�n encontrados en PrintStream.
 * 
 */
public class EscrituraArchivoTexto{
	public static void main(String[] args){
        FileWriter archivo = null;
        PrintWriter pw = null;
        try{
        	//Crea el archivo, si el archivo existe, escribe al final de su contenido
            archivo = new FileWriter("D:/archivoSalida.txt", true);
            //Crea un objeto PrintWriter, sin realizar vaciado autom�tico de linea, con el archivo especificado.
            pw = new PrintWriter(archivo);

            for (int i = 0; i < 10; i++){
            	//Escribe linea a linea sobre el archivo
            	pw.println("Linea " + i);
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }finally{
        	try{
        		archivo.close();
        		if(archivo != null){
        			System.out.println("Archivo creado correctamente");
        		}
        	}catch(Exception e){
        		System.out.println("Error al cerrar el archivo: "+e);
        	}
        }
    }
}