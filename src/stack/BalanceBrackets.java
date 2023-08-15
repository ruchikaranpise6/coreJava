package stack;

import java.util.Stack;

public class BalanceBrackets {

    static boolean usingStack(String input) {

        Stack<Character> stack = new Stack();

        char[] characterArray = input.toCharArray();

        for (int i = 0; i <= characterArray.length - 1; i++) {

            char c = characterArray[i];

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            char check;
            switch (c) {

                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[') {
                        return false;
                    }
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '{' || check == '(') {
                        return false;
                    }
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '[' || check == '(') {
                        return false;
                    }
                    break;
            }

        }
        return stack.isEmpty();
    }


    static boolean withoutUsingStack(String input) {
        int i = -1;

        char[] stack = new char[input.length()];

        char[] charArray = input.toCharArray();

        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                i++;
                stack[i] = c;
            } else {
                if (i >= 0
                        && ((stack[i] == '(' && c == ')')
                        || (stack[i] == '[' && c == ']')
                        || (stack[i] == '{' && c == '}'))) {
                    i--;
                } else
                    return false;
            }
        }

        return i == -1;
    }

    public static void main(String[] args) {
        String expr1 = "{()}[]";

        // Function call
        if (usingStack(expr1))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");

        String expr2 = "{()}[]]";

        if (withoutUsingStack(expr2))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");

    }

}
