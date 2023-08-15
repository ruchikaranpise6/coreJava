package linkedlist;

public class MoveLastElementToFirst {
    LinkedListImpl list;

    MoveLastElementToFirst(LinkedListImpl list) {
        this.list = list;
    }

    public static void main(String[] args) {
        LinkedListImpl ll = new LinkedListImpl();
        ll.insert(1);
        ll.insert(2);
        ll.insert(10);
        ll.insert(8);
        ll.insert(7);
        ll.insert(4);
        System.out.println("Original linked list - ");
        ll.printList();

        MoveLastElementToFirst swapNodesLL = new MoveLastElementToFirst(ll);
        swapNodesLL.MoveLastElementToFirst(ll.head);
        System.out.println();
        System.out.println("List after movement -");
        ll.printList();
    }

    void MoveLastElementToFirst(LinkedListImpl.Node head){

        if(head == null)
            return;

        LinkedListImpl.Node temp = head;
        LinkedListImpl.Node prev = null;
        while(temp.next!= null){
            prev = temp;
            temp = temp.next;
        }

        if(temp!= null){
            prev.next = head;
            temp.next = head.next;
            head.next = null;
            list.head = temp;
        }

    }
}
