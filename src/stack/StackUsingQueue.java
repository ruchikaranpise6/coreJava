package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    static class Stack {

        static Queue<Integer> q1 = new LinkedList();
        static Queue<Integer> q2 = new LinkedList();

        static void push(int x) {

            //insert new implement in Q2
            q2.add(x);

            //insert all data from Q1 to Q2.
            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }

            //swap Q's
            Queue temp = q1;
            q1 = q2;
            q2 = temp;
        }

        //actual data is in Q1
        static void pop() {

            if (q1.isEmpty()) {
                return;
            }
            q1.remove();
        }

        static int peek() {
            if (q1.isEmpty()) {
                return 0;
            }
            return q1.peek();
        }

        static int size() {
            return q1.size();
        }

    }

    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("current size: " + stack.size());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());

        System.out.println("current size: " + stack.size());

    }
}
