package linkedlist;

public class IntersectionOfTwoSortedList {

    public static void main(String[] args) {

        LinkedListImpl list1 = new LinkedListImpl();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);
        System.out.println("List 1 - ");
        list1.printList();

        LinkedListImpl list2 = new LinkedListImpl();
        list2.insert(1);
        list2.insert(2);
        list2.insert(4);
        list2.insert(8);
        list2.insert(9);
        System.out.println();
        System.out.println("List 2 - ");
        list2.printList();

        IntersectionOfTwoSortedList obj = new IntersectionOfTwoSortedList();
        //obj.intersectionOfLists(list1, list2);
        obj.sortedIntersect(list1.head, list2.head);
    }

    void intersectionOfLists(LinkedListImpl list1, LinkedListImpl list2) {
        LinkedListImpl result = new LinkedListImpl();

        LinkedListImpl.Node temp1 = list1.head;

        while (temp1 != null) {
            LinkedListImpl.Node temp2 = list2.head;

            while (temp2 != null) {

                if (temp1.data == temp2.data) {
                    result.insert(temp1.data);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }

        //remove duplicates
        LinkedListImpl.Node temp = result.head;
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
        System.out.println();
        System.out.println("Intersection result of unsorted list- ");
        result.printList();
    }

    void sortedIntersect(LinkedListImpl.Node head1, LinkedListImpl.Node head2) {
        LinkedListImpl.Node p = head1;
        LinkedListImpl.Node q = head2;
        LinkedListImpl result = new LinkedListImpl();

        while (p != null && q != null) {

            if (p.data == q.data) {
                result.insert(p.data);
                p = p.next;
                q = q.next;
            } else if (p.data < q.data) {
                p = p.next;
            } else {
                q = q.next;
            }
        }

        System.out.println();
        System.out.println("Intersection result of sorted list- ");
        result.printList();
    }
}
