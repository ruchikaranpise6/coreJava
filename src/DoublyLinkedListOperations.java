public class DoublyLinkedListOperations {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedListOperations dl = new DoublyLinkedListOperations();
        dl.append(0);
        dl.append(1);
        dl.append(2);
        dl.append(3);
        dl.append(4);
        dl.printDLL(dl.head);
    }

    //append new data at the end of the list

    void append(int data) {
        Node newNode = new Node(data);
        newNode.next = null; //this is going to be last node
        if (head == null) {
            head = newNode;
            head.prev = null;
            return;
        }

        Node last = head; // for iteration
        //travel till last node
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;
    }

    void printDLL(Node node) {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }

        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }
}
