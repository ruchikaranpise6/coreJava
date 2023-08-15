package linkedlist;

public class QuickSortLL {

    public static void main(String[] args) {
        QuickSortLL ll = new QuickSortLL();
        LinkedListImpl list1 = new LinkedListImpl();
        list1.insert(5);
        list1.insert(6);
        list1.insert(4);
        list1.insert(3);
        list1.insert(9);
        System.out.println();

        LinkedListImpl.Node n = list1.head;
        while (n.next != null)
            n = n.next;

        System.out.println("Linked List before sorting");
        list1.printList();

        ll.sort(list1.head, n);

        System.out.println("\nLinked List after sorting");
        list1.printList();

    }

    void sort(LinkedListImpl.Node start, LinkedListImpl.Node end) {
        if (start == null || start == end || start == end.next)
            return;

        LinkedListImpl.Node pivot_prev = partionLast(start, end);
        sort(start, pivot_prev);
        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);

            // if pivot is in between of the list,
            // start from next of pivot,
            // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }

    private LinkedListImpl.Node partionLast(LinkedListImpl.Node start, LinkedListImpl.Node end) {
        if (start == end || start == null || end == null)
            return start;

        LinkedListImpl.Node pivot_prev = start;
        LinkedListImpl.Node current = start;
        int pivot = end.data;

        while (start != end) {
            if (start.data < pivot) {
                pivot_prev = current;
                int temp = current.data;
                current.data = start.data;
                start.data = temp;
                current = current.next;
            }
            start = start.next;
        }

        // swap the position of curr i.e.
        // next suitable index and pivot
        int temp = current.data;
        current.data = pivot;
        end.data = temp;

        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }
}
