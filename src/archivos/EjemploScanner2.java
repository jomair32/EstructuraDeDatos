package archivos;

/*
 * Leyendo un archivo con Scanner
 */

import java.io.*;
import java.util.*;

public class EjemploScanner2 {

	public static void main(String[] args) {

		String nombre, materia;
		int calificacion;
		Scanner entrada = null;
		
		try{
			
			entrada = new Scanner(new FileReader("grades.txt"));
			entrada.useDelimiter("[\t\n\r]+");
			while ( entrada.hasNextLine() ) {
				nombre = entrada.next();
				materia = entrada.next();
				calificacion = entrada.nextInt();
				System.out.println(nombre + "->" + materia + " -> " + calificacion );
			}
		} 
	 	catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado");
		} 
		catch (InputMismatchException e){
			System.err.println(e);
			System.out.println("Error en el tipo de datos!!");
		} 
		catch (NoSuchElementException e) {
			System.err.println(e);
			System.out.println("Error durante la lectura, faltan datos!!");
		}
		finally {
			entrada.close();
        }
	}
}
