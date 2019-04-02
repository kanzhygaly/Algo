package kz.ya.algo.amazon;

/**
 *
 * @author yerlana
 */
public class Assignment22 {

    public static void main(String[] args) {
        int[] values = {5, 6, 3, 1, 2, 4};
        int n = 6;
        int node1 = 2;
        int node2 = 4;
        System.out.println(bstDistance(values, n, node1, node2));

        values = new int[]{9, 7, 5, 3, 1};
        n = 5;
        node1 = 7;
        node2 = 20;
        System.out.println(bstDistance(values, n, node1, node2));
    }

    public static int bstDistance(int[] values, int n, int node1, int node2) {
        BST tree = new BST(values[0]);
        for (int i = 1; i < n; i++) {
            tree.insert(tree.root, new Node(values[i]));
        }
        return tree.getDistance(tree.root, node1, node2);
    }

    static class BST {

        public Node root;

        public BST(int item) {
            root = new Node(item);
        }

        public Node insert(Node node, Node newNode) {
            if (node == null) {
                return newNode;
            }
            if (newNode.item < node.item) {
                node.left = insert(node.left, newNode);
            } else {
                node.right = insert(node.right, newNode);
            }
            return node;
        }

        public int findLevel(Node root, int key) {
            if (root == null) {
                return -1;
            }
            if (root.item == key) {
                return 0;
            } else if (root.item < key) {
                int level = findLevel(root.right, key);
                return level == -1 ? level : 1 + level;
            }
            int level = findLevel(root.left, key);
            return level == -1 ? level : 1 + level;
        }

        public int getDistance(Node root, int a, int b) {
            if (root == null) {
                return -1;
            }
            if (a > root.item && b > root.item) {
                // If both keys are greater than current node, we move to right child of current node.
                return getDistance(root.right, a, b);
            } else if (a < root.item && b < root.item) {
                // If both keys are smaller than current node, we move to left child of current node.
                return getDistance(root.left, a, b);
            } else if (root.item >= a && root.item <= b || root.item <= a && root.item >= b) {
                // If one keys is smaller and other key is greater, current node is Lowest Common Ancestor (LCA) of two nodes.
                // We find distances of current node from two keys and return sum of the distances.
                int d1 = findLevel(root, a);
                int d2 = findLevel(root, b);
                if (d1 == -1 || d2 == -1) {
                    return -1;
                }
                return d1 + d2;
            }
            return 0;
        }
    }

    static class Node {

        public int item;
        public Node left;
        public Node right;

        public Node(int item) {
            this(item, null, null);
        }

        public Node(int item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    static class BinaryTreeUtil {

        public Node LeastCommonAncestor(Node root, int n1, int n2) {
            if (root == null) {
                return root;
            }
            // If either n1 or n2 matches with root's key, report
            // the presence by returning root (Note that if a key is
            // ancestor of other, then the ancestor key becomes LCA
            if (root.item == n1 || root.item == n2) {
                return root;
            }

            // Look for keys in left and right subtrees
            Node left = LeastCommonAncestor(root.left, n1, n2);
            Node right = LeastCommonAncestor(root.right, n1, n2);

            // If both of the above calls return Non-NULL, then one key
            // is present in once subtree and other is present in other,
            // So this node is the LCA
            if (left != null && right != null) {
                return root;
            }

            // Otherwise check if left subtree or right subtree is LCA
            return (left != null) ? left : right;
        }

        // Returns level of key k if it is in a tree, otherwise returns -1
        public int findLevel(Node root, int k, int level) {
            if (root == null) {
                return -1;
            }
            if (root.item == k) {
                return level;
            }

            if (root.item > k) {
                return findLevel(root.left, k, level + 1);
            } else {
                return findLevel(root.right, k, level + 1);
            }
        }

        public int getDistance(Node root, int a, int b) {
            Node lca = LeastCommonAncestor(root, a, b);

            int d1 = findLevel(lca, a, 0);
            int d2 = findLevel(lca, b, 0);

            return d1 + d2;
        }
    }
}
