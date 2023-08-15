package Queue;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();

    void enqueue(int x) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
    }

    int dequeue() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    boolean isEmpty() {
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        return false;
    }

    int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    void    printQueue(){

    }
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        queue.enqueue(1);
        queue.enqueue(8);
        queue.enqueue(10);


    }
}
