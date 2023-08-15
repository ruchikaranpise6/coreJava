package stack;

import java.util.Stack;

public class ReverseStack {

    static Stack<Character> st = new Stack<>();

    static void insert_at_bottom(char x) {
        if (st.isEmpty())
            st.push(x);

        else {
            char a = st.peek();
            st.pop();
            System.out.println("Character popped in insert_at_bottom - " + a);

            System.out.println("insert_at_bottom called in insert_at_bottom - " + x);
            insert_at_bottom(x);

            System.out.println("Element pushed in stack in insert_at_bottom - " + a);
            st.push(a);
        }
    }

    static void reverse() {
        if (st.size() > 0) {

            char x = st.peek();
            st.pop();
            System.out.println("Character popped in reverse - " + x);
            reverse();
            System.out.println("insert_at_bottom called in reverse - " + x);
            insert_at_bottom(x);
        }
    }

    public static void main(String[] args) {

        // push elements into
        // the stack
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');

        System.out.println("Original Stack");

        System.out.println(st);

        // function to reverse
        // the stack
        reverse();

        System.out.println("Reversed Stack");

        System.out.println(st);
    }
}
