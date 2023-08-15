package Queue;

public class QueueImplUsingArray {
    int front, rear, size, capacity;
    int[] array;

    public QueueImplUsingArray(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity - 1;
        array = new int[this.capacity];
    }

    boolean isFull() {
        return this.capacity == size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int x) {
        if (!isFull()) {
            rear = (rear + 1) % capacity;
            array[rear] = x;
            size = size + 1;
        }
    }

    int dequeue() {
        if (!isEmpty()) {
            int x = array[front];
            front = (front + 1) % capacity;
            size = size - 1;
            return x;
        }
        return -1;
    }

    public static void main(String[] args) {
        QueueImplUsingArray queue = new QueueImplUsingArray(15);
        System.out.println(queue.front);
        System.out.println(queue.rear);

        queue.enqueue(1);
        queue.enqueue(2);

        System.out.println(queue.front);
        System.out.println(queue.rear);

        queue.dequeue();

        System.out.println(queue.front);
        System.out.println(queue.rear);

        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(12);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(12);
        System.out.println(queue.front);
        System.out.println(queue.rear);

        queue.dequeue();
        System.out.println(queue.front);
        System.out.println(queue.rear);

        queue.enqueue(18);
        queue.enqueue(19);

    }
}
