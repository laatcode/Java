import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * La clase File es una representaci�n abstracta de archivo y rutas de directorio
 * 
 * La clase FileReader permite leer archvivos de caracteres.
 * Los constructores de esta clase suponen que la codificaci�n de caracteres predeterminada
 * y el tama�o predeterminado del b�fer de bytes son apropiados.
 * Para especificar estos valores, puede construir un InputStreamReader en un FileInputStream.
 * 
 * La clase BufferedReader permite leer el texto de una secuencia de entrada de caracteres,
 * almacenando en b�fer caracterespara proporcionar una lectura eficiente de caracteres, matrices y l�neas.
 * El tama�o del b�fer puede especificarse, o puede usarse el tama�o predeterminado.
 * El valor predeterminado es lo suficientemente grande para la mayor�a de los prop�sitos.
 * 
 */
public class LecturaArchivoTexto{
	
	public static void main(String[] args) {
		//Declaraci�n de variables
		File archivo;
		FileReader fr=null;
		BufferedReader br;
		
		try{
			//Almacena la ruta del archivo en la variable archivo
			archivo = new File("D:\\archivo.txt");
			//Crea un objeto FileReader con la ruta del archivo a leer
			fr = new FileReader (archivo);
			//Crea un flujo de entrada de caracteres de espacio de memoria(buffer)
	        br = new BufferedReader(fr);
	        
		    // Lectura del archivo
	        String linea;
	        //Se recorre linea a linea el flujo de entrada de caracteres y se almacenan en la variable linea
	        while((linea=br.readLine())!=null){
	        	System.out.println(linea);
	        }
        //Se crea excepci�n si el sistema no encuentra el archivo
		}catch (FileNotFoundException e) {
			System.out.println("El sistema no puede encontrar el archivo");
		}
		//Se crea Excepci�n si el sistema encuentra cualquier otro error
		catch (Exception e) {
			System.out.println("Error: "+e);
		}finally {
			if(fr != null){
				try{
					fr.close();
				}
				//Se captura excepci�n si existen problemas al cerrar el archivo
		        catch (Exception e){
		        	System.out.println("Error al cerrar el archivo "+e);
		        }
			}
		}
	}
}