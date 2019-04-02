package kz.ya.algo.collection;

/**
 *
 * @author yerlana
 */
public class SinglyLinkedList {

    static class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    private Node head;

    public void add(Node node) {
        if (this.head == null) {
            this.head = node;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }
    
    public void reverse() {
        Node current = this.head;
        Node prev = null, next;
        while (current != null) {
            // store NEXT node before changing
            next = current.next;
            // change pointer on CURRENT node to PREV
            current.next = prev;
            // move prev and current one step forward
            prev = current;
            current = next;
        }
        this.head = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node current = this.head;
        while (current != null) {
            sb.append(current);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
