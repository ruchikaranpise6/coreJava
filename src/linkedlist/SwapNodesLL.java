package linkedlist;

//Swap nodes in a linked list without swapping data
public class SwapNodesLL {

    LinkedListImpl list;

    SwapNodesLL(LinkedListImpl list) {
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
        System.out.println("Original sorted linked list - ");
        ll.printList();

        SwapNodesLL swapNodesLL = new SwapNodesLL(ll);
        swapNodesLL.swapNodes(10, 7);
        System.out.println();
        System.out.println("List after swipe -");
        ll.printList();

    }

    void swapNodes(int x, int y) {
        if (x == y)
            return;

        //search for x
        LinkedListImpl.Node currentX = list.head;
        LinkedListImpl.Node prevX = null;
        while (currentX != null && currentX.data != x) {
            prevX = currentX;
            currentX = currentX.next;
        }

        //search for y
        LinkedListImpl.Node currentY = list.head;
        LinkedListImpl.Node prevY = null;
        while (currentY != null && currentY.data != y) {
            prevY = currentY;
            currentY = currentY.next;
        }

        if (currentX == null || currentY == null)
            return;

        //check if x is head
        if (prevX != null) {
            prevX.next = currentY;
        } else
            list.head = currentY;

        //check if y is head
        if (prevY != null) {
            prevY.next = currentX;
        } else
            list.head = currentX;

        //swap next pointer
        LinkedListImpl.Node temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;
    }
}
