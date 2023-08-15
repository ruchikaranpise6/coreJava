package stack;

public class DynamicSizeStack {

    Node top;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    boolean isEmpty() {
        return top == null;
    }

    boolean push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            Node temp = top;
            top = newNode;
            newNode.next = temp;
        }
        return true;
    }

    int pop() {
        int popped = 0;
        if (!isEmpty()) {
            popped = top.data;
            top = top.next;
        }
        return popped;
    }

    int peek(){
        return top.data;
    }
    public static void main(String[] args) {

        DynamicSizeStack sll = new DynamicSizeStack();

        sll.push(10);
        sll.push(20);
        sll.push(30);
        System.out.println("Top element is " + sll.peek());

        System.out.println(sll.pop() + " popped from stack");

        System.out.println("Top element is " + sll.peek());

    }
}
