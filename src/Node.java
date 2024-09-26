/********************************************************************************
 ∗ @file: Node.java
 ∗ @description: File that creates a node used in the BST
 ∗ @author: Benton Phillips
 ∗ @date: September 25 , 2024
 *********∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*/

// Implement the constructor
public class Node<Mountain> {
    private Mountain data;
    private Node left;
    private Node right;

    //Constructor for the Node class
    Node(Mountain data) {
        this.data = data;
        left = right = null;
    }

    // Implement the setElement method
    // sets the value of the node
    public void setElement(Mountain value) {
        this.data = value;
    }

    // Implement the setLeft method
    //Sets the pointer of the node's left child
    public void setLeft(Node<Mountain> left) {this.left=left;}

    // Implement the setRight method
    //Sets the pointer of the node's right child
    public void setRight(Node<Mountain> right) {this.right=right;}

    // Implement the getLeft method
    //Gets the node's left child
    public Node<Mountain> getLeft(){
        return left;
    }

    // Implement the getRight method
    //Gets the node's right child
    public Node<Mountain> getRight(){
        return right;
    }

    // Implement the getElement method
    //Returns the value of node
    public Mountain getElement() {
        return data;
    }


    // Implement the isLeaf method
    //Checks to see if the node is a leaf (has no children)
    public boolean isLeaf(){
        return left == null && right == null;
    }
}
