/**
 * Binary Search Tree
 */
package kz.ya.algo.amazon;

import java.util.List;

/**
 *
 * @author yerlana
 */
public class BST {

    public Node root;

    public BST(List<Integer> item) {
        root = new Node(item);
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
