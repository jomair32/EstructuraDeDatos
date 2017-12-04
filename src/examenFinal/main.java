/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenFinal;

import java.util.Random;

/**
 *
 * @author jomai
 */
public class main {

    public static void main(String[] args) {

        String[] a = new String[10];

        a[0] = "123";
        a[1] = "398";
        a[2] = "210";
        a[3] = "019";
        a[4] = "528";
        a[5] = "003";
        a[6] = "513";
        a[7] = "129";
        a[8] = "220";
        a[9] = "294";
        for (int i = 0; i < a.length; i++) {
            //System.out.println(a[i]);
        }
        //superSort(a);
        //while (true) {
            mochila();
        //}

    }

    public static void superSort(String[] arr) {
        LinkedList<String> B0 = new LinkedList();
        LinkedList<String> B1 = new LinkedList();
        LinkedList<String> B2 = new LinkedList();
        LinkedList<String> B3 = new LinkedList();
        LinkedList<String> B4 = new LinkedList();
        LinkedList<String> B5 = new LinkedList();
        LinkedList<String> B6 = new LinkedList();
        LinkedList<String> B7 = new LinkedList();
        LinkedList<String> B8 = new LinkedList();
        LinkedList<String> B9 = new LinkedList();
        int paso = 0;
        while (paso != 3) {

            for (int i = 0; i < arr.length; i++) {
                char j;
                if (paso == 0) {
                    j = arr[i].charAt(2);

                } else if (paso == 1) {
                    j = arr[i].charAt(1);
                } else if (paso == 2) {
                    j = arr[i].charAt(0);
                } else {
                    j = '0';
                }
                switch (j) {
                    case '0':
                        B0.addLast(arr[i]);
                        break;
                    case '1':
                        B1.addLast(arr[i]);
                        break;
                    case '2':
                        B2.addLast(arr[i]);
                        break;
                    case '3':
                        B3.addLast(arr[i]);
                        break;
                    case '4':
                        B4.addLast(arr[i]);
                        break;
                    case '5':
                        B5.addLast(arr[i]);
                        break;
                    case '6':
                        B6.addLast(arr[i]);
                        break;
                    case '7':
                        B7.addLast(arr[i]);
                        break;
                    case '8':
                        B8.addLast(arr[i]);
                        break;
                    case '9':
                        B9.addLast(arr[i]);
                        break;
                }
            }
            int f = 0;
            while (!B0.isEmpty()) {
                arr[f] = B0.removeFirst();
                f++;
            }
            while (!B1.isEmpty()) {
                arr[f] = B1.removeFirst();
                f++;
            }
            while (!B2.isEmpty()) {
                arr[f] = B2.removeFirst();
                f++;
            }
            while (!B3.isEmpty()) {
                arr[f] = B3.removeFirst();
                f++;
            }
            while (!B4.isEmpty()) {
                arr[f] = B4.removeFirst();
                f++;
            }
            while (!B5.isEmpty()) {
                arr[f] = B5.removeFirst();
                f++;
            }
            while (!B6.isEmpty()) {
                arr[f] = B6.removeFirst();
                f++;
            }
            while (!B7.isEmpty()) {
                arr[f] = B7.removeFirst();
                f++;
            }
            while (!B8.isEmpty()) {
                arr[f] = B8.removeFirst();
                f++;
            }
            while (!B9.isEmpty()) {
                arr[f] = B9.removeFirst();
                f++;
            }
            paso++;
            System.out.println("--------------");
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void mochila() {
        int cont = 0;
        Item[] L = new Item[100];
        while (cont != 100) {
            Item temp = new Item(Math.random() * 25, Math.random() * 25);
            L[cont] = temp;
            //System.out.println("22");
            cont++;
        }
        LinkedList<Item> mochila1 = greedy(L);
        int cont2 = 0;

        LinkedList<Item> mochila2 = aleatoria(L);
        while (cont2 != 9900) {
            LinkedList<Item> mochila3 = aleatoria(L);
            if (mochila3.getLast().valor > mochila2.getLast().valor) {
                mochila2 = mochila3;
            }
            cont2++;
        }
        //System.out.println("valor total aleatoria: " + mochila2.getLast().valor);
        //System.out.println("peso total aleatoria: " + mochila2.getLast().peso);
        //System.out.println("------------");
        int cont3 = 0;
        while (cont3 < mochila1.size()) {
            //System.out.println(mochila1.get(cont3).valor);
            cont3++;
        }
        cont3 = 0;
        //System.out.println("----yyyy----");
        while (cont3 < mochila2.size()) {
            //System.out.println(mochila2.get(cont3).valor);
            cont3++;
        }
        int a=0;
        while(a<mochila1.size()-1){
            a+=mochila1.getFirst().valor;
            mochila1.removeFirst();
        }
        System.out.println("hay una diferencia de "+(mochila1.getLast().peso-mochila2.getLast().peso)+" en peso y "+(a-mochila2.getLast().valor)+" en valor");

    }

    public static LinkedList greedy(Item[] L) {
        LinkedList<Item> mochila = new LinkedList();
        int j = 0;
        double pesoTotal = 0;
        double valorTotal = 0;
        LinkedList<Item> usado = new LinkedList();
        while (pesoTotal < 25) {
            for (int i = 0; i < L.length; i++) {
                if (!usado.contains(L[i])) {
                    if ((pesoTotal + L[i].peso) < 25) {
                        //System.out.println(pesoTotal + L[i].peso);
                        if (L[i].ganancia() > L[j].ganancia()) {
                            j = i;

                        }
                    }else{
                        
                    }
                }
                else{
                    //System.out.println("usado");
                }
            }

            //System.out.println(pesoTotal + L[j].peso);
            
            //System.out.println("usado "+usado.size());
            pesoTotal += L[j].peso;
            //System.out.println("peso total "+pesoTotal);
            valorTotal += L[j].valor;
            mochila.addLast(L[j]);
            if(pesoTotal>25){
            mochila.removeLast();
            pesoTotal -= L[j].peso;
            valorTotal-=L[j].valor;
            usado.addLast(L[j]);}
            j=0;
            if(usado.size()==100){
                Item mochilaDatos = new Item(pesoTotal, valorTotal);
        mochila.addLast(mochilaDatos);
         //System.out.println("valor total greedy: " + valorTotal);
        //System.out.println("peso total greedy: " + pesoTotal);
                return mochila;
            }
        }
        //System.out.println("valor total greedy: " + valorTotal);
        //System.out.println("peso total greedy: " + pesoTotal);
        Item mochilaDatos = new Item(pesoTotal, valorTotal);
        mochila.addLast(mochilaDatos);
        return mochila;
    }

    public static LinkedList aleatoria(Item[] L) {
        LinkedList<Item> mochila = new LinkedList();
        LinkedList<Integer> usado = new LinkedList();
        double pesoTotal = 0;
        double valorTotal = 0;

        while (pesoTotal < 25) {
            int r = (int) (Math.random() * 100);
            if (!usado.contains(r)) {
                usado.addLast(r);
                if ((pesoTotal + L[r].peso) < 25) {
                    mochila.addLast(L[r]);
                    pesoTotal += L[r].peso;
                    valorTotal += L[r].valor;
                }
            }
            if (usado.size() == 100) {
                //System.out.println("valor total aleatoria temporal: " + valorTotal);
                //System.out.println("peso total aleatoria temporal: " + pesoTotal);
                Item mochilaDatos = new Item(pesoTotal, valorTotal);
                mochila.addLast(mochilaDatos);
                return mochila;
            }

        }

        return mochila;
    }
}
