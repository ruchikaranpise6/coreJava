package leetcode;

import java.util.Stack;

public class BracketStatement {

    public static void main(String[] args) {
        System.out.println(isValidBracket("]"));
    }

    private static boolean isValidBracket(String s) {
        Stack<Character> stack = new Stack<>();

        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {

            if (array[i] == ']') {
                if (!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }

            } else if (array[i] == ')') {

                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }

            } else if (array[i] == '}') {
                if (!stack.empty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(array[i]);
            }
        }

        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
