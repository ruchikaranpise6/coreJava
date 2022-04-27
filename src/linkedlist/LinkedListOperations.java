package linkedlist;

public class LinkedListOperations {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    void printLinkedList() {
        Node n = head;

        while (n != null) {
            System.out.println(n.data + " , ");
            n = n.next;
        }

    }

    public static void main(String[] args) {
        LinkedListOperations list = new LinkedListOperations();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        list.head = n1;
        list.head.next = n2;
        n2.next = n3;
        list.insertFrontNode(0);
        list.insertAfter(n2, 8);
        list.addNodeInEnd(9);
        list.deleteNode(0);
        list.deleteNode(8);
        list.deleteNode(9);
        list.deleteNodeByPosition(2);
        list.printLinkedList();
    }

    void insertFrontNode(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAfter(Node previous, int data) {
        Node newNode = new Node(data);
        newNode.next = previous.next;
        previous.next = newNode;
    }

    void addNodeInEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;

        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        return;
    }

    void deleteNode(int key) {
        Node temp = head;
        Node prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }
        prev.next = temp.next;
    }

    void deleteNodeByPosition(int position) {
        if (head == null)
            return;
        Node temp = head;
        if (position == 0) {
            head = temp.next;
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null && temp.next == null)
            return;

        Node next = temp.next.next;
        temp.next = next;
    }
}
