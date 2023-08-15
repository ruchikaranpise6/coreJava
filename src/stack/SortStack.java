package stack;

import java.util.Stack;

public class SortStack {

    static Stack<Integer> s1;

    public static void main(String[] args) {

        //using auxillary space
        s1 = new Stack();

        s1.push(1);
        s1.push(4);
        s1.push(2);
        s1.push(0);
        s1.push(30);

        sortStack(s1);

        //using single stack
        System.out.println("===Second Sorting====\n");
        s1 = new Stack();
        pushSortedElement(1);
        pushSortedElement(4);
        pushSortedElement(2);
        pushSortedElement(0);
        pushSortedElement(30);

        while (!s1.isEmpty()) {
            System.out.println(s1.pop());
        }
    }

    private static void sortStack(Stack<Integer> s1) {
        Stack<Integer> tempStack = new Stack();
        while (!s1.isEmpty()) {

            int poppedElement = s1.pop();

            while (!tempStack.isEmpty() && tempStack.peek() >= poppedElement) {
                s1.push(tempStack.pop());
            }

            tempStack.push(poppedElement);
        }

        while (!tempStack.isEmpty()) {
            System.out.println(tempStack.pop());
        }
    }

    static void pushSortedElement(int x) {

        if (s1.isEmpty()) {
            s1.push(x);
        } else if (s1.peek() > x) {
            int popped = s1.pop();
            pushSortedElement(x);
            s1.push(popped);
        } else {
            s1.push(x);
        }


    }
}
