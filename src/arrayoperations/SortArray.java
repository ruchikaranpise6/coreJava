package arrayoperations;

public class SortArray {

    public static void main(String[] args) {

        int[] arr = {4, 7, 8, 9, 1, 5};

        int length = arr.length;

        for (int i = 1; i < length; i++) {
            for (int j = i + 1; i < length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
