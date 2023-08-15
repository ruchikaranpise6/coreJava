package linkedlist;

public class ReverseLL {

    public static void main(String[] args) {
        ReverseLL ll = new ReverseLL();
        LinkedListImpl list1 = new LinkedListImpl();
        list1.insert(5);
        list1.insert(6);
        list1.insert(4);
        list1.insert(3);
        list1.insert(9);
        System.out.println();
        list1.printList();
        ll.reverse(list1);
        list1.printList();
    }

    void reverse(LinkedListImpl list) {
        LinkedListImpl.Node prev = null;
        LinkedListImpl.Node current = list.head;
        LinkedListImpl.Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }
}
