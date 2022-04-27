package doublylinkedlist;

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
        dl.addNodeAtFront(7);
        dl.addNodeAfterGivenNode(dl.head, 8);
        dl.addNodeBeforeGivenNode(dl.head, 10);
        dl.deleteNode(dl.head);
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

    void addNodeAtFront(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = null;
            head.prev = null;
            return;
        }
        newNode.next = head;
        newNode.prev = null;
        head.prev = newNode;
        head = newNode;
    }

    void addNodeAfterGivenNode(Node prevNode, int data) {

        if (head == null)
            return;

        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    void addNodeBeforeGivenNode(Node nextNode, int data) {

        Node newNode = new Node(data);

        newNode.prev = nextNode.prev;
        nextNode.prev = newNode;
        newNode.next = nextNode;

        if (newNode.prev != null) {
            newNode.prev.next = newNode;
        } else
            head = newNode;
    }

    void deleteNode(Node nodePtr) {

        //if the first node
        if (nodePtr == head) {
            head = nodePtr.next;
            head.prev = null;
            return;
        }

        //if the last node
        if (nodePtr.next == null) {
            nodePtr.prev.next = null;
            return;
        }

        //if the middle node
        nodePtr.prev.next = nodePtr.next;
        nodePtr.next.prev = nodePtr.prev;
        return;
    }
}
