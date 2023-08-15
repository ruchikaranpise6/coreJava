package linkedlist;


/*Given a Linked List of integers, write a function to modify the linked list such that
all even numbers appear before all the odd numbers in the modified linked list.
Also, keep the order of even and odd numbers same.*/

public class SegregateEvenOddNodesLL {

    public static void main(String[] args) {
        SegregateEvenOddNodesLL ll = new SegregateEvenOddNodesLL();
        LinkedListImpl list1 = new LinkedListImpl();
        list1.insert(5);
        list1.insert(6);
        list1.insert(4);
        list1.insert(3);
        list1.insert(9);
        System.out.println();

        LinkedListImpl.Node n = list1.head;
        while (n.next != null)
            n = n.next;

        System.out.println("Linked List before sorting");
        list1.printList();

        ll.segregateEvenOdd(list1);
        System.out.println("\nLinked List after segregation");
        list1.printList();
    }

    void segregateEvenOdd(LinkedListImpl list1) {
        LinkedListImpl.Node current = list1.head;
        LinkedListImpl.Node prev = null;
        LinkedListImpl.Node end = list1.head;

        while (end.next != null) {
            end = end.next;
        }

        LinkedListImpl.Node new_end = end;

        if (current.data % 2 != 0 && current != end) {
            new_end.next = current;
            current = current.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        if (current.data % 2 == 0) {
            list1.head = current;
            while (current != end) {
                if (current.data % 2 == 0) {
                    prev = current;
                    current = current.next;
                } else {
                    prev.next = current.next;
                    current.next = null;
                    new_end.next = current;
                    new_end = current;
                    current = prev.next;
                }
            }
        } else
            prev = current;

        if (new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }
}
