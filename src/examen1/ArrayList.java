package examen1;
import java.lang.IndexOutOfBoundsException;


public class ArrayList<E> implements List<E> {
	public Object[] top;
	private int size;
	private int initialCapacity = 5;
	private int extraCapacity = 5;
	
	/**
	 * Creates a new ArrayList instance with the default initial capacity.
	 */
	public ArrayList() {
		top = new Object[initialCapacity];
		size = 0;
	}
	
	/**
	 * Increases the capacity of this ArrayList instance so that it 
	 * can hold at least extraCapacity elements more.
	 * This method allocates a new array with greater capacity than the
	 * current one (top.length + extraCapacity) and copies all elements
	 * from top to the newly allocated array. The reference top is then
	 * updated to point to the new array. 
	 * @param extraCapacity increase the capacity of this ArrayList by this amount
	 */
	private void reserveExtraCapacity(int extraCapacity) {
            Object[] newArray=new Object[top.length+extraCapacity];
            for(int i=0;i<top.length;i++){
                newArray[i]=top[i];
            }
            top=newArray;
	}
	
	/**
	 * Increases the capacity of this list if its size equals the length of the array
	 * where the data is stored. This method calls reserveExtraCapacity when (size() >= top.length).
	 * reserveExtraCapacity is called using the instance variable extraCapacity.
	 */
	private void ensureCapacity() {
            if(size()>=top.length){
                reserveExtraCapacity(this.extraCapacity);
            }
	}
	
	/**
	 * Shifts elements in the array (top) to the right, starting at the given position.
	 * @param index the position in which the shift will begin
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	private void shiftContentsRight(int index) {
            if(index < 0 || index > size()){
                throw new IndexOutOfBoundsException();
            }
            Object[] newArray=new Object[top.length+1];
            for(int i=0;i<size();i++){
                newArray[i]=top[i];
                
            }
            top=newArray;
            
            
            for(int i=size();i>index;i--){
                
                top[i]=top[i-1];
                
            }
            top[index]=null;
            
            
	}
	
	@Override
	public void addFirst(E e) {
            if(size==0){
                top[0]=e;
                size++;
            }
            else{
            shiftContentsRight(0);
            top[0]=e;
            size++;}
	}

	@Override
	public void addLast(E e) {
            if(size==0){
                top[0]=e;
                size++;
            }
            else{
            Object[] newArray=new Object[top.length+1];
            newArray[top.length]=e;
            for(int i=0;i<top.length;i++){
                top[i]=newArray[i];
            }
            top=newArray;
            size++;}
	}

	@Override
	public void add(int index, E element) {
            if(size==0){
                top[0]=element;
                size++;
            }
            else{
            shiftContentsRight(index);
            top[index]=element;
            size++;}
	}

	@Override
	public E getFirst() {
            return (E) top[0];
            
	}

	
	@Override
	public E getLast() {
		return (E) top[top.length-1];
	}

	
	@Override
	public E get(int index) {
		return (E) top[index];
	}

	@Override
	public E set(int index, E element) {
            Object x = top[index];
		top[index]=element;
                return (E) x;
	}

	@Override
	public void clear() {
            size=0;
            Object[] newArray=new Object[this.initialCapacity];
            top=newArray;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
                if(size()==0){
		return true;}
                else{
                    return false;
                }
	}

	@Override
	public String toString() {
		String s="[";
                
                if(isEmpty()){
                    s+="]";
                    ;
                }
                else{
                    for(int i=0;i<top.length;i++)
                        s+=top[i]+" ,";
                    s+="]";
                }
                return s;
	}
}
