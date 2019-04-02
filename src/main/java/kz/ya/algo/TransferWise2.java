package kz.ya.algo;


/**
 *
 * @author yerlana
 */
public class TransferWise2 {

    private static class Node {

        Node left, right, parent;
        int data;

        Node(int newData) {
            left = right = parent = null;
            data = newData;
        }
    }

    private static Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
                node.left.parent = node;
            } else {
                node.right = insert(node.right, data);
                node.right.parent = node;
            }
        }
        return (node);
    }

    public static void main(String[] args) throws Exception {
//        Scanner in = new Scanner(System.in);
//        Node _root;
//        int root_i = 0, root_cnt = 0, root_num = 0;
//        root_cnt = in.nextInt();
//        _root = null;
//        for (root_i = 0; root_i < root_cnt; root_i++) {
//            root_num = in.nextInt();
//            if (root_i == 0) {
//                _root = new Node(root_num);
//            } else {
//                insert(_root, root_num);
//            }
//        }
//
//        int _x = in.nextInt();

        int[] input = {11, 20, 10, 30, 8, 12, 25, 40, 6, 31, 13, 23, 30};
        if (input.length == 0) {
            return;
        }

        int N = input[0];
        Node root = new Node(input[1]);

        for (int i = 2; i <= N; i++) {
            insert(root, input[i]);
        }

        int key = input[N + 1];
        System.out.println("The smallest value greater than " + key + " is " + nextIntegerGreaterThan(root, key));
    }

    private static int nextIntegerGreaterThan(Node root, int val) {
        if (root == null) {
            return -1;
        }
        if (root.data > val) {
            int t = nextIntegerGreaterThan(root.left, val);
            return Math.abs(root.data - val) < Math.abs(t - val) ? root.data : t;
        } else if (root.data == val) {
            return nextIntegerGreaterThan(root.right, val);
        } else {
            int t = nextIntegerGreaterThan(root.right, val);
            return Math.abs(root.data - val) < Math.abs(t - val) ? root.data : t;
        }
    }
}
