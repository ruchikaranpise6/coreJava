package leetcode;

import java.util.Arrays;

public class ValueWithIndex {

    public static void main(String[] args) {
        int[] array = new int[]{0, -1, -1, 3, 4, 1, 2, 2, 1, 5, 6};
        int[] response = new int[array.length];
        System.out.println("Size of input array: " + array.length);
        System.out.println("Size of output array: " + response.length);

        for (int i = 0; i < array.length; i++) {
            if (i == array[i]) {
                response[i] = array[i];
            } else if (contains(i, array)) {
                response[i] = i;
            } else response[i] = 0;
        }

        for (int i = 0; i < response.length; i++) {
            System.out.println(" " + response[i]);
        }
    }

    static boolean contains(int key, int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                return true;
            }
        }
        return false;
    }
}
