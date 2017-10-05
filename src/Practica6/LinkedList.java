package Practica6;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private Node<E> header;
    private int size;

    public LinkedList() {
        header = new Node<E>();
        size = 0;
    }

    /**
     * Gets the node at the specified index.
     *
     * @param index the index of the node to get
     * @return the node at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index
     * >= size())
     */
    private Node<E> node(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index < (size >> 1)) {
            Node<E> x = header.next;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = header.prev;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    @Override
    public void addFirst(E e) {
        Node<E> newElement = new Node<E>(e);

        Node<E> firstElement = header.next;
        newElement.next = firstElement;
        firstElement.prev = newElement;

        newElement.prev = header;
        header.next = newElement;

        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> newElement = new Node<E>(e);

        Node<E> lastElement = header.prev;
        newElement.prev = lastElement;
        lastElement.next = newElement;

        newElement.next = header;
        header.prev = newElement;

        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }

        if (index == size()) {
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

    @Override
    public E removeFirst() {
        if (header.next == header) {
            throw new NoSuchElementException("the list is empty");
        }

        Node<E> nodeToRemove = header.next;
        Node<E> nextNode = nodeToRemove.next;

        header.next = nextNode;
        nextNode.prev = header;

        nodeToRemove.next = null;
        nodeToRemove.prev = null;

        size--;

        return nodeToRemove.value;
    }

    @Override
    public E removeLast() {
        if (header.next == header) {
            throw new NoSuchElementException("the list is empty");
        }

        Node<E> nodeToRemove = header.prev;
        Node<E> previousNode = nodeToRemove.prev;

        previousNode.next = header;
        header.prev = previousNode;

        nodeToRemove.next = null;
        nodeToRemove.prev = null;

        size--;

        return nodeToRemove.value;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> nodeToRemove = node(index);
        Node<E> previousNode = nodeToRemove.prev;
        Node<E> nextNode = nodeToRemove.next;

        previousNode.next = nextNode;
        nextNode.prev = previousNode;
        nodeToRemove.next = null;
        nodeToRemove.prev = null;

        size--;

        return nodeToRemove.value;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index >= 0 && index < size()) {
            remove(index);
            return true;
        }

        return false;
    }

    @Override
    public E getFirst() {
        if (header.next == header) {
            throw new NoSuchElementException();
        }

        return header.next.value;
    }

    @Override
    public E getLast() {
        if (header.next == header) {
            throw new NoSuchElementException();
        }

        return header.prev.value;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> nodeToReturn = node(index);

        return nodeToReturn.value;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> nodeToSet = node(index);
        E currentValue = nodeToSet.value;
        nodeToSet.value = element;

        return currentValue;
    }

    @Override
    public boolean contains(E e) {
        int index = indexOf(e);

        if (index >= 0 && index < size()) {
            return true;
        }

        return false;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;

        if (o == null) {
            for (Node<E> x = header.next; x != header; x = x.next) {
                if (x.value == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = header.next; x != header; x = x.next) {
                if (o.equals(x.value)) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    @Override
    public void clear() {
        header.next = header;
        header.prev = header;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] returnArray = new Object[size];

        int i = 0;
        for (Node<E> x = header.next; x != header; x = x.next) {
            returnArray[i++] = x.value;
        }

        return returnArray;
    }

    @Override
    public String toString() {
        if (header.next == header) {
            return "[]";
        }

        Node<E> current = header.next;
        String str = "[" + current.value;
        while (current.next != header) {
            current = current.next;
            str += ", " + current.value;
        }
        str += "]";

        return str;
    }

    public E josephus(int steps) {
        Node<E> current = header;

        int count = 0;
        while (size() > 1) {
            current = current.next;
            if (current != header) {
                count++;
                if (count == steps) {
                    Node<E> prevNode = current.prev;
                    System.out.println("Contestant lost: " + current.value);
                    remove(indexOf(current.value));
                    count = 0;
                    current = prevNode;
                }
            }
        }

        return getFirst();
    }
    //Busquedas
    
    
    
    
    
    
    
    
    
    
    
    public static int linearSearch(int[] e, int o) {
        for (int i = 0; i < e.length; i++) {
            if (e[i] == o) {
                return i;
            } else {
                if (e[i] > o) {
                    return (-1);
                }
            }
        }
        return (-1);

    }

    public static int binarySearch(int[] e, int o) {
        int min = 0, max = e.length - 1, mid;
        while (min >= max) {
            mid = (max - min) / 2;
            if (o < e[mid]) {
                max = mid - 1;
            } else if (o > e[mid]) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void shiftRight(int values[], int start, int end) {

        int a = values[start], b = end;

        for (int i = start; i != end; i--) {
            values[i] = values[i - 1];
        }
        values[b] = a;

    }

    public static void Insertionsort(int[] e) {
        for (int i = 1; i < e.length; i++) {
            for (int j = 0; j != i; j++) {
                if (e[i] < e[j]) {
                    shiftRight(e, i, j);
                }
            }
        }

    }

    public static void Selectionsort(int[] e) {
        for (int i = 0; i < e.length; i++) {
            int min = i;
            for (int j = (i + 1); j < e.length; j++) {
                if (e[min] > e[j]) {
                    min = j;
                }

            }
            int a = e[min];
            e[min] = e[i];
            e[i] = a;
        }
    }
}
