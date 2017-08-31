package Practica3;
import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;


public class LinkedList<E> implements List<E> {
	private Node<E> header;
	private int size;
	
	public LinkedList() {
		header = new Node<E>();
		size = 0;
                
	}
	
	/**
	 * Gets the node at the specified index.
	 * @param index the index of the node to get
	 * @return the node at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	private Node<E> node(int index){
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index < (size >> 1)) {
			Node<E> x = header.next;
			for(int i=0; i<index; i++)
				x = x.next;
			return x;
		} else {
			Node<E> x = header.prev;
			for(int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
		}
	}

	@Override
	public void addFirst(E e) {
		Node<E> newElement=new Node<E>(e);
                if(size==0){
                    header.next=newElement;
                    newElement.prev=header;
                    size++;
                    
                    
                }
                else{
                    
                Node<E> firstElement=header.next;
                newElement.next=firstElement;
                firstElement.prev=newElement;
        
                newElement.prev=header;
                header.next=newElement;
        
                size++;}
		
	}

	@Override
	public void addLast(E e) {
		Node<E> newElement=new Node<E>(e);
                //System.out.println("value  "+newElement.value);
                Node<E> lastElement=header.prev;
                lastElement.next=newElement;
                newElement.prev=lastElement;
                
                newElement.next=header;
                header.prev=newElement;
                size++;
                
                
		
	}

	@Override
        public void add(int index, E element) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index == size()) {
			addLast(element);
		} else {
			Node<E> newNode = new Node<E>(element);
			Node<E> current = node(index);
			Node<E> previousNode = current.prev;
			
			newNode.prev = previousNode;
			previousNode.next = newNode;
			
			newNode.next = current;
			current.prev = newNode;
			size++;
		}
	}
	public void addd(int index, E element) {
		if(index<0 || index>size){
                    throw new IndexOutOfBoundsException();
                }
                 
                
                if(size==0){
                    
                    addFirst(element);
                    
                    
                }
                else{
                if(index==size){
                    addLast(element);
                    
                    //System.out.println("addsecond  "+size);
                    
                }
                else{
                    
                    Node<E> newNode=new Node<E>(element);
                    Node<E> current=node(index);
                    Node<E> previousNode=current.prev;
        
                    newNode.prev=previousNode;
                    previousNode.next=newNode;
        
                    newNode.next=current;
                    current.prev=newNode;
        
                    size++;}}}
                   
        
	

	@Override
	public E removeFirst() {
		if(size<=0){
                    throw new NoSuchElementException();
                }
                else{
                    if(size==1){
                        Node<E> first=header.next;
                        header.next=null;
                        size--;
                        return first.value;
                        
                    }
                    else{
                        
                    Node<E> newFirst=node(1);
                    Node<E> First=header.next;
                    header.next=newFirst;
                    newFirst.prev=header;
                    size--;
                    return First.value;
                    }
                }
	}

	@Override
	public E removeLast() {
		if(size<=0){
		return null;}
                else{
                    Node<E> newLast=node(size-1);
                    header.prev=newLast;
                    newLast.next=header;
                    size--;
                    return newLast.value;
                }
                
	}

	@Override
	public E remove(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
                Node<E> nodeToRemove=node(index);
                Node<E> prevNode=nodeToRemove.prev;
                Node<E> nextNode=nodeToRemove.next;
                
                prevNode.next=nextNode;
                nextNode.prev=prevNode;
                
                size--;
                return nodeToRemove.value;
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
		if(header.next==null){
                    throw new NoSuchElementException();
        }
                return header.next.value;
	}

	@Override
	public E getLast() {
		if(header.next==null){
                    throw new NoSuchElementException();
        }
                return header.prev.value;
	}

	@Override
	public E get(int index) {
            if(index>=this.size){
                throw new IndexOutOfBoundsException();
            }
            else{
		Node<E> n=node(index);
                return n.value;
	}}

	@Override
	public E set(int index, E element) {
		if(index>=this.size){
                throw new IndexOutOfBoundsException();
            }
                else{
                    Node<E> n=node(index);
                    n.value=element;
                    return n.value;
                }
	}

	@Override
	public boolean contains(E e) {
		int index=0;
        if(e==null){
            for(Node<E> x=header.next; x !=null; x=x.next){
                if(x.value==null)
                    return true;
                index++;
            }
        }
        else{
            for (Node<E> x =header.next; x!=null;x=x.next){
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
                    for(Node<E> x=header.next; x !=null; x=x.next){
                        if(x.value==null)
                            return index;
                        index++;
            }
        }
                else{
                    for (Node<E> x =header.next; x!=null;x=x.next){
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
		header.next = null;
                header.prev=null;
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
                for(int i=0;i<this.size;i++){
                    A[i]=this.get(i);
                }
                return A;
	}
	
	@Override
	public String toString() {
		if(size==0){
			return "[]";}
                
                
                
		Node<E> current = header.next;
		String returnValue = "[" + current.value;
                
                int sizeC=1;
                
                while(sizeC<this.size){
                    current=current.next;
                    returnValue+=", "+current.value;
                    sizeC++;
                }
                
                returnValue += "]";
		return returnValue;
                
                
                
                
		
		
	}
}
