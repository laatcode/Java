import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * Los Stream son una secuencia ordenada de datos con un determinado origen y destino, normalmente se utilzan en parejas (iniciador, filtro)
 * FileWriter (iniciador): escribe texto en un fichero
 * PrintWriter (filtro): permite convertir a texto variables y objetos para escribirlos en un Writer
 *
 * La clase FileWriter permite escribir archvivos de caracteres.
 * El constructor de esta clase supone que la codificación de caracteres predeterminada
 * y el tamaño predeterminado del búfer de bytes son aceptables.
 * Para especificar estos valores, puede construir un OutputStreamWriter en un FileOutputStream.
 * 
 * La clase PrintWriter Imprime las representaciones formateadas de objetos en una secuencia de salida de texto.
 * Esta clase implementa todos los métodos de impresión encontrados en PrintStream.
 * 
 */
public class EscrituraArchivoTexto{
	public static void main(String[] args){
        FileWriter archivo = null;
        PrintWriter pw = null;
        try{
        	//Crea el archivo, si el archivo existe, escribe al final de su contenido (Stream iniciador)
            archivo = new FileWriter("D:/archivoSalida.txt", true);
            //Crea un objeto PrintWriter, sin realizar vaciado automático de linea, con el archivo especificado (Stream filtro).
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
