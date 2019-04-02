package kz.ya.algo.vmware;

import java.util.HashSet;

/**
 *
 * @author yerlana
 */
public class LinkedList {

    static class SinglyLinkedListNode {

        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

    static class DoublyLinkedListNode {

        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

    static SinglyLinkedListNode removeNodes(SinglyLinkedListNode listHead, int x) {
        SinglyLinkedListNode it = listHead;

        // If head node itself holds the value greater than 'x'
        while (it != null && it.data > x) {
            listHead = it.next;
            it = listHead;
        }

        SinglyLinkedListNode prev = null;

        // Delete occurrences other than head
        while (it != null) {
            // Search for the node to be deleted, keep track of the previous node as we need to change 'prev->next'
            while (it != null && it.data <= x) {
                prev = it;
                it = it.next;
            }
            // If required value node was't present in linked list
            if (it == null) {
                break;
            }

            // Unlink the node from linked list
            prev.next = it.next;
            // Update Temp for next iteration of outer loop
            it = prev.next;
        }

        return listHead;
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        int count = 0;
        SinglyLinkedListNode it = head;
        SinglyLinkedListNode prev = null;

        while (count < position) {
            prev = it;

            // iterate
            it = it.next;
            count++;
        }

        prev.next = new SinglyLinkedListNode(data);
        prev.next.next = it;

        return head;
    }

    // O(m+n)
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int result = 0;
        HashSet<SinglyLinkedListNode> hashSet = new HashSet<>();

        SinglyLinkedListNode it = head1;
        while (it != null) {
            hashSet.add(it);
            // iterate
            it = it.next;
        }

        SinglyLinkedListNode it2 = head2;
        while (it2 != null) {
            if (hashSet.contains(it2)) {
                result = it2.data;
                break;
            }
            hashSet.add(it2);
            // iterate
            it2 = it2.next;
        }

        return result;
    }

    // O(n)
    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        SinglyLinkedListNode it = head;
        HashSet<SinglyLinkedListNode> hashSet = new HashSet<>();
        
        while (it != null) {
            if (hashSet.contains(it)) {
                return true;
            }
            hashSet.add(it);
            // iterate
            it = it.next;
        }
        
        return false;
    }

    static void printNodes(SinglyLinkedListNode listHead) {
        SinglyLinkedListNode it = listHead;
        while (it != null) {
            System.out.print(it.data + " ");
            it = it.next;
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if (head == null) {
            return new DoublyLinkedListNode(data);
        }
        if (head.data > data) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        DoublyLinkedListNode it = head;
        DoublyLinkedListNode tail = null;

        while (it != null && it.data < data) {
            tail = it;

            // iterate
            it = it.next;
        }

        if (it == null) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            tail.next = newNode;
            newNode.prev = tail;
        } else {
            DoublyLinkedListNode prev = it.prev;
            prev.next = new DoublyLinkedListNode(data);
            prev.next.next = it;
        }

        return head;
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        DoublyLinkedListNode it = head;
        DoublyLinkedListNode tail = null;

        while (it != null) {
            tail = it;
            it = it.next;
        }

        it = tail;

        while (it != null) {
            DoublyLinkedListNode temp = it.prev;
            it.prev = it.next;
            it.next = temp;

            // iterate
            it = it.next;
        }

        return tail;
    }

    static void printNodes(DoublyLinkedListNode listHead) {
        DoublyLinkedListNode it = listHead;
        while (it != null) {
            System.out.print(it.data + " ");
            it = it.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(7);
        head.next = new SinglyLinkedListNode(3);
        head.next.next = new SinglyLinkedListNode(4);
        head.next.next.next = new SinglyLinkedListNode(8);
        head.next.next.next.next = new SinglyLinkedListNode(5);
        head.next.next.next.next.next = new SinglyLinkedListNode(1);

        printNodes(insertNodeAtPosition(head, 10, 2));

        System.out.println("");

        printNodes(removeNodes(head, 6));

        System.out.println("");

        DoublyLinkedListNode doubleHead = new DoublyLinkedListNode(1);
        DoublyLinkedListNode elem1 = new DoublyLinkedListNode(3);
        doubleHead.next = elem1;
        elem1.prev = doubleHead;
        DoublyLinkedListNode elem2 = new DoublyLinkedListNode(4);
        elem1.next = elem2;
        elem2.prev = elem1;
        DoublyLinkedListNode elem3 = new DoublyLinkedListNode(10);
        elem2.next = elem3;
        elem3.prev = elem2;

        printNodes(sortedInsert(doubleHead, 11));

        System.out.println("");

        printNodes(reverse(doubleHead));

        System.out.println("");
    }
}
