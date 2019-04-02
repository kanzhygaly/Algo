package kz.ya.algo.collection;

/**
 *
 * @author yerlana
 */
public class Test {
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(new SinglyLinkedList.Node(10));
        list.add(new SinglyLinkedList.Node(11));
        list.add(new SinglyLinkedList.Node(12));
        list.add(new SinglyLinkedList.Node(13));
        list.add(new SinglyLinkedList.Node(14));
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}
