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

    public static String checkForBalance(String e) {
        System.out.println("kk");
        Stack<Character> a = new Stack<Character>();
        for (int i = 0; i < e.length(); i++) {
            if (e.charAt(i) == '(' || e.charAt(i) == '{' || e.charAt(i) == '[') {
                a.push(e.charAt(i));
            }
            switch (e.charAt(i)) {
                case ')':
                    if (a.peek() != '(') {
                        return "Missing left symbol";
                    } else {
                        a.pop();
                        break;
                    }
                case '}':
                    if (a.peek() != '{') {
                        return "Missing left symbol";
                    } else {
                        a.pop();
                        break;
                    }
                case ']':
                    if (a.peek() != '[') {
                        return "Missing left symbol";
                    } else {
                        a.pop();
                        break;
                    }
            }
        }
        return "correcto";
    }

    public static String postfixEval(String e) {
        Stack<Character> a = new Stack<Character>();
        int temp1, temp2, temp3;
        String aa = "0123456789";
        String bb = "+-*/";
        for (int i = 0; i < e.length(); i++) {
            for (int f = 0; f < aa.length(); f++) {
                if (e.charAt(i) == aa.charAt(f)) {
                    a.push(e.charAt(i));
                }
                for (int r = 0; r < bb.length(); r++) {
                    if (e.charAt(i) == bb.charAt(r)) {
                        if (a.peek() == null) {
                            return "Too many operators";
                        }
                        temp1 = Character.getNumericValue(a.pop());
                        if (a.peek() == null) {
                            return "Too many operators";
                        }
                        temp2 = Character.getNumericValue(a.pop());

                        switch (e.charAt(i)) {
                            case '+':
                                temp3 = temp1 + temp2;
                                a.push(Integer.toString(temp3).charAt(0));
                                break;
                            case '-':
                                temp3 = temp1 - temp2;
                                a.push(Integer.toString(temp3).charAt(0));
                                break;
                            case '*':
                                temp3 = temp1 * temp2;
                                a.push(Integer.toString(temp3).charAt(0));
                                break;
                            case '/':
                                temp3 = temp1 / temp2;
                                a.push(Integer.toString(temp3).charAt(0));
                                break;
                        }
                    }
                }

            }
        }
        temp3=a.pop();
        if(a.peek()!=null){
            return("too many operands");}
            else{
                    return temp3+"";
                    }
        }
    public static void Fibonacci(int s){
        Stack<Integer> q = new Stack<Integer>();
        q.push(1);
        q.push(1);
        int a,b;
        for(int i=0;i<s-1;i++){
            b=q.pop();
            a=q.pop();
            System.out.println(a);
            q.push(b);
            q.push(a+b);
        }
    }

    public static void main(String[] args) {

        checkForBalance("1234567");

    }

    public static void mainw(String[] args) {
        Object[] inputArray = {1, 2, 3, "cas", 5};
        invertir(inputArray);

        System.out.println("prueba");
        int[] inputArray2 = {3, 2, 1, 3, 2};
        tren(inputArray2);

        hanoi();
    }

    public static Object[] invertir(Object[] inputArray) {

        Stack<Object> iStack = new Stack<Object>();
        for (int i = 0; i < inputArray.length; i++) {
            iStack.push(inputArray[i]);
        }
        System.out.println(Arrays.toString(inputArray));

        Object[] outputArray = new Object[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            outputArray[i] = iStack.pop();
        }

        System.out.println(Arrays.toString(outputArray));
        return outputArray;

    }

    public static void tren(int[] inputArray) {
        Stack<Integer> input = new Stack<Integer>();
        for (int i = 0; i < inputArray.length; i++) {
            input.push(inputArray[i]);
        }
        Stack<Integer> output = new Stack<Integer>();
        Stack<Integer> H1 = new Stack<Integer>();
        Stack<Integer> H2 = new Stack<Integer>();
        while (input.empty() == false) {
            switch (input.peek()) {
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
            }
        }
        while (H1.empty() == false) {
            output.push(H1.peek());
            H1.pop();
        }
        while (H2.empty() == false) {
            output.push(H2.peek());
            H2.pop();
        }

        int[] outputArray = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            outputArray[i] = output.pop();
        }
        System.out.println(Arrays.toString(outputArray));

    }

    public static void hanoi() {
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
