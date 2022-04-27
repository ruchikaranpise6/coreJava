package linkedlist;

public class LinkedListImpl {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /* Inserts a new Node at end of the list. */
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /* Inserts a new Node at front of the list. */
    void insertFromFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

}
