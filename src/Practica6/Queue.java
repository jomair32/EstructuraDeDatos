package Practica6;
import java.util.NoSuchElementException;

public class Queue<E> implements IQueue<E> {
	private LinkedList<E> queue;
	
	public Queue() {
		queue = new LinkedList<E>();
	}

	@Override
	public void offer(E e) {
		queue.addFirst(e);
		
	}

	@Override
	public E remove() {
            if(queue.size()==0){
                throw new NoSuchElementException();
            }
            E x = queue.getLast();
            queue.removeLast();
            return x;
	}

	@Override
	public E element() {
            if(queue.size()==0){
                throw new NoSuchElementException();
            }
            E x = queue.getLast();
            return x;
	}

	@Override
	public boolean isEmpty() {
		if(queue.size()==0){
                return true;
            }else{
                    return false;
                }
	}

	@Override
	public void clear() {
                queue.clear();
        }

	@Override
	public int size() {
		return size();
	}

	@Override
	public Object[] toArray() {
		return queue.toArray();
	}

}
