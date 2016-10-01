package uuidgenerator;

/**
 * @author Luis Angel Avila Torres
 * @version 1.0
 * 
 * Generar un identificador único universal de 16 Bytes (128 bits).
 * En un formato de 36 caracteres (32 dígitos y 4 guiones)
 * Ejemplo: 550e8400-e29b-41d4-a716-446655440000
 * 
 */

public class GeneradorUUID {
	public static String crearUUID() {
		return java.util.UUID.randomUUID().toString();
	}
	
	public static void main(String[] args){
		System.out.println(crearUUID());
	}
}