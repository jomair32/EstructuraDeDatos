/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IStack;

/**
 *
 * @author Jomair
 */
public class Node<T> {
	public T value;
	public Node<T> prev;
	public Node<T> next;
	
	public Node() {
		value = null;
		prev = this;
		next = this;
	}
	
	public Node(T value) {
		this.value = value;
		prev = this;
		next = this;
	}
}