package stack;

public class FixedSizeStack {

    final int Max = 100;
    int top;
    int[] a = new int[Max];

    FixedSizeStack() {
        top = -1;
    }

    boolean isEmpty() {
        return top < 0;
    }

    boolean push(int x) {
        if (top != Max) {
            a[++top] = x;
            return true;
        }
        return false;
    }

    int pop() {
        if (!isEmpty()) {
            int x = a[top--];
            return x;
        }
        return 0;
    }

    int peek(){
        if(!isEmpty()){
            return a[top];
        }
        return 0;
    }

    public static void main(String[] args) {
        FixedSizeStack s = new FixedSizeStack();
        System.out.println(s.push(1));
        System.out.println(s.push(2));
        System.out.println(s.top);

        System.out.println(s.pop());
        System.out.println(s.top);
        System.out.println(s.peek());

    }

}
