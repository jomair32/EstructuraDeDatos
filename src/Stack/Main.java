/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author Jomair
 */
import java.util.Arrays;

public class Main {
	
        
	public static void main(String[] args) {
		Object[] inputArray = {1, 2, 3, "cas", 5};
		invertir(inputArray);
                
                
                
                System.out.println("prueba");
                int[] inputArray2 = {3, 2, 1, 3, 2};
                tren(inputArray2);
                
                hanoi();
                

                
                
                
                
            
        }
        public static Object[] invertir(Object[] inputArray){
		
            Stack<Object> iStack = new Stack<Object>();
		
            for(int i=0; i<inputArray.length; i++)
		iStack.push(inputArray[i]);
            System.out.println(Arrays.toString(inputArray));
                
            Object[] outputArray = new Object[inputArray.length];
            for(int i=0; i<inputArray.length; i++)
		outputArray[i] = iStack.pop();
		
            System.out.println(Arrays.toString(outputArray));
            return outputArray;
    
}
        public static void tren(int[] inputArray){
            Stack<Integer> input = new Stack<Integer>();
            for(int i=0; i<inputArray.length; i++)
			input.push(inputArray[i]);
            Stack<Integer> output = new Stack<Integer>();
            Stack<Integer> H1 = new Stack<Integer>();
            Stack<Integer> H2 = new Stack<Integer>();
            while(input.empty()==false){
                switch(input.peek()){
                    case 1:
                        output.push(input.peek());
                        input.pop();
                        break;
                    case 2:
                        H1.push(input.peek());
                        input.pop();
                        break;
                    case 3:
                        H2.push(input.peek());
                        input.pop();
                        break;
                }}
                while(H1.empty()==false){
                    output.push(H1.peek());
                    H1.pop();
                }
                while(H2.empty()==false){
                    output.push(H2.peek());
                    H2.pop();
            }
	
        int[] outputArray = new int[inputArray.length];
        for(int i=0; i<inputArray.length; i++)
			outputArray[i] = output.pop();
        System.out.println(Arrays.toString(outputArray));
        
}
        public static void hanoi(){
            Stack<Integer> H1 = new Stack<Integer>();
            Stack<Integer> H2 = new Stack<Integer>();
            Stack<Integer> H3 = new Stack<Integer>();
            H1.push(3);
            H1.push(2);
            H1.push(1);
            
            H2.push(H1.peek());
            H1.pop();
            
            H3.push(H1.peek());
            H1.pop();
            
            H3.push(H2.peek());
            H2.pop();
            
            H2.push(H1.peek());
            H1.pop();
            
            H3.push(H2.peek());
            H2.pop();
            
            H1.push(H3.peek());
            H3.pop();
            
            H2.push(H3.peek());
            H3.pop();
            
            H2.push(H1.peek());
            H1.pop();
                
        }
        
        
        
}

	

