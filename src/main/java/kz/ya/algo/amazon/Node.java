package kz.ya.algo.amazon;

import java.util.List;

/**
 *
 * @author yerlana
 */
public class Node {

    public double key;
    public List<Integer> item;
    public Node left;
    public Node right;
    public int height;

    public Node(List<Integer> item) {
        this(item, null, null);
    }

    public Node(List<Integer> item, Node left, Node right) {
        this.item = item;
        this.key = Math.sqrt(item.get(0) * item.get(0) + item.get(1) * item.get(1));
        this.left = left;
        this.right = right;
        this.height = 1;
    }
}
