package stack;

/*
Solution 1 -
The idea to implement two stacks is to divide the array into two halves and assign two halves to two stacks, i.e.,
use arr[0] to arr[n/2] for stack1, and arr[(n/2) + 1] to arr[n-1] for stack2
where arr[] is the array to be used to implement two stacks and size of array be n.

The problem in the above implementation is that as we reserve half of the array for a stack and another half for the another
stack. So, let if 1st half is full means first stack already have n/2 numbers of elements and 2nd half is not full means it
doesn’t have n/2 numbers of elements. So, if we look into the array, there are free spaces inside array(eg. in the next half)
but we cannot push elements for stack 1(because first half is reserved for stack 1 and it’s already full).
It means this implementation show stack overflow although the array is not full.
The solution for this answer is the below implementation.

Solution 2 -
The idea is to start two stacks from two extreme corners of arr[].

Implementation for second is below.

*/
public class TwoStacksSingleArray {

    int top1;
    int top2;
    int[] array;
    int size;

    TwoStacksSingleArray(int n) {
        array = new int[n];
        top1 = -1;
        size = n;
        top2 = size;
    }

    public void push1(int x) {
        if (top1 < top2 - 1) {
            top1++;
            array[top1] = x;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public void push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            array[top2] = x;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            int x = array[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack Underflow");
        }
        return 0;
    }

    public int pop2() {
        if (top2 < size) {
            int x = array[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack Underflow");
        }
        return 0;
    }

    public static void main(String[] args) {
        TwoStacksSingleArray stack = new TwoStacksSingleArray(8);
        stack.push1(5);
        stack.push2(10);
        stack.push2(15);
        stack.push1(11);
        stack.push2(7);
        System.out.println("Popped element from"
                + " stack1 is " + stack.pop1());
        stack.push2(40);
        System.out.println("Popped element from"
                + " stack2 is " + stack.pop2());
    }
}
