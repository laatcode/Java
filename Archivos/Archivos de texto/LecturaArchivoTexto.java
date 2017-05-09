import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 *
 * Los Stream son una secuencia ordenada de datos con un determinado origen y destino, normalmente se utilzan en parejas (iniciador, filtro)
 *
 *FileReader (iniciador): lee texto de un fichero
 * BufferedReader (filtro): lee texto (línea a línea) de un Reader
 *
 * La clase File es una representación abstracta de archivo y rutas de directorio
 * 
 * La clase FileReader permite leer archvivos de caracteres.
 * Los constructores de esta clase suponen que la codificación de caracteres predeterminada
 * y el tamaño predeterminado del búfer de bytes son apropiados.
 * Para especificar estos valores, puede construir un InputStreamReader en un FileInputStream.
 * 
 * La clase BufferedReader permite leer el texto de una secuencia de entrada de caracteres,
 * almacenando en búfer caracterespara proporcionar una lectura eficiente de caracteres, matrices y líneas.
 * El tamaño del búfer puede especificarse, o puede usarse el tamaño predeterminado.
 * El valor predeterminado es lo suficientemente grande para la mayoría de los propósitos.
 * 
 */
public class LecturaArchivoTexto{
	
	public static void main(String[] args) {
		//Declaración de variables
		File archivo;
		FileReader fr=null;
		BufferedReader br;
		
		try{
			//Almacena la ruta del archivo en la variable archivo (Stream iniciador)
			archivo = new File("D:\\archivo.txt");
			//Crea un objeto FileReader con la ruta del archivo a leer
			fr = new FileReader (archivo);
			//Crea un flujo de entrada de caracteres de espacio de memoria(buffer, Stream filtro)
	        br = new BufferedReader(fr);
	        
		    // Lectura del archivo
	        String linea;
	        //Se recorre linea a linea el flujo de entrada de caracteres y se almacenan en la variable linea
	        while((linea=br.readLine())!=null){
	        	System.out.println(linea);
	        }
        //Se crea excepción si el sistema no encuentra el archivo
		}catch (FileNotFoundException e) {
			System.out.println("El sistema no puede encontrar el archivo");
		}
		//Se crea Excepción si el sistema encuentra cualquier otro error
		catch (Exception e) {
			System.out.println("Error: "+e);
		}finally {
			if(fr != null){
				try{
					fr.close();
				}
				//Se captura excepción si existen problemas al cerrar el archivo
		        catch (Exception e){
		        	System.out.println("Error al cerrar el archivo "+e);
		        }
			}
		}
	}
}
