package stack;


import java.util.Stack;

/* Use two stacks: one to store actual stack elements and the other as an auxiliary stack to store minimum values.
The idea is to do push() and pop() operations in such a way that the top of the auxiliary stack is always the minimum.
Let us see how push() and pop() operations work.
 */
public class GetMin extends Stack<Integer> {

    Stack<Integer> auxiliary = new Stack();

    public void push(int item) {
        if (isEmpty()) {
            super.push(item);
            auxiliary.push(item);
        } else {
            if (auxiliary.peek() < item) {
                auxiliary.push(auxiliary.peek());
            } else {
                auxiliary.push(item);
            }
        }
    }

    public Integer pop() {
        int item = super.pop();
        auxiliary.pop();
        return item;
    }

    public int getMin(){
        return auxiliary.peek();
    }

    public static void main(String[] args) {
        GetMin stack = new GetMin();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.getMin());
        stack.push(5);
        System.out.println(stack.getMin());
    }
}
