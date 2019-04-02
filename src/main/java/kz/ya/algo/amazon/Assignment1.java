package kz.ya.algo.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yerlan
 */
public class Assignment1 {

    public static void main(String[] args) {
        // allLocations=[[1,2],[3,4],[1,-1]]
        List<List<Integer>> allLocations = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        item.add(1);
        item.add(2);
        allLocations.add(item);
        item = new ArrayList<>();
        item.add(3);
        item.add(4);
        allLocations.add(item);
        item = new ArrayList<>();
        item.add(1);
        item.add(-1);
        allLocations.add(item);
        
        List<List<Integer>> output = closestLocations(3, allLocations, 2);
        for (List<Integer> list : output) {
            System.out.println("[" + list.get(0) + "," + list.get(1) + "]");
        }
    }

    static List<List<Integer>> closestLocations(int totalCrates,
            List<List<Integer>> allLocations,
            int truckCapacity) {
        //BST tree = new BST(allLocations.get(0));
        AVL tree = new AVL(allLocations.get(0));
        for (int i = 1; i < allLocations.size(); i++) {
            tree.insert(tree.root, new Node(allLocations.get(i)));
        }
        List<List<Integer>> output = new ArrayList<>();
        tree.inOrder(tree.root, output);
        return output.subList(0, truckCapacity);
    }
}
