package linkedlist;

public class PairSwapLL {

    LinkedListImpl list;

    PairSwapLL(LinkedListImpl list) {
        this.list = list;
    }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);

        PairSwapLL swapLL = new PairSwapLL(linkedList);
        System.out.println("Original data - ");
        linkedList.printList();

        swapLL.pairSwap();
        System.out.println();
        System.out.println("Swap list 1- ");
        linkedList.printList();

        swapLL.pairSwapRecursion(linkedList.head);
        System.out.println();
        System.out.println("Swap list 2- ");
        linkedList.printList();
    }

    void pairSwap() {
        LinkedListImpl.Node temp = list.head;

        while (temp != null && temp.next != null) {
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }

    }

    void pairSwapRecursion(LinkedListImpl.Node head) {
        while (head != null && head.next != null) {
            int k = head.data;
            head.data = head.next.data;
            head.next.data = k;
            pairSwapRecursion(head.next.next);
        }
    }
}
