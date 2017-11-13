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
public class BinaryNode {

    public int value;
    public BinaryNode leftChild;
    public BinaryNode rightChild;

    public BinaryNode(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    public void setRight(BinaryNode a) {
        this.rightChild = a;
    }

    public void setLeft(BinaryNode a) {
        this.leftChild = a;
    }

    public void preorderTraversal() {
        preorder(this);
    }

    public void inorderTraversal() {
        inorder(this);
    }

    public void postorderTraversal() {
        postorder(this);
    }

    public void depthFirstTraversal() {
        Queue<BinaryNode> a = new Queue<BinaryNode>();
        BinaryNode b = this;
        a.offer(b);
        while (!a.isEmpty()) {
            b = a.element();
            if (b.leftChild != null) {
                a.offer(b.leftChild);
            }
            if (b.rightChild != null) {
                a.offer(b.rightChild);
            }
            System.out.println(b.value);
            a.remove();

        }
    }

    private void postorder(BinaryNode a) {
        //System.out.println("estamos en nodo "+a.value);

        if (a.leftChild != null) {
            postorder(a.leftChild);

        }
        if (a.rightChild != null) {

            postorder(a.rightChild);

        }
        System.out.println(a.value);
        //System.out.println("se termina en nodo "+a.value);

    }

    private void inorder(BinaryNode a) {

        if (a.leftChild != null) {
            inorder(a.leftChild);

        }

        System.out.println(a.value);

        if (a.rightChild != null) {

            inorder(a.rightChild);

        }

    }

    private void preorder(BinaryNode a) {
        System.out.println(a.value);
        if (a.leftChild != null) {
            preorder(a.leftChild);
        }

        if (a.rightChild != null) {
            preorder(a.rightChild);

        }

    }

    public void addNode(int value) {
        if (this.value > value) {
            if (this.leftChild == null) {
                this.leftChild = new BinaryNode(value);
            } else {
                this.leftChild.addNode(value);
            }

        } else {
            if(value>this.value){
            if (this.rightChild == null) {
                this.rightChild = new BinaryNode(value);
            } else {
                this.rightChild.addNode(value);
            }}

        }
    }
    
    public BinaryNode findNode(int target){
        if(target==this.value){
            return this;
        }
        if(target<this.value){
            if(this.leftChild==null){
                return null;
            }
            else{
                return this.leftChild.findNode(target);
            }
        }
        else{
            
            if(this.rightChild==null){
                return null;
            }
            else{
                return this.rightChild.findNode(target);
            }
        }
    }

}
