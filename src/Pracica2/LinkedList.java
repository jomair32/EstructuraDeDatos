/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pracica2;
/**
 *
 * @author jomai
 */
public class LinkedList<E> implements List<E> {
    private Node<E> header;
    private int size;
    
    public LinkedList(){
        header=new Node();
        size=0;
    }
    
    private  Node<E> node(int index){
        if(index<0 || index>=size){
            //throw new IndexOutOfBoundaException();
        }
        if(index<(size>>1)){
            Node<E> x =header.next;
            for(int i=0;i<index;i++)
                x=x.next;
            return x;
           
        }
        else{
            Node<E> x=header.prev;
            for(int i=size-1;i>index;i--)
                x=x.prev;
            return x;
        }
    }
    
    
    

    @Override
    public void addFirst(E e) {
        Node<E> newElement=new Node<E>(e);
        
        Node<E> firstElement=header.next;
        newElement.next=firstElement;
        firstElement.prev=newElement;
        
        newElement.prev=header;
        header.next=newElement;
        
        size++;
    }

    @Override
    public void addLast(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E element) {
        if(index<0 || index>size){
            throw new IndexOutOfBoundaException();
        }
        if(index==size()){
            addLast(element);
             }
        else{
        Node<E> newNode=new Node<E>(element);
        Node<E> current=node(index);
        Node<E> previousNode=current.prev;
        
        newNode.prev=previousNode;
        previousNode.next=newNode;
        
        newNode.next=current;
        current.prev=newNode;
        
        size++;
    }}

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
