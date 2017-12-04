/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenFinal;

/**
 *
 * @author jomai
 */
public class Item {
    public double peso;
    public double valor;
    
    public Item(double peso, double valor){
        this.peso=peso;
        this.valor=valor;
        
    }
    public double ganancia(){
        return(this.valor/this.peso);
    }
            
}
