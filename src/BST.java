/********************************************************************************
 ∗ @file: BST.java
 ∗ @description: This file implements and maintains the Binary Search Tree structure for the Mountain Node
 ∗ @author: Benton Phillips
 ∗ @date: September 25 , 2024
 *********∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*/
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

// Implement the constructor
class BST implements Iterable<Mountain> {
    private Node<Mountain> root;
    private int nodecount;

    // Constructor for BST that sets an empty tree
    public BST() {
        root = null;
        nodecount = 0;
    }

    // Clears the whole tree by setting the root to null and nodecount to 0
    public void clear() {
        root = null;
        nodecount = 0;
    }

    // Returns the number of nodes in the BST
    public int size() {
        return nodecount;
    }

    // Adds a node to the BST
    public void insert(Mountain mountainNode) {
        root = insertHelp(root, mountainNode);
        nodecount++;
    }

    // Removes a node from the BST
    public Mountain remove(Mountain key) {
        Mountain temp = searchHelp(root, key);
        if (temp != null) {
            root = removeHelp(root, key);
            nodecount--;
        }
        return temp;
    }

    // Finds a node that matches the key value
    public Mountain search(Mountain key) {
        return searchHelp(root, key);
    }

    // Builds the string to print the BST in-order
    public String printString() {
        StringBuilder sb = new StringBuilder();
        for (Mountain mountain : this) {
            sb.append(mountain).append(" ");
        }
        return sb.toString();
    }

    // Returns a BST iterator for in-order traversal
    @Override
    public Iterator<Mountain> iterator() {
        return new BSTIterator(root);
    }

    // Searches for a particular node
    private Mountain searchHelp(Node<Mountain> root, Mountain key) {
        if (root == null) {
            return null;
        }

        if (root.getElement().compareTo(key) > 0) {
            return searchHelp(root.getLeft(), key);
        } else if (root.getElement().compareTo(key) == 0) {
            return root.getElement();
        } else {
            return searchHelp(root.getRight(), key);
        }
    }

    // Inserts a node into the BST based on the rules of a BST
    private Node<Mountain> insertHelp(Node<Mountain> root, Mountain mountainNode) {
        if (root == null) {
            return new Node<>(mountainNode);
        }
        if (mountainNode.compareTo(root.getElement()) < 0) {
            root.setLeft(insertHelp(root.getLeft(), mountainNode));
        } else {
            root.setRight(insertHelp(root.getRight(), mountainNode));
        }
        return root;
    }

    // Removes a node from the BST
    private Node<Mountain> removeHelp(Node<Mountain> root, Mountain key) {
        if (root == null) {
            return null;
        }

        if (root.getElement().compareTo(key) > 0) {
            root.setLeft(removeHelp(root.getLeft(), key));
        } else if (root.getElement().compareTo(key) < 0) {
            root.setRight(removeHelp(root.getRight(), key));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            } else {
                Node<Mountain> temp = getMax(root.getLeft());
                root.setElement(temp.getElement());
                root.setLeft(deleteMax(root.getLeft()));
            }
        }
        return root;
    }

    // Gets the maximum node in the BST
    private Node<Mountain> getMax(Node<Mountain> root) {
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root;
    }

    // Deletes the maximum node in the BST
    private Node<Mountain> deleteMax(Node<Mountain> root) {
        if (root.getRight() == null) {
            return root.getLeft();
        }
        root.setRight(deleteMax(root.getRight()));
        return root;
    }

    // Iterator for the BST to allow for easy traversal of BST nodes
    private class BSTIterator implements Iterator<Mountain> {
        private Stack<Node<Mountain>> stack;

        // Constructor for the BSTIterator
        public BSTIterator(Node<Mountain> root) {
            stack = new Stack<>();
            pushLeft(root);
        }

        // Push all left nodes onto the stack
        private void pushLeft(Node<Mountain> node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }

        @Override
        // Checks if stack is empty
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        // Returns the next element in the stack
        public Mountain next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Node<Mountain> node = stack.pop();
            Mountain result = node.getElement();
            if (node.getRight() != null) {
                pushLeft(node.getRight());
            }
            return result;
        }
    }
}
