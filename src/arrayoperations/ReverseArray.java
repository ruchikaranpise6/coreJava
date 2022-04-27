package arrayoperations;

public class ReverseArray {


    public static void main(String[] args) {
        int[] given = new int[]{1, 3, 6, 8, 12, 9};

        int[] response = reverseArray(given);

        for (int i : response) {
            System.out.println(i);
        }
    }

    private static int[] reverseArray(int[] given) {

        int start = 0, end = given.length - 1;
        int[] response = new int[given.length];
        while (start != given.length) {
            //use temp variable instead of response to save memory
            response[start] = given[end];
            start++;
            end--;
        }
        return response;
    }
}
