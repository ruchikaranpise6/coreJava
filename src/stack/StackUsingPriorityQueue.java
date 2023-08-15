package stack;

import java.util.PriorityQueue;

public class StackUsingPriorityQueue {

    int priority;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //store count and new value,
    // compare counts with each other to sort the list according to priority.

    StackUsingPriorityQueue() {
        priority = 0;
    }

    void push(int x) {
        priority++;
        pq.offer(new int[]{priority, x});
    }

    public void pop() {
        if (pq.isEmpty()) {
            System.out.println("Underflow");
        }
        priority--;
        pq.poll();
    }

    public int peek() {
        if (pq.isEmpty()) {
            System.out.println("Underflow");
        }
        int x[] = pq.peek();
        return x[1];
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingPriorityQueue s = new StackUsingPriorityQueue();
        s.push(3);
        s.push(2);
        s.push(1);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}

