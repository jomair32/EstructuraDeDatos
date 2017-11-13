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
public class main {

    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(4);
        BinaryNode node1 = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node6 = new BinaryNode(6);
        BinaryNode node7 = new BinaryNode(7);
        BinaryNode node8 = new BinaryNode(8);

        root.leftChild = node2;
        root.rightChild = node5;
        node2.leftChild = node1;
        node2.rightChild = node3;
        node5.rightChild = node7;
        node7.leftChild = node6;
        node7.rightChild = node8;
        System.out.println("Pre Order");
        root.preorderTraversal();
        System.out.println("In Order");
        root.inorderTraversal();
        System.out.println("Post Order");
        root.postorderTraversal();
        System.out.println("Depth First");
        root.depthFirstTraversal();
        
        BinaryNode root2 = new BinaryNode(4);
        root2.addNode(2);
        root2.addNode(1);
        root2.addNode(5);
        root2.addNode(3);
        root2.addNode(7);
        root2.addNode(8);
        root2.addNode(6);
        System.out.println("In Order");
        root2.inorderTraversal();
        System.out.println("Depth First");
        root2.depthFirstTraversal();
        
    }
    
    

}
