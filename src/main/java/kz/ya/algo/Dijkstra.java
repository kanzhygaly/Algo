/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ya.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author YERLAN
 */
public class Dijkstra {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        if (T < 1 || T > 10) {
            return;
        }
        in.nextLine();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            in.nextLine();

            HashMap<Integer, Node> nodes = new HashMap<>();
            ArrayList<Edge> edges = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                Node x = new Node(in.nextInt());
                Node y = new Node(in.nextInt());
                Edge r = new Edge(j, x, y, in.nextInt());
                in.nextLine();

                nodes.put(x.getId(), x);
                nodes.put(y.getId(), y);
                edges.add(r);
            }

            Node S = nodes.remove(in.nextInt());

            DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(edges);
            dijkstra.setStart(S);

            for (Node target : nodes.values()) {
//                LinkedList<Node> path = dijkstra.getPath(target);
//                System.out.println(path);
                System.out.print(dijkstra.getPathDistance(target) + " ");
            }
            in.nextLine();
        }
    }
}

class DijkstraAlgorithm {

    private final List<Edge> edges;
    private HashSet<Node> settledNodes;
    private HashSet<Node> unSettledNodes;
    private HashMap<Node, Node> predecessors;
    private HashMap<Node, Integer> distance;

    public DijkstraAlgorithm(List<Edge> edges) {
        // create a copy of the array so that we can operate on this array
        this.edges = new ArrayList<>(edges);
    }

    public void setStart(Node source) {
        settledNodes = new HashSet<>();
        unSettledNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();

        distance.put(source, 0);
        unSettledNodes.add(source);

        while (unSettledNodes.size() > 0) {
            Node node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private Node getMinimum(Set<Node> nodes) {
        Node minimum = null;
        for (Node node : nodes) {
            if (minimum == null) {
                minimum = node;
            } else if (getShortestDistance(node) < getShortestDistance(minimum)) {
                minimum = node;
            }
        }
        return minimum;
    }

    private int getShortestDistance(Node destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    private void findMinimalDistances(Node node) {
        List<Node> adjacentNodes = getNeighbors(node);
        for (Node target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSrc().equals(node) && !settledNodes.contains(edge.getDst())) {
                neighbors.add(edge.getDst());
            } else if (edge.getDst().equals(node) && !settledNodes.contains(edge.getSrc())) {
                neighbors.add(edge.getSrc());
            }
        }
        return neighbors;
    }

    private int getDistance(Node node, Node target) {
        for (Edge edge : edges) {
            if (edge.getSrc().equals(node) && edge.getDst().equals(target)
                    || edge.getSrc().equals(target) && edge.getDst().equals(node)) {
                return edge.getDistance();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    /**
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     *
     * @param target
     * @return
     */
    public LinkedList<Node> getPath(Node target) {
        LinkedList<Node> path = new LinkedList<>();
        Node step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

    /**
     * This method returns the path distance from the source to the selected
     * target and -1 if no path exists
     *
     * @param target
     * @return
     */
    public int getPathDistance(Node target) {
        Node current = target;
        // check if a path exists
        if (predecessors.get(current) == null) {
            return -1;
        }
        int path = 0;
        while (predecessors.get(current) != null) {
            Node prev = predecessors.get(current);
            path += getDistance(prev, current);
            current = prev;
        }
        return path;
    }
}

class Node {

    private final int id;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return id + "";
    }
}

class Edge {

    private final int id;
    private final Node src;
    private final Node dst;
    private final int distance;

    public Edge(int id, Node src, Node dst, int distance) {
        this.id = id;
        this.src = src;
        this.dst = dst;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public Node getSrc() {
        return src;
    }

    public Node getDst() {
        return dst;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return src + " " + dst;
    }
}
