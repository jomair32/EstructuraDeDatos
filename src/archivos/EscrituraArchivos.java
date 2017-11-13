package archivos;

/**
 *
 * @author Angeles Junco
 * Ejemplo de escritura a archivos
 * Inserta 20 datos aleatorio en el archivo "datos.txt". Si YA 
 * existe el archivo lo reescribe.
 * Posteriormente, agrega otros 10 datos aleatorios. Si YA existe 
 * el archivo los AGREGA después de la línea de ******
 */

import java.io.*;

public class EscrituraArchivos {
    
    public static void main(String[] args) {
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(new FileWriter("atos.txt"));
            for(int i=0; i<20; i++) {
                salida.println( (int)(Math.random()*100)+1 );
            }
            salida.println("********");
            salida.close();
            salida = new PrintWriter(new FileWriter("atos.txt",true));
            for(int i=0; i<10; i++) {
                salida.println( (int)(Math.random()*100)+1 );
            }
        }
        catch (IOException ex) {
            System.out.println("Error al escribir en el archivo" + ex);
        } finally {
            salida.close();
        }
    }
}
