package linkedlist;

public class InteractionPointLL {

    public static void main(String[] args) {

        LinkedListImpl list1 = new LinkedListImpl();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);
        System.out.println("List 1 - ");
        list1.printList();

        LinkedListImpl list2 = new LinkedListImpl();
        list2.insert(5);
        list2.insert(6);
        list2.insert(4);
        list2.insert(3);
        list2.insert(9);
        System.out.println();
        System.out.println("List 2 - ");
        list2.printList();

        InteractionPointLL obj = new InteractionPointLL();
        System.out.println();
        System.out.println("Intersection point  (" + obj.getNode(list1.head, list2.head)+")");
    }

    int getNode(LinkedListImpl.Node head1, LinkedListImpl.Node head2) {
        int c1 = getCount(head1);
        int c2 = getCount(head2);

        if (c1 > c2) {
            return getIntesectionNode(c1 - c2, head1, head2);
        } else {
            return getIntesectionNode(c2 - c1, head2, head1);
        }
    }

    int getIntesectionNode(int diff, LinkedListImpl.Node head1, LinkedListImpl.Node head2) {

        LinkedListImpl.Node temp1 = head1;
        LinkedListImpl.Node temp2 = head2;

        for (int i = 0; i < diff; i++) {
            if (temp1 == null)
                return -1;
            temp1 = temp1.next;
        }

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                return temp1.data;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return -1;
    }

    int getCount(LinkedListImpl.Node head) {

        LinkedListImpl.Node temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
