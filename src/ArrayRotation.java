public class ArrayRotation {

    // rotate given array by n indexes
    public static void main(String[] args) {
        int[] given = new int[]{1, 3, 6, 8, 19, 30};
        int[] roatatedArray = rotateArray(given, 2);
        for (int element : roatatedArray) {
            System.out.println(element);
        }

        //Time complexity : O(n * d)
        System.out.println("==============");
        rotateLeft(given, 2);
        for (int element : given) {
            System.out.println(element);
        }

        System.out.println("==============");
        int[] rotateRight = new int[]{1, 3, 6, 8, 19, 30};
        rotateRight(rotateRight, 2);
        for (int element : rotateRight) {
            System.out.println(element);
        }
    }

    private static int[] rotateArray(int[] given, int n) {
        int[] roatatedArray = new int[given.length];
        int len = given.length;
        int rotatedArrayindex = n;
        int givenArrayIndex = 0;
        for (int element : given) {
            if (n < len && rotatedArrayindex < len) {
                roatatedArray[rotatedArrayindex] = element;
                rotatedArrayindex = rotatedArrayindex + 1;
                givenArrayIndex = givenArrayIndex + 1;
            } else {
                rotatedArrayindex = 0;
                roatatedArray[rotatedArrayindex] = element;
                rotatedArrayindex = rotatedArrayindex + 1;
            }
        }

        return roatatedArray;
    }

    private static void rotateLeft(int[] array, int rotateBy) {
        int size = array.length;
        for (int i = 0; i < rotateBy; i++)
            leftRotatebyOne(array, size);
    }

    private static void leftRotatebyOne(int[] array, int size) {
        int i, temp;
        temp = array[0];
        for (i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = temp;
    }

    private static void rotateRight(int[] array, int rotateBy) {
        int size = array.length;
        for (int i = 0; i < rotateBy; i++)
            rightRotatebyOne(array, size);
    }
//        int[] rotateRight = new int[]{1, 3, 6, 8, 19, 30};
    private static void rightRotatebyOne(int[] array, int size) {
        int i, temp;
        temp = array[size - 1];
        for (i = size - 2; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = temp;
    }
}
