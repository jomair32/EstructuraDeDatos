package archivos;

/*
 * Leyendo un archivo con Scanner
 */

import java.io.*;
import java.util.*;

public class EjemploScanner1 {

	public static void main(String[] args) {

		String linea, nombre, materia, puntos;
		
		Scanner entrada = null;
		
		try{
			entrada = new Scanner(new FileReader("grades.txt"));
			entrada.useDelimiter("[\t\n\r]+");
			while ( entrada.hasNextLine() ) {
				//linea = entrada.nextLine();
				//nombre = linea.substring(0,linea.indexOf('\t'));
				//materia = linea.substring(linea.indexOf('\t')+1, linea.lastIndexOf('\t'));
				//puntos = linea.substring(linea.lastIndexOf('\t')+1);
				//System.out.println(nombre + "->" + materia + " -> " + Integer.parseInt(puntos) );
                                linea = entrada.next();
				nombre = entrada.next();
				materia =entrada.next();
				puntos = entrada.next();
				System.out.println(nombre + "->" + materia + " -> " + Integer.parseInt(puntos) );
			}
		} 
	 	catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado");
		} 
		catch (NumberFormatException e) {
			System.err.println("Error en el tipo de datos esperado");
		} 

		finally {
			entrada.close();
                }
	}
}
