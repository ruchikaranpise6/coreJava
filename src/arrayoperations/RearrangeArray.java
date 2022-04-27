package arrayoperations;

import java.util.Arrays;
import java.util.OptionalInt;

/*Rearrange an array such that arr[i] = i*/
public class RearrangeArray {

    public static void main(String[] args) {
        int[] given = new int[]{1, 3, 6, 8, 12, 9};

        int[] response = reArrangeArray(given);

        for (int i : response) {
            System.out.println(i);
        }
    }

    static int[] reArrangeArray(int[] given) {

        int[] response = new int[findMax(given).getAsInt()+1];
        for (int i = 0; i < response.length; i++) {
            OptionalInt ifPresent = findNumber(given, i);
            if (ifPresent.isPresent()) {
                response[i] = i;
            } else
                response[i] = -1;
        }
        return response;
    }

    static OptionalInt findNumber(int[] given, final int index) {
        return Arrays.stream(given).filter(number -> number == index).findAny();
    }

    static OptionalInt findMax(int[] given) {
        return Arrays.stream(given).max();
    }
}


