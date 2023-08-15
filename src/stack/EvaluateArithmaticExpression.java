package stack;

import java.util.Stack;

public class EvaluateArithmaticExpression {

    static int prec(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostFix(String input) {
        Stack<Character> stack = new Stack<>();

        char[] chars = input.toCharArray();
        String result = "";
        for (int i = 0; i <= input.length() - 1; i++) {

            char c = chars[i];

            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }
                stack.pop();

            } else {
                while (!stack.isEmpty() && prec(stack.peek()) >= prec(c)) {

                    result += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }

        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.peek();
            stack.pop();
        }


        return result;
    }

    static String evaluatePostFixExpression(String expression) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i <= expression.length() - 1; i++) {

            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(String.valueOf(c));
            } else if (isOperator(c)) {
                int op1 = Integer.valueOf(stack.peek());
                stack.pop();
                int op2 = Integer.valueOf(stack.peek());
                stack.pop();

                int res = performOperation(op1, op2, c);
                String result = String.valueOf(res);
                stack.push(result);
            }
        }

        return stack.peek();
    }

    static boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '/':
            case '*':
            case '^':
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String exp = "(2+4)*(4+6)";

        String postFix = infixToPostFix(exp);

        System.out.println(postFix);

        System.out.println(evaluatePostFixExpression(postFix));

    }

    public static int performOperation(int a, int b, char operator) {

        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '^':
                return a ^ b;
        }
        return 0;
    }

    static int evaluatePostfix(String exp) {
        // Create a stack
        Stack<Integer> stack = new Stack<>();

        // Scan all characters one by one
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the scanned character is an operand
            // (number here), push it to the stack.
            if (Character.isDigit(c))
                stack.push(c - '0');

                //  If the scanned character is an operator, pop
                //  two elements from stack apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

}
