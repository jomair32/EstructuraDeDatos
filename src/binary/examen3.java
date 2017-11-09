/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary;

/**
 *
 * @author jomai
 */
public class examen3 {

    public static void main(String[] args) {
        System.out.println("Maxdepth");
        String a = "()()()";
        System.out.println(maxDepth(a));
        String b = "()(()";
        System.out.println(maxDepth(b));
        String c = "()(((3)())())";
        System.out.println(maxDepth(c));

        System.out.println("+");
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(7);
        list2.addLast(8);
        list2.addLast(9);

        System.out.println(intersect(list1, list2));
        System.out.println("-");
        System.out.println(difference(list1, list2));

        System.out.println("area");
        System.out.println(shapeArea(5));
        System.out.println(shapeArea(4));
    }

    public static int maxDepth(String exp) {
        int c = 0;
        int d = 0;
        Stack<Character> a = new Stack<Character>();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                c++;
                if (c > d) {
                    d = c;
                }
            }
            if (exp.charAt(i) == ')') {
                c--;
            }
        }
        if (c != 0) {
            return (-1);
        } else {
            return d;
        }
    }

    public static LinkedList<Integer> intersect(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> list3 = new LinkedList<Integer>();
        for (int i = 0; i < list1.size(); i++) {
            if (list2.contains(list1.get(i))) {
                list3.addLast(list1.get(i));
            }
        }
        return list3;

    }

    public static LinkedList<Integer> difference(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> list3 = new LinkedList<Integer>();
        for (int i = 0; i < list1.size(); i++) {
            if (list2.contains(list1.get(i)) == false) {
                list3.addLast(list1.get(i));
            }
        }
        return list3;

    }

    public static int shapeArea(int n) {
        if (n == 1) {

            return 1;
        }

        return (4 * (n - 1)) + shapeArea(n - 1);
    }

}
