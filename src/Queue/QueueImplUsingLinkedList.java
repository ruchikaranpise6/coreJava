package Queue;

public class QueueImplUsingLinkedList {

    Qnode rear, front;

    public QueueImplUsingLinkedList() {
        this.rear = this.front = null;
    }

    static class Qnode {
        int key;
        Qnode next;

        Qnode(int key) {
            this.key = key;
            this.next = null;
        }
    }

    boolean isEmpty() {
        return this.front == null;
    }

    void enqueue(int x) {
        Qnode newNode = new Qnode(x);

        if (!isEmpty()) {
            rear.next = newNode;

        } else {
            front = newNode;
        }
        rear = newNode;
    }

    int dequeue() {
        int x = -1;
        if (!isEmpty()) {
            Qnode temp = front;
            x = front.key;
            front = front.next;
            temp.next = null;
        }
        return x;
    }

    void printQueue() {
        if (!isEmpty()) {
            Qnode temp = front;
            while (temp != null) {
                System.out.println(temp.key);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {

        QueueImplUsingLinkedList queue = new QueueImplUsingLinkedList();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(0);
        queue.enqueue(10);
        System.out.println("before Deletion");

        queue.printQueue();
        queue.dequeue();
        System.out.println("After Deletion");
        queue.printQueue();
    }
}
