package Pracica2;

import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;


public class SLinkedList<E> implements List<E> {
	private SNode<E> top;
	private int size;
	
	public SLinkedList() {
		top = new SNode<E>();
		size = 0;
	}

	@Override
	public void addFirst(E e) {
		SNode<E> newNode=new SNode<E>(e);
        newNode.next=top.next;
        top.next=newNode;
        size++;
	}

	@Override
	public void addLast(E e) {
		SNode<E> newNode = new SNode<E>(e);
		
		SNode<E> current = top;
		while(current.next != null)
			current = current.next;
		
		current.next = newNode;
		size++;
	}

	@Override
	public void add(int index, E element) {
            if((this.size==0 && index==0)||(this.size>0 && index<=this.size)){
                //System.out.println("TOPNEXT: "+top.next);
                if(top.next==null){
                    SNode<E> J=new SNode<E>(element);
                    top.next=J;
                    this.size++;
                    //System.out.println("size: "+this.size+" index: "+index);
                    //System.out.println("top.next= "+J.value+"   "+top.next.value);
                
                }else{
                    SNode<E> N=new SNode<E>(element);
                    SNode<E> S= top;
                    for(int x=0; x<index;x++){
                        S=S.next;
                    }
                    N.next=S.next;
                    S.next=N;
                    
                    this.size++;
                    }
            }
            else{
                
                throw new IndexOutOfBoundsException();
            }
                
		
	}

	@Override
	public E removeFirst() {
		if(top.next==null){
            throw new NoSuchElementException();
        }
        SNode<E> nodeToRemove=top.next;
        top.next=nodeToRemove.next;
        nodeToRemove.next=null;
        size--;
        return nodeToRemove.value;
	}

	@Override
	public E removeLast() {
		if(top.next==null){
            throw new NoSuchElementException();
    }
        SNode<E> current=top;
        while(current.next.next != null){
            current=current.next;
        }
        SNode<E> nodeToRemove=current.next;
        current.next=null;
        size--;
        return nodeToRemove.value;
	}

	@Override
	public E remove(int index) {
            if(index>=this.size){
                throw new IndexOutOfBoundsException();
            }
            SNode<E> S= top.next;
            SNode<E> J= top;
            for(int x=0;x<index;x++){
                S=S.next;
                J=J.next;
            }
            J.next=S.next;
            size--;
            return S.value;
            
	}

	@Override
	public boolean remove(Object o) {
		if(this.indexOf(o)!=-1){
                    this.remove(this.indexOf(o));
                    return true;
                }
                return false;
	}

	@Override
	public E getFirst() {
		if(top.next==null){
                    throw new NoSuchElementException();
        }
                return top.next.value;
	}

	@Override
	public E getLast() {
		if(top.next==null){
            throw new NoSuchElementException();
        }
        SNode<E> current=top;
        while(current.next !=null){
            current=current.next;
        }
        return current.value;
	}

	@Override
	public E get(int index) {
		if(index>=this.size){
                throw new IndexOutOfBoundsException();
            }
                SNode<E> S= top.next;
                for(int x=0;x!=index;x++){
                    S=S.next;
            }
                return S.value;
	}

	@Override
	public E set(int index, E element) {
		if(index>=this.size){
                throw new IndexOutOfBoundsException();
            }
                SNode<E> S= top.next;
                for(int x=0;x!=index;x++){
                    S=S.next;
            }
                SNode<E> G =new SNode(S.value);
                S.value=element;
                return G.value;
	}

	@Override
	public boolean contains(E e) {
		int index=0;
        if(e==null){
            for(SNode<E> x=top.next; x !=null; x=x.next){
                if(x.value==null)
                    return true;
                index++;
            }
        }
        else{
            for (SNode<E> x =top.next; x!=null;x=x.next){
                if(e.equals(x.value)){
                    return true;
                }
                index++;
            }
        }
        return false;
	}

	@Override
	public int indexOf(Object o) {
		int index=0;
        if(o==null){
            for(SNode<E> x=top.next; x !=null; x=x.next){
                if(x.value==null)
                    return index;
                index++;
            }
        }
        else{
            for (SNode<E> x =top.next; x!=null;x=x.next){
                if(o.equals(x.value)){
                    return index;
                }
                index++;
            }
        }
        return -1;
	}

	@Override
	public void clear() {
		top.next = null;
		size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size() ==0;
	}

	@Override
	public Object[] toArray() {
		Object[] A;
                A=new Object[this.size];
                //System.out.println(A[0]);
                for(int i=0;i<this.size;i++){
                    //System.out.println(this.get(i));
                    A[i]=this.get(i);
                }
                return A;
	}
	
	public String toString() {
		if(top.next == null)
			return "[]";
		
		SNode<E> current = top.next;
		String returnValue = "[" + current.value;
		while(current.next != null) {
			current = current.next;
			returnValue += ", " + current.value;
		}
		
		returnValue += "]";
		return returnValue;
        
	}
}
