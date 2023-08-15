package stack;

/*
1) top[]: This is of size k and stores indexes of top elements in all stacks.

2) nextFreeSlot[]: This is of size n and stores indexes of next item for the items in array arr[].

Here arr[] is actual array that stores k stacks. Together with k stacks, a stack of free slots in arr[] is also maintained.

The top of this stack is stored in a variable ‘free’. All entries in top[] are initialized as -1 to indicate that all stacks are empty.

All entries next[i] are initialized as i+1 because all slots are free initially and pointing to next slot.

Top of free stack, ‘free’ is initialized as 0.

 */
public class KStackUsingSingleArray {

    static class KStack {

        int free;
        int k, n;
        int[] array;
        int[] nextFreeSlots;
        int[] top;

        KStack(int n, int k) {
            this.n = n;
            this.k = k;
            free = 0;

            nextFreeSlots = new int[n];
            top = new int[k];
            array = new int[n];

            for (int i = 0; i < n - 1; i++) {
                nextFreeSlots[i] = i + 1;
            }
            nextFreeSlots[n - 1] = -1; //to mark end

            for (int i = 0; i < k; i++) {
                top[i] = -1;
            }

        }

        boolean isFull() {
            return free == -1;
        }

        boolean isEmpty(int stackNumber) {
            return top[stackNumber] == -1;
        }

        void push(int item, int sn) {
            // Overflow check
            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }

            int i = free; // Store index of first free slot

            // Update index of free slot to index of next slot in free list
            free = nextFreeSlots[i];

            // Update next of top and then top for stack number 'sn'
            nextFreeSlots[i] = top[sn];
            top[sn] = i;

            // Put the item in array
            array[i] = item;
        }

        // To pop an element from stack number 'sn' where sn is from 0 to k-1
        int pop(int sn) {
            // Underflow check
            if (isEmpty(sn)) {
                System.out.println("Stack Underflow");
                return Integer.MAX_VALUE;
            }

            // Find index of top item in stack number 'sn'
            int i = top[sn];

            top[sn] = nextFreeSlots[i]; // Change top to store next of previous top

            // Attach the previous top to the beginning of free list
            nextFreeSlots[i] = free;
            free = i;

            // Return the previous top item
            return array[i];
        }

    }


    public static void main(String[] args) {
        // Let us create 3 stacks in an array of size 10
        int k = 3, n = 10;

        KStack ks = new KStack(k, n);

        ks.push(15, 2);
        ks.push(45, 2);

        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }

}
