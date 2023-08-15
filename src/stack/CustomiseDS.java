package stack;

import java.util.ArrayList;

public class CustomiseDS {

    static class Pair {
        int minElement;
        int element;

        Pair(int minElement, int element) {
            this.minElement = minElement;
            this.element = element;
        }
    }

    int min;
    ArrayList<Pair> stack = new ArrayList<>();

    CustomiseDS() {
        min = Integer.MIN_VALUE;
    }

    void addElement(int x) {
        if (x < min || stack.size() == 0) {
            min = x;
        }
        Pair pair = new Pair(min, x);
        stack.add(pair);
    }

    int getLastElement() {
        if (!stack.isEmpty()) {
            return stack.get(stack.size() - 1).element;
        }
        return -1;
    }

    void removeLastElement() {
        if (!stack.isEmpty()) {
            if (stack.size() > 1) {
                min = stack.get(stack.size() - 2).minElement;
            } else {
                min = Integer.MIN_VALUE;
            }
            stack.remove(stack.size() - 1);
        }
    }

    int getMin() {
        if (!stack.isEmpty()) {
            return stack.get(stack.size() - 1).minElement;
        }
        return -1;
    }

    public static void main(String[] args) {
        CustomiseDS newStack = new CustomiseDS();
        newStack.addElement(5);
        newStack.addElement(7);
        newStack.addElement(3);
        System.out.println("min element :: " + newStack.getMin());
        newStack.removeLastElement();
        newStack.addElement(2);
        newStack.addElement(9);
        System.out.println("last element :: " + newStack.getLastElement());
        newStack.addElement(0);
        System.out.println("min element :: " + newStack.getMin());
        newStack.removeLastElement();
        newStack.addElement(11);
        System.out.println("min element :: " + newStack.getMin());
    }

}
