/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

/*
 * Excepciones para el manejo de archivos
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExcepcionesArchivos {
	
    public static void main (String args[]) {
    
    	Scanner scan = null;
		
		try {
                    scan=new Scanner(new FileReader("grades.txt"));
                    scan.useDelimiter();
// aqui colocarías el código para procesar los datos previamente leidos				 
				 
		}		
		catch (FileNotFoundException e) {
			System.err.println(e);
			System.out.println("Archivo NO encontrado!!");
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
			scan.close();
      }
   } 
}
