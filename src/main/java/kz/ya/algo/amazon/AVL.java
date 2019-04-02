/**
 * AVL Tree
 * Self-Balancing Binary Search Tree
 */
package kz.ya.algo.amazon;

import java.util.List;

/**
 *
 * @author yerlana
 */
public class AVL {

    public Node root;

    public AVL(List<Integer> item) {
        root = new Node(item);
    }

    public int getBalance(Node n) {
        if (n != null) {
            return (getHeight(n.left) - getHeight(n.right));
        }
        return 0;
    }

    public int getHeight(Node n) {
        if (n != null) {
            return n.height;
        }
        return 0;
    }

    public Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Rotation
        x.right = y;
        y.left = T2;

        // update their heights
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return x;
    }

    public Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Rotation
        y.left = x;
        x.right = T2;

        // update their heights
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    public Node insert(Node node, Node newNode) {
        if (node == null) {
            return newNode;
        }
        if (newNode.key < node.key) {
            node.left = insert(node.left, newNode);
        } else {
            node.right = insert(node.right, newNode);
        }
        // update the node height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int balDiff = getBalance(node);

        // Left Rotate
        // Left-Left Case : x is the left child of y and y is the left child of z
        if (balDiff > 1 && newNode.key < node.left.key) {
            return rightRotate(node);
        }

        // Right Rotate        
        // Right-Right Case : x is the right child of y and y is the right child of z
        if (balDiff < -1 && newNode.key > node.right.key) {
            return leftRotate(node);
        }

        // Left Right Rotate
        // Right-Left Case : x is the left child of y and y is the right child of z        
        if (balDiff > 1 && newNode.key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Rotate       
        // Left-Right Case : x is the right child of y and y is the left child of z
        if (balDiff < -1 && newNode.key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // IN-ORDER TRAVERSAL(LEFT->ROOT->RIGHT) OF TREE FOR GETTING ELEMENTS IN ASCENDING ORDER
    public void inOrder(Node node, List<List<Integer>> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.item);
            inOrder(node.right, list);
        }
    }

    // RIGHT->ROOT->LEFT TRAVERSAL OF TREE FOR GETTING ELEMENTS IN DESCENDING ORDER
    public void descOrder(Node node, List<List<Integer>> list) {
        if (node != null) {
            descOrder(node.right, list);
            list.add(node.item);
            descOrder(node.left, list);
        }
    }
}
