package stack;

import java.util.Arrays;
import java.util.Stack;

/*A stack is monotonically decreasing if It’s elements are in decreasing order from the bottom to the top of the stack.

so check if top of the stack is less than new value if yes then pop till top of the stack is greater than new value.

 */
public class MonotonicDecreasingStack {

    public static void decreasingStack(int[] input) {
        int length = input.length;
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && stack.peek() < input[i]) {
                stack.pop();
            }
            stack.push(input[i]);
        }

        int length2 = stack.size();
        int[] response = new int[length2];
        int j = length2 - 1;

        Arrays.fill(response, 0); //insert all zeros in response array

        while (!stack.empty()) {
            response[j] = stack.peek();
            stack.pop();
            j--;
        }

        // Displaying the original array
        System.out.print("The Array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();

        // Displaying Monotonic increasing stack
        System.out.print("The Stack: ");
        for (int i = 0; i < length2; i++) {
            System.out.print(response[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 4, 5, 3, 12, 10};
        decreasingStack(input);
    }
}
