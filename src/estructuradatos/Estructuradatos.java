/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos;

/**
 *
 * @author jomai
 */
public class Estructuradatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegerLinkedList iList=new IntegerLinkedList();
        System.out.println(iList);
        iList.addFirst(5);
        System.out.println(iList);
        iList.addFirst(10);
        System.out.println(iList);
        iList.addLast(7);
        System.out.println(iList);
        
        SLinkedList<String> sList=new SLinkedList<String>();
        sList.addFirst("world");
        sList.addFirst("Hello");
        System.out.println(sList);
        
        SLinkedList<Integer> iList2=new SLinkedList<Integer>();
        for(int i=0; i<10; i++){
            iList2.addFirst((i));}
        System.out.println(iList2);
        
        while(!iList2.isEmpty()){
            iList2.removeFirst();
            System.out.println(iList2);
        }
        System.out.println("hhhhhhhh");
        SLinkedList<Integer> sList3=new SLinkedList<Integer>();
        sList3.addFirst(1);
        sList3.addFirst(2);
        sList3.addFirst(3);
        sList3.addFirst(2);
        
        System.out.println(sList3);
        System.out.println("hhhhhhhh");
        System.out.println(sList3);
        System.out.println(sList3.indexOf(1));
        }


    }
    

