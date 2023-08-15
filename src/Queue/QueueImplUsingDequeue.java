package Queue;

public class QueueImplUsingDequeue {

    DequeNode front;
    DequeNode rear;
    int size;

    static class DequeNode {
        int key;
        DequeNode prev;
        DequeNode next;

        DequeNode(int key) {
            this.key = key;
            this.prev = this.next = null;
        }
    }

    QueueImplUsingDequeue() {
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void insert_at_end(int x) {
        DequeNode newNode = new DequeNode(x);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
        }
        rear = newNode;
        size++;
    }

    void insert_at_front(int x) {
        DequeNode newNode = new DequeNode(x);
        if (!isEmpty()) {
            front.prev = newNode;
            newNode.next = front;
        } else {
            rear = newNode;
        }
        front = newNode;
        size++;
    }

    void printQueue() {
        if (!isEmpty()) {
            DequeNode temp = front;
            while (temp != null) {
                System.out.println(temp.key);
                temp = temp.next;
            }
        }
    }

    int delete_from_end() {
        int key = -1;
        if (!isEmpty()) {
            key = rear.key;
            rear.prev.next = null;
            rear = rear.prev;
        }
        return key;
    }

    int delete_from_front() {
        int key = -1;
        if (!isEmpty()) {
            key = front.key;
            front.next.prev = null;
            front = front.next;
        }
        return key;
    }

    public static void main(String[] args) {
        QueueImplUsingDequeue queue = new QueueImplUsingDequeue();
        queue.insert_at_front(5);
        queue.insert_at_end(10);
        queue.insert_at_front(3);
        queue.insert_at_end(7);
        queue.insert_at_end(12);

        queue.printQueue();
        System.out.println("Deleted element from last - " + queue.delete_from_end());
        queue.printQueue();
        System.out.println("Deleted element from first - " + queue.delete_from_front());
        queue.printQueue();
    }
}
