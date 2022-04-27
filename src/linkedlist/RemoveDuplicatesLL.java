package linkedlist;

import java.util.HashSet;

/*Write a function that takes a list sorted in non-decreasing order and deletes any duplicate nodes from the list.
The list should only be traversed once.
 */
public class RemoveDuplicatesLL {

    LinkedListImpl list;

    RemoveDuplicatesLL(LinkedListImpl list) {
        this.list = list;
    }


    public static void main(String[] args) {
        LinkedListImpl ll = new LinkedListImpl();
        ll.insertFromFront(100);
        ll.insertFromFront(100);
        ll.insertFromFront(22);
        ll.insertFromFront(22);
        ll.insertFromFront(4);
        ll.insertFromFront(4);
        System.out.println("Original sorted linked list - ");
        ll.printList();

        RemoveDuplicatesLL removeDuplicatesLL = new RemoveDuplicatesLL(ll);
        System.out.println();
        System.out.println("Duplicates removed from sorted linked list - ");
        removeDuplicatesLL.removeDuplicatesFromSortedList();
        ll.printList();

        //ll.head = removeDuplicatesFromSortedRecursive(ll.head);


        //remove from unsorted list
        ll.insertFromFront(1);
        ll.insertFromFront(100);
        ll.insertFromFront(22);
        ll.insertFromFront(22);
        ll.insertFromFront(4);
        ll.insertFromFront(9);
        ll.insertFromFront(22);
        ll.insertFromFront(100);

        System.out.println();
        System.out.println("Original unsorted linked list - ");
        ll.printList();

        System.out.println();
        System.out.println("Duplicates removed from unsorted linked list - ");
        removeDuplicatesLL.removeDuplicatesFromUnsortedList();
        ll.printList();
    }

    void removeDuplicatesFromSortedList() {
        LinkedListImpl.Node cursor = list.head;
        while (cursor != null) {

            LinkedListImpl.Node temp = cursor;
            while (temp != null && temp.data == cursor.data) {
                temp = temp.next;
            }
            cursor.next = temp;
            cursor = cursor.next;
        }
    }

    static LinkedListImpl.Node removeDuplicatesFromSortedRecursive(LinkedListImpl.Node head) {
        LinkedListImpl.Node toFree;

        if (head == null)
            return null;

        if (head.next != null) {

            if (head.data == head.next.data) {
                toFree = head.next;
                head.next = toFree.next;
                removeDuplicatesFromSortedRecursive(head);
            } else
                removeDuplicatesFromSortedRecursive(head.next);
        }
        return head;
    }

    void removeDuplicatesFromUnsortedList() {
        LinkedListImpl.Node temp = list.head;
        while (temp != null) {

            LinkedListImpl.Node nextNode = temp.next;
            LinkedListImpl.Node prevNode = temp;
            while (nextNode != null) {
                Boolean isDeleted = false;
                if (temp.data == nextNode.data) {
                    prevNode.next = nextNode.next;
                    nextNode = nextNode.next;
                    isDeleted = true;
                }

                if (!isDeleted) {
                    prevNode = nextNode;
                    nextNode = nextNode.next;
                }
            }
            temp = temp.next;
        }
    }

    /* Method 2: Function to remove duplicates from a
   unsorted linked list */
    static void removeDuplicate(LinkedListImpl.Node head) {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();

        /* Pick elements one by one */
        LinkedListImpl.Node current = head;
        LinkedListImpl.Node prev = null;
        while (current != null) {
            int curval = current.data;

            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }

}
