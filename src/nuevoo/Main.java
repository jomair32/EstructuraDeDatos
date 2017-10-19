/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoo;

/**
 *
 * @author jomai
 */
import java.util.Arrays;

public class Main {
   public static String aux(String e){
       int c = 1, f = 0;
        String ne = "";
        Stack<Character> a = new Stack<Character>();
        Stack<Character> b = new Stack<Character>();
        Stack<Character> a2 = new Stack<Character>();
        Stack<Character> b2 = new Stack<Character>();
        for (int i = 0; i < e.length(); i++) {
            if (e.charAt(i) == '(' && c == 0) {
                //aux();
            }
            if (c == 1 && e.charAt(i) != '(' && e.charAt(i) != ')') {
                a.push(e.charAt(i));
                
            }

            if (e.charAt(i) == '(') {
                c = 0;
            }
            
            if (c == 0 && e.charAt(i) != '(' && e.charAt(i) != ')') {
                b.push(e.charAt(i));
                f++;
            }
            if (e.charAt(i) == ')') {
                c = 1;
                while (f > 0) {
                    a.push(b.pop());
                    f--;
                }
            }

        }
        while (a.empty() == false) {
            a2.push(a.pop());
        }
        while (a2.empty() == false) {
            ne = ne + a2.pop();
        }
        return ne;
    }
   
    public static String reverseParentheses(String e) {
        int c = 1, f = 0;
        String ne = "";
        Stack<Character> a = new Stack<Character>();
        Stack<Character> b = new Stack<Character>();
        Stack<Character> a2 = new Stack<Character>();
        Stack<Character> b2 = new Stack<Character>();
        for (int i = 0; i < e.length(); i++) {
            if (e.charAt(i) == '(' && c == 0) {
                //aux(ne);
            }
            if (c == 1 && e.charAt(i) != '(' && e.charAt(i) != ')') {
                a.push(e.charAt(i));
                
            }

            if (e.charAt(i) == '(') {
                c = 0;
            }
            
            if (c == 0 && e.charAt(i) != '(' && e.charAt(i) != ')') {
                b.push(e.charAt(i));
                f++;
            }
            if (e.charAt(i) == ')') {
                c = 1;
                while (f > 0) {
                    a.push(b.pop());
                    f--;
                }
            }

        }
        while (a.empty() == false) {
            a2.push(a.pop());
        }
        while (a2.empty() == false) {
            ne = ne + a2.pop();
        }
        return ne;
    }

   

    public static void makeHeap(int values[]) {
        for (int i = 0; i < values.length; i++) {
            int index = i;
            while (index != 0) {
                int parent = (index - 1) / 2;

                if (values[index] <= values[parent]) {
                    break;
                }

                int temp = values[index];
                values[index] = values[parent];
                values[parent] = temp;

                index = parent;
            }
        }
    }

    public static int removeTopItem(int values[], int count) {
        int result = values[0];

        values[0] = values[count - 1];

        int index = 0;
        while (true) {
            int child1 = 2 * index + 1;
            int child2 = 2 * index + 2;

            if (child1 >= count) {
                child1 = index;
            }

            if (child2 >= count) {
                child2 = index;
            }

            if (values[index] >= values[child1]
                    && values[index] >= values[child2]) {
                break;
            }

            int swapChild = child1;
            if (values[child2] > values[child1]) {
                swapChild = child2;
            }

            int temp = values[index];
            values[index] = values[swapChild];
            values[swapChild] = temp;

            index = swapChild;
        }

        return result;
    }

    public static void main(String[] args) {
        int uArray[] = {1, 0, 24, 18, -2, 10};
        System.out.println(Arrays.toString(uArray));
        makeHeap(uArray);
        System.out.println(Arrays.toString(uArray));
        System.out.println(removeTopItem(uArray, uArray.length));
        System.out.println(Arrays.toString(uArray));
        System.out.println(removeTopItem(uArray, uArray.length - 1));
        System.out.println(Arrays.toString(uArray));
        
        
      
        String v = "(ab)(cd)(ef)g";
        System.out.println(v);
        String f = reverseParentheses(v);
        System.out.println(f);
    }

}
